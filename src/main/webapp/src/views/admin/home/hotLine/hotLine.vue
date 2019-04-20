<template>
    <div class="hotLine">
        <fieldset style=" border-radius: 20px;padding: 20px">
            <legend>服务热线编辑</legend>
            <el-form  :model="form" ref="formName" :rules="rules" label-position>
                <el-form-item label="客服" prop="customerServiceTel">
                    <el-input v-model="form.customerServiceTel"></el-input>
                </el-form-item>
                <el-form-item label="手机" prop="mobilePhone">
                    <el-input v-model="form.mobilePhone"></el-input>
                </el-form-item>
                <el-form-item label="电话" prop="telephone">
                    <el-input v-model="form.telephone"></el-input>
                </el-form-item>
                <el-form-item label="服务邮箱" prop="serviceEmail">
                    <el-input v-model="form.serviceEmail"></el-input>
                </el-form-item>
                <el-form-item label="服务地址" prop="serviceAddress">
                    <el-input v-model="form.serviceAddress"></el-input>
                </el-form-item>
            </el-form>
            <el-button type="primary" style="width: 100%;border-radius: 10px" @click="btnClick">确认</el-button>
        </fieldset>
    </div>
</template>

<script>
    import * as ADMIN_API from '@/api/admin/home.js'
    export default {
        components: {},
        data() {
            return {
                form:{
                    customerServiceTel:'400-885-9898',//客服电话
                    mobilePhone:'12345678901',//手机
                    telephone:'010-58635888-',//电话
                    serviceEmail:'crmnoreply@zhaopin.com.cn',//邮箱
                    serviceAddress:'仓山区挖不倒',//服务地址
                },
                rules:{
                    customerServiceTel:[
                        { required: true, message: '请填写客服电话', trigger: 'blur' },
                    ],
                    mobilePhone:[
                        { required: true, message: '请填写手机号', trigger: 'blur' },
                    ],
                    telephone:[
                        { required: true, message: '请填写电话', trigger: 'blur' },
                    ],
                    serviceEmail:[
                        { required: true, message: '请填写服务邮箱', trigger: 'blur' },
                    ],
                    serviceAddress:[
                        { required: true, message: '请填写服务地址', trigger: 'blur' },
                    ],
                },
            }
        },
        mounted() {
            this.fetchData();
        },
        watch: {
            
        },
        methods: {
            fetchData(){
                ADMIN_API.api(ADMIN_API.URL_QUERY_HOT_LINE_INFO,{}).then(data =>{
                    console.info(data);
                });
            },
            btnClick(){
                this.$refs['formName'].validate((valid) => {
                    if (valid) {
                        let param = {
                            customerServiceTel: this.form.customerServiceTel,//客服电话
                            mobilePhone: this.form.mobilePhone,//手机
                            telephone: this.form.telephone,//电话
                            serviceEmail: this.form.serviceEmail,//邮箱
                            serviceAddress: this.form.serviceAddress,//服务地址
                        };
                        ADMIN_API.api(ADMIN_API.URL_DO_SAVE_HOT_LINE_INFO,param).then(data =>{
                            console.info(data);
                        });
                    }
                });
            },
        }
    }
</script>

<style scoped>
.hotLine{
    width:60%;
    margin: 5% auto;
    font-size: 20px;
    padding: 20px;
    background-color: #f0f0f0;
}
</style>