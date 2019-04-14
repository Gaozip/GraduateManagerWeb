<template>
    <div class="basicInfo">
        <el-form :inline="true" :model="form" ref="formName" :rules="rules">
            <table class="tab-app" align="center">
                <tr>
                    <td colspan="6" class="title">个人信息</td>
                </tr>
                <tr>
                    <td class="item">学号</td>
                    <td>
                        <el-form-item prop="sno">
                            <el-input v-model="form.sno"></el-input>
                        </el-form-item>
                    </td>
                    <td class="item">姓名</td>
                    <td>
                        <el-form-item prop="name">
                            <el-input v-model="form.name"></el-input>
                        </el-form-item>
                    </td>
                    <td class="item">性别</td>
                    <td>
                        <el-form-item prop="性别">
                            <el-radio-group v-model="form.sex" size="small">
                                <el-radio label="男" border>男</el-radio>
                                <el-radio label="女" border>女</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </td>
                </tr>
                <tr>
                    <td class="item">出生年月</td>
                    <td>
                        <el-form-item prop="birthday">
                            <el-date-picker v-model="form.birthday" type="date"placeholder="选择日期" > </el-date-picker>
                        </el-form-item>
                    </td>
                    <td class="item">民族</td>
                    <td>
                        <el-form-item prop="nation">
                            <el-select v-model="form.nation" >
                                <el-option value="汉族"></el-option>
                                <el-option value="蒙古族"></el-option>
                                <el-option value="回族"></el-option>
                                <el-option value="藏族"></el-option>
                                <el-option value="维吾尔族"></el-option>
                                <el-option value="苗族"></el-option>
                                <el-option value="彝族"></el-option>
                                <el-option value="壮族"></el-option>
                                <el-option value="布依族"></el-option>
                                <el-option value="朝鲜族"></el-option>
                                <el-option value="满族"></el-option>
                                <el-option value="侗族"></el-option>
                                <el-option value="瑶族"></el-option>
                                <el-option value="白族"></el-option>
                                <el-option value="土家族"></el-option>
                                <el-option value="哈尼族"></el-option>
                                <el-option value="哈萨克族"></el-option>
                                <el-option value="傣族"></el-option>
                                <el-option value="黎族"></el-option>
                                <el-option value="僳僳族"></el-option>
                                <el-option value="佤族"></el-option>
                                <el-option value="畲族"></el-option>
                                <el-option value="高山族"></el-option>
                                <el-option value="拉祜族"></el-option>
                                <el-option value="水族"></el-option>
                                <el-option value="东乡族"></el-option>
                                <el-option value="纳西族"></el-option>
                                <el-option value="景颇族"></el-option>
                                <el-option value="柯尔克孜族"></el-option>
                                <el-option value="土族"></el-option>
                                <el-option value="达斡尔族"></el-option>
                                <el-option value="仫佬族"></el-option>
                                <el-option value="羌族"></el-option>
                                <el-option value="布朗族"></el-option>
                                <el-option value="撒拉族"></el-option>
                                <el-option value="毛南族"></el-option>
                                <el-option value="仡佬族"></el-option>
                                <el-option value="锡伯族"></el-option>
                                <el-option value="阿昌族"></el-option>
                                <el-option value="普米族"></el-option>
                                <el-option value="塔吉克族"></el-option>
                                <el-option value="怒族"></el-option>
                                <el-option value="乌孜别克族"></el-option>
                                <el-option value="俄罗斯族"></el-option>
                                <el-option value="鄂温克族"></el-option>
                                <el-option value="德昂族"></el-option>
                                <el-option value="保安族"></el-option>
                                <el-option value="裕固族"></el-option>
                                <el-option value="京族"></el-option>
                                <el-option value="塔塔尔族"></el-option>
                                <el-option value="独龙族"></el-option>
                                <el-option value="鄂伦春族"></el-option>
                                <el-option value="赫哲族"></el-option>
                                <el-option value="门巴族"></el-option>
                                <el-option value="珞巴族"></el-option>
                                <el-option value="基诺族"></el-option>
                            </el-select>
                        </el-form-item>
                    </td>
                    <td class="item">籍贯</td>
                    <td>
                        <v-distpicker hide-area @selected="setNativePlace" :province="form.province" :city="form.city"></v-distpicker>
                    </td>
                </tr>
                <tr>
                    <td class="item">政治面貌</td>
                    <td>
                        <el-form-item prop="politicalStatus">
                            <el-select v-model="form.politicalStatus" >
                            <el-option value="中共党员"></el-option>
                            <el-option value="中共预备党员"></el-option>
                            <el-option value="共青团员"></el-option>
                            <el-option value="民革党员"></el-option>
                            <el-option value="民盟盟员"></el-option>
                            <el-option value="民建会员"></el-option>
                            <el-option value="民进会员"></el-option>
                            <el-option value="农工党党员"></el-option>
                            <el-option value="致公党党员 "></el-option>
                            <el-option value="九三学社社员"></el-option>
                            <el-option value="台盟盟员"></el-option>
                            <el-option value="无党派人士"></el-option>
                            <el-option value="群众"></el-option>
                        </el-select>
                        </el-form-item>
                    </td>
                    <td class="item">电话</td>
                    <td>
                        <el-form-item prop="tel">
                            <el-input v-model="form.tel"></el-input>
                        </el-form-item>
                    </td>
                    <td class="item">QQ</td>
                    <td>
                        <el-form-item prop="qq">
                            <el-input v-model="form.qq"></el-input>
                        </el-form-item>
                    </td>
                </tr>
                <tr>
                    <td class="item">微信</td>
                    <td>
                        <el-form-item prop="wchat">
                            <el-input v-model="form.wchat"></el-input>
                        </el-form-item>
                    </td>

                    <td class="item">系别</td>
                    <td>
                        <el-form-item prop="dept">
                            <el-select v-model="form.dept" class="dept" @change="deptChange(form.dept)">
                                <el-option v-for="item in deptList" :key="item.value" :value="item.value" :label="item.value"></el-option>
                            </el-select>
                        </el-form-item>
                    </td>
                    <td class="item">专业</td>
                    <td>
                        <el-form-item prop="specialty">
                            <el-select v-model="form.specialty" class="specialty">
                                <el-option v-for="item in specialtyList" :key="item.value" :value="item.value" :label="item.value"></el-option>
                            </el-select>
                        </el-form-item>
                    </td>
                </tr>
                <tr>
                    <td class="item">教育背景</td>
                    <td>
                        <el-form-item prop="education">
                            <el-select v-model="form.education" placeholder="请选择">
                            <el-option value="高中/中技/中专"></el-option>
                            <el-option value="大专"></el-option>
                            <el-option value="本科"></el-option>
                            <el-option value="硕士"></el-option>
                            <el-option value="MBA"></el-option>
                            <el-option value="博士"></el-option>
                        </el-select>
                        </el-form-item>
                    </td>
                    <td class="item">毕业院校</td>
                    <td>
                        <el-form-item prop="gradCollege">
                            <el-input v-model="form.graduateCollege"></el-input>
                        </el-form-item>
                    </td>
                    <td class="item">入学时间</td>
                    <td>
                        <el-form-item prop="inDate">
                            <el-date-picker v-model="form.inDate" type="date" placeholder="选择日期" > </el-date-picker>
                        </el-form-item>
                    </td>
                </tr>
                <tr>
                    <td class="haveJob">有无工作</td>
                    <td>
                        <el-radio-group v-model="form.haveJob" size="small">
                            <el-radio label="0" border>无</el-radio>
                            <el-radio label="1" border>有</el-radio>
                        </el-radio-group>
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr v-show="form.haveJob == '1'">
                    <td colspan="6" class="title">就业信息</td>
                </tr>
                <tr v-show="form.haveJob == '1'">
                    <td class="item">公司名称</td>
                    <td>
                        <el-form-item prop="companyName">
                            <el-input v-model="form.companyName"></el-input>
                        </el-form-item>
                    </td>
                    <td class="item">入职时间</td>
                    <td>
                        <el-form-item prop="getJobTime">
                            <el-date-picker v-model="form.getJobTime" type="date"placeholder="选择日期" > </el-date-picker>
                        </el-form-item>
                    </td>
                    <td class="item">所属行业</td>
                    <td>
                        <el-form-item prop="industry">
                            <el-select v-model="form.industry" >
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
                    </td>
                </tr>
                <tr v-show="form.haveJob == '1'">
                    <td class="item">职位</td>
                    <td>
                        <el-form-item prop="position">
                            <el-input v-model="form.position"></el-input>
                        </el-form-item>
                    </td>
                    <td class="item">月薪</td>
                    <td>
                        <el-form-item prop="monthSalary">
                            <el-input v-model="form.monthSalary"></el-input>
                        </el-form-item>
                    </td>
                    <td class="item">工作经验</td>
                    <td>
                        <el-form-item prop="workYear">
                            <el-select v-model="form.workYear" placeholder="请如实选择" >
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
                    </td>
                </tr>
            </table>
        </el-form>
        <br/>
        <div style="text-align: center;">
            <el-button type="primary" plain @click="btnClick">确定</el-button>
        </div>
    </div>
