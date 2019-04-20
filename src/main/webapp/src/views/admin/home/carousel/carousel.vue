<template>
    <div class="mainBody">
        <el-upload
                class="upload-demo"
                ref="upload"
                :action="ctxPath+'/carousel/doSave'"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :file-list="fileList"
                :auto-upload="false">
            <el-button slot="trigger" type="primary">选取文件</el-button>
            <el-button style="margin-left: 10px;"  type="success" @click="submitUpload">上传到服务器</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
    </div>
</template>

<script>
    export default {
        components: {},
        data() {
            return {
                ctxPath,
                fileList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}]
            }
        },
        mounted() {
            
        },
        watch: {
            
        },
        methods: {
            submitUpload() {
                this.$refs.upload.submit();
            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePreview(file) {
                console.log(file);
            }
        }
    }
</script>

<style scoped>
.mainBody{
    width: 50%;
    margin: 8% auto ;
    background-color: #f9f9f9;
    padding: 2%;
    border-radius: 12px;
}
</style>