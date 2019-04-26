<template>
	<div class="companyInfo">
		<fieldset>
			<legend >公司基本信息</legend>
			<br />
			<el-form :inline="true" :model="form" :rules="rules" ref="formName">
				<div style="text-align: center;" class="box">
					<div class="box1">
						<el-form-item label="公司名称" prop="companyName">
							<el-input v-model="form.companyName"></el-input>
						</el-form-item>
						<el-form-item label="成立时间" prop="registerDate">
							<el-date-picker v-model="form.registerDate" type="date" placeholder="选择日期"></el-date-picker>
						</el-form-item>
						<el-form-item label="公司类型" prop="companyNature">
							<el-select v-model="form.companyType" placeholder="请选择">
								<el-option value="内资企业"></el-option>
								<el-option value="国有企业"></el-option>
								<el-option value="集体企业"></el-option>
								<el-option value="股份合作企业"></el-option>
								<el-option value="联营企业"></el-option>
								<el-option value="有限责任公司"></el-option>
								<el-option value="股份有限公司"></el-option>
								<el-option value="私营企业"></el-option>
								<el-option value="其他企业"></el-option>
								<el-option value="港、澳、台商投资企业"></el-option>
								<el-option value="合资经营企业（港或澳、台资）"></el-option>
								<el-option value="合作经营企业（港或澳、台资）"></el-option>
								<el-option value="港、澳、台商独资经营企业"></el-option>
								<el-option value="港、澳、台商投资股份有限公司"></el-option>
								<el-option value="外商投资企业"></el-option>
								<el-option value="中外合资经营企业"></el-option>
								<el-option value="中外合作经营企业"></el-option>
								<el-option value="外商投资股份有限公司"></el-option>
							</el-select>
						</el-form-item>
						<el-form-item label="员工人数" prop="employerNum">
							<el-input v-model="form.employerNum" placeholder="单位:人"></el-input>
						</el-form-item>
						<el-form-item label="所属行业" prop="industry">
							<el-select v-model="form.industry" placeholder="请选择">
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
					</div>
					<div class="box2">
						<div class="code"> 
							<el-form-item label="组织机构代码" prop="organizationCode">
								<el-input v-model="form.organizationCode"></el-input>
							</el-form-item>
						</div>
						<el-form-item label="法人代表" prop="legalRepresentative">
							<el-input v-model="form.legalRepresentative"></el-input>
						</el-form-item>
						<el-form-item label="经营状态" prop="managementForms">
							<el-select v-model="form.managementForms">
								<el-option value="存续"></el-option>
								<el-option value="在业"></el-option>
								<el-option value="吊销"></el-option>
								<el-option value="注销"></el-option>
								<el-option value="迁入"></el-option>
								<el-option value="迁出"></el-option>
								<el-option value="停业"></el-option>
								<el-option value="清算"></el-option>
							</el-select>
						</el-form-item>
						<el-form-item label="注册资本" prop="registerCapital">
							<el-input v-model="form.registerCapital" placeholder="单位:万"></el-input>						
						</el-form-item>
						
						<el-form-item label="电话热线" prop="hotLine">
							<el-input v-model="form.hotLine"></el-input>
						</el-form-item>
					</div>
				</div>
				<div style="float: left;padding-left:38px;">
					<el-form-item label="公司所在地" >
						<v-distpicker hide-area @selected="setNativePlace" :province="form.province" :city="form.city"></v-distpicker>
					</el-form-item>
				</div>
				<div style="text-align: center;">
					<el-form-item label="公司地址" prop="companyAddress">
						<el-input v-model="form.companyAddress" class="companyAddress"></el-input>
					</el-form-item>
					<br />
					<el-form-item label="经营范围" prop="scopeOfBusiness">
						<el-input type="textarea" v-model="form.scopeOfBusiness" :rows="4" :autosize="{ minRows: 4, maxRows:5}" style="width:530px"></el-input>
					</el-form-item>
					<el-form-item label="公司简介" prop="companyProfile">
						<el-input type="textarea" v-model="form.companyProfile" :rows="6" :autosize="{ minRows: 6, maxRows: 8}" style="width:530px"></el-input>
					</el-form-item>
				</div>
				<div style="text-align: center;">
					<el-button type="primary" plain @click="btnClick">确定</el-button>
				</div>
				<br />
			</el-form>
		</fieldset>
	</div>
	
</template>

<script>
import * as EMPLOYER_API from '@/api/employer/employer.js';
import * as tools from '@/assets/tools';
import VDistpicker from 'v-distpicker'
	
