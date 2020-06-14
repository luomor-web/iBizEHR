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
            component: () => import('@pages/att/index/index.vue'),
            children: [
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
                {
                    path: 'vacholidayrules/:vacholidayrules?/curormorgpickupview/:curormorgpickupview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.curormorgpickupview.title',
                        info:'',
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
                        caption: 'entities.attendencesetup.views.pickupgridview.title',
                        info:'',
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
                    path: 'vacleavedetails/:vacleavedetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-grid-view/vac-leave-detail-grid-view.vue'),
                },
                {
                    path: 'attendencesetups/:attendencesetup?/attendancesettings/:attendancesettings?/fygzzkqgridview/:fygzzkqgridview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.fygzzkqgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'fygzzkqgridview', parameterName: 'fygzzkqgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-fygzzkqgrid-view/att-endance-settings-fygzzkqgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/attendancesettings/:attendancesettings?/fygzzkqgridview/:fygzzkqgridview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.fygzzkqgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'fygzzkqgridview', parameterName: 'fygzzkqgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-fygzzkqgrid-view/att-endance-settings-fygzzkqgrid-view.vue'),
                },
                {
                    path: 'attendancesettings/:attendancesettings?/fygzzkqgridview/:fygzzkqgridview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.fygzzkqgridview.title',
                        info:'',
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/vacholidays/:vacholiday?/jjrtxsbgridview/:jjrtxsbgridview?',
                    meta: {
                        caption: 'entities.vacholiday.views.jjrtxsbgridview.title',
                        info:'',
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
                        caption: 'entities.vacholiday.views.jjrtxsbgridview.title',
                        info:'',
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
                        caption: 'entities.attensummary.views.curzzkqhzgridview.title',
                        info:'',
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
                    component: () => import('@pages/att/pim-person-pickup-grid-view/pim-person-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/curorgpimpersonpickupgridview/:curorgpimpersonpickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.curorgpimpersonpickupgridview.title',
                        info:'',
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
                    path: 'attensummaries/:attensummary?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attensummary.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinhuizong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attensummaries', parameterName: 'attensummary' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-ensummary-grid-view/att-ensummary-grid-view.vue'),
                },
                {
                    path: 'vacleacetypes/:vacleacetype?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacleacetype.views.editview.title',
                        info:'',
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
                    path: 'attendencesetups/:attendencesetup?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.editview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/attendancerecords/:attendancerecord?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancerecord.views.editview.title',
                        info:'',
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
                        caption: 'entities.attendancerecord.views.editview.title',
                        info:'',
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
                    path: 'attendencesetups/:attendencesetup?/attendenceormorgscetors/:attendenceormorgscetor?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendenceormorgscetor.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'attendenceormorgscetors', parameterName: 'attendenceormorgscetor' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-ormorgscetor-edit-view/att-endence-ormorgscetor-edit-view.vue'),
                },
                {
                    path: 'attendenceormorgscetors/:attendenceormorgscetor?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendenceormorgscetor.views.editview.title',
                        info:'',
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
                        caption: 'entities.vacleacetype.views.gridview.title',
                        info:'',
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
                    path: 'attendancemreports/:attendancemreport?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancemreport.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-mreport-grid-view/att-endance-mreport-grid-view.vue'),
                },
                {
                    path: 'attendancemreports/:attendancemreport?/kqybtreeexpview/:kqybtreeexpview?',
                    meta: {
                        caption: 'entities.attendancemreport.views.kqybtreeexpview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/attendancerecords/:attendancerecord?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancerecord.views.gridview.title',
                        info:'',
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
                        caption: 'entities.attendancerecord.views.gridview.title',
                        info:'',
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
                    path: 'vacholidayrules/:vacholidayrules?/curormorgpickupgridview/:curormorgpickupgridview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.curormorgpickupgridview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.editview.title',
                        info:'',
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
                    path: 'attendancemreports/:attendancemreport?/attendancemreportmxes/:attendancemreportmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
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
                        caption: 'entities.attendancemreportmx.views.editview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/setattrulesgridview/:setattrulesgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.setattrulesgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'setattrulesgridview', parameterName: 'setattrulesgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-set-att-rules-grid-view/pim-person-set-att-rules-grid-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.editview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.gridview.title',
                        info:'',
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
                    path: 'attendancemreports/:attendancemreport?/attendancemreportmxes/:attendancemreportmx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
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
                        caption: 'entities.attendancemreportmx.views.gridview.title',
                        info:'',
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
                    path: 'attendencesetups/:attendencesetup?/attendancesettings/:attendancesettings?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-edit-view/att-endance-settings-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/attendancesettings/:attendancesettings?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-edit-view/att-endance-settings-edit-view.vue'),
                },
                {
                    path: 'attendancesettings/:attendancesettings?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.editview.title',
                        info:'',
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
                    path: 'attendencesetups/:attendencesetup?/attendenceormorgscetors/:attendenceormorgscetor?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendenceormorgscetor.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'attendenceormorgscetors', parameterName: 'attendenceormorgscetor' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-ormorgscetor-grid-view/att-endence-ormorgscetor-grid-view.vue'),
                },
                {
                    path: 'attendenceormorgscetors/:attendenceormorgscetor?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendenceormorgscetor.views.gridview.title',
                        info:'',
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
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.pickupgridview.title',
                        info:'',
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
                        caption: 'entities.ormbmkqdz.views.pickupgridview.title',
                        info:'',
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
                        caption: 'entities.ormbmkqdz.views.pickupgridview.title',
                        info:'',
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
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormbmkqdz.views.pickupview.title',
                        info:'',
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
                        caption: 'entities.ormbmkqdz.views.pickupview.title',
                        info:'',
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
                        caption: 'entities.ormbmkqdz.views.pickupview.title',
                        info:'',
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
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
                    component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/kqgzwizardview/:kqgzwizardview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.kqgzwizardview.title',
                        info:'',
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
                    path: 'attendencesetups/:attendencesetup?/kqsztreeexpview/:kqsztreeexpview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.kqsztreeexpview.title',
                        info:'',
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
                    path: 'attendencetypes/:attendencetype?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendencetype.views.editview.title',
                        info:'',
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
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-mpickup-view/orm-orgsector-mpickup-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-orgsector-mpickup-view/orm-orgsector-mpickup-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.vacholidayrules.views.gridview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/pim-person-mpickup-view/pim-person-mpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/curorgpimpersonpickupview/:curorgpimpersonpickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.curorgpimpersonpickupview.title',
                        info:'',
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
                        caption: 'entities.attendencesetup.views.mpickupview.title',
                        info:'',
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
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/bmkqszeditview/:bmkqszeditview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.bmkqszeditview.title',
                        info:'',
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
                        caption: 'entities.ormorgsector.views.bmkqszeditview.title',
                        info:'',
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
                    path: 'attensummaries/:attensummary?/kqhztreeexpview/:kqhztreeexpview?',
                    meta: {
                        caption: 'entities.attensummary.views.kqhztreeexpview.title',
                        info:'',
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
                    path: 'attendencesetups/:attendencesetup?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-pickup-view/att-endence-setup-pickup-view.vue'),
                },
                {
                    path: 'attendancemreports/:attendancemreport?/editview/:editview?',
                    meta: {
                        caption: 'entities.attendancemreport.views.editview.title',
                        info:'',
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
                    path: 'attendencesetups/:attendencesetup?/attendancesettings/:attendancesettings?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-grid-view/att-endance-settings-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/attendancesettings/:attendancesettings?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endance-settings-grid-view/att-endance-settings-grid-view.vue'),
                },
                {
                    path: 'attendancesettings/:attendancesettings?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendancesettings.views.gridview.title',
                        info:'',
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
                        caption: 'entities.vacsynjcx.views.editview.title',
                        info:'',
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
                    path: 'attendencesetups/:attendencesetup?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendencesetup.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/att-endence-setup-grid-view/att-endence-setup-grid-view.vue'),
                },
                {
                    path: 'vacholidayrules/:vacholidayrules?/vacleavetips/:vacleavetips?/qjtsgridview/:qjtsgridview?',
                    meta: {
                        caption: 'entities.vacleavetips.views.qjtsgridview.title',
                        info:'',
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
                        caption: 'entities.vacleavetips.views.qjtsgridview.title',
                        info:'',
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
                        caption: 'entities.vacholiday.views.editview.title',
                        info:'',
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
                        caption: 'entities.vacholiday.views.editview.title',
                        info:'',
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
                        caption: 'entities.vacleavetips.views.editview.title',
                        info:'',
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
                        caption: 'entities.vacleavetips.views.editview.title',
                        info:'',
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
                    path: 'vacsynjcxes/:vacsynjcx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.vacsynjcx.views.gridview.title',
                        info:'',
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
                    path: 'vacleavedetails/:vacleavedetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.vacleavedetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/vac/vac-leave-detail-edit-view/vac-leave-detail-edit-view.vue'),
                },
                {
                    path: 'attendencetypes/:attendencetype?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.attendencetype.views.gridview.title',
                        info:'',
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
        path: '/attendencesetups/:attendencesetup?/attendancesettings/:attendancesettings?/editview/:editview?',
        meta: {
            caption: 'entities.attendancesettings.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-edit-view/att-endance-settings-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/attendancesettings/:attendancesettings?/editview/:editview?',
        meta: {
            caption: 'entities.attendancesettings.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-edit-view/att-endance-settings-edit-view.vue'),
    },
    {
        path: '/attendancesettings/:attendancesettings?/editview/:editview?',
        meta: {
            caption: 'entities.attendancesettings.views.editview.title',
            info:'',
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
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-mpickup-view/orm-orgsector-mpickup-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-mpickup-view/orm-orgsector-mpickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/curorgpimpersonpickupview/:curorgpimpersonpickupview?',
        meta: {
            caption: 'entities.pimperson.views.curorgpimpersonpickupview.title',
            info:'',
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
        path: '/attendencesetups/:attendencesetup?/editview/:editview?',
        meta: {
            caption: 'entities.attendencesetup.views.editview.title',
            info:'',
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
            caption: 'entities.vacleavetips.views.qjtsgridview.title',
            info:'',
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
            caption: 'entities.vacleavetips.views.qjtsgridview.title',
            info:'',
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
        path: '/attendencesetups/:attendencesetup?/attendancesettings/:attendancesettings?/fygzzkqgridview/:fygzzkqgridview?',
        meta: {
            caption: 'entities.attendancesettings.views.fygzzkqgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'fygzzkqgridview', parameterName: 'fygzzkqgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-fygzzkqgrid-view/att-endance-settings-fygzzkqgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/attendancesettings/:attendancesettings?/fygzzkqgridview/:fygzzkqgridview?',
        meta: {
            caption: 'entities.attendancesettings.views.fygzzkqgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'fygzzkqgridview', parameterName: 'fygzzkqgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-fygzzkqgrid-view/att-endance-settings-fygzzkqgrid-view.vue'),
    },
    {
        path: '/attendancesettings/:attendancesettings?/fygzzkqgridview/:fygzzkqgridview?',
        meta: {
            caption: 'entities.attendancesettings.views.fygzzkqgridview.title',
            info:'',
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
        path: '/attendancemreports/:attendancemreport?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancemreport.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-mreport-grid-view/att-endance-mreport-grid-view.vue'),
    },
    {
        path: '/vacsynjcxes/:vacsynjcx?/gridview/:gridview?',
        meta: {
            caption: 'entities.vacsynjcx.views.gridview.title',
            info:'',
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
        component: () => import('@pages/att/pim-person-pickup-grid-view/pim-person-pickup-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/bmkqszeditview/:bmkqszeditview?',
        meta: {
            caption: 'entities.ormorgsector.views.bmkqszeditview.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.bmkqszeditview.title',
            info:'',
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
            caption: 'entities.vacholiday.views.editview.title',
            info:'',
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
            caption: 'entities.vacholiday.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'vacholidays', parameterName: 'vacholiday' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-edit-view/vac-holiday-edit-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/attendancesettings/:attendancesettings?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancesettings.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-grid-view/att-endance-settings-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/attendancesettings/:attendancesettings?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancesettings.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'attendancesettings', parameterName: 'attendancesettings' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endance-settings-grid-view/att-endance-settings-grid-view.vue'),
    },
    {
        path: '/attendancesettings/:attendancesettings?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancesettings.views.gridview.title',
            info:'',
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
        path: '/pimpeople/:pimperson?/setattrulesgridview/:setattrulesgridview?',
        meta: {
            caption: 'entities.pimperson.views.setattrulesgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'setattrulesgridview', parameterName: 'setattrulesgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-set-att-rules-grid-view/pim-person-set-att-rules-grid-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.attendencesetup.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-pickup-view/att-endence-setup-pickup-view.vue'),
    },
    {
        path: '/attendencetypes/:attendencetype?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendencetype.views.gridview.title',
            info:'',
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
            caption: 'entities.attendencesetup.views.pickupgridview.title',
            info:'',
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
            caption: 'entities.attensummary.views.curzzkqhzgridview.title',
            info:'',
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
        path: '/attendancemreports/:attendancemreport?/editview/:editview?',
        meta: {
            caption: 'entities.attendancemreport.views.editview.title',
            info:'',
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
        path: '/pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.gridview.title',
            info:'',
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
        path: '/attendancemreports/:attendancemreport?/attendancemreportmxes/:attendancemreportmx?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
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
            caption: 'entities.attendancemreportmx.views.gridview.title',
            info:'',
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
        path: '/attendencesetups/:attendencesetup?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendencesetup.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinshezhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-setup-grid-view/att-endence-setup-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.pickupview.title',
            info:'',
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
            caption: 'entities.ormbmkqdz.views.pickupview.title',
            info:'',
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
            caption: 'entities.ormbmkqdz.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-pickup-view/orm-bmkqdz-pickup-view.vue'),
    },
    {
        path: '/vacleavedetails/:vacleavedetail?/editview/:editview?',
        meta: {
            caption: 'entities.vacleavedetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-edit-view/vac-leave-detail-edit-view.vue'),
    },
    {
        path: '/attensummaries/:attensummary?/gridview/:gridview?',
        meta: {
            caption: 'entities.attensummary.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinhuizong.png',
            iconCls: '',
            parameters: [
                { pathName: 'attensummaries', parameterName: 'attensummary' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-ensummary-grid-view/att-ensummary-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.pimperson.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/pim-person-mpickup-view/pim-person-mpickup-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/attendenceormorgscetors/:attendenceormorgscetor?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendenceormorgscetor.views.gridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'attendenceormorgscetors', parameterName: 'attendenceormorgscetor' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-ormorgscetor-grid-view/att-endence-ormorgscetor-grid-view.vue'),
    },
    {
        path: '/attendenceormorgscetors/:attendenceormorgscetor?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendenceormorgscetor.views.gridview.title',
            info:'',
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
            caption: 'entities.vacleavetips.views.editview.title',
            info:'',
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
            caption: 'entities.vacleavetips.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'vacleavetips', parameterName: 'vacleavetips' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-tips-edit-view/vac-leave-tips-edit-view.vue'),
    },
    {
        path: '/attendencesetups/:attendencesetup?/attendenceormorgscetors/:attendenceormorgscetor?/editview/:editview?',
        meta: {
            caption: 'entities.attendenceormorgscetor.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendencesetups', parameterName: 'attendencesetup' },
                { pathName: 'attendenceormorgscetors', parameterName: 'attendenceormorgscetor' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/att-endence-ormorgscetor-edit-view/att-endence-ormorgscetor-edit-view.vue'),
    },
    {
        path: '/attendenceormorgscetors/:attendenceormorgscetor?/editview/:editview?',
        meta: {
            caption: 'entities.attendenceormorgscetor.views.editview.title',
            info:'',
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
            caption: 'entities.attendencesetup.views.kqsztreeexpview.title',
            info:'',
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
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
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
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
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
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzedit-view/orm-bmkqdz-bmkqdzedit-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/curormorgpickupgridview/:curormorgpickupgridview?',
        meta: {
            caption: 'entities.vacholidayrules.views.curormorgpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'curormorgpickupgridview', parameterName: 'curormorgpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-rules-cur-ormorg-pickup-grid-view/vac-holiday-rules-cur-ormorg-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/attendancerecords/:attendancerecord?/gridview/:gridview?',
        meta: {
            caption: 'entities.attendancerecord.views.gridview.title',
            info:'',
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
            caption: 'entities.attendancerecord.views.gridview.title',
            info:'',
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
            caption: 'entities.vacholidayrules.views.curormorgpickupview.title',
            info:'',
            parameters: [
                { pathName: 'vacholidayrules', parameterName: 'vacholidayrules' },
                { pathName: 'curormorgpickupview', parameterName: 'curormorgpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-holiday-rules-cur-ormorg-pickup-view/vac-holiday-rules-cur-ormorg-pickup-view.vue'),
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
        path: '/vacleavedetails/:vacleavedetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.vacleavedetail.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'vacleavedetails', parameterName: 'vacleavedetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/vac/vac-leave-detail-grid-view/vac-leave-detail-grid-view.vue'),
    },
    {
        path: '/vacholidayrules/:vacholidayrules?/vacholidays/:vacholiday?/jjrtxsbgridview/:jjrtxsbgridview?',
        meta: {
            caption: 'entities.vacholiday.views.jjrtxsbgridview.title',
            info:'',
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
            caption: 'entities.vacholiday.views.jjrtxsbgridview.title',
            info:'',
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
        path: '/attendancemreports/:attendancemreport?/kqybtreeexpview/:kqybtreeexpview?',
        meta: {
            caption: 'entities.attendancemreport.views.kqybtreeexpview.title',
            info:'',
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
            caption: 'entities.vacholidayrules.views.kqgzwizardview.title',
            info:'',
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
            caption: 'entities.vacholidayrules.views.editview.title',
            info:'',
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
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
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
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
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
        component: () => import('@pages/orm/orm-bmkqdz-bmkqdzgrid-view/orm-bmkqdz-bmkqdzgrid-view.vue'),
    },
    {
        path: '/vacsynjcxes/:vacsynjcx?/editview/:editview?',
        meta: {
            caption: 'entities.vacsynjcx.views.editview.title',
            info:'',
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
            caption: 'entities.pimperson.views.curorgpimpersonpickupgridview.title',
            info:'',
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
            caption: 'entities.vacholidayrules.views.gridview.title',
            info:'',
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
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ormbmkqdzs/:ormbmkqdz?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormbmkqdz.views.pickupgridview.title',
            info:'',
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
            caption: 'entities.ormbmkqdz.views.pickupgridview.title',
            info:'',
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
            caption: 'entities.ormbmkqdz.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormbmkqdzs', parameterName: 'ormbmkqdz' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-bmkqdz-pickup-grid-view/orm-bmkqdz-pickup-grid-view.vue'),
    },
    {
        path: '/attensummaries/:attensummary?/kqhztreeexpview/:kqhztreeexpview?',
        meta: {
            caption: 'entities.attensummary.views.kqhztreeexpview.title',
            info:'',
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
            caption: 'entities.vacleacetype.views.gridview.title',
            info:'',
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
            caption: 'entities.attendencetype.views.editview.title',
            info:'',
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
        path: '/vacleacetypes/:vacleacetype?/editview/:editview?',
        meta: {
            caption: 'entities.vacleacetype.views.editview.title',
            info:'',
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
        path: '/pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/editview/:editview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.editview.title',
            info:'',
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
        path: '/attendancemreports/:attendancemreport?/attendancemreportmxes/:attendancemreportmx?/editview/:editview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancemreports', parameterName: 'attendancemreport' },
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
            caption: 'entities.attendancemreportmx.views.editview.title',
            info:'',
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
            caption: 'entities.attendancerecord.views.editview.title',
            info:'',
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
            caption: 'entities.attendancerecord.views.editview.title',
            info:'',
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
            caption: 'entities.attendencesetup.views.mpickupview.title',
            info:'',
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
