import Vue from 'vue';
import VueRouter from 'vue-router';
import admin from './router-admin.js';
import employer from './router-employer.js';
import graduate from './router-graduate.js';
import register from './router-register.js';

// 路由组件
Vue.use(VueRouter);

// init Router
let routes = [
    ...register,
    ...admin,
    ...employer,
    ...graduate,
    {
	    path: '/',
	    redirect: '/home'
	},
    {
      	path: '/home',
    	component: () => import ('../views/home/home.vue')
  	},
  	{
	    path: '*',
	    component: () => import (/* webpackChunkName: 'system' */ '../views/page404.vue')
  	},
    {
        path: '/login',
        component: () => import ('../Login.vue')
    },
];

//if (process.env.NODE_ENV === 'dev') {
//  routes = routes.concat(demo);
//}

const router = new VueRouter({
  routes: routes
});

router.beforeEach((to, from, next) => {
  document.documentElement.scrollTop = 0;
  document.body.scrollTop = 0;
  next();
})

export default router;