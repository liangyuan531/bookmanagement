<template>
    <el-container>
        <el-aside class="side-bar">
            <switch></switch>
            <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
        </el-aside>
        <el-main>
            <books class="books-display" ref="booksArea"></books>
        </el-main>
    </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Books from './Books'
export default {
    name: 'AppLibrary',
    components: {SideMenu, Books},
    methods: {
        listByCategory() {
            var _this = this
            var cid = this.$refs.sideMenu.cid
            var url = `category/${cid}/books`
            _this.$axios.get(url)
                .then(res => {
                    if(res && res.status === 200) {
                        _this.$refs.booksArea.books = res.data
                    }
                })
        }
    }
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

