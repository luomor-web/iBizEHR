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
            component: () => import('@pages/sal/index/index.vue'),
            children: [
                {
                    path: 'salparams/:salparam?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salparam.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salparams', parameterName: 'salparam' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-param-pickup-grid-view/sal-param-pickup-grid-view.vue'),
                },
                {
                    path: 'salparams/:salparam?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salparam.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salparams', parameterName: 'salparam' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-param-pickup-view/sal-param-pickup-view.vue'),
                },
                {
                    path: 'salplans/:salplan?/editview/:editview?',
                    meta: {
                        caption: 'entities.salplan.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanjihua.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salplans', parameterName: 'salplan' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-plan-edit-view/sal-plan-edit-view.vue'),
                },
                {
                    path: 'salrules/:salrule?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salrule.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoukemu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salrules', parameterName: 'salrule' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-rule-grid-view/sal-rule-grid-view.vue'),
                },
                {
                    path: 'salruledetails/:salruledetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salruledetail.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salruledetails', parameterName: 'salruledetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-rule-detail-grid-view/sal-rule-detail-grid-view.vue'),
                },
                {
                    path: 'salrules/:salrule?/editview/:editview?',
                    meta: {
                        caption: 'entities.salrule.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoukemu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salrules', parameterName: 'salrule' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-rule-edit-view/sal-rule-edit-view.vue'),
                },
                {
                    path: 'salstdzxes/:salstdzx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salstdzx.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/zhuanxiangjintiebiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdzxes', parameterName: 'salstdzx' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdzx-grid-view/sal-stdzx-grid-view.vue'),
                },
                {
                    path: 'salplans/:salplan?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salplan.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salplans', parameterName: 'salplan' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-plan-pickup-grid-view/sal-plan-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-pickup-view/orm-orgsector-pickup-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-pickup-view/orm-orgsector-pickup-view.vue'),
                },
                {
                    path: 'salsubjects/:salsubject?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salsubject.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsubjects', parameterName: 'salsubject' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-subject-pickup-view/sal-subject-pickup-view.vue'),
                },
                {
                    path: 'salschemes/:salscheme?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salscheme.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanfangan.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemes', parameterName: 'salscheme' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-grid-view/sal-scheme-grid-view.vue'),
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
                    path: 'salschemes/:salscheme?/salschemeitems/:salschemeitem?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemes', parameterName: 'salscheme' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-grid-view/sal-scheme-item-grid-view.vue'),
                },
                {
                    path: 'salitems/:salitem?/salschemeitems/:salschemeitem?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salitems', parameterName: 'salitem' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-grid-view/sal-scheme-item-grid-view.vue'),
                },
                {
                    path: 'salschemeitems/:salschemeitem?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-grid-view/sal-scheme-item-grid-view.vue'),
                },
                {
                    path: 'salstdzcs/:salstdzc?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salstdzc.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/zhichengjintiebiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdzcs', parameterName: 'salstdzc' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdzc-grid-view/sal-stdzc-grid-view.vue'),
                },
                {
                    path: 'salschemes/:salscheme?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.salscheme.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemes', parameterName: 'salscheme' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-mpickup-view/sal-scheme-mpickup-view.vue'),
                },
                {
                    path: 'salsubjects/:salsubject?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salsubject.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsubjects', parameterName: 'salsubject' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-subject-pickup-grid-view/sal-subject-pickup-grid-view.vue'),
                },
                {
                    path: 'salschemes/:salscheme?/editview/:editview?',
                    meta: {
                        caption: 'entities.salscheme.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanfangan.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemes', parameterName: 'salscheme' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-edit-view/sal-scheme-edit-view.vue'),
                },
                {
                    path: 'salstdzyzgs/:salstdzyzg?/editview/:editview?',
                    meta: {
                        caption: 'entities.salstdzyzg.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/zhiyezigejintiebiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdzyzgs', parameterName: 'salstdzyzg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdzyzg-edit-view/sal-stdzyzg-edit-view.vue'),
                },
                {
                    path: 'salstdgws/:salstdgw?/editview/:editview?',
                    meta: {
                        caption: 'entities.salstdgw.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/gaowenjintiebiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdgws', parameterName: 'salstdgw' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdgw-edit-view/sal-stdgw-edit-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormduty.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-duty-pickup-grid-view/orm-duty-pickup-grid-view.vue'),
                },
                {
                    path: 'salsources/:salsource?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salsource.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsources', parameterName: 'salsource' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-source-pickup-view/sal-source-pickup-view.vue'),
                },
                {
                    path: 'salparams/:salparam?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salparam.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanzhibiao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salparams', parameterName: 'salparam' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-param-grid-view/sal-param-grid-view.vue'),
                },
                {
                    path: 'salpersonstds/:salpersonstd?/editview/:editview?',
                    meta: {
                        caption: 'entities.salpersonstd.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/yuangongxinchoubiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salpersonstds', parameterName: 'salpersonstd' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-person-std-edit-view/sal-person-std-edit-view.vue'),
                },
                {
                    path: 'salitems/:salitem?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salitem.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salitems', parameterName: 'salitem' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-item-pickup-grid-view/sal-item-pickup-grid-view.vue'),
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
                    path: 'salstdzyzgs/:salstdzyzg?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salstdzyzg.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/zhiyezigejintiebiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdzyzgs', parameterName: 'salstdzyzg' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdzyzg-grid-view/sal-stdzyzg-grid-view.vue'),
                },
                {
                    path: 'salpersonstds/:salpersonstd?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salpersonstd.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/yuangongxinchoubiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salpersonstds', parameterName: 'salpersonstd' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-person-std-grid-view/sal-person-std-grid-view.vue'),
                },
                {
                    path: 'salschemes/:salscheme?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salscheme.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemes', parameterName: 'salscheme' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-pickup-view/sal-scheme-pickup-view.vue'),
                },
                {
                    path: 'salstdzcs/:salstdzc?/editview/:editview?',
                    meta: {
                        caption: 'entities.salstdzc.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/zhichengjintiebiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdzcs', parameterName: 'salstdzc' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdzc-edit-view/sal-stdzc-edit-view.vue'),
                },
                {
                    path: 'salschemes/:salscheme?/salschemeitems/:salschemeitem?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemes', parameterName: 'salscheme' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-pickup-grid-view/sal-scheme-item-pickup-grid-view.vue'),
                },
                {
                    path: 'salitems/:salitem?/salschemeitems/:salschemeitem?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salitems', parameterName: 'salitem' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-pickup-grid-view/sal-scheme-item-pickup-grid-view.vue'),
                },
                {
                    path: 'salschemeitems/:salschemeitem?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-pickup-grid-view/sal-scheme-item-pickup-grid-view.vue'),
                },
                {
                    path: 'salitems/:salitem?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.salitem.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salitems', parameterName: 'salitem' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-item-mpickup-view/sal-item-mpickup-view.vue'),
                },
                {
                    path: 'salstdgwgzs/:salstdgwgz?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salstdgwgz.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/gangweigongzibiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdgwgzs', parameterName: 'salstdgwgz' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdgwgz-grid-view/sal-stdgwgz-grid-view.vue'),
                },
                {
                    path: 'salsalarydetails/:salsalarydetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salsalarydetail.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsalarydetails', parameterName: 'salsalarydetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-salary-detail-grid-view/sal-salary-detail-grid-view.vue'),
                },
                {
                    path: 'salplans/:salplan?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salplan.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanjihua.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salplans', parameterName: 'salplan' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-plan-grid-view/sal-plan-grid-view.vue'),
                },
                {
                    path: 'salitems/:salitem?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salitem.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanyaosu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salitems', parameterName: 'salitem' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-item-grid-view/sal-item-grid-view.vue'),
                },
                {
                    path: 'salstdxmgzs/:salstdxmgz?/editview/:editview?',
                    meta: {
                        caption: 'entities.salstdxmgz.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xiangmugongzibiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdxmgzs', parameterName: 'salstdxmgz' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-std-xmgz-edit-view/sal-std-xmgz-edit-view.vue'),
                },
                {
                    path: 'salschemes/:salscheme?/salschemeitems/:salschemeitem?/editview/:editview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemes', parameterName: 'salscheme' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-edit-view/sal-scheme-item-edit-view.vue'),
                },
                {
                    path: 'salitems/:salitem?/salschemeitems/:salschemeitem?/editview/:editview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salitems', parameterName: 'salitem' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-edit-view/sal-scheme-item-edit-view.vue'),
                },
                {
                    path: 'salschemeitems/:salschemeitem?/editview/:editview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-edit-view/sal-scheme-item-edit-view.vue'),
                },
                {
                    path: 'salsalarydetails/:salsalarydetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.salsalarydetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsalarydetails', parameterName: 'salsalarydetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-salary-detail-edit-view/sal-salary-detail-edit-view.vue'),
                },
                {
                    path: 'salsalaries/:salsalary?/editview/:editview?',
                    meta: {
                        caption: 'entities.salsalary.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/xinchouxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsalaries', parameterName: 'salsalary' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-salary-edit-view/sal-salary-edit-view.vue'),
                },
                {
                    path: 'salparams/:salparam?/editview/:editview?',
                    meta: {
                        caption: 'entities.salparam.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanzhibiao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salparams', parameterName: 'salparam' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-param-edit-view/sal-param-edit-view.vue'),
                },
                {
                    path: 'salpersonstddetails/:salpersonstddetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salpersonstddetail.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salpersonstddetails', parameterName: 'salpersonstddetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/salpersonstddetailgrid-view/salpersonstddetailgrid-view.vue'),
                },
                {
                    path: 'salschemes/:salscheme?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salscheme.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemes', parameterName: 'salscheme' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-pickup-grid-view/sal-scheme-pickup-grid-view.vue'),
                },
                {
                    path: 'sallogs/:sallog?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.sallog.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'sallogs', parameterName: 'sallog' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-log-grid-view/sal-log-grid-view.vue'),
                },
                {
                    path: 'salstdgwgzs/:salstdgwgz?/editview/:editview?',
                    meta: {
                        caption: 'entities.salstdgwgz.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/gangweigongzibiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdgwgzs', parameterName: 'salstdgwgz' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdgwgz-edit-view/sal-stdgwgz-edit-view.vue'),
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
                    path: 'salrules/:salrule?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salrule.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salrules', parameterName: 'salrule' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-rule-pickup-grid-view/sal-rule-pickup-grid-view.vue'),
                },
                {
                    path: 'salruledetails/:salruledetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.salruledetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salruledetails', parameterName: 'salruledetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-rule-detail-edit-view/sal-rule-detail-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormpost.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-post-pickup-view/orm-post-pickup-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormpost.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-post-pickup-view/orm-post-pickup-view.vue'),
                },
                {
                    path: 'salstdxmgzs/:salstdxmgz?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salstdxmgz.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xiangmugongzibiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdxmgzs', parameterName: 'salstdxmgz' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-std-xmgz-grid-view/sal-std-xmgz-grid-view.vue'),
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
                    path: 'salplans/:salplan?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salplan.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salplans', parameterName: 'salplan' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-plan-pickup-view/sal-plan-pickup-view.vue'),
                },
                {
                    path: 'salitems/:salitem?/editview/:editview?',
                    meta: {
                        caption: 'entities.salitem.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanyaosu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salitems', parameterName: 'salitem' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-item-edit-view/sal-item-edit-view.vue'),
                },
                {
                    path: 'salstdgls/:salstdgl?/editview/:editview?',
                    meta: {
                        caption: 'entities.salstdgl.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/gonglinggongzibiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdgls', parameterName: 'salstdgl' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdgl-edit-view/sal-stdgl-edit-view.vue'),
                },
                {
                    path: 'salstdgws/:salstdgw?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salstdgw.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/gaowenjintiebiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdgws', parameterName: 'salstdgw' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdgw-grid-view/sal-stdgw-grid-view.vue'),
                },
                {
                    path: 'salstdzxes/:salstdzx?/editview/:editview?',
                    meta: {
                        caption: 'entities.salstdzx.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/zhuanxiangjintiebiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdzxes', parameterName: 'salstdzx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdzx-edit-view/sal-stdzx-edit-view.vue'),
                },
                {
                    path: 'saltypes/:saltype?/editview/:editview?',
                    meta: {
                        caption: 'entities.saltype.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/gongzidanmingxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'saltypes', parameterName: 'saltype' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-type-edit-view/sal-type-edit-view.vue'),
                },
                {
                    path: 'salsources/:salsource?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salsource.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsources', parameterName: 'salsource' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-source-pickup-grid-view/sal-source-pickup-grid-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormduty.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-duty-pickup-view/orm-duty-pickup-view.vue'),
                },
                {
                    path: 'salstddszns/:salstddszn?/editview/:editview?',
                    meta: {
                        caption: 'entities.salstddszn.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/dushengzinvbiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstddszns', parameterName: 'salstddszn' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stddszn-edit-view/sal-stddszn-edit-view.vue'),
                },
                {
                    path: 'salstdgls/:salstdgl?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salstdgl.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/gonglinggongzibiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstdgls', parameterName: 'salstdgl' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stdgl-grid-view/sal-stdgl-grid-view.vue'),
                },
                {
                    path: 'salsalaries/:salsalary?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salsalary.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/xinchouxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsalaries', parameterName: 'salsalary' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-salary-grid-view/sal-salary-grid-view.vue'),
                },
                {
                    path: 'salrules/:salrule?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salrule.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salrules', parameterName: 'salrule' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-rule-pickup-view/sal-rule-pickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormpost.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-post-pickup-grid-view/orm-post-pickup-grid-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormpost.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-post-pickup-grid-view/orm-post-pickup-grid-view.vue'),
                },
                {
                    path: 'salitems/:salitem?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salitem.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salitems', parameterName: 'salitem' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-item-pickup-view/sal-item-pickup-view.vue'),
                },
                {
                    path: 'salschemes/:salscheme?/salschemeitems/:salschemeitem?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemes', parameterName: 'salscheme' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-pickup-view/sal-scheme-item-pickup-view.vue'),
                },
                {
                    path: 'salitems/:salitem?/salschemeitems/:salschemeitem?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salitems', parameterName: 'salitem' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-pickup-view/sal-scheme-item-pickup-view.vue'),
                },
                {
                    path: 'salschemeitems/:salschemeitem?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-scheme-item-pickup-view/sal-scheme-item-pickup-view.vue'),
                },
                {
                    path: 'salpersonstddetails/:salpersonstddetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.salpersonstddetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salpersonstddetails', parameterName: 'salpersonstddetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/salpersonstddetailedit-view/salpersonstddetailedit-view.vue'),
                },
                {
                    path: 'salsources/:salsource?/editview/:editview?',
                    meta: {
                        caption: 'entities.salsource.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanyuan.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsources', parameterName: 'salsource' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-source-edit-view/sal-source-edit-view.vue'),
                },
                {
                    path: 'salstddszns/:salstddszn?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salstddszn.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/dushengzinvbiaozhun.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salstddszns', parameterName: 'salstddszn' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-stddszn-grid-view/sal-stddszn-grid-view.vue'),
                },
                {
                    path: 'saltypes/:saltype?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.saltype.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/gongzidanmingxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'saltypes', parameterName: 'saltype' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-type-grid-view/sal-type-grid-view.vue'),
                },
                {
                    path: 'salsources/:salsource?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salsource.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jlgl/1/xinchoujisuanyuan.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'salsources', parameterName: 'salsource' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/sal/sal-source-grid-view/sal-source-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
                },
            ...indexRoutes,
            ],
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
        path: '/salschemes/:salscheme?/salschemeitems/:salschemeitem?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salschemeitem.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salschemes', parameterName: 'salscheme' },
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-pickup-view/sal-scheme-item-pickup-view.vue'),
    },
    {
        path: '/salitems/:salitem?/salschemeitems/:salschemeitem?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salschemeitem.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-pickup-view/sal-scheme-item-pickup-view.vue'),
    },
    {
        path: '/salschemeitems/:salschemeitem?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salschemeitem.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-pickup-view/sal-scheme-item-pickup-view.vue'),
    },
    {
        path: '/salsalarydetails/:salsalarydetail?/editview/:editview?',
        meta: {
            caption: 'entities.salsalarydetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'salsalarydetails', parameterName: 'salsalarydetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-salary-detail-edit-view/sal-salary-detail-edit-view.vue'),
    },
    {
        path: '/salitems/:salitem?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salitem.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-item-pickup-grid-view/sal-item-pickup-grid-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salscheme.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salschemes', parameterName: 'salscheme' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-pickup-view/sal-scheme-pickup-view.vue'),
    },
    {
        path: '/salstdzxes/:salstdzx?/editview/:editview?',
        meta: {
            caption: 'entities.salstdzx.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/zhuanxiangjintiebiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdzxes', parameterName: 'salstdzx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdzx-edit-view/sal-stdzx-edit-view.vue'),
    },
    {
        path: '/salstddszns/:salstddszn?/gridview/:gridview?',
        meta: {
            caption: 'entities.salstddszn.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/dushengzinvbiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstddszns', parameterName: 'salstddszn' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stddszn-grid-view/sal-stddszn-grid-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/salschemeitems/:salschemeitem?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salschemeitem.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salschemes', parameterName: 'salscheme' },
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-pickup-grid-view/sal-scheme-item-pickup-grid-view.vue'),
    },
    {
        path: '/salitems/:salitem?/salschemeitems/:salschemeitem?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salschemeitem.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-pickup-grid-view/sal-scheme-item-pickup-grid-view.vue'),
    },
    {
        path: '/salschemeitems/:salschemeitem?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salschemeitem.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-pickup-grid-view/sal-scheme-item-pickup-grid-view.vue'),
    },
    {
        path: '/salrules/:salrule?/editview/:editview?',
        meta: {
            caption: 'entities.salrule.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoukemu.png',
            iconCls: '',
            parameters: [
                { pathName: 'salrules', parameterName: 'salrule' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-rule-edit-view/sal-rule-edit-view.vue'),
    },
    {
        path: '/saltypes/:saltype?/editview/:editview?',
        meta: {
            caption: 'entities.saltype.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/gongzidanmingxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'saltypes', parameterName: 'saltype' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-type-edit-view/sal-type-edit-view.vue'),
    },
    {
        path: '/salsubjects/:salsubject?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salsubject.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salsubjects', parameterName: 'salsubject' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-subject-pickup-view/sal-subject-pickup-view.vue'),
    },
    {
        path: '/salstdxmgzs/:salstdxmgz?/editview/:editview?',
        meta: {
            caption: 'entities.salstdxmgz.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xiangmugongzibiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdxmgzs', parameterName: 'salstdxmgz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-std-xmgz-edit-view/sal-std-xmgz-edit-view.vue'),
    },
    {
        path: '/salstdgws/:salstdgw?/editview/:editview?',
        meta: {
            caption: 'entities.salstdgw.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/gaowenjintiebiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdgws', parameterName: 'salstdgw' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdgw-edit-view/sal-stdgw-edit-view.vue'),
    },
    {
        path: '/salruledetails/:salruledetail?/editview/:editview?',
        meta: {
            caption: 'entities.salruledetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'salruledetails', parameterName: 'salruledetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-rule-detail-edit-view/sal-rule-detail-edit-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormduty.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-duty-pickup-grid-view/orm-duty-pickup-grid-view.vue'),
    },
    {
        path: '/salplans/:salplan?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salplan.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salplans', parameterName: 'salplan' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-plan-pickup-grid-view/sal-plan-pickup-grid-view.vue'),
    },
    {
        path: '/salstdgls/:salstdgl?/editview/:editview?',
        meta: {
            caption: 'entities.salstdgl.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/gonglinggongzibiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdgls', parameterName: 'salstdgl' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdgl-edit-view/sal-stdgl-edit-view.vue'),
    },
    {
        path: '/salparams/:salparam?/editview/:editview?',
        meta: {
            caption: 'entities.salparam.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanzhibiao.png',
            iconCls: '',
            parameters: [
                { pathName: 'salparams', parameterName: 'salparam' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-param-edit-view/sal-param-edit-view.vue'),
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
        path: '/salplans/:salplan?/gridview/:gridview?',
        meta: {
            caption: 'entities.salplan.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanjihua.png',
            iconCls: '',
            parameters: [
                { pathName: 'salplans', parameterName: 'salplan' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-plan-grid-view/sal-plan-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-pickup-view/orm-orgsector-pickup-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-pickup-view/orm-orgsector-pickup-view.vue'),
    },
    {
        path: '/salstdzyzgs/:salstdzyzg?/editview/:editview?',
        meta: {
            caption: 'entities.salstdzyzg.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/zhiyezigejintiebiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdzyzgs', parameterName: 'salstdzyzg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdzyzg-edit-view/sal-stdzyzg-edit-view.vue'),
    },
    {
        path: '/salruledetails/:salruledetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.salruledetail.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'salruledetails', parameterName: 'salruledetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-rule-detail-grid-view/sal-rule-detail-grid-view.vue'),
    },
    {
        path: '/salplans/:salplan?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salplan.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salplans', parameterName: 'salplan' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-plan-pickup-view/sal-plan-pickup-view.vue'),
    },
    {
        path: '/salsources/:salsource?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salsource.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salsources', parameterName: 'salsource' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-source-pickup-view/sal-source-pickup-view.vue'),
    },
    {
        path: '/sallogs/:sallog?/gridview/:gridview?',
        meta: {
            caption: 'entities.sallog.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'sallogs', parameterName: 'sallog' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-log-grid-view/sal-log-grid-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormduty.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-duty-pickup-view/orm-duty-pickup-view.vue'),
    },
    {
        path: '/salstdgwgzs/:salstdgwgz?/gridview/:gridview?',
        meta: {
            caption: 'entities.salstdgwgz.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/gangweigongzibiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdgwgzs', parameterName: 'salstdgwgz' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdgwgz-grid-view/sal-stdgwgz-grid-view.vue'),
    },
    {
        path: '/salitems/:salitem?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.salitem.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-item-mpickup-view/sal-item-mpickup-view.vue'),
    },
    {
        path: '/salsources/:salsource?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salsource.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salsources', parameterName: 'salsource' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-source-pickup-grid-view/sal-source-pickup-grid-view.vue'),
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
        component: () => import('@pages/orm/orm-post-pickup-view/orm-post-pickup-view.vue'),
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
        component: () => import('@pages/orm/orm-post-pickup-view/orm-post-pickup-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/editview/:editview?',
        meta: {
            caption: 'entities.salscheme.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanfangan.png',
            iconCls: '',
            parameters: [
                { pathName: 'salschemes', parameterName: 'salscheme' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-edit-view/sal-scheme-edit-view.vue'),
    },
    {
        path: '/salsalarydetails/:salsalarydetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.salsalarydetail.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'salsalarydetails', parameterName: 'salsalarydetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-salary-detail-grid-view/sal-salary-detail-grid-view.vue'),
    },
    {
        path: '/salsalaries/:salsalary?/editview/:editview?',
        meta: {
            caption: 'entities.salsalary.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/xinchouxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'salsalaries', parameterName: 'salsalary' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-salary-edit-view/sal-salary-edit-view.vue'),
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
        path: '/salstdzcs/:salstdzc?/editview/:editview?',
        meta: {
            caption: 'entities.salstdzc.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/zhichengjintiebiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdzcs', parameterName: 'salstdzc' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdzc-edit-view/sal-stdzc-edit-view.vue'),
    },
    {
        path: '/salstdgws/:salstdgw?/gridview/:gridview?',
        meta: {
            caption: 'entities.salstdgw.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/gaowenjintiebiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdgws', parameterName: 'salstdgw' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdgw-grid-view/sal-stdgw-grid-view.vue'),
    },
    {
        path: '/salsources/:salsource?/editview/:editview?',
        meta: {
            caption: 'entities.salsource.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanyuan.png',
            iconCls: '',
            parameters: [
                { pathName: 'salsources', parameterName: 'salsource' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-source-edit-view/sal-source-edit-view.vue'),
    },
    {
        path: '/salstdzcs/:salstdzc?/gridview/:gridview?',
        meta: {
            caption: 'entities.salstdzc.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/zhichengjintiebiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdzcs', parameterName: 'salstdzc' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdzc-grid-view/sal-stdzc-grid-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.salscheme.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'salschemes', parameterName: 'salscheme' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-mpickup-view/sal-scheme-mpickup-view.vue'),
    },
    {
        path: '/salparams/:salparam?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salparam.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salparams', parameterName: 'salparam' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-param-pickup-grid-view/sal-param-pickup-grid-view.vue'),
    },
    {
        path: '/salpersonstddetails/:salpersonstddetail?/editview/:editview?',
        meta: {
            caption: 'entities.salpersonstddetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'salpersonstddetails', parameterName: 'salpersonstddetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/salpersonstddetailedit-view/salpersonstddetailedit-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/gridview/:gridview?',
        meta: {
            caption: 'entities.salscheme.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanfangan.png',
            iconCls: '',
            parameters: [
                { pathName: 'salschemes', parameterName: 'salscheme' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-grid-view/sal-scheme-grid-view.vue'),
    },
    {
        path: '/salstdgls/:salstdgl?/gridview/:gridview?',
        meta: {
            caption: 'entities.salstdgl.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/gonglinggongzibiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdgls', parameterName: 'salstdgl' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdgl-grid-view/sal-stdgl-grid-view.vue'),
    },
    {
        path: '/salsources/:salsource?/gridview/:gridview?',
        meta: {
            caption: 'entities.salsource.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanyuan.png',
            iconCls: '',
            parameters: [
                { pathName: 'salsources', parameterName: 'salsource' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-source-grid-view/sal-source-grid-view.vue'),
    },
    {
        path: '/salrules/:salrule?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salrule.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salrules', parameterName: 'salrule' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-rule-pickup-view/sal-rule-pickup-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salscheme.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salschemes', parameterName: 'salscheme' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-pickup-grid-view/sal-scheme-pickup-grid-view.vue'),
    },
    {
        path: '/salpersonstds/:salpersonstd?/editview/:editview?',
        meta: {
            caption: 'entities.salpersonstd.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/yuangongxinchoubiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salpersonstds', parameterName: 'salpersonstd' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-person-std-edit-view/sal-person-std-edit-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/salschemeitems/:salschemeitem?/gridview/:gridview?',
        meta: {
            caption: 'entities.salschemeitem.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'salschemes', parameterName: 'salscheme' },
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-grid-view/sal-scheme-item-grid-view.vue'),
    },
    {
        path: '/salitems/:salitem?/salschemeitems/:salschemeitem?/gridview/:gridview?',
        meta: {
            caption: 'entities.salschemeitem.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-grid-view/sal-scheme-item-grid-view.vue'),
    },
    {
        path: '/salschemeitems/:salschemeitem?/gridview/:gridview?',
        meta: {
            caption: 'entities.salschemeitem.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-grid-view/sal-scheme-item-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
    },
    {
        path: '/salitems/:salitem?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salitem.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-item-pickup-view/sal-item-pickup-view.vue'),
    },
    {
        path: '/salparams/:salparam?/gridview/:gridview?',
        meta: {
            caption: 'entities.salparam.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanzhibiao.png',
            iconCls: '',
            parameters: [
                { pathName: 'salparams', parameterName: 'salparam' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-param-grid-view/sal-param-grid-view.vue'),
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
        path: '/salplans/:salplan?/editview/:editview?',
        meta: {
            caption: 'entities.salplan.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanjihua.png',
            iconCls: '',
            parameters: [
                { pathName: 'salplans', parameterName: 'salplan' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-plan-edit-view/sal-plan-edit-view.vue'),
    },
    {
        path: '/salsalaries/:salsalary?/gridview/:gridview?',
        meta: {
            caption: 'entities.salsalary.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/xinchouxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'salsalaries', parameterName: 'salsalary' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-salary-grid-view/sal-salary-grid-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/salschemeitems/:salschemeitem?/editview/:editview?',
        meta: {
            caption: 'entities.salschemeitem.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'salschemes', parameterName: 'salscheme' },
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-edit-view/sal-scheme-item-edit-view.vue'),
    },
    {
        path: '/salitems/:salitem?/salschemeitems/:salschemeitem?/editview/:editview?',
        meta: {
            caption: 'entities.salschemeitem.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-edit-view/sal-scheme-item-edit-view.vue'),
    },
    {
        path: '/salschemeitems/:salschemeitem?/editview/:editview?',
        meta: {
            caption: 'entities.salschemeitem.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-edit-view/sal-scheme-item-edit-view.vue'),
    },
    {
        path: '/salstdzyzgs/:salstdzyzg?/gridview/:gridview?',
        meta: {
            caption: 'entities.salstdzyzg.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/zhiyezigejintiebiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdzyzgs', parameterName: 'salstdzyzg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdzyzg-grid-view/sal-stdzyzg-grid-view.vue'),
    },
    {
        path: '/salpersonstds/:salpersonstd?/gridview/:gridview?',
        meta: {
            caption: 'entities.salpersonstd.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/yuangongxinchoubiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salpersonstds', parameterName: 'salpersonstd' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-person-std-grid-view/sal-person-std-grid-view.vue'),
    },
    {
        path: '/salitems/:salitem?/gridview/:gridview?',
        meta: {
            caption: 'entities.salitem.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanyaosu.png',
            iconCls: '',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-item-grid-view/sal-item-grid-view.vue'),
    },
    {
        path: '/salparams/:salparam?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salparam.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'salparams', parameterName: 'salparam' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-param-pickup-view/sal-param-pickup-view.vue'),
    },
    {
        path: '/salrules/:salrule?/gridview/:gridview?',
        meta: {
            caption: 'entities.salrule.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoukemu.png',
            iconCls: '',
            parameters: [
                { pathName: 'salrules', parameterName: 'salrule' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-rule-grid-view/sal-rule-grid-view.vue'),
    },
    {
        path: '/salrules/:salrule?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salrule.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salrules', parameterName: 'salrule' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-rule-pickup-grid-view/sal-rule-pickup-grid-view.vue'),
    },
    {
        path: '/saltypes/:saltype?/gridview/:gridview?',
        meta: {
            caption: 'entities.saltype.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/gongzidanmingxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'saltypes', parameterName: 'saltype' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-type-grid-view/sal-type-grid-view.vue'),
    },
    {
        path: '/salstdgwgzs/:salstdgwgz?/editview/:editview?',
        meta: {
            caption: 'entities.salstdgwgz.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/gangweigongzibiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdgwgzs', parameterName: 'salstdgwgz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdgwgz-edit-view/sal-stdgwgz-edit-view.vue'),
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
        path: '/salstdxmgzs/:salstdxmgz?/gridview/:gridview?',
        meta: {
            caption: 'entities.salstdxmgz.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xiangmugongzibiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdxmgzs', parameterName: 'salstdxmgz' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-std-xmgz-grid-view/sal-std-xmgz-grid-view.vue'),
    },
    {
        path: '/salstdzxes/:salstdzx?/gridview/:gridview?',
        meta: {
            caption: 'entities.salstdzx.views.gridview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/zhuanxiangjintiebiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstdzxes', parameterName: 'salstdzx' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stdzx-grid-view/sal-stdzx-grid-view.vue'),
    },
    {
        path: '/salsubjects/:salsubject?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salsubject.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'salsubjects', parameterName: 'salsubject' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-subject-pickup-grid-view/sal-subject-pickup-grid-view.vue'),
    },
    {
        path: '/salitems/:salitem?/editview/:editview?',
        meta: {
            caption: 'entities.salitem.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/xinchoujisuanyaosu.png',
            iconCls: '',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-item-edit-view/sal-item-edit-view.vue'),
    },
    {
        path: '/salpersonstddetails/:salpersonstddetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.salpersonstddetail.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'salpersonstddetails', parameterName: 'salpersonstddetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/salpersonstddetailgrid-view/salpersonstddetailgrid-view.vue'),
    },
    {
        path: '/salstddszns/:salstddszn?/editview/:editview?',
        meta: {
            caption: 'entities.salstddszn.views.editview.title',
            info:'',
            imgPath: '../../../img/jlgl/1/dushengzinvbiaozhun.png',
            iconCls: '',
            parameters: [
                { pathName: 'salstddszns', parameterName: 'salstddszn' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-stddszn-edit-view/sal-stddszn-edit-view.vue'),
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
