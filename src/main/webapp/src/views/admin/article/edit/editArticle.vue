<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="公告详情" width="55%" append-to-body >
		<div class="dialog-edit">
			<!-- 添加了校验规则 -->
			<el-form :inline="true" :model="form" ref="formName" :rules="rules" >
				<div class="dialog-edit__row dialog-edit__row--long">
					<div class="dialog-edit__row__item">
						<el-form-item label="公告标题" prop="articleItem">
							<el-input v-model="form.ARTICLE_ITEM" ></el-input>
						</el-form-item>
					</div>
				</div>
				<div class="dialog-edit__row">
					<div class="dialog-edit__row__item">
						<el-form-item label="公告类型" prop="articleType">
							<el-input v-model="articleType[form.ARTICLE_TYPE]"></el-input>
						</el-form-item>
					</div>
					<div class="dialog-edit__row__item">
						<el-form-item label="发布时间" prop="startTime" >
							<el-date-picker v-model="form.START_TIME" type="date" placeholder="选择日期" ></el-date-picker>
						</el-form-item>
					</div>
				</div>
				<div class="dialog-edit__row">
					<div class="dialog-edit__row__item">
						<el-form-item label="是否有效" prop="isValid">
							<el-radio-group v-model="form.IS_VALID" size="small">
								<el-radio :label="1" border >有效</el-radio>
								<el-radio :label="0" border >无效</el-radio>
							</el-radio-group>
						</el-form-item>
					</div>
					<div class="dialog-edit__row__item">
						<el-form-item label="是否热门" prop="isTop">
							<el-radio-group v-model="form.IS_TOP" size="small">
								<el-radio :label="1" border >是</el-radio>
								<el-radio :label="0" border >否</el-radio>
							</el-radio-group>
						</el-form-item>
					</div>
				</div>
				<div class="dialog-edit__row dialog-edit__row--long">
					<div class="dialog-edit__row__item">
						<el-form-item label="公告内容" prop="articleBody">
							<el-input type="textarea"
									  v-model="form.ARTICLE_BODY"
									  :rows="4"
									  :autosize="{ minRows: 4, maxRows: 4}">
							</el-input>
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
import * as ARTICLE_API from '@/api/admin/article.js'
export default{
	data(){
		return{
			dialogVisible:false,
			articleType:{
				0:'重要通知',
				1:'版本更新',
				2:'修复bug',
				3:'热门事件',
			},
			form:{
			},
			rules:{

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
		btnClick(){
			let param = {
				articleItem:this.form.articleItem,//公告标题
				articleType:this.form.articleType,//公告类型
				startTime:this.form.startTime,//发布时间
				isValid:this.form.isValid,//是否有效
				isTop:this.form.isTop,//是否热门
				articleBody:this.form.articleBody,//公告内容
			};
			ARTICLE_API.api(ARTICLE_API.URL_DO_UPDATE,param).then(data =>{

			});
		},
		beforeClose(){
      		this.$refs['formName'].resetFields();
	        // 推送关闭消息
	        this.$emit('closed');
      	},
      	show(item){
			this.form = item;
			this.dialogVisible = true;
      	},
	},
}
</script>

<style>
</style>