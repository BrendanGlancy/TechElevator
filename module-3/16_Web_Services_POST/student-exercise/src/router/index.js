import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import Messages from '@/views/Messages.vue';
import AddMessage from '@/views/AddMessage.vue';
import AddTopic from '@/views/AddTopic.vue';
import EditTopic from '@/views/EditTopic.vue';
import NotFound from '@/views/NotFound.vue';
import EditMessage from '@/views/EditMessage';

Vue.use(VueRouter);

const routes = [
  {
    path: "/not-found",
    name: "NotFound",
    component: NotFound
  },
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/add-topic',
    name: 'AddTopic',
    component: AddTopic
  },
  {
    path: '/edit-topic/:id',
    name: 'EditTopic',
    component: EditTopic
  },
  {
    path: '/:id',
    name: 'Messages',
    component: Messages
  },
  {
    path: '/:topicId/add-message',
    name: 'AddMessage',
    component: AddMessage
  },
  {
    path: '/:topicId/edit-message/:messageId',
    name: 'EditMessage',
    component: EditMessage
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
