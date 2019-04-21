const BASE_URL = '/admin';
export default[
	{	//用户管理
		path:`${BASE_URL}/user`,
		component: () => import('@/views/admin/user/user.vue')
	},
	{	//公告管理
		path:`${BASE_URL}/article`,
		component: () => import('@/views/admin/home/article/article.vue')
	},
	{	//走马灯管理
		path:`${BASE_URL}/carousel`,
		component: () => import('@/views/admin/home/carousel/carousel.vue')
	},
	{	//就业率
		path:`${BASE_URL}/jobRate`,
		component: () => import('@/views/admin/jobRate/jobRate.vue')
	},
	{	//就业情况
		path:`${BASE_URL}/studentInfo`,
		component: () => import('@/views/admin/jobRate/studentInfo.vue')	
	},
	{	//字典分类
		path:`${BASE_URL}/dict`,
		component: () => import('@/views/admin/dict/dict/dict.vue')
	},
	{	//字典元素
		path:`${BASE_URL}/dictItem`,
		component: () => import('@/views/admin/dict/dictItem/dictItem.vue')
	},
]