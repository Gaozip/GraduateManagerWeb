<template>
  <div class="login">
    <div class="login-form">
      <div class="login-form-title"><img :src="ctxPath + '/images/denglu2_wz.png'"></div>
      <div class="login-input-row">
        <label>用户名：</label>
        <input
          v-model="userName"
          id="userName"
          class="login-input"
          placeholder="请输入用户名"
          ref="userNameInput"
          @keyup.enter="$refs.pwdInput.focus()"/>
      </div>
      <div class="login-input-row password">
        <label>密码：</label>
        <input
          type="password"
          v-model="password"
          id="password"
          class="login-input"
          placeholder="请输入密码"
          ref="pwdInput"
          @keyup.enter="$refs.vCodeInput.focus()" />
      </div>
      <div class="login-checkCode">
      		<label id="verityCode">验证码：</label>
      		<input type="text" 
      					 v-model="verityCode"
      					 ref="vCodeInput"
      					 maxlength="4"
      					 placeholder="请输入验证码"
      					 id="vCode"
      					 @keyup.enter="doLogin()"/>
      		<img id="codeImg" ref="vCode" @click="changeCode()" src="/managersystem/verityCodeExt" />
      </div>
      <div>
        <el-checkbox v-model="rmbUser">记住用户名</el-checkbox>
      </div>
      <div class="login-btn-row">
        <el-button @click="doLogin()">登录</el-button>
      </div>
      <div class="login-btn-row">
        <el-button @click="$refs.reg.show()">注册</el-button>
      </div>
    </div>
    <Reg ref="reg"></Reg>
  </div>
</template>

<script>
  import * as LOGIN_API from './api/user/login.js';
  import Reg from "./views/register/register.vue";
  export default {
    components: {Reg},
    data() {
      return {
        ctxPath,
        rmbUser: false,
      	userName: '李四',
      	password: '111111',
      	verityCode: '',
      };
    },
    created() {
      const rmbUser = window.localStorage.getItem('rmbUser');
      if (rmbUser == 'true') {
        this.rmbUser = true;
        this.userName = window.localStorage.getItem('userName');
      }
    },
    mounted() {
      if (this.userName == '') {
        this.$refs.userNameInput.focus();
      }
    },
    methods: {
  		doLogin() {
  			var param = {
  				'userName': this.userName,
  				'password': this.password,
  				'verityCode':this.verityCode,
  			};
  			LOGIN_API.api(LOGIN_API.URL_DO_LOGIN,param).then(resp => {
                  const userName = this.rmbUser ? this.userName : '';
                  window.localStorage.setItem('userName', userName);
                  window.localStorage.setItem('rmbUser', this.rmbUser);
                  window.location.href = ctxPath + "/home";
             });
  		},
  		changeCode(){
  			this.$refs.vCode.src=this.$refs.vCode.src+"?"+Math.random();
  		},
  	}
  };
</script>

<style scoped>
	.login-checkCode{
		height:35px;
		margin-top: 25px;
	}
	.login-form{
		margin-right:-30px
	}
	.login label {
		display: block;
	}
	#verityCode{
		display: inline;
		padding: 14px 0 10px;
		font-size: 14px;
	}
	#vCode{
		width: 97px;
    height: 34px;
    border: 1px solid #0a469c;
    border-radius: 6px;
    box-shadow: none;
    background-color: transparent;
    font-size: 14px;
    padding-left: 5px;
    color: #666;
	}
	#codeImg{
		position: absolute;
		padding-left: 2px;
		border-radius: 6px;
	}
</style>