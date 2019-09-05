// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
const axios = require('axios')
// set proxy, send front end request to http://localhost:9090/api
axios.defaults.baseURL = 'http://localhost:9090/api'

// register axios globally, using this.$axios anywhere
Vue.prototype.$axios = axios
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
