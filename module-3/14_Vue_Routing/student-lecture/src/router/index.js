import Vue from 'vue' // Get the Vue code
import VueRouter from 'vue-router' // Get the router code
import Products from '@/views/Products'
import ProductDetail from '@/views/ProductDetail' // get the ProductsDetails.vue

Vue.use(VueRouter) // tell Vue we are using the router 

// Array of router routes (like a url path)
const routes = [
  {
    path: '/', // the url path to associate (root path)
    name: 'products',
    component: Products
  },
  {
    //we are using a dynamic path (dynamic segment)
    // a dynamic path is one with a colon an a variable name after it
    path: '/products/:id', // this path will have a path variable called id
    name: 'product-detail', // name for the path-router view associated
    component: ProductDetail
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
