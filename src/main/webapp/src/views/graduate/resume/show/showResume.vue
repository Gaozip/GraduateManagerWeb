<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="简历" width="55%" append-to-body >
	    <div class="dialog-edit">
	    	<dl>
	    		<dt>基本信息</dt>
	    		<div class="box">
	    			<div class="box1">
	    				<span class="lab">【姓名】{{graduateInfo.name}}</span>
	    				<br />
	    				<span class="lab">【出生年月】{{  graduateInfo.birthday | dateFmt('YYYY-MM-DD') }}</span>
	    				<br />
	    				<span class="lab">【电话】{{graduateInfo.tel}}</span>
	    				<br />
	    				<span class="lab">【学历】{{graduateInfo.education}}</span>
		    		</div>
		    		<div class="box2">
		    			<span class="lab">【性别】:{{graduateInfo.sex}}</span>
		    			<br />
		    			<span class="lab">【政治面貌】{{graduateInfo.politicalStatus}}</span>
		    			<br />
		    			<span class="lab">【邮箱】{{graduateInfo.email}}</span>
		    			<br />
		    			<span class="lab">【现居地】{{graduateInfo.province + graduateInfo.city}}</span>
		    		</div>
	    		</div>
	    		<br />
	    		<hr />
	    		<dt>教育经历</dt>
	    		<div>
	    			<span class="lab">{{graduateInfo.inDate | dateFmt('YYYY') }}.09-{{gradYear}}.06</span>
		    		<span class="lab">{{graduateInfo.gradCollege}}</span>
		    		<span class="lab">{{graduateInfo.dept}}</span>
		    		<span class="lab">{{graduateInfo.speciality}}({{graduateInfo.education}})</span>
	    		</div>
	    		<br />
	    		<hr />
	    		<dt>求职意向({{resumeInfo.jobType}})</dt>
	    		<div class="box">
	    			<div class="box1">
	    				<span class="lab">【从事行业】{{resumeInfo.expertIndustry}}</span>
	    				<br />
	    				<span class="lab">【工作地点】{{resumeInfo.province + resumeInfo.city}}</span>
	    				<br />
	    				<span class="lab">【月薪】{{resumeInfo.expertSalary}}</span>
	    			</div>
	    			<div class="box2">
	    				<span class="lab">【从事职业】{{resumeInfo.expertJobIntension}}</span>
	    				<br />
	    				<span class="lab">【求职状态】{{resumeInfo.jobStatus}}</span>
	    			</div>
	    		</div>
	    		<br />
	    		<hr />
	    		<dt>专业技能</dt>
	    		<div>
	    			<span class="lab">{{resumeInfo.professionalAbility}}</span>
	    		</div>
	    		<br />
	    		<hr />
	    		<dt>证书</dt>
	    		<div>
	    			<span class="lab">{{resumeInfo.certificate}}</span>
	    		</div>
	    		<br />
	    		<hr />
	    		<dt>工作经验</dt>
	    		<div>
					<ol>
	    			<li v-for="item in workList">
				    	<fieldset>
				    		<legend>公司名称:&nbsp;&nbsp;&nbsp;{{item.companyName}}</legend>
				    		<dl>
				    		
					      		<dt>所属行业:</dt>
					      		<span class="lab">{{item.industry}}</span>
					      		
					      		<dt>职位名称:</dt>
					      		<span class="lab">{{item.jobIntension}}</span>
					      		
					      		<dt>工作性质:</dt>
					      		<span class="lab">{{item.jobType}}</span>
					      		
					      		<dt>在职时间:</dt>
					      		<span class="lab">{{item.workDate}}</span>
					      		
					      		<dt>税前薪资:</dt>
					      		<span class="lab">{{item.monthSalary}}</span>
					      		
					      		<dt>工作描述:</dt>
					      		<span class="lab">{{item.jobDescription}}</span>
				      		</dl>
				    	</fieldset>
				    	<br />
				    	<br />
				    </li>
			  	</ol>
	    		</div>
	    		<dt>项目经验</dt>
	    		<ol>
				    <li v-for="item in projectList">
				    	<fieldset>
				    		<legend>{{item.projectName}}</legend>
				    		<dl>
				    			<dt>项目时间:</dt>
				    			<span class="lab">{{item.projectDate}}</span>
				    		
					      		<dt>项目描述:</dt>
					      		<span class="lab">{{item.projectDescription}}</span>
					      		
					      		<dt>个人职责:</dt>
					      		<span class="lab">{{item.personalResponsibility}}</span>
					      		
					      		<dt>所属公司:</dt>
					      		<span class="lab">{{item.companyName}}</span>
				      		</dl>
				    	</fieldset>
				    	<br />
				    	<br />
				    </li>
				</ol>
	    	</dl>
	    </div>
		<!-- 最后是按钮，（不要放在 form 里面） -->
		<div class="dialog-edit__btnGroup" slot="footer">
			<el-button type="primary"  v-show="type == 'employer'" @click="doUpdate">通过</el-button>
			<el-button @click="dialogVisible = false">关闭</el-button>
		</div>
	</el-dialog>
</template>

<script>
import * as tools from '@/assets/tools';	
import * as GERINFO_API from '@/api/employer/gerInfo.js'
export default{
	data(){
		return{
			dialogVisible:false,
			graduateInfo:'',
			resumeInfo:'',
			projectList:[],
			workList:[],
			gradYear:'',
			type:'',
			gerId:'',
		}
	},
	methods:{
		show(scope,gerId,type){
			if(type == 'employer'){
				this.type = type;
				this.gerId = gerId;
			}
			this.dialogVisible = true;
			this.graduateInfo = scope.graduateInfo;
			this.resumeInfo = scope;
			this.projectList = scope.projectList;
			this.workList = scope.workList;
			this.gradYear = parseInt(tools.transformTime(scope.graduateInfo.inDate,'YYYY')) + 4; 
		},
		doUpdate(){
			let param = {
				pkGerId: this.gerId,
			};
			this.$confirm('确认通过？').then(_ => {
				GERINFO_API.api(GERINFO_API.URL_DO_UPDATE,param).then(data =>{
					this.$message.success('设置成功!');
					this.dialogVisible = false;
				});
			}).catch(_ => {});
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