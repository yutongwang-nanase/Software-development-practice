<template>
  <div>

    <div style="padding: 10px 0;margin-top: 35px">

      <el-input style="width: 300px" suffix-icon="el-icon-search" v-model="name">

      </el-input>
      <el-button style="margin-left: 10px;" @click="load">搜索</el-button>

    </div>


    <el-row>
      <el-col :span="4" v-for="item in tableData" :key="item" style="margin: 30px">
        <el-card :body-style="{ padding: '50px' }">
          <el-image :src="item.image" style="width: 100%"></el-image>
          <div style="padding: 14px;">
            <span>{{item.name}}</span>
            <div class="bottom clearfix" >
              <span>价格：{{item.price}} </span>
              <p style="margin-top: 5px;line-height: 1.8">产品介绍：{{item.instruction}} </p>
              <p></p>
              <el-button @click="GoShopping(item.id,item.image,item.name,item.price,item.instruction)">跳转</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>


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


<style>
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>

<script>
export default {
  name:"FAKEGOODS",
  data() {
    return {
      currentDate: new Date(),
      tableData: [
        {id: "", image: "", instruction: "", name: "", price:"",}],
      total:0,
      pageNum:1,
      pageSize:5,
      name:""
    };
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

    },
    GoShopping(id,image,name,price,instruction){
      this.$router.push({
        name: "Fakecar",
        params: {
          id: id ,
          image:image,
          name: name,
          price: price,
          instruction:instruction

        }
      });
    },
  },




}
</script>