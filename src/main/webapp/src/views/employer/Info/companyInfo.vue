<template>
    <div class="companyInfo">
        <el-form :inline="true" :model="form" ref="formName">
            <table class="tab-app" align="center">
                <tr>
                    <td colspan="6" class="item">公司信息</td>
                </tr>
                <tr>
                    <td class="item">公司名称</td>
                    <td>{{form.companyName}}</td>
                    <td class="item">组织机构代码</td>
                    <td>{{form.organizationCode}}</td>
                    <td class="item">成立时间</td>
                    <td>{{form.registerDate | dateFmt('YYYY-MM-DD')}}</td>
                </tr>
                <tr>
                    <td class="item">法人代表</td>
                    <td>{{form.legalRepresentative}}</td>
                    <td class="item">公司类型</td>
                    <td>{{form.companyType}}</td>
                    <td class="item">经营状态</td>
                    <td>{{form.managementForms}}</td>
                </tr>
                <tr>
                    <td class="item">员工人数</td>
                    <td>{{form.employerNum}}</td>
                    <td class="item">注册资本</td>
                    <td>{{form.registerCapital}}</td>
                    <td class="item">所属行业</td>
                    <td>{{form.industry}}</td>
                </tr>
                <tr>
                    <td class="item">电话热线</td>
                    <td>{{form.hotLine}}</td>
                    <td class="item">公司地址</td>
                    <td>{{form.companyAddress}}</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="item" height="80px">公司简介</td>
                    <td colspan="5" height="80px">{{form.companyProfile}}</td>
                </tr>
                <tr>
                    <td class="item" height="80px">经营范围</td>
                    <td colspan="5" height="80px">{{form.scopeOfBusiness}}</td>
                </tr>
            </table>
        </el-form>
    </div>
</template>

<script>
    import * as EMPLOYER_API from '@/api/employer/employer.js';
    export default {
        data(){
            return{
                forEdit:false,
                form:{
                },
            }
        },
        mounted(){
            this.fetchData();
        },
        methods:{
            fetchData(){
                EMPLOYER_API.api(EMPLOYER_API.URL_GET_EMPLOYER_INFO_BY_ID,{}).then(data =>{
                    this.form = data.datas;
                    if(this.form.isValid == '0'){
                        this.$confirm('请先到修改资料中填写基本资料!', '提示', {
                            type: 'warning'
                        })
                    }
                });
            },
        },
    }
</script>

<style scoped>
    table.tab-app{
        width: 85%;
        margin: 7% auto;
        text-align: center;
        font-family: verdana,arial,sans-serif;
        font-size:11px;
        color:#333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
    }
    table.tab-app th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }
    table.tab-app td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }
    table .item{
        font-weight: bold;
    }
</style>