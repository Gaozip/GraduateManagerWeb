<template>
	<el-form :inline="true" :model="form" ref="formName" :rules="rules">
		<div class="search-bar">
			<el-form-item label="简历编号:" prop="resumeName">
				<el-input v-model="form.resumeId" @keyup.enter.native="doSearch"></el-input>
			</el-form-item>
			<el-form-item label="年龄(以上):">
				<el-input v-model="form.age" @keyup.enter.native="doSearch"></el-input>
			</el-form-item>
			<el-form-item label="性别:">
				<el-radio-group v-model="form.sex" >
				    <el-radio-button label="男"></el-radio-button>
				    <el-radio-button label="女"></el-radio-button>
			    </el-radio-group>			
			</el-form-item>
			<el-form-item label="期望行业:">
				<el-select v-model="form.expertIndustry" >
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
			<el-form-item label="期望职业">
				<el-select v-model="form.expertJobIntenson">
					<el-option value="java工程师"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="工作经验:">
				<el-select v-model="form.workYear">
					<el-option value="暂无"></el-option>
					<el-option value="1年及以上"></el-option>
					<el-option value="2年及以上"></el-option>
					<el-option value="3年及以上"></el-option>
					<el-option value="4年及以上"></el-option>
					<el-option value="5年及以上"></el-option>
					<el-option value="6年及以上"></el-option>
					<el-option value="7年及以上"></el-option>
					<el-option value="8年及以上"></el-option>
					<el-option value="9年及以上"></el-option>
					<el-option value="10年及以上"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="学历:">
				<el-select v-model="form.education">
					<el-option value="不限"></el-option>
					<el-option value="高中/中技/中专"></el-option>
					<el-option value="大专"></el-option>
					<el-option value="本科"></el-option>
					<el-option value="硕士"></el-option>
					<el-option value="MBA"></el-option>
					<el-option value="博士"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="毕业院校:">
				<el-select v-model="form.gradCollege" >
					<el-option value="东方"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="所在公司:">
				<el-select v-model="form.companyName" >
					<el-option value="福建博恒"></el-option>
				</el-select>
			</el-form-item>
			<el-button type="primary"  plain style="margin-top: 5px;"@click="doSearch">查询</el-button>
		</div>
		<div class="table-wrap">
	      <el-table :data="tableData" border stripe style="width: 100%">
	        <el-table-column prop="pkResumeId" label="操作" width="90px" :show-overflow-tooltip="true">
	        	<template slot-scope="scope">
		            <el-button type="text" @click="$refs.showResume.show(scope.row)">查看</el-button>
		        </template>
	        </el-table-column>
	        <el-table-column type="index" label="序号" width="60px"></el-table-column>
	        <el-table-column prop="pkResumeId" label="简历编号" ></el-table-column>
	        <el-table-column prop="graduateInfo.name" label="姓名" show-overflow-tooltip ></el-table-column>
	        <el-table-column prop="graduateInfo.sex" label="性别" show-overflow-tooltip ></el-table-column>
	        <el-table-column prop="graduateInfo.age" label="年龄" show-overflow-tooltip width="90px"></el-table-column>
	        <el-table-column prop="graduateInfo.education" label="学历" show-overflow-tooltip></el-table-column>
	        <el-table-column prop="expertIndustry" label="期望行业" show-overflow-tooltip ></el-table-column>
			<el-table-column prop="expertJobIntension" label="期望职位" show-overflow-tooltip ></el-table-column>
			<el-table-column prop="certificate" label="期望工作地点" show-overflow-tooltip></el-table-column>
	      </el-table>
	      <div class="pagination-bar" v-show="tableData.length > 0">
	        <el-pagination
	          @size-change="handleSizeChange"
	          @current-change="handleCurrentChange"
	          :current-page="currentPage"
	          :page-sizes="[defaultPageSize, 10, 20, 40]"
	          :page-size="pageSize"
	          layout="total, sizes, prev, pager, next, jumper"
	          :total="totalNum">
	        </el-pagination>
	      </div>
	      <showResume ref="showResume"></showResume>
	    </div>
	</el-form>
</template>

<script>
import * as AXIOS from '@/api/axios.js';
import showResume from '../graduate/resume/show/showResume.vue'
	
export default{
	components:{
		showResume,
	},
	data(){
		return{
			form:{
				resumeId:'',
				expertIndustry:'',
				education:'',
				sex:'',
				age:'',
				workYear:'',
				gradCollege:'',
				companyName:'',
				expertJobIntenson:'',
			},
			tableData: [],
			// 分页
	        currentPage: 1,
	        pageSize: 10,
	        totalNum: 0,
	        // 默认分页数量
	        defaultPageSize: 0,
			rules:{
				
			},	
		}
	},
	mounted(){
		this.fetchTableData();
	},
	methods:{
		// 修改每页显示条数
      	handleSizeChange(value) {
        	this.currentPage = 1;
        	this.pageSize = value;
        	this.fetchTableData();
      	},
      	// 修改当前页
      	handleCurrentChange(value) {
        	this.currentPage = value;
        	this.fetchTableData();
      	},
      	fetchTableData(){
      		let param = {
      			pageNo: this.currentPage,
          		pageSize: this.pageSize,
      		};
      		AXIOS.api('/resume/getResumeByEmployer',param).then(data =>{
  				this.tableData = data.datas.datas;
                this.totalNum = data.datas.totalNum;
                this.currentPage = data.datas.pageNo;
      		});
      	},
      	doSearch(){
			let param = {
				'resumeId': this.form.resumeId,
				'expertIndustry': this.form.expertIndustry,
				'education': this.form.education,
				'sex': this.form.sex,
				'age': this.form.age,
				'workYear': this.form.workYear,
				'gradCollege': this.form.gradCollege,
				'companyName': this.form.companyName,
				'expertJobIntension': this.form.expertJobIntenson,
			};
			AXIOS.api('/resume/doSearchByRequire',param).then(data =>{
				this.tableData = [];
				console.info(data.datas.datas);
				this.tableData = data.datas.datas;
                this.totalNum = data.datas.totalNum;
                this.currentPage = data.datas.pageNo;
			});
      	},
	},
}
</script>

<style scoped>
.search-bar >>> .el-radio-button__inner {
	padding:8px 20px;	
}
</style>