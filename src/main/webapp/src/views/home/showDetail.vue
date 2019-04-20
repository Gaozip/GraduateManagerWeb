<template>
    <el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" :title="form.articleType" width="65%" append-to-body >
        <div class="dialog-edit">
            <h1 style="text-align: center">{{form.articleItem}}</h1>
            <div v-html="form.articleBody"></div>
            <!-- 最后是按钮，（不要放在 form 里面） -->
            <div class="dialog-edit__btnGroup" slot="footer">
                <el-button @click="dialogVisible = false">关闭</el-button>
            </div>
        </div>
    </el-dialog>
</template>

<script>
export default {
    data() {
        return {
            dialogVisible:false,
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
            // this.$refs['formName'].resetFields();
            // 推送关闭消息
            this.$emit('closed');
        },
        show(item){
            this.form = JSON.parse(JSON.stringify(item));
            switch (item.articleType) {
                case 0: this.form.articleType = '重要通知'; break;
                case 1: this.form.articleType = '版本更新'; break;
                case 2: this.form.articleType = '修复bug'; break;
                case 3: this.form.articleType = '热门事件'; break;
            }
            this.dialogVisible = true;
        }
    }
}
</script>

<style scoped>

</style>