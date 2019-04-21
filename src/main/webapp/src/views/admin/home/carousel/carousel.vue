<template>
    <div class="mainBody">
        <fieldset class="field_">
            <legend style="font-size: large">首页走马灯图片管理</legend>
            <el-upload
                    class="upload-demo"
                    ref="upload"
                    :action="ctxPath+'/carousel/doSave'"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :file-list="fileList"
                    list-type="picture"
                    :auto-upload="false">
                <el-button slot="trigger" type="primary">选取文件</el-button>
                <el-button style="margin-left: 10px;"  type="success" @click="submitUpload">上传到服务器</el-button>
                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>
        </fieldset>
    </div>
</template>

<script>
    import * as HOME_API from '@/api/admin/home.js'
    export default {
        components: {},
        data() {
            return {
                ctxPath,
                fileList: [],
            }
        },
        mounted() {
            this.fetchPictureList();
        },
        watch: {
            
        },
        methods: {
            submitUpload() {
                this.$refs.upload.submit();
            },
            handleRemove(file) {
                let param = {
                    fileName:file.name,
                };
                this.$confirm('确定删除?', '提示').then(() => {
                    HOME_API.api(HOME_API.URL_DELETE_PICTURE,param).then(data =>{
                        if(data.rs){
                            this.$message.success('删除成功!');
                            this.fetchPictureList();
                        }
                    });
                });
            },
            handlePreview(file) {
              
            },
            fetchPictureList(){
                this.fileList = [];
                HOME_API.api(HOME_API.URL_QUERY_PICTURE_LIST,{}).then(data =>{
                    data.datas.forEach(item =>{
                        this.fileList.push({name:item.fileName,url:item.imgPath});
                    });
                });
            },
        }
    }
</script>

<style scoped>
.mainBody{
    width: 100%;
    margin:0;
    background-color: #f9f9f9;
    padding: 2% 15%;
    border-radius: 12px;
}
.field_{
    padding: 4% 13%;
    border-radius: 20px;
}    
</style>