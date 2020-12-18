import Vue from 'vue'; // Access the code for Vue
import VueRouter from 'vue-router'; // Access the code for Vue Router
import Home from '@/views/Home.vue'; // Access the code for Home.vue
import Messages from '@/views/Messages.vue'; // Access the code for Messages.vue
import TopicDetails from '@/components/TopicDetails';

Vue.use(VueRouter);

const routes = [ // Associate paths to components
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/topics/:id',
    name: 'topic',
    component: TopicDetails
  },
  {
    path: '/:id',
    name: 'Messages',
    component: Messages
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
