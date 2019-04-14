<template>
	<el-dialog :visible.sync="dialogVisible" title="用户注册" width="750px" :close-on-click-modal=false> <!--点击外部不关闭弹窗-->
		<div class="dialog-edit">
			<!-- 添加了校验规则 -->
			<el-form :inline="true" :model="form" ref="formName" :rules="rule" >

				<!--注册账号密码-->
				<div class="form-row">
					<div class="zero">
						<el-form-item label="注册角色：" prop="role">
							<el-radio v-model="form.role" label="1">毕业生</el-radio>
							<el-radio v-model="form.role" label="2">用人单位</el-radio>
						</el-form-item>
					</div>
					<div class="one">
						<el-form-item label="用户名：" prop="username">
							<el-input  v-model="form.username" placeholder="请输入用户名"/>
						</el-form-item>
					</div>

					<div class="two">
						<el-form-item label="密码：" prop="password">
							<el-input type="password"  v-model="form.password" placeholder="请输入密码" />
						</el-form-item>
					</div>
					<div class="three">
						<el-form-item label="确认密码：" prop="password2">
							<el-input  type="password"  v-model="form.password2" placeholder="请再次输入密码"/>
						</el-form-item>
					</div>
					<div class="four">
						<el-form-item label="邮箱：" prop="email">
							<el-input type="text"  v-model="form.email" placeholder="请输入邮箱地址"/>
						</el-form-item>
					</div>
				</div>
			</el-form>
			<br />
			<!--/////////////////////////////////////////////定海神针/////////////////////////////////////////////////-->
			<!-- 最后是按钮，（不要放在 form 里面） -->
			<div class="dialog-edit__btnGroup" slot="footer">
				<el-button type="primary"
						   :plain="true"
						   @click="btnClick"
				>确认</el-button>
				<el-button  @click="dialogVisible = false">取消</el-button>
			</div>
		</div>
	</el-dialog>
</template>

<script>
	import * as REGISTER_API from '@/api/user/register.js';

	export default{
		data(){
			var IsRegisterByUserName = (rule, value, callback) => {
				if(this.form.username != '' && this.form.username != null){
					let param = {
						'userName':this.form.username,
						'email':'',
					};
					REGISTER_API.api(REGISTER_API.URL_USER_IS_REGISTER,param).then(data =>{
						if(data.datas.num != '0'){
							callback(new Error("该用户名已被注册!"));
						}else{
							callback();
						}
					});
				}else{
					callback();
				}
			};
			var IsRegisterByEmail = (rule, value, callback) =>{
				if(this.form.email != '' && this.form.email != null){
					let param = {
						'username':'',
						'email':this.form.email,
					};
					REGISTER_API.api(REGISTER_API.URL_USER_IS_REGISTER,param).then(data =>{
						if(data.datas.num != '0'){
							callback(new Error("该邮箱已被注册!"));
						}else{
							callback();
						}
					});
				}else{
					callback();
				}
			};
			var EqualsPassword = (rule, value, callback) =>{
				var reg = /^(\w){6,20}$/;
				if(!reg.test(value)){
					callback(new Error('只能输入6-20个字母、数字、下划线!'));
				}
				else if(this.form.password != '' && (this.form.password != this.form.password2)){
					callback(new Error('输入的密码不一致'));
				}
				else{
					callback();
				}
			};
			return{
				dialogVisible: false,	//窗口默认不显示
				form:{
					username:'',
					password:'',
					password2:'',
					role:'1',	//0:管理员  1：毕业生 2：用人单位
					email:'',
				},
				rule:{
					username:[
						{ required: true, message: '请填写用户名', trigger: 'blur' },
						{ pattern: /^[a-zA-Z_\u4e00-\u9fa5][a-zA-Z0-9_\u4e00-\u9fa5]{1,12}$/, message: '非数字开头1-16个字符,数字,下划线', trigger: 'blur' },
						{ validator: IsRegisterByUserName, trigger: 'blur'},
					],
					password:[
						{ required: true, message: '请填写密码', trigger: 'blur' },
						{
							pattern: /^(\w){6,20}$/,
							message: '只能输入6-20个字母、数字、下划线',
							trigger: 'blur'
						}
					],
					password2:[
						{ required: true, message: '请填写密码', trigger: 'blur'},
						{ validator: EqualsPassword, trigger: 'blur'},
					],
					email:[
						{ required: true, message: '请输入邮箱地址', trigger: 'blur' },
						{ type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur'},
						{ validator: IsRegisterByEmail, trigger: 'blur'},
					],
				},
			}
		},
		watch: {	//窗口关闭前清空数据
			dialogVisible(value) {
				if (!value) {
					this.beforeClose();
				}
			},
		},
		methods:{
			show() {
				this.dialogVisible = true;
			},
			btnClick(){
				this.$refs['formName'].validate((valid) =>{
					if(valid){
						//开始注册
						let param= {
							username:this.form.username,
							password:this.form.password,
							role:this.form.role,
							email:this.form.email,
						};
						REGISTER_API.api(REGISTER_API.UEL_USER_OD_SAVE,param).then(resp =>{
							this.$message({
								message: "注册申请成功，请登录所填邮箱进行账号激活！",
								type: "success"
							});
							this.dialogVisible = false;
						});
					}else {//校验失败
						return false;
					}
				});

			},// 关闭前操作，一般要进行数据清空
			beforeClose() {
				// ref 根据实际修改
				this.$refs['formName'].resetFields();
				// 推送关闭消息
				this.$emit('closed');
			},
		}
	}
</script>

<style>
	.el-input {
		width:220px;
	}
	.dialog-edit__btnGroup,.reBtn{
		text-align: center;
	}
	.el-radio+.el-radio{
		margin-left: 20px;
	}
	.el-form-item__label{
		line-height: 13px;
	}
	.el-form-item{
		margin-bottom:20px;
	}
	.el-input--suffix .el-input__inner,.el-input--suffix .el-input__inner{
		padding-right: 0px;
	}
	.el-input__inner{
		width: 90%;
		height: 34px;
		border: 1px solid #0a469c;
		border-radius: 6px;
		box-shadow: none;
		background-color: transparent;
		font-size: 14px;
		color: #666;
		padding-left:15px;
	}
	.el-form-item__error{
		left:10px;
	}
	.form-row{
		margin-top: 10px;
		text-align: center;
	}
	.login label {
		display: inline;
	}
	.two{
		padding-left: 14px;
	}
	.three{
		padding-right: 12px;
	}
	.four{
		padding-left: 18px;
	}
	#msg{
		position:relative;
		padding-left: 380px;

		color: red;
	}
	#onepone{
		position:relative;
		padding-top: 10px;
	}

</style>