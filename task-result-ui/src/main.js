import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from '@/store'

import ElementUI from 'element-ui'
import locale from 'element-ui/lib/locale/lang/ja'
import 'element-ui/lib/theme-chalk/index.css'
//import VeeValidate from 'vee-validate'

import Axios from 'axios'
Axios.defaults.baseURL = process.env.VUE_APP_API_ENDPOINT || "http://localhost:8080/";
process.env.API_URL = Axios.defaults.baseURL;
//Axios.defaults.baseURL = process.env.VUE_APP_API_ENDPOINT || "http://192.168.0.18:8080/";

//import draggable from 'vuedraggable'

//Vue.use(VeeValidate)
Vue.config.productionTip = false
Vue.use(ElementUI, { locale })

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
