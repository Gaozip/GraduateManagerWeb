<template>
  <div class="left-menu">
    <el-tree
    	:props="options"
      :data="routerList"
      :highlight-current="false"
      :default-expand-all="true"
      @node-click="handleNodeClick">
    </el-tree>
  </div>
</template>

<script>
import * as AXIOS from '@API_PATH/axios.js';
const GRADUATE_ROLE = 1;
const EMPLOYER_ROLE = 2;
const ADMIN_ROLE = 0;

export default {
  data() {
    return {
      routerList:[],
      graduateRouterList: [
       	{label:'首页',to:'/home',name:'首页'},
	    	{label:'资料管理',children:[{label:'基本资料',to:'/graduate/basicInfo',name:'基本资料'},{label:'修改资料',to:'/graduate/changeBasicInfo',name:'修改资料'}]},
	    	{label:'信息咨询',children:[{label:'企业信息查询',to:'/graduate/companyInfo',name:'企业信息查询'},{label:'招聘信息查询',to:'/graduate/recruitmentInfo',name:'招聘信息查询'},{label:'简历投递结果查询',to:'/graduate/resultInfo',name:'简历投递结果查询'},]},
	    	{label:'简历管理',children:[{label:'我的简历',to:'/graduate/myResume',name:'我的简历'},{label:'上传本地简历',to:'/graduate/uploadResume',name:'上传本地简历'}]},
    	],
	    employerRouterList:[
	    	{label:'首页',to:'/home',name:'首页'},
	   		{label:'资料管理',children:[{label:'公司信息',to:'/employer/companyInfo',name:'公司信息'},{label:'修改公司信息',to:'/employer/changeCompanyInfo',name:'修改公司信息'}]},
	   		{label:'信息咨询',children:[{label:'简历搜索',to:'/employer/searchResume',name:'简历搜索'},{label:'收到的简历',to:'/employer/resumeReceive',name:'收到的简历'}]},
	   		{label:'招聘管理',children:[{label:'我的招聘',to:'/employer/myRecruitment',name:'我的招聘'}]},
	    ],
	    adminRouterList:[
	    	{label:'首页',to:'/home'},
            {label:'首页管理',children:[{label:'公告管理',to:'/admin/article',name:'公告管理'},{label:'走马灯图片管理',to:'/admin/carousel',name:'走马灯图片管理'}]},
            {label:'就业统计',children:[{label:'就业率',to:'/admin/jobRate',name:'就业率'},{label:'就业情况',to:'/admin/studentInfo',name:'就业情况'},]},
            {label:'用户管理',children:[{label:'用户管理',to:'/admin/user',name:'用户管理'},]},
            {label:'字典管理',children:[{label:'字典分类',to:'/admin/dict',name:'字典分类'},{label:'字典元素',to:'/admin/dictItem',name:'字典元素'},]},
	    ],
	    options: {
	      label: 'label',
	      children: 'children',
	    },
  	}
	},
	mounted(){
		this.getUserRole();
	},
	methods: {
	  handleNodeClick(data) {
	    if (data.to) {
	      this.$emit('menu-click', data);
	      //this.$router.push(data.to);
	    }
	  },
	  getMenu(){
	//        AXIOS.api('/user/getMenu', {}).then(data => {
	//          this.routerList = this.graduateRouterList;
	//        }, () => {
	//          this.routerList = [];
	//        });
	  },
	  getUserRole(){
	  	AXIOS.api('/user/getUserRole',{}).then(data =>{
	  		this.routerList = [];
	  		if(ADMIN_ROLE === data.datas){
	  			this.routerList = this.adminRouterList;
	  		}else if(EMPLOYER_ROLE === data.datas){
	  			this.routerList = this.employerRouterList;
	  		}else if(GRADUATE_ROLE === data.datas){
	  			this.routerList = this.graduateRouterList;
	  		}
	  	});
	  },
  }
};
</script>

<style scoped>
</style>