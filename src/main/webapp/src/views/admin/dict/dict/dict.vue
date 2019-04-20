<template>
    <el-form :inline="true" :model="searchForm" ref="formName">
        <div class="search-bar">
            <el-form-item label="字典名称" prop="dictName">
                <el-input v-model="searchForm.dictName" @keyup.enter.native="fetchTableData"></el-input>
            </el-form-item>
            <el-form-item label="字典编码" prop="dictCode" @keyup.enter.native="fetchTableData">
                <el-input v-model="searchForm.dictCode"></el-input>
            </el-form-item>
            <el-button type="primary"  plain style="margin-top: 5px;"@click="fetchTableData">查询</el-button>
            <el-button type="success"  plain style="margin-top: 5px;" @click="$refs.add.show()">新建</el-button>
        </div>
        <div class="table-wrap">
            <el-table :data="tableData" border stripe style="width: 100%">
                <el-table-column prop="pkResumeId" label="操作" width="135px" :show-overflow-tooltip="true">
                    <template slot-scope="scope">
                        <el-button type="text">修改</el-button>
                        <el-button type="text" >删除</el-button>
                    </template>
                </el-table-column>
                <el-table-column type="index" label="序号" width="70px"></el-table-column>
                <el-table-column prop="pkDictId" label="字典编号"></el-table-column>
                <el-table-column prop="dictName" label="字典名称"></el-table-column>
                <el-table-column prop="dictCode" label="字典编码"></el-table-column>
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
            <Add ref="add"></Add>
            <Edit ref="edit"></Edit>
        </div>
    </el-form>
</template>

<script>
    import Add from './add.vue'
    import Edit from './edit.vue'
    export default {
        components: {
            Add, Edit,
        },
        data() {
            return {
                searchForm:{
                    dictName:'',
                    dictCode:'',
                },
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
            
        },
        watch: {
            
        },
        methods: {
            fetchTableData(){
                
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