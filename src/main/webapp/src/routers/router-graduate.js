const BASE_URL = '/graduate';
export default[
	{	//毕业生基本信息
		path:`${BASE_URL}/basicInfo`,
		component: () => import('@/views/graduate/information/basicInfo.vue')
	},
	{	//毕业生就业信息
		path:`${BASE_URL}/changeBasicInfo`,
		component: () => import('@/views/graduate/information/changeBasicInfo.vue')
	},
	{	//企业信息查询
		path:`${BASE_URL}/companyInfo`,
		component: () => import('@/views/graduate/searchInfo/companyInfo.vue')
	},
	{	//招聘信息查询
		path:`${BASE_URL}/recruitmentInfo`,
		component: () => import('@/views/graduate/searchInfo/recruitmentInfo.vue')
	},
	{	//简历投递结果查询
		path:`${BASE_URL}/resultInfo`,
		component: () => import('@/views/graduate/searchInfo/resultInfo.vue')
	},
	{	//毕业生简历
		path:`${BASE_URL}/myResume`,
		component: () => import('@/views/graduate/resume/myResume.vue')
	},
	{	//上传本地简历
		path:`${BASE_URL}/uploadResume`,
		component: () => import('@/views/graduate/resume/uploadResume.vue')
	}
]