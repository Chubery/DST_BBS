import { createRouter, createWebHashHistory } from 'vue-router'
import main from "../views/main";
import bbs from "../views/bbs";
import login from "../views/login";
import register from "../views/register";

const routes = [
    {
        path: '/',
        name: 'main',
        component: main
    },
    {
        path: '/bbs',
        name: 'bbs',
        component: bbs
    },
    {
        path: '/login',
        name: 'login',
        component: login
    },
    {
        path: '/register',
        name: 'register',
        component: register
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
