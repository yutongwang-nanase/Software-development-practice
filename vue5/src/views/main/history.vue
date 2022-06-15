<template>
<div>
  <el-button @click="GoId">返回 </el-button>

  <el-table
      :data="tableData3"
      style="margin-top: 50px"
      highlight-current-row
  >
    <el-table-column label="商品名" align="center">
      <template slot-scope="scope">
        {{ scope.row.goodsname }}
      </template>
    </el-table-column>
    <el-table-column label="购买时间" align="center">
      <template slot-scope="scope">
        {{ scope.row.time }}
      </template>
    </el-table-column>
    <el-table-column label="" align="center">
      <template slot-scope="scope">
        <img :src="scope.row.photo" style="width: 80px">
      </template>
    </el-table-column>
    <el-table-column label="商品单价" align="center">
      <template slot-scope="scope">
        {{ scope.row.price }} 元
      </template>
    </el-table-column>
    <el-table-column label="" align="center">
      <template slot-scope="scope">
        <el-button @click="pingjia(scope.row.id)">点击评价</el-button>


        <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
          <span></span>
          <el-input placeholder="请输入评价" size="medium" style="margin: 10px" prefix-icon="el-icon-edit-outline" v-model:prefix-icon="formeva.eva"></el-input>

          <el-input-number v-model="formeva.star" @change="handleChange" :min="1" :max="5" label="评价"></el-input-number>
                   <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="commit()">确 定</el-button>
          </span>
        </el-dialog>
      </template>
    </el-table-column>
  </el-table>
</div>
</template>

<script>
export default {
  name: "history",
  data(){
    return{

      tableData3:[{
        "userid": "",
        "goodsid":'',
        "goodsname":"",
        "price": '',
        "time":'',
        "photo":""
      }],
      form:{
        userid:this.$route.params.name
      },
      formeva:{

        eva:"",
        star: 5
      },
      dialogVisible:false
    }

  },
  created() {
    this.load()
  },
  methods:{
    load(){

      this.request.post("http://localhost:9090/eva/search",this.form).then(res => {
        // if (!res) {
        //   this.$message.error("错误")
        // }
        console.log(res)
        this.tableData3 = res
        console.log(this.tableData3)
      })

    },
    pingjia(id){
      this.dialogVisible = true
      this.formeva.id = id

    },
    commit() {
      this.dialogVisible = false
      this.request.post("http://localhost:9090/eva/up",this.formeva).then(res => {
        // if (!res) {
        //   this.$message.error("错误")
        // }
        console.log(res)
        // this.tableData3 = res

      })
    },
    handleChange(value) {
      console.log(value);
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
    },
    GoId(){
      this.$router.push({
        name: "Message",
        params: {
          id: this.$route.params.name
        }
      });
    },
  }

}
</script>

<style scoped>

</style>