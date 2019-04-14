import Vue from 'vue';
import App from './App.vue';
import axios from 'axios';
import qs from 'qs';
import router from './routers';
import ElementUI from 'element-ui';
import VDistpicker from 'v-distpicker'
// filters
import VueQuillEditor from 'vue-quill-editor'
import { dateFmt, } from './filters/fmt.js';

// require styles
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'

Vue.use(VueQuillEditor, /* { default global options } */)

Vue.use(ElementUI);
Vue.component('v-distpicker', VDistpicker)
// === AXIOS
axios.defaults.transformRequest = [data => qs.stringify(data)];
Vue.prototype.$http = axios;

// 注册全局过滤器
Vue.filter('dateFmt', dateFmt);

//init
var app = new Vue({
  router: router,
  render: h => h(App)
}).$mount('#app');