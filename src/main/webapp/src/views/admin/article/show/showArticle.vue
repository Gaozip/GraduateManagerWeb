<template>
	<el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="公告详情" width="55%" append-to-body >
	    <div class="dialog-edit">
	      	<!-- 添加了校验规则 -->
	      	<el-form :inline="true" :model="form" ref="formName" :rules="rules" >
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
			
		},
		beforeClose(){
      		this.$refs['formName'].resetFields();
	        // 推送关闭消息
	        this.$emit('closed');
      	},
      	show(){
      		this.dialogVisible = true;
      	}
	},
}
</script>

<style>
</style>