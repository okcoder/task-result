import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import Store from '@/store/index.js'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/schedule/:id',
    name: 'Schedule',
    component: () => import(/* webpackChunkName: "about" */ '../views/Schedule.vue')
  },
  {
    path: '/schedulePriority',
    name: 'SchedulePriority',
    component: () => import(/* webpackChunkName: "about" */ '../views/SchedulePriority.vue')
  },
  {
    path: '/taskPriority',
    name: 'TaskPriority',
    component: () => import(/* webpackChunkName: "about" */ '../views/TaskPriority.vue')
  },
  {
    path: '/master/userList',
    name: 'userList',
    component: () => import(/* webpackChunkName: "about" */ '../views/master/UserList.vue'),
  },
  {
    path: '/master/userDetail',
    name: 'userDetail',
    component: () => import(/* webpackChunkName: "about" */ '../views/master/UserDetail.vue'),
  },
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue'),
    meta: {
      isPublic: true
    }
  },
  {
    path: '/logout',
    name: 'logout',
    component: () => import(/* webpackChunkName: "about" */ '../views/Logout.vue'),
    meta: {
      isPublic: true
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if (to.matched.some(page => page.meta.isPublic) || Store.state.auth.token) {
    next()
  } else {
    //next()
    next('/login')
  }
})

export default router
