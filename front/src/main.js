// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
/* eslint-disable */
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
const axios = require('axios')
// set proxy, send front end request to http://localhost:9090/api
axios.defaults.baseURL = 'http://localhost:9090/api'
// register axios globally, using this.$axios anywhere
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)

router.beforeEach((to, from, next) => {
  if(to.meta.requireAuth) {
    if(store.state.user.username) {
      next()
    }else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  }else {
    next()
  }
})

new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: {App},
  template: '<App/>'
})
