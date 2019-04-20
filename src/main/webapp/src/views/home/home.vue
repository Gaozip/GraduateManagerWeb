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
						<li>客服：400-885-9898</li>
						<li>手机：12345678901</li>
						<li>电话：010-58635888-</li>
						<li>邮箱： crmnoreply@zhaopin.com.cn</li>
					</ol>
			  	</div>
			</el-card>
		</div>
		<div class="card3">
			<el-carousel indicator-position="outside" arrow="always" :interval="5000" height="380px">
				<el-carousel-item v-for="item in imgList" :key="item" style="text-align: center;">
				  	<img :src="item" width="580px" height="330px" style="margin-top: 25px;">
				</el-carousel-item>
	  		</el-carousel>
		</div>
		<showDetail ref="showDetail"></showDetail>
	</div>
</template>	
<script>
import * as ARTICLE_API from '@/api/admin/article.js'
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
        	imgList: [
	          "/managersystem/images/lunbo1.jpg",
	          "/managersystem/images/lunbo2.jpg",
	          "/managersystem/images/lunbo3.jpg",
	        ],
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
    },
};
</script>

<style scoped>
.mainBody{
	background-color:#f0f0f0;
	width: 98%;
	height:95%;
	margin: 20px;
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
	margin-top: 50px;
	float: right;
}
.card2{
	position: absolute;
	display: inline;
	float: right;
	margin-left: 750px;
	margin-top: 340px;
}
.card3{
	width: 700px;
	height: 600px;
	position: absolute;
	margin-left: 20px;
	margin-top: 30px;
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