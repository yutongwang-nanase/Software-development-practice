<template>
  <div>

    <div style="padding: 10px 0;margin-top: 35px">

      <el-input style="width: 300px" suffix-icon="el-icon-search" v-model="productname">

      </el-input>
      <el-button style="margin-left: 10px;margin-top: 100px" @click="load">搜索</el-button>

    </div>


    <el-row>
      <el-col :span="4" v-for="item in tableData" :key="item" style="margin: 30px">
        <el-card :body-style="{ padding: '30px' }">
          <el-image :src="item.productimage" style="width: 100%"></el-image>
          <div style="padding: 14px;">
            <span>{{item.productName}}</span>
            <div class="bottom clearfix" >
              <span>价格：{{item.productprice/100}} </span>
              <p style="margin-top: 5px;line-height: 1.8">产品介绍：{{item.productinstruction}} </p>
<!--              <span>{{$route.params.id}}</span>-->
              <el-button @click="GoShopping(item.id,item.productimage,item.productName,item.productprice,item.productinstruction,$route.params.id,item.productstock,item.publishername)">查看详情</el-button>

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
          :page-sizes="[8, 16, 24]"
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
const that = this
export default {
  name:"GOODS",
  data() {
    return {
      currentDate: new Date(),
      form:{

      },
      tableData: [
        {
          id: "",
          productName: "",
          productdiscount: '',
          productimage: "",
          productinstruction: "",
          productprice: '',
          productstock: '',
          producttype: "",
          publishername: ""
        }],
      total:0,
      pageNum:1,
      pageSize:8,
      productname:'',


    };
  },
  created() {
    this.load()
  },



  methods:{
    load(){

      // this.form.pageNum = 1
      // this.form.pageSize = 8
      // this.form.productName = ""
      // this.request.post("http://localhost:9090/goods/page",this.form).then(res => {
      //
      //   console.log(res)
      //   this.tableData = res.data
      //   this.total=res.total
      // })



      fetch("http://localhost:9090/goods/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&productname="+this.productname)
          .then(res=>res.json()).then(res => {
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
    GoShopping(id,image,name,price,instruction,userid,num,publish){

      this.$router.push({
        name: "Shop",
        params: {
          id: id ,
          image:image,
          name: name,
          price: price,
          instruction:instruction,
          userid:userid,
          num: num,
          publish:publish,

        }
      });
    },
  },




}
</script>