<template>
  <header>
  	<div class="system-name">毕业生就业管理系统</div>
    <div class="hearder-tools">
    	<el-dropdown  @command="handleCommand">
	    	<span class="el-dropdown-link">
	    		<div class="hello-message" style="color: white;">
                    <a href="javascript:void(0)">
                        <img class="headImage" :src="headPath" v-show="headPath != null" @click="$refs.changeHeadImage.show()"/>
                        <img class="headImage" src="/upload/defaultHeadImg.jpg" v-show="headPath == null" @click="$refs.changeHeadImage.show()"/>
                    </a>
                    <label style="padding-left: 45px">你好，{{adminName}}</label>
                </div>
	    	</span>
	    	<el-dropdown-menu slot="dropdown">
	    		<el-dropdown-item command="a">修改用户名</el-dropdown-item>
	    		<el-dropdown-item command="b">修改密码</el-dropdown-item>
	    		<el-dropdown-item command="c">更换头像</el-dropdown-item>
	    	</el-dropdown-menu>
      </el-dropdown>

      <div class="logout" @click="showLogOut">
        <div><i class="iconfont icon-logout"></i>注销</div>
      </div>
      <changeUserName ref="changeUserName"></changeUserName>
      <changePassword ref="changePassword"></changePassword>
      <changeHeadImage ref="changeHeadImage" @closed="getUserName()"></changeHeadImage>
    </div>
  </header>

</template>

<script>
  import person from "../../../assets/icon/person.png";
  import * as LOGIN_API from '@/api/user/login.js';
  import changeUserName from '../changeUserInfo/changeUserName.vue'
  import changePassword from '../changeUserInfo/changePassword.vue'
  import changeHeadImage from '../changeUserInfo/changeHeadImage.vue'

  export default {
    name: "Header",
    components:{
    	changeUserName,changePassword,changeHeadImage,
    },
    data() {
      return {
      	ctxPath,
        person,
        adminName:'',
        headPath:'',
      };
    },
    created() {
     	this.getUserName();
    },
    methods: {
    	getUserName(){
    		let param = {};
    		LOGIN_API.api(LOGIN_API.URL_USER_NAME,param).then(data =>{
    			this.adminName = data.datas.userName;
    			this.headPath = data.datas.headPath;
    		});
    	},
      showLogOut() {
        this.$confirm('确定注销吗?', '提示').then(() => {
        	let param = {};
            LOGIN_API.loginOut(param).then(data =>{
                window.location.href = ctxPath + "/";
            });
        });
      },
      handleCommand(command){
      	if(command ==='a'){
      		this.$refs.changeUserName.show(this.adminName);
      	}else if(command ==='b'){
      		this.$refs.changePassword.show();
      	}else if(command ==='c'){
      		this.$refs.changeHeadImage.show();
      	}
      	
      },
    }
  };
</script>

<style scoped>
    .hello-message{
        margin-right: 30px;
        text-align: center;
    }
    .system-name{
        font-family: "楷体";
    }
    .headImage{
        border-radius:50px;
        width: 35px;
        height: 35px;
        position: absolute;
        margin-top: 8px;
        margin-right: 10px;
    }

</style>
