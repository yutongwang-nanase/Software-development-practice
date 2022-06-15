<template>





<!--        background-color="#545c64"-->
<!--        text-color="#fff"-->
<!--        active-text-color="#ffd04b"-->



<div>




<el-button @click="GoId($route.params.id)">返回主菜单</el-button>
  <el-button @click="load">刷新</el-button>
  <span> 您好用户：  {{this.$route.params.id}}</span>
  <el-table
      :data="tableData"
      border
      fit
      highlight-current-row
  >

    <el-table-column label="用户id" align="center">
      <template slot-scope="scope">
        {{ scope.row.id }}
      </template>
    </el-table-column>
    <el-table-column label="电话号码" align="center">
      <template slot-scope="scope">
        {{ scope.row.phonenumber }}
        <el-button type="text" @click="update2(scope.row.id,scope.row.money,scope.row.point)">点击修改</el-button>

        <el-dialog
            :visible.sync="dialogVisible1"
            width="30%"
            :before-close="handleClose">
          <span></span>
          <el-input   v-model:prefix-icon="user.phonenumber"></el-input>
          <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible1 = false">取 消</el-button>
          <el-button type="primary" @click="commit2()">确 定</el-button>
          </span>
        </el-dialog>
      </template>
    </el-table-column>
    <el-table-column label="email" align="center">
      <template slot-scope="scope" >

        {{ scope.row.email }}
        <el-button type="text" @click="update3(scope.row.id,scope.row.money,scope.row.point)">点击修改</el-button>

        <el-dialog
            :visible.sync="dialogVisible2"
            width="30%"
            :before-close="handleClose">
          <span></span>
          <el-input   v-model:prefix-icon="user.email"></el-input>
          <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible2 = false">取 消</el-button>
          <el-button type="primary" @click="commit3()">确 定</el-button>
          </span>
        </el-dialog>
      </template>
    </el-table-column>
    <el-table-column label="住址" align="center">
      <template slot-scope="scope">
        {{ scope.row.city }}
        <el-button type="text" @click="update4(scope.row.id,scope.row.money,scope.row.point)">点击修改</el-button>

        <el-dialog
            :visible.sync="dialogVisible3"
            width="30%"
            :before-close="handleClose">
          <span></span>
          <el-input   v-model:prefix-icon="user.city"></el-input>
          <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible3 = false">取 消</el-button>
          <el-button type="primary" @click="commit4()">确 定</el-button>
          </span>
        </el-dialog>
      </template>
    </el-table-column>
    <el-table-column label="银行卡号" align="center">
      <template slot-scope="scope">
        {{ scope.row.banknumber }}
        <el-button type="text" @click="update5(scope.row.id,scope.row.money,scope.row.point)">点击修改</el-button>

        <el-dialog
            :visible.sync="dialogVisible4"
            width="30%"
            :before-close="handleClose">
          <span></span>
          <el-input   v-model:prefix-icon="user.banknumber"></el-input>
          <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible4 = false">取 消</el-button>
          <el-button type="primary" @click="commit5()">确 定</el-button>
          </span>
        </el-dialog>
      </template>
    </el-table-column>
    <el-table-column label="用户剩余金额" align="center">
      <template slot-scope="scope">
        {{ scope.row.income /100 }} 元
        <el-button type="text" @click="dialogVisible = true">点击充值</el-button>

        <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
          <span></span>
          <el-input placeholder="请输入充值金额" size="medium" style="margin: 10px" prefix-icon="el-icon-edit-outline" v-model:prefix-icon="user.income"></el-input>
          <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="commit()">确 定</el-button>
          </span>
        </el-dialog>
