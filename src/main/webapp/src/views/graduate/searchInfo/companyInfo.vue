<template>
    <el-form :inline="true" :model="searchForm" ref="formName" >
        <div class="search-bar">
            <FuzzySearch placeholder="输入关键字进行搜索" @fuzzyClick="fuzzyClick" width="300px">
                <el-form-item label="公司名称" prop="resumeName">
                    <el-input v-model="searchForm.companyName" @keyup.enter.native="doSearch"></el-input>
                </el-form-item>
                <el-form-item label="组织结构代码">
                    <el-input v-model="searchForm.organizationCode"></el-input>
                </el-form-item>
                <el-form-item label="法人代表">
                    <el-input v-model="searchForm.legalRepresentative"></el-input>
                </el-form-item>
                <el-form-item label="公司类型">
                    <el-select v-model="searchForm.companyType" placeholder="请选择">
                        <el-option value="内资企业"></el-option>
                        <el-option value="国有企业"></el-option>
                        <el-option value="集体企业"></el-option>
                        <el-option value="股份合作企业"></el-option>
                        <el-option value="联营企业"></el-option>
                        <el-option value="有限责任公司"></el-option>
                        <el-option value="股份有限公司"></el-option>
                        <el-option value="私营企业"></el-option>
                        <el-option value="其他企业"></el-option>
                        <el-option value="港、澳、台商投资企业"></el-option>
                        <el-option value="合资经营企业（港或澳、台资）"></el-option>
                        <el-option value="合作经营企业（港或澳、台资）"></el-option>
                        <el-option value="港、澳、台商独资经营企业"></el-option>
                        <el-option value="港、澳、台商投资股份有限公司"></el-option>
                        <el-option value="外商投资企业"></el-option>
                        <el-option value="中外合资经营企业"></el-option>
                        <el-option value="中外合作经营企业"></el-option>
                        <el-option value="外商投资股份有限公司"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="所属行业">
                    <el-select v-model="searchForm.industry" placeholder="请选择">
                        <el-option value="互联网/电子商务"></el-option>
                        <el-option value="计算机软件"></el-option>
                        <el-option value="IT服务(系统/数据/维护)"></el-option>
                        <el-option value="电子技术/半导体/集成电路"></el-option>
                        <el-option value="计算机硬件"></el-option>
                        <el-option value="通信/电信/网络设备"></el-option>
                        <el-option value="通信/电信运营、增值服务"></el-option>
                        <el-option value="网络游戏"></el-option>
                        <el-option value="基金/证券/期贷/投资"></el-option>
                        <el-option value="保险"></el-option>
                        <el-option value="IT|通信|电子|互联网"></el-option>
                        <el-option value="银行"></el-option>
                        <el-option value="金融业"></el-option>
                        <el-option value="信托/担保/拍卖/典当"></el-option>
                        <el-option value="房地产|建筑业"></el-option>
                        <el-option value="房地产/建筑/建材/工程"></el-option>
                        <el-option value="商业服务"></el-option>
                        <el-option value="家居/室内设计/装饰装潢"></el-option>
                        <el-option value="贸易|批发|零售|租赁业"></el-option>
                        <el-option value="物业管理/商业中心"></el-option>
                        <el-option value="文体教育|工艺美术"></el-option>
                        <el-option value="专业服务/咨询(财会/法律/人力资源等)"></el-option>
                        <el-option value="服务业"></el-option>
                        <el-option value="广告/会展/公关"></el-option>
                        <el-option value="文化|传媒|娱乐|体育"></el-option>
                        <el-option value="中介服务"></el-option>
                        <el-option value="生产|加工|制造"></el-option>
                        <el-option value="检验/检测/认证"></el-option>
                        <el-option value="交通|运输|物流|仓储"></el-option>
                        <el-option value="外包服务"></el-option>
                        <el-option value="能源|矿产|环保"></el-option>
                        <el-option value="快速消费品(食品/饮料/烟酒/日化)"></el-option>
                        <el-option value="政府|非营利机构"></el-option>
                        <el-option value="耐用消费品(服饰/纺织/皮革/家具/家电)"></el-option>
                        <el-option value="农|林|牧|渔|其他"></el-option>
                        <el-option value="贸易/进出口"></el-option>
                        <el-option value="零售/批发"></el-option>
                        <el-option value="租赁服务"></el-option>
                        <el-option value="教育/培训/院校"></el-option>
                        <el-option value="礼品/玩具/工艺美术/收藏品/奢侈品"></el-option>
                        <el-option value="汽车/摩托车"></el-option>
                        <el-option value="大型设备/机电设备/重工业"></el-option>
                        <el-option value="加工制造(原料加工/模具)"></el-option>
                        <el-option value="仪器仪表及工业自动化"></el-option>
                        <el-option value="印刷/包装/造纸"></el-option>
                        <el-option value="办公用品及设备"></el-option>
                        <el-option value="医药/生物工程"></el-option>
                        <el-option value="医疗设备/机械"></el-option>
                        <el-option value="航空/航天研究与制造"></el-option>
                        <el-option value="交通/运输"></el-option>
                        <el-option value="物流/仓储"></el-option>
                        <el-option value="医疗/护理/美容/保健/卫生服务"></el-option>
                        <el-option value="酒店/餐饮"></el-option>
                        <el-option value="旅游/度假"></el-option>
                        <el-option value="媒体/出版/影视/文化传播"></el-option>
                        <el-option value="娱乐/体育/修闲"></el-option>
                        <el-option value="能源/矿产/采掘/冶炼"></el-option>
                        <el-option value="石油/石化/化工"></el-option>
                        <el-option value="电气/电力/水利"></el-option>
                        <el-option value="环保"></el-option>
                        <el-option value="政府/公共事业/非营利机构"></el-option>
                        <el-option value="学术/科研"></el-option>
                        <el-option value="农/林/牧/渔"></el-option>
                        <el-option value="跨领域经营"></el-option>
                        <el-option value="其他"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="员工人数">
                    <el-input v-model="searchForm.employerNum"></el-input>
                </el-form-item>
                <el-form-item label="注册资本">
                    <el-input v-model="searchForm.registerCapital" placeholder="单位:万以上"></el-input>
                </el-form-item>
                <el-form-item label="成立时间">
                    <el-date-picker v-model="searchForm.beginRegisterDate" type="date" placeholder="选择日期"></el-date-picker>
                    --
                    <el-date-picker v-model="searchForm.endRegisterDate" type="date" placeholder="选择日期"></el-date-picker>
                </el-form-item>
                <el-button type="primary"  plain style="margin-top: 5px;"@click="doSearch">查询</el-button>
            </FuzzySearch>
        </div>
        <div class="table-wrap">
            <el-table :data="tableData" border stripe style="width: 100%">
                <el-table-column  label="操作" width="135px" :show-overflow-tooltip="true">
                    <template slot-scope="scope">
                        <el-button type="text" @click="$refs.showCompanyDetail.show(scope.row)">查看</el-button>
                    </template>
                </el-table-column>
                <el-table-column type="index" label="序号" width="60px"></el-table-column>
                <el-table-column prop="companyName" label="公司名称"></el-table-column>
                <el-table-column prop="organizationCode" label="组织机构代码"></el-table-column>
                <el-table-column prop="legalRepresentative" label="法人代表"></el-table-column>
                <el-table-column prop="industry" label="所属行业"></el-table-column>
                <el-table-column prop="employerNum" label="员工人数">
                    <template slot-scope="scope">
                        {{scope.row.employerNum}}人
                    </template>
                </el-table-column>
                <el-table-column prop="registerCapital" label="注册资本">
                    <template slot-scope="scope">
                        {{scope.row.registerCapital}}万
                    </template>
                </el-table-column>
                <el-table-column prop="registerDate" label="成立时间">
                    <template slot-scope="scope">
                        {{scope.row.registerDate | dateFmt('YYYY-MM-DD')}}
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
            <ShowCompanyDetail ref="showCompanyDetail"></ShowCompanyDetail>
        </div>
    </el-form>
