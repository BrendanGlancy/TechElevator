import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Document from '../views/Document.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/document/:id',
    name: 'Document',
    component: Document
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
