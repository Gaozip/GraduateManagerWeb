<template>
    <el-dialog :visible.sync="dialogVisible" :close-on-click-modal="false" title="新增字典元素" width="60%" append-to-body >
        <div class="dialog-edit">
            <!-- 添加了校验规则 -->
            <el-form :inline="true" :model="form" ref="formName" :rules="rules" >
                <div class="dialog-edit__row">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="元素名称" prop="itemName">
                            <el-input v-model="form.itemName"></el-input>
                        </el-form-item>
                    </div>
                    <div class="dialog-edit__row__item">
                        <el-form-item label="元素编码" prop="itemCode">
                            <el-input v-model="form.itemCode"></el-input>
                        </el-form-item>
                    </div>
                </div>
                <div class="dialog-edit__row dialog-edit__row--long">
                    <div class="dialog-edit__row__item">
                        <el-form-item label="元素值" prop="itemVal">
                            <el-input v-model="form.itemVal"></el-input>
                        </el-form-item>
                    </div>
                    <div class="dialog-edit__row__item">
                        <el-form-item label="元素分类" prop="dictType">
                            <el-select v-model="form.dictType">
                                <el-option v-for="item in dictTypeList" :label="item.value" :value="item.value"></el-option>
                            </el-select>
                        </el-form-item>
                    </div>
                </div>
                <div class="dialog-edit__row dialog-edit__row--long">
                    <el-form-item label="是否启用" prop="isValid">
                        <el-radio-group v-model="form.isValid" size="small">
                            <el-radio :label="1" border>启用</el-radio>
                            <el-radio :label="0" border>禁用</el-radio>
                        </el-radio-group>
                    </el-form-item>
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
    import * as DICT_ITEM_API from '@/api/admin/dictItem.js'
    export default {
        components: {},
        data() {
            var IfExist = (rule, value, callback) => {
                if(value != this.itemCodeClone){
                    DICT_ITEM_API.api(DICT_ITEM_API.URL_IF_EXIST, {itemCode: value,}).then(data => {
                        if (data.datas.num == '1') {
                            callback(new Error('该元素编码已存在!'));
                        } else {
                            callback();
                        }
                    });
                }else{
                    callback();
                }
            };
            return {
                dialogVisible: false,
                dictTypeList: [],
                itemCodeClone:'',
                form: {
                    itemName: '',
                    itemCode: '',
                    itemVal: '',
                    isValid: '1',
                    remark: '',
                    dictType: '',
                    fkDictId: '',
                },
                rules: {
                    itemName: [
                        {required: true, message: '请输入字典元素名称', trigger: 'blur'},
                    ],
                    itemCode: [
                        {required: true, message: '请输入字典元素编码', trigger: 'blur'},
                        {validator: IfExist, trigger: 'blur'},
                    ],
                    itemVal: [
                        {required: true, message: '请输入字典元素值', trigger: 'blur'},
                    ],
                    dictType: [
                        {required: true, message: '请选择元素分类', trigger: 'blur'},
                    ],
                },
            }
        },
        mounted() {
            this.fetchDictType();
        },
        watch: {
            dialogVisible(value) {
                if (!value) {
                    this.beforeClose();
                }
            },
        },
        methods: {
            fetchDictType() {
                this.dictTypeList = [];
                DICT_API.api(DICT_API.URL_QUERY_ALL_DICT, {}).then(data => {
                    data.datas.forEach(item => {
                        this.dictTypeList.push({value: item.dictName});
                        this.form.fkDictId = item.pkDictId;
                    });
                });
            },
            beforeClose() {
                this.$refs['formName'].resetFields();
                // 推送关闭消息
                this.$emit('closed');
            },
            show(data) {
                this.form = JSON.parse(JSON.stringify(data));
                this.itemCodeClone = data.itemCode;
                this.dialogVisible = true;
            },
            btnClick() {
                this.$refs['formName'].validate((valid) => {
                    if (valid) {
                        let param = {
                            pkDictItemId: this.form.pkDictItemId,
                            itemName: this.form.itemName,
                            itemCode: this.form.itemCode,
                            itemVal: this.form.itemVal,
                            isValid: this.form.isValid,
                            remark: this.form.remark,
                            fkDictId: this.form.fkDictId,
                            dictType: this.form.dictType,
                        };
                        DICT_ITEM_API.api(DICT_ITEM_API.URL_DO_UPDATE, param).then(data => {
                            this.$message.success('修改成功');
                            this.dialogVisible = false;
                        });
                    }
                });
            },
        }
    }
</script>

<style scoped>

</style>