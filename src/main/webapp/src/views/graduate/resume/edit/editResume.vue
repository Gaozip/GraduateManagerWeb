<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="修改简历" width="60%" append-to-body >
	    <div class="dialog-edit">
	      	<!-- 添加了校验规则 -->
	      	<el-form :inline="true" :model="form" ref="formName" :rules="rules" label-width="150px">
              	<div class="box">
              		<dl>
              			<dt>求职意向</dt>
	              		<el-form-item label="期望工作性质:" prop="jobType">
		              		<el-radio-group v-model="form.jobType">
		              			<el-radio-button label="兼职"></el-radio-button>
							    <el-radio-button label="实习生"></el-radio-button>
							    <el-radio-button label="正式员工"></el-radio-button>
		              		</el-radio-group>
		              	</el-form-item>
		              	<el-form-item label="期望从事行业:" prop="expertIndustry">
							<el-select v-model="form.expertIndustry" placeholder="请选择">
								<el-option value="互联网/电子商务"></el-option>
								<el-option value="计算机软件"></el-option>
								<el-option value="IT服务(系统/数据/维护)"></el-option>
								<el-option value="电子技术/半导体/集成电路"></el-option>
								<el-option value="计算机硬件"></el-option>
								<el-option value="通信/电信/网络设备"></el-option>
								<el-option value="通信/电信运营、增值服务"></el-option>
								<el-option value="网络游戏"></el-option>
								<el-option value="基金/证券/期贷/投资"></el-option>
								<el-option value="保险"></el-option>
								<el-option value="IT|通信|电子|互联网"></el-option>
								<el-option value="银行"></el-option>
								<el-option value="金融业"></el-option>
								<el-option value="信托/担保/拍卖/典当"></el-option>
								<el-option value="房地产|建筑业"></el-option>
								<el-option value="房地产/建筑/建材/工程"></el-option>
								<el-option value="商业服务"></el-option>
								<el-option value="家居/室内设计/装饰装潢"></el-option>
								<el-option value="贸易|批发|零售|租赁业"></el-option>
								<el-option value="物业管理/商业中心"></el-option>
								<el-option value="文体教育|工艺美术"></el-option>
								<el-option value="专业服务/咨询(财会/法律/人力资源等)"></el-option>
								<el-option value="服务业"></el-option>
								<el-option value="广告/会展/公关"></el-option>
								<el-option value="文化|传媒|娱乐|体育"></el-option>
								<el-option value="中介服务"></el-option>
								<el-option value="生产|加工|制造"></el-option>
								<el-option value="检验/检测/认证"></el-option>
								<el-option value="交通|运输|物流|仓储"></el-option>
								<el-option value="外包服务"></el-option>
								<el-option value="能源|矿产|环保"></el-option>
								<el-option value="快速消费品(食品/饮料/烟酒/日化)"></el-option>
								<el-option value="政府|非营利机构"></el-option>
								<el-option value="耐用消费品(服饰/纺织/皮革/家具/家电)"></el-option>
								<el-option value="农|林|牧|渔|其他"></el-option>
								<el-option value="贸易/进出口"></el-option>
								<el-option value="零售/批发"></el-option>
								<el-option value="租赁服务"></el-option>
								<el-option value="教育/培训/院校"></el-option>
								<el-option value="礼品/玩具/工艺美术/收藏品/奢侈品"></el-option>
								<el-option value="汽车/摩托车"></el-option>
								<el-option value="大型设备/机电设备/重工业"></el-option>
								<el-option value="加工制造(原料加工/模具)"></el-option>
								<el-option value="仪器仪表及工业自动化"></el-option>
								<el-option value="印刷/包装/造纸"></el-option>
								<el-option value="办公用品及设备"></el-option>
								<el-option value="医药/生物工程"></el-option>
								<el-option value="医疗设备/机械"></el-option>
								<el-option value="航空/航天研究与制造"></el-option>
								<el-option value="交通/运输"></el-option>
								<el-option value="物流/仓储"></el-option>
								<el-option value="医疗/护理/美容/保健/卫生服务"></el-option>
								<el-option value="酒店/餐饮"></el-option>
								<el-option value="旅游/度假"></el-option>
								<el-option value="媒体/出版/影视/文化传播"></el-option>
								<el-option value="娱乐/体育/修闲"></el-option>
								<el-option value="能源/矿产/采掘/冶炼"></el-option>
								<el-option value="石油/石化/化工"></el-option>
								<el-option value="电气/电力/水利"></el-option>
								<el-option value="环保"></el-option>
								<el-option value="政府/公共事业/非营利机构"></el-option>
								<el-option value="学术/科研"></el-option>
								<el-option value="农/林/牧/渔"></el-option>
								<el-option value="跨领域经营"></el-option>
								<el-option value="其他"></el-option>
							</el-select>			                
		              	</el-form-item>
		              	<el-form-item label="期望从事职业:" prop="expertJobIntension">
							<el-input v-model="form.expertJobIntension" style="width:215px"></el-input>			                
		              	</el-form-item>
						<el-form-item label="期望工作地点" >
							<v-distpicker hide-area @selected="setNativePlace" :province="form.province" :city="form.city"></v-distpicker>
						</el-form-item>
		              	<el-form-item label="税前期望月薪:" prop="expertSalary">
							<el-select v-model="form.expertSalary">
								<el-option label="1000元/月" value="1000"></el-option>
								<el-option label="2000元/月" value="2000"></el-option>
								<el-option label="4000元/月" value="4000"></el-option>
								<el-option label="6000元/月" value="6000"></el-option>
								<el-option label="8000元/月" value="8000"></el-option>
								<el-option label="10000元/月" value="10000"></el-option>
								<el-option label="15000元/月" value="15000"></el-option>
								<el-option label="25000元/月" value="25000"></el-option>
								<el-option label="35000元/月" value="35000"></el-option>
								<el-option label="50000元/月" value="50000"></el-option>
								<el-option label="70000元/月" value="70000"></el-option>
								<el-option label="100000元/月" value="100000"></el-option>
							</el-select>			                
		              	</el-form-item>
		          		<el-form-item label="求职状态:" prop="jobStatus">
							<el-select v-model="form.jobStatus">
								<el-option value="离职"></el-option>
								<el-option value="在职，可一个月内到岗"></el-option>
								<el-option value="在职考虑换工作"></el-option>
								<el-option value="在职，不想换工作"></el-option>
								<el-option value="应届毕业生"></el-option>
							</el-select>		                
		              	</el-form-item>
		            </dl>
              	</div>
              	<div class="box">
              		<dl>
	              		<dt>工作经验</dt>
						<el-button type="primary" plain class="add" @click="$refs.addWorkExperience.show()">添加</el-button>
						<div class="table-wrap">
						    <el-table :data="workTableData" border stripe style="width: 100%" :show-overflow-tooltip="true">
						        <el-table-column  label="操作" width="90px">
						        	<template slot-scope="scope">
							            <el-button type="text" @click="$refs.editWorkExperience.show(scope.row,scope.$index)">编辑</el-button>
							            <el-button type="text" @click="handleDeleteWork(scope.$index)">移除</el-button>
							        </template>
						        </el-table-column>
						        <el-table-column type="index" label="序号" width="45px"></el-table-column>
						        <el-table-column prop="companyName" label="公司名称" show-overflow-tooltip></el-table-column>
						        <el-table-column prop="industry" label="所属行业" show-overflow-tooltip width="180px"></el-table-column>
						        <el-table-column prop="jobIntension" label="职位名称" show-overflow-tooltip></el-table-column>
						        <el-table-column prop="monthSalary" label="税前薪资" show-overflow-tooltip width="130px"></el-table-column>
						        <el-table-column prop="workDate" label="在职时间" show-overflow-tooltip width="180px"></el-table-column>
						        <el-table-column prop="jobDescription" label="工作描述" show-overflow-tooltip width="250px"></el-table-column>
						    </el-table>
						</div>
	              	</dl>
              	</div>
              	<div class="box">
              		<dl>
	              		<dt>项目经验</dt>
						<el-button type="primary" plain class="add" @click="$refs.addProjectExperience.show()" >添加</el-button>
						<div class="table-wrap">
						    <el-table :data="projectTableData"  style="width: 100%" border stripe :show-overflow-tooltip="true">
						        <el-table-column prop="pkResumeProject" label="操作" width="90px">
						        	<template slot-scope="scope">
							            <el-button type="text" @click="$refs.editProjectExperience.show(scope.row,scope.$index)">编辑</el-button>
							            <el-button type="text" @click="handleDeleteProject(scope.$index)">移除</el-button>
							        </template>
						        </el-table-column>
						        <el-table-column type="index" label="序号" width="45px"></el-table-column>
						        <el-table-column prop="projectName" label="项目名称" show-overflow-tooltip></el-table-column>
						        <el-table-column prop="projectDate" label="项目时间" show-overflow-tooltip width="180px"></el-table-column>
						        <el-table-column prop="projectDescription" label="项目描述" show-overflow-tooltip width="250px"></el-table-column>
						        <el-table-column prop="personalResponsibility" label="个人职责" show-overflow-tooltip width="250px"></el-table-column>
						        <el-table-column prop="companyName" label="公司名称" show-overflow-tooltip></el-table-column>
						    </el-table>
						</div>
	              	</dl>
              	</div>
              	<div class="box">
              		<dl>
	              		<dt>专业技能</dt>
	              		<div style="text-align: center;">
	              			<el-form-item prop="professionalAbility">
	              				<el-input type="textarea" v-model="form.professionalAbility" :rows="6"  :autosize="{ minRows: 6, maxRows: 8}"></el-input>
	              			</el-form-item>
						</div>
	              	</dl>
              	</div>
              	<div class="box">
              		<dl>
	              		<dt>证书</dt>
						<div style="text-align: center;">
							<el-form-item prop="certificate">
								<el-input type="textarea" v-model="form.certificate" :rows="6" :autosize="{ minRows: 6, maxRows: 8}" ></el-input>
							</el-form-item>
						</div>
	              	</dl>
	              	<addWorkExperience ref="addWorkExperience" @show="showTableDataWork"></addWorkExperience>
	              	<editWorkExperience ref="editWorkExperience" @edit="editTableDataWork" ></editWorkExperience>
	              	<addProjectExperience ref="addProjectExperience" @show="showTableDataProject"></addProjectExperience>
	              	<editProjectExperience ref="editProjectExperience" @edit="editTableDataProject"></editProjectExperience>
              	</div>
          	</el-form>
			<!-- 最后是按钮，（不要放在 form 里面） -->
		    <div class="dialog-edit__btnGroup" slot="footer">
		        <el-button type="primary" @click="btnClick">确认</el-button>
		        <el-button @click="dialogVisible = false">取消</el-button>
		    </div>
		</div>
	</el-dialog>
