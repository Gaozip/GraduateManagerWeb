<template>
	<el-form :inline="true" :model="form" ref="formName" :rules="rules">
		<div class="search-bar">
			<el-form-item label="简历编号" prop="resumeName">
				<el-input v-model="form.resumeId" @keyup.enter.native="doSearch"></el-input>
			</el-form-item>
			<el-button type="primary"  plain style="margin-top: 5px;"@click="doSearch">查询</el-button>
			<el-button type="success"  plain style="margin-top: 5px;" @click="$refs.addResume.show()">新建</el-button>
		</div>
		<div class="table-wrap">
	      <el-table :data="tableData" border stripe style="width: 100%">
	        <el-table-column prop="pkResumeId" label="操作" width="135px" :show-overflow-tooltip="true">
	        	<template slot-scope="scope">
	        		<el-button type="text" @click="$refs.showResume.show(scope.row)">查看</el-button>
		            <el-button type="text" @click="$refs.editResume.show(scope.row)">修改</el-button>
		            <el-button type="text" @click="deleteResumeByResumeId(scope.row.pkResumeId)">删除</el-button>
		        </template>
	        </el-table-column>
	        <el-table-column type="index" label="序号" width="46px"></el-table-column>
	        <el-table-column prop="pkResumeId" label="简历编号"></el-table-column>
	        <el-table-column prop="jobType" label="期望工作性质" show-overflow-tooltip width="120px"></el-table-column>
	        <el-table-column prop="expertIndustry" label="期望从事行业" show-overflow-tooltip width="180px"></el-table-column>
	        <el-table-column prop="expertJobIntension" label="期望从事职业" show-overflow-tooltip width="180px"></el-table-column>
	        <el-table-column prop="expertSalary" label="税前期望月薪" show-overflow-tooltip width="130px"></el-table-column>
	        <el-table-column prop="jobStatus" label="求职状态" show-overflow-tooltip width="150px"></el-table-column>
	        <el-table-column  label="工作经验">
	        	<template slot-scope="Scope">
	        		<el-button type="text" @click="$refs.showWokeExperience.show(Scope.row)">查看</el-button>
	        	</template>
	        </el-table-column>
	        <el-table-column  label="项目经验">
	        	<template slot-scope="Scope">
	        		<el-button type="text" @click="$refs.showProjectExperience.show(Scope.row)">查看</el-button>
	        	</template>
	        </el-table-column>
	        <el-table-column prop="professionalAbility" label="专业技能" show-overflow-tooltip width="250px"></el-table-column>
	        <el-table-column prop="certificate" label="证书" show-overflow-tooltip width="200px"></el-table-column>
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
	      <addResume ref="addResume" @closed="fetchTableData"></addResume>
	      <showProjectExperience ref="showProjectExperience"></showProjectExperience>
	      <showWokeExperience ref="showWokeExperience"></showWokeExperience>
	      <editResume ref="editResume" @closed="fetchTableData"></editResume>
	      <showResume ref="showResume"></showResume>
	    </div>
	</el-form>
</template>

<script>
import * as RESUME_API from '@/api/graduate/resume.js'
import addResume from './add/addResume.vue'
import showProjectExperience from './show/showProjectExperience.vue'
import showWokeExperience from './show/showWokeExperience.vue'
import editResume from './edit/editResume.vue'
import showResume from './show/showResume.vue'
export default{
	components:{
		addResume,showProjectExperience,showWokeExperience,editResume,showResume,
	},
	data(){
		return{
			form:{
				resumeId:'',
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
      	deleteResumeByResumeId(resumeId){
      		this.$confirm('确认删除？').then(_ => {
      			RESUME_API.api(RESUME_API.URL_DO_DELETE,{'resumeId':resumeId,}).then(data =>{
					this.$message.success('删除成功');
					this.fetchTableData();
				});
      		}).catch(_ => {});
			
      	},
      	fetchTableData(){
      		let param = {
      			pageNo: this.currentPage,
          		pageSize: this.pageSize,
				resumeId: '',
      		};
      		RESUME_API.api(RESUME_API.URL_QUERY_PAGE,param).then(data =>{
      			this.tableData = data.datas.datas;
                this.totalNum = data.datas.totalNum;
                this.currentPage = data.datas.pageNo;
      		});
      	},
      	doSearch(){
			let param = {
				pageNo: this.currentPage,
				pageSize: this.pageSize,
				resumeId: this.form.resumeId,
			};
			RESUME_API.api(RESUME_API.URL_QUERY_PAGE,param).then(data =>{
				this.tableData = data.datas.datas;
				this.totalNum = data.datas.totalNum;
				this.currentPage = data.datas.pageNo;
			});
      	}
	},
}
</script>

<style scoped>
.el-form--inline >>> .el-form-item__label{
	padding-left: 0px;
	font-size: 1.3rem;
}
</style>