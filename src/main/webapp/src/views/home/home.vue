<template>
	<div class="mainBody">
		
		<div class="card1">
			<el-card class="article">
				<div slot="header" class="headerr">
				    <span>公告</span>
				</div>
				<ul class="arti">
					<li v-for="item in articleList">
						<a href="javascript:void(0)" @click="$refs.showDetail.show(item.key)" style="text-overflow: ellipsis;overflow: hidden;white-space: nowrap">{{item.value}}</a>
					</li>
				</ul>
				<div class="pagination-bar">
					<el-pagination
						small
						@current-change="handleCurrentChange"
						:current-page="currentPage"
						layout="prev, pager, next"
						:page-size="pageSize"
						:total="totalNum">
					</el-pagination>
				</div>
			</el-card>
		</div>
		<div class="card2">
			<el-card class="card">
				<div slot="header" class="headerr">
				    <span>服务热线</span>
				</div>
			  	<div class="bod">
					<ol>
						<li>客服：{{hotLineForm.customerServiceTel}}</li>
						<li>手机：{{hotLineForm.mobilePhone}}</li>
						<li>电话：{{hotLineForm.telephone}}</li>
						<li>邮箱：{{hotLineForm.serviceEmail}}</li>
						<li>服务地址：{{hotLineForm.serviceAddress}}</li>
					</ol>
					<br/>
			  	</div>
			</el-card>
		</div>
		<div class="card3">
			<el-carousel indicator-position="outside" arrow="always" :interval="5000" height="380px">
				<el-carousel-item v-for="item in fileList" style="text-align: center;">
				  	<img :src="item.url" width="580px" height="330px" style="margin-top: 25px;">
				</el-carousel-item>
	  		</el-carousel>
		</div>
		<showDetail ref="showDetail"></showDetail>
	</div>
</template>	
<script>
import * as ARTICLE_API from '@/api/admin/article.js'
import * as ADMIN_API from '@/api/admin/home.js'
import showDetail from './showDetail.vue';
const articleType = {
	0:'重要通知',
	1:'版本更新',
	2:'修复bug',
	3:'热门事件',
};
export default {
    name: 'home',
    components: {showDetail,},
    data() {
        return {
        	ctxPath,
			fileList:[],
			hotLineForm:{
				customerServiceTel:'',
				serviceAddress:'',
				serviceEmail:'',
				telephone:'',
				mobilePhone:'',
			},
			articleList: [],//公告
			//== 公告分页
			tableData: [],
			totalNum: 0,
			currentPage: 1,
			pageSize: 6,
			totalPage: 0,
        };
    },
	mounted(){
		this.fetchArticleData();
		this.fetchHotLineData();
		this.fetchPictureList();
	},
    methods: {
		// 修改当前页
		handleCurrentChange(value) {
			this.currentPage = value;
			this.fetchArticleData();
		},
		fetchArticleData(){
			let param = {
				pageNo: this.currentPage,
				pageSize: this.pageSize,
			};
			this.articleList = [];
			ARTICLE_API.api(ARTICLE_API.URL_ARTICLE_SHOW,param).then(data =>{
				this.tableData = data.datas.datas;
				this.totalNum = data.datas.totalNum;
				this.currentPage = data.datas.pageNo;
				
				this.tableData.forEach(item =>{
					var type = "";
					switch (item.articleType) {
						case 0: type = "重要通知"; break;
						case 1: type = "版本更新"; break;
						case 2: type = "修复bug";  break;
						case 3: type = "热门事件"; break;
					}
					this.articleList.push({key: item,value: "【"+type+"】"+item.articleItem});
				});
			});
		},
		fetchHotLineData(){
			ADMIN_API.api(ADMIN_API.URL_QUERY_HOT_LINE_INFO,{}).then(data =>{
				this.hotLineForm = data.datas;
			});	
		},
		fetchPictureList(){
			this.fileList = [];
			ADMIN_API.api(ADMIN_API.URL_QUERY_PICTURE_LIST,{}).then(data =>{
				data.datas.forEach(item =>{
					this.fileList.push({name:item.fileName,url:item.imgPath});
				});
			});
		},
    },
};
</script>

<style scoped>
.mainBody{
	background-color:#f0f0f0;
	width: 100%;
	height:100%;
	border-radius: 5px;
	position:absolute;
	line-height: 30px;
	font-size: 16px;
}

.card {
   width: 320px;
}
.article{
	width: 320px;
}

.card >>> div,.article >>> div{
	padding: 4px 9px;
}

.card1{
	position: absolute;
	display: inline;
	margin-left: 750px;
	margin-top: 40px;
	float: right;
}
.card2{
	position: absolute;
	display: inline;
	float: right;
	margin-left: 750px;
	margin-top: 330px;
}
.card3{
	width: 700px;
	height: 600px;
	position: absolute;
	margin-left: 20px;
	margin-top: 80px;
}
.bod li{
	font-size: 10px;
	line-height: 25px;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
}
  
.arti >>> li{
	font-size: 12px;
	line-height: 25px;
}
</style>