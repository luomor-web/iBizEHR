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
                caption: 'app.views.index.title',
                info:'',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'index', parameterName: 'index' },
                ],
                requireAuth: true,
            },
            component: () => import('@pages/ungroup/index/index.vue'),
            children: [
                {
                    path: 'ehrportalview/:ehrportalview?',
                    meta: {
                        caption: 'app.views.ehrportalview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ehrportalview', parameterName: 'ehrportalview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/portal/ehr-portal-view/ehr-portal-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/ehrportalview/:ehrportalview?',
        meta: {
            caption: 'app.views.ehrportalview.title',
            info:'',
            parameters: [
                { pathName: 'ehrportalview', parameterName: 'ehrportalview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/portal/ehr-portal-view/ehr-portal-view.vue'),
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
