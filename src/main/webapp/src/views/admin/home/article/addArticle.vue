<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="添加公告" width="55%" append-to-body >
	    <div class="dialog-edit">
	      	<!-- 添加了校验规则 -->
	      	<el-form :inline="true" :model="form" ref="formName" :rules="rules" >
	      		<div class="dialog-edit__row dialog-edit__row--long">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="公告标题" prop="articleItem">
                            <el-input v-model="form.articleItem"></el-input>
                        </el-form-item>
                    </div>
                </div>
            	<div class="dialog-edit__row">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="公告类型" prop="articleType">
                            <el-select v-model="form.articleType">
                            	<el-option 
                            		v-for="item in articleTypeList"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                            	</el-option>
                            </el-select>
                        </el-form-item>
                    </div>
                    <div class="dialog-edit__row__item">
                        <el-form-item label="发布时间" prop="startTime">
                           	<el-date-picker v-model="form.startTime" type="date" placeholder="选择日期"></el-date-picker>
                        </el-form-item>
                    </div>
                </div>
                <div class="dialog-edit__row">
                    <div class="dialog-edit__row__item">
                    	<el-form-item label="是否有效" prop="isValid">
                    		<el-radio v-model="form.isValid" label="1">有效</el-radio>
							<el-radio v-model="form.isValid" label="0">无效</el-radio>
                    	</el-form-item>
                    </div>
                    <div class="dialog-edit__row__item">
                    	<el-form-item label="是否热门" prop="isTop">
                    		<el-radio v-model="form.isTop" label="1">是</el-radio>
							<el-radio v-model="form.isTop" label="0">否</el-radio>
                    	</el-form-item>
                    </div>
                </div>
                <div class="dialog-edit__row dialog-edit__row--long">
                    <div class="dialog-edit__row__item">
                    	<el-form-item label="公告内容" prop="articleBody">
							<quill-editor v-model="form.articleBody"
										  ref="quillEditor"
										  @change="onEditorChange($event)"
										  :options="editorOption">
							</quill-editor>
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
import * as ARTICLE from '@/api/admin/article.js'
export default{
	data(){
		return{
			editorOption: {
				theme: 'snow'
			},
			dialogVisible:false,
			form:{
				articleItem:'',//公告标题
				articleType:'',//公告类型
				startTime:new Date(),//发布时间
				isValid:'1',//是否有效
				isTop:'0',//是否热门
				articleBody:'',//公告内容
			},
			rules:{
				articleItem:[
					{ required: true, message: '请填写公告标题', trigger: 'blur' },
					{  max: 32, message: '标题最长不能超过32个字', trigger: 'blur'}
				],
				articleType:[
					{ required: true, message: '请选择公告类型', trigger: 'blur' },
				],
				startTime:[
					{ required: true, message: '请选择发布时间', trigger: 'blur' },
				],
				articleBody:[
					{ required: true, message: '请输入公告内容', trigger: 'blur' },
				],
			},
			articleTypeList:[
				{
					label:'重要通知',
					value:0,
				},
				{
					label:'版本更新',
					value:1,
				},
				{
					label:'修复bug',
					value:2,
				},
				{
					label:'热门事件',
					value:3,
				},
			],
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
		btnClick(){
			this.$refs['formName'].validate((valid) =>{
				if(valid){
					let param = {
						articleItem:this.form.articleItem,//公告标题
						articleType:this.form.articleType,//公告类型
						startTime:this.form.startTime,//发布时间
						isValid:this.form.isValid,//是否有效
						isTop:this.form.isTop,//是否热门
						articleBody:this.form.articleBody,//公告内容
					};
					ARTICLE.api(ARTICLE.URL_ARTICLE_SAVE,param).then(data =>{
						this.$message.success('添加成功');
						this.dialogVisible = false;
					});
				}
			});
		},
		beforeClose(){
      		this.$refs['formName'].resetFields();
	        // 推送关闭消息
	        this.$emit('closed');
      	},
      	show(){
      		this.dialogVisible = true;
      	},
		onEditorChange({ editor, html, text }) {
			let textLength = text.length
			this.$refs['formName'].validate((valid) => {
				if (valid) {
				}
			});
		},
	},
}
</script>

<style>
</style>