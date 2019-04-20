<template>
	<el-form :inline="true" :model="form" ref="formName" :rules="rules">
		<div class="search-bar">
			<el-form-item label="公告编号" prop="resumeName">
				<el-input v-model="form.pkArticleId" @keyup.enter.native="fetchTableData"></el-input>
			</el-form-item>
			<el-button type="primary"  plain style="margin-top: 5px;"@click="fetchTableData">查询</el-button>
			<el-button type="success"  plain style="margin-top: 5px;" @click="$refs.addArticle.show()">新建</el-button>
		</div>
		<div class="table-wrap">
	        <el-table :data="tableData" border stripe style="width: 100%">
		        <el-table-column label="操作" width="135px" :show-overflow-tooltip="true">
		        	<template slot-scope="scope">
		        		<el-button type="text" @click="$refs.showArticle.show(scope.row)">查看</el-button>
		        		<el-button type="text" @click="$refs.editArticle.show(scope.row)">修改</el-button>
			            <el-button type="text" @click="doDelete(scope.row.pkArticleId)">删除</el-button>
			        </template>
		        </el-table-column>
				<el-table-column type="index" width="50px" label="序号"></el-table-column>
				<el-table-column label="公告编号" prop="pkArticleId" width="80px"></el-table-column>
				<el-table-column prop="articleItem" label="公告标题" show-overflow-tooltip></el-table-column>
				<el-table-column prop="articleType" label="公告类型">
					<template slot-scope="scope">
						<img v-show="scope.row.articleType == '0'" src="@/assets/icon/ico_gj_red.png" height="13" width="13"/>
						<img v-show="scope.row.articleType == '2'" src="@/assets/icon/ico_gj.png" height="15" width="15"/>
						<label v-if="scope.row.articleType == '0'">重要通知</label>
						<label v-if="scope.row.articleType == '1'">版本更新</label>
						<label v-if="scope.row.articleType == '2'">修复bug</label>
						<label v-if="scope.row.articleType == '3'">热门事件</label>
					</template>
				</el-table-column>
				<el-table-column prop="startTime" label="发布时间">
					<template slot-scope="scope">
						{{ scope.row.startTime | dateFmt('YYYY-MM-DD HH:mm:ss')}}
					</template>
				</el-table-column>
				<el-table-column prop="isValid" label="是否有效" width="80px">
					<template slot-scope="scope">
						<label v-if="scope.row.isValid == '0'">无效</label>
						<label v-if="scope.row.isValid == '1'">有效</label>
					</template>
				</el-table-column>
				<el-table-column prop="isTop" label="是否热门" width="80px">
					<template slot-scope="scope">
						<label v-if="scope.row.isTop == '1'">是</label>
						<label v-if="scope.row.isTop == '0'">否</label>
					</template>
				</el-table-column>
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
		    <addArticle ref="addArticle" @closed="fetchTableData()"></addArticle>
		    <editArticle ref="editArticle" @closed="fetchTableData()"></editArticle>
		    <showArticle ref="showArticle"></showArticle>
	   </div>
	</el-form>
</template>

<script>
import * as ARTICLE_API from '@/api/admin/article.js'
import addArticle from './addArticle.vue'
import editArticle from './editArticle.vue'
import showArticle from './showArticle.vue'
export default{
	components:{
		addArticle,editArticle,showArticle,
	},
	data(){
		return{
			form:{
				
			},
			// 分页
	        currentPage: 1,
	        pageSize: 10,
	        totalNum: 0,
	        // 默认分页数量
	        defaultPageSize: 0,
			tableData:[],
			rules:{
				
			},
		}
	},
	mounted(){
		this.fetchTableData();
	},
	methods:{
		fetchTableData(){
			let param = {
				pageNo: this.currentPage,
				pageSize: this.pageSize,
			};
			Object.assign(param,{pkArticleId: this.form.pkArticleId});
			ARTICLE_API.api(ARTICLE_API.URL_ARTICLE_SHOW,param).then(data =>{
				this.tableData = data.datas.datas;
				this.totalNum = data.datas.totalNum;
				this.currentPage = data.datas.pageNo;
			});
		},
		doDelete(id){
			this.$confirm('确认删除？').then(_ => {
				ARTICLE_API.api(ARTICLE_API.URL_DO_DELETE,{pkArticleId: id}).then(data =>{
					if(data.rs){
						this.$message.success('删除成功!');
						this.fetchTableData();
					}
				});
			}).catch(_ => {});
			
		},
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
	},
}
</script>

<style>
</style>