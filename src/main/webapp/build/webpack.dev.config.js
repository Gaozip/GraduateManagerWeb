/**
 * 开发模式
 */

var path = require('path');
var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');


module.exports = {
  // 输入
  // 入口
  entry: {
    main: path.join(__dirname, '../src/main'),
    vendors: ['vue', 'vue-router', 'axios', 'moment', 'element-ui'],
    login: path.join(__dirname, '../src/login'),
  },
  // 输出
  output: {
    path: path.join(__dirname, '../../../../WebContent/static/js/'),
    filename: '[name].js',
    chunkFilename: '[name].chunk.js',
    publicPath: './js/',
  },
  // 加载器
  module: {
    loaders: [{
        test: /\.json$/,
        loader: 'json-loader',
      }, {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'babel-loader?cacheDirectory=true',
      }, {
        test: /\.css$/,
        use: [{
            loader: 'style-loader',
          },
          {
            loader: 'css-loader',
            options: {
              importLoaders: 1,
            }
          },
          {
            loader: "postcss-loader",
            options: { // 如果没有options这个选项将会报错 No PostCSS Config found
              plugins: (loader) => [
                require('autoprefixer')(), //CSS浏览器兼容
              ]
            }
          }
        ]
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader',
      }, {
        test: /\.(scss|sass)$/,
        loader: 'style-loader!css-loader!sass-loader',
      },
      {
        test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
        loader: 'url-loader?limit=10000'
      },
      {
        test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
        loader: "url-loader?limit=10000&minetype=application/font-woff"
      },
      {
        test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
        loader: "file-loader"
      }
    ],
  },
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js',
      '@API_PATH': path.join(__dirname, '../src/api'),
      '@AXIOS_PATH': path.join(__dirname, '../src/axios'),
      '@pack': '/WebContent',
      '@': path.join(__dirname, '../src'),
    },
  },
  plugins: [
    new webpack.ContextReplacementPlugin(/moment[\/\\]locale$/, /zh-cn/),
    new webpack.DefinePlugin({
      'process.env.NODE_ENV': '"dev"',
      'ctxPath': JSON.stringify("/managersystem"), // 项目名称
    }),
    // new ExtractTextPlugin({ filename: '[name].css', allChunks: true, resolve: ['modules'] }), // 提取CSS
    new webpack.optimize.CommonsChunkPlugin({ name: 'vendors', filename: 'vendors.js' }), // 提取第三方库
    new HtmlWebpackPlugin({
      ctxPath: '${ctxPath}/',
      realName: '${realName}',
      userType: '${userType}',
      template: __dirname + "/../template.html",
      filename: path.join(__dirname, '../../../../WebContent/WEB-INF/views/index.html'),
      hash: true,
      chunks: ['main', 'vendors']
    }),
    new HtmlWebpackPlugin({
        ctxPath: '${ctxPath}/',
        verityFlag: '${verityFlag}',
        autoLoginFlag: '${autoLoginFlag}',
        template: __dirname + "/../template-login.html",
        filename: path.join(__dirname, '../../../../WebContent/WEB-INF/views/login.html'),
        hash: true,
        chunks: ['login', 'vendors']
    }),
  ]
}