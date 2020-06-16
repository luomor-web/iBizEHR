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
            component: () => import('@pages/soc/index/index.vue'),
            children: [
                {
                    path: 'socruledetails/:socruledetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.socruledetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socruledetails', parameterName: 'socruledetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-detail-edit-view/soc-rule-detail-edit-view.vue'),
                },
                {
                    path: 'socrules/:socrule?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socrule.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socrules', parameterName: 'socrule' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-grid-view/soc-rule-grid-view.vue'),
                },
                {
                    path: 'socaccounts/:socaccount?/editview/:editview?',
                    meta: {
                        caption: 'entities.socaccount.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socaccounts', parameterName: 'socaccount' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-account-edit-view/soc-account-edit-view.vue'),
                },
                {
                    path: 'soctypes/:soctype?/editview/:editview?',
                    meta: {
                        caption: 'entities.soctype.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'soctypes', parameterName: 'soctype' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-type-edit-view/soc-type-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-org-pickup-grid-view/orm-org-pickup-grid-view.vue'),
                },
                {
                    path: 'soctypes/:soctype?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.soctype.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'soctypes', parameterName: 'soctype' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-type-grid-view/soc-type-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-org-pickup-view/orm-org-pickup-view.vue'),
                },
                {
                    path: 'socruledetails/:socruledetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socruledetail.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socruledetails', parameterName: 'socruledetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-detail-grid-view/soc-rule-detail-grid-view.vue'),
                },
                {
                    path: 'soctypes/:soctype?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.soctype.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'soctypes', parameterName: 'soctype' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-type-pickup-view/soc-type-pickup-view.vue'),
                },
                {
                    path: 'soctypes/:soctype?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.soctype.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'soctypes', parameterName: 'soctype' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-type-pickup-grid-view/soc-type-pickup-grid-view.vue'),
                },
                {
                    path: 'socaccounts/:socaccount?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socaccount.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socaccounts', parameterName: 'socaccount' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-account-grid-view/soc-account-grid-view.vue'),
                },
                {
                    path: 'socareas/:socarea?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socarea.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socareas', parameterName: 'socarea' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-area-grid-view/soc-area-grid-view.vue'),
                },
                {
                    path: 'socareas/:socarea?/editview/:editview?',
                    meta: {
                        caption: 'entities.socarea.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socareas', parameterName: 'socarea' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-area-edit-view/soc-area-edit-view.vue'),
                },
                {
                    path: 'socrules/:socrule?/editview/:editview?',
                    meta: {
                        caption: 'entities.socrule.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socrules', parameterName: 'socrule' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-edit-view/soc-rule-edit-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/soctypes/:soctype?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.soctype.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'soctypes', parameterName: 'soctype' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-type-pickup-view/soc-type-pickup-view.vue'),
    },
    {
        path: '/socareas/:socarea?/gridview/:gridview?',
        meta: {
            caption: 'entities.socarea.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'socareas', parameterName: 'socarea' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-area-grid-view/soc-area-grid-view.vue'),
    },
    {
        path: '/soctypes/:soctype?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.soctype.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'soctypes', parameterName: 'soctype' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-type-pickup-grid-view/soc-type-pickup-grid-view.vue'),
    },
    {
        path: '/socareas/:socarea?/editview/:editview?',
        meta: {
            caption: 'entities.socarea.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'socareas', parameterName: 'socarea' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-area-edit-view/soc-area-edit-view.vue'),
    },
    {
        path: '/socruledetails/:socruledetail?/editview/:editview?',
        meta: {
            caption: 'entities.socruledetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'socruledetails', parameterName: 'socruledetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-detail-edit-view/soc-rule-detail-edit-view.vue'),
    },
    {
        path: '/socrules/:socrule?/gridview/:gridview?',
        meta: {
            caption: 'entities.socrule.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'socrules', parameterName: 'socrule' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-grid-view/soc-rule-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-org-pickup-grid-view/orm-org-pickup-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormorg.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-org-pickup-view/orm-org-pickup-view.vue'),
    },
    {
        path: '/socrules/:socrule?/editview/:editview?',
        meta: {
            caption: 'entities.socrule.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'socrules', parameterName: 'socrule' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-edit-view/soc-rule-edit-view.vue'),
    },
    {
        path: '/soctypes/:soctype?/editview/:editview?',
        meta: {
            caption: 'entities.soctype.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'soctypes', parameterName: 'soctype' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-type-edit-view/soc-type-edit-view.vue'),
    },
    {
        path: '/soctypes/:soctype?/gridview/:gridview?',
        meta: {
            caption: 'entities.soctype.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'soctypes', parameterName: 'soctype' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-type-grid-view/soc-type-grid-view.vue'),
    },
    {
        path: '/socruledetails/:socruledetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.socruledetail.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'socruledetails', parameterName: 'socruledetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-detail-grid-view/soc-rule-detail-grid-view.vue'),
    },
    {
        path: '/socaccounts/:socaccount?/gridview/:gridview?',
        meta: {
            caption: 'entities.socaccount.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'socaccounts', parameterName: 'socaccount' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-account-grid-view/soc-account-grid-view.vue'),
    },
    {
        path: '/socaccounts/:socaccount?/editview/:editview?',
        meta: {
            caption: 'entities.socaccount.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'socaccounts', parameterName: 'socaccount' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-account-edit-view/soc-account-edit-view.vue'),
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
