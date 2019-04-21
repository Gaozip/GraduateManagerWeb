<template>
    <div class="dictItem">
        <div class="menu">
            <el-menu :default-active="menuActive">
                <el-menu-item index="字典列表" @click="menuClick(-1)">
                    <i class="el-icon-document"></i>
                    <span slot="title" class="root">字典列表</span>
                </el-menu-item>
                <el-menu-item :index="item.value" v-for="item in dictList" @click="menuClick(item.key)">
                    <span slot="title">{{item.value}}</span>
                </el-menu-item>
            </el-menu>
        </div>
        <div class="rightBody">
            <el-form :inline="true" :model="searchForm" ref="formName">
                <div class="search-bar">
                    <el-form-item label="元素名称" prop="itemName">
                        <el-input v-model="searchForm.itemName" @keyup.enter.native="fetchTableData"></el-input>
                    </el-form-item>
                    <el-form-item label="元素编码" prop="itemCode" @keyup.enter.native="fetchTableData">
                        <el-input v-model="searchForm.itemCode"></el-input>
                    </el-form-item>
                    <el-button type="primary"  plain style="margin-top: 5px;"@click="doSearch">查询</el-button>
                    <el-button type="success"  plain style="margin-top: 5px;" @click="$refs.add.show()">新增</el-button>
                </div>
                <div class="table-wrap">
                    <el-table :data="tableData" border stripe style="width: 100%">
                        <el-table-column  label="操作" width="135px" :show-overflow-tooltip="true">
                            <template slot-scope="scope">
                                <el-button type="text" @click="$refs.edit.show(scope.row)">修改</el-button>
                                <el-button type="text" @click="doDelete(scope.row.pkDictItemId)">删除</el-button>
                            </template>
                        </el-table-column>
                        <el-table-column type="index" label="序号" width="70px"></el-table-column>
                        <el-table-column prop="itemName" label="元素名称"></el-table-column>
                        <el-table-column prop="itemCode" label="元素编码"></el-table-column>
                        <el-table-column prop="itemVal" label="元素值"></el-table-column>
                        <el-table-column prop="dictType" label="元素分类"></el-table-column>
                        <el-table-column prop="isValid" label="是否启用">
                            <template slot-scope="scope">
                                <label v-show="scope.row.isValid == '1'">是</label>
                                <label v-show="scope.row.isValid == '0'">否</label>
                            </template>
                        </el-table-column>
                        <el-table-column prop="remark" label="备注"></el-table-column>
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
                    <Add ref="add" @closed="fetchTableData"></Add>
                    <Edit ref="edit" @closed="fetchTableData"></Edit>
                </div>
            </el-form>
        </div>
    </div>
</template>

<script>
    import * as DICT_ITEM_API from '@/api/admin/dictItem.js'
    import * as DICT_API from '@/api/admin/dict.js'
    import Add from './add.vue'
    import Edit from './edit.vue'
    export default {
        components: {
            Add,Edit,
        },
        data() {
            return {
                menuActive:'字典列表',
                dictList:[],
                tableData:[],
                tableDataClone:[],
                searchForm:{
                    itemName:'',
                    itemCode:'',
                },
                // 分页
                currentPage: 1,
                pageSize: 10,
                totalNum: 0,
                // 默认分页数量
                defaultPageSize: 0,
            }
        },
        mounted() {
            this.fetchDictType();
            this.fetchTableData();
        },
        watch: {
            
        },
        methods: {
            fetchDictType(){
                this.dictList = [];
                DICT_API.api(DICT_API.URL_QUERY_ALL_DICT,{}).then(data =>{
                    data.datas.forEach(item =>{
                        this.dictList.push({key:item.pkDictId,value:item.dictName});
                    });
                });  
            },
            doSearch(){
                this.currentPage = 1;
                let param = {
                    itemName: this.searchForm.itemName,
                    itemCode: this.searchForm.itemCode,
                };
                this.tableDataClone = Object.assign(param,{});
                this.fetchTableData();
            },
            menuClick(id){
                this.currentPage = 1;

                if(id == -1){
                    this.tableDataClone = {};
                }else{
                    let param = {
                        pkDictId: id,
                    };
                    this.tableDataClone = Object.assign(param,{});
                }
                this.fetchTableData();
            },
            fetchTableData(){
                let param = {
                    pageNo: this.currentPage,
                    pageSize: this.pageSize,
                };
                Object.assign(param,this.tableDataClone);
                DICT_ITEM_API.api(DICT_ITEM_API.URL_QUERY_PAGE,param).then(data =>{
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
            doDelete(id){
                this.$confirm('确认删除？').then(_ => {
                    DICT_ITEM_API.api(DICT_ITEM_API.URL_DO_DELETE,{pkDictItemId:id,}).then(data =>{
                        this.$message.success('删除成功');
                        this.fetchTableData();
                    });
                }).catch(_ => {});
            },
        }
    }
</script>

<style scoped>
    .dictItem{
        display: flex;
        width:  100%;
        height: 100%;
    }
    .menu{
        flex: 2;
        height: 100%;
        border: 1px solid #d1d1d1;
    }.rightBody{
        flex: 12;
        height: 100%;
    }
     .menu >>> .el-menu-item{
         border: 1px solid #d1d1d1;
     }
    .menu >>> .el-menu-item, .el-submenu__title{
        height:45px;
        line-height: 40px;
    }
    .menu >>> .el-menu-item.is-active {
        color: #3d56ce;
    }
    .menu >>> el-menu-item:focus, .el-menu-item:hover {
        outline: 0;
        background-color: #e0e0e0;
    }
    
</style>