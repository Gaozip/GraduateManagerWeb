/*
* @Author: Book
* @Date:   2018-06-26 09:53:07
* @Last Modified by:   Book
* @Last Modified time: 2018-06-26 10:40:52
*/
import Vue from 'vue';
import Login from './Login.vue';
import axios from 'axios';
import qs from 'qs';
import ElementUI from 'element-ui';

Vue.use(ElementUI);

// === AXIOS
axios.defaults.transformRequest = [data => qs.stringify(data)];
Vue.prototype.$http = axios;

//init
let app = new Vue({
  render: h => h(Login)
}).$mount('#app');