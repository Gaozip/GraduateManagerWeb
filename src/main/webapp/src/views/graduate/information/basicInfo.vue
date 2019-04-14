<template>
	<div class="basicInfo">
		<el-form :inline="true" :model="form" ref="formName">
			<table class="tab-app" align="center">
				<tr>
					<td colspan="6" class="item">基本信息</td>
				</tr>
				<tr>
					<td class="item">学号</td>
					<td>{{form.sno}}</td>
					<td class="item">姓名</td>
					<td>{{form.name}}</td>
					<td class="item">性别</td>
					<td>{{form.sex}}</td>
				</tr>
				<tr>
					<td class="item">出生年月</td>
					<td>{{form.birthday | dateFmt('YYYY-MM-DD')}}</td>
					<td class="item">民族</td>
					<td>{{form.nation}}</td>
					<td class="item">籍贯</td>
					<td>{{form.province+form.city}}</td>
				</tr>
				<tr>
					<td class="item">政治面貌</td>
					<td>{{form.politicalStatus}}</td>
					<td class="item">电话</td>
					<td>{{form.tel}}</td>
					<td class="item">QQ</td>
					<td>{{form.qq}}</td>
				</tr>
				<tr>
					<td class="item">微信</td>
					<td>{{form.wchat}}</td>
					<td class="item">入学时间</td>
					<td>{{form.inDate | dateFmt('YYYY-MM-DD')}}</td>
					<td class="item">系别</td>
					<td>{{form.dept}}</td>
				</tr>
				<tr>
					<td class="item">专业</td>
					<td>{{form.specialty}}</td>
					<td class="item">教育背景</td>
					<td>{{form.education}}</td>
					<td class="item">毕业院校</td>
					<td>{{form.graduateCollege}}</td>
				</tr>
				<tr>
					<td class="item">有无工作</td>
					<td>
						<label v-show="form.haveJob == '1'">有</label>
						<label v-show="form.haveJob == '0'">无</label>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="6" class="item">就业信息</td>
				</tr>
				<tr>
					<td class="item">公司名称</td>
					<td>{{form.companyName}}</td>
					<td class="item">入职时间</td>
					<td>{{form.getJobTime | dateFmt('YYYY-MM-DD')}}</td>
					<td class="item">所属行业</td>
					<td>{{form.industry}}</td>
				</tr>
				<tr>
					<td class="item">职位</td>
					<td>{{form.position}}</td>
					<td class="item">月薪</td>
					<td>{{form.monthSalary}}</td>
					<td class="item">工作经验</td>
					<td>{{form.workYear}}</td>
				</tr>
			</table>
		</el-form>
	</div>
</template>

<script>
	import * as GRADUATE_API from '@/api/graduate/graduate.js';
	export default {
		data(){
			return{
				forEdit:false,
				form:{
				},
			}
		},
		mounted(){
			this.fetchData();
		},
		methods:{
			fetchData(){
				GRADUATE_API.api(GRADUATE_API.URL_QUERY_BASIC_INFO_BY_ID,{}).then(data =>{
					this.form = data.datas;
					if(this.form.sno == null){
						this.$confirm('请先到修改资料中填写基本资料!', '提示', {
							type: 'warning'
						})
					}
				});
			},
		},
	}
</script>

<style scoped>
	table.tab-app{
		width: 85%;
		margin-top: 40px;
		text-align: center;
		font-family: verdana,arial,sans-serif;
		font-size:11px;
		color:#333333;
		border-width: 1px;
		border-color: #666666;
		border-collapse: collapse;
	}
	table.tab-app th {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #666666;
		background-color: #dedede;
	}
	table.tab-app td {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #666666;
		background-color: #ffffff;
	}
	table .item{
		font-weight: bold;
	}
</style>