<template>
  <div class="zhuce">
    <div style="margin: 300px auto ;background: #FFFFFF;width: 450px;height: 300px;padding: 20px">




      <el-card class="box-card">
        <el-tabs v-model="currentIndex" stretch>
          <el-tab-pane label="用户" name="unreceive">
            <div style="margin: 20px; text-align: center; font-size: 24px"><b>注册</b></div>
            <el-input placeholder="请输入用户名" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="user.name"></el-input>
            <el-input placeholder="请输入密码" size="medium" style="margin: 10px" prefix-icon="el-icon-lock"  show-password v-model:prefix-icon="user.password"></el-input>
            <el-input placeholder="请确认密码" size="medium" style="margin: 10px" prefix-icon="el-icon-lock"  show-password v-model:prefix-icon="newpassword"></el-input>
            <el-input placeholder="请输入电话号码" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="user.phonenumber"></el-input>
            <el-input placeholder="请输入住址" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="user.city"></el-input>
            <el-input placeholder="请输入银行卡号" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="user.banknumber"></el-input>
            <el-input placeholder="请输入邮箱" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="user.email"></el-input>
            <el-radio v-model="user.gender" label="1">男</el-radio>
            <el-radio v-model="user.gender" label="0">女</el-radio>
            <div style="margin: 10px;text-align: right">
              <el-button type="primary" @click="login">提交</el-button>
              <el-button @click = "$router.push('/Login')">返回登陆</el-button>
            </div>


          </el-tab-pane>
          <el-tab-pane label="商家" name="isreceive">

            <div style="margin: 20px; text-align: center; font-size: 24px"><b>注册</b></div>
            <el-input placeholder="请输入用户名" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="business.name"></el-input>
            <el-input placeholder="请输入密码" size="medium" style="margin: 10px" prefix-icon="el-icon-lock"  show-password v-model:prefix-icon="business.password"></el-input>
            <el-input placeholder="请确认密码" size="medium" style="margin: 10px" prefix-icon="el-icon-lock"  show-password v-model:prefix-icon="newpassword"></el-input>
            <el-input placeholder="请输入电话号码" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="business.phonenumber"></el-input>
            <el-input placeholder="请输入住址" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="business.city"></el-input>
            <el-input placeholder="请输入银行卡号" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="business.banknumber"></el-input>
            <el-input placeholder="请输入邮箱" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="business.email"></el-input>
            <el-radio v-model="business.gender" label="1">男</el-radio>
            <el-radio v-model="business.gender" label="0">女</el-radio>
            <div style="margin: 10px;text-align: right">
              <el-button type="primary" @click="businesslogin">提交</el-button>
              <el-button @click = "$router.push('/Login')">返回登陆</el-button>
            </div>


          </el-tab-pane>
        </el-tabs>
      </el-card>



    </div>



  </div>
</template>

<script>
export default{
  data(){
    return{
      user:{
        banknumber:'',
        phonenumber:''
      },
      business:{
        businessLevel:5,
      },
      currentIndex:"unreceive",
      form: { gender : 1 },
      newpassword:""
    }
  },
  methods:{
    login(){

      if (this.user.password===this.newpassword){
        this.user.type = 0
        this.user.avatar = ""
        this.user.income = 0
        console.log(this.user)
        this.request.post("http://localhost:9090/user",this.user).then(res =>{
          console.log(res)
          if (!res){
            // this.$message.error("用户名或密码错误")
          }else {
            this.$message.success("注册成功")
          }
        })
        setTimeout('5000')
        this.$router.push("/")
      } else{
        this.$message.warning("两次输入密码不一致")
        this.user.password= ""
        this.newpassword=""
      }



    },
    businesslogin(){

      if (this.business.password===this.newpassword){
        this.business.type = 1
        this.business.avatar = ""
        this.business.income = 0
        this.business.businessLevel = 5
        console.log(this.user)
        this.request.post("http://localhost:9090/user",this.business).then(res =>{
          console.log(res)
          if (!res){
            // this.$message.error("用户名或密码错误")
          }else {
            this.$message.success("注册成功")
          }
        })
        setTimeout('5000')
        this.$router.push("/")
      } else{
        this.$message.warning("两次输入密码不一致")
        this.business.password= ""
        this.newpassword=""
      }



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
  background-image: linear-gradient(to bottom right,#FFC0CB,#A020F0);
  overflow: hidden;
}
</style>
