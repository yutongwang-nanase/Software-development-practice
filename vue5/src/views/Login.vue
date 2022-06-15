<template>
	<div class="login">
		<div style="margin: 300px auto ;background: #FFFFFF;width: 450px;height: 300px;padding: 20px">
      <div style="margin: 20px; text-align: center; font-size: 24px"><b>登录</b></div>
      <el-input placeholder="请输入用户名" size="medium" style="margin: 10px" prefix-icon="el-icon-user" v-model:prefix-icon="user.username"></el-input>
      <el-input placeholder="请输入密码" size="medium" style="margin: 10px" prefix-icon="el-icon-lock"  show-password v-model:prefix-icon="user.password"></el-input>
      <div style="width: 450px;height: 50px;margin-left: 10px;margin-top: 5px">
        <el-input v-model="inputVal" style="width:150px ;" clearable />
        <validate-code ref="ref_validateCode" @change="changeCode"  style="margin-left: 20px; vertical-align:middle " />
        {{result}}
      </div>

      <div style="margin: 10px;text-align: right">
        <el-link  @click = "$router.push('./fake')"  icon="el-icon-shopping-cart-2" target="_blank" style="margin-right: 20px">暂时先不登陆~~</el-link>
        <el-button type="primary" @click="login">提交</el-button>
        <el-button >重置</el-button>
        <el-button @click = "$router.push('./register')">注册</el-button>
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
        inputVal: "",
        checkCode: "",
        result: "",
				user:{

        },
        check:{

        }

			}
		},
		methods:{
        login() {
          if (this.inputVal.toUpperCase() === this.checkCode) {
            this.result = "☑";
            this.request.post("http://localhost:9090/user/login", this.user).then(res => {
              if (!res) {
                this.$message.error("用户名或密码错误")
              } else {

                this.user.name = this.user.username
                this.request.post("http://localhost:9090/user/check", this.user).then(res => {
                  console.log(res)
                  if (res === 0 || res === -1) {
                    this.$message.error("审核中或审核未通过")
                  }
                  else this.GoId(this.user.username)

                })



              }
            })
          } else {
            this.$message.error("验证码错误")
            this.result = "✘";
            this.inputVal = "";
            this.$refs["ref_validateCode"].draw();
          }
        },
      GoId(id){
        this.$router.push({
          name: "home",
          params: {
            id: id
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
    background-image: linear-gradient(to bottom right,#FFC0CB,#A020F0);
    overflow: hidden;
	}
</style>
