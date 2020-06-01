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
            component: () => import('@pages/att/index/index.vue'),
            children: [
                {
                    path: 'vacholidayrules/:vacholidayrules?/curormorgpickupview/:curormorgpickupview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.curormorgpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                            { pathName: 'curormorgpickupview', parameterName: 'curormorgpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-holiday-rules-cur-ormorg-pickup-view/vac-holiday-rules-cur-ormorg-pickup-view.vue'),
                },
                {
                    path: 'attendencesetups/:attendencesetup?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-pickup-grid-view/att-endence-setup-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzgridview.caption',
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzgridview.caption',
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
                },
                {
                    path: 'ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzgridview.caption',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'bmkqdzgridview', parameterName: 'bmkqdzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/kqgzwizardview/:kqgzwizardview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.kqgzwizardview.caption',
                        imgPath: '../../../img/newimage/1/jiejiariguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                            { pathName: 'kqgzwizardview', parameterName: 'kqgzwizardview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-holiday-rules-kqgzwizard-view/vac-holiday-rules-kqgzwizard-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/curzzbm_kqszpickupgridview/:curzzbm_kqszpickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.curzzbm_kqszpickupgridview.caption',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'curzzbm_kqszpickupgridview', parameterName: 'curzzbm_kqszpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-cur-zzbm-kqszpickup-grid-view/orm-orgsector-cur-zzbm-kqszpickup-grid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/curzzbm_kqszpickupgridview/:curzzbm_kqszpickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.curzzbm_kqszpickupgridview.caption',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'curzzbm_kqszpickupgridview', parameterName: 'curzzbm_kqszpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-cur-zzbm-kqszpickup-grid-view/orm-orgsector-cur-zzbm-kqszpickup-grid-view.vue'),
                },
                {
                    path: 'attendencesetups/:attendencesetup?/kqsztreeexpview/:kqsztreeexpview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.kqsztreeexpview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'kqsztreeexpview', parameterName: 'kqsztreeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-kqsztree-exp-view/att-endence-setup-kqsztree-exp-view.vue'),
                },
                {
                    path: 'attendencesetups/:attendencesetup?/kqszwizardview/:kqszwizardview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.kqszwizardview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'kqszwizardview', parameterName: 'kqszwizardview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-kqszwizard-view/att-endence-setup-kqszwizard-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/jqgzsyfpxxpickupview/:jqgzsyfpxxpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.jqgzsyfpxxpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'jqgzsyfpxxpickupview', parameterName: 'jqgzsyfpxxpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-org-jqgzsyfpxxpickup-view/orm-org-jqgzsyfpxxpickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzeditview.caption',
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzeditview.caption',
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
                },
                {
                    path: 'ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.bmkqdzeditview.caption',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'bmkqdzeditview', parameterName: 'bmkqdzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/vacholidays/:vacholiday?/jjrtxsbgridview/:jjrtxsbgridview?',
                    meta: {
                        caption: 'entities.vacholiday.views.jjrtxsbgridview.caption',
                        imgPath: '../../../img/jcgl/1/xiujiaxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                            { pathName: 'vacholidays', parameterName: 'vacholiday' },
                            { pathName: 'jjrtxsbgridview', parameterName: 'jjrtxsbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-holiday-jjrtxsbgrid-view/vac-holiday-jjrtxsbgrid-view.vue'),
                },
                {
                    path: 'vacholidays/:vacholiday?/jjrtxsbgridview/:jjrtxsbgridview?',
                    meta: {
                        caption: 'entities.vacholiday.views.jjrtxsbgridview.caption',
                        imgPath: '../../../img/jcgl/1/xiujiaxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidays', parameterName: 'vacholiday' },
                            { pathName: 'jjrtxsbgridview', parameterName: 'jjrtxsbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-holiday-jjrtxsbgrid-view/vac-holiday-jjrtxsbgrid-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/jiejiariguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-holiday-rules-grid-view/vac-holiday-rules-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/curorgpimpersonpickupgridview/:curorgpimpersonpickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.curorgpimpersonpickupgridview.caption',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'curorgpimpersonpickupgridview', parameterName: 'curorgpimpersonpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-cur-org-pimperson-pickup-grid-view/pim-person-cur-org-pimperson-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/curorgpimpersonpickupview/:curorgpimpersonpickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.curorgpimpersonpickupview.caption',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'curorgpimpersonpickupview', parameterName: 'curorgpimpersonpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-cur-org-pimperson-pickup-view/pim-person-cur-org-pimperson-pickup-view.vue'),
                },
                {
                    path: 'attendencesetups/:attendencesetup?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.editview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-edit-view/att-endence-setup-edit-view.vue'),
                },
                {
                    path: 'attendencesetups/:attendencesetup?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.mpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-mpickup-view/att-endence-setup-mpickup-view.vue'),
                },
                {
                    path: 'attendenceormorgscetors/:attendenceormorgscetor?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendenceormorgscetor.views.editview.caption',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendenceormorgscetors', parameterName: 'attendenceormorgscetor' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-ormorgscetor-edit-view/att-endence-ormorgscetor-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/bmkqszeditview/:bmkqszeditview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.bmkqszeditview.caption',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'bmkqszeditview', parameterName: 'bmkqszeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-bmkqszedit-view/orm-orgsector-bmkqszedit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/bmkqszeditview/:bmkqszeditview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.bmkqszeditview.caption',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'bmkqszeditview', parameterName: 'bmkqszeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-bmkqszedit-view/orm-orgsector-bmkqszedit-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/curormorgpickupgridview/:curormorgpickupgridview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.curormorgpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                            { pathName: 'curormorgpickupgridview', parameterName: 'curormorgpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-holiday-rules-cur-ormorg-pickup-grid-view/vac-holiday-rules-cur-ormorg-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/jqgzsypickupgridview/:jqgzsypickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.jqgzsypickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'jqgzsypickupgridview', parameterName: 'jqgzsypickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-org-jqgzsypickup-grid-view/orm-org-jqgzsypickup-grid-view.vue'),
                },
                {
                    path: 'attendencesetups/:attendencesetup?/curorgkqszgridview/:curorgkqszgridview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.curorgkqszgridview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'curorgkqszgridview', parameterName: 'curorgkqszgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-cur-org-kqszgrid-view/att-endence-setup-cur-org-kqszgrid-view.vue'),
                },
                {
                    path: 'attendancesettings/:attendancesettings?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-grid-view/att-endance-settings-grid-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.editview.caption',
                        imgPath: '../../../img/newimage/1/jiejiariguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-holiday-rules-edit-view/vac-holiday-rules-edit-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/vacleavetips/:vacleavetips?/qjtsgridview/:qjtsgridview?',
                    meta: {
                        caption: 'entities.vacleavetips.views.qjtsgridview.caption',
                        imgPath: '../../../img/jcgl/1/xiujiaxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                            { pathName: 'vacleavetips', parameterName: 'vacleavetips' },
                            { pathName: 'qjtsgridview', parameterName: 'qjtsgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-tips-qjtsgrid-view/vac-leave-tips-qjtsgrid-view.vue'),
                },
                {
                    path: 'vacleavetips/:vacleavetips?/qjtsgridview/:qjtsgridview?',
                    meta: {
                        caption: 'entities.vacleavetips.views.qjtsgridview.caption',
                        imgPath: '../../../img/jcgl/1/xiujiaxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavetips', parameterName: 'vacleavetips' },
                            { pathName: 'qjtsgridview', parameterName: 'qjtsgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-tips-qjtsgrid-view/vac-leave-tips-qjtsgrid-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/vacholidays/:vacholiday?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacholiday.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                            { pathName: 'vacholidays', parameterName: 'vacholiday' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-holiday-edit-view/vac-holiday-edit-view.vue'),
                },
                {
                    path: 'vacholidays/:vacholiday?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacholiday.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidays', parameterName: 'vacholiday' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-holiday-edit-view/vac-holiday-edit-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/vacleavetips/:vacleavetips?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacleavetips.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                            { pathName: 'vacleavetips', parameterName: 'vacleavetips' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-tips-edit-view/vac-leave-tips-edit-view.vue'),
                },
                {
                    path: 'vacleavetips/:vacleavetips?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacleavetips.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavetips', parameterName: 'vacleavetips' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-tips-edit-view/vac-leave-tips-edit-view.vue'),
                },
                {
                    path: 'attendancesettings/:attendancesettings?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.editview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-edit-view/att-endance-settings-edit-view.vue'),
                },
                {
                    path: 'attendenceormorgscetors/:attendenceormorgscetor?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendenceormorgscetor.views.gridview.caption',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendenceormorgscetors', parameterName: 'attendenceormorgscetor' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-ormorgscetor-grid-view/att-endence-ormorgscetor-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/kqszmpickupview/:kqszmpickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.kqszmpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'kqszmpickupview', parameterName: 'kqszmpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-kqszmpickup-view/orm-orgsector-kqszmpickup-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/kqszmpickupview/:kqszmpickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.kqszmpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'kqszmpickupview', parameterName: 'kqszmpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-kqszmpickup-view/orm-orgsector-kqszmpickup-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/attendancesettings/:attendancesettings?/editview/:editview?',
        meta: {
            caption: 'entities.attendancesettings.views.editview.caption',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-edit-view/att-endance-settings-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/curorgpimpersonpickupview/:curorgpimpersonpickupview?',
        meta: {
            caption: 'entities.pimperson.views.curorgpimpersonpickupview.caption',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'curorgpimpersonpickupview', parameterName: 'curorgpimpersonpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-cur-org-pimperson-pickup-view/pim-person-cur-org-pimperson-pickup-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/curorgkqszgridview/:curorgkqszgridview?',
        meta: {
            caption: 'entities.attendencesetup.views.curorgkqszgridview.caption',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'curorgkqszgridview', parameterName: 'curorgkqszgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-cur-org-kqszgrid-view/att-endence-setup-cur-org-kqszgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/jqgzsyfpxxpickupview/:jqgzsyfpxxpickupview?',
        meta: {
            caption: 'entities.ormorg.views.jqgzsyfpxxpickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'jqgzsyfpxxpickupview', parameterName: 'jqgzsyfpxxpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-org-jqgzsyfpxxpickup-view/orm-org-jqgzsyfpxxpickup-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/editview/:editview?',
        meta: {
            caption: 'entities.attendencesetup.views.editview.caption',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-edit-view/att-endence-setup-edit-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/vacleavetips/:vacleavetips?/qjtsgridview/:qjtsgridview?',
        meta: {
            caption: 'entities.vacleavetips.views.qjtsgridview.caption',
            imgPath: '../../../img/jcgl/1/xiujiaxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'vacleavetips', parameterName: 'vacleavetips' },
                { pathName: 'qjtsgridview', parameterName: 'qjtsgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-tips-qjtsgrid-view/vac-leave-tips-qjtsgrid-view.vue'),
    },
    {
        path: '/vacleavetips/:vacleavetips?/qjtsgridview/:qjtsgridview?',
        meta: {
            caption: 'entities.vacleavetips.views.qjtsgridview.caption',
            imgPath: '../../../img/jcgl/1/xiujiaxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavetips', parameterName: 'vacleavetips' },
                { pathName: 'qjtsgridview', parameterName: 'qjtsgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-tips-qjtsgrid-view/vac-leave-tips-qjtsgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/bmkqszeditview/:bmkqszeditview?',
        meta: {
            caption: 'entities.ormorgsector.views.bmkqszeditview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'bmkqszeditview', parameterName: 'bmkqszeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-bmkqszedit-view/orm-orgsector-bmkqszedit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/bmkqszeditview/:bmkqszeditview?',
        meta: {
            caption: 'entities.ormorgsector.views.bmkqszeditview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'bmkqszeditview', parameterName: 'bmkqszeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-bmkqszedit-view/orm-orgsector-bmkqszedit-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/vacholidays/:vacholiday?/editview/:editview?',
        meta: {
            caption: 'entities.vacholiday.views.editview.caption',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'vacholidays', parameterName: 'vacholiday' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-edit-view/vac-holiday-edit-view.vue'),
    },
    {
        path: '/vacholidays/:vacholiday?/editview/:editview?',
        meta: {
            caption: 'entities.vacholiday.views.editview.caption',
            parameters: [
                { pathName: 'vacholidays', parameterName: 'vacholiday' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-edit-view/vac-holiday-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/jqgzsypickupgridview/:jqgzsypickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.jqgzsypickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'jqgzsypickupgridview', parameterName: 'jqgzsypickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-org-jqgzsypickup-grid-view/orm-org-jqgzsypickup-grid-view.vue'),
    },
    {
        path: '/attendancesettings/:attendancesettings?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancesettings.views.gridview.caption',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-grid-view/att-endance-settings-grid-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.attendencesetup.views.pickupgridview.caption',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-pickup-grid-view/att-endence-setup-pickup-grid-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/kqszwizardview/:kqszwizardview?',
        meta: {
            caption: 'entities.attendencesetup.views.kqszwizardview.caption',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'kqszwizardview', parameterName: 'kqszwizardview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-kqszwizard-view/att-endence-setup-kqszwizard-view.vue'),
    },
    {
        path: '/attendenceormorgscetors/:attendenceormorgscetor?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendenceormorgscetor.views.gridview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendenceormorgscetors', parameterName: 'attendenceormorgscetor' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-ormorgscetor-grid-view/att-endence-ormorgscetor-grid-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/vacleavetips/:vacleavetips?/editview/:editview?',
        meta: {
            caption: 'entities.vacleavetips.views.editview.caption',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'vacleavetips', parameterName: 'vacleavetips' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-tips-edit-view/vac-leave-tips-edit-view.vue'),
    },
    {
        path: '/vacleavetips/:vacleavetips?/editview/:editview?',
        meta: {
            caption: 'entities.vacleavetips.views.editview.caption',
            parameters: [
                { pathName: 'vacleavetips', parameterName: 'vacleavetips' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-tips-edit-view/vac-leave-tips-edit-view.vue'),
    },
    {
        path: '/attendenceormorgscetors/:attendenceormorgscetor?/editview/:editview?',
        meta: {
            caption: 'entities.attendenceormorgscetor.views.editview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendenceormorgscetors', parameterName: 'attendenceormorgscetor' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-ormorgscetor-edit-view/att-endence-ormorgscetor-edit-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/kqsztreeexpview/:kqsztreeexpview?',
        meta: {
            caption: 'entities.attendencesetup.views.kqsztreeexpview.caption',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'kqsztreeexpview', parameterName: 'kqsztreeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-kqsztree-exp-view/att-endence-setup-kqsztree-exp-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzeditview.caption',
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
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzeditview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzeditview', parameterName: 'bmkqdzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
    },
    {
        path: '/ormbmkqdzs/:ormbmkqdz?/bmkqdzeditview/:bmkqdzeditview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzeditview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzeditview', parameterName: 'bmkqdzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/curormorgpickupgridview/:curormorgpickupgridview?',
        meta: {
            caption: 'entities.vacholidayrules.views.curormorgpickupgridview.caption',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'curormorgpickupgridview', parameterName: 'curormorgpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-rules-cur-ormorg-pickup-grid-view/vac-holiday-rules-cur-ormorg-pickup-grid-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/curormorgpickupview/:curormorgpickupview?',
        meta: {
            caption: 'entities.vacholidayrules.views.curormorgpickupview.caption',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'curormorgpickupview', parameterName: 'curormorgpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-rules-cur-ormorg-pickup-view/vac-holiday-rules-cur-ormorg-pickup-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/vacholidays/:vacholiday?/jjrtxsbgridview/:jjrtxsbgridview?',
        meta: {
            caption: 'entities.vacholiday.views.jjrtxsbgridview.caption',
            imgPath: '../../../img/jcgl/1/xiujiaxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'vacholidays', parameterName: 'vacholiday' },
                { pathName: 'jjrtxsbgridview', parameterName: 'jjrtxsbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-jjrtxsbgrid-view/vac-holiday-jjrtxsbgrid-view.vue'),
    },
    {
        path: '/vacholidays/:vacholiday?/jjrtxsbgridview/:jjrtxsbgridview?',
        meta: {
            caption: 'entities.vacholiday.views.jjrtxsbgridview.caption',
            imgPath: '../../../img/jcgl/1/xiujiaxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacholidays', parameterName: 'vacholiday' },
                { pathName: 'jjrtxsbgridview', parameterName: 'jjrtxsbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-jjrtxsbgrid-view/vac-holiday-jjrtxsbgrid-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/kqgzwizardview/:kqgzwizardview?',
        meta: {
            caption: 'entities.vacholidayrules.views.kqgzwizardview.caption',
            imgPath: '../../../img/newimage/1/jiejiariguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'kqgzwizardview', parameterName: 'kqgzwizardview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-rules-kqgzwizard-view/vac-holiday-rules-kqgzwizard-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/editview/:editview?',
        meta: {
            caption: 'entities.vacholidayrules.views.editview.caption',
            imgPath: '../../../img/newimage/1/jiejiariguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-rules-edit-view/vac-holiday-rules-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzgridview.caption',
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
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzgridview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzgridview', parameterName: 'bmkqdzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
    },
    {
        path: '/ormbmkqdzs/:ormbmkqdz?/bmkqdzgridview/:bmkqdzgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.bmkqdzgridview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'bmkqdzgridview', parameterName: 'bmkqdzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/curorgpimpersonpickupgridview/:curorgpimpersonpickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.curorgpimpersonpickupgridview.caption',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'curorgpimpersonpickupgridview', parameterName: 'curorgpimpersonpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-cur-org-pimperson-pickup-grid-view/pim-person-cur-org-pimperson-pickup-grid-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/gridview/:gridview?',
        meta: {
            caption: 'entities.vacholidayrules.views.gridview.caption',
            imgPath: '../../../img/newimage/1/jiejiariguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-rules-grid-view/vac-holiday-rules-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/curzzbm_kqszpickupgridview/:curzzbm_kqszpickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.curzzbm_kqszpickupgridview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'curzzbm_kqszpickupgridview', parameterName: 'curzzbm_kqszpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-cur-zzbm-kqszpickup-grid-view/orm-orgsector-cur-zzbm-kqszpickup-grid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/curzzbm_kqszpickupgridview/:curzzbm_kqszpickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.curzzbm_kqszpickupgridview.caption',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'curzzbm_kqszpickupgridview', parameterName: 'curzzbm_kqszpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-cur-zzbm-kqszpickup-grid-view/orm-orgsector-cur-zzbm-kqszpickup-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/kqszmpickupview/:kqszmpickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.kqszmpickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'kqszmpickupview', parameterName: 'kqszmpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-kqszmpickup-view/orm-orgsector-kqszmpickup-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/kqszmpickupview/:kqszmpickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.kqszmpickupview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'kqszmpickupview', parameterName: 'kqszmpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-kqszmpickup-view/orm-orgsector-kqszmpickup-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.attendencesetup.views.mpickupview.caption',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-mpickup-view/att-endence-setup-mpickup-view.vue'),
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
