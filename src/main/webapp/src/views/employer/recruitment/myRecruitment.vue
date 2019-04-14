<template>
	<el-form :inline="true" :model="form" ref="formName" :rules="rules">
		<div class="search-bar">
			<el-form-item label="招聘信息编号" prop="resumeName">
				<el-input v-model="form.resumeId" @keyup.enter.native="doSearch"></el-input>
			</el-form-item>
			<el-button type="primary"  plain style="margin-top: 5px;"@click="doSearch">查询</el-button>
			<el-button type="success"  plain style="margin-top: 5px;" @click="$refs.addRecruitment.show()">新建</el-button>
		</div>
		<div class="table-wrap">
	      <el-table :data="tableData" border stripe style="width: 100%">
	        <el-table-column prop="pkResumeId" label="操作" width="135px" :show-overflow-tooltip="true">
	        	<template slot-scope="scope">
	        		<el-button type="text" @click="$refs.showRecruitment.show(scope.row)">查看</el-button>
	        		<el-button type="text" @click="$refs.editRecruitment.show(scope.row)">修改</el-button>
		            <el-button type="text" @click="deleteResumeByResumeId(scope.row.pkRecruitmentId)">删除</el-button>
		        </template>
	        </el-table-column>
	        <el-table-column type="index" label="序号" width="49px"></el-table-column>
	        <el-table-column label="发布状态">
	        	<template slot-scope="scope">
	        		<span v-if="scope.row.state == '1'">已发布</span>
	        		<span v-if="scope.row.state == '0'">未发布</span>
	        	</template>
	        </el-table-column>
	        <el-table-column prop="position" label="招聘职位" show-overflow-tooltip width="120px"></el-table-column>
	        <el-table-column prop="monthSalary" label="月薪" show-overflow-tooltip width="80px"></el-table-column>
	        <el-table-column prop="workPlace" label="工作地点" show-overflow-tooltip width="180px"></el-table-column>
	        <el-table-column prop="jobNature" label="工作性质" show-overflow-tooltip width="100px"></el-table-column>
	        <el-table-column prop="recruitNum" label="招收人数" show-overflow-tooltip width="80px"></el-table-column>
	        <el-table-column prop="education" label="学历要求" show-overflow-tooltip width="120px"></el-table-column>
	        <el-table-column prop="workExperience" label="工作经验" show-overflow-tooltip width="120px"></el-table-column>
	        <el-table-column prop="jobContent" label="工作内容" show-overflow-tooltip width="150px"></el-table-column>
	        <el-table-column prop="qualification" label="任职要求" show-overflow-tooltip width="150px"></el-table-column>
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
	      <addRecruitment ref="addRecruitment" @closed="fetchTableData()"></addRecruitment>
	      <editRecruitment ref="editRecruitment"></editRecruitment>
	      <showRecruitment ref="showRecruitment"></showRecruitment>
	    </div>
	</el-form>
</template>

<script>
import * as AXIOS from '@/api/axios.js'
import addRecruitment from './add/addRecruitment.vue'
import editRecruitment from './edit/editRecruitment.vue'
import showRecruitment from './show/showRecruitment.vue'
export default{
	components:{
		addRecruitment,editRecruitment,showRecruitment,
	},
	data(){
		return{
			tableData: [],
			form:{},
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
      	deleteResumeByResumeId(Id){
      		this.$confirm('确认删除？').then(_ => {
      			AXIOS.api('/recruitment/doDelete',{'pkRecruitmentId':Id,}).then(data =>{
					this.$message.success('删除成功');
				});
      		}).catch(_ => {});
			
      	},
      	fetchTableData(){
      		let param = {
      			pageNo: this.currentPage,
          		pageSize: this.pageSize,
      		};
      		AXIOS.api('/recruitment/queryPage',param).then(data =>{
      			this.tableData = data.datas.datas;
                this.totalNum = data.datas.totalNum;
                this.currentPage = data.datas.pageNo;
      		});
      	},
      	doSearch(){
//    		if(this.form.resumeId != null && this.form.resumeId != ''){
//    			AXIOS.api('/resume/doSearch',{'resumeId':this.form.resumeId,}).then(data =>{
//	      			this.tableData = data.datas.datas;
//	                this.totalNum = data.datas.totalNum;
//	                this.currentPage = data.datas.pageNo;
//	      		});
//    		}else{
//    			this.fetchTableData();
//    		}
      		
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