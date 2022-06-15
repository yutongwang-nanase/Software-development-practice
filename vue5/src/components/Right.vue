<template>
<div id="Right" style="width: 1400px ">
  <el-link href="https://element.eleme.io"  icon="el-icon-shopping-cart-2" target="_blank" style="margin-right: 20px">默认链接</el-link>

  <el-dropdown>
    <i class="el-icon-setting" style="margin-right: 15px"></i>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item>查看</el-dropdown-item>

      <el-dropdown-item @click.native="this.$router.push('/car')">退出</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>

  <span>{{this.$route.params.id}}</span>

  <div id="img_show">
    <el-carousel :interval="4000" type="card" height="350px"  width="1000px" indicator-position="outside" style="background: #F5F5F5">
      <el-carousel-item v-for="item in imgs" :key="item.id">
        <img :src="item.img" class="image" width="100%" height="90%">
      </el-carousel-item>
    </el-carousel>
  </div>

  <!--  <div class = "top">-->

<!--    <img alt="top advertising" src="@/assets/img/top1.jpg">-->

<!--  </div>-->

</div>
</template>

<script>
import login from "@/views/Login";

export default {
  name:'img_show',
  data () {
    return {
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
  methods:{
    Golg(){

    }
  }

}
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}
.el-carousel__item:nth-child(1) {

}
img_show{
  background-color: dimgrey;
  padding-top: 50px;
  width: auto;
}
img{
  align-content: center;
}

</style>