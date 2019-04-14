<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="添加项目经验" width="55%" append-to-body >
	    <div class="dialog-edit">
	      	<!-- 添加了校验规则 -->
	      	<el-form :inline="true" :model="form" ref="formName" :rules="rules" label-width="150px">
	      		<el-form-item label="项目名称:" prop="projectName">
	      			<el-input v-model="form.projectName"></el-input>
	      		</el-form-item>
	      		<el-form-item label="项目时间:" prop="projectDate">
	      			<el-date-picker
					    v-model="form.projectDate"
					    type="daterange"
					    value-format="yyyy-MM-dd"
					    range-separator="至"
					    start-placeholder="开始日期"
					    end-placeholder="结束日期">
				    </el-date-picker>
	      		</el-form-item>
	      		<el-form-item label="项目描述:" prop="projectDescription">
	      			<el-input type="textarea" v-model="form.projectDescription" :rows="6"  :autosize="{ minRows: 6, maxRows: 8}"></el-input>
	      		</el-form-item>
	      		<el-form-item label="个人职责:" prop="personalResponsibility">
	      			<el-input type="textarea" v-model="form.personalResponsibility" :rows="6"  :autosize="{ minRows: 6, maxRows: 8}"></el-input>
	      		</el-form-item>
	      		<el-form-item label="所属公司:" prop="companyName">
	      			<el-input v-model="form.companyName"></el-input>
	      		</el-form-item>
	      	</el-form>
	      	<!-- 最后是按钮，（不要放在 form 里面） -->
		    <div class="dialog-edit__btnGroup" slot="footer">
		        <el-button type="primary" @click="btnClick">确认</el-button>
		        <el-button @click="dialogVisible = false">取消</el-button>
		    </div>
	    </div>
	</el-dialog>
</template>

<script>
export default{
	data(){
		return{
			dialogVisible:false,
			form:{
				projectName:'毕业生就业管理系统',
				projectDate:'',
				projectDescription:'滑水',
				personalResponsibility:'打酱油',
				companyName:'博恒',
			},
			rules:{
				projectName:[
					{ required: true, message: '请输入项目名称', trigger: 'blur' },
				],
				projectDate:[
					{ required: true, message: '请选择项目时间', trigger: 'blur' },
				],
				projectDescription:[
					{ required: true, message: '请输入项目描述', trigger: 'blur' },
				],
				personalResponsibility:[
					{ required: true, message: '请输入个人职责', trigger: 'blur' },
				],
				companyName:[
					{ required: true, message: '请输入公司名称', trigger: 'blur' },
				],
			},
		}
	},
	watch: {
      dialogVisible(value) {
        if (!value) {
          this.beforeClose();
        }
      },
    },
	methods:{
		show(){
			this.dialogVisible = true;
		},
		btnClick(){
			this.$refs['formName'].validate((valid) =>{
				if(valid){
					this.$emit('show',JSON.parse(JSON.stringify(this.form)));
					this.$message.success('添加成功');
				}else {//校验失败
	              	return false;
				}
				this.dialogVisible = false;
			});
		},
		beforeClose(){
			this.$refs['formName'].resetFields();
	        // 推送关闭消息
	        this.$emit('closed');
		},
	},
}
</script>

<style>
</style>