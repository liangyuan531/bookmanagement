<template>
    <div class="search-bar">
        <el-input
            @keyup.enter.native="searchClick"
            placeholder="Search by author/book"
            prefix-icon="el-icon-search"
            v-model="keywords"></el-input>
        <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">Search</el-button>
    </div>
</template>

<script>
export default {
    name: 'SearchBar',
    data() {
        return {
            keywords: '',
            books: [],
            cardLoading: []
        }
    },
    methods: {
        searchClick() {
            this.$emit('onSearch')
        }
    }
}
</script>
    
<style scoped>
    .search-bar {
        margin-bottom: 30px;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .search-bar el-input {
        width: 400px;
        margin-right: 10px;
    }
</style>
