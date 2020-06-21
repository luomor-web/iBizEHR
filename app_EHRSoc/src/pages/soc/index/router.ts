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
                    path: 'socareas/:socarea?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.socarea.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socareas', parameterName: 'socarea' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-area-pickup-view/soc-area-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-pickup-grid-view/pim-person-pickup-grid-view.vue'),
                },
                {
                    path: 'socrules/:socrule?/socruledetails/:socruledetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.socruledetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socrules', parameterName: 'socrule' },
                            { pathName: 'socruledetails', parameterName: 'socruledetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-detail-edit-view/soc-rule-detail-edit-view.vue'),
                },
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
                    path: 'pimpeople/:pimperson?/setsocarchivesgridview/:setsocarchivesgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.setsocarchivesgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'setsocarchivesgridview', parameterName: 'setsocarchivesgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-set-soc-archives-grid-view/pim-person-set-soc-archives-grid-view.vue'),
                },
                {
                    path: 'socareas/:socarea?/roweditgridview/:roweditgridview?',
                    meta: {
                        caption: 'entities.socarea.views.roweditgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socareas', parameterName: 'socarea' },
                            { pathName: 'roweditgridview', parameterName: 'roweditgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-area-row-edit-grid-view/soc-area-row-edit-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-pickup-view/pim-person-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/socarchives/:socarchives?/socarchivesdetails/:socarchivesdetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.socarchivesdetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-detail-edit-view/soc-archives-detail-edit-view.vue'),
                },
                {
                    path: 'socarchives/:socarchives?/socarchivesdetails/:socarchivesdetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.socarchivesdetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-detail-edit-view/soc-archives-detail-edit-view.vue'),
                },
                {
                    path: 'socarchivesdetails/:socarchivesdetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.socarchivesdetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-detail-edit-view/soc-archives-detail-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/socarchives/:socarchives?/socarchivesdetails/:socarchivesdetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socarchivesdetail.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-detail-grid-view/soc-archives-detail-grid-view.vue'),
                },
                {
                    path: 'socarchives/:socarchives?/socarchivesdetails/:socarchivesdetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socarchivesdetail.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-detail-grid-view/soc-archives-detail-grid-view.vue'),
                },
                {
                    path: 'socarchivesdetails/:socarchivesdetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socarchivesdetail.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-detail-grid-view/soc-archives-detail-grid-view.vue'),
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
                    path: 'socrules/:socrule?/quickeditview/:quickeditview?',
                    meta: {
                        caption: 'entities.socrule.views.quickeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socrules', parameterName: 'socrule' },
                            { pathName: 'quickeditview', parameterName: 'quickeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-quick-edit-view/soc-rule-quick-edit-view.vue'),
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
                    path: 'pimpeople/:pimperson?/socarchives/:socarchives?/stopgridview/:stopgridview?',
                    meta: {
                        caption: 'entities.socarchives.views.stopgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'stopgridview', parameterName: 'stopgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-stop-grid-view/soc-archives-stop-grid-view.vue'),
                },
                {
                    path: 'socarchives/:socarchives?/stopgridview/:stopgridview?',
                    meta: {
                        caption: 'entities.socarchives.views.stopgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'stopgridview', parameterName: 'stopgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-stop-grid-view/soc-archives-stop-grid-view.vue'),
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
                    path: 'pimpeople/:pimperson?/socarchives/:socarchives?/editview/:editview?',
                    meta: {
                        caption: 'entities.socarchives.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-edit-view/soc-archives-edit-view.vue'),
                },
                {
                    path: 'socarchives/:socarchives?/editview/:editview?',
                    meta: {
                        caption: 'entities.socarchives.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-edit-view/soc-archives-edit-view.vue'),
                },
                {
                    path: 'socareas/:socarea?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.socarea.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socareas', parameterName: 'socarea' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-area-pickup-grid-view/soc-area-pickup-grid-view.vue'),
                },
                {
                    path: 'socrules/:socrule?/socruledetails/:socruledetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socruledetail.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socrules', parameterName: 'socrule' },
                            { pathName: 'socruledetails', parameterName: 'socruledetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-detail-grid-view/soc-rule-detail-grid-view.vue'),
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
                    path: 'pimpeople/:pimperson?/socarchives/:socarchives?/quickeditview/:quickeditview?',
                    meta: {
                        caption: 'entities.socarchives.views.quickeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'quickeditview', parameterName: 'quickeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-quick-edit-view/soc-archives-quick-edit-view.vue'),
                },
                {
                    path: 'socarchives/:socarchives?/quickeditview/:quickeditview?',
                    meta: {
                        caption: 'entities.socarchives.views.quickeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'quickeditview', parameterName: 'quickeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-quick-edit-view/soc-archives-quick-edit-view.vue'),
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
                {
                    path: 'socaccounts/:socaccount?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.socaccount.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socaccounts', parameterName: 'socaccount' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-account-pickup-grid-view/soc-account-pickup-grid-view.vue'),
                },
                {
                    path: 'socrules/:socrule?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.socrule.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socrules', parameterName: 'socrule' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-pickup-grid-view/soc-rule-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/socarchives/:socarchives?/main2editview/:main2editview?',
                    meta: {
                        caption: 'entities.socarchives.views.main2editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'main2editview', parameterName: 'main2editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-main2-edit-view/soc-archives-main2-edit-view.vue'),
                },
                {
                    path: 'socarchives/:socarchives?/main2editview/:main2editview?',
                    meta: {
                        caption: 'entities.socarchives.views.main2editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'main2editview', parameterName: 'main2editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-main2-edit-view/soc-archives-main2-edit-view.vue'),
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
                    path: 'pimpeople/:pimperson?/socarchives/:socarchives?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.socarchives.views.treeexpview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-tree-exp-view/soc-archives-tree-exp-view.vue'),
                },
                {
                    path: 'socarchives/:socarchives?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.socarchives.views.treeexpview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-tree-exp-view/soc-archives-tree-exp-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/socarchives/:socarchives?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socarchives.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-grid-view/soc-archives-grid-view.vue'),
                },
                {
                    path: 'socarchives/:socarchives?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.socarchives.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-grid-view/soc-archives-grid-view.vue'),
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
                    path: 'socaccounts/:socaccount?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.socaccount.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socaccounts', parameterName: 'socaccount' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-account-pickup-view/soc-account-pickup-view.vue'),
                },
                {
                    path: 'socrules/:socrule?/main2editview/:main2editview?',
                    meta: {
                        caption: 'entities.socrule.views.main2editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socrules', parameterName: 'socrule' },
                            { pathName: 'main2editview', parameterName: 'main2editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-main2-edit-view/soc-rule-main2-edit-view.vue'),
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
                    path: 'socrules/:socrule?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.socrule.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socrules', parameterName: 'socrule' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-rule-pickup-view/soc-rule-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/socarchives/:socarchives?/orggridview/:orggridview?',
                    meta: {
                        caption: 'entities.socarchives.views.orggridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'orggridview', parameterName: 'orggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-org-grid-view/soc-archives-org-grid-view.vue'),
                },
                {
                    path: 'socarchives/:socarchives?/orggridview/:orggridview?',
                    meta: {
                        caption: 'entities.socarchives.views.orggridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'socarchives', parameterName: 'socarchives' },
                            { pathName: 'orggridview', parameterName: 'orggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/soc/soc-archives-org-grid-view/soc-archives-org-grid-view.vue'),
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
            ...indexRoutes,
            ],
        },
    {
        path: '/pimpeople/:pimperson?/socarchives/:socarchives?/quickeditview/:quickeditview?',
        meta: {
            caption: 'entities.socarchives.views.quickeditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'quickeditview', parameterName: 'quickeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-quick-edit-view/soc-archives-quick-edit-view.vue'),
    },
    {
        path: '/socarchives/:socarchives?/quickeditview/:quickeditview?',
        meta: {
            caption: 'entities.socarchives.views.quickeditview.title',
            info:'',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'quickeditview', parameterName: 'quickeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-quick-edit-view/soc-archives-quick-edit-view.vue'),
    },
    {
        path: '/socaccounts/:socaccount?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.socaccount.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'socaccounts', parameterName: 'socaccount' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-account-pickup-grid-view/soc-account-pickup-grid-view.vue'),
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
        path: '/socrules/:socrule?/socruledetails/:socruledetail?/editview/:editview?',
        meta: {
            caption: 'entities.socruledetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'socrules', parameterName: 'socrule' },
                { pathName: 'socruledetails', parameterName: 'socruledetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-detail-edit-view/soc-rule-detail-edit-view.vue'),
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
        path: '/pimpeople/:pimperson?/socarchives/:socarchives?/gridview/:gridview?',
        meta: {
            caption: 'entities.socarchives.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-grid-view/soc-archives-grid-view.vue'),
    },
    {
        path: '/socarchives/:socarchives?/gridview/:gridview?',
        meta: {
            caption: 'entities.socarchives.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-grid-view/soc-archives-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/socarchives/:socarchives?/orggridview/:orggridview?',
        meta: {
            caption: 'entities.socarchives.views.orggridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'orggridview', parameterName: 'orggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-org-grid-view/soc-archives-org-grid-view.vue'),
    },
    {
        path: '/socarchives/:socarchives?/orggridview/:orggridview?',
        meta: {
            caption: 'entities.socarchives.views.orggridview.title',
            info:'',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'orggridview', parameterName: 'orggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-org-grid-view/soc-archives-org-grid-view.vue'),
    },
    {
        path: '/socareas/:socarea?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.socarea.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'socareas', parameterName: 'socarea' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-area-pickup-grid-view/soc-area-pickup-grid-view.vue'),
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
        path: '/pimpeople/:pimperson?/setsocarchivesgridview/:setsocarchivesgridview?',
        meta: {
            caption: 'entities.pimperson.views.setsocarchivesgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'setsocarchivesgridview', parameterName: 'setsocarchivesgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-set-soc-archives-grid-view/pim-person-set-soc-archives-grid-view.vue'),
    },
    {
        path: '/socareas/:socarea?/roweditgridview/:roweditgridview?',
        meta: {
            caption: 'entities.socarea.views.roweditgridview.title',
            info:'',
            parameters: [
                { pathName: 'socareas', parameterName: 'socarea' },
                { pathName: 'roweditgridview', parameterName: 'roweditgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-area-row-edit-grid-view/soc-area-row-edit-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/socarchives/:socarchives?/editview/:editview?',
        meta: {
            caption: 'entities.socarchives.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-edit-view/soc-archives-edit-view.vue'),
    },
    {
        path: '/socarchives/:socarchives?/editview/:editview?',
        meta: {
            caption: 'entities.socarchives.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-edit-view/soc-archives-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/socarchives/:socarchives?/socarchivesdetails/:socarchivesdetail?/editview/:editview?',
        meta: {
            caption: 'entities.socarchivesdetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-detail-edit-view/soc-archives-detail-edit-view.vue'),
    },
    {
        path: '/socarchives/:socarchives?/socarchivesdetails/:socarchivesdetail?/editview/:editview?',
        meta: {
            caption: 'entities.socarchivesdetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-detail-edit-view/soc-archives-detail-edit-view.vue'),
    },
    {
        path: '/socarchivesdetails/:socarchivesdetail?/editview/:editview?',
        meta: {
            caption: 'entities.socarchivesdetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-detail-edit-view/soc-archives-detail-edit-view.vue'),
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
        path: '/pimpeople/:pimperson?/socarchives/:socarchives?/socarchivesdetails/:socarchivesdetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.socarchivesdetail.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-detail-grid-view/soc-archives-detail-grid-view.vue'),
    },
    {
        path: '/socarchives/:socarchives?/socarchivesdetails/:socarchivesdetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.socarchivesdetail.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-detail-grid-view/soc-archives-detail-grid-view.vue'),
    },
    {
        path: '/socarchivesdetails/:socarchivesdetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.socarchivesdetail.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'socarchivesdetails', parameterName: 'socarchivesdetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-detail-grid-view/soc-archives-detail-grid-view.vue'),
    },
    {
        path: '/socrules/:socrule?/socruledetails/:socruledetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.socruledetail.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'socrules', parameterName: 'socrule' },
                { pathName: 'socruledetails', parameterName: 'socruledetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-detail-grid-view/soc-rule-detail-grid-view.vue'),
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
        path: '/pimpeople/:pimperson?/socarchives/:socarchives?/main2editview/:main2editview?',
        meta: {
            caption: 'entities.socarchives.views.main2editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'main2editview', parameterName: 'main2editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-main2-edit-view/soc-archives-main2-edit-view.vue'),
    },
    {
        path: '/socarchives/:socarchives?/main2editview/:main2editview?',
        meta: {
            caption: 'entities.socarchives.views.main2editview.title',
            info:'',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'main2editview', parameterName: 'main2editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-main2-edit-view/soc-archives-main2-edit-view.vue'),
    },
    {
        path: '/socrules/:socrule?/main2editview/:main2editview?',
        meta: {
            caption: 'entities.socrule.views.main2editview.title',
            info:'',
            parameters: [
                { pathName: 'socrules', parameterName: 'socrule' },
                { pathName: 'main2editview', parameterName: 'main2editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-main2-edit-view/soc-rule-main2-edit-view.vue'),
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
        path: '/pimpeople/:pimperson?/socarchives/:socarchives?/stopgridview/:stopgridview?',
        meta: {
            caption: 'entities.socarchives.views.stopgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'stopgridview', parameterName: 'stopgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-stop-grid-view/soc-archives-stop-grid-view.vue'),
    },
    {
        path: '/socarchives/:socarchives?/stopgridview/:stopgridview?',
        meta: {
            caption: 'entities.socarchives.views.stopgridview.title',
            info:'',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'stopgridview', parameterName: 'stopgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-stop-grid-view/soc-archives-stop-grid-view.vue'),
    },
    {
        path: '/socaccounts/:socaccount?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.socaccount.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'socaccounts', parameterName: 'socaccount' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-account-pickup-view/soc-account-pickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-pickup-grid-view/pim-person-pickup-grid-view.vue'),
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
    {
        path: '/pimpeople/:pimperson?/socarchives/:socarchives?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.socarchives.views.treeexpview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-tree-exp-view/soc-archives-tree-exp-view.vue'),
    },
    {
        path: '/socarchives/:socarchives?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.socarchives.views.treeexpview.title',
            info:'',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-archives-tree-exp-view/soc-archives-tree-exp-view.vue'),
    },
    {
        path: '/socrules/:socrule?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.socrule.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'socrules', parameterName: 'socrule' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-pickup-view/soc-rule-pickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pimperson.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-pickup-view/pim-person-pickup-view.vue'),
    },
    {
        path: '/socrules/:socrule?/quickeditview/:quickeditview?',
        meta: {
            caption: 'entities.socrule.views.quickeditview.title',
            info:'',
            parameters: [
                { pathName: 'socrules', parameterName: 'socrule' },
                { pathName: 'quickeditview', parameterName: 'quickeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-quick-edit-view/soc-rule-quick-edit-view.vue'),
    },
    {
        path: '/socareas/:socarea?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.socarea.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'socareas', parameterName: 'socarea' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-area-pickup-view/soc-area-pickup-view.vue'),
    },
    {
        path: '/socrules/:socrule?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.socrule.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'socrules', parameterName: 'socrule' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/soc/soc-rule-pickup-grid-view/soc-rule-pickup-grid-view.vue'),
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
