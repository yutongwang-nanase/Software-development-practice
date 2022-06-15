<template>
  <div class="result-infor-con" style="padding: 250px">
    <i class="el-icon-check" ></i>
    <p class="success-text">用户     {{this.$route.params.userid}}</p>
    <p class="success-text">交易成功</p>
<!--    <p class="success-text">尽快发货</p>-->
    <div class="infor-kv-box">
      <el-table
          :data="tableData"
          border
          fit
          highlight-current-row
      >
        <el-table-column label="订单编号" align="center">
          <template slot-scope="scope" >
            {{ scope.row.id }}
          </template>
        </el-table-column>

        <el-table-column label="实际支付" align="center">
          <template slot-scope="scope">
            {{ scope.row.money/100 }} 元
          </template>
        </el-table-column>
        <el-table-column label="预计本次获取积分" align="center">
          <template slot-scope="scope">
            {{ scope.row.point }}
          </template>
        </el-table-column>
<!--        <el-table-column label="" align="center">-->
<!--          <template slot-scope="scope">-->
<!--           <el-button @click="pay(scope.row.username,scope.row.money,scope.row.point)">确认支付</el-button>-->
<!--          </template>-->
<!--        </el-table-column>-->

      </el-table>
    </div>





    <div class="other-operation">
      <el-button @click="GoId($route.params.userid)">  继续逛逛？ </el-button>
      <el-button @click = "$router.push('/')"> 退出 </el-button>
    </div>
    <div class="main-tips-text" STYLE="color: #A52A2A" >
      <p>重要提示：本平台及销售商不会以订单异常、系统升级为由，要求您点击任何链接进行退款。</p>
    </div>
  </div>
</template>







<script>
export default {
  name: "checkout",
  data(){
    return{
      tableData:[{id:'',money:'',point:''}],
      form:{}

    }
  },
  created() {
    this.$message.success("订单生成成功！！")

    this.getdata()
  },
  methods:{


    getdata(){

      this.request.post("http://localhost:9090/tran/enough1").then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("")
        }
        this.tableData = res

      })







    },
    pay(name,income,point){
      this.form.name = name
      this.form.income = income
      this.form.point = point

      this.request.post("http://localhost:9090/user/income",this.form).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("金额不足请充值")

          this.request.post("http://localhost:9090/tran/demoney").then(res => {
            console.log(res)

          })

        }
        else {

        }

      })

    },

    GoId(id){
      this.$router.push({
        name: "home",
        params: {
          id: id
        }
      });
    },
  }


}
</script>

<style scoped>
.success-text{
    color: #00CD00;
    font-size: xx-large;
}
.el-icon-check{
  font-size: 100px;
  color: #00CD00;
  padding-left: 40%;
}


</style>