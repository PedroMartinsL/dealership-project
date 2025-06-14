import { createRouter, createWebHistory } from 'vue-router'

import Home from '../pages/Home.vue'
import Modelos from '../pages/Modelos.vue'
import CompreOnline from '../pages/CompreOnline.vue'
import Huracan from '../pages/saibaMais/Huracan.vue'
import Glb from '../pages/saibaMais/Glb.vue'
import Phantom from '../pages/saibaMais/Phantom.vue'
import CadastroCarro from '../pages/CadastroCarro.vue'
import CadastroCustomization from '../pages/CadastroCustomization.vue'
import CadastroEngine from '../pages/CadastroEngine.vue'
import CadastroOrder from '../pages/CadastroOrder.vue'



const routes = [
  { path: '/', component: Home },
  { path: '/modelos', component: Modelos },
  { path: '/compre-online', component: CompreOnline },
  { path: '/saibamais/huracan', component: Huracan },
  { path: '/saibamais/glb', component: Glb },
  { path: '/saibamais/phantom', component: Phantom },
  { path: '/cadastro-carro', component: CadastroCarro },
  { path: '/cadastro-customization', component: CadastroCustomization },
  { path: '/cadastro-engine', component: CadastroEngine },
  { path: '/cadastro-order', component: CadastroOrder }


]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
