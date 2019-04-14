<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="修改密码" width="35%" append-to-body >
	    <div class="dialog-edit">
	      	<!-- 添加了校验规则 -->
	      	<el-form :inline="true" :model="form" ref="formName" :rules="rules" label-width="150px">
	      		<div class="inputI">
	      			<el-form-item label="旧密码:" prop="password">
		      			<el-input type="password" v-model="form.password"></el-input>
		      		</el-form-item>
		      		<el-form-item label="新密码:" prop="newPassword">
		      			<el-input type="password" v-model="form.newPassword"></el-input>
		      		</el-form-item>
		      		<el-form-item label="确认密码:" prop="rePassword">
						<el-input type="password" v-model="form.rePassword"></el-input>		      			
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
		var EqualsPassword = (rule, value, callback) =>{
			var reg = /^(\w){6,20}$/;
			if(!reg.test(value)){
            	callback(new Error('只能输入6-20个字母、数字、下划线!'));
            }
			else if(this.form.newpassword != '' && (this.form.newPassword != this.form.rePassword)){
				callback(new Error('输入的密码不一致'));
			}
			else{
				callback();
			}
		};
		return{
			dialogVisible:false,
			form:{
				password:'',
				newPassword:'',
				rePassword:'',
			},
			rules:{
				password:[
					{ required: true, message: '请输入旧密码', trigger: 'blur' },
		            {
		              pattern: /^(\w){6,20}$/,
		              message: '只能输入6-20个字母、数字、下划线',
		              trigger: 'blur'
		            }
				],
				newPassword:[
					{ required: true, message: '请输入新密码', trigger: 'blur' },
		            {
		              pattern: /^(\w){6,20}$/,
		              message: '只能输入6-20个字母、数字、下划线',
		              trigger: 'blur'
		            }
				],
				rePassword:[
					{ required: true, message: '请输入新密码', trigger: 'blur'},
		            { validator: EqualsPassword, trigger: 'blur'},
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
					let param = {
						'password': this.form.password,
						'newPassword': this.form.newPassword,
						'rePassword': this.form.rePassword,
					};
					AXIOS.api('/user/changePassword',param).then(data =>{
						this.$message.success('修改成功');
					});
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
	}
}
</script>

<style>
.inputI{
	position: relative;
	padding-left: 5px;
}
</style>