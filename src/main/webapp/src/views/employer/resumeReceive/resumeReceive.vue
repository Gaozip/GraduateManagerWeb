<template>
    <el-form :inline="true" :model="searchForm" ref="formName" >
        <div class="search-bar">
            <el-form-item label="招聘编号">
                <el-select v-model="searchForm.fkRecruitmentId">
                    <el-option v-for="item in idList" :label="item.key+'-'+item.value" :value="item.key"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="简历编号">
                <el-input v-model="searchForm.fkResumeId"></el-input>
            </el-form-item>
            <el-button type="success" plain @click="doSearch">查询</el-button>
        </div>
        <div class="table-wrap">
            <el-table :data="tableData" border stripe style="width: 100%">
                <el-table-column  label="操作" width="165px" :show-overflow-tooltip="true">
                    <template slot-scope="scope">
                        <el-button type="text" @click="$refs.showResume.show(scope.row.resume,scope.row.pkGerId,'employer')">查看简历</el-button>
                        <el-button type="text" @click="$refs.showRecruitment.show(scope.row.recruitment,'employer')">查看招聘信息</el-button>
                    </template>
                </el-table-column>
                <el-table-column type="index" label="序号" width="60px"></el-table-column>
                <el-table-column prop="resume.graduateInfo.name" label="姓名"></el-table-column>
                <el-table-column prop="resume.graduateInfo.sex" label="性别"></el-table-column>
                <el-table-column label="出生年月">
                    <template slot-scope="scope">
                        {{scope.row.resume.graduateInfo.birthday | dateFmt('YYYY-MM-DD')}}
                    </template>
                </el-table-column>
                <el-table-column prop="resume.graduateInfo.graduateCollege" label="毕业院校"></el-table-column>
                <el-table-column prop="resume.graduateInfo.education" label="学历"></el-table-column>
                <el-table-column prop="resume.graduateInfo.dept" label="系别"></el-table-column>
                <el-table-column prop="resume.graduateInfo.specialty" label="专业"></el-table-column>
                <el-table-column label="入学时间">
                    <template slot-scope="scope">
                        {{scope.row.resume.graduateInfo.inDate | dateFmt('YYYY-MM-DD')}}
                    </template>
                </el-table-column>
                <el-table-column label="投递时间">
                    <template slot-scope="scope">
                        {{scope.row.sendTime | dateFmt('YYYY-MM-DD')}}
                    </template>
                </el-table-column>
                <el-table-column label="通过时间">
                    <template slot-scope="scope">
                        {{scope.row.resultTime | dateFmt('YYYY-MM-DD')}}
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination-bar">
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
            <ShowResume ref="showResume"></ShowResume>
            <ShowRecruitment ref="showRecruitment"></ShowRecruitment>
        </div>
    </el-form>
</template>

<script>
    import ShowResume from '@/views/graduate/resume/show/showResume.vue'
    import ShowRecruitment from '@/views/employer/recruitment/show/showRecruitment.vue'
    import * as GERINFO_API from '@/api/employer/gerInfo.js'
    export default {
        components: {ShowResume,ShowRecruitment, },
        data() {
            return {
                searchForm:{
                    fkResumeId:'',
                    fkRecruitmentId:'',
                },
                searchFormClone:{},
                idList:[],
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
            this.fetchPkRecruitmentList();
        },
        watch: {
            
        },
        methods: {
            fetchTableData(){
                let param = {
                    pageNo: this.currentPage,
                    pageSize: this.pageSize,
                };
                Object.assign(param,this.searchFormClone);
                GERINFO_API.api(GERINFO_API.URL_QUERY_RESUME_RECEIVE,param).then(data =>{
                    this.tableData = data.datas.datas;
                    this.totalNum = data.datas.totalNum;
                    this.currentPage = data.datas.pageNo;
                });
            },
            doSearch(){
                this.currentPage = 1;
                let param = {
                    fkResumeId: this.searchForm.fkResumeId,
                    fkRecruitmentId: this.searchForm.fkRecruitmentId,
                };
                this.searchFormClone = Object.assign(param,{});
                this.fetchTableData();
            },
            fetchPkRecruitmentList(){
                GERINFO_API.api(GERINFO_API.URL_QUERY_RECRUITMENT_LIST,{}).then(data =>{
                    data.datas.forEach(item =>{
                        this.idList.push({key:item.PK_RECRUITMENT_ID,value:item.POSITION});
                    });
                });
            },
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
        }
    }
</script>

<style scoped>

</style>