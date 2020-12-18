import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Document from '../views/Document.vue'
import CreateDocument from '../views/CreateDocument.vue'
import NotFound from '../views/NotFound.vue';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/document/create',
    name: 'CreateDocument',
    component: CreateDocument
  },
  {
    path: '/document/:id',
    name: 'Document',
    component: Document
  },
  {
    path: '/404',
    name: 'NotFound',
    component: NotFound
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
