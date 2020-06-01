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
                    path: 'attendancesettings/:attendancesettings?/ygszkqgridview/:ygszkqgridview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.ygszkqgridview.caption',
                        imgPath: '../../../img/newimage/1/guazhidaoqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'ygszkqgridview', parameterName: 'ygszkqgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-ygszkqgrid-view/att-endance-settings-ygszkqgrid-view.vue'),
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
                    path: 'vacleavedetails/:vacleavedetail?/jhqjmx_ck_gridview/:jhqjmx_ck_gridview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.jhqjmx_ck_gridview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'jhqjmx_ck_gridview', parameterName: 'jhqjmx_ck_gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-jhqjmx-ck-grid-view/vac-leave-detail-jhqjmx-ck-grid-view.vue'),
                },
                {
                    path: 'attendancesettings/:attendancesettings?/fygzzkqgridview/:fygzzkqgridview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.fygzzkqgridview.caption',
                        imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'fygzzkqgridview', parameterName: 'fygzzkqgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-fygzzkqgrid-view/att-endance-settings-fygzzkqgrid-view.vue'),
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
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ngeditview/:ngeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ngeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ngeditview', parameterName: 'ngeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-ngedit-view/vac-leave-manage-ngedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/ngeditview/:ngeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ngeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ngeditview', parameterName: 'ngeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-ngedit-view/vac-leave-manage-ngedit-view.vue'),
                },
                {
                    path: 'vacleavedetails/:vacleavedetail?/jhqjmx_editview/:jhqjmx_editview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.jhqjmx_editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'jhqjmx_editview', parameterName: 'jhqjmx_editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-jhqjmx-edit-view/vac-leave-detail-jhqjmx-edit-view.vue'),
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
                    path: 'attensummaries/:attensummary?/curzzkqhzgridview/:curzzkqhzgridview?',
                    meta: {
                        caption: 'entities.attensummary.views.curzzkqhzgridview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinhuizong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attensummaries', parameterName: 'attensummary' },
                            { pathName: 'curzzkqhzgridview', parameterName: 'curzzkqhzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-ensummary-cur-zzkqhzgrid-view/att-ensummary-cur-zzkqhzgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-grid-view/vac-leave-manage-grid-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-grid-view/vac-leave-manage-grid-view.vue'),
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
                    path: 'vacleavedetails/:vacleavedetail?/sjqjmx_editview/:sjqjmx_editview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.sjqjmx_editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'sjqjmx_editview', parameterName: 'sjqjmx_editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-sjqjmx-edit-view/vac-leave-detail-sjqjmx-edit-view.vue'),
                },
                {
                    path: 'vacleacetypes/:vacleacetype?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacleacetype.views.editview.caption',
                        imgPath: '../../../img/newimage/1/xiujialeixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleacetypes', parameterName: 'vacleacetype' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leace-type-edit-view/vac-leace-type-edit-view.vue'),
                },
                {
                    path: 'attendencesetups/:attendencesetup?/kqbypickupview/:kqbypickupview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.kqbypickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'kqbypickupview', parameterName: 'kqbypickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-kqbypickup-view/att-endence-setup-kqbypickup-view.vue'),
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
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/yqxeditview/:yqxeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.yqxeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'yqxeditview', parameterName: 'yqxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-yqxedit-view/vac-leave-manage-yqxedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/yqxeditview/:yqxeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.yqxeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'yqxeditview', parameterName: 'yqxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-yqxedit-view/vac-leave-manage-yqxedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/attendancerecords/:attendancerecord?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancerecord.views.editview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinjilu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'attendancerecords', parameterName: 'attendancerecord' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-record-edit-view/att-endance-record-edit-view.vue'),
                },
                {
                    path: 'attendancerecords/:attendancerecord?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancerecord.views.editview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinjilu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancerecords', parameterName: 'attendancerecord' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-record-edit-view/att-endance-record-edit-view.vue'),
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
                    path: 'vacleacetypes/:vacleacetype?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.vacleacetype.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/xiujialeixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleacetypes', parameterName: 'vacleacetype' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leace-type-grid-view/vac-leace-type-grid-view.vue'),
                },
                {
                    path: 'attendancemreports/:attendancemreport?/kqybtreeexpview/:kqybtreeexpview?',
                    meta: {
                        caption: 'entities.attendancemreport.views.kqybtreeexpview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
                            { pathName: 'kqybtreeexpview', parameterName: 'kqybtreeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-mreport-kqybtree-exp-view/att-endance-mreport-kqybtree-exp-view.vue'),
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
                    path: 'pimpeople/:pimperson?/attendancerecords/:attendancerecord?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancerecord.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinjilu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'attendancerecords', parameterName: 'attendancerecord' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-record-grid-view/att-endance-record-grid-view.vue'),
                },
                {
                    path: 'attendancerecords/:attendancerecord?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancerecord.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinjilu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancerecords', parameterName: 'attendancerecord' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-record-grid-view/att-endance-record-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.editview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-mreportmx-edit-view/att-endance-mreportmx-edit-view.vue'),
                },
                {
                    path: 'attendancemreportmxes/:attendancemreportmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.editview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-mreportmx-edit-view/att-endance-mreportmx-edit-view.vue'),
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
                    path: 'vacleavedetails/:vacleavedetail?/jhqjmx_gridview/:jhqjmx_gridview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.jhqjmx_gridview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'jhqjmx_gridview', parameterName: 'jhqjmx_gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-jhqjmx-grid-view/vac-leave-detail-jhqjmx-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-mreportmx-grid-view/att-endance-mreportmx-grid-view.vue'),
                },
                {
                    path: 'attendancemreportmxes/:attendancemreportmx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-mreportmx-grid-view/att-endance-mreportmx-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ytgeditview/:ytgeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ytgeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ytgeditview', parameterName: 'ytgeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-ytgedit-view/vac-leave-manage-ytgedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/ytgeditview/:ytgeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ytgeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ytgeditview', parameterName: 'ytgeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-ytgedit-view/vac-leave-manage-ytgedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/xjeditview/:xjeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.xjeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'xjeditview', parameterName: 'xjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-xjedit-view/vac-leave-manage-xjedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/xjeditview/:xjeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.xjeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'xjeditview', parameterName: 'xjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-xjedit-view/vac-leave-manage-xjedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-bmkqdz-pickup-grid-view/orm-bmkqdz-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-bmkqdz-pickup-grid-view/orm-bmkqdz-pickup-grid-view.vue'),
                },
                {
                    path: 'ormbmkqdzs/:ormbmkqdz?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-bmkqdz-pickup-grid-view/orm-bmkqdz-pickup-grid-view.vue'),
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
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.pickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-bmkqdz-pickup-view/orm-bmkqdz-pickup-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.pickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-bmkqdz-pickup-view/orm-bmkqdz-pickup-view.vue'),
                },
                {
                    path: 'ormbmkqdzs/:ormbmkqdz?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.pickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-bmkqdz-pickup-view/orm-bmkqdz-pickup-view.vue'),
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
                    path: 'vacleavedetails/:vacleavedetail?/sjqjmx_ck_gridview/:sjqjmx_ck_gridview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.sjqjmx_ck_gridview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'sjqjmx_ck_gridview', parameterName: 'sjqjmx_ck_gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-sjqjmx-ck-grid-view/vac-leave-detail-sjqjmx-ck-grid-view.vue'),
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
                    path: 'pcmwzd0001s/:pcmwzd0001?/ygszkqoptionview/:ygszkqoptionview?',
                    meta: {
                        caption: 'entities.pcmwzd0001.views.ygszkqoptionview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmwzd0001s', parameterName: 'pcmwzd0001' },
                            { pathName: 'ygszkqoptionview', parameterName: 'ygszkqoptionview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-wzd0001-ygszkqoption-view/pcm-wzd0001-ygszkqoption-view.vue'),
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
                    path: 'vacleavedetails/:vacleavedetail?/sjqjmx_gridview/:sjqjmx_gridview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.sjqjmx_gridview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'sjqjmx_gridview', parameterName: 'sjqjmx_gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-sjqjmx-grid-view/vac-leave-detail-sjqjmx-grid-view.vue'),
                },
                {
                    path: 'vacleavedetails/:vacleavedetail?/jhqjmx_ck_editview/:jhqjmx_ck_editview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.jhqjmx_ck_editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'jhqjmx_ck_editview', parameterName: 'jhqjmx_ck_editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-jhqjmx-ck-edit-view/vac-leave-detail-jhqjmx-ck-edit-view.vue'),
                },
                {
                    path: 'attendencetypes/:attendencetype?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendencetype.views.editview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinleixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencetypes', parameterName: 'attendencetype' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-type-edit-view/att-endence-type-edit-view.vue'),
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
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/wfproxystartview/:wfproxystartview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.wfproxystartview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'wfproxystartview', parameterName: 'wfproxystartview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-wfproxy-start-view/vac-leave-manage-wfproxy-start-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/wfproxystartview/:wfproxystartview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.wfproxystartview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'wfproxystartview', parameterName: 'wfproxystartview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-wfproxy-start-view/vac-leave-manage-wfproxy-start-view.vue'),
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
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ybheditview/:ybheditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ybheditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ybheditview', parameterName: 'ybheditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-ybhedit-view/vac-leave-manage-ybhedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/ybheditview/:ybheditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ybheditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ybheditview', parameterName: 'ybheditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-ybhedit-view/vac-leave-manage-ybhedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/kqjrypickupgridview/:kqjrypickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.kqjrypickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'kqjrypickupgridview', parameterName: 'kqjrypickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-kqjrypickup-grid-view/pim-person-kqjrypickup-grid-view.vue'),
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
                    path: 'vacleavedetails/:vacleavedetail?/sjqjmx_ck_editview/:sjqjmx_ck_editview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.sjqjmx_ck_editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'sjqjmx_ck_editview', parameterName: 'sjqjmx_ck_editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-sjqjmx-ck-edit-view/vac-leave-detail-sjqjmx-ck-edit-view.vue'),
                },
                {
                    path: 'attendencesetups/:attendencesetup?/kqbpickupgridview/:kqbpickupgridview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.kqbpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'kqbpickupgridview', parameterName: 'kqbpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-kqbpickup-grid-view/att-endence-setup-kqbpickup-grid-view.vue'),
                },
                {
                    path: 'attensummaries/:attensummary?/kqhztreeexpview/:kqhztreeexpview?',
                    meta: {
                        caption: 'entities.attensummary.views.kqhztreeexpview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinhuizong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attensummaries', parameterName: 'attensummary' },
                            { pathName: 'kqhztreeexpview', parameterName: 'kqhztreeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-ensummary-kqhztree-exp-view/att-ensummary-kqhztree-exp-view.vue'),
                },
                {
                    path: 'attendancemreports/:attendancemreport?/curzzkqybgridview/:curzzkqybgridview?',
                    meta: {
                        caption: 'entities.attendancemreport.views.curzzkqybgridview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
                            { pathName: 'curzzkqybgridview', parameterName: 'curzzkqybgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-mreport-cur-zzkqybgrid-view/att-endance-mreport-cur-zzkqybgrid-view.vue'),
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
                    path: 'attendancemreports/:attendancemreport?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancemreport.views.editview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-mreport-edit-view/att-endance-mreport-edit-view.vue'),
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
                    path: 'vacsynjcxes/:vacsynjcx?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacsynjcx.views.editview.caption',
                        imgPath: '../../../img/newimage/1/shengyunianjiatongji.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacsynjcxes', parameterName: 'vacsynjcx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-synjcx-edit-view/vac-synjcx-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/wfproxyresultview/:wfproxyresultview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.wfproxyresultview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'wfproxyresultview', parameterName: 'wfproxyresultview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-wfproxy-result-view/vac-leave-manage-wfproxy-result-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/wfproxyresultview/:wfproxyresultview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.wfproxyresultview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'wfproxyresultview', parameterName: 'wfproxyresultview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-wfproxy-result-view/vac-leave-manage-wfproxy-result-view.vue'),
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
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/spzeditview/:spzeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.spzeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'spzeditview', parameterName: 'spzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-spzedit-view/vac-leave-manage-spzedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/spzeditview/:spzeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.spzeditview.caption',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'spzeditview', parameterName: 'spzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-manage-spzedit-view/vac-leave-manage-spzedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/kqjrypickupview/:kqjrypickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.kqjrypickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'kqjrypickupview', parameterName: 'kqjrypickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-kqjrypickup-view/pim-person-kqjrypickup-view.vue'),
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
                    path: 'vacsynjcxes/:vacsynjcx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.vacsynjcx.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/shengyunianjiatongji.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacsynjcxes', parameterName: 'vacsynjcx' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-synjcx-grid-view/vac-synjcx-grid-view.vue'),
                },
                {
                    path: 'attendencetypes/:attendencetype?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendencetype.views.gridview.caption',
                        imgPath: '../../../img/newimage/1/kaoqinleixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencetypes', parameterName: 'attendencetype' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-type-grid-view/att-endence-type-grid-view.vue'),
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
        path: '/attendencesetups/:attendencesetup?/kqbypickupview/:kqbypickupview?',
        meta: {
            caption: 'entities.attendencesetup.views.kqbypickupview.caption',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'kqbypickupview', parameterName: 'kqbypickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-kqbypickup-view/att-endence-setup-kqbypickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/spzeditview/:spzeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.spzeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'spzeditview', parameterName: 'spzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-spzedit-view/vac-leave-manage-spzedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/spzeditview/:spzeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.spzeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'spzeditview', parameterName: 'spzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-spzedit-view/vac-leave-manage-spzedit-view.vue'),
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
        path: '/attendancesettings/:attendancesettings?/fygzzkqgridview/:fygzzkqgridview?',
        meta: {
            caption: 'entities.attendancesettings.views.fygzzkqgridview.caption',
            imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'fygzzkqgridview', parameterName: 'fygzzkqgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-fygzzkqgrid-view/att-endance-settings-fygzzkqgrid-view.vue'),
    },
    {
        path: '/vacleavedetails/:vacleavedetail?/sjqjmx_editview/:sjqjmx_editview?',
        meta: {
            caption: 'entities.vacleavedetail.views.sjqjmx_editview.caption',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'sjqjmx_editview', parameterName: 'sjqjmx_editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-sjqjmx-edit-view/vac-leave-detail-sjqjmx-edit-view.vue'),
    },
    {
        path: '/vacsynjcxes/:vacsynjcx?/gridview/:gridview?',
        meta: {
            caption: 'entities.vacsynjcx.views.gridview.caption',
            imgPath: '../../../img/newimage/1/shengyunianjiatongji.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacsynjcxes', parameterName: 'vacsynjcx' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-synjcx-grid-view/vac-synjcx-grid-view.vue'),
    },
    {
        path: '/vacleavedetails/:vacleavedetail?/jhqjmx_editview/:jhqjmx_editview?',
        meta: {
            caption: 'entities.vacleavedetail.views.jhqjmx_editview.caption',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'jhqjmx_editview', parameterName: 'jhqjmx_editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-jhqjmx-edit-view/vac-leave-detail-jhqjmx-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/wfproxystartview/:wfproxystartview?',
        meta: {
            caption: 'entities.vacleavemanage.views.wfproxystartview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'wfproxystartview', parameterName: 'wfproxystartview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-wfproxy-start-view/vac-leave-manage-wfproxy-start-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/wfproxystartview/:wfproxystartview?',
        meta: {
            caption: 'entities.vacleavemanage.views.wfproxystartview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'wfproxystartview', parameterName: 'wfproxystartview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-wfproxy-start-view/vac-leave-manage-wfproxy-start-view.vue'),
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
        path: '/vacleavedetails/:vacleavedetail?/jhqjmx_gridview/:jhqjmx_gridview?',
        meta: {
            caption: 'entities.vacleavedetail.views.jhqjmx_gridview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'jhqjmx_gridview', parameterName: 'jhqjmx_gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-jhqjmx-grid-view/vac-leave-detail-jhqjmx-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ytgeditview/:ytgeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ytgeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ytgeditview', parameterName: 'ytgeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-ytgedit-view/vac-leave-manage-ytgedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/ytgeditview/:ytgeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ytgeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ytgeditview', parameterName: 'ytgeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-ytgedit-view/vac-leave-manage-ytgedit-view.vue'),
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
        path: '/vacleavedetails/:vacleavedetail?/sjqjmx_ck_editview/:sjqjmx_ck_editview?',
        meta: {
            caption: 'entities.vacleavedetail.views.sjqjmx_ck_editview.caption',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'sjqjmx_ck_editview', parameterName: 'sjqjmx_ck_editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-sjqjmx-ck-edit-view/vac-leave-detail-sjqjmx-ck-edit-view.vue'),
    },
    {
        path: '/vacleavedetails/:vacleavedetail?/sjqjmx_ck_gridview/:sjqjmx_ck_gridview?',
        meta: {
            caption: 'entities.vacleavedetail.views.sjqjmx_ck_gridview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'sjqjmx_ck_gridview', parameterName: 'sjqjmx_ck_gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-sjqjmx-ck-grid-view/vac-leave-detail-sjqjmx-ck-grid-view.vue'),
    },
    {
        path: '/attendencetypes/:attendencetype?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendencetype.views.gridview.caption',
            imgPath: '../../../img/newimage/1/kaoqinleixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencetypes', parameterName: 'attendencetype' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-type-grid-view/att-endence-type-grid-view.vue'),
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
        path: '/attensummaries/:attensummary?/curzzkqhzgridview/:curzzkqhzgridview?',
        meta: {
            caption: 'entities.attensummary.views.curzzkqhzgridview.caption',
            imgPath: '../../../img/newimage/1/kaoqinhuizong.png',
            iconCls: '',
            parameters: [
                { pathName: 'attensummaries', parameterName: 'attensummary' },
                { pathName: 'curzzkqhzgridview', parameterName: 'curzzkqhzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-ensummary-cur-zzkqhzgrid-view/att-ensummary-cur-zzkqhzgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ngeditview/:ngeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ngeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ngeditview', parameterName: 'ngeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-ngedit-view/vac-leave-manage-ngedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/ngeditview/:ngeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ngeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ngeditview', parameterName: 'ngeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-ngedit-view/vac-leave-manage-ngedit-view.vue'),
    },
    {
        path: '/attendancemreports/:attendancemreport?/editview/:editview?',
        meta: {
            caption: 'entities.attendancemreport.views.editview.caption',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-mreport-edit-view/att-endance-mreport-edit-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/kqbpickupgridview/:kqbpickupgridview?',
        meta: {
            caption: 'entities.attendencesetup.views.kqbpickupgridview.caption',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'kqbpickupgridview', parameterName: 'kqbpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-kqbpickup-grid-view/att-endence-setup-kqbpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.gridview.caption',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-mreportmx-grid-view/att-endance-mreportmx-grid-view.vue'),
    },
    {
        path: '/attendancemreportmxes/:attendancemreportmx?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.gridview.caption',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-mreportmx-grid-view/att-endance-mreportmx-grid-view.vue'),
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
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.pickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-pickup-view/orm-bmkqdz-pickup-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.pickupview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-pickup-view/orm-bmkqdz-pickup-view.vue'),
    },
    {
        path: '/ormbmkqdzs/:ormbmkqdz?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.pickupview.caption',
            parameters: [
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-pickup-view/orm-bmkqdz-pickup-view.vue'),
    },
    {
        path: '/pcmwzd0001s/:pcmwzd0001?/ygszkqoptionview/:ygszkqoptionview?',
        meta: {
            caption: 'entities.pcmwzd0001.views.ygszkqoptionview.caption',
            parameters: [
                { pathName: 'pcmwzd0001s', parameterName: 'pcmwzd0001' },
                { pathName: 'ygszkqoptionview', parameterName: 'ygszkqoptionview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-wzd0001-ygszkqoption-view/pcm-wzd0001-ygszkqoption-view.vue'),
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
        path: '/vacleavedetails/:vacleavedetail?/jhqjmx_ck_gridview/:jhqjmx_ck_gridview?',
        meta: {
            caption: 'entities.vacleavedetail.views.jhqjmx_ck_gridview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'jhqjmx_ck_gridview', parameterName: 'jhqjmx_ck_gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-jhqjmx-ck-grid-view/vac-leave-detail-jhqjmx-ck-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/attendancerecords/:attendancerecord?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancerecord.views.gridview.caption',
            imgPath: '../../../img/newimage/1/kaoqinjilu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'attendancerecords', parameterName: 'attendancerecord' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-record-grid-view/att-endance-record-grid-view.vue'),
    },
    {
        path: '/attendancerecords/:attendancerecord?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancerecord.views.gridview.caption',
            imgPath: '../../../img/newimage/1/kaoqinjilu.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancerecords', parameterName: 'attendancerecord' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-record-grid-view/att-endance-record-grid-view.vue'),
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
        path: '/vacleavedetails/:vacleavedetail?/jhqjmx_ck_editview/:jhqjmx_ck_editview?',
        meta: {
            caption: 'entities.vacleavedetail.views.jhqjmx_ck_editview.caption',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'jhqjmx_ck_editview', parameterName: 'jhqjmx_ck_editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-jhqjmx-ck-edit-view/vac-leave-detail-jhqjmx-ck-edit-view.vue'),
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
        path: '/vacleavedetails/:vacleavedetail?/sjqjmx_gridview/:sjqjmx_gridview?',
        meta: {
            caption: 'entities.vacleavedetail.views.sjqjmx_gridview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'sjqjmx_gridview', parameterName: 'sjqjmx_gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-sjqjmx-grid-view/vac-leave-detail-sjqjmx-grid-view.vue'),
    },
    {
        path: '/attendancemreports/:attendancemreport?/curzzkqybgridview/:curzzkqybgridview?',
        meta: {
            caption: 'entities.attendancemreport.views.curzzkqybgridview.caption',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
                { pathName: 'curzzkqybgridview', parameterName: 'curzzkqybgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-mreport-cur-zzkqybgrid-view/att-endance-mreport-cur-zzkqybgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/yqxeditview/:yqxeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.yqxeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'yqxeditview', parameterName: 'yqxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-yqxedit-view/vac-leave-manage-yqxedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/yqxeditview/:yqxeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.yqxeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'yqxeditview', parameterName: 'yqxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-yqxedit-view/vac-leave-manage-yqxedit-view.vue'),
    },
    {
        path: '/attendancemreports/:attendancemreport?/kqybtreeexpview/:kqybtreeexpview?',
        meta: {
            caption: 'entities.attendancemreport.views.kqybtreeexpview.caption',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
                { pathName: 'kqybtreeexpview', parameterName: 'kqybtreeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-mreport-kqybtree-exp-view/att-endance-mreport-kqybtree-exp-view.vue'),
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
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/gridview/:gridview?',
        meta: {
            caption: 'entities.vacleavemanage.views.gridview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-grid-view/vac-leave-manage-grid-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/gridview/:gridview?',
        meta: {
            caption: 'entities.vacleavemanage.views.gridview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-grid-view/vac-leave-manage-grid-view.vue'),
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
        path: '/vacsynjcxes/:vacsynjcx?/editview/:editview?',
        meta: {
            caption: 'entities.vacsynjcx.views.editview.caption',
            imgPath: '../../../img/newimage/1/shengyunianjiatongji.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacsynjcxes', parameterName: 'vacsynjcx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-synjcx-edit-view/vac-synjcx-edit-view.vue'),
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
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ybheditview/:ybheditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ybheditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ybheditview', parameterName: 'ybheditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-ybhedit-view/vac-leave-manage-ybhedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/ybheditview/:ybheditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ybheditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ybheditview', parameterName: 'ybheditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-ybhedit-view/vac-leave-manage-ybhedit-view.vue'),
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
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.pickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-pickup-grid-view/orm-bmkqdz-pickup-grid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.pickupgridview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-pickup-grid-view/orm-bmkqdz-pickup-grid-view.vue'),
    },
    {
        path: '/ormbmkqdzs/:ormbmkqdz?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.pickupgridview.caption',
            parameters: [
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-pickup-grid-view/orm-bmkqdz-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/kqjrypickupview/:kqjrypickupview?',
        meta: {
            caption: 'entities.pimperson.views.kqjrypickupview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'kqjrypickupview', parameterName: 'kqjrypickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-kqjrypickup-view/pim-person-kqjrypickup-view.vue'),
    },
    {
        path: '/attensummaries/:attensummary?/kqhztreeexpview/:kqhztreeexpview?',
        meta: {
            caption: 'entities.attensummary.views.kqhztreeexpview.caption',
            imgPath: '../../../img/newimage/1/kaoqinhuizong.png',
            iconCls: '',
            parameters: [
                { pathName: 'attensummaries', parameterName: 'attensummary' },
                { pathName: 'kqhztreeexpview', parameterName: 'kqhztreeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-ensummary-kqhztree-exp-view/att-ensummary-kqhztree-exp-view.vue'),
    },
    {
        path: '/vacleacetypes/:vacleacetype?/gridview/:gridview?',
        meta: {
            caption: 'entities.vacleacetype.views.gridview.caption',
            imgPath: '../../../img/newimage/1/xiujialeixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleacetypes', parameterName: 'vacleacetype' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leace-type-grid-view/vac-leace-type-grid-view.vue'),
    },
    {
        path: '/attendencetypes/:attendencetype?/editview/:editview?',
        meta: {
            caption: 'entities.attendencetype.views.editview.caption',
            imgPath: '../../../img/newimage/1/kaoqinleixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencetypes', parameterName: 'attendencetype' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-type-edit-view/att-endence-type-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/xjeditview/:xjeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.xjeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'xjeditview', parameterName: 'xjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-xjedit-view/vac-leave-manage-xjedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/xjeditview/:xjeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.xjeditview.caption',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'xjeditview', parameterName: 'xjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-manage-xjedit-view/vac-leave-manage-xjedit-view.vue'),
    },
    {
        path: '/vacleacetypes/:vacleacetype?/editview/:editview?',
        meta: {
            caption: 'entities.vacleacetype.views.editview.caption',
            imgPath: '../../../img/newimage/1/xiujialeixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleacetypes', parameterName: 'vacleacetype' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leace-type-edit-view/vac-leace-type-edit-view.vue'),
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
        path: '/pimpeople/:pimperson?/kqjrypickupgridview/:kqjrypickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.kqjrypickupgridview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'kqjrypickupgridview', parameterName: 'kqjrypickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-kqjrypickup-grid-view/pim-person-kqjrypickup-grid-view.vue'),
    },
    {
        path: '/attendancesettings/:attendancesettings?/ygszkqgridview/:ygszkqgridview?',
        meta: {
            caption: 'entities.attendancesettings.views.ygszkqgridview.caption',
            imgPath: '../../../img/newimage/1/guazhidaoqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'ygszkqgridview', parameterName: 'ygszkqgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-ygszkqgrid-view/att-endance-settings-ygszkqgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/editview/:editview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.editview.caption',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-mreportmx-edit-view/att-endance-mreportmx-edit-view.vue'),
    },
    {
        path: '/attendancemreportmxes/:attendancemreportmx?/editview/:editview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.editview.caption',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-mreportmx-edit-view/att-endance-mreportmx-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/attendancerecords/:attendancerecord?/editview/:editview?',
        meta: {
            caption: 'entities.attendancerecord.views.editview.caption',
            imgPath: '../../../img/newimage/1/kaoqinjilu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'attendancerecords', parameterName: 'attendancerecord' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-record-edit-view/att-endance-record-edit-view.vue'),
    },
    {
        path: '/attendancerecords/:attendancerecord?/editview/:editview?',
        meta: {
            caption: 'entities.attendancerecord.views.editview.caption',
            imgPath: '../../../img/newimage/1/kaoqinjilu.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancerecords', parameterName: 'attendancerecord' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-record-edit-view/att-endance-record-edit-view.vue'),
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
