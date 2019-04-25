<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="招聘信息" width="55%" append-to-body >
	    <div class="dialog-edit">
	    	<dl>
	    		<dt>基本信息</dt>
	    		<div class="box">
	    			<div class="box1">
	    				<span class="lab">【招收职位】{{tableData.position}}({{tableData.jobNature}})</span>
	    				<br />
	    				<span class="lab">【工作地点】{{tableData.province+tableData.city}}</span>
	    				<br />
	    				<span class="lab">【学历要求】{{tableData.education}}</span>
		    		</div>
		    		<div class="box2">
		    			<span class="lab">【薪资】{{tableData.monthSalary}}</span>
		    			<br />
		    			<span class="lab">【招收人数】{{tableData.recruitNum}}</span>
		    			<br />
		    			<span class="lab">【工作经验】{{tableData.workExperience}}</span>
		    		</div>
	    		</div>
	    		<br />
	    		<dt>工作内容</dt>
	    		<div>
	    			<span class="lab">{{tableData.jobContent}}</span>
	    		</div>
	    		<dt>任职要求</dt>
	    		<div>
	    			<span class="lab">{{tableData.qualification}}</span>
	    		</div>
	    		<dt>公司介绍</dt>
				<div class="box">
					<div class="box1">
						<span class="lab">【公司名称】{{employerInfo.companyName}}</span>
						<br />
						<span class="lab">【成立时间】{{employerInfo.registerDate | dateFmt('YYYY-MM-DD') }}</span>
						<br />
						<span class="lab">【所属行业】{{employerInfo.industry}}</span>
					</div>
					<div class="box2">
						<span class="lab">【组织机构代码】{{employerInfo.organizationCode}}</span>
						<br />
						<span class="lab">【注册资本】{{employerInfo.registerCapital}}万</span>
						<br />
						<span class="lab">【所在地】{{employerInfo.province + employerInfo.city}}</span>
					</div>
				</div>
				<dt>简介</dt>
	    		<div>
	    			<span class="lab">{{employerInfo.companyProfile}}</span>
	    		</div>
				<dt>经营范围</dt>
				<div>
					<span class="lab">{{employerInfo.scopeOfBusiness}}</span>
				</div>
	    	</dl>
	    </div>
		<!-- 最后是按钮，（不要放在 form 里面） -->
		<div class="dialog-edit__btnGroup" slot="footer">
			<el-button type="primary" @click="btnClick" v-show="this.userType == 'graduate'">投递简历</el-button>
			<el-button @click="dialogVisible = false">关闭</el-button>
		</div>
		<el-dialog title="选择要投递的简历" :visible.sync="innerVisible" append-to-body width="30%">
			<el-form :inline="true" :model="form" ref="formName">
				<el-form-item label="请选择要投递的简历编号">
					<el-select v-model="form.pkResumeId">
						<el-option v-for="item in resumeIdList" :label="item.value" :value="item.value"></el-option>
					</el-select>
				</el-form-item>
			</el-form>
			<!-- 最后是按钮，（不要放在 form 里面） -->
			<div class="dialog-edit__btnGroup" slot="footer">
				<el-button type="primary" @click="sendRecruitment">确认投递</el-button>
				<el-button @click="innerVisible = false">关闭</el-button>
			</div>
		</el-dialog>
	</el-dialog>
</template>

<script>
import * as RECRUITMENT_API from '@/api/employer/recruitment.js';
import * as GERINFO_API from '@/api/employer/gerInfo.js'
export default{
	data(){
		return{
			dialogVisible:false,
			innerVisible:false,
			tableData:[],
			employerInfo:'',
			userType:'',//查看人类型
			form:{
				pkResumeId:'',	
			},
			resumeIdList:[],
		}
	},
	watch:{
		dialogVisible(value) {
			if (!value) {
				this.beforeClose();
			}
		},
		innerVisible(value) {
			if (!value) {
				this.beforeCloseInnerTab();
			}
		},
	},
	mounted(){
		this.fetchResumeId();	
	},
	methods:{
		show(scope,type){
			this.tableData = JSON.parse(JSON.stringify(scope));
			this.employerInfo = JSON.parse(JSON.stringify(scope.employerInfo));
			if(type  == 'graduate'){
				this.userType = type;
			}
			this.dialogVisible = true;
		},
		btnClick(){	//投递简历
			this.innerVisible = true;
		},
		beforeClose(){
			this.tableData = [];
			this.employerInfo = [];
			this.userType = '';
			// 推送关闭消息
			this.$emit('closed');
		},
		beforeCloseInnerTab(){
			this.form = {};	
		},
		fetchResumeId(){
			RECRUITMENT_API.api(RECRUITMENT_API.URL_QUERY_ALL_RESUME_ID_BY_USER_ID,{}).then(data =>{
				data.datas.forEach(item =>{
					this.resumeIdList.push({value:item});
				});
			});
		},
		sendRecruitment(){
			let param = {
				fkResumeId: this.form.pkResumeId,
				fkRecruitmentId: this.tableData.pkRecruitmentId,
				fkEmployerId: this.tableData.fkUserId,
			};
			GERINFO_API.api(GERINFO_API.URL_DO_SAVE,param).then(data =>{
				this.$message.success('简历投递成功!');
				this.innerVisible = false;
			});
		},
	},
}
</script>

<style scoped>
dt {
    margin: 8px 0;
    padding-left: 14px;
    font-size: 14px;
    color: #333;
    border-left: 4px solid #108cee;
    display: block;
    margin-top: 15px;
}
dl{
	padding:15px;
}
.lab{
	padding-left: 40px;
}
.box{
	display: flex;
	line-height:33px;
}
.box1,.box2{
	flex: 2;
	font-size: 14px;
}
.box1{
	padding-left: 5px;
}
</style>