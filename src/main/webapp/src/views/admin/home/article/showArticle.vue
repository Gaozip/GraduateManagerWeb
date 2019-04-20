<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="公告详情" width="55%" append-to-body >
		<div class="dialog-edit">
			<!-- 添加了校验规则 -->
			<el-form :inline="true" :model="form" ref="formName" :rules="rules" >
				<div class="dialog-edit__row dialog-edit__row--long">
					<div class="dialog-edit__row__item">
						<el-form-item label="公告标题" prop="articleItem">
							<el-input v-model="form.articleItem" disabled></el-input>
						</el-form-item>
					</div>
				</div>
				<div class="dialog-edit__row">
					<div class="dialog-edit__row__item">
						<el-form-item label="公告类型" prop="articleType">
							<el-input v-model="form.articleType" disabled></el-input>
						</el-form-item>
					</div>
					<div class="dialog-edit__row__item">
						<el-form-item label="发布时间" prop="startTime" >
							<el-date-picker v-model="form.startTime" type="date" placeholder="选择日期" disabled></el-date-picker>
						</el-form-item>
					</div>
				</div>
				<div class="dialog-edit__row">
					<div class="dialog-edit__row__item">
						<el-form-item label="是否有效" prop="isValid">
							<el-radio-group v-model="form.isValid" size="small">
								<el-radio :label="1" border disabled>有效</el-radio>
								<el-radio :label="0" border disabled>无效</el-radio>
							</el-radio-group>
						</el-form-item>
					</div>
					<div class="dialog-edit__row__item">
						<el-form-item label="是否热门" prop="">
							<el-radio-group v-model="form.isTop" size="small">
								<el-radio :label="1" border disabled>是</el-radio>
								<el-radio :label="0" border disabled>否</el-radio>
							</el-radio-group>
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
	export default {
		data() {
			return {
				editorOption: {
					theme: 'snow'
				},
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
		mounted() {

		},
		watch: {
			dialogVisible(value) {
				if (!value) {
					this.beforeClose();
				}
			},
		},
		methods: {
			btnClick(){

			},
			beforeClose(){
				this.$refs['formName'].resetFields();
				// 推送关闭消息
				this.$emit('closed');
			},
			show(item){
				console.info(item);
				this.form = item;
				this.dialogVisible = true;
			},
			onEditorChange({ editor, html, text }) {
				let textLength = text.length
				this.$refs['formName'].validate((valid) => {
					if (valid) {
					}
				});
			},
		}
	}
</script>

<style scoped>

</style>