import { createRouter, createWebHistory } from 'vue-router'

import Home from '../pages/Home.vue'
import Modelos from '../pages/Modelos.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/modelos', component: Modelos }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
