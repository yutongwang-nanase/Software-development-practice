<template>
  <div class="login">
    <div style="margin: 300px auto ;background: #FFFFFF;width: 450px;height: 300px;padding: 20px">
      <div style="margin: 20px; text-align: center; font-size: 24px"><b>{{this.$route.params.name}}</b></div>
      <el-input placeholder="请输入新密码" size="medium" style="margin: 10px" prefix-icon="el-icon-user" show-password v-model:prefix-icon="user.password"></el-input>
      <el-input placeholder="请确认密码" size="medium" style="margin: 10px" prefix-icon="el-icon-lock"  show-password v-model:prefix-icon="newpassword"></el-input>
      <div style="width: 450px;height: 50px;margin-left: 10px;margin-top: 5px">
        <el-input v-model="inputVal" style="width:150px ;" clearable />
        <validate-code ref="ref_validateCode" @change="changeCode"  style="margin-left: 20px; vertical-align:middle " />
        {{result}}
      </div>

      <div style="margin: 10px;text-align: right">
<!--        <el-link  @click = "$router.push('./fake')"  icon="el-icon-shopping-cart-2" target="_blank" style="margin-right: 20px">暂时先不登陆~~</el-link>-->
        <el-button type="primary" @click="login" style="margin-right: 200px">提交</el-button>
        <el-button @click="GoId">返回</el-button>
<!--        <el-button @click = "$router.push('./register')">注册</el-button>-->
      </div>




    </div>



  </div>
</template>



<script>

import validateCode from "@/components/ValidateCode";
export default{
  components: {
    validateCode
  },
  data(){
    return{
      newpassword:"",
      inputVal: "",
      checkCode: "",
      result: "",
      user:{

      }
    }
  },
  methods:{
    login() {
      if (this.inputVal.toUpperCase() === this.checkCode) {
        this.result = "☑";
        this.user.id = this.$route.params.id
        this.user.point = this.$route.params.point
        this.user.money = this.$route.params.money
        if (this.user.password===this.newpassword){
          this.request.post("http://localhost:9090/user/updateuser", this.user).then(res => {
            if (!res) {
              this.$message.error("错误")
            } else {
              this.$message.success("修改成功,请重新登录")
              this.$router.push("/")
            }
          })
        }else {
          this.$message.error("两次输入密码不同")
          this.user.password = ""
          this.newpassword = ""
        }

      } else {
        this.$message.error("验证码错误")
        this.result = "✘";
        this.inputVal = "";
        this.$refs["ref_validateCode"].draw();
      }
    },
    GoId(){
      this.$router.push({
        name: "Message",
        params: {
          id: this.$route.params.name
        }
      });
    },
    changeCode(value) {
      this.checkCode = value;
    },
    compare() {

    }
  }
};
</script>

<style scoped lang="less">
.login{
  width: auto;
  margin: 0 auto;
  height: 900px;
  .box-card{
    width: 700px;
    margin: 100px auto;
  }
 // background-image: linear-gradient(to bottom right,#FFC0CB,#A020F0);
  overflow: hidden;
}
</style>
