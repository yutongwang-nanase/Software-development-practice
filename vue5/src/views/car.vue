<template>
  <div id="car">

    <div>
      <h3>您好用户    {{ $route.params.id }}</h3>
      <el-button @click="load">查看商品</el-button>
    </div>



    <el-table
        :data="tableData"
        border
        fit
        highlight-current-row
    >
      <el-table-column label="商品名称" align="center">
        <template slot-scope="scope">
          {{ scope.row.productName }}
<!--          <img :src="scope.row.photo" style="width: 10%;height: 10%">-->
        </template>
      </el-table-column>


      <el-table-column label="商品价格" align="center">
        <template slot-scope="scope">
          {{ scope.row.money/100 }}
        </template>
      </el-table-column>
      <el-table-column label="商家名称" align="center">
        <template slot-scope="scope" >
          {{ scope.row.payee}}
        </template>
      </el-table-column>
<!--      <el-table-column>-->
<!--        <template slot-scope="scope">-->
<!--          <el-button @click="detail()">查看详情</el-button>-->
<!--        </template>-->

<!--      </el-table-column>-->
      <el-table-column>
        <template slot-scope="scope">
          <el-button  @click="Delete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>


    <el-row>
      <el-col :span="1" v-for="item in formdata" :key="item" style="margin-left: 80%">

        <el-button @click="check" style="margin: 10px">结算</el-button>
        <el-button @click="GoId($data.name)">返回主菜单</el-button>

      </el-col>
    </el-row>









    <router-view/>
  </div>
</template>
<script>
export default {
  data() {

    return {
      // tableData: Array(5).fill(item)
      name:this.$route.params.id,

      tableData: [
        {
          id: "",
          ispay: "",
          isreceive: "",
          money: "",
          payee: "",
          payer: "",
          productName: ""
        }],
      form:{
        userid: '',

      },

      formdelete:{
        id:''
      },
      formdata:[{
        userid:'',
        point:'',
        money:''
      }],
      formshop1:{
        userid:'',
        point:'',
        money:''
      },
      formshop2:{
        userid:'',
        point:'',
        money:''
      },
      formcheck:{

      }

    }

  },
  created() {
   this.load()
    // this.request.post("http://localhost:9090/car/last").then(res => {
    //       if (!res) {
    //         this.$message.error("错误")
    //       }
    //       console.log(res)
    //       this.formdata = res
    // })
  },

  methods: {
    load(){
      this.form.payer=this.name
      console.log(name)
      this.request.post("http://localhost:9090/tran/search",this.form).then(res => {
        if (!res) {
          this.$message.error("您还未加入商品进入购物车哦")
        }
        console.log(res)
        this.tableData = res
        // this.formeva = res.data
      })


      // this.form.userid=this.$route.params.id

      // // 计算商品总价
      // this.request.post("http://localhost:9090/car/check",this.form).then(res => {
      //   // if (!res) {
      //   //   this.$message.error("错误")
      //   // }
      //   console.log(res)
      //
      // })


    },

    Delete(row){
      this.formdelete.id = row
      console.log(this.formdelete.id)
      this.request.post("http://localhost:9090/tran/delete",this.formdelete).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("错误")
        }else {
          this.$message.success("删除成功")
        }

      })
    },
    // detail(){
    //
    // },
    // getdata(){
    //   this.request.post("http://localhost:9090/car/last").then(res => {
    //     if (!res) {
    //       this.$message.error("错误")
    //     }
    //
    //   })
    // },
    //
    //
    check(){
      this.formcheck.payer = this.$route.params.id
      this.formcheck.name = this.$route.params.id
      this.$message.warning("结算中")
      this.request.post("http://localhost:9090/tran/money",this.formcheck).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("错误")
        }
        this.check2()
      })




    },
    check2(){

      this.request.post("http://localhost:9090/tran/enough").then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("")
        }
        this.formcheck.income = res

        console.log(this.formcheck)
        this.request.post("http://localhost:9090/user/income",this.formcheck).then(res => {
          console.log(res)
          if (!res) {
            this.$message.error("金额不足请充值")

            this.request.post("http://localhost:9090/tran/demoney").then(res => {
              console.log(res)

            })

          }
          else {
            this.request.post("http://localhost:9090/tran/check",this.formcheck).then(res => {
              console.log(res)
              this.$router.push({
                name: "Checkout",
                params: {
                  userid: this.$route.params.id,
                  income: this.formcheck.income
                }
              })

            })

          }

        })



      })







    },
    //
    // checkout(userid,point,money,num){
    //
    //     this.formshop1.username = userid
    //     this.formshop1.point = point
    //     this.formshop1.money = money
    //     this.formshop1.num = num
    //     console.log(this.formshop1)
    //     this.request.post("http://localhost:9090/user/changeback",this.formshop1).then(res => {
    //       if (!res) {
    //         // this.$message.error("错误")
    //       }
    //       console.log(res)
    //
    //     })
    //
    // //   扣款,更新积分
    //  this.formeva.userid = this.$route.params.id
    //   console.log(this.formeva)
    //   this.request.post("http://localhost:9090/eva/insert",this.formeva).then(res => {
    //     if (!res) {
    //       // this.$message.error("错误")
    //     }
    //     console.log(res)
    //
    //   })
    //
    //
    //
    //   this.formshop2.userid = userid.toString()
    //   //删除购物车商品
    //   this.request.post("http://localhost:9090/car/deleteall",this.formshop2).then(res => {
    //     if (!res) {
    //       this.$message.error("错误")
    //     }
    //     console.log(res)
    //   })
    //
    //   this.formshop1.userid=this.$route.params.id
    //
    //   // 购物记录保存到shop表
    //
    //   this.request.post("http://localhost:9090/car/shop",this.formshop1).then(res => {
    //     if (!res) {
    //       this.$message.error("错误")
    //     }
    //     this.check()
    //     console.log(res)
    //
    //
    //   })
    //
    //
    // },
    GoId(id){
      this.$router.push({
        name: "home",
        params: {
          id: id
        }
      });
    },
  }
};
</script>