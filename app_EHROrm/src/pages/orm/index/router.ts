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
            component: () => import('@pages/orm/index/index.vue'),
            children: [
                {
                    path: 'ormduties/:ormduty?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormduty.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormdutyedit-view/ormdutyedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/orgtreeexpview/:orgtreeexpview?',
                    meta: {
                        caption: 'entities.ormorg.views.orgtreeexpview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/xiangmurenyuanpeizhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'orgtreeexpview', parameterName: 'orgtreeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgorg-tree-exp-view/ormorgorg-tree-exp-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/curleaderpickupview/:curleaderpickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.curleaderpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'curleaderpickupview', parameterName: 'curleaderpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/pimpersoncur-leader-pickup-view/pimpersoncur-leader-pickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgdzs/:ormorgdz?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormorgdz.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgdzs', parameterName: 'ormorgdz' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgdzedit-view/ormorgdzedit-view.vue'),
                },
                {
                    path: 'ormorgdzs/:ormorgdz?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormorgdz.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgdzs', parameterName: 'ormorgdz' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgdzedit-view/ormorgdzedit-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormsignorg.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-sign-org-pickup-grid-view/orm-sign-org-pickup-grid-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ormduty.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormdutygrid-view/ormdutygrid-view.vue'),
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
                    component: () => import('@pages/orm/ormorgpickup-view/ormorgpickup-view.vue'),
                },
                {
                    path: 'ormerporgs/:ormerporg?/legalmpickupview/:legalmpickupview?',
                    meta: {
                        caption: 'entities.ormerporg.views.legalmpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormerporgs', parameterName: 'ormerporg' },
                            { pathName: 'legalmpickupview', parameterName: 'legalmpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormerporglegal-mpickup-view/ormerporglegal-mpickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/sjorgpickupgridview/:sjorgpickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.sjorgpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'sjorgpickupgridview', parameterName: 'sjorgpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsjorg-pickup-grid-view/ormorgsjorg-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgdzs/:ormorgdz?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ormorgdz.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/rencaixulie.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgdzs', parameterName: 'ormorgdz' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgdzgrid-view/ormorgdzgrid-view.vue'),
                },
                {
                    path: 'ormorgdzs/:ormorgdz?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ormorgdz.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/rencaixulie.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgdzs', parameterName: 'ormorgdz' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgdzgrid-view/ormorgdzgrid-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/pimcontractsignorgs/:pimcontractsignorg?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimcontractsignorg.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/contract-sign-orggrid-view/contract-sign-orggrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pimcontractsignorgs/:pimcontractsignorg?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimcontractsignorg.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/contract-sign-orggrid-view/contract-sign-orggrid-view.vue'),
                },
                {
                    path: 'pimcontractsignorgs/:pimcontractsignorg?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimcontractsignorg.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/contract-sign-orggrid-view/contract-sign-orggrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormxmbqs/:ormxmbq?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ormxmbq.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormxmbqgrid-view/ormxmbqgrid-view.vue'),
                },
                {
                    path: 'ormxmbqs/:ormxmbq?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ormxmbq.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormxmbqgrid-view/ormxmbqgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/sjorgpickupview/:sjorgpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.sjorgpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'sjorgpickupview', parameterName: 'sjorgpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsjorg-pickup-view/ormorgsjorg-pickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'bmkqdzgridview', parameterName: 'bmkqdzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormbmkqdzbmkqdzgrid-view/ormbmkqdzbmkqdzgrid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'bmkqdzgridview', parameterName: 'bmkqdzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormbmkqdzbmkqdzgrid-view/ormbmkqdzbmkqdzgrid-view.vue'),
                },
                {
                    path: 'ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'bmkqdzgridview', parameterName: 'bmkqdzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormbmkqdzbmkqdzgrid-view/ormbmkqdzbmkqdzgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzeditview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'bmkqdzeditview', parameterName: 'bmkqdzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormbmkqdzbmkqdzedit-view/ormbmkqdzbmkqdzedit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzeditview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'bmkqdzeditview', parameterName: 'bmkqdzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormbmkqdzbmkqdzedit-view/ormbmkqdzbmkqdzedit-view.vue'),
                },
                {
                    path: 'ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzeditview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'bmkqdzeditview', parameterName: 'bmkqdzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormbmkqdzbmkqdzedit-view/ormbmkqdzbmkqdzedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/allleveltwoorgpickupgridview/:allleveltwoorgpickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.allleveltwoorgpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'allleveltwoorgpickupgridview', parameterName: 'allleveltwoorgpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgall-level-two-org-pickup-grid-view/ormorgall-level-two-org-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.ormorg.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgedit-view9/ormorgedit-view9.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/xmbqpickupgridview/:xmbqpickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.xmbqpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'xmbqpickupgridview', parameterName: 'xmbqpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-org-xmbqpickup-grid-view/orm-org-xmbqpickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/xmbqpickupview/:xmbqpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.xmbqpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'xmbqpickupview', parameterName: 'xmbqpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgxmbqpickup-view/ormorgxmbqpickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectorgrid-view/ormorgsectorgrid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectorgrid-view/ormorgsectorgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/allleveltwoorgpickupview/:allleveltwoorgpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.allleveltwoorgpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'allleveltwoorgpickupview', parameterName: 'allleveltwoorgpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgall-level-two-org-pickup-view/ormorgall-level-two-org-pickup-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/pimcontractsignorgs/:pimcontractsignorg?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimcontractsignorg.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/contract-sign-orgedit-view/contract-sign-orgedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pimcontractsignorgs/:pimcontractsignorg?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimcontractsignorg.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/contract-sign-orgedit-view/contract-sign-orgedit-view.vue'),
                },
                {
                    path: 'pimcontractsignorgs/:pimcontractsignorg?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimcontractsignorg.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/contract-sign-orgedit-view/contract-sign-orgedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/bzcxgridview/:bzcxgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.bzcxgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'bzcxgridview', parameterName: 'bzcxgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectorbzcxgrid-view/ormorgsectorbzcxgrid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/bzcxgridview/:bzcxgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.bzcxgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'bzcxgridview', parameterName: 'bzcxgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectorbzcxgrid-view/ormorgsectorbzcxgrid-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ormsignorg.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-sign-org-grid-view/orm-sign-org-grid-view.vue'),
                },
                {
                    path: 'ormerporgs/:ormerporg?/legalpickupgridview/:legalpickupgridview?',
                    meta: {
                        caption: 'entities.ormerporg.views.legalpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormerporgs', parameterName: 'ormerporg' },
                            { pathName: 'legalpickupgridview', parameterName: 'legalpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormerporglegal-pickup-grid-view/ormerporglegal-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormpost.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormpostedit-view/ormpostedit-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormpost.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormpostedit-view/ormpostedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/editview9_editmode/:editview9_editmode?',
                    meta: {
                        caption: 'entities.ormorgsector.views.editview9_editmode.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'editview9_editmode', parameterName: 'editview9_editmode' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectoredit-view9-edit-mode/ormorgsectoredit-view9-edit-mode.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/editview9_editmode/:editview9_editmode?',
                    meta: {
                        caption: 'entities.ormorgsector.views.editview9_editmode.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'editview9_editmode', parameterName: 'editview9_editmode' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectoredit-view9-edit-mode/ormorgsectoredit-view9-edit-mode.vue'),
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
                    component: () => import('@pages/orm/ormorgpickup-grid-view/ormorgpickup-grid-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormsignorg.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-sign-org-edit-view/orm-sign-org-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/curleaderpickupgridview/:curleaderpickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.curleaderpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'curleaderpickupgridview', parameterName: 'curleaderpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/pimpersoncur-leader-pickup-grid-view/pimpersoncur-leader-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/orgtreegridview/:orgtreegridview?',
                    meta: {
                        caption: 'entities.ormorg.views.orgtreegridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/rencaixulie.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'orgtreegridview', parameterName: 'orgtreegridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgorg-tree-grid-view/ormorgorg-tree-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/xjgridview/:xjgridview?',
                    meta: {
                        caption: 'entities.ormpost.views.xjgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'xjgridview', parameterName: 'xjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-post-xjgrid-view/orm-post-xjgrid-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/xjgridview/:xjgridview?',
                    meta: {
                        caption: 'entities.ormpost.views.xjgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'xjgridview', parameterName: 'xjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-post-xjgrid-view/orm-post-xjgrid-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormsignorg.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-sign-org-pickup-view/orm-sign-org-pickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormxmbqs/:ormxmbq?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormxmbq.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormxmbqedit-view/ormxmbqedit-view.vue'),
                },
                {
                    path: 'ormxmbqs/:ormxmbq?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormxmbq.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormxmbqedit-view/ormxmbqedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.ormorgsector.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectoredit-view9/ormorgsectoredit-view9.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.ormorgsector.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectoredit-view9/ormorgsectoredit-view9.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectoredit-view/ormorgsectoredit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgsectoredit-view/ormorgsectoredit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/editview9_editmode/:editview9_editmode?',
                    meta: {
                        caption: 'entities.ormorg.views.editview9_editmode.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'editview9_editmode', parameterName: 'editview9_editmode' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgedit-view9-edit-mode/ormorgedit-view9-edit-mode.vue'),
                },
            {
                path: 'ormxmbqredirectview/:ormxmbqredirectview?',
                meta: {
                    caption: 'entities.ormxmbq.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormxmbqredirectview', parameterName: 'ormxmbqredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormxmbqredirect-view/ormxmbqredirect-view.vue'),
            },
            {
                path: 'ormpostlibredirectview/:ormpostlibredirectview?',
                meta: {
                    caption: 'entities.ormpostlib.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormpostlibredirectview', parameterName: 'ormpostlibredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormpost-lib-redirect-view/ormpost-lib-redirect-view.vue'),
            },
            {
                path: 'ormdepestmanredirectview/:ormdepestmanredirectview?',
                meta: {
                    caption: 'entities.ormdepestman.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormdepestmanredirectview', parameterName: 'ormdepestmanredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormdep-est-man-redirect-view/ormdep-est-man-redirect-view.vue'),
            },
            {
                path: 'contractsignorgredirectview/:contractsignorgredirectview?',
                meta: {
                    caption: 'entities.pimcontractsignorg.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'contractsignorgredirectview', parameterName: 'contractsignorgredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/contract-sign-orgredirect-view/contract-sign-orgredirect-view.vue'),
            },
            {
                path: 'ormorgdzredirectview/:ormorgdzredirectview?',
                meta: {
                    caption: 'entities.ormorgdz.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormorgdzredirectview', parameterName: 'ormorgdzredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormorgdzredirect-view/ormorgdzredirect-view.vue'),
            },
            {
                path: 'ormbmgwbzredirectview/:ormbmgwbzredirectview?',
                meta: {
                    caption: 'entities.ormbmgwbz.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormbmgwbzredirectview', parameterName: 'ormbmgwbzredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormbmgwbzredirect-view/ormbmgwbzredirect-view.vue'),
            },
            {
                path: 'ormerporgredirectview/:ormerporgredirectview?',
                meta: {
                    caption: 'entities.ormerporg.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormerporgredirectview', parameterName: 'ormerporgredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormerporgredirect-view/ormerporgredirect-view.vue'),
            },
            {
                path: 'ormtitleredirectview/:ormtitleredirectview?',
                meta: {
                    caption: 'entities.ormtitle.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormtitleredirectview', parameterName: 'ormtitleredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormtitleredirect-view/ormtitleredirect-view.vue'),
            },
            {
                path: 'ormorginforedirectview/:ormorginforedirectview?',
                meta: {
                    caption: 'entities.ormorginfo.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormorginforedirectview', parameterName: 'ormorginforedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormorginfo-redirect-view/ormorginfo-redirect-view.vue'),
            },
            {
                path: 'ormorgsectorredirectview/:ormorgsectorredirectview?',
                meta: {
                    caption: 'entities.ormorgsector.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormorgsectorredirectview', parameterName: 'ormorgsectorredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormorgsectorredirect-view/ormorgsectorredirect-view.vue'),
            },
            {
                path: 'ormorgredirectview/:ormorgredirectview?',
                meta: {
                    caption: 'entities.ormorg.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormorgredirectview', parameterName: 'ormorgredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormorgredirect-view/ormorgredirect-view.vue'),
            },
            {
                path: 'ormxmbmxredirectview/:ormxmbmxredirectview?',
                meta: {
                    caption: 'entities.ormxmbmx.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormxmbmxredirectview', parameterName: 'ormxmbmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormxmbmxredirect-view/ormxmbmxredirect-view.vue'),
            },
            {
                path: 'ormdutyredirectview/:ormdutyredirectview?',
                meta: {
                    caption: 'entities.ormduty.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormdutyredirectview', parameterName: 'ormdutyredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormdutyredirect-view/ormdutyredirect-view.vue'),
            },
            {
                path: 'ormrelationredirectview/:ormrelationredirectview?',
                meta: {
                    caption: 'entities.ormrelation.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormrelationredirectview', parameterName: 'ormrelationredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormrelation-redirect-view/ormrelation-redirect-view.vue'),
            },
            {
                path: 'ormeditionredirectview/:ormeditionredirectview?',
                meta: {
                    caption: 'entities.ormedition.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormeditionredirectview', parameterName: 'ormeditionredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormeditionredirect-view/ormeditionredirect-view.vue'),
            },
            {
                path: 'ormxmglredirectview/:ormxmglredirectview?',
                meta: {
                    caption: 'entities.ormxmgl.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormxmglredirectview', parameterName: 'ormxmglredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormxmglredirect-view/ormxmglredirect-view.vue'),
            },
            {
                path: 'ormpostredirectview/:ormpostredirectview?',
                meta: {
                    caption: 'entities.ormpost.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormpostredirectview', parameterName: 'ormpostredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormpostredirect-view/ormpostredirect-view.vue'),
            },
            {
                path: 'ormbmkqdzredirectview/:ormbmkqdzredirectview?',
                meta: {
                    caption: 'entities.ormbmkqdz.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormbmkqdzredirectview', parameterName: 'ormbmkqdzredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormbmkqdzredirect-view/ormbmkqdzredirect-view.vue'),
            },
            {
                path: 'ormsignorgredirectview/:ormsignorgredirectview?',
                meta: {
                    caption: 'entities.ormsignorg.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormsignorgredirectview', parameterName: 'ormsignorgredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/orm-sign-org-redirect-view/orm-sign-org-redirect-view.vue'),
            },
            {
                path: 'ormpostdetailsredirectview/:ormpostdetailsredirectview?',
                meta: {
                    caption: 'entities.ormpostdetails.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormpostdetailsredirectview', parameterName: 'ormpostdetailsredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormpost-details-redirect-view/ormpost-details-redirect-view.vue'),
            },
            {
                path: 'ormqybzwhredirectview/:ormqybzwhredirectview?',
                meta: {
                    caption: 'entities.ormqybzwh.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormqybzwhredirectview', parameterName: 'ormqybzwhredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormqybzwhredirect-view/ormqybzwhredirect-view.vue'),
            },
            {
                path: 'ormqyglredirectview/:ormqyglredirectview?',
                meta: {
                    caption: 'entities.ormqygl.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormqyglredirectview', parameterName: 'ormqyglredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormqyglredirect-view/ormqyglredirect-view.vue'),
            },
            ...indexRoutes,
            ],
        },
    {
        path: '/ormorgs/:ormorg?/ormxmbqs/:ormxmbq?/editview/:editview?',
        meta: {
            caption: 'entities.ormxmbq.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormxmbqedit-view/ormxmbqedit-view.vue'),
    },
    {
        path: '/ormxmbqs/:ormxmbq?/editview/:editview?',
        meta: {
            caption: 'entities.ormxmbq.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormxmbqedit-view/ormxmbqedit-view.vue'),
    },
            {
                path: '/ormxmbqredirectview/:ormxmbqredirectview?',
                meta: {
                    caption: 'entities.ormxmbq.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormxmbqredirectview', parameterName: 'ormxmbqredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormxmbqredirect-view/ormxmbqredirect-view.vue'),
            },
            {
                path: '/ormpostlibredirectview/:ormpostlibredirectview?',
                meta: {
                    caption: 'entities.ormpostlib.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormpostlibredirectview', parameterName: 'ormpostlibredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormpost-lib-redirect-view/ormpost-lib-redirect-view.vue'),
            },
    {
        path: '/ormorgs/:ormorg?/xmbqpickupgridview/:xmbqpickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.xmbqpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'xmbqpickupgridview', parameterName: 'xmbqpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-org-xmbqpickup-grid-view/orm-org-xmbqpickup-grid-view.vue'),
    },
    {
        path: '/ormxmgls/:ormxmgl?/editview/:editview?',
        meta: {
            caption: 'entities.ormxmgl.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormxmgls', parameterName: 'ormxmgl' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormxmgledit-view/ormxmgledit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/editview9_editmode/:editview9_editmode?',
        meta: {
            caption: 'entities.ormorg.views.editview9_editmode.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'editview9_editmode', parameterName: 'editview9_editmode' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgedit-view9-edit-mode/ormorgedit-view9-edit-mode.vue'),
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
        component: () => import('@pages/orm/pimpersonpickup-grid-view/pimpersonpickup-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/editview/:editview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmkqdzedit-view/ormbmkqdzedit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/editview/:editview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmkqdzedit-view/ormbmkqdzedit-view.vue'),
    },
    {
        path: '/ormbmkqdzs/:ormbmkqdz?/editview/:editview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmkqdzedit-view/ormbmkqdzedit-view.vue'),
    },
            {
                path: '/ormdepestmanredirectview/:ormdepestmanredirectview?',
                meta: {
                    caption: 'entities.ormdepestman.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormdepestmanredirectview', parameterName: 'ormdepestmanredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormdep-est-man-redirect-view/ormdep-est-man-redirect-view.vue'),
            },
            {
                path: '/contractsignorgredirectview/:contractsignorgredirectview?',
                meta: {
                    caption: 'entities.pimcontractsignorg.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'contractsignorgredirectview', parameterName: 'contractsignorgredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/contract-sign-orgredirect-view/contract-sign-orgredirect-view.vue'),
            },
    {
        path: '/ormorgs/:ormorg?/orgtreeexpview/:orgtreeexpview?',
        meta: {
            caption: 'entities.ormorg.views.orgtreeexpview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/xiangmurenyuanpeizhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'orgtreeexpview', parameterName: 'orgtreeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgorg-tree-exp-view/ormorgorg-tree-exp-view.vue'),
    },
            {
                path: '/ormorgdzredirectview/:ormorgdzredirectview?',
                meta: {
                    caption: 'entities.ormorgdz.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormorgdzredirectview', parameterName: 'ormorgdzredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormorgdzredirect-view/ormorgdzredirect-view.vue'),
            },
    {
        path: '/ormsignorgs/:ormsignorg?/pimcontractsignorgs/:pimcontractsignorg?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimcontractsignorg.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/contract-sign-orggrid-view/contract-sign-orggrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pimcontractsignorgs/:pimcontractsignorg?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimcontractsignorg.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/contract-sign-orggrid-view/contract-sign-orggrid-view.vue'),
    },
    {
        path: '/pimcontractsignorgs/:pimcontractsignorg?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimcontractsignorg.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/contract-sign-orggrid-view/contract-sign-orggrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormxmbmxes/:ormxmbmx?/editview/:editview?',
        meta: {
            caption: 'entities.ormxmbmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormxmbmxes', parameterName: 'ormxmbmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormxmbmxedit-view/ormxmbmxedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/ormxmbmxes/:ormxmbmx?/editview/:editview?',
        meta: {
            caption: 'entities.ormxmbmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'ormxmbmxes', parameterName: 'ormxmbmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormxmbmxedit-view/ormxmbmxedit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormxmbmxes/:ormxmbmx?/editview/:editview?',
        meta: {
            caption: 'entities.ormxmbmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormxmbmxes', parameterName: 'ormxmbmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormxmbmxedit-view/ormxmbmxedit-view.vue'),
    },
    {
        path: '/ormxmbmxes/:ormxmbmx?/editview/:editview?',
        meta: {
            caption: 'entities.ormxmbmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormxmbmxes', parameterName: 'ormxmbmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormxmbmxedit-view/ormxmbmxedit-view.vue'),
    },
            {
                path: '/ormbmgwbzredirectview/:ormbmgwbzredirectview?',
                meta: {
                    caption: 'entities.ormbmgwbz.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormbmgwbzredirectview', parameterName: 'ormbmgwbzredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormbmgwbzredirect-view/ormbmgwbzredirect-view.vue'),
            },
            {
                path: '/ormerporgredirectview/:ormerporgredirectview?',
                meta: {
                    caption: 'entities.ormerporg.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormerporgredirectview', parameterName: 'ormerporgredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormerporgredirect-view/ormerporgredirect-view.vue'),
            },
    {
        path: '/ormtitles/:ormtitle?/editview/:editview?',
        meta: {
            caption: 'entities.ormtitle.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormtitles', parameterName: 'ormtitle' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormtitleedit-view/ormtitleedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/xmbqpickupview/:xmbqpickupview?',
        meta: {
            caption: 'entities.ormorg.views.xmbqpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'xmbqpickupview', parameterName: 'xmbqpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgxmbqpickup-view/ormorgxmbqpickup-view.vue'),
    },
            {
                path: '/ormtitleredirectview/:ormtitleredirectview?',
                meta: {
                    caption: 'entities.ormtitle.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormtitleredirectview', parameterName: 'ormtitleredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormtitleredirect-view/ormtitleredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/curleaderpickupgridview/:curleaderpickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.curleaderpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'curleaderpickupgridview', parameterName: 'curleaderpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/pimpersoncur-leader-pickup-grid-view/pimpersoncur-leader-pickup-grid-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/gridview/:gridview?',
        meta: {
            caption: 'entities.ormduty.views.gridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormdutygrid-view/ormdutygrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/editview/:editview?',
        meta: {
            caption: 'entities.ormorg.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgedit-view/ormorgedit-view.vue'),
    },
            {
                path: '/ormorginforedirectview/:ormorginforedirectview?',
                meta: {
                    caption: 'entities.ormorginfo.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormorginforedirectview', parameterName: 'ormorginforedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormorginfo-redirect-view/ormorginfo-redirect-view.vue'),
            },
            {
                path: '/ormorgsectorredirectview/:ormorgsectorredirectview?',
                meta: {
                    caption: 'entities.ormorgsector.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormorgsectorredirectview', parameterName: 'ormorgsectorredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormorgsectorredirect-view/ormorgsectorredirect-view.vue'),
            },
    {
        path: '/ormsignorgs/:ormsignorg?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormsignorg.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-sign-org-pickup-grid-view/orm-sign-org-pickup-grid-view.vue'),
    },
            {
                path: '/ormorgredirectview/:ormorgredirectview?',
                meta: {
                    caption: 'entities.ormorg.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormorgredirectview', parameterName: 'ormorgredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormorgredirect-view/ormorgredirect-view.vue'),
            },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/ormpostdetails/:ormpostdetails?/editview/:editview?',
        meta: {
            caption: 'entities.ormpostdetails.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'ormpostdetails', parameterName: 'ormpostdetails' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpost-details-edit-view/ormpost-details-edit-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/ormpostdetails/:ormpostdetails?/editview/:editview?',
        meta: {
            caption: 'entities.ormpostdetails.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'ormpostdetails', parameterName: 'ormpostdetails' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpost-details-edit-view/ormpost-details-edit-view.vue'),
    },
    {
        path: '/ormpostlibs/:ormpostlib?/ormpostdetails/:ormpostdetails?/editview/:editview?',
        meta: {
            caption: 'entities.ormpostdetails.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormpostlibs', parameterName: 'ormpostlib' },
                { pathName: 'ormpostdetails', parameterName: 'ormpostdetails' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpost-details-edit-view/ormpost-details-edit-view.vue'),
    },
    {
        path: '/ormpostdetails/:ormpostdetails?/editview/:editview?',
        meta: {
            caption: 'entities.ormpostdetails.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormpostdetails', parameterName: 'ormpostdetails' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpost-details-edit-view/ormpost-details-edit-view.vue'),
    },
    {
        path: '/ormerporgs/:ormerporg?/editview/:editview?',
        meta: {
            caption: 'entities.ormerporg.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormerporgs', parameterName: 'ormerporg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormerporgedit-view/ormerporgedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/allleveltwoorgpickupview/:allleveltwoorgpickupview?',
        meta: {
            caption: 'entities.ormorg.views.allleveltwoorgpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'allleveltwoorgpickupview', parameterName: 'allleveltwoorgpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgall-level-two-org-pickup-view/ormorgall-level-two-org-pickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormxmbqs/:ormxmbq?/gridview/:gridview?',
        meta: {
            caption: 'entities.ormxmbq.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormxmbqgrid-view/ormxmbqgrid-view.vue'),
    },
    {
        path: '/ormxmbqs/:ormxmbq?/gridview/:gridview?',
        meta: {
            caption: 'entities.ormxmbq.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ormxmbqs', parameterName: 'ormxmbq' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormxmbqgrid-view/ormxmbqgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzgridview', parameterName: 'bmkqdzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmkqdzbmkqdzgrid-view/ormbmkqdzbmkqdzgrid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzgridview', parameterName: 'bmkqdzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmkqdzbmkqdzgrid-view/ormbmkqdzbmkqdzgrid-view.vue'),
    },
    {
        path: '/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzgridview', parameterName: 'bmkqdzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmkqdzbmkqdzgrid-view/ormbmkqdzbmkqdzgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormpost.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpostpickup-view/ormpostpickup-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormpost.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpostpickup-view/ormpostpickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/sjorgpickupview/:sjorgpickupview?',
        meta: {
            caption: 'entities.ormorg.views.sjorgpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'sjorgpickupview', parameterName: 'sjorgpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsjorg-pickup-view/ormorgsjorg-pickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/sjorgpickupgridview/:sjorgpickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.sjorgpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'sjorgpickupgridview', parameterName: 'sjorgpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsjorg-pickup-grid-view/ormorgsjorg-pickup-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgdzs/:ormorgdz?/gridview/:gridview?',
        meta: {
            caption: 'entities.ormorgdz.views.gridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/rencaixulie.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgdzs', parameterName: 'ormorgdz' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgdzgrid-view/ormorgdzgrid-view.vue'),
    },
    {
        path: '/ormorgdzs/:ormorgdz?/gridview/:gridview?',
        meta: {
            caption: 'entities.ormorgdz.views.gridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/rencaixulie.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgdzs', parameterName: 'ormorgdz' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgdzgrid-view/ormorgdzgrid-view.vue'),
    },
            {
                path: '/ormxmbmxredirectview/:ormxmbmxredirectview?',
                meta: {
                    caption: 'entities.ormxmbmx.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormxmbmxredirectview', parameterName: 'ormxmbmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormxmbmxredirect-view/ormxmbmxredirect-view.vue'),
            },
    {
        path: '/ormsignorgs/:ormsignorg?/pimcontractsignorgs/:pimcontractsignorg?/editview/:editview?',
        meta: {
            caption: 'entities.pimcontractsignorg.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/contract-sign-orgedit-view/contract-sign-orgedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pimcontractsignorgs/:pimcontractsignorg?/editview/:editview?',
        meta: {
            caption: 'entities.pimcontractsignorg.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/contract-sign-orgedit-view/contract-sign-orgedit-view.vue'),
    },
    {
        path: '/pimcontractsignorgs/:pimcontractsignorg?/editview/:editview?',
        meta: {
            caption: 'entities.pimcontractsignorg.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimcontractsignorgs', parameterName: 'pimcontractsignorg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/contract-sign-orgedit-view/contract-sign-orgedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgdzs/:ormorgdz?/editview/:editview?',
        meta: {
            caption: 'entities.ormorgdz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgdzs', parameterName: 'ormorgdz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgdzedit-view/ormorgdzedit-view.vue'),
    },
    {
        path: '/ormorgdzs/:ormorgdz?/editview/:editview?',
        meta: {
            caption: 'entities.ormorgdz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgdzs', parameterName: 'ormorgdz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgdzedit-view/ormorgdzedit-view.vue'),
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
        component: () => import('@pages/orm/pimpersonpickup-view/pimpersonpickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormpost.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-post-pickup-grid-view/orm-post-pickup-grid-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormpost.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-post-pickup-grid-view/orm-post-pickup-grid-view.vue'),
    },
            {
                path: '/ormdutyredirectview/:ormdutyredirectview?',
                meta: {
                    caption: 'entities.ormduty.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormdutyredirectview', parameterName: 'ormdutyredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormdutyredirect-view/ormdutyredirect-view.vue'),
            },
            {
                path: '/ormrelationredirectview/:ormrelationredirectview?',
                meta: {
                    caption: 'entities.ormrelation.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormrelationredirectview', parameterName: 'ormrelationredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormrelation-redirect-view/ormrelation-redirect-view.vue'),
            },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/editview/:editview?',
        meta: {
            caption: 'entities.ormpost.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpostedit-view/ormpostedit-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/editview/:editview?',
        meta: {
            caption: 'entities.ormpost.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpostedit-view/ormpostedit-view.vue'),
    },
    {
        path: '/ormsignorgs/:ormsignorg?/editview/:editview?',
        meta: {
            caption: 'entities.ormsignorg.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-sign-org-edit-view/orm-sign-org-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/editview9/:editview9?',
        meta: {
            caption: 'entities.ormorgsector.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectoredit-view9/ormorgsectoredit-view9.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/editview9/:editview9?',
        meta: {
            caption: 'entities.ormorgsector.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectoredit-view9/ormorgsectoredit-view9.vue'),
    },
            {
                path: '/ormeditionredirectview/:ormeditionredirectview?',
                meta: {
                    caption: 'entities.ormedition.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormeditionredirectview', parameterName: 'ormeditionredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormeditionredirect-view/ormeditionredirect-view.vue'),
            },
    {
        path: '/ormorgs/:ormorg?/editview9/:editview9?',
        meta: {
            caption: 'entities.ormorg.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgedit-view9/ormorgedit-view9.vue'),
    },
    {
        path: '/ormorginfos/:ormorginfo?/editview/:editview?',
        meta: {
            caption: 'entities.ormorginfo.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorginfos', parameterName: 'ormorginfo' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorginfo-edit-view/ormorginfo-edit-view.vue'),
    },
    {
        path: '/ormsignorgs/:ormsignorg?/gridview/:gridview?',
        meta: {
            caption: 'entities.ormsignorg.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-sign-org-grid-view/orm-sign-org-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/ormbmgwbzs/:ormbmgwbz?/editview/:editview?',
        meta: {
            caption: 'entities.ormbmgwbz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'ormbmgwbzs', parameterName: 'ormbmgwbz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmgwbzedit-view/ormbmgwbzedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmgwbzs/:ormbmgwbz?/editview/:editview?',
        meta: {
            caption: 'entities.ormbmgwbz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmgwbzs', parameterName: 'ormbmgwbz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmgwbzedit-view/ormbmgwbzedit-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/ormbmgwbzs/:ormbmgwbz?/editview/:editview?',
        meta: {
            caption: 'entities.ormbmgwbz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'ormbmgwbzs', parameterName: 'ormbmgwbz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmgwbzedit-view/ormbmgwbzedit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormbmgwbzs/:ormbmgwbz?/editview/:editview?',
        meta: {
            caption: 'entities.ormbmgwbz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmgwbzs', parameterName: 'ormbmgwbz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmgwbzedit-view/ormbmgwbzedit-view.vue'),
    },
    {
        path: '/ormbmgwbzs/:ormbmgwbz?/editview/:editview?',
        meta: {
            caption: 'entities.ormbmgwbz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormbmgwbzs', parameterName: 'ormbmgwbz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmgwbzedit-view/ormbmgwbzedit-view.vue'),
    },
            {
                path: '/ormxmglredirectview/:ormxmglredirectview?',
                meta: {
                    caption: 'entities.ormxmgl.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormxmglredirectview', parameterName: 'ormxmglredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormxmglredirect-view/ormxmglredirect-view.vue'),
            },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/gridview/:gridview?',
        meta: {
            caption: 'entities.ormorgsector.views.gridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectorgrid-view/ormorgsectorgrid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/gridview/:gridview?',
        meta: {
            caption: 'entities.ormorgsector.views.gridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectorgrid-view/ormorgsectorgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/xjgridview/:xjgridview?',
        meta: {
            caption: 'entities.ormpost.views.xjgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'xjgridview', parameterName: 'xjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-post-xjgrid-view/orm-post-xjgrid-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/xjgridview/:xjgridview?',
        meta: {
            caption: 'entities.ormpost.views.xjgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'xjgridview', parameterName: 'xjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-post-xjgrid-view/orm-post-xjgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/allleveltwoorgpickupgridview/:allleveltwoorgpickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.allleveltwoorgpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'allleveltwoorgpickupgridview', parameterName: 'allleveltwoorgpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgall-level-two-org-pickup-grid-view/ormorgall-level-two-org-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/curleaderpickupview/:curleaderpickupview?',
        meta: {
            caption: 'entities.pimperson.views.curleaderpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'curleaderpickupview', parameterName: 'curleaderpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/pimpersoncur-leader-pickup-view/pimpersoncur-leader-pickup-view.vue'),
    },
    {
        path: '/ormerporgs/:ormerporg?/legalmpickupview/:legalmpickupview?',
        meta: {
            caption: 'entities.ormerporg.views.legalmpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormerporgs', parameterName: 'ormerporg' },
                { pathName: 'legalmpickupview', parameterName: 'legalmpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormerporglegal-mpickup-view/ormerporglegal-mpickup-view.vue'),
    },
    {
        path: '/ormerporgs/:ormerporg?/legalpickupgridview/:legalpickupgridview?',
        meta: {
            caption: 'entities.ormerporg.views.legalpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormerporgs', parameterName: 'ormerporg' },
                { pathName: 'legalpickupgridview', parameterName: 'legalpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormerporglegal-pickup-grid-view/ormerporglegal-pickup-grid-view.vue'),
    },
    {
        path: '/ormqygls/:ormqygl?/editview/:editview?',
        meta: {
            caption: 'entities.ormqygl.views.editview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xuliegangweiguanxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormqygls', parameterName: 'ormqygl' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormqygledit-view/ormqygledit-view.vue'),
    },
    {
        path: '/ormqybzwhs/:ormqybzwh?/editview/:editview?',
        meta: {
            caption: 'entities.ormqybzwh.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormqybzwhs', parameterName: 'ormqybzwh' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormqybzwhedit-view/ormqybzwhedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/editview/:editview?',
        meta: {
            caption: 'entities.ormorgsector.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectoredit-view/ormorgsectoredit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/editview/:editview?',
        meta: {
            caption: 'entities.ormorgsector.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectoredit-view/ormorgsectoredit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/bzcxgridview/:bzcxgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.bzcxgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'bzcxgridview', parameterName: 'bzcxgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectorbzcxgrid-view/ormorgsectorbzcxgrid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/bzcxgridview/:bzcxgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.bzcxgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'bzcxgridview', parameterName: 'bzcxgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectorbzcxgrid-view/ormorgsectorbzcxgrid-view.vue'),
    },
    {
        path: '/ormrelations/:ormrelation?/editview/:editview?',
        meta: {
            caption: 'entities.ormrelation.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormrelations', parameterName: 'ormrelation' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormrelation-edit-view/ormrelation-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzeditview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzeditview', parameterName: 'bmkqdzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmkqdzbmkqdzedit-view/ormbmkqdzbmkqdzedit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzeditview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzeditview', parameterName: 'bmkqdzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmkqdzbmkqdzedit-view/ormbmkqdzbmkqdzedit-view.vue'),
    },
    {
        path: '/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzeditview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzeditview', parameterName: 'bmkqdzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormbmkqdzbmkqdzedit-view/ormbmkqdzbmkqdzedit-view.vue'),
    },
    {
        path: '/ormeditions/:ormedition?/editview/:editview?',
        meta: {
            caption: 'entities.ormedition.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormeditions', parameterName: 'ormedition' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormeditionedit-view/ormeditionedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/orgtreegridview/:orgtreegridview?',
        meta: {
            caption: 'entities.ormorg.views.orgtreegridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/rencaixulie.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'orgtreegridview', parameterName: 'orgtreegridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgorg-tree-grid-view/ormorgorg-tree-grid-view.vue'),
    },
            {
                path: '/ormpostredirectview/:ormpostredirectview?',
                meta: {
                    caption: 'entities.ormpost.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormpostredirectview', parameterName: 'ormpostredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormpostredirect-view/ormpostredirect-view.vue'),
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
        component: () => import('@pages/orm/ormorgpickup-grid-view/ormorgpickup-grid-view.vue'),
    },
            {
                path: '/ormbmkqdzredirectview/:ormbmkqdzredirectview?',
                meta: {
                    caption: 'entities.ormbmkqdz.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormbmkqdzredirectview', parameterName: 'ormbmkqdzredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormbmkqdzredirect-view/ormbmkqdzredirect-view.vue'),
            },
            {
                path: '/ormsignorgredirectview/:ormsignorgredirectview?',
                meta: {
                    caption: 'entities.ormsignorg.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormsignorgredirectview', parameterName: 'ormsignorgredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/orm-sign-org-redirect-view/orm-sign-org-redirect-view.vue'),
            },
    {
        path: '/ormpostlibs/:ormpostlib?/editview/:editview?',
        meta: {
            caption: 'entities.ormpostlib.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormpostlibs', parameterName: 'ormpostlib' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpost-lib-edit-view/ormpost-lib-edit-view.vue'),
    },
    {
        path: '/ormsignorgs/:ormsignorg?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormsignorg.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-sign-org-pickup-view/orm-sign-org-pickup-view.vue'),
    },
    {
        path: '/ormpostlibs/:ormpostlib?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormpostlib.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormpostlibs', parameterName: 'ormpostlib' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpost-lib-pickup-view/ormpost-lib-pickup-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/editview/:editview?',
        meta: {
            caption: 'entities.ormduty.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormdutyedit-view/ormdutyedit-view.vue'),
    },
            {
                path: '/ormpostdetailsredirectview/:ormpostdetailsredirectview?',
                meta: {
                    caption: 'entities.ormpostdetails.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormpostdetailsredirectview', parameterName: 'ormpostdetailsredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormpost-details-redirect-view/ormpost-details-redirect-view.vue'),
            },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormdepestmen/:ormdepestman?/editview/:editview?',
        meta: {
            caption: 'entities.ormdepestman.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormdepestmen', parameterName: 'ormdepestman' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormdep-est-man-edit-view/ormdep-est-man-edit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormdepestmen/:ormdepestman?/editview/:editview?',
        meta: {
            caption: 'entities.ormdepestman.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormdepestmen', parameterName: 'ormdepestman' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormdep-est-man-edit-view/ormdep-est-man-edit-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/ormdepestmen/:ormdepestman?/editview/:editview?',
        meta: {
            caption: 'entities.ormdepestman.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'ormdepestmen', parameterName: 'ormdepestman' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormdep-est-man-edit-view/ormdep-est-man-edit-view.vue'),
    },
    {
        path: '/ormdepestmen/:ormdepestman?/editview/:editview?',
        meta: {
            caption: 'entities.ormdepestman.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormdepestmen', parameterName: 'ormdepestman' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormdep-est-man-edit-view/ormdep-est-man-edit-view.vue'),
    },
            {
                path: '/ormqybzwhredirectview/:ormqybzwhredirectview?',
                meta: {
                    caption: 'entities.ormqybzwh.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormqybzwhredirectview', parameterName: 'ormqybzwhredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormqybzwhredirect-view/ormqybzwhredirect-view.vue'),
            },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/editview9_editmode/:editview9_editmode?',
        meta: {
            caption: 'entities.ormorgsector.views.editview9_editmode.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'editview9_editmode', parameterName: 'editview9_editmode' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectoredit-view9-edit-mode/ormorgsectoredit-view9-edit-mode.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/editview9_editmode/:editview9_editmode?',
        meta: {
            caption: 'entities.ormorgsector.views.editview9_editmode.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'editview9_editmode', parameterName: 'editview9_editmode' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgsectoredit-view9-edit-mode/ormorgsectoredit-view9-edit-mode.vue'),
    },
            {
                path: '/ormqyglredirectview/:ormqyglredirectview?',
                meta: {
                    caption: 'entities.ormqygl.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'ormqyglredirectview', parameterName: 'ormqyglredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/orm/ormqyglredirect-view/ormqyglredirect-view.vue'),
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
        component: () => import('@pages/orm/ormorgpickup-view/ormorgpickup-view.vue'),
    },
    {
        path: '/ormpostlibs/:ormpostlib?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormpostlib.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormpostlibs', parameterName: 'ormpostlib' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpost-lib-pickup-grid-view/ormpost-lib-pickup-grid-view.vue'),
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
