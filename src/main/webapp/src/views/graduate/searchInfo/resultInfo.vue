<template>
    <div class="table-wrap" style="margin-top: 5%">
        <el-table :data="tableData" border stripe style="width: 100%">
            <el-table-column prop="pkResumeId" label="操作" width="185px" :show-overflow-tooltip="true">
                <template slot-scope="scope">
                    <el-button type="text" @click="$refs.showResume.show(scope.row.resume,scope.row.pkGerId,'')">查看简历</el-button>
                    <el-button type="text" @click="$refs.showRecruitment.show(scope.row.recruitment,'')">查看招聘信息</el-button>
                </template>
            </el-table-column>
            <el-table-column type="index" label="序号" width="70px"></el-table-column>
            <el-table-column prop="recruitment.employerInfo.companyName" label="公司名称" width="130"></el-table-column>
            <el-table-column prop="recruitment.employerInfo.industry" label="所属行业"></el-table-column>
            <el-table-column prop="" label="注册资本">
                <template slot-scope="scope">
                    {{scope.row.recruitment.employerInfo.registerCapital}}万
                </template>
            </el-table-column>
            <el-table-column prop="pkResumeId" label="是否通过">
                <template slot-scope="scope">
                    <label v-show="scope.row.result == '1'">通过</label>
                    <label v-show="scope.row.result != '1'">未答复</label>
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
        <ShowResume ref="showResume"></ShowResume>
        <ShowRecruitment ref="showRecruitment"></ShowRecruitment>
    </div>
</template>

<script>
    import * as GERINFO_API from '@/api/employer/gerInfo.js'
    import ShowResume from '@/views/graduate/resume/show/showResume.vue'
    import ShowRecruitment from '@/views/employer/recruitment/show/showRecruitment.vue'
    export default {
        components: {ShowResume,ShowRecruitment},
        data() {
            return {
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
                GERINFO_API.api(GERINFO_API.URL_QUERY_RESULT_PAGE,param).then(data =>{
                    this.tableData = data.datas.datas;
                    this.totalNum = data.datas.totalNum;
                    this.currentPage = data.datas.pageNo;
                });
            },
        }
    }
</script>

<style scoped>

</style>