</template>

<script>
    import VDistpicker from 'v-distpicker'
    import * as GRADUATE_API from '@/api/graduate/graduate.js';
    import * as tools from '@/assets/tools';
    export default {
        components:{VDistpicker,},
        data(){
            return{
                forEdit:false,
                deptList:[
                    {label:"经济系",value:"经济系"},
                    {label:"文法系",value:"文法系"},
                    {label:"管理系",value:"管理系"},
                    {label:"会计系",value:"会计系"},
                    {label:"信息工程系",value:"信息工程系"},
                    {label:"艺术设计系",value:"艺术设计系"},
                ],
                specialtyList:[],
                form:{
                    sno:'1550303022',
                    haveJob:'1',
                    name:'高志鹏',
                    sex:'男',
                    birthday:'1997-02-19',
                    nation:'汉族',
                    province:'福建省',
                    city:'福州市',
                    politicalStatus:'共青团员',
                    tel:'13115912059',
                    qq:'2982824388',
                    wchat:'Gzip13115912059',
                    inDate:'2015-09-12',
                    gradYear:'2019',
                    dept:'信息工程系',
                    specialty:'计算机科学与技术',
                    education:'本科',
                    graduateCollege:'福建农林大学东方学院',
                    homeAddress:'福建省福州市平潭县',
                    companyName:'福建博恒软件',
                    industry:'it行业',
                    getJobTime:'2019-01-04',
                    monthSalary:'2600',
                    position:'码农',
                    workYear:'暂无',
                },
                rules:{
                    sno:[{ required: true, message: '请填写学号', trigger: 'blur' },],
                    name:[{ required: true, message: '请填写姓名', trigger: 'blur' }],
                    birthday:[{ required: true, message: '请选择出生年月', trigger: 'blur' }],
                    nation:[{ required: true, message: '请选择民族', trigger: 'blur' }],
                    politicalStatus:[{ required: true, message: '请选择政治面貌', trigger: 'blur' }],
                    tel:[{ required: true, message: '请填写手机号', trigger: 'blur' }],
                    qq:[{ required: true, message: '请填写qq', trigger: 'blur' }],
                    wchat:[{ required: true, message: '请填写微信', trigger: 'blur' }],
                    inDate:[{ required: true, message: '请选择入学时间', trigger: 'blur' }],
                    gradYear:[{ required: true, message: '请选择毕业年份', trigger: 'blur' }],
                    dept:[{ required: true, message: '请选择系别', trigger: 'blur' }],
                    specialty:[{ required: true, message: '请选择专业', trigger: 'blur' }],
                    education:[{ required: true, message: '请选择教育背景', trigger: 'blur' }],
                    graduateCollege:[{ required: true, message: '请填写毕业院校', trigger: 'blur' }],
                    homeAddress:[{ required: true, message: '请填写家庭住址', trigger: 'blur' }],
                    companyName:[{ required: true, message: '请填写公司名称', trigger: 'blur' },],
                    industry:[{ required: true, message: '请选择行业', trigger: 'blur' },],
                    getJobTime:[{ required: true, message: '请选择入职时间', trigger: 'blur' },],
                    monthSalary:[{ required: true, message: '请填写月薪', trigger: 'blur' },],
                    position:[{ required: true, message: '请填写职位', trigger: 'blur' },],
                    workYear:[{ required: true, message: '请请选择工作经验', trigger: 'blur' },],
                },
            }
        },
        mounted(){
           this.fetchData();
        },
        methods:{
            fetchData(){
                GRADUATE_API.api(GRADUATE_API.URL_QUERY_BASIC_INFO_BY_ID,{}).then(data =>{
                    if(data.datas.sno != null){
                        this.form = data.datas;
                        this.form.haveJob = ''+data.datas.haveJob;
                        this.form.province = data.datas.province;
                        this.form.city = data.datas.city;
                    }
                });
            },
            btnClick(){
                console.info(this.form.city);
                this.$refs['formName'].validate((valid) =>{
                    if(this.form.city == '市' || this.form.city == null){
                        this.$message({
                            message: '请选择籍贯!',
                            type: 'warning'
                        });
                        return false;
                    }
                    if(valid){
                        let param = {
                            'sno': this.form.sno,
                            'haveJob': this.form.haveJob,
                            'name': this.form.name,
                            'sex': this.form.sex,
                            'birthday': tools.transformTime(this.form.birthday, 'YYYY-MM-DD'),
                            'nation': this.form.nation,
                            'province': this.form.province,
                            'city': this.form.city,
                            'politicalStatus': this.form.politicalStatus,
                            'tel': this.form.tel,
                            'qq': this.form.qq,
                            'wchat': this.form.wchat,
                            'inDate': tools.transformTime(this.form.inDate, 'YYYY-MM-DD'),
                            'gradYear':this.form.gradYear,
                            'dept': this.form.dept,
                            'specialty': this.form.specialty,
                            'education':this.form.education,
                            'graduateCollege': this.form.graduateCollege,
                            'companyName': this.form.companyName,
                            'industry': this.form.industry,
                            'getJobTime': tools.transformTime(this.form.getJobTime, 'YYYY-MM-DD'),
                            'monthSalary': this.form.monthSalary,
                            'position': this.form.position,
                            'workYear': this.form.workYear,
                        };
                        GRADUATE_API.api(GRADUATE_API.URL_DO_UPDATE,param).then(data =>{
                            this.$message.success('保存成功');
                        });
                    }
                });
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
           setNativePlace(value){
                this.form.province = value.province.value;
                this.form.city = value.city.value;
           },
        },
    }
</script>

<style scoped>
    .tab-app{
        width: 85%;
        margin-top: 40px;
        text-align: center;
        font-family: verdana,arial,sans-serif;
        font-size:11px;
        color:#333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
    }
    .tab-app th {
        border-width: 1px;
        padding: 0px;
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }
    .tab-app td {
        border-width: 1px;
        padding: 0px;
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }
     .item{
        font-weight: bold;
    }
    table .title{
        font-weight: bold;
        font-size: 16px;
        padding: 14px;
    }
    table .haveJob{
        font-weight: bold;
        padding: 16px;
    }
</style>