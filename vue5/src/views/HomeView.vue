<template>
  <div class="shouye">
<!--    <el-button @click="$router.push('./shop')">切换界面</el-button>-->
    <el-container style="height: 90%; border: 1px solid #eee">
      <div class="left">
        <el-aside width="150px" style="background-color: rgb(238, 241, 246)">
<!--        <Left></Left>-->
        </el-aside>
      </div>


      <div class="right">
        <el-container width="1000px">
          <div class="righttop">

          </div>
          <el-header style="text-align: right; font-size: 12px">
<!--          <Right></Right>-->
            <div id="Right" style="width: 1400px ">
              <el-button @click="gocar($route.params.id)" icon="el-icon-shopping-cart-2" target="_blank" style="margin-right: 20px">购物车</el-button>

              <el-dropdown>
                <i class="el-icon-setting" style="margin-right: 15px"></i>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item @click.native="GoId($route.params.id)">查看</el-dropdown-item>

                  <el-dropdown-item @click.native="$router.push('/')">退出</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>

              <span>{{this.$route.params.id}}</span>

              <div id="img_show" style="margin-top: 50px">
                <el-carousel :interval="4000" type="card" height="350px"  width="1000px" indicator-position="outside" style="background: #F5F5F5">
                  <el-carousel-item v-for="item in imgs" :key="item.id" @click="">
                    <img :src="item.img" class="image" width="100%" height="90%">
                  </el-carousel-item>
                </el-carousel>
              </div>

              <!--  <div class = "top">-->

              <!--    <img alt="top advertising" src="@/assets/img/top1.jpg">-->

              <!--  </div>-->

            </div>



          </el-header>

          <el-main style="margin-top: 350px">


            <GOODS></GOODS>
            <img src="//i0.hdslb.com/bfs/archive/ba85138129ecbd9d8b59f7fc19f1d47bf0c8b5c8.png@3840w_360h_1c_90q" alt="" loading="eager" onload="">
          </el-main>
        </el-container>
      </div>

    </el-container>
  </div>
</template>

<script>
import Left from "@/components/Left";
import MSG from "@/components/msg";
import Right from "@/components/Right";
import GOODS from "@/views/shangpin";

export default {

  data() {
    return {
      tableData: [],
      total:0,
      pageNum:1,
      pageSize:2,
      name:"",
      id:this.$route.params.id,
      imgs: [
        {
          id: 1, img: require('../assets/img/top1.jpg')
        },
        {
          id: 2, img: require('../assets/img/top2.jpg')
        },
        {
          id: 3, img: require('../assets/img/top3.jpg')
        },

        {
          id: 4, img: require('../assets/img/top4.jpg')
        },

        {
          id: 5, img: require('../assets/img/top5.jpg')
        },


      ]
    }
  },
  created() {


    this.load()


  },

  components:{
    GOODS,
    MSG,
    Left,
    Right
  },

  activated() {
    this.init();
  },


  methods:{
    load(){
      // fetch("http://localhost:9090/goods/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&name="+this.name).then(res=>res.json()).then(res => {
      //   console.log(res)
      //   this.tableData = res.data
      //   this.total=res.total
      // })
    },
    init(){

    },
    gocar(id){

      this.$router.push({
        name: "Car",
        params: {
          id: id
        }
      });
    },

    GoId(id){
      this.$router.push({
        name: "Message",
        params: {
          id: id
        }
      });
    },




    handleSizeChange(pageSize){
      this.pageSize = pageSize
      this.load()
    },

    handleCurrentChange(pageNum){
      this.pageNum = pageNum
      this.load()

    }
  },




};
</script>

<style  >
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
/* .el-table{
   display: inline-flex;
 } */
</style>




