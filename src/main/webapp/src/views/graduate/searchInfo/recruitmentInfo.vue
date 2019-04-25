<template>
    <el-form :inline="true" :model="searchForm" ref="formName" >
        <div class="search-bar">
            <FuzzySearch placeholder="输入关键字进行搜索" @fuzzyClick="fuzzyClick" width="300px">
                <el-form-item label="招收职位">
                    <el-input v-model="searchForm.position"></el-input>
                </el-form-item>
                <el-form-item label="月工资" >
                    <el-input v-model="searchForm.monthSalary"></el-input>
                </el-form-item>
                <el-form-item label="工作地点">
                    <v-distpicker hide-area @selected="setNativePlace" :province="searchForm.province" :city="searchForm.city"></v-distpicker>
                </el-form-item>
                <el-form-item label="工作性质">
                    <el-select v-model="searchForm.jobNature">
                        <el-option value="实习生"></el-option>
                        <el-option value="正式员工"></el-option>
                        <el-option value="兼职"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="学历要求">
                    <el-select v-model="searchForm.education">
                        <el-option value="高中/中技/中专"></el-option>
                        <el-option value="大专"></el-option>
                        <el-option value="本科"></el-option>
                        <el-option value="硕士"></el-option>
                        <el-option value="MBA"></el-option>
                        <el-option value="博士"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="工作经验">
                    <el-select v-model="searchForm.workExperience">
                        <el-option value="暂无"></el-option>
                        <el-option value="1年及以上"></el-option>
                        <el-option value="2年及以上"></el-option>
                        <el-option value="3年及以上"></el-option>
                        <el-option value="4年及以上"></el-option>
                        <el-option value="5年及以上"></el-option>
                        <el-option value="6年及以上"></el-option>
                        <el-option value="7年及以上"></el-option>
                        <el-option value="8年及以上"></el-option>
                        <el-option value="9年及以上"></el-option>
                        <el-option value="10年及以上"></el-option>
                    </el-select>
                </el-form-item>
            </FuzzySearch>
        </div>
        <div class="table-wrap">
            <el-table :data="tableData" border stripe style="width: 100%">
                <el-table-column  label="操作" width="135px" :show-overflow-tooltip="true">
                    <template slot-scope="scope">
                        <el-button type="text" @click="$refs.showRecruitment.show(scope.row,'graduate')">查看</el-button>
                    </template>
                </el-table-column>
                <el-table-column type="index" label="序号" width="60px"></el-table-column>
                <el-table-column prop="employerInfo.companyName" label="公司名称" show-overflow-tooltip width="120px"></el-table-column>
                <el-table-column prop="position" label="招聘职位" show-overflow-tooltip width="120px"></el-table-column>
                <el-table-column prop="monthSalary" label="月薪" show-overflow-tooltip width="80px"></el-table-column>
                <el-table-column prop="workPlace" label="工作地点" show-overflow-tooltip width="180px">
                    <template slot-scope="scope">
                        {{scope.row.province + scope.row.city}}
                    </template>
                </el-table-column>
                <el-table-column prop="jobNature" label="工作性质" show-overflow-tooltip width="100px"></el-table-column>
                <el-table-column prop="recruitNum" label="招收人数" show-overflow-tooltip width="80px"></el-table-column>
                <el-table-column prop="education" label="学历要求" show-overflow-tooltip width="120px"></el-table-column>
                <el-table-column prop="workExperience" label="工作经验" show-overflow-tooltip width="120px"></el-table-column>
                <el-table-column prop="jobContent" label="工作内容" show-overflow-tooltip width="150px"></el-table-column>
                <el-table-column prop="qualification" label="任职要求" show-overflow-tooltip width="150px"></el-table-column>
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
            <ShowRecruitment ref="showRecruitment"></ShowRecruitment>
        </div>
    </el-form>
</template>

<script>
    import FuzzySearch from '@/components/fuzzySearch/fuzzySearch.vue';
    import VDistpicker from 'v-distpicker'
    import * as QUERY_INFO from '@/api/graduate/queryInfo.js';
    import ShowRecruitment from '@/views/employer/recruitment/show/showRecruitment.vue';
    export default {
        components: {FuzzySearch,VDistpicker,ShowRecruitment,},
        data() {
            return {
                searchForm:{
                    position:'',
                    monthSalary:'',
                    province:'',
                    city:'',
                    jobNature:'',
                    education:'',
                    workExperience:'',
                },
                searchFormClone:{},
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
            fuzzyClick(fuzzyWord) {   //模糊查询
                this.currentPage = 1;
                let param = {
                    FUZZY_WORD:fuzzyWord,
                };
                this.searchFormClone = Object.assign(param,{});
                this.fetchTableData();
            },
            doSearch(){ //高级查询
                this.currentPage = 1;
                let param = {
                    position: this.searchForm.position,
                    monthSalary: this.searchForm.monthSalary,
                    province: this.searchForm.province,
                    city: this.searchForm.city,
                    jobNature: this.searchForm.jobNature,
                    education: this.searchForm.education,
                    workExperience: this.searchForm.workExperience,
                };
                this.searchFormClone = Object.assign(param,{});
                this.fetchTableData();
            },
            fetchTableData(){
                let param = {
                    pageNo: this.currentPage,
                    pageSize: this.pageSize,
                };
                Object.assign(param,this.searchFormClone);
                QUERY_INFO.api(QUERY_INFO.URL_QUERY_RECRUITMENT_INFO,param).then(data =>{
                    this.tableData = data.datas.datas;
                    this.totalNum = data.datas.totalNum;
                    this.currentPage = data.datas.pageNo;
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
            setNativePlace(value){
                this.form.province = value.province.value;
                this.form.city = value.city.value;
            },
        }
    }
</script>

<style scoped>

</style>