</template>

<script>
import * as RESUME_API from '@/api/graduate/resume.js';
import addWorkExperience from '../add/addWorkExperience.vue';
import editWorkExperience from './editWorkExperience.vue';
import addProjectExperience from '../add/addProjectExperience.vue';
import editProjectExperience from './editProjectExperience.vue';
import VDistpicker from 'v-distpicker'
export default{
	components:{
		addWorkExperience,editWorkExperience,addProjectExperience,editProjectExperience,VDistpicker,
	},
	data(){
		return{
			dialogVisible: false,
			resumeId:'',
			form:{
                jobType:'',
                expertIndustry:'',	//期望从事行业
                expertJobIntension:'',//期望从事职业
                province:'',
                city:'',
                expertSalary:'',//税前期望月薪
                jobStatus:'',//求职状态
                professionalAbility:'',//专业技能
                certificate:'',//证书
			},
			workTableData:[],
			projectTableData:[],
			rules:{
                expertIndustry:[
					{ required: true, message: '请选择期望从事行业', trigger: 'blur' },
				],
                expertJobIntension:[
					{ required: true, message: '请输入期望从事职业', trigger: 'blur' },
				],
                expertSalary:[
					{ required: true, message: '请选择税前期望月薪', trigger: 'blur' },
				],
                jobStatus:[
					{ required: true, message: '请选择求职状态', trigger: 'blur' },
				],
                professionalAbility:[
					{ required: true, message: '请输入专业技能', trigger: 'blur' },
				],
                certificate:[
					{ required: true, message: '请输入证书', trigger: 'blur' },
				],
			},
		}
	},
	watch: {
      dialogVisible(value) {
        if (!value) {
          this.beforeClose();
        }
      },
    },
    methods:{
    	show(scope) {
        	this.dialogVisible = true;
        	this.form = scope;
        	this.projectTableData = scope.projectList;
        	this.workTableData = scope.workList;
        	this.resumeId = scope.pkResumeId;
      	},
      	btnClick(){
      		this.$refs['formName'].validate((valid) =>{
				if(this.form.city == '市' || this.form.city == null || this.form.city == ''){
					this.$message({
						message: '请选择期望工作地点!',
						type: 'warning'
					});
					return false;
				}
				if(valid){
					let param = {
						'projectTableData':JSON.stringify(this.projectTableData),
						'workTableData':JSON.stringify(this.workTableData),
						'pkResumeId':this.resumeId,
						'jobType':this.form.jobType,
						'expertIndustry':this.form.expertIndustry,
						'expertJobIntension':this.form.expertJobIntension,
						'expertSalary':this.form.expertSalary,
						'jobStatus':this.form.jobStatus,
						'professionalAbility':this.form.professionalAbility,
						'certificate':this.form.certificate,
						'city': this.form.city,
						'province': this.form.province,
					};
					RESUME_API.api(RESUME_API.URL_DO_UPDATE,param).then(data =>{
						if(data.rs){
							this.$message.success('修改成功');
							this.dialogVisible = false;
						}
					});
					
				}else {//校验失败
	              	return false;
				}
				this.dialogVisible = false;
			});
      	},
      	beforeClose(){
      		this.$refs['formName'].resetFields();
	        // 推送关闭消息
			this.projectTableData = [];
			this.workTableData = [];
			this.resumeId = '';
	        this.$emit('closed');
      	},//显示工作经验数据
      	showTableDataWork(data){
      		this.workTableData.push(data);
      	},//修改工作经验
      	editTableDataWork(data){
      		this.workTableData.splice(data.rowIndex,1);
      		this.workTableData.push(data);
      	},//移除工作经验
      	handleDeleteWork(index){
      		this.workTableData.splice(index,1);
      	},//显示项目经验数据
      	showTableDataProject(data){
      		this.projectTableData.push(data);
      	},//修改项目经验
      	editTableDataProject(data){
      		this.projectTableData.splice(data.rowIndex,1);
      		this.projectTableData.push(data);
      	},//移除项目经验
      	handleDeleteProject(index){
      		this.projectTableData.splice(index,1);
      	},
		setNativePlace(value){
			this.form.province = value.province.value;
			this.form.city = value.city.value;
		},
    },
 }
</script>

<style>
.box{
	margin: 0 auto;
	opacity: 1;
	padding-top: 5px;
	border-radius: 5px;
	padding-left:30px;
	padding-right:30px;
	position:relative;
	line-height: 30px;
	font-size: 16px;
}
.el-input__inner{
    width: 90%;
    height: 34px;
    border: 1px solid #85a0c5;
    border-radius: 6px;
    box-shadow: none;
    background-color: transparent;
    font-size: 14px;
    color: #666;
    padding-left:15px;
}
.el-form--inline .el-form-item__label{
	padding-left: 0px;
	font-size: 1.3rem;
}
.table-wrap .el-table th {
    padding: 2px 0;
}
.el-textarea__inner{
	width:550px;
}
.add{
	margin:5px 5px;
}
.box dt {
    margin: 8px 0;
    padding-left: 14px;
    font-size: 16px;
    color: #333;
    border-left: 4px solid #108cee;
}
.el-radio-button__inner {
	padding:8px 10px;
}
.table-wrap .el-table th{
	font-size: 0.4rem;
    color: #301f1fba;
}
</style>