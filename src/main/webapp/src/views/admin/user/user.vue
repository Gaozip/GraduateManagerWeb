<template>
	<div class="user">
        <FuzzySearch placeholder="输入关键字进行搜索" ref="fuzzy" @fuzzyClick="fuzzyClick" width="350px" >
            <template slot="prepend">
                <el-button type="primary" plain @click="$refs.addAdminUser.show()">新增管理员用户</el-button>
            </template>
            <el-form :inline="true" :model="searchForm" ref="formName">
                <div class="search-bar">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="searchForm.username"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱" prop="email">
                        <el-input v-model="searchForm.email"></el-input>
                    </el-form-item>
                    <el-form-item label="用户角色" prop="role">
                        <el-select v-model="searchForm.role">
                            <el-option value="0" label="管理员"></el-option>
                            <el-option value="1" label="毕业生"></el-option>
                            <el-option value="2" label="用人单位"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="激活状态" prop="state">
                        <el-radio-group v-model="searchForm.state" size="small">
                            <el-radio label="1" border>已激活</el-radio>
                            <el-radio label="0" border>未激活</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="账号状态" prop="isValid">
                        <el-radio-group v-model="searchForm.isValid" size="small">
                            <el-radio label="1" border>正常</el-radio>
                            <el-radio label="0" border>封号</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="注册时间" prop="registerTime">
                        <el-date-picker  v-model="searchForm.registerStartTime" type="date" placeholder="选择日期"></el-date-picker>
                        -
                        <el-date-picker  v-model="searchForm.registerEndTime" type="date" placeholder="选择日期"></el-date-picker>
                    </el-form-item>
                    <el-form-item label="激活时间" prop="activeTime">
                        <el-date-picker  v-model="searchForm.activeStartTime" type="date" placeholder="选择日期"></el-date-picker>
                        -
                        <el-date-picker  v-model="searchForm.activeEndTime" type="date" placeholder="选择日期"></el-date-picker>
                    </el-form-item>
                    <el-button type="primary" @click="doSearch">查询</el-button>
                </div>
            </el-form>
        </FuzzySearch>
        <div class="table-wrap">
            <el-table :data="tableData" border stripe style="width: 100%">
                <el-table-column  label="操作" width="130px" :show-overflow-tooltip="true">
                    <template slot-scope="scope">
                        <el-button type="text" v-show="scope.row.state == '0'" @click="changeStatus('1','',scope.row.pkUserId)">激活</el-button>
                        <el-button type="text" v-show="scope.row.isValid == '1' && scope.row.role != '0'" @click="changeStatus('','0',scope.row.pkUserId)">封号</el-button>
                        <el-button type="text" v-show="scope.row.isValid == '0' && scope.row.role != '0'" @click="changeStatus('','1',scope.row.pkUserId)">解封</el-button>
                    </template>
                </el-table-column>
                <el-table-column type="index" label="序号" width="60px"></el-table-column>
                <el-table-column prop="username" label="用户名" show-overflow-tooltip ></el-table-column>
                <el-table-column prop="role" label="用户角色" show-overflow-tooltip >
                    <template slot-scope="scope">
                        <label v-show="scope.row.role == '0'">管理员</label>
                        <label v-show="scope.row.role == '1'">毕业生</label>
                        <label v-show="scope.row.role == '2'">用人单位</label>
                    </template>                    
                </el-table-column>
                <el-table-column prop="email" label="邮箱" show-overflow-tooltip></el-table-column>
                <el-table-column prop="state" label="激活状态" show-overflow-tooltip >
                    <template slot-scope="scope">
                        <img v-show="scope.row.state == '0'" src="@/assets/icon/ico_gj_red.png" height="13" width="13"/>
                        <label v-show="scope.row.state == '1'">已激活</label>
                        <label v-show="scope.row.state == '0'">未激活</label>
                    </template>
                </el-table-column>
                <el-table-column prop="isValid" label="账号状态" show-overflow-tooltip >
                    <template slot-scope="scope">
                        <img v-show="scope.row.isValid == '0'" src="@/assets/icon/ico_gj_red.png" height="13" width="13"/>
                        <label v-show="scope.row.isValid == '1'">正常</label>
                        <label v-show="scope.row.isValid == '0'">封号</label>
                    </template>
                </el-table-column>
                <el-table-column prop="registerTime" label="注册时间" show-overflow-tooltip>
                    <template slot-scope="scope">
                        {{scope.row.registerTime | dateFmt('YYYY-MM-DD HH:mm:ss')}}
                    </template>
                </el-table-column>
                <el-table-column prop="activeTime" label="激活时间" show-overflow-tooltip>
                    <template slot-scope="scope">
                        {{scope.row.activeTime | dateFmt('YYYY-MM-DD HH:mm:ss')}}
                    </template>
                </el-table-column>
                <el-table-column prop="unActiveTime" label="未激活持续时间" show-overflow-tooltip>
                    <template slot-scope="scope">
                        <label>{{scope.row.unActiveTime}}</label>
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
        </div>
        <addAdminUser ref="addAdminUser" @closed="fetchTableData"></addAdminUser>
    </div>
