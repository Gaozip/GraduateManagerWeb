<template>
    <el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="公司信息" width="55%" append-to-body >
        <div class="dialog-edit">
            <dl>公司信息</dl>
            <div class="box">
                <div class="box1">
                    <span class="lab">【公司名称】{{employerInfo.companyName}}</span>
                    <br />
                    <span class="lab">【成立时间】{{employerInfo.registerDate | dateFmt('YYYY-MM-DD') }}</span>
                    <br />
                    <span class="lab">【公司类型】{{employerInfo.companyType}}</span>
                    <br />
                    <span class="lab">【员工人数】{{employerInfo.employerNum}}</span>
                    <br />
                    <span class="lab">【所属行业】{{employerInfo.industry}}</span>
                </div>
                <div class="box2">
                    <span class="lab">【组织机构代码】:{{employerInfo.organizationCode}}</span>
                    <br />
                    <span class="lab">【法人代表】{{employerInfo.legalRepresentative}}</span>
                    <br />
                    <span class="lab">【经营状态】{{employerInfo.managementForms}}</span>
                    <br />
                    <span class="lab">【注册资本】{{employerInfo.registerCapital}}</span>
                    <br />
                    <span class="lab">【电话热线】{{employerInfo.hotLine}}</span>
                </div>
            </div>
            <br />
            <hr />
            <dt>公司简介</dt>
            <div>
                {{employerInfo.companyProfile}}
            </div>
            <br />
            <hr />
            <dt>经营范围</dt>
            <div>
                {{employerInfo.scopeOfBusiness}}
            </div>
        </div>
        <div class="dialog-edit__btnGroup" slot="footer">
            <el-button @click="dialogVisible = false">关闭</el-button>
        </div>
    </el-dialog>
</template>

<script>
    export default {
        components: {},
        data() {
            return {
                dialogVisible:false,
                employerInfo:{},
            }
        },
        mounted() {
            
        },
        watch: {
            
        },
        methods: {
            show(data){
                this.employerInfo = data;
                this.dialogVisible = true;
            }
        }
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