<template>
    <el-form :inline="true" :model="searchForm" ref="formName" :rules="rules">
        <div class="search-bar">
            <el-form-item label="年级" prop="grade">
                <el-date-picker
                        v-model="searchForm.grade"
                        type="year"
                        placeholder="选择年份">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="系别" prop="dept">
                <el-select v-model="searchForm.dept" class="dept" @change="deptChange(searchForm.dept)">
                    <el-option v-for="item in deptList" :key="item.value" :value="item.value" :label="item.value"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="专业" prop="specialty">
                <el-select v-model="searchForm.specialty" class="specialty">
                    <el-option v-for="item in specialtyList" :key="item.value" :value="item.value" :label="item.value"></el-option>
                </el-select>
            </el-form-item>
            <el-button type="primary"  plain style="margin-top: 5px;"@click="fetchData">查询</el-button>
        </div>
        <div class="body">
            <div class="left_">
                <h1>就业率</h1>
                <el-progress type="circle" :percentage="totalRate" :width="200" style="margin: 30px"></el-progress>
            </div>
            <div class="right_">
                <h1>在职学生数量:{{jobNum}}</h1>
                <h1>学生总数:{{totalNum}}</h1>
            </div>
            
        </div>
    </el-form>
</template>

<script>
    import * as JOBRATE_API from '@/api/admin/jobRate.js'
    import * as tools from '@/assets/tools';

    export default {
        components: {},
        data() {
            return {
                jobNum:'',//有工作学生数量
                totalNum:'',//学生总数
                totalRate:0,//就业率
                searchForm:{
                    grade:'2015',
                    dept:'',
                    specialty:'',
                },
                deptList:[
                    {label:"经济系",value:"经济系"},
                    {label:"文法系",value:"文法系"},
                    {label:"管理系",value:"管理系"},
                    {label:"会计系",value:"会计系"},
                    {label:"信息工程系",value:"信息工程系"},
                    {label:"艺术设计系",value:"艺术设计系"},
                ],
                specialtyList:[],
                rules: {
                    grade: [
                        {required: true, message: '请选择年级', trigger: 'blur'},
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
                this.$refs['formName'].validate((valid) => {
                    if (valid) {
                        var grade = '';
                        if(this.searchForm.grade != null && this.searchForm.grade != ''){
                            grade = tools.transformTime(this.searchForm.grade, 'YYYY');
                        }
                        let param = {
                            grade: grade,
                            dept: this.searchForm.dept,
                            specialty: this.searchForm.specialty,
                        };
                        JOBRATE_API.api(JOBRATE_API.URL_QUERY_JOB_RATE, param).then(data => {
                            this.jobNum = data.datas.JOBNUM;
                            this.totalNum = data.datas.TOTALNUM;
                            this.totalRate = data.datas.TOTALRATE;
                        });
                    }
                });
            },
            doSearch(){
                
            },
            deptChange(deptName){
                this.specialtyList = [];
                if(deptName != ""){
                    if(deptName == "经济系"){
                        this.specialtyList.push({value:"国际经济与贸易"}, {value:"金融学"}, {value:"投资学"},);
                    }
                    if(deptName == "文法系"){
                        this.specialtyList.push({value:"英语"}, {value:"商务英语"}, {value:"广告"}, {value:"法学"},);
                    }
                    if(deptName == "管理系"){
                        this.specialtyList.push({value:"工商管理"},{value:"人力资源管理"}, {value:"旅游管理"}, {value:"物流管理"},);
                    }
                    if(deptName == "会计系"){
                        this.specialtyList.push({value:"会计学"}, {value:"财务管理"},);
                    }
                    if(deptName == "信息工程系"){
                        this.specialtyList.push({value:"计算机科学与技术"}, {value:"电子信息工程"}, {value:"网络工程"}, {value:"软件工程"}, {value:"电子商务"},);
                    }
                    if(deptName == "艺术设计系"){
                        this.specialtyList.push({value:"风景园林"}, {value:"产品设计"}, {value:"环境设计"}, {value:"视觉传达设计"}, {value:"城乡规划学"}, {value:"工程管理"}, {value:"工程造价"},);
                    }
                }
            },
        }
    }
</script>

<style scoped>
    .body{
        display: flex;
        width: 80%;
        height:80%;
        margin: 3% auto;
        background-color: #f4efff;
        border-radius: 20px;
    }
    .left_{
        padding-top: 3%;
        flex: 5;
        text-align: center;
        border: 1px solid black;
        border-radius: 20px;
    }
    .right_{
        padding-top: 10%;
        padding-left: 8%;
        flex: 2;
        border: 1px solid black;
        border-radius: 20px;
    }
    
    
</style>