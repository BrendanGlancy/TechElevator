import Vue from 'vue';
import Home from '@/views/Home';
import VueRouter from 'vue-router';
import MyBooks from '@/views/MyBooks';
import NewBook from '@/views/NewBook';
import BookDetail from '@/views/BookDetail';

Vue.use(VueRouter);

const routes = [
  {
    path: '/', 
    name: 'home',
    component: Home
  },
  {
    path: '/myBooks',
    name: 'my-books',
    component: MyBooks
  },
  {
    path: '/addBook',
    name: 'add-book',
    component: NewBook
  },
  {
    path: '/book/:isbn',
    name: 'book-detail',
    component: BookDetail
  }

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
