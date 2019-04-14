<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="修改招聘信息" width="55%" append-to-body >
	    <div class="dialog-edit">
	      	<!-- 添加了校验规则 -->
	      	<el-form :inline="true" :model="form" ref="formName" :rules="rules" >
	      		<div class="dialog-edit__row">
                    <div class="dialog-edit__row__item">
	          			<el-form-item label="招收职位" prop="position">
	          				<el-input v-model="form.position"></el-input>
	          			</el-form-item>
	          		</div>
	          		<div class="dialog-edit__row__item">
	          			<el-form-item label="月工资" prop="monthSalary">
	          				<el-input v-model="form.monthSalary"></el-input>
	          			</el-form-item>
	          		</div>
	            </div>
	            <div class="dialog-edit__row">
                    <div class="dialog-edit__row__item">
	          			<el-form-item label="工作地点" prop="workPlace">
							<el-input v-model="form.workPlace"></el-input>              				
	          			</el-form-item>
	          		</div>
	          		<div class="dialog-edit__row__item">
	          			<el-form-item label="工作性质" prop="jobNature">
	          				<el-select v-model="form.jobNature">
	          					<el-option value="实习生"></el-option>
	          					<el-option value="正式员工"></el-option>
	          					<el-option value="兼职"></el-option>
	          				</el-select>
	          			</el-form-item>
	          		</div>
	          	</div>
	          	<div class="dialog-edit__row">
                    <div class="dialog-edit__row__item">
	          			<el-form-item label="招收人数" prop="recruitNum">
	          				<el-input v-model="form.recruitNum"></el-input>
	          			</el-form-item>
	          		</div>
	          		<div class="dialog-edit__row__item">
	          			<el-form-item label="学历要求" prop="education">
	          				<el-select v-model="form.education">
	          					<el-option value="高中/中技/中专"></el-option>
								<el-option value="大专"></el-option>
								<el-option value="本科"></el-option>
								<el-option value="硕士"></el-option>
								<el-option value="MBA"></el-option>
								<el-option value="博士"></el-option>
	          				</el-select>
	          			</el-form-item>
	          		</div>
	          	</div>
          		<div class="dialog-edit__row">
                	<div class="dialog-edit__row__item">
	          			<el-form-item label="工作经验" prop="workExperience">
	          				<el-select v-model="form.workExperience">
	          					<el-option value="暂无要求"></el-option>
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
	          		</div>
	          		<div class="dialog-edit__row__item">
	          			<el-form-item label="是否立即发布">
	          				<el-radio-group v-model="form.state" class="radioo">
							    <el-radio-button label="发布"></el-radio-button>
							    <el-radio-button label="不发布"></el-radio-button>
							</el-radio-group>
	          			</el-form-item>
	          		</div>
	          	</div>
				<div class="dialog-edit__row dialog-edit__row--long">
                	<div class="dialog-edit__row__item">
						<el-form-item label="工作内容" prop="jobContent" >
	          				<el-input type="textarea" v-model="form.jobContent" :rows="6"  :autosize="{ minRows: 6, maxRows: 8}" class="area"></el-input>
	          			</el-form-item>
          			</div>
          		</div>
          		<div class="dialog-edit__row dialog-edit__row--long">
                	<div class="dialog-edit__row__item">
	          			<el-form-item label="任职要求" prop="qualification" >
	          				<el-input type="textarea" v-model="form.qualification" :rows="6"  :autosize="{ minRows: 6, maxRows: 8}" class="area"></el-input>
	          			</el-form-item>
	          		</div>
				</div>
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
import * as AXIOS from '@/api/axios.js';	
export default{
	data(){
		return{
			dialogVisible:false,
			pkRecruitmentId:'',
			form:{
				position:'',//招聘职位
				monthSalary:'',//月工资
				workPlace:'',//工作地点
				jobNature:'',//工作性质
				recruitNum:'',//招收人数
				education:'',//学历要求
				workExperience:'',//工作经验
				jobContent:'',//工作内容
				qualification:'',//任职要求
				state:'',//发布状态
			},
			rules:{
				position:[
					{ required: true, message: '请输入招收职位', trigger: 'blur' },
				],
				monthSalary:[
					{ required: true, message: '请输入月薪', trigger: 'blur' },
				],
				workPlace:[
					{ required: true, message: '请输入工作地点', trigger: 'blur' },
				],
				jobNature:[
					{ required: true, message: '请选择工作性质', trigger: 'blur' },
				],
				recruitNum:[
					{ required: true, message: '请输入招收人数', trigger: 'blur' },
				],
				education:[
					{ required: true, message: '请选择学历要求', trigger: 'blur' },
				],
				workExperience:[
					{ required: true, message: '请选择工作经验要求', trigger: 'blur' },
				],
				jobContent:[
					{ required: true, message: '请输入工作内容', trigger: 'blur' },
				],
				qualification:[
					{ required: true, message: '请输入任职要求', trigger: 'blur' },
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
		beforeClose(){
      		this.$refs['formName'].resetFields();
	        // 推送关闭消息
	        this.$emit('closed');
        },
        show(scope) {
        	this.dialogVisible = true;
        	this.pkRecruitmentId = scope.pkRecruitmentId;
        	this.form.position=scope.position;
        	this.form.monthSalary=scope.monthSalary;
        	this.form.workPlace=scope.workPlace;
        	this.form.jobNature=scope.jobNature;
        	this.form.recruitNum=scope.recruitNum;
        	this.form.education=scope.education;
        	this.form.workExperience=scope.workExperience;
        	this.form.jobContent=scope.jobContent;
        	this.form.qualification=scope.qualification;
        	if(scope.state == '1'){
        		this.form.state = '发布';
        	}else{
				this.form.state = '不发布';
        	}
        },
        btnClick(){
        	this.$refs['formName'].validate((valid) =>{
				if(valid){
		        	this.$confirm('确认更改？').then(_ => {
		        		let param = {
		        			'pkRecruitmentId':this.pkRecruitmentId,
			        		'position': this.form.position,
							'monthSalary':this.form.monthSalary,
							'workPlace':this.form.workPlace,
							'jobNature':this.form.jobNature,
							'recruitNum':this.form.recruitNum,
							'education':this.form.education,
							'workExperience':this.form.workExperience,
							'jobContent':this.form.jobContent,
							'qualification':this.form.qualification,
							'state':this.form.state,
			        	};
			        	AXIOS.api('/recruitment/doUpdate',param).then(data =>{
							this.$message.success('修改成功');
							this.dialogVisible = false;
						});
					});
				}else{
					return false;
				}
			});
        },
	}
}
</script>

<style scoped>
.radioo >>> .el-radio-button__inner {
	padding:10px 20px;
}
</style>