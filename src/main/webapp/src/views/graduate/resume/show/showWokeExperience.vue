<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="项目经验" width="45%" append-to-body >
	    <div class="dialog-edit">
	    	<ol>
			    <li v-for="item in workList">
			    	<fieldset>
			    		<legend>公司名称:&nbsp;&nbsp;&nbsp;{{item.companyName}}</legend>
			    		<dl>
			    		
				      		<dt>所属行业:</dt>
				      		<span class="lab">{{item.industry}}</span>
				      		
				      		<dt>职位名称:</dt>
				      		<span class="lab">{{item.jobIntension}}</span>
				      		
				      		<dt>工作性质:</dt>
				      		<span class="lab">{{item.jobType}}</span>
				      		
				      		<dt>在职时间:</dt>
				      		<span class="lab">{{item.workDate}}</span>
				      		
				      		<dt>税前薪资:</dt>
				      		<span class="lab">{{item.monthSalary}}元/月</span>
				      		
				      		<dt>工作描述:</dt>
				      		<span class="lab">{{item.jobDescription}}</span>
			      		</dl>
			    	</fieldset>
			    	<br />
			    	<br />
			    </li>
			  </ol>
	    </div>
	</el-dialog>
</template>

<script>
export default{
	data(){
		return{
			dialogVisible:false,
			workList:[],
		}
	},
	methods:{
		show(scope){
			this.dialogVisible = true;
			this.workList = scope.workList;
		},
		btnClick(){
			
		},
	},
}
</script>

<style scoped>
dt {
    margin: 8px 0;
    padding-left: 14px;
    font-size: 14px;
    color: #333;
    border-left: 4px solid #108cee;
    display: block;
    margin-top: 15px;
}
dl{
	padding:15px;
}
.lab{
	padding-left: 40px;
}
</style>