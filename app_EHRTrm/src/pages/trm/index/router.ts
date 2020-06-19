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
            component: () => import('@pages/trm/index/index.vue'),
            children: [
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-pickup-grid-view/trm-train-plan-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-pickup-grid-view/trm-train-plan-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-edit-view9/trm-train-course-edit-view9.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-edit-view9/trm-train-course-edit-view9.vue'),
                },
                {
                    path: 'trmtraincourses/:trmtraincourse?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-edit-view9/trm-train-course-edit-view9.vue'),
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
                    path: 'trmtrainactapplies/:trmtrainactapply?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainactapply.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainactapplies', parameterName: 'trmtrainactapply' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-actapply-pickup-grid-view/trm-train-actapply-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-pickup-view/trm-train-plan-pickup-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-pickup-view/trm-train-plan-pickup-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-pickup-grid-view/trm-train-course-pickup-grid-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-pickup-grid-view/trm-train-course-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtraincourses/:trmtraincourse?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-pickup-grid-view/trm-train-course-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/wbeditview/:wbeditview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.wbeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'wbeditview', parameterName: 'wbeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-wbedit-view/trm-train-teacher-wbedit-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/wbeditview/:wbeditview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.wbeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'wbeditview', parameterName: 'wbeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-wbedit-view/trm-train-teacher-wbedit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
                },
                {
                    path: 'trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
                },
                {
                    path: 'trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
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
                    path: 'trmtrainagencies/:trmtrainagency?/trmhmatsers/:trmhmatser?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmhmatser.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-hmatser-pickup-grid-view/trm-hmatser-pickup-grid-view.vue'),
                },
                {
                    path: 'trmhmatsers/:trmhmatser?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmhmatser.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-hmatser-pickup-grid-view/trm-hmatser-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
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
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-edit-view/trm-train-plan-edit-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-edit-view/trm-train-plan-edit-view.vue'),
                },
                {
                    path: 'trmplanformus/:trmplanformu?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmplanformu.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmplanformus', parameterName: 'trmplanformu' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-plan-formu-grid-view/trm-plan-formu-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
                },
                {
                    path: 'trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
                },
                {
                    path: 'trmteachercharges/:trmteachercharge?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.bjgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'bjgridview', parameterName: 'bjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.bjgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'bjgridview', parameterName: 'bjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.bjgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'bjgridview', parameterName: 'bjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.bjgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'bjgridview', parameterName: 'bjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
                },
                {
                    path: 'trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.bjgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'bjgridview', parameterName: 'bjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-pickup-view/trm-train-course-pickup-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-pickup-view/trm-train-course-pickup-view.vue'),
                },
                {
                    path: 'trmtraincourses/:trmtraincourse?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-pickup-view/trm-train-course-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainpeople/:trmtrainperson?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainperson.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/kfgl/1/peixunjiluguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainpeople', parameterName: 'trmtrainperson' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-person-grid-view/trm-train-person-grid-view.vue'),
                },
                {
                    path: 'trmtrainpeople/:trmtrainperson?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainperson.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/kfgl/1/peixunjiluguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainpeople', parameterName: 'trmtrainperson' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-person-grid-view/trm-train-person-grid-view.vue'),
                },
                {
                    path: 'trmtrainactments/:trmtrainactment?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainactment.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunhuodongpinggu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainactments', parameterName: 'trmtrainactment' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-actment-edit-view/trm-train-actment-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbgridview', parameterName: 'tbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbgridview', parameterName: 'tbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbgridview', parameterName: 'tbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbgridview', parameterName: 'tbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
                },
                {
                    path: 'trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbgridview', parameterName: 'tbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
                },
                {
                    path: 'trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbgridview', parameterName: 'tbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-mpickup-view/trm-train-teacher-mpickup-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-mpickup-view/trm-train-teacher-mpickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
                },
                {
                    path: 'trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/tabexpview/:tabexpview?',
                    meta: {
                        caption: 'entities.trmtrainagency.views.tabexpview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'tabexpview', parameterName: 'tabexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-agency-tab-exp-view/trm-train-agency-tab-exp-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainaddress.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-address-pickup-view/trm-train-address-pickup-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmtrainfacies/:trmtrainfacies?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainfacies.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunsheshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmtrainfacies', parameterName: 'trmtrainfacies' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-facies-edit-view/trm-train-facies-edit-view.vue'),
                },
                {
                    path: 'trmtrainfacies/:trmtrainfacies?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainfacies.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunsheshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainfacies', parameterName: 'trmtrainfacies' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-facies-edit-view/trm-train-facies-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/jhfbgridview/:jhfbgridview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.jhfbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'jhfbgridview', parameterName: 'jhfbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-jhfbgrid-view/trm-train-plan-jhfbgrid-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/jhfbgridview/:jhfbgridview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.jhfbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'jhfbgridview', parameterName: 'jhfbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-jhfbgrid-view/trm-train-plan-jhfbgrid-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmstays/:trmstay?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmstay.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmstays', parameterName: 'trmstay' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-stay-grid-view/trm-stay-grid-view.vue'),
                },
                {
                    path: 'trmstays/:trmstay?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmstay.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmstays', parameterName: 'trmstay' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-stay-grid-view/trm-stay-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbfeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbfeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbfeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbfeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
                },
                {
                    path: 'trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbfeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
                },
                {
                    path: 'trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.tbfeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainagency.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-agency-pickup-grid-view/trm-train-agency-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/wbgridview/:wbgridview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.wbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'wbgridview', parameterName: 'wbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-wbgrid-view/trm-train-teacher-wbgrid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/wbgridview/:wbgridview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.wbgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'wbgridview', parameterName: 'wbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-wbgrid-view/trm-train-teacher-wbgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
                },
                {
                    path: 'trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
                },
                {
                    path: 'trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
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
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-pickup-view/trm-course-system-pickup-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-pickup-view/trm-course-system-pickup-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmstays/:trmstay?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmstay.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmstays', parameterName: 'trmstay' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-stay-edit-view/trm-stay-edit-view.vue'),
                },
                {
                    path: 'trmstays/:trmstay?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmstay.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmstays', parameterName: 'trmstay' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-stay-edit-view/trm-stay-edit-view.vue'),
                },
                {
                    path: 'trmplanformus/:trmplanformu?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmplanformu.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmplanformus', parameterName: 'trmplanformu' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-plan-formu-edit-view/trm-plan-formu-edit-view.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmdepart.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/bumenxuqiutianbao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-depart-edit-view/trm-depart-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.pxjggridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.pxjggridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.pxjggridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.pxjggridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.pxjggridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.pxjggridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
                },
                {
                    path: 'trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.pxjggridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmdepart.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-depart-pickup-grid-view/trm-depart-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmteachercharges/:trmteachercharge?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmteachercharges/:trmteachercharge?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
                },
                {
                    path: 'trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
                },
                {
                    path: 'trmteachercharges/:trmteachercharge?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachercharge.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainpeople/:trmtrainperson?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainperson.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainpeople', parameterName: 'trmtrainperson' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-person-edit-view/trm-train-person-edit-view.vue'),
                },
                {
                    path: 'trmtrainpeople/:trmtrainperson?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainperson.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainpeople', parameterName: 'trmtrainperson' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-person-edit-view/trm-train-person-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainagency.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjigou.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-agency-grid-view/trm-train-agency-grid-view.vue'),
                },
                {
                    path: 'trmtrainactapplies/:trmtrainactapply?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainactapply.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainactapplies', parameterName: 'trmtrainactapply' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-actapply-pickup-view/trm-train-actapply-pickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.ormorg.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-org-grid-view/orm-org-grid-view.vue'),
                },
                {
                    path: 'trmtrainactments/:trmtrainactment?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainactment.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunhuodongpinggu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainactments', parameterName: 'trmtrainactment' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-actment-grid-view/trm-train-actment-grid-view.vue'),
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
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunkecheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-edit-view/trm-train-course-edit-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunkecheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-edit-view/trm-train-course-edit-view.vue'),
                },
                {
                    path: 'trmtraincourses/:trmtraincourse?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunkecheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-edit-view/trm-train-course-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
                },
                {
                    path: 'trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainaddress.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-address-pickup-grid-view/trm-train-address-pickup-grid-view.vue'),
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
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-mpickup-view/trm-course-system-mpickup-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-mpickup-view/trm-course-system-mpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/feditview/:feditview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.feditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'feditview', parameterName: 'feditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-fedit-view/trm-train-plan-fedit-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/feditview/:feditview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.feditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'feditview', parameterName: 'feditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-fedit-view/trm-train-plan-fedit-view.vue'),
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
                    component: () => import('@pages/orm/orm-erporg-legal-mpickup-view/orm-erporg-legal-mpickup-view.vue'),
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
                    path: 'trmtrainagencies/:trmtrainagency?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainagency.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-agency-pickup-view/trm-train-agency-pickup-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.trmtrainaddress.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-address-mpickup-view/trm-train-address-mpickup-view.vue'),
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
                    path: 'trmtrainaddresses/:trmtrainaddress?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainaddress.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-address-edit-view/trm-train-address-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
                },
                {
                    path: 'trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
                },
                {
                    path: 'trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainbuapply.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
                },
                {
                    path: 'trmtrainoutapplies/:trmtrainoutapply?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainoutapply.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/waibupeixunshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainoutapplies', parameterName: 'trmtrainoutapply' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-out-apply-edit-view/trm-train-out-apply-edit-view.vue'),
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
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmtraffics/:trmtraffic?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtraffic.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmtraffics', parameterName: 'trmtraffic' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-traffic-grid-view/trm-traffic-grid-view.vue'),
                },
                {
                    path: 'trmtraffics/:trmtraffic?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtraffic.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtraffics', parameterName: 'trmtraffic' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-traffic-grid-view/trm-traffic-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-pickup-grid-view/trm-train-teacher-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-pickup-grid-view/trm-train-teacher-pickup-grid-view.vue'),
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
                    path: 'trmtrainagencies/:trmtrainagency?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.trmtrainagency.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-agency-edit-view9/trm-train-agency-edit-view9.vue'),
                },
                {
                    path: 'trmtrainoutapplies/:trmtrainoutapply?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainoutapply.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/waibupeixunshenqing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainoutapplies', parameterName: 'trmtrainoutapply' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-out-apply-grid-view/trm-train-out-apply-grid-view.vue'),
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
                    component: () => import('@pages/orm/orm-org-sjorg-pickup-grid-view/orm-org-sjorg-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-edit-view/trm-course-system-edit-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-edit-view/trm-course-system-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-grid-view/trm-course-system-grid-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-grid-view/trm-course-system-grid-view.vue'),
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
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-edit-view/trm-train-teacher-edit-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-edit-view/trm-train-teacher-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmteachertrains/:trmteachertrain?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachertrain.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-train-grid-view/trm-teacher-train-grid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmteachertrains/:trmteachertrain?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachertrain.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-train-grid-view/trm-teacher-train-grid-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmteachertrains/:trmteachertrain?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachertrain.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-train-grid-view/trm-teacher-train-grid-view.vue'),
                },
                {
                    path: 'trmteachertrains/:trmteachertrain?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmteachertrain.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-train-grid-view/trm-teacher-train-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
                },
                {
                    path: 'trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmdemdeftion.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmhmatsers/:trmhmatser?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmhmatser.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-hmatser-edit-view/trm-hmatser-edit-view.vue'),
                },
                {
                    path: 'trmhmatsers/:trmhmatser?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmhmatser.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-hmatser-edit-view/trm-hmatser-edit-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmtraffics/:trmtraffic?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtraffic.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmtraffics', parameterName: 'trmtraffic' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-traffic-edit-view/trm-traffic-edit-view.vue'),
                },
                {
                    path: 'trmtraffics/:trmtraffic?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtraffic.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtraffics', parameterName: 'trmtraffic' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-traffic-edit-view/trm-traffic-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
                },
                {
                    path: 'trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunkecheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-grid-view/trm-train-course-grid-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunkecheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-grid-view/trm-train-course-grid-view.vue'),
                },
                {
                    path: 'trmtraincourses/:trmtraincourse?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtraincourse.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunkecheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-course-grid-view/trm-train-course-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainagency.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjigou.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-agency-edit-view/trm-train-agency-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-edit-view9/trm-course-system-edit-view9.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-edit-view9/trm-course-system-edit-view9.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmdepart.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/bumenxuqiutianbao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-depart-grid-view/trm-depart-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmhmatsers/:trmhmatser?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmhmatser.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/peixunxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-hmatser-grid-view/trm-hmatser-grid-view.vue'),
                },
                {
                    path: 'trmhmatsers/:trmhmatser?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmhmatser.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/peixunxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-hmatser-grid-view/trm-hmatser-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/editview/:editview?',
                    meta: {
                        caption: 'entities.ormorg.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-org-edit-view/orm-org-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-grid-view/trm-train-teacher-grid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-grid-view/trm-train-teacher-grid-view.vue'),
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
                    component: () => import('@pages/orm/orm-erporg-legal-pickup-grid-view/orm-erporg-legal-pickup-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmhmatsers/:trmhmatser?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.trmhmatser.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-hmatser-mpickup-view/trm-hmatser-mpickup-view.vue'),
                },
                {
                    path: 'trmhmatsers/:trmhmatser?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.trmhmatser.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-hmatser-mpickup-view/trm-hmatser-mpickup-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainaddress.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-address-grid-view/trm-train-address-grid-view.vue'),
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
                    component: () => import('@pages/orm/orm-org-sjorg-pickup-view/orm-org-sjorg-pickup-view.vue'),
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
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcouarranges/:trmcouarrange?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmcouarranges/:trmcouarrange?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
                },
                {
                    path: 'trmcouarranges/:trmcouarrange?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
                },
                {
                    path: 'trmtrainfillins/:trmtrainfillin?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmtrainfillin.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-pickup-view/trm-train-teacher-pickup-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainteacher.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-teacher-pickup-view/trm-train-teacher-pickup-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmteachertrains/:trmteachertrain?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachertrain.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-train-edit-view/trm-teacher-train-edit-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmteachertrains/:trmteachertrain?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachertrain.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-train-edit-view/trm-teacher-train-edit-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmteachertrains/:trmteachertrain?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachertrain.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-train-edit-view/trm-teacher-train-edit-view.vue'),
                },
                {
                    path: 'trmteachertrains/:trmteachertrain?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmteachertrain.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-teacher-train-edit-view/trm-teacher-train-edit-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
                },
                {
                    path: 'trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmtrainplanterm.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
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
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-grid-view/trm-train-plan-grid-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-grid-view/trm-train-plan-grid-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmtrainfacies/:trmtrainfacies?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainfacies.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunsheshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmtrainfacies', parameterName: 'trmtrainfacies' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-facies-grid-view/trm-train-facies-grid-view.vue'),
                },
                {
                    path: 'trmtrainfacies/:trmtrainfacies?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmtrainfacies.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunsheshi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainfacies', parameterName: 'trmtrainfacies' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-facies-grid-view/trm-train-facies-grid-view.vue'),
                },
                {
                    path: 'trmdeparts/:trmdepart?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.trmdepart.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-depart-pickup-view/trm-depart-pickup-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
                },
                {
                    path: 'trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
                },
                {
                    path: 'trmtrainaddresses/:trmtrainaddress?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
                },
                {
                    path: 'trmcouarranges/:trmcouarrange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmcouarrange.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
                },
                {
                    path: 'trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-pickup-grid-view/trm-course-system-pickup-grid-view.vue'),
                },
                {
                    path: 'trmcoursesystems/:trmcoursesystem?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.trmcoursesystem.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-course-system-pickup-grid-view/trm-course-system-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/fgridview/:fgridview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.fgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'fgridview', parameterName: 'fgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-fgrid-view/trm-train-plan-fgrid-view.vue'),
                },
                {
                    path: 'trmtrainplans/:trmtrainplan?/fgridview/:fgridview?',
                    meta: {
                        caption: 'entities.trmtrainplan.views.fgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                            { pathName: 'fgridview', parameterName: 'fgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trm-train-plan-fgrid-view/trm-train-plan-fgrid-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/trmtrainactments/:trmtrainactment?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainactment.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunhuodongpinggu.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainactments', parameterName: 'trmtrainactment' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-actment-edit-view/trm-train-actment-edit-view.vue'),
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
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-pickup-view/trm-train-teacher-pickup-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-pickup-view/trm-train-teacher-pickup-view.vue'),
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
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/editview/:editview?',
        meta: {
            caption: 'entities.trmcouarrange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/editview/:editview?',
        meta: {
            caption: 'entities.trmcouarrange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/editview/:editview?',
        meta: {
            caption: 'entities.trmcouarrange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcouarranges/:trmcouarrange?/editview/:editview?',
        meta: {
            caption: 'entities.trmcouarrange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmcouarranges/:trmcouarrange?/editview/:editview?',
        meta: {
            caption: 'entities.trmcouarrange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/editview/:editview?',
        meta: {
            caption: 'entities.trmcouarrange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
    },
    {
        path: '/trmcouarranges/:trmcouarrange?/editview/:editview?',
        meta: {
            caption: 'entities.trmcouarrange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-edit-view/trm-couarrange-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainagency.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjigou.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-agency-edit-view/trm-train-agency-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
    },
    {
        path: '/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
    },
    {
        path: '/trmtrainbuapplies/:trmtrainbuapply?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-grid-view/trm-train-buapply-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtraincourse.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-pickup-grid-view/trm-train-course-pickup-grid-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtraincourse.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-pickup-grid-view/trm-train-course-pickup-grid-view.vue'),
    },
    {
        path: '/trmtraincourses/:trmtraincourse?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtraincourse.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-pickup-grid-view/trm-train-course-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainactapplies/:trmtrainactapply?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainactapply.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainactapplies', parameterName: 'trmtrainactapply' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-actapply-pickup-view/trm-train-actapply-pickup-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-grid-view/trm-course-system-grid-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-grid-view/trm-course-system-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbfeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbfeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbfeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbfeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
    },
    {
        path: '/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbfeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
    },
    {
        path: '/trmdemdeftions/:trmdemdeftion?/tbfeditview/:tbfeditview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbfeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbfeditview', parameterName: 'tbfeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbfedit-view/trm-demdeftion-tbfedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainpeople/:trmtrainperson?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainperson.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainpeople', parameterName: 'trmtrainperson' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-person-edit-view/trm-train-person-edit-view.vue'),
    },
    {
        path: '/trmtrainpeople/:trmtrainperson?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainperson.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainpeople', parameterName: 'trmtrainperson' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-person-edit-view/trm-train-person-edit-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmtraffics/:trmtraffic?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtraffic.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmtraffics', parameterName: 'trmtraffic' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-traffic-grid-view/trm-traffic-grid-view.vue'),
    },
    {
        path: '/trmtraffics/:trmtraffic?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtraffic.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtraffics', parameterName: 'trmtraffic' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-traffic-grid-view/trm-traffic-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/wbgridview/:wbgridview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.wbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'wbgridview', parameterName: 'wbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-wbgrid-view/trm-train-teacher-wbgrid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/wbgridview/:wbgridview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.wbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'wbgridview', parameterName: 'wbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-wbgrid-view/trm-train-teacher-wbgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/gridview/:gridview?',
        meta: {
            caption: 'entities.ormorg.views.gridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-org-grid-view/orm-org-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
    },
    {
        path: '/trmtrainplanterms/:trmtrainplanterm?/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
    },
    {
        path: '/trmtrainbuapplies/:trmtrainbuapply?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainbuapply.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunyusuanshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainbuapplies', parameterName: 'trmtrainbuapply' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-buapply-edit-view/trm-train-buapply-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-mpickup-view/trm-train-teacher-mpickup-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-mpickup-view/trm-train-teacher-mpickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
    },
    {
        path: '/trmtrainfillins/:trmtrainfillin?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-grid-view/trm-train-fillin-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-edit-view/trm-train-teacher-edit-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-edit-view/trm-train-teacher-edit-view.vue'),
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
        component: () => import('@pages/orm/orm-org-sjorg-pickup-view/orm-org-sjorg-pickup-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmstays/:trmstay?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmstay.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmstays', parameterName: 'trmstay' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-stay-grid-view/trm-stay-grid-view.vue'),
    },
    {
        path: '/trmstays/:trmstay?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmstay.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmstays', parameterName: 'trmstay' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-stay-grid-view/trm-stay-grid-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmstays/:trmstay?/editview/:editview?',
        meta: {
            caption: 'entities.trmstay.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmstays', parameterName: 'trmstay' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-stay-edit-view/trm-stay-edit-view.vue'),
    },
    {
        path: '/trmstays/:trmstay?/editview/:editview?',
        meta: {
            caption: 'entities.trmstay.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmstays', parameterName: 'trmstay' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-stay-edit-view/trm-stay-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
    },
    {
        path: '/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
    },
    {
        path: '/trmdemdeftions/:trmdemdeftion?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-view/trm-demdeftion-pickup-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/editview9/:editview9?',
        meta: {
            caption: 'entities.trmtraincourse.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-edit-view9/trm-train-course-edit-view9.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/editview9/:editview9?',
        meta: {
            caption: 'entities.trmtraincourse.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-edit-view9/trm-train-course-edit-view9.vue'),
    },
    {
        path: '/trmtraincourses/:trmtraincourse?/editview9/:editview9?',
        meta: {
            caption: 'entities.trmtraincourse.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-edit-view9/trm-train-course-edit-view9.vue'),
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
        path: '/trmtrainagencies/:trmtrainagency?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainagency.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-agency-pickup-grid-view/trm-train-agency-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
    },
    {
        path: '/trmcouarranges/:trmcouarrange?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-grid-view/trm-couarrange-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtraincourse.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunkecheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-grid-view/trm-train-course-grid-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtraincourse.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunkecheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-grid-view/trm-train-course-grid-view.vue'),
    },
    {
        path: '/trmtraincourses/:trmtraincourse?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtraincourse.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunkecheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-grid-view/trm-train-course-grid-view.vue'),
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
        component: () => import('@pages/orm/orm-erporg-legal-mpickup-view/orm-erporg-legal-mpickup-view.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmdepart.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-depart-pickup-view/trm-depart-pickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
    },
    {
        path: '/trmdemdeftions/:trmdemdeftion?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-pickup-grid-view/trm-demdeftion-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainplan.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-pickup-grid-view/trm-train-plan-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainplan.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-pickup-grid-view/trm-train-plan-pickup-grid-view.vue'),
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
        path: '/trmtrainactapplies/:trmtrainactapply?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainactapply.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainactapplies', parameterName: 'trmtrainactapply' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-actapply-pickup-grid-view/trm-train-actapply-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainaddress.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-address-pickup-view/trm-train-address-pickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbgridview', parameterName: 'tbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbgridview', parameterName: 'tbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbgridview', parameterName: 'tbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbgridview', parameterName: 'tbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
    },
    {
        path: '/trmtrainfillins/:trmtrainfillin?/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbgridview', parameterName: 'tbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
    },
    {
        path: '/trmdemdeftions/:trmdemdeftion?/tbgridview/:tbgridview?',
        meta: {
            caption: 'entities.trmdemdeftion.views.tbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/xuqiudiaochadingyi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmdemdeftions', parameterName: 'trmdemdeftion' },
                { pathName: 'tbgridview', parameterName: 'tbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-demdeftion-tbgrid-view/trm-demdeftion-tbgrid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/editview/:editview?',
        meta: {
            caption: 'entities.trmtraincourse.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunkecheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-edit-view/trm-train-course-edit-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/editview/:editview?',
        meta: {
            caption: 'entities.trmtraincourse.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunkecheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-edit-view/trm-train-course-edit-view.vue'),
    },
    {
        path: '/trmtraincourses/:trmtraincourse?/editview/:editview?',
        meta: {
            caption: 'entities.trmtraincourse.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunkecheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-edit-view/trm-train-course-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmhmatsers/:trmhmatser?/editview/:editview?',
        meta: {
            caption: 'entities.trmhmatser.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-hmatser-edit-view/trm-hmatser-edit-view.vue'),
    },
    {
        path: '/trmhmatsers/:trmhmatser?/editview/:editview?',
        meta: {
            caption: 'entities.trmhmatser.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-hmatser-edit-view/trm-hmatser-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-pickup-grid-view/trm-course-system-pickup-grid-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-pickup-grid-view/trm-course-system-pickup-grid-view.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmdepart.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-depart-pickup-grid-view/trm-depart-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtraincourse.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-pickup-view/trm-train-course-pickup-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/trmtraincourses/:trmtraincourse?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtraincourse.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-pickup-view/trm-train-course-pickup-view.vue'),
    },
    {
        path: '/trmtraincourses/:trmtraincourse?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtraincourse.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtraincourses', parameterName: 'trmtraincourse' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-course-pickup-view/trm-train-course-pickup-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmtraffics/:trmtraffic?/editview/:editview?',
        meta: {
            caption: 'entities.trmtraffic.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmtraffics', parameterName: 'trmtraffic' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-traffic-edit-view/trm-traffic-edit-view.vue'),
    },
    {
        path: '/trmtraffics/:trmtraffic?/editview/:editview?',
        meta: {
            caption: 'entities.trmtraffic.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtraffics', parameterName: 'trmtraffic' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-traffic-edit-view/trm-traffic-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.pxjggridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.pxjggridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.pxjggridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.pxjggridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.pxjggridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.pxjggridview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
    },
    {
        path: '/trmcouarranges/:trmcouarrange?/pxjggridview/:pxjggridview?',
        meta: {
            caption: 'entities.trmcouarrange.views.pxjggridview.title',
            info:'',
            parameters: [
                { pathName: 'trmcouarranges', parameterName: 'trmcouarrange' },
                { pathName: 'pxjggridview', parameterName: 'pxjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-couarrange-pxjggrid-view/trm-couarrange-pxjggrid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/editview9/:editview9?',
        meta: {
            caption: 'entities.trmtrainagency.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-agency-edit-view9/trm-train-agency-edit-view9.vue'),
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
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/feditview/:feditview?',
        meta: {
            caption: 'entities.trmtrainplan.views.feditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'feditview', parameterName: 'feditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-fedit-view/trm-train-plan-fedit-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/feditview/:feditview?',
        meta: {
            caption: 'entities.trmtrainplan.views.feditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'feditview', parameterName: 'feditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-fedit-view/trm-train-plan-fedit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmteachertrains/:trmteachertrain?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachertrain.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-train-edit-view/trm-teacher-train-edit-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmteachertrains/:trmteachertrain?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachertrain.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-train-edit-view/trm-teacher-train-edit-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmteachertrains/:trmteachertrain?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachertrain.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-train-edit-view/trm-teacher-train-edit-view.vue'),
    },
    {
        path: '/trmteachertrains/:trmteachertrain?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachertrain.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-train-edit-view/trm-teacher-train-edit-view.vue'),
    },
    {
        path: '/trmtrainoutapplies/:trmtrainoutapply?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainoutapply.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/waibupeixunshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainoutapplies', parameterName: 'trmtrainoutapply' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-out-apply-edit-view/trm-train-out-apply-edit-view.vue'),
    },
    {
        path: '/trmplanformus/:trmplanformu?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmplanformu.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmplanformus', parameterName: 'trmplanformu' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-plan-formu-grid-view/trm-plan-formu-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/fgridview/:fgridview?',
        meta: {
            caption: 'entities.trmtrainplan.views.fgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'fgridview', parameterName: 'fgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-fgrid-view/trm-train-plan-fgrid-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/fgridview/:fgridview?',
        meta: {
            caption: 'entities.trmtrainplan.views.fgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'fgridview', parameterName: 'fgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-fgrid-view/trm-train-plan-fgrid-view.vue'),
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
        component: () => import('@pages/orm/orm-org-edit-view/orm-org-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmhmatsers/:trmhmatser?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmhmatser.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-hmatser-pickup-grid-view/trm-hmatser-pickup-grid-view.vue'),
    },
    {
        path: '/trmhmatsers/:trmhmatser?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmhmatser.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-hmatser-pickup-grid-view/trm-hmatser-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/editview9/:editview9?',
        meta: {
            caption: 'entities.trmcoursesystem.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-edit-view9/trm-course-system-edit-view9.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/editview9/:editview9?',
        meta: {
            caption: 'entities.trmcoursesystem.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-edit-view9/trm-course-system-edit-view9.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/editview/:editview?',
        meta: {
            caption: 'entities.trmdepart.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/bumenxuqiutianbao.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-depart-edit-view/trm-depart-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/wbeditview/:wbeditview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.wbeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'wbeditview', parameterName: 'wbeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-wbedit-view/trm-train-teacher-wbedit-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/wbeditview/:wbeditview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.wbeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'wbeditview', parameterName: 'wbeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-wbedit-view/trm-train-teacher-wbedit-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainaddress.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-address-grid-view/trm-train-address-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachercharge.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachercharge.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmteachercharges/:trmteachercharge?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachercharge.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachercharge.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachercharge.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmteachercharges/:trmteachercharge?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachercharge.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
    },
    {
        path: '/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachercharge.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
    },
    {
        path: '/trmteachercharges/:trmteachercharge?/editview/:editview?',
        meta: {
            caption: 'entities.trmteachercharge.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-edit-view/trm-teacher-charge-edit-view.vue'),
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
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainplan.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-grid-view/trm-train-plan-grid-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainplan.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-grid-view/trm-train-plan-grid-view.vue'),
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
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainplan.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-pickup-view/trm-train-plan-pickup-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainplan.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-pickup-view/trm-train-plan-pickup-view.vue'),
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
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/editview/:editview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-edit-view/trm-course-system-edit-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/editview/:editview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-edit-view/trm-course-system-edit-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.trmtrainaddress.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-address-mpickup-view/trm-train-address-mpickup-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmtrainfacies/:trmtrainfacies?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainfacies.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunsheshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmtrainfacies', parameterName: 'trmtrainfacies' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-facies-grid-view/trm-train-facies-grid-view.vue'),
    },
    {
        path: '/trmtrainfacies/:trmtrainfacies?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainfacies.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunsheshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainfacies', parameterName: 'trmtrainfacies' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-facies-grid-view/trm-train-facies-grid-view.vue'),
    },
    {
        path: '/trmtrainactments/:trmtrainactment?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainactment.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunhuodongpinggu.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainactments', parameterName: 'trmtrainactment' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-actment-grid-view/trm-train-actment-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachercharge.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachercharge.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachercharge.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachercharge.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachercharge.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachercharge.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
    },
    {
        path: '/trmtrainplanterms/:trmtrainplanterm?/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachercharge.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
    },
    {
        path: '/trmteachercharges/:trmteachercharge?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachercharge.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmteachercharges', parameterName: 'trmteachercharge' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-charge-grid-view/trm-teacher-charge-grid-view.vue'),
    },
    {
        path: '/trmplanformus/:trmplanformu?/editview/:editview?',
        meta: {
            caption: 'entities.trmplanformu.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmplanformus', parameterName: 'trmplanformu' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-plan-formu-edit-view/trm-plan-formu-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
    },
    {
        path: '/trmtrainplanterms/:trmtrainplanterm?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-edit-view/trm-train-planterm-edit-view.vue'),
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
        component: () => import('@pages/orm/orm-org-sjorg-pickup-grid-view/orm-org-sjorg-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-pickup-grid-view/trm-train-teacher-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-pickup-grid-view/trm-train-teacher-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainplan.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-edit-view/trm-train-plan-edit-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainplan.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-edit-view/trm-train-plan-edit-view.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmdepart.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/bumenxuqiutianbao.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-depart-grid-view/trm-depart-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmhmatsers/:trmhmatser?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmhmatser.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/peixunxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-hmatser-grid-view/trm-hmatser-grid-view.vue'),
    },
    {
        path: '/trmhmatsers/:trmhmatser?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmhmatser.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/peixunxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-hmatser-grid-view/trm-hmatser-grid-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmtrainfacies/:trmtrainfacies?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainfacies.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunsheshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmtrainfacies', parameterName: 'trmtrainfacies' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-facies-edit-view/trm-train-facies-edit-view.vue'),
    },
    {
        path: '/trmtrainfacies/:trmtrainfacies?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainfacies.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunsheshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainfacies', parameterName: 'trmtrainfacies' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-facies-edit-view/trm-train-facies-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainagency.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjigou.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-agency-grid-view/trm-train-agency-grid-view.vue'),
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
        path: '/trmtrainagencies/:trmtrainagency?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainagency.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-agency-pickup-view/trm-train-agency-pickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainpeople/:trmtrainperson?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainperson.views.gridview.title',
            info:'',
            imgPath: '../../../img/kfgl/1/peixunjiluguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainpeople', parameterName: 'trmtrainperson' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-person-grid-view/trm-train-person-grid-view.vue'),
    },
    {
        path: '/trmtrainpeople/:trmtrainperson?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainperson.views.gridview.title',
            info:'',
            imgPath: '../../../img/kfgl/1/peixunjiluguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainpeople', parameterName: 'trmtrainperson' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-person-grid-view/trm-train-person-grid-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainaddress.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-address-pickup-grid-view/trm-train-address-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-grid-view/trm-train-teacher-grid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainteacher.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/peixunjiaoshi.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-teacher-grid-view/trm-train-teacher-grid-view.vue'),
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
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-mpickup-view/trm-course-system-mpickup-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-mpickup-view/trm-course-system-mpickup-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmhmatsers/:trmhmatser?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.trmhmatser.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-hmatser-mpickup-view/trm-hmatser-mpickup-view.vue'),
    },
    {
        path: '/trmhmatsers/:trmhmatser?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.trmhmatser.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmhmatsers', parameterName: 'trmhmatser' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-hmatser-mpickup-view/trm-hmatser-mpickup-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
    },
    {
        path: '/trmtrainplanterms/:trmtrainplanterm?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-grid-view/trm-train-planterm-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmteachertrains/:trmteachertrain?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachertrain.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-train-grid-view/trm-teacher-train-grid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmteachertrains/:trmteachertrain?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachertrain.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-train-grid-view/trm-teacher-train-grid-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/trmteachertrains/:trmteachertrain?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachertrain.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-train-grid-view/trm-teacher-train-grid-view.vue'),
    },
    {
        path: '/trmteachertrains/:trmteachertrain?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmteachertrain.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'trmteachertrains', parameterName: 'trmteachertrain' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-teacher-train-grid-view/trm-teacher-train-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/tabexpview/:tabexpview?',
        meta: {
            caption: 'entities.trmtrainagency.views.tabexpview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'tabexpview', parameterName: 'tabexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-agency-tab-exp-view/trm-train-agency-tab-exp-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainplanterms/:trmtrainplanterm?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-grid-view/trm-train-planterm-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/jhfbgridview/:jhfbgridview?',
        meta: {
            caption: 'entities.trmtrainplan.views.jhfbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'jhfbgridview', parameterName: 'jhfbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-jhfbgrid-view/trm-train-plan-jhfbgrid-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/jhfbgridview/:jhfbgridview?',
        meta: {
            caption: 'entities.trmtrainplan.views.jhfbgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/gongsipenxunjihuazhiding.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'jhfbgridview', parameterName: 'jhfbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-plan-jhfbgrid-view/trm-train-plan-jhfbgrid-view.vue'),
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
        component: () => import('@pages/orm/orm-erporg-legal-pickup-grid-view/orm-erporg-legal-pickup-grid-view.vue'),
    },
    {
        path: '/trmtrainoutapplies/:trmtrainoutapply?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmtrainoutapply.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/waibupeixunshenqing.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmtrainoutapplies', parameterName: 'trmtrainoutapply' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-out-apply-grid-view/trm-train-out-apply-grid-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmcoursesystems/:trmcoursesystem?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-pickup-view/trm-course-system-pickup-view.vue'),
    },
    {
        path: '/trmcoursesystems/:trmcoursesystem?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmcoursesystem.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmcoursesystems', parameterName: 'trmcoursesystem' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-course-system-pickup-view/trm-course-system-pickup-view.vue'),
    },
    {
        path: '/trmtrainaddresses/:trmtrainaddress?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainaddress.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainaddresses', parameterName: 'trmtrainaddress' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-address-edit-view/trm-train-address-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.bjgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'bjgridview', parameterName: 'bjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.bjgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'bjgridview', parameterName: 'bjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.bjgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'bjgridview', parameterName: 'bjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.bjgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'bjgridview', parameterName: 'bjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
    },
    {
        path: '/trmtrainplanterms/:trmtrainplanterm?/bjgridview/:bjgridview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.bjgridview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'bjgridview', parameterName: 'bjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-bjgrid-view/trm-train-planterm-bjgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
    },
    {
        path: '/trmdeparts/:trmdepart?/trmtrainfillins/:trmtrainfillin?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmdeparts', parameterName: 'trmdepart' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/trmtrainfillins/:trmtrainfillin?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/trmtrainfillins/:trmtrainfillin?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
    },
    {
        path: '/trmtrainfillins/:trmtrainfillin?/editview/:editview?',
        meta: {
            caption: 'entities.trmtrainfillin.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainfillins', parameterName: 'trmtrainfillin' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-fillin-edit-view/trm-train-fillin-edit-view.vue'),
    },
    {
        path: '/trmtrainagencies/:trmtrainagency?/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainagencies', parameterName: 'trmtrainagency' },
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
    },
    {
        path: '/trmtrainteachers/:trmtrainteacher?/trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainteachers', parameterName: 'trmtrainteacher' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
    },
    {
        path: '/trmtrainplans/:trmtrainplan?/trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplans', parameterName: 'trmtrainplan' },
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
    },
    {
        path: '/trmtrainplanterms/:trmtrainplanterm?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.trmtrainplanterm.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'trmtrainplanterms', parameterName: 'trmtrainplanterm' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trm-train-planterm-pickup-view/trm-train-planterm-pickup-view.vue'),
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
