<template>
  <body id="back-ground">
    <el-form class="login-container" label-position="left" label-width="0px">
      <h3 class="login_title">User Login</h3>
      <el-form-item>
        <el-input type="text" v-model="loginForm.username" placeholder="username" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="loginForm.password" placeholder="password" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" class="login_btn" v-on:click="login">Login</el-button>
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      responseResult: []
    }
  },

  methods: {
    login() {
      var _this = this
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        }).then(successRes => {
          if(successRes.data.code === 200) {
            // call login mutation in store
            _this.$store.commit('login', _this.loginForm)
            let path = this.$route.query.redirect
            this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
          }
        }).catch(failRes => {
          console.log(failRes)
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  #back-ground {
    /* background: url('../assets/blue.jpg'); */
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body {
    margin: 0px;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 190px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 40px #cac6c6;
  }
  .loging_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .login_btn {
    width: 100%;
    background: #505458;
    border: none;
  }
</style>
