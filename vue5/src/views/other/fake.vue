<template>
  <div class="shouye">

    <el-container style="height: 90%; border: 1px solid #eee">
      <div class="left">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
<!--          <Left></Left>-->
        </el-aside>
      </div>


      <div class="right">
        <el-container width="1000px">
          <div class="righttop">

          </div>
          <el-header style="text-align: right; font-size: 12px">
            <FAKERIGHT></FAKERIGHT>
          </el-header>

          <el-main style="margin-top: 350px">


            <FAKEGOODS></FAKEGOODS>
          </el-main>
        </el-container>
      </div>

    </el-container>
  </div>
</template>

<script>

import FAKERIGHT from "@/views/other/fakeright";
import FAKEGOODS from "@/views/other/fakeshop";
export default {
  data() {
    return {
      tableData: [],
      total:0,
      pageNum:1,
      pageSize:2,
      name:""
    }
  },
  created() {


    this.load()


  },

  components:{
    FAKEGOODS,
    FAKERIGHT
  },

  activated() {
    this.init();
  },


  methods:{
    load(){
      fetch("http://localhost:9090/goods/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&name="+this.name).then(res=>res.json()).then(res => {
        console.log(res)
        this.tableData = res.data
        this.total=res.total
      })
    },
    init(){

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




