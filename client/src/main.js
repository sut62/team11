import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false
import router from './router';
import VueMaterial from 'vue-material'
import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/default.css'
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbvue/build/css/mdb.css';
import vuetify from './plugins/vuetify';

Vue.use(VueMaterial)

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
