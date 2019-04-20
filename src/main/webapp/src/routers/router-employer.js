const BASE_URL = '/employer';
export default[
	{	//公司信息
		path:`${BASE_URL}/companyInfo`,
		component: () => import('@/views/employer/companyInfo/companyInfo.vue')
	},
	{	//修改公司信息
		path:`${BASE_URL}/changeCompanyInfo`,
		component: () => import('@/views/employer/companyInfo/changeCompanyInfo.vue')
	},
	{	//建立搜索
		path:`${BASE_URL}/searchResume`,
		component: () => import('@/views/employer/queryResume/searchResume.vue')
	},
	{	//我的招聘
		path:`${BASE_URL}/myRecruitment`,
		component: () => import('@/views/employer/recruitment/myRecruitment.vue')
	},
	{	//收到的简历
		path:`${BASE_URL}/resumeReceive`,
		component: () => import('@/views/employer/resumeReceive/resumeReceive.vue')
	},
]
