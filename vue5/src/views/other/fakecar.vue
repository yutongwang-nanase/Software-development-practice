<template>
  <div class="shop">

    <el-card style="margin-right: 100px;margin-top: 10px;margin-left: 100px">

      <div style="display: flex">
        <div style="width:300px">

          <el-image :src="this.$route.params.image" style="width: 100%"></el-image>

        </div>
        <div style="flex: 1;padding-left: 50px">
          <div class="item1"><h3>{{this.$route.params.name}}</h3></div>
          <div class="item1" style="font-size: 14px;padding-left: 15px"><h3>{{this.$route.params.instruction}}</h3></div>
          <div class="item1" style="color: orangered"><h3>￥{{this.$route.params.price}}</h3></div>
          <div>
            <el-input-number v-model="form.num" :min="1" :max="100"></el-input-number>
          </div>
        </div>

      </div>


      <div style="padding-left: 50%">
        <el-button @click="gotolink">back</el-button>
        <el-button @click="addcar">请先登录！！</el-button>
      </div>




    </el-card>




  </div>
</template>


<script>
export default {
  name: "FAKECAR",

  data(){
    return{
      id: this.$route.query.id,
      goods: {},
      form:{num:1}
    }
  },
  created() {

  },
  methods: {
    load() {
      fetch("http://localhost:9090/car?shopid="+ this.id ).then(res => {
        console.log(res)

      })
    },
    gotolink(){
      this.$router.push('/fake');
    },
    addcar(){
      // this.form.goodsId = this.goods.id
      // this.request.post( )
      this.$router.push('/')
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