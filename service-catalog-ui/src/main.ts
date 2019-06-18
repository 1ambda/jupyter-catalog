import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
/** element ui */
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/display.css'
import locale from 'element-ui/lib/locale/lang/en'
/** icons */
// import 'vue-awesome/icons'
// import Icon from 'vue-awesome/components/Icon.vue'

Vue.use(ElementUI, {locale})
// Vue.component('v-icon', Icon)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app')
