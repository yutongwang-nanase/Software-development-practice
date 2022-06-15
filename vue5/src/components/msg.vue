<template>
  <div>

    <div style="padding: 10px 0">

      <el-input style="width: 300px" suffix-icon="el-icon-search" v-model="name">

      </el-input>
      <el-button style="margin-left: 10px;" @click="load">搜索</el-button>

    </div>



    <el-table :data="tableData" >
      <el-table-column prop="name" label="名称" width="120">
      </el-table-column>
      <el-table-column prop="image" label="照片" width="120">
      </el-table-column>
      <el-table-column prop="price" label="价格" width="120">
      </el-table-column>
      <el-table-column prop="instruction" label="介绍" width="120">
      </el-table-column>
      <el-table-column>
        <el-button type="success">编辑</el-button>
        <el-button type="danger">删除</el-button>
      </el-table-column>
    </el-table>
    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
  </div>





</template>

<script>

  export default {
    name: "MSG",
    data() {
      return {
        tableData: [],
        total:0,
        pageNum:1,
        pageSize:5,
        name:""
      }
    },
    created() {
      this.load()
    },


    methods:{
        load(){
        fetch("http://localhost:9090/goods/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&name="+this.name).then(res=>res.json()).then(res => {
          console.log(res)
          this.tableData = res.data
          this.total=res.total
        })
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

<style scoped>

</style>