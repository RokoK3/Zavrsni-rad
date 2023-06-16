import { createRouter, createWebHistory } from 'vue-router';
import LecturesList from '@/components/LecturesList.vue';
import AdditionTasks from '@/components/AdditionTasks.vue';

const routes = [
  {
    path: '/',
    name: 'LecturesList',
    component: LecturesList,
  },
  {
    path: '/lecture/1',
    name: 'AdditionTasks',
    component: AdditionTasks,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;