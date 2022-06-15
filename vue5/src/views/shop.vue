<template>
<div class="shop">

  <el-card style="margin-right: 100px;margin-top: 10px;margin-left: 100px">

    <div style="display: flex">
      <div style="width:300px">
<!--        {{this.$route.params.id}}-->
        <el-image :src="this.$route.params.image" style="width: 100%"></el-image>

      </div>
      <div style="flex: 1;padding-left: 50px">
        <div class="item1"><h5>{{this.$route.params.publish}}</h5></div>
          <div class="item1"><h3>{{this.$route.params.name}}</h3></div>
        <div class="item1" style="font-size: 14px;padding-left: 15px"><h3>{{this.$route.params.instruction}}</h3></div>
        <div class="item1" style="color: orangered"><h3>￥{{this.$route.params.price/100}}</h3></div>
        <div>
<!--          <el-input-number v-model="form.num" :min="1" :max="100"></el-input-number>-->
          <span>    剩余库存   {{this.$route.params.num}}</span>
        </div>
      </div>

    </div>


      <div style="padding-left: 50%">
        <el-button @click="GoId($data.id)">back</el-button>
        <el-button @click="addcar">加入购物车</el-button>
      </div>




  </el-card>

  <el-table
      :data="tableData3"
      style="margin-top: 50px"
      highlight-current-row

  >

    <el-table-column label="评论内容" align="center">
      <template slot-scope="scope">
        {{ scope.row.comment }}
      </template>
    </el-table-column>

    <el-table-column label="评论时间" align="center">
      <template slot-scope="scope">
        {{ scope.row.createdAt }}
      </template>
    </el-table-column>

  </el-table>


</div>
</template>


<script>

export default {
name: "shop",

  data(){

  return{
    id: this.$route.params.userid,
    goods: {},
    form:{

          userid:'',
          photo:'',
          num:1
    },
    form2:{
      name:this.$route.params.userid,

    },
    form3:{
      name:this.$route.params.publish
    },
    tableData3:[{
      createdAt:""
    }],
    form1:{

    }


  }
  },
  created() {
   this.pingjia()
    this.request.post("http://localhost:9090/user/getid",this.form2).then(res =>{
      this.form.userid = res
    })
    this.request.post("http://localhost:9090/user/getlevel",this.form3).then(res =>{
      this.form.businessLevel = res
    })
  },
  methods: {
    load() {
      fetch("http://localhost:9090/car?shopid="+ this.id  ).then(res => {
        console.log(res)

      })
    },
      gotolink(id){
        this.$router.push({
          name:"home",
          params:{
            id:id
          }
        });
      },
    GoId(id){
      this.$router.push({
        name: "home",
        params: {
          id: id
        }
      });
    },
    addcar(){






      //this.form.productName=this.$route.params.id
      this.form.productid = this.$route.params.id
      this.form.payer=this.$route.params.userid
      this.form.money = this.$route.params.price
     // this.form.photo = this.$route.params.image
      this.form.productName = this.$route.params.name
     // this.form.publish = this.$route.params.publish
      this.form.payee = this.$route.params.publish
      this.form.ispay = 0
      this.form.isreceive = 0
      this.form.name = this.$route.params.publish
      console.log(this.form)



      this.request.post("http://localhost:9090/user/level", this.form).then(res => {

        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }
        this.form.businessLevel = res
      })

      this.request.post("http://localhost:9090/tran", this.form).then(res => {

        console.log(res)
        if (!res) {
          this.$message.error("失败")
        } else {
          this.$message.success("加入成功")

        }
      })
      // 数据库减去对应的商品数量并更新
      // if (this.form.userid !=null){
      //   this.form.name = this.$route.params.name
      //   this.form.history = this.form.num
      //   this.form.trips= 1
      //   console.log(this.form)
      //   this.request.post("http://localhost:9090/goods/update",this.form).then(res => {
      //     if (!res) {
      //       this.$message.error("错误")
      //     }
      //     console.log(res)
      //
      //   })
      // }



    },

    GoShopping(id,image,name,price,instruction,userid){

      this.$router.push({
        name: "Shop",
        params: {
          id: id ,
          image:image,
          name: name,
          price: price,
          instruction:instruction,
          userid:userid

        }
      });
    },
    pingjia(){

      this.form1.productId = this.$route.params.id
      this.request.post("http://localhost:9090/comment/search",this.form1).then(res => {
        // if (!res) {
        //   this.$message.error("错误")
        // }
        console.log(res)
        this.tableData3 = res

      })

    }

    }

}
</script>

<style scoped>

.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.item1{
  padding: 5px;
  color: #666;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

</style>