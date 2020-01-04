import Vue from 'vue'
import VueRouter from 'vue-router'
import BookRoom from '../views/BookRoom'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'BookRoom',
    component: BookRoom
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
