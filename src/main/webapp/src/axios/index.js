import axios from 'axios';
import qs from 'qs';
import { Message as message } from 'element-ui';


// const BASE_URL = process.env.NODE_ENV === 'dev' ? 'https://easy-mock.com/mock/5b14e49e647ea43344eecca1/' : '/api/';


// 创建axios实例
const service = axios.create({
  baseURL: ctxPath, // api的base_url
  // timeout: 5000, // 请求超时时间
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
  },
  transformRequest: [data => qs.stringify(data)],
})


//POST传参序列化
// service.interceptors.request.use((config) => {
//   if (config.method === 'post') {
//     config.data = qs.stringify(config.data);
//   }
//   return config;
// }, (error) => {
//   console.log(error) // for debug
//   Promise.reject(error)
// });

// respone拦截器
service.interceptors.response.use(
  response => {
    if(!response.data.rs && response.data.msg == 'NOT_LOGIN_ERROR') {   // 未登录，跳转到登录页
        window.location.href = ctxPath + "/";
    } else {
      return response;
    }
  },
  error => {
    message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service