</template>

<script>
    import FuzzySearch from '@/components/fuzzySearch/fuzzySearch.vue';
    import * as USER_API from '@/api/admin/user.js'
    import * as tools from '@/assets/tools';
    import addAdminUser from './addAdminUser.vue'
    export default{
    components:{
        FuzzySearch, addAdminUser,
    },
	data(){
		return{
			searchForm:{
                username:'',
                email:'',
                role:'',
                state:'',
                isValid:'',
                registerStartTime:'',
                registerEndTime:'',
                activeStartTime:'',
                activeEndTime:'',
                unActiveTime:'',
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
    mounted(){
        this.fetchTableData();
    },
	methods:{
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
            USER_API.api(USER_API.URL_QUERY_USER_PAGE,param).then(data =>{
               
                this.totalNum = data.datas.totalNum;
                this.currentPage = data.datas.pageNo;
                data.datas.datas.forEach(item =>{
                    
                    if(item.state == '1'){
                        item.unActiveTime = '--';
                    }else{
                        var sdate = new Date(item.registerTime);
                        var now = new Date();
                        var days = now.getTime() - sdate.getTime();
                        var day = parseInt(days / (1000 * 60 * 60 * 24));
                        item.unActiveTime = day+'天';
                    }
                });
                this.tableData = data.datas.datas;
            });
        },
        // 模糊搜索
        fuzzyClick(fuzzyWord) {
            this.currentPage = 1;
            let param = {
                FUZZY_WORD: fuzzyWord,
            };
            this.searchFormClone = Object.assign(param, {});
            this.fetchTableData();
        },
        doSearch(){
            this.currentPage = 1;
            var registerStartTime = '';
            var registerEndTime = '';
            var activeStartTime = '';
            var activeEndTime = '';
            if(this.searchForm.registerStartTime != '' && this.searchForm.registerStartTime != null){
                registerStartTime = tools.transformTime(this.searchForm.registerStartTime, 'YYYY-MM-DD 00:00:00');
            }
            if(this.searchForm.registerEndTime != '' && this.searchForm.registerEndTime != null){
                registerEndTime = tools.transformTime(this.searchForm.registerEndTime, 'YYYY-MM-DD 23:59:59');
            }
            if(this.searchForm.activeStartTime != '' && this.searchForm.activeStartTime != null){
                activeStartTime = tools.transformTime(this.searchForm.activeStartTime, 'YYYY-MM-DD 00:00:00');
            }
            if(this.searchForm.activeEndTime != '' && this.searchForm.activeEndTime != null){
                activeEndTime = tools.transformTime(this.searchForm.activeEndTime, 'YYYY-MM-DD 23:59:59');
            }
            let param = {
                username: this.searchForm.username,
                email:this.searchForm.email,
                role:this.searchForm.role,
                state:this.searchForm.state,
                isValid:this.searchForm.isValid,
                registerStartTime:registerStartTime,
                registerEndTime:registerEndTime,
                activeStartTime:activeStartTime,
                activeEndTime:activeEndTime,
            };
            this.searchFormClone = Object.assign(param, {});
            this.fetchTableData();
        },
        changeStatus(state,valid,pkId){
            let param = {
                state: state,
                isValid: valid,
                pkUserId: pkId,
            };
            USER_API.api(USER_API.URL_DO_UPDATE_USER_STATE,param).then(data =>{
                this.$message.success('修改成功');
                this.fetchTableData();
            });
        },
	},
}
</script>

<style>
</style>