<!--        <el-button type="primary" plain>充值</el-button>-->
      </template>

    </el-table-column>
    <el-table-column label="积分" align="center">
      <template slot-scope="scope">
        {{ scope.row.point }}
      </template>
    </el-table-column>
    <el-table-column  align="center" >
      <template slot-scope="scope">

        <el-button type="danger" @click="Gochange(scope.row.id,scope.row.money,scope.row.point)">修改密码</el-button>
      </template>
    </el-table-column>






  </el-table>


  <el-card class="box-card">
    <el-tabs v-model="currentIndex" stretch>
      <el-tab-pane label="未收货" name="unreceive">
        <el-table
            :data="tableData2"
            style="margin-top: 50px"
            highlight-current-row
        >
          <el-table-column label="订单号" align="center">
            <template slot-scope="scope">
              {{ scope.row.id }}
            </template>
          </el-table-column>
          <el-table-column label="产品名称" align="center">
            <template slot-scope="scope">
              {{ scope.row.productName }}
            </template>
          </el-table-column>
          <el-table-column label="购物下单时间" align="center">
            <template slot-scope="scope">
              {{ scope.row.createdAt }}
            </template>
          </el-table-column>

          <el-table-column label="实缴金额" align="center">
            <template slot-scope="scope">
              {{ scope.row.money /100}} 元
            </template>
          </el-table-column>
          <el-table-column label="商家名称" align="center">
            <template slot-scope="scope">
              {{ scope.row.payee }}
            </template>
          </el-table-column>
          <el-table-column label="订单跟踪" align="center">
            <template slot-scope="scope" >
              未收货
            </template>
          </el-table-column>
<!--          <el-table-column label="" align="center">-->
<!--            <template slot-scope="scope">-->
<!--              <el-button @click="history()">评价</el-button>-->
<!--            </template>-->
<!--          </el-table-column>-->
<!--          <el-table-column label="" align="center">-->
<!--            <template slot-scope="scope">-->
<!--              <el-button @click="history()" type="warning" plain>退货</el-button>-->
<!--            </template>-->
<!--          </el-table-column>-->
        </el-table>

      </el-tab-pane>
      <el-tab-pane label="已收货" name="isreceive">

        <el-table
            :data="tableData4"
            style="margin-top: 50px"
            highlight-current-row
        >
          <el-table-column label="订单号" align="center">
            <template slot-scope="scope">
              {{ scope.row.id }}
            </template>
          </el-table-column>
          <el-table-column label="产品名称" align="center">
            <template slot-scope="scope">
              {{ scope.row.productName }}
            </template>
          </el-table-column>
          <el-table-column label="购物下单时间" align="center">
            <template slot-scope="scope">
              {{ scope.row.createdAt }}
            </template>
          </el-table-column>

          <el-table-column label="实缴金额" align="center">
            <template slot-scope="scope">
              {{ scope.row.money /100}} 元
            </template>
          </el-table-column>
          <el-table-column label="商家名称" align="center">
            <template slot-scope="scope">
              {{ scope.row.payee }}
            </template>
          </el-table-column>
          <el-table-column label="订单跟踪" align="center">
            <template slot-scope="scope" >
              已收货
            </template>
          </el-table-column>
          <el-table-column label="" align="center">
            <template slot-scope="scope">
              <el-button @click="update6(scope.row.productName,scope.row.payer,scope.row.payee,scope.row.money)">退货</el-button>
                  <el-dialog
                      :visible.sync="dialogVisible6"
                      width="30%"
                      :before-close="handleClose">
                    <span></span>
                    <el-input   v-model:prefix-icon="form6.requestMessage"></el-input>
                    <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible6 = false">取 消</el-button>
                    <el-button type="primary" @click="commit6()">确 定</el-button>
                    </span>
                  </el-dialog>
            </template>
          </el-table-column>
          <el-table-column label="" align="center">
            <template slot-scope="scope">
              <el-button @click="update7(scope.row.productid,scope.row.userid)" type="warning" plain>评价</el-button>
              <el-dialog
                  :visible.sync="dialogVisible7"
                  width="30%"
                  :before-close="handleClose">
                <span></span>

                  <el-radio v-model="form7.type" label="1">好评</el-radio>
                  <el-radio v-model="form7.type" label="0">差评</el-radio>


                <el-input   v-model:prefix-icon="form7.comment"></el-input>




                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible7 = false">取 消</el-button>
                    <el-button type="primary" @click="commit7()">确 定</el-button>
                    </span>
              </el-dialog>
            </template>
          </el-table-column>
        </el-table>

      </el-tab-pane>
    </el-tabs>
  </el-card>





  <el-table
      :data="tableData3"
      style="margin-top: 50px"
      highlight-current-row
  >
