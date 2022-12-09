import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'

const router = createRouter({
history: createWebHistory(import.meta.env.BASE_URL),
routes: [
{
path: '/',
name: 'home',
component: HomeView
},
{
path: '/persona',
name: 'persona',
component: () => import('../views/PersonaView.vue')
},
{
path: '/ciudad',
name: 'ciudad',
component: () => import('../views/CiudadView.vue')
}]

})
export default router