<template>
    <el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="更换头像" width="20%" append-to-body >
        <div class="dialog-edit">
            <el-upload
                    class="avatar-uploader"
                    list-type="picture-card"
                    :action="ctxPath+'/user/uploadUserHeadImage'"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload"
            >
                <img v-if="imageUrl" :src="imageUrl" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon" style="text-align: center"></i>
            </el-upload>
           
            <!-- 最后是按钮，（不要放在 form 里面） -->
            <div class="dialog-edit__btnGroup" slot="footer">
                <el-button @click="dialogVisible = false">取消</el-button>
            </div>
        </div>
    </el-dialog>
</template>

<script>
    export default {
        components: {},
        data() {
            return {
                ctxPath,
                imageUrl: '',
                dialogVisible:false,
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
            show(){
                this.dialogVisible = true;
            },
            beforeClose(){
                // 推送关闭消息
                this.$emit('closed');
            },
            btnClick(){

            },
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
                this.$message.success('修改头像成功！');
                this.dialogVisible = false;
            },
            beforeAvatarUpload(file){
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            }
        }
    }
</script>

<style scoped>
    .dialog-edit{
        text-align: center;
    }
    .avatar-uploader .el-upload {
        border: 1px dashed #d92f0a;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
</style>