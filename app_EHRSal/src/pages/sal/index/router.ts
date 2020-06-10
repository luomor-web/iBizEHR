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
            component: () => import('@pages/sal/index/index.vue'),
            children: [
                {
                    path: 'salitems/:salitem?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salitem.views.gridview.caption',
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
                    path: 'salparams/:salparam?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salparam.views.pickupview.caption',
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
                    path: 'salparams/:salparam?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salparam.views.pickupgridview.caption',
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
                    path: 'salschemes/:salscheme?/salschemeitems/:salschemeitem?/editview/:editview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.editview.caption',
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
                        caption: 'entities.salschemeitem.views.editview.caption',
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
                        caption: 'entities.salschemeitem.views.editview.caption',
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
                    path: 'salparams/:salparam?/editview/:editview?',
                    meta: {
                        caption: 'entities.salparam.views.editview.caption',
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
                    path: 'salrules/:salrule?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salrule.views.gridview.caption',
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
                        caption: 'entities.salruledetail.views.gridview.caption',
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
                        caption: 'entities.salrule.views.editview.caption',
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
                    path: 'ormorgs/:ormorg?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.pickupview.caption',
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
                        caption: 'entities.salrule.views.pickupgridview.caption',
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
                        caption: 'entities.salruledetail.views.editview.caption',
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
                    path: 'salsubjects/:salsubject?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salsubject.views.pickupview.caption',
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
                        caption: 'entities.salscheme.views.gridview.caption',
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
                    path: 'salschemes/:salscheme?/salschemeitems/:salschemeitem?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salschemeitem.views.gridview.caption',
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
                        caption: 'entities.salschemeitem.views.gridview.caption',
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
                        caption: 'entities.salschemeitem.views.gridview.caption',
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
                    path: 'salsubjects/:salsubject?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salsubject.views.pickupgridview.caption',
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
                    path: 'ormorgs/:ormorg?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.pickupgridview.caption',
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
                    path: 'salschemes/:salscheme?/editview/:editview?',
                    meta: {
                        caption: 'entities.salscheme.views.editview.caption',
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
                    path: 'salitems/:salitem?/editview/:editview?',
                    meta: {
                        caption: 'entities.salitem.views.editview.caption',
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
                    path: 'salsources/:salsource?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salsource.views.pickupview.caption',
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
                    path: 'saltypes/:saltype?/editview/:editview?',
                    meta: {
                        caption: 'entities.saltype.views.editview.caption',
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
                        caption: 'entities.salsource.views.pickupgridview.caption',
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
                    path: 'salparams/:salparam?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.salparam.views.gridview.caption',
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
                    path: 'salrules/:salrule?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salrule.views.pickupview.caption',
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
                    path: 'salitems/:salitem?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.salitem.views.pickupgridview.caption',
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
                    path: 'salitems/:salitem?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.salitem.views.pickupview.caption',
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
                    path: 'salsources/:salsource?/editview/:editview?',
                    meta: {
                        caption: 'entities.salsource.views.editview.caption',
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
                    path: 'saltypes/:saltype?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.saltype.views.gridview.caption',
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
                        caption: 'entities.salsource.views.gridview.caption',
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
            ...indexRoutes,
            ],
        },
    {
        path: '/ormorgs/:ormorg?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.pickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-org-pickup-grid-view/orm-org-pickup-grid-view.vue'),
    },
    {
        path: '/salitems/:salitem?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salitem.views.pickupgridview.caption',
            parameters: [
                { pathName: 'salitems', parameterName: 'salitem' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-item-pickup-grid-view/sal-item-pickup-grid-view.vue'),
    },
    {
        path: '/salrules/:salrule?/editview/:editview?',
        meta: {
            caption: 'entities.salrule.views.editview.caption',
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
            caption: 'entities.saltype.views.editview.caption',
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
            caption: 'entities.salsubject.views.pickupview.caption',
            parameters: [
                { pathName: 'salsubjects', parameterName: 'salsubject' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-subject-pickup-view/sal-subject-pickup-view.vue'),
    },
    {
        path: '/salruledetails/:salruledetail?/editview/:editview?',
        meta: {
            caption: 'entities.salruledetail.views.editview.caption',
            parameters: [
                { pathName: 'salruledetails', parameterName: 'salruledetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-rule-detail-edit-view/sal-rule-detail-edit-view.vue'),
    },
    {
        path: '/salparams/:salparam?/editview/:editview?',
        meta: {
            caption: 'entities.salparam.views.editview.caption',
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
        path: '/salruledetails/:salruledetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.salruledetail.views.gridview.caption',
            parameters: [
                { pathName: 'salruledetails', parameterName: 'salruledetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-rule-detail-grid-view/sal-rule-detail-grid-view.vue'),
    },
    {
        path: '/salsources/:salsource?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salsource.views.pickupview.caption',
            parameters: [
                { pathName: 'salsources', parameterName: 'salsource' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-source-pickup-view/sal-source-pickup-view.vue'),
    },
    {
        path: '/salsources/:salsource?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salsource.views.pickupgridview.caption',
            parameters: [
                { pathName: 'salsources', parameterName: 'salsource' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-source-pickup-grid-view/sal-source-pickup-grid-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/editview/:editview?',
        meta: {
            caption: 'entities.salscheme.views.editview.caption',
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
        path: '/salsources/:salsource?/editview/:editview?',
        meta: {
            caption: 'entities.salsource.views.editview.caption',
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
        path: '/salparams/:salparam?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salparam.views.pickupgridview.caption',
            parameters: [
                { pathName: 'salparams', parameterName: 'salparam' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-param-pickup-grid-view/sal-param-pickup-grid-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/gridview/:gridview?',
        meta: {
            caption: 'entities.salscheme.views.gridview.caption',
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
        path: '/salsources/:salsource?/gridview/:gridview?',
        meta: {
            caption: 'entities.salsource.views.gridview.caption',
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
            caption: 'entities.salrule.views.pickupview.caption',
            parameters: [
                { pathName: 'salrules', parameterName: 'salrule' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-rule-pickup-view/sal-rule-pickup-view.vue'),
    },
    {
        path: '/salschemes/:salscheme?/salschemeitems/:salschemeitem?/gridview/:gridview?',
        meta: {
            caption: 'entities.salschemeitem.views.gridview.caption',
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
            caption: 'entities.salschemeitem.views.gridview.caption',
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
            caption: 'entities.salschemeitem.views.gridview.caption',
            parameters: [
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-grid-view/sal-scheme-item-grid-view.vue'),
    },
    {
        path: '/salitems/:salitem?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.salitem.views.pickupview.caption',
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
            caption: 'entities.salparam.views.gridview.caption',
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
        path: '/salschemes/:salscheme?/salschemeitems/:salschemeitem?/editview/:editview?',
        meta: {
            caption: 'entities.salschemeitem.views.editview.caption',
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
            caption: 'entities.salschemeitem.views.editview.caption',
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
            caption: 'entities.salschemeitem.views.editview.caption',
            parameters: [
                { pathName: 'salschemeitems', parameterName: 'salschemeitem' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/sal/sal-scheme-item-edit-view/sal-scheme-item-edit-view.vue'),
    },
    {
        path: '/salitems/:salitem?/gridview/:gridview?',
        meta: {
            caption: 'entities.salitem.views.gridview.caption',
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
            caption: 'entities.salparam.views.pickupview.caption',
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
            caption: 'entities.salrule.views.gridview.caption',
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
            caption: 'entities.salrule.views.pickupgridview.caption',
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
            caption: 'entities.saltype.views.gridview.caption',
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
        path: '/ormorgs/:ormorg?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormorg.views.pickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-org-pickup-view/orm-org-pickup-view.vue'),
    },
    {
        path: '/salsubjects/:salsubject?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.salsubject.views.pickupgridview.caption',
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
            caption: 'entities.salitem.views.editview.caption',
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
