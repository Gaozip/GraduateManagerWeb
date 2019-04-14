<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="简历" width="55%" append-to-body >
	    <div class="dialog-edit">
	    	<dl>
	    		<dt>基本信息</dt>
	    		<div class="box">
	    			<div class="box1">
	    				<span class="lab">【招收职位】{{tableData.position}}({{tableData.jobNature}})</span>
	    				<br />
	    				<span class="lab">【工作地点】{{tableData.workPlace}}</span>
	    				<br />
	    				<span class="lab">【学历要求】{{tableData.education}}</span>
		    		</div>
		    		<div class="box2">
		    			<span class="lab">【薪资】{{tableData.monthSalary}}</span>
		    			<br />
		    			<span class="lab">【招收人数】{{tableData.recruitNum}}</span>
		    			<br />
		    			<span class="lab">【工作经验】{{tableData.workExperience}}</span>
		    		</div>
	    		</div>
	    		<br />
	    		<dt>工作内容</dt>
	    		<div>
	    			<span class="lab">{{tableData.jobContent}}</span>
	    		</div>
	    		<dt>任职要求</dt>
	    		<div>
	    			<span class="lab">{{tableData.qualification}}</span>
	    		</div>
	    		<dt>公司介绍</dt>
	    		<div>
	    			<span class="lab">{{employerInfo.companyProfile}}</span>
	    		</div>
	    	</dl>
	    </div>
	</el-dialog>
</template>

<script>
export default{
	data(){
		return{
			dialogVisible:false,
			tableData:[],
			employerInfo:'',
		}
	},
	methods:{
		show(scope){
			this.dialogVisible = true;
			console.info(scope);
			this.tableData = scope;
			this.employerInfo = scope.employerInfo;
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
.box{
	display: flex;
	line-height:33px;
}
.box1,.box2{
	flex: 2;
	font-size: 14px;
}
.box1{
	padding-left: 5px;
}
</style>