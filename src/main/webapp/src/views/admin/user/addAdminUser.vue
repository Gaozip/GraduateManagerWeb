<template>
    <el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="新增管理员用户" width="30%" append-to-body >
        <div class="dialog-edit">
            <!-- 添加了校验规则 -->
            <el-form :inline="true" :model="form" ref="formName" :rules="rules" >
                <div class="dialog-edit__row dialog-edit__row--long">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="用户名" prop="username">
                            <el-input v-model="form.username"></el-input>
                        </el-form-item>
                    </div>
                </div>
                <div class="dialog-edit__row dialog-edit__row--long">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="密码" prop="password">
                            <el-input v-model="form.password"></el-input>
                        </el-form-item>
                    </div>
                </div>
                <div class="dialog-edit__row dialog-edit__row--long">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="确认密码" prop="password2">
                            <el-input v-model="form.password2"></el-input>
                        </el-form-item>
                    </div>
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
    import * as REGISTER_API from '@/api/user/register.js';
    
    export default {
        components: {},
        data() {
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
            return {
                dialogVisible: false,
                form:{
                    username:'',
                    password:'',
                    password2:'',
                },
                rules:{
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
                },
            }
        },
        mounted() {
            
        },
        watch: {
            dialogVisible(value) {
                if (!value) {
                    this.beforeClose();
                }
            },
        },
        methods: {
            show(){
                this.dialogVisible = true;
            },
            btnClick(){
                this.$refs['formName'].validate((valid) => {
                    if (valid) {
                        let param = {
                            username: this.form.username,
                            password: this.form.password,
                        };
                        REGISTER_API.api(REGISTER_API.URL_REGISTER_ADMIN_USER, param).then(data => {
                            this.$message({
                                message: "注册成功！",
                                type: "success"
                            });
                            this.dialogVisible = false;
                        });
                    }
                });
            },
            beforeClose() {
                // ref 根据实际修改
                this.$refs['formName'].resetFields();
                // 推送关闭消息
                this.$emit('closed');
            },
        }
    }
</script>

<style scoped>

</style>