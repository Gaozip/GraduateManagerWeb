
<template>
    <el-form :inline="true" :model="searchForm" ref="formName">
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
            <el-button type="primary"  plain style="margin-top: 5px;" @click="doSearch">查询</el-button>
        </div>
        <div class="table-wrap">
            <el-table :data="tableData" border stripe style="width: 100%">
                <el-table-column type="index" label="序号" width="70px"></el-table-column>
                <el-table-column prop="sno" label="学号" width="140px"></el-table-column>
                <el-table-column prop="name" label="姓名"></el-table-column>
                <el-table-column prop="sex" label="性别"></el-table-column>
                <el-table-column prop="inDate" label="年级"></el-table-column>
                <el-table-column prop="dept" label="系别"></el-table-column>
                <el-table-column prop="specialty" label="专业"></el-table-column>
                <el-table-column prop="haveJob" label="有无工作">
                    <template slot-scope="scope">
                        <label v-show="scope.row.haveJob == '1'">有</label>
                        <label v-show="scope.row.haveJob == '0'">无</label>
                    </template>
                </el-table-column>
                <el-table-column prop="companyName" label="公司名称"></el-table-column>
                <el-table-column prop="monthSalary" label="月薪"></el-table-column>
            </el-table>
            <div class="pagination-bar" v-show="tableData.length > 0">
                <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="currentPage"
                        :page-sizes="[defaultPageSize, 10, 20, 40]"
                        :page-size="pageSize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="totalNum">
                </el-pagination>
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
                searchForm:{
                    grade:'',
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
                searchFormClone:[],
                tableData: [],
                // 分页
                currentPage: 1,
                pageSize: 10,
                totalNum: 0,
                // 默认分页数量
                defaultPageSize: 0,
            }
        },
        mounted() {
            this.fetchTableData();
        },
        watch: {

        },
        methods: {
            // 修改每页显示条数
            handleSizeChange(value) {
                this.currentPage = 1;
                this.pageSize = value;
                this.fetchTableData();
            },
            // 修改当前页
            handleCurrentChange(value) {
                this.currentPage = value;
                this.fetchTableData();
            },
            fetchTableData(){
                let param = {
                    pageNo: this.currentPage,
                    pageSize: this.pageSize,  
                };
                Object.assign(param,this.searchFormClone);
                JOBRATE_API.api(JOBRATE_API.URL_QUERY_STUDENT_INFO,param).then(data =>{
                    this.tableData = data.datas.datas;
                    this.totalNum = data.datas.totalNum;
                    this.currentPage = data.datas.pageNo;
                });
            },
            doSearch(){
                this.currentPage = 1;
                var grade = '';
                if(this.searchForm.grade != null && this.searchForm.grade != ''){
                    grade = tools.transformTime(this.searchForm.grade, 'YYYY');
                }
                let param = {
                    grade:grade,
                    dept:this.searchForm.dept,
                    specialty:this.searchForm.specialty,
                };
                this.searchFormClone = Object.assign(param,{});
                this.fetchTableData();
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

</style>