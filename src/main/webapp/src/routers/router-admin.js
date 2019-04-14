const BASE_URL = '/admin';
export default[
	{	//用户管理
		path:`${BASE_URL}/user`,
		component: () => import('@/views/admin/user/user.vue')
	},
	{	//公告管理
		path:`${BASE_URL}/article`,
		component: () => import('@/views/admin/article/article.vue')
	},
	{	//就业统计
		path:`${BASE_URL}/jobRate`,
		component: () => import('@/views/admin/jobRate/jobRate.vue')
	},
]