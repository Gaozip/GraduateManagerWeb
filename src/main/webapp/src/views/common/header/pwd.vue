<!-- 密码修改 -->
<template>

  <el-dialog :visible.sync="dialogVisible"
             title="密码修改">
    <div class="dialog-edit">
      <el-form
               :model="form"
               ref="formName">
      <el-form-item label="请输入旧密码">
      <el-input type="password"
      v-model="form.oldPassword"></el-input>
      </el-form-item>

      <label class="el-form-item__label">请输入新密码</label>
      <el-form-item>
      <el-input type="password"
      v-model="form.newPassword1"></el-input>
      </el-form-item>
      <label class="el-form-item__label">请验证密码</label>
      <el-form-item>
      <el-input type="password"
      v-model="form.newPassword2"></el-input>
      </el-form-item>
      <div style="margin-bottom: 10px;">
      <span>新密码验证规则：</span>
      <span style="color:red">新密码长度不得小于8位,必须包括字母，数字，特殊符号(~!@#$%^&*().,)</span>
      </div>

      </el-form>
      <!-- 最后是按钮，（不要放在 form 里面） -->
      <div class="dialog-edit__btnGroup"
           slot="footer">
        <el-button type="primary"
                   @click="changePass">确认</el-button>
        <el-button @click="close">取消</el-button>
      </div>
    </div>
  </el-dialog>

</template>

<script>
import * as SYSTEM_API from "@API_PATH/system/system";
export default {
  name: "system-pwd",
  data() {
    return {
        dialogVisible: false,

        form: {
            oldPassword: "",
            newPassword1: "",
            newPassword2: "",
        },
    };
  },
  methods: {
      show(row) {
          this.dialogVisible = true;
      },
      beforeClose(){
          this.$emit("closed");
          this.reset();
          this.$refs["formName"].resetFields();

      },
    changePass(row) {
      if (this.newPassword1 != this.newPassword2) {
        this.$alert("两次密码不一致", "提示信息", {
          confirmButtonText: "确定"
        });
        return;
      }
      let param = {
        oldPassword: this.form.oldPassword,
        newPassword1: this.form.newPassword1,
        newPassword2: this.form.newPassword2
      };
      SYSTEM_API.api(SYSTEM_API.URL_USER_CHANGE_PASS, param).then(data => {
        this.reset();
        this.$alert(`修改成功`, "提示", {
          confirmButtonText: "确定",
          callback: action => {}
        });
        this.dialogVisible=false;
        this.reset();
      });
    },
      close(){
        this.reset();
        this.dialogVisible=false;
      },
    reset() {
      this.form.oldPassword = "";
      this.form.newPassword1 = "";
      this.form.newPassword2 = "";
    }
  }
};
</script>

<style scoped>
.center {
  display: block;
  margin: 20px auto;
  width: 300px;
  /*text-align: center;
  position: absolute;
  left: 30%;
  top: 30px;*/
}
</style>
