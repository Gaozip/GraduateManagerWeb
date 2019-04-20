<template>
    <el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="新建字典" width="60%" append-to-body >
        <div class="dialog-edit">
            <!-- 添加了校验规则 -->
            <el-form :inline="true" :model="form" ref="formName" :rules="rules" >
                <div class="dialog-edit__row">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="字典名称" prop="dictName">
                            <el-input v-model="form.dictName"></el-input>
                        </el-form-item>
                    </div>
                    <div class="dialog-edit__row__item">
                        <el-form-item label="字典编码" prop="dictCode">
                            <el-input v-model="form.dictCode"></el-input>
                        </el-form-item>
                    </div>
                </div>
                <div class="dialog-edit__row dialog-edit__row--long">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="是否有效" prop="isValid">
                            <el-radio-group v-model="form.isValid" size="small">
                                <el-radio label="1" border>有效</el-radio>
                                <el-radio label="0" border>无效</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </div>
                </div>
                <div class="dialog-edit__row dialog-edit__row--long">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="备注" prop="remark">
                            <el-input type="textarea"  v-model="form.remark" :rows="6" :autosize="{ minRows: 6, maxRows: 8}"></el-input>
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
    import * as DICT_API from '@/api/admin/dict.js'
    export default {
        components: {},
        data() {
            return {
                dialogVisible:false,
                form:{
                  dictName:'',
                  dictCode:'',
                  remark:'', 
                  isValid:'1',  
                },
                rules:{
                    dictName:[
                        { required: true, message: '请输入字典名称', trigger: 'blur' },
                    ],
                    dictCode:[
                        { required: true, message: '请输入字典编码', trigger: 'blur' },
                    ],
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
            beforeClose(){
                this.$refs['formName'].resetFields();
                // 推送关闭消息
                this.$emit('closed');
            },
            show(){
              this.dialogVisible = true;  
            },
            btnClick(){
                this.$refs['formName'].validate((valid) => {
                    if (valid) {
                        let param ={
                            dictName: this.form.dictName,
                            dictCode: this.form.dictCode,
                            isValid: this.form.isValid,
                            remark: this.form.remark,
                        };
                        DICT_API.api(DICT_API.URL_DO_SAVE,param).then(data =>{
                            console.info(data);
                        });
                    }
                });
            },
        }
    }
</script>

<style scoped>

</style>