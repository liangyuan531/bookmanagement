<template>
  <div>
      username: <input type="text" v-model="loginForm.username" placeholder="username"/>
      <br><br>
      password: <input type="password" v-model="loginForm.password" placeholder="password"/>
      <br><br>
      <button v-on:click="login">Login</button>
  </div>
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
      this.$axios
        .post('./login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        }).then(successRes => {
          if(successRes.data.code === 200) {
            this.$router.replace({path: './index'})
          }
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
