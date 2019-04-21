<template>
	<div class="base-crud">
		<FuzzySearch placeholder="输入关键字进行搜索" ref="fuzzy" @fuzzyClick="fuzzyClick" width="350px">
			<el-form :inline="true" :model="searchForm" ref="formName" :rules="rules">
				<div class="search-bar">
					<el-form-item label="姓名:">
						<el-input v-model="searchForm.name" @keyup.enter.native="doSearch"></el-input>
					</el-form-item>
					<el-form-item label="年龄(以上):">
						<el-input v-model="searchForm.age" @keyup.enter.native="doSearch"></el-input>
					</el-form-item>
					<el-form-item label="性别:">
						<el-radio-group v-model="searchForm.sex" >
							<el-radio-button label="男"></el-radio-button>
							<el-radio-button label="女"></el-radio-button>
						</el-radio-group>
					</el-form-item>
					<el-form-item label="居住地">
						<v-distpicker hide-area @selected="setNativePlace" :province="searchForm.province" :city="searchForm.city"></v-distpicker>
					</el-form-item>
					<el-form-item label="学历:">
						<el-select v-model="searchForm.education">
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
						<el-input v-model="searchForm.gradCollege" @keyup.enter.native="doSearch"></el-input>
					</el-form-item>
					<el-form-item label="专业">
						<el-input v-model="searchForm.specialty"></el-input>
					</el-form-item>
					<el-form-item label="工作经验">
						<el-select v-model="searchForm.workYear" placeholder="请如实选择" >
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
					<el-button type="primary"  plain style="margin-top: 5px;"@click="doSearch">查询</el-button>
				</div>
			</el-form>
		</FuzzySearch>
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
				
				<el-table-column prop="graduateInfo.education" label="学历" show-overflow-tooltip></el-table-column>
				<el-table-column prop="expertIndustry" label="期望行业" show-overflow-tooltip ></el-table-column>
				<el-table-column prop="expertJobIntension" label="期望职位" show-overflow-tooltip ></el-table-column>
				<el-table-column prop="certificate" label="期望工作地点" show-overflow-tooltip></el-table-column>
			</el-table>
			<div class="pagination-bar">
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
	</div>
</template>

<script>
import FuzzySearch from '@/components/fuzzySearch/fuzzySearch.vue';	
import * as EMPLOYER_API from '@/api/employer/employer.js'
import showResume from '@/views/graduate/resume/show/showResume.vue'
import VDistpicker from 'v-distpicker'
	
export default{
	components:{
		showResume,FuzzySearch,VDistpicker,
	},
	data(){
		return{
			searchForm:{
				name:'',
				age:'',
				sex:'',
				province:'',
				city:'',
				education:'',
				gradCollege:'',
				specialty:'',
				workYear:'',
			},
			searchFormClone:{},
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
      		Object.assign(param,this.searchFormClone);
      		this.tableData = [];
      		EMPLOYER_API.api(EMPLOYER_API.URL_GET_RESUME_BY_EMPLOYER,param).then(data =>{
      			data.datas.datas.forEach(item =>{
      				item.forEach(item =>{
      					this.tableData.push(item);
					});
				});
                this.totalNum = this.tableData.length;
                this.currentPage = data.datas.pageNo;
      		});
      	},
		// 模糊搜索
		fuzzyClick(fuzzyWord) {
			this.currentPage = 1;
			let param = {
				FUZZY_WORD: fuzzyWord,
			};
			this.searchFormClone = Object.assign(param, {});
			this.fetchTableData();
		},
      	doSearch(){
      		this.currentPage = 1;
			let param = {
				name: this.searchForm.name,
				age: this.searchForm.age,
				sex: this.searchForm.sex,
				province: this.searchForm.province,
				city: this.searchForm.city,
				education: this.searchForm.education,
				gradCollege: this.searchForm.gradCollege,
				specialty: this.searchForm.specialty,
				workYear: this.searchForm.workYear,
			};
			this.searchFormClone = Object.assign(param, {});
			this.fetchTableData();
      	},
		setNativePlace(value){
			this.searchForm.province = value.province.value;
			this.searchForm.city = value.city.value;
		},
	},
}
</script>

<style scoped>
.search-bar >>> .el-radio-button__inner {
	padding:8px 20px;	
}
</style>