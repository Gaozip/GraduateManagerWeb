<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="项目经验" width="45%" append-to-body >
	    <div class="dialog-edit">
	    	<ol>
			    <li v-for="item in projectList">
			    	<fieldset>
			    		<legend>{{item.projectName}}</legend>
			    		<dl>
			    			<dt>项目时间:</dt>
			    			<span class="lab">{{item.projectDate}}</span>
			    		
				      		<dt>项目描述:</dt>
				      		<span class="lab">{{item.projectDescription}}</span>
				      		
				      		<dt>个人职责:</dt>
				      		<span class="lab">{{item.personalResponsibility}}</span>
				      		
				      		<dt>所属公司:</dt>
				      		<span class="lab">{{item.companyName}}</span>
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
			projectList:[],
		}
	},
	methods:{
		show(scope){
			this.dialogVisible = true;
			this.projectList = scope.projectList;
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
	padding:5px;
}
.lab{
	padding-left: 40px;
}
</style>