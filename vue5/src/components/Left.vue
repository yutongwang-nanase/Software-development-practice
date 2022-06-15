<template>
  <div>
    <el-menu :default-openeds="['1', '3']">

      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>导航二</template>
        <el-menu-item-group>
          <template slot="title">商品</template>
          <el-menu-item index="2-1">商品</el-menu-item>
          <el-menu-item index="2-2">商品</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="2-3">商品</el-menu-item>
        </el-menu-item-group>


          <el-menu-item index="2-4-1">商品</el-menu-item>

      </el-submenu>

    </el-menu>
  </div>

</template>

<script>
export default {
  name: "Left"
}
</script>

<style scoped>
  .title{
    width: 100px;
    color: red;
    padding-bottom: 20px;
  }
  .menu li{
    height: 50px;

  }

</style>