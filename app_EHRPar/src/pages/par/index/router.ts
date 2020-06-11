import Vue from 'vue';
import Router from 'vue-router';
import { AuthGuard } from '@/utils';
import qs from 'qs';
import { globalRoutes, indexRoutes} from '@/router'

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/index/:index?',
            beforeEnter: (to: any, from: any, next: any) => {
                const routerParamsName = 'index';
                const params: any = {};
                if (to.params && to.params[routerParamsName]) {
                    Object.assign(params, qs.parse(to.params[routerParamsName], { delimiter: ';' }));
                }
                const url: string = '/appdata';
                const auth: Promise<any> = AuthGuard.getInstance().authGuard(url, params, router);
                auth.then(() => {
                    next();
                }).catch(() => {
                    next();
                });
            },
            meta: {  
                caption: 'app.views.index.caption',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'index', parameterName: 'index' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/par/index/index.vue'),
            children: [
                {
                    path: 'partzggs/:partzgg?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.partzgg.views.gridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'partzggs', parameterName: 'partzgg' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-tzgg-grid-view/par-tzgg-grid-view.vue'),
                },
                {
                    path: 'parexamcycles/:parexamcycle?/editview/:editview?',
                    meta: {
                        caption: 'entities.parexamcycle.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-exam-cycle-edit-view/par-exam-cycle-edit-view.vue'),
                },
                {
                    path: 'partzggs/:partzgg?/editview/:editview?',
                    meta: {
                        caption: 'entities.partzgg.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'partzggs', parameterName: 'partzgg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-tzgg-edit-view/par-tzgg-edit-view.vue'),
                },
                {
                    path: 'parexamcycles/:parexamcycle?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parexamcycle.views.gridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-exam-cycle-grid-view/par-exam-cycle-grid-view.vue'),
                },
                {
                    path: 'partzggs/:partzgg?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.partzgg.views.editview9.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'partzggs', parameterName: 'partzgg' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-tzgg-edit-view9/par-tzgg-edit-view9.vue'),
                },
            {
                path: 'partzggredirectview/:partzggredirectview?',
                meta: {
                    caption: 'entities.partzgg.views.redirectview.caption',
                    parameters: [
                        { pathName: 'partzggredirectview', parameterName: 'partzggredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/par/par-tzgg-redirect-view/par-tzgg-redirect-view.vue'),
            },
            {
                path: 'parexamcycleredirectview/:parexamcycleredirectview?',
                meta: {
                    caption: 'entities.parexamcycle.views.redirectview.caption',
                    parameters: [
                        { pathName: 'parexamcycleredirectview', parameterName: 'parexamcycleredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/par/par-exam-cycle-redirect-view/par-exam-cycle-redirect-view.vue'),
            },
            ...indexRoutes,
            ],
        },
    {
        path: '/parexamcycles/:parexamcycle?/gridview/:gridview?',
        meta: {
            caption: 'entities.parexamcycle.views.gridview.caption',
            parameters: [
                { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-cycle-grid-view/par-exam-cycle-grid-view.vue'),
    },
    {
        path: '/partzggs/:partzgg?/gridview/:gridview?',
        meta: {
            caption: 'entities.partzgg.views.gridview.caption',
            parameters: [
                { pathName: 'partzggs', parameterName: 'partzgg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-tzgg-grid-view/par-tzgg-grid-view.vue'),
    },
    {
        path: '/parexamcycles/:parexamcycle?/editview/:editview?',
        meta: {
            caption: 'entities.parexamcycle.views.editview.caption',
            parameters: [
                { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-cycle-edit-view/par-exam-cycle-edit-view.vue'),
    },
            {
                path: '/partzggredirectview/:partzggredirectview?',
                meta: {
                    caption: 'entities.partzgg.views.redirectview.caption',
                    parameters: [
                        { pathName: 'partzggredirectview', parameterName: 'partzggredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/par/par-tzgg-redirect-view/par-tzgg-redirect-view.vue'),
            },
    {
        path: '/partzggs/:partzgg?/editview/:editview?',
        meta: {
            caption: 'entities.partzgg.views.editview.caption',
            parameters: [
                { pathName: 'partzggs', parameterName: 'partzgg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-tzgg-edit-view/par-tzgg-edit-view.vue'),
    },
    {
        path: '/partzggs/:partzgg?/editview9/:editview9?',
        meta: {
            caption: 'entities.partzgg.views.editview9.caption',
            parameters: [
                { pathName: 'partzggs', parameterName: 'partzgg' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-tzgg-edit-view9/par-tzgg-edit-view9.vue'),
    },
            {
                path: '/parexamcycleredirectview/:parexamcycleredirectview?',
                meta: {
                    caption: 'entities.parexamcycle.views.redirectview.caption',
                    parameters: [
                        { pathName: 'parexamcycleredirectview', parameterName: 'parexamcycleredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/par/par-exam-cycle-redirect-view/par-exam-cycle-redirect-view.vue'),
            },
        ...globalRoutes,
        {
            path: '/login/:login?',
            name: 'login',
            meta: {  
                caption: '登录',
                viewType: 'login',
                requireAuth: false,
                ignoreAddPage: true,
            },
            beforeEnter: (to: any, from: any, next: any) => {
                router.app.$store.commit('resetRootStateData');
                next();
            },
            component: () => import('@components/login/login.vue'),
        },
        {
            path: '/404',
            component: () => import('@components/404/404.vue')
        },
        {
            path: '/500',
            component: () => import('@components/500/500.vue')
        },
        {
            path: '*',
            redirect: 'index'
        },
    ],
});

export default router;
