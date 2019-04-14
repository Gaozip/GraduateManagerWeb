<!-- beforeClose 是关闭前数据清空操作，需要在 el-form-item 标签上添加 prop 属性 -->
<template>
    <el-dialog :visible.sync="dialogVisible" :title="title" width="80%">
        <div class="dialog-edit">
            <el-form :inline="true" :model="form" ref="formName">
                <!-- 1行由2列组成 -->
                <div class="dialog-edit__row dialog-edit__row--long">
                    <!-- 1列由 label 和 el-form-item 组成 -->
                    <div class="dialog-edit__row__item" style="text-align: center">
                        <el-form-item label="" prop="title">
                            <div id="title">{{form.title}}</div>
                        </el-form-item>
                    </div>

                </div>
                	<div class="ql-editor" v-html="form.content">
                </div>
            </el-form>

        </div>
    </el-dialog>
</template>

<script>
    import * as ARTICLE_API from "@API_PATH/operation/article/article.js";

    export default {
        data() {
            return {
                title: "",
                dialogVisible: false,
                form: {
                },
            };
        },
        watch: {
            dialogVisible(value) {
                if (!value) {
                    this.beforeClose();
                }
            }
        },
        methods: {
            show(articleData) {
                this.form.title = articleData.TITLE
                this.form.articleType = articleData.ARTICLE_TYPE
                this.form.startTime = articleData.START_TIME
                this.form.endTime = articleData.END_TIME
                this.form.isTop = articleData.IS_TOP
                this.form.status = articleData.STATUS
                this.form.content = articleData.CONTENT
                this.title = articleData.ARTICLE_TYPE
                this.dialogVisible = true;
            },
            // 关闭前操作，一般要进行数据清空
            beforeClose() {
                // ref 根据实际修改
                this.$refs['formName'].resetFields();
                // 推送关闭消息
                this.$emit('closed');
            },
            btnClick(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let param = {...this.form};
                        ARTICLE_API.api(ARTICLE_API.URL_ARTICLE_DOSAVE, param).then(data => {
                            this.$message.success('添加成功');
                            this.dialogVisible = false;
                        })
                    }
                });
            }
        },
    };
</script>

<style scoped>
    #title {
        color: #3a8ee6;
        font-weight: bold;
        font-size: xx-large;
    }
</style>