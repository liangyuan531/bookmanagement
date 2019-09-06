<template>
    <div>
        <i class="el-icon-circle-plus-outline" @click="dialogFormVisible = true"></i>
        <el-dialog title="Add/Update Book" :visible.sync="dialogFormVisible" @close="clear">
            <el-form v-model="form" style="text-align: left" ref="dataFor">
                <el-form-item label="Title" :label-width="formLabelWidth" prop="title">
                    <el-input v-model="form.title" aria-autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Author" :label-width="formLabelWidth" prop="author">
                    <el-input v-model="form.author" aria-autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Date" :label-width="formLabelWidth" prop="date">
                    <el-input v-model="form.date" aria-autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Press" :label-width="formLabelWidth" prop="press">
                    <el-input v-model="form.press" aria-autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Cover" :label-width="formLabelWidth" prop="cover">
                    <el-input v-model="form.cover" aria-autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Description" :label-width="formLabelWidth" prop="abs">
                    <el-input v-model="form.abs" aria-autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="Category" :label-width="formLabelWidth" prop="category">
                    <el-select v-model="form.category.id" placeholder="Choose category">
                        <el-option label="Fiction" value="1"></el-option>
                        <el-option label="Non-Fiction" value="2"></el-option>
                        <el-option label="Culture" value="3"></el-option>
                        <el-option label="Life" value="4"></el-option>
                        <el-option label="Management" value="5"></el-option>
                        <el-option label="Technology" value="6"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item prop="id" style="height: 0">
                    <el-input type="hidden" v-model="form.id" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">Cancel</el-button>
                <el-button type="primary" @click="onSubmit">Submit</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
export default {
    name: 'EditForm',
    data() {
        return {
            dialogFormVisible: false,
            form: {
                id: '',
                title: '',
                author: '',
                date: '',
                press: '',
                cover: '',
                abs: '',
                category: {
                  id: '',
                  name: ''
                }
            },
            formLabelWidth: '120px'
        }
    },
    methods: {
        clear() {
            this.form = {
                id: '',
                title: '',
                author: '',
                date: '',
                press: '',
                cover: '',
                abs: '',
                category: ''
            }
        },
        onSubmit() {
            this.$axios.post('/book', {
                id: this.form.id,
                cover: this.form.cover,
                title: this.form.title,
                author: this.form.author,
                date: this.form.date,
                press: this.form.press,
                abs: this.form.abs,
                category: this.form.category
            }).then(res => {
                if(res & res.status === 200) {
                    this.dialogFormVisible = false
                    this.$emit('onSubmit')
                }
            })
        }
    }
}
</script>

<style scoped>
    .el-icon-circle-plus-outline {
        margin: 50px 0 0 20px;
        font-size: 100px;
        float: left;
        cursor: pointer;
    }
</style>