</template>

<script>
    import FuzzySearch from '@/components/fuzzySearch/fuzzySearch.vue';
    import * as QUERY_INFO from '@/api/graduate/queryInfo.js';
    import * as tools from '@/assets/tools';
    import  ShowCompanyDetail from '@/views/graduate/searchInfo/showCompanyDetail.vue'
    export default {
        components: { FuzzySearch,ShowCompanyDetail,},
        data() {
            return {
                searchForm:{
                    companyName:'',    //公司名称
                    organizationCode:'',//组织机构代码
                    legalRepresentative:'',//法人代表
                    companyType:'',//公司类型
                    industry:'',//所属行业
                    employerNum:'',//员工人数
                    registerCapital:'',//注册资本
                    beginRegisterDate:'',//成立时间-开始
                    endRegisterDate:'',//成立时间-结束
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
            fuzzyClick(fuzzyWord){   //模糊查询
                this.currentPage = 1;
                let param = {
                    FUZZY_WORD: fuzzyWord,
                };
                this.searchFormClone = Object.assign(param,{});
                this.fetchTableData();
            },
            doSearch(){    //高级查询
                this.currentPage = 1;
                var beginRegisterDate = '';
                var endRegisterDate = '';
                if(this.searchForm.beginRegisterDate != '' && this.searchForm.beginRegisterDate != null){
                    beginRegisterDate = tools.transformTime(this.searchForm.beginRegisterDate,'YYYY-MM-DD');
                }
                if(this.searchForm.endRegisterDate != '' && THIS.searchForm.endRegisterDate != null){
                    endRegisterDate = tools.transformTime(this.searchForm.endRegisterDate,'YYYY-MM-DD');
                }
                
                let param = {
                    companyName: this.searchForm.companyName,    //公司名称
                    organizationCode: this.searchForm.organizationCode,  //组织机构代码
                    legalRepresentative: this.searchForm.legalRepresentative,//法人代表
                    companyType: this.searchForm.companyType,//公司类型
                    industry: this.searchForm.industry,//所属行业
                    employerNum: this.searchForm.employerNum,//员工人数
                    registerCapital: this.searchForm.registerCapital,//注册资本
                    beginRegisterDate: beginRegisterDate,//成立时间-开始
                    endRegisterDate: endRegisterDate,//成立时间-结束
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
                QUERY_INFO.api(QUERY_INFO.URL_QUERY_COMPANY_INFO,param).then(data =>{
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
        }
    }
</script>

<style scoped>

</style>