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
	{	//服务热线管理
		path:`${BASE_URL}/hotLineInfo`,
		component: () => import('@/views/admin/home/hotLine/hotLine.vue')
	},
	{	//就业统计
		path:`${BASE_URL}/jobRate`,
		component: () => import('@/views/admin/jobRate/jobRate.vue')
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