<!--    <el-table-column label="消费/充值" align="left">-->
<!--      <template slot-scope="scope">-->
<!--      </template>-->
<!--    </el-table-column>-->
    <el-table-column label="消费/充值单号" align="center" >
      <template slot-scope="scope">
        {{ scope.row.id }}
      </template>
    </el-table-column>
    <el-table-column label="充值/消费时间" align="center">
      <template slot-scope="scope">
        {{ scope.row.createdAt }}
      </template>
    </el-table-column>

    <el-table-column label="金额" align="center">
      <template slot-scope="scope">
        {{ scope.row.money /100 }} 元
      </template>
    </el-table-column>
    <el-table-column label="获得积分" align="center">
      <template slot-scope="scope">
        {{ scope.row.point }}
      </template>
    </el-table-column>

  </el-table>
</div>




<!--  <div>-->


<!--    <el-table-->
<!--        :data="tableData2"-->
<!--    >-->
<!--      <el-table-column label="订单号" align="center">-->
<!--        <template slot-scope="scope">-->
<!--          {{ scope.row.id }}-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="购物下单时间" align="center">-->
<!--        <template slot-scope="scope">-->
<!--          {{ scope.row.time }}-->
<!--        </template>-->
<!--      </el-table-column>-->

<!--      <el-table-column label="实缴金额" align="center">-->
<!--        <template slot-scope="scope">-->
<!--          {{ scope.row.money }} 元-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="新增积分" align="center">-->
<!--        <template slot-scope="scope">-->
<!--          {{ scope.row.point }}-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->
<!--  </div>-->

</template>

