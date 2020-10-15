import Vue from 'vue'
import App from './App.vue'
import router from './router'

import ElementUI from 'element-ui'
import locale from 'element-ui/lib/locale/lang/ja'
import 'element-ui/lib/theme-chalk/index.css'

import Axios from 'axios'
Axios.defaults.baseURL = process.env.VUE_APP_API_ENDPOINT || "http://192.168.1.112:8080/";
//Axios.defaults.baseURL = process.env.VUE_APP_API_ENDPOINT || "http://192.168.0.18:8080/";

//import draggable from 'vuedraggable'

Vue.config.productionTip = false
Vue.use(ElementUI, { locale })

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
