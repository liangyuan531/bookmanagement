<template>
    <el-container>
        <el-aside class="side-bar">
            <switch></switch>
            <SideMenu></SideMenu>
        </el-aside>
        <el-main>
            <books class="books-display"></books>
        </el-main>
    </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Books from './Books'
export default {
    name: 'AppLibrary',
    components: {SideMenu, Books}
}
</script>

<style scoped>
  .side-bar {
      width: 200px;
      margin-top: 20px;
  }
  .books-display {
      width: 990px;
      margin-left: auto;
      margin-right: auto;
  }
</style>