<script>
export default {
  name: "message",

  data(){
    return{
      currentIndex:"unreceive",
      dialogVisible:  false,
      dialogVisible1: false,
      dialogVisible2: false,
      dialogVisible3: false,
      dialogVisible4: false,
      dialogVisible6: false,
      dialogVisible7: false,
      user:{
        username: this.$route.params.id
      },
      tableData:[{
        "username": "",
        "password": "",
        "phonenum": '',
        "email": '',
        "city":'',
        "gender": '',
        "banknumber": '',
        "type": '',
        "point": '',
        "money": ''
      }],
      tableData2:[{
        "id": '',
        "createdAt": "",
        "updatedAt": "",
        "productName": "",
        "payer": "",
        "payee": "",
        "money": '',
        "businessLevel": '',
        "isreceive": '',
        "ispay": '',
        "state":"交易进行中"
      }],
      tableData3:[{
        "name": "",
        "id":'',
        "time":"",
        "money": ''
      }],
      tableData4:[{
        "username": "",
        "password": "",
        "phonenum": '',
        "email": '',
        "city":'',
        "gender": '',
        "account": '',
        "type": '',
        "point": '',
        "money": '',
        "state":"未收货"
      }],
      form:{
        name: this.$route.params.id
      },
      form2:{
        payer: this.$route.params.id
      },
      form3:{
        username: this.$route.params.id
      },
      form6:{
        requestMessage:''
      },
      form7:{
        type : 1
      }
    }
  },
  created() {
    this.search()


  },
  methods:{

    search(){
      this.request.post("http://localhost:9090/user/findone", this.form).then(res => {
        console.log(this.form)
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }
        this.tableData = res
        console.log(this.tableData)
        this.search2()
      })
    },
    search2(){
      this.request.post("http://localhost:9090/tran/all", this.form2).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }
        this.tableData2 = res
        // let item = this.tableData2.find(item => {
        //   return item.isreceive == 1;
        // });
        // console.log(item)
        // this.tableData4 = item
        // console.log(this.tableData4)

      })
      this.request.post("http://localhost:9090/tran/all2", this.form2).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }
        this.tableData4 = res
        // let item = this.tableData2.find(item => {
        //   return item.isreceive == 1;
        // });
        // console.log(item)
        // this.tableData4 = item
        // console.log(this.tableData4)
        this.search3()
      })
    },
    search3(){
      this.request.post("http://localhost:9090/money", this.form3).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }
        this.tableData3 = res

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
    handleClose(done) {
      this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
    },
    commit(){
      this.dialogVisible = false
      console.log(this.user)
      const m = this.user.income
      this.user.income = m*100
      // this.form3.money = parseInt(this.user.money)
      this.request.post("http://localhost:9090/user/money", this.user).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }
        this.tableData2 = res

      })
      this.user.id = ''
      this.user.name = this.$route.params.id
      this.user.money = this.user.income
      this.user.ispay = 1
      console.log(this.user)
      this.request.post("http://localhost:9090/money/insertmoney", this.user).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }


      })

    },
    commit2(){
      this.dialogVisible1 = false
      console.log(this.user)
      this.request.post("http://localhost:9090/user/updateuser", this.user).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }

      })
      // this.form3.money = parseInt(this.user.money)
      // this.update()
    },
    commit3(){
      this.dialogVisible2 = false
      console.log(this.user)
      this.request.post("http://localhost:9090/user/updateuser", this.user).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }

      })
      // this.form3.money = parseInt(this.user.money)
      // this.update()
    },
    commit4(){
      this.dialogVisible3 = false
      console.log(this.user)
      this.request.post("http://localhost:9090/user/updateuser", this.user).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }

      })
      // this.form3.money = parseInt(this.user.money)
      // this.update()
    },
    commit5(){
      this.dialogVisible4 = false
      console.log(this.user)
      this.request.post("http://localhost:9090/user/updateuser", this.user).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }

      })
      // this.form3.money = parseInt(this.user.money)
      // this.update()
    },
    commit6(){
      this.dialogVisible6 = false

      console.log(this.form6)
      this.request.post("http://localhost:9090/return", this.form6).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }
        else this.$message.success("创建退货申请成功，详情请登陆后台管理系统查看")

      })

    },
    commit7(){
      this.dialogVisible7= false

      this.request.post("http://localhost:9090/comment", this.form7).then(res => {
        console.log(res)
        if (!res) {
          this.$message.error("失败")
        }

      })

    },

    update2(id,money,point){
      // console.log(this.form3)
      this.dialogVisible1 = true
      console.log(id)
      this.user.id = id
      this.user.money = money
      this.user.point = point

    },
    update3(id,money,point){
      // console.log(this.form3)
      this.dialogVisible2 = true
      console.log(id)
      this.user.id = id
      this.user.money = money
      this.user.point = point

    },
    update4(id,money,point){
      // console.log(this.form3)
      this.dialogVisible3 = true
      console.log(id)
      this.user.id = id
      this.user.money = money
      this.user.point = point

    },
    update5(id,money,point){
      // console.log(this.form3)
      this.dialogVisible4 = true
      console.log(id)
      this.user.id = id
      this.user.money = money
      this.user.point = point

    },
    update6(goodsname,payer,payee,money){
      // console.log(this.form3)
      this.dialogVisible6 = true

      this.form6.userName = payer
      this.form6.businessMan = payee
      this.form6.productName = goodsname
      this.form6.money = money
      this.form6.status = 0
      console.log(this.form6)
    },
    update7(goodsname,payer){
      // console.log(this.form3)
      this.dialogVisible7 = true

      this.form7.userId = payer
      this.form7.productId = goodsname

    },
    update(){
      // console.log(this.form3)

      //
    },
    load(){
      this.search()
    },
    Gochange(id,money,point){
      this.$router.push({
        name: "Recharge",
        params: {
          name: this.$route.params.id,
          id:id,
          money:money,
          point:point
        }
      });
    },




  }
}
</script>

<style scoped>

</style>