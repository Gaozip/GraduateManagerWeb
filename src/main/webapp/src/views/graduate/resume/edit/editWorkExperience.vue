<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="编辑工作经验" width="55%" append-to-body >
	    <div class="dialog-edit">
	      	<!-- 添加了校验规则 -->
	      	<el-form :inline="true" :model="form" ref="formName" :rules="rules" label-width="150px">
	      	<el-form-item label="公司名称:" prop="companyName">
	      			<el-input v-model="form.companyName"></el-input>
	      		</el-form-item>
	      		<el-form-item label="所属行业:" prop="industry" >
	      			<el-select v-model="form.industry" placeholder="请选择" style="width: 200px;">
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
							<el-option value="其他">
						</el-option>
	      			</el-select>
	      		</el-form-item>
	      		<el-form-item label="职位名称:" prop="jobIntension">
	      			<el-input v-model="form.jobIntension"></el-input>
	      		</el-form-item>
	      		<el-form-item label="工作性质:" prop="jobType">
	      			<el-radio-group v-model="form.jobType">
              			<el-radio-button label="兼职"></el-radio-button>
					    <el-radio-button label="实习生"></el-radio-button>
					    <el-radio-button label="正式员工"></el-radio-button>
              		</el-radio-group>
	      		</el-form-item>
	      		<el-form-item label="在职时间:" prop="workDate">
	      			 <el-date-picker
					    v-model="form.workDate"
					    type="daterange"
					    value-format="yyyy-MM-dd"
					    range-separator="至"
					    start-placeholder="开始日期"
					    end-placeholder="结束日期">
				    </el-date-picker>
	      		</el-form-item>
	      		<el-form-item label="税前薪资:" prop="monthSalary">
	      			<el-select v-model="form.monthSalary">
						<el-option label="1000元/月" value="1000"></el-option>
						<el-option label="2000元/月" value="2000"></el-option>
						<el-option label="4000元/月" value="4000"></el-option>
						<el-option label="6000元/月" value="6000"></el-option>
						<el-option label="8000元/月" value="8000"></el-option>
						<el-option label="10000元/月" value="10000"></el-option>
						<el-option label="15000元/月" value="15000"></el-option>
						<el-option label="25000元/月" value="25000"></el-option>
						<el-option label="35000元/月" value="35000"></el-option>
						<el-option label="50000元/月" value="50000"></el-option>
						<el-option label="70000元/月" value="70000"></el-option>
						<el-option label="100000元/月" value="100000"></el-option>
					</el-select>			 
	      		</el-form-item>
	      		<el-form-item label="工作描述:" prop="jobDescription">
	      			<el-input type="textarea" v-model="form.jobDescription" :rows="4"  :autosize="{ minRows: 4, maxRows: 5}"></el-input>
	      		</el-form-item>
	      	</el-form>
	      	<!-- 最后是按钮，（不要放在 form 里面） -->
		    <div class="dialog-edit__btnGroup" slot="footer">
		        <el-button type="primary" @click="btnClick">确认</el-button>
		        <el-button @click="dialogVisible = false">取消</el-button>
		    </div>
	    </div>
	</el-dialog>
</template>

<script>

export default{
	data(){
		return{
			dialogVisible:false,
			rowIndex:'',
			form:{
				companyName:'',
				industry:'',//所属行业
				jobIntension:'',//职位
				jobType:'',
				workDate:'',
				monthSalary:'',
				jobDescription:'',
				rowIndex:'',
			},
			rules:{
				companyName:[
					{ required: true, message: '请输入公司名称', trigger: 'blur' },
				],
				industry:[
					{ required: true, message: '请选择所属行业', trigger: 'blur' },
				],
				jobIntension:[
					{ required: true, message: '请输入职位名称', trigger: 'blur' },
				],
				workDate:[
					{ required: true, message: '请选择在职时间', trigger: 'blur' },
				],
				monthSalary:[
					{ required: true, message: '请选择税前薪资', trigger: 'blur' },
				],
				jobDescription:[
					{ required: true, message: '请输入工作描述', trigger: 'blur' },
				],
			},
		}
	},
	watch: {
      dialogVisible(value) {
        if (!value) {
          this.beforeClose();
        }
      },
    },
	methods:{
		show(data,index){
			this.form = data;
			if(data.workDate.indexOf("[") != -1){
				this.form.workDate =  JSON.parse(data.workDate);
			}else{
				this.form.workDate = data.workDate;
			}
			this.form.rowIndex = index;
			this.dialogVisible = true;
		},
		btnClick(){
			this.$refs['formName'].validate((valid) =>{
				if(valid){
					this.$emit('edit',JSON.parse(JSON.stringify(this.form)));
					this.$message.success('修改成功');
				}else {//校验失败
	              	return false;
				}
				this.dialogVisible = false;
			});
			
		},
		beforeClose(){
			this.$refs['formName'].resetFields();
	        // 推送关闭消息
	        this.$emit('closed');
		},
	},
}
</script>

<style>
</style>