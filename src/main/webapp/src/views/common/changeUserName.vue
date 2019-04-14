<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="修改用户名" width="35%" append-to-body >
	    <div class="dialog-edit">
	      	<!-- 添加了校验规则 -->
	      	<el-form :inline="true" :model="form" ref="formName" :rules="rules" label-width="150px">
	      		<div class="inputI">
	      			<el-form-item label="用户名:" prop="userName">
		      			<el-input v-model="form.userName"></el-input>
		      		</el-form-item>
	      		</div>
	      		
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
import * as AXIOS from '@/api/axios.js';
	
export default{
	data(){
		var IsRegisterByUserName = (rule, value, callback) => {
			if(this.form.userName != '' && this.form.userName != null){
				let param = {
		    		'userName':this.form.userName,
		    		'email':'',
		    	};
		    	AXIOS.api('/user/IsRegister',param).then(data =>{
		    		if(data.datas.flag == 'false'){
		    			callback(new Error(data.datas.msg));
		    		}else{
		    			callback();
		    		}
				});
			}else{
				callback();
			}
		};
		return{
			dialogVisible:false,
			form:{
				userName:'',
			},
			rules:{
				userName:[
					{ required: true, message: '请输入用户名', trigger: 'blur' },
					{ pattern: /^[a-zA-Z_\u4e00-\u9fa5][a-zA-Z0-9_\u4e00-\u9fa5]{1,12}$/, message: '非数字开头1-16个字符,数字,下划线', trigger: 'blur' },
					{ validator: IsRegisterByUserName, trigger: 'blur'},
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
		show(name){
			this.form.userName = name;
			this.dialogVisible = true;
		},
		btnClick(){
			this.$refs['formName'].validate((valid) =>{
				if(valid){
					AXIOS.api('/user/changeUserName',{'userName':this.form.userName,}).then(data =>{
						this.$message.success('修改成功');
						this.dialogVisible = false;
					});
				}else {//校验失败
	              	return false;
				}
				
			});
			
		},
		beforeClose(){
			this.$refs['formName'].resetFields();
	        // 推送关闭消息
	        this.$emit('closed');
		},
	}
}
</script>

<style>
.inputI{
	position: relative;
	padding-left: 5px;
}
</style>