export default{
	components:{ VDistpicker, },
	data(){
		return{
			form:{
				companyName:'', //公司名称
				organizationCode:'',//组织机构代码
				registerDate:'',//注册时间
				registerCapital:'',//注册资本
				companyType:'',//公司性质
				industry:'',//所属行业
				employerNum:'',//员工人数
				hotLine:'',//电话热线
				province:'',
				city:'',
				companyAddress:'',//公司地址
				companyProfile:'',//公司简介
				legalRepresentative:'',//法人代表
				managementForms:'',//经营状态
				scopeOfBusiness:'',//经营范围
			},
			rules:{
				companyName:[
					{ required: true, message: '请输入公司名称', trigger: 'blur' },
				],
				organizationCode:[
					{ required: true, message: '请输入组织机构代码', trigger: 'blur' },
				],
				registerDate:[
					{ required: true, message: '请选择注册时间', trigger: 'blur' },
				],
				registerCapital:[
					{ required: true, message: '请输入注册资本', trigger: 'blur' },
					{ pattern: /^[0-9]*$/, message: '只能输入数字!', trigger: 'blur' },
				],
				companyType:[
					{ required: true, message: '请选择公司性质', trigger: 'blur' },
				],
				industry:[
					{ required: true, message: '请选择所属行业', trigger: 'blur' },
				],
				employerNum:[
					{ required: true, message: '请输入员工人数', trigger: 'blur' },
				],
				hotLine:[
					{ required: true, message: '请输入电话热线', trigger: 'blur' },
					{ pattern: /^[0-9]*$/, message: '只能输入数字!', trigger: 'blur' },
				],
				companyAddress:[
					{ required: true, message: '请输入公司地址', trigger: 'blur' },
				],
				companyProfile:[
					{ required: true, message: '请输入公司简介', trigger: 'blur' },
				],
				legalRepresentative:[
					{ required: true, message: '请输入法人代表', trigger: 'blur' },
				],
				managementForms:[
					{ required: true, message: '请选择经营状态', trigger: 'blur' },
				],
				scopeOfBusiness:[
					{ required: true, message: '请输入经营范围', trigger: 'blur' },
				],
			},
		}
	},
	mounted(){
		this.fetchData();
	},
	methods:{
		btnClick(){
			this.$refs['formName'].validate((valid) =>{
				if(this.form.city == '市' || this.form.city == null || this.form.city == ''){
					this.$message({
						message: '请选择公司所在地!',
						type: 'warning'
					});
					return false;
				}
				if(valid){
					let param = {
						'companyName': this.form.companyName, //公司名称
						'organizationCode':this.form.organizationCode,//组织机构代码
						'registerDate': tools.transformTime(this.form.registerDate, 'YYYY-MM-DD'),//注册时间
						'registerCapital':this.form.registerCapital,//注册资本
						'companyType':this.form.companyType,//公司性质
						'industry':this.form.industry,//所属行业
						'employerNum':this.form.employerNum,//员工人数
						'hotLine':this.form.hotLine,//电话热线
						'province': this.form.province,
						'city': this.form.city,
						'companyAddress':this.form.companyAddress,//公司地址
						'companyProfile':this.form.companyProfile,//公司简介
						'legalRepresentative':this.form.legalRepresentative,//法人代表
						'managementForms':this.form.managementForms,//经营状态
						'scopeOfBusiness':this.form.scopeOfBusiness,//经营范围
					};
					this.$confirm('确认更改？').then(_ => {
						EMPLOYER_API.api(EMPLOYER_API.URL_DO_UPDATE,param).then(data =>{
							this.$message.success('保存成功');
						});
					}).catch(_ => {});
				}else{
					return false;
				}
			});
		},
		fetchData(){
			EMPLOYER_API.api(EMPLOYER_API.URL_GET_EMPLOYER_INFO_BY_ID,{}).then(data =>{
				if(data.datas.isValid != '0'){
					this.form = data.datas;
				}
			});
		},
		setNativePlace(value){
			this.form.province = value.province.value;
			this.form.city = value.city.value;
		},
	},
}
</script>

<style scoped>
.companyInfo{
	background-color:white;
	width: 750px;
	margin: 0 auto;
	opacity: 1;
	margin-top: 20px;
	padding-top: 20px;
	padding-bottom: 30px;
	border-radius: 5px;
	padding-left:30px;
	padding-right:30px;
	position:relative;
	line-height: 30px;
	font-size: 16px;
}
.box{
	display: flex;
}
.box1{
	flex: 2;
}
.box2{
	flex: 2;
}
.box >>> .el-date-editor.el-input{
	width: 180px;
}
.box >>> .el-input--suffix .el-input__inner {
    padding-right: 15px;
}
.companyAddress{
	width: 530px;
}
.code{
	position: relative;
	padding-right: 25px;
}
.companyInfo >>> .el-input__inner {
	border: 1px solid #b2c3ea;
}
.companyInfo >>> .el-textarea__inner{
	border: 1px solid #b2c3ea;
}
.el-form-item.is-error >>> .el-input__inner,.el-form-item.is-error >>> .el-textarea__inner{
	border-color: #f56c6c;
}
.el-form-item.is-success >>> .el-input__inner,.el-form-item.is-success >>> .el-textarea__inner{
	border-color: #67c23a;
}
</style>
