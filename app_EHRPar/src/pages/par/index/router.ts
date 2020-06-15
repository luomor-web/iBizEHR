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
            component: () => import('@pages/par/index/index.vue'),
            children: [
                {
                    path: 'parldndlhmbs/:parldndlhmb?/kheditview/:kheditview?',
                    meta: {
                        caption: 'entities.parldndlhmb.views.kheditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'kheditview', parameterName: 'kheditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmb-khedit-view/par-ldndlhmb-khedit-view.vue'),
                },
                {
                    path: 'parintegralrules/:parintegralrule?/editview/:editview?',
                    meta: {
                        caption: 'entities.parintegralrule.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parintegralrules', parameterName: 'parintegralrule' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-integral-rule-edit-view/par-integral-rule-edit-view.vue'),
                },
                {
                    path: 'parassesstemplates/:parassesstemplate?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.parassesstemplate.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-assess-template-pickup-view/par-assess-template-pickup-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/kheditview/:kheditview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.kheditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'kheditview', parameterName: 'kheditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-khedit-view/par-ldndlhmbmx-khedit-view.vue'),
                },
                {
                    path: 'parldndlhmbmxes/:parldndlhmbmx?/kheditview/:kheditview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.kheditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'kheditview', parameterName: 'kheditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-khedit-view/par-ldndlhmbmx-khedit-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/xzgridview/:xzgridview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.xzgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'xzgridview', parameterName: 'xzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-xzgrid-view/par-ldndlhmbmx-xzgrid-view.vue'),
                },
                {
                    path: 'parldndlhmbmxes/:parldndlhmbmx?/xzgridview/:xzgridview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.xzgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'xzgridview', parameterName: 'xzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-xzgrid-view/par-ldndlhmbmx-xzgrid-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/editview/:editview?',
                    meta: {
                        caption: 'entities.parldndlhmb.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmb-edit-view/par-ldndlhmb-edit-view.vue'),
                },
                {
                    path: 'parkhfas/:parkhfa?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parkhfa.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoheleixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parkhfas', parameterName: 'parkhfa' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-khfa-grid-view/par-khfa-grid-view.vue'),
                },
                {
                    path: 'parassesstemplates/:parassesstemplate?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.parassesstemplate.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-assess-template-pickup-grid-view/par-assess-template-pickup-grid-view.vue'),
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
                    path: 'parassesstemplates/:parassesstemplate?/parjxkhxhzs/:parjxkhxhz?/editview/:editview?',
                    meta: {
                        caption: 'entities.parjxkhxhz.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                            { pathName: 'parjxkhxhzs', parameterName: 'parjxkhxhz' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-jxkhxhz-edit-view/par-jxkhxhz-edit-view.vue'),
                },
                {
                    path: 'parjxkhxhzs/:parjxkhxhz?/editview/:editview?',
                    meta: {
                        caption: 'entities.parjxkhxhz.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parjxkhxhzs', parameterName: 'parjxkhxhz' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-jxkhxhz-edit-view/par-jxkhxhz-edit-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/ndlhmbxzgridview/:ndlhmbxzgridview?',
                    meta: {
                        caption: 'entities.parldndlhmb.views.ndlhmbxzgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'ndlhmbxzgridview', parameterName: 'ndlhmbxzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmb-ndlhmbxzgrid-view/par-ldndlhmb-ndlhmbxzgrid-view.vue'),
                },
                {
                    path: 'partzggs/:partzgg?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.partzgg.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'partzggs', parameterName: 'partzgg' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-tzgg-edit-view9/par-tzgg-edit-view9.vue'),
                },
                {
                    path: 'parjxjgs/:parjxjg?/khdjeditview/:khdjeditview?',
                    meta: {
                        caption: 'entities.parjxjg.views.khdjeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/jixiaojieguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parjxjgs', parameterName: 'parjxjg' },
                            { pathName: 'khdjeditview', parameterName: 'khdjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-jxjg-khdjedit-view/par-jxjg-khdjedit-view.vue'),
                },
                {
                    path: 'parexamcycles/:parexamcycle?/newgridview/:newgridview?',
                    meta: {
                        caption: 'entities.parexamcycle.views.newgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                            { pathName: 'newgridview', parameterName: 'newgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-exam-cycle-new-grid-view/par-exam-cycle-new-grid-view.vue'),
                },
                {
                    path: 'parintegralrules/:parintegralrule?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.parintegralrule.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parintegralrules', parameterName: 'parintegralrule' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-integral-rule-edit-view9/par-integral-rule-edit-view9.vue'),
                },
                {
                    path: 'parexamcycles/:parexamcycle?/editview/:editview?',
                    meta: {
                        caption: 'entities.parexamcycle.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-exam-cycle-edit-view/par-exam-cycle-edit-view.vue'),
                },
                {
                    path: 'parkhfas/:parkhfa?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.parkhfa.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parkhfas', parameterName: 'parkhfa' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-khfa-edit-view9/par-khfa-edit-view9.vue'),
                },
                {
                    path: 'partzggs/:partzgg?/editview/:editview?',
                    meta: {
                        caption: 'entities.partzgg.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'partzggs', parameterName: 'partzgg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-tzgg-edit-view/par-tzgg-edit-view.vue'),
                },
                {
                    path: 'parldkhqzs/:parldkhqz?/newgridview/:newgridview?',
                    meta: {
                        caption: 'entities.parldkhqz.views.newgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldkhqzs', parameterName: 'parldkhqz' },
                            { pathName: 'newgridview', parameterName: 'newgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldkhqz-new-grid-view/par-ldkhqz-new-grid-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-grid-view/par-ldndlhmbmx-grid-view.vue'),
                },
                {
                    path: 'parldndlhmbmxes/:parldndlhmbmx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-grid-view/par-ldndlhmbmx-grid-view.vue'),
                },
                {
                    path: 'parassesstemplates/:parassesstemplate?/parjxkhxhzs/:parjxkhxhz?/ygkhxgridview/:ygkhxgridview?',
                    meta: {
                        caption: 'entities.parjxkhxhz.views.ygkhxgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/yuangongkaohefenleiyilanbiao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                            { pathName: 'parjxkhxhzs', parameterName: 'parjxkhxhz' },
                            { pathName: 'ygkhxgridview', parameterName: 'ygkhxgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-jxkhxhz-ygkhxgrid-view/par-jxkhxhz-ygkhxgrid-view.vue'),
                },
                {
                    path: 'parjxkhxhzs/:parjxkhxhz?/ygkhxgridview/:ygkhxgridview?',
                    meta: {
                        caption: 'entities.parjxkhxhz.views.ygkhxgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/yuangongkaohefenleiyilanbiao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parjxkhxhzs', parameterName: 'parjxkhxhz' },
                            { pathName: 'ygkhxgridview', parameterName: 'ygkhxgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-jxkhxhz-ygkhxgrid-view/par-jxkhxhz-ygkhxgrid-view.vue'),
                },
                {
                    path: 'parjxkhjcszs/:parjxkhjcsz?/parkhzcmxes/:parkhzcmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.parkhzcmx.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parjxkhjcszs', parameterName: 'parjxkhjcsz' },
                            { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-khzcmx-edit-view/par-khzcmx-edit-view.vue'),
                },
                {
                    path: 'parassesstemplates/:parassesstemplate?/parkhzcmxes/:parkhzcmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.parkhzcmx.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                            { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-khzcmx-edit-view/par-khzcmx-edit-view.vue'),
                },
                {
                    path: 'parkhzcmxes/:parkhzcmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.parkhzcmx.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-khzcmx-edit-view/par-khzcmx-edit-view.vue'),
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
                    path: 'parassesstemplates/:parassesstemplate?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.parassesstemplate.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-assess-template-edit-view9/par-assess-template-edit-view9.vue'),
                },
                {
                    path: 'parexamcontents/:parexamcontent?/editview/:editview?',
                    meta: {
                        caption: 'entities.parexamcontent.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parexamcontents', parameterName: 'parexamcontent' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-exam-content-edit-view/par-exam-content-edit-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/ndlhmbxzeditview/:ndlhmbxzeditview?',
                    meta: {
                        caption: 'entities.parldndlhmb.views.ndlhmbxzeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'ndlhmbxzeditview', parameterName: 'ndlhmbxzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmb-ndlhmbxzedit-view/par-ldndlhmb-ndlhmbxzedit-view.vue'),
                },
                {
                    path: 'parassesstemplates/:parassesstemplate?/editview/:editview?',
                    meta: {
                        caption: 'entities.parassesstemplate.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-assess-template-edit-view/par-assess-template-edit-view.vue'),
                },
                {
                    path: 'parintegralrules/:parintegralrule?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parintegralrule.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parintegralrules', parameterName: 'parintegralrule' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-integral-rule-grid-view/par-integral-rule-grid-view.vue'),
                },
                {
                    path: 'parexamcontents/:parexamcontent?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.parexamcontent.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parexamcontents', parameterName: 'parexamcontent' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-exam-content-edit-view9/par-exam-content-edit-view9.vue'),
                },
                {
                    path: 'parexamcontents/:parexamcontent?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parexamcontent.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parexamcontents', parameterName: 'parexamcontent' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-exam-content-grid-view/par-exam-content-grid-view.vue'),
                },
                {
                    path: 'parldkhqzs/:parldkhqz?/editview/:editview?',
                    meta: {
                        caption: 'entities.parldkhqz.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldkhqzs', parameterName: 'parldkhqz' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldkhqz-edit-view/par-ldkhqz-edit-view.vue'),
                },
                {
                    path: 'parjxkhjcszs/:parjxkhjcsz?/parkhzcmxes/:parkhzcmx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parkhzcmx.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parjxkhjcszs', parameterName: 'parjxkhjcsz' },
                            { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-khzcmx-grid-view/par-khzcmx-grid-view.vue'),
                },
                {
                    path: 'parassesstemplates/:parassesstemplate?/parkhzcmxes/:parkhzcmx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parkhzcmx.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                            { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-khzcmx-grid-view/par-khzcmx-grid-view.vue'),
                },
                {
                    path: 'parkhzcmxes/:parkhzcmx?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parkhzcmx.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-khzcmx-grid-view/par-khzcmx-grid-view.vue'),
                },
                {
                    path: 'parjxjgs/:parjxjg?/jxpgdjgridview/:jxpgdjgridview?',
                    meta: {
                        caption: 'entities.parjxjg.views.jxpgdjgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parjxjgs', parameterName: 'parjxjg' },
                            { pathName: 'jxpgdjgridview', parameterName: 'jxpgdjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-jxjg-jxpgdjgrid-view/par-jxjg-jxpgdjgrid-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/khgridview/:khgridview?',
                    meta: {
                        caption: 'entities.parldndlhmb.views.khgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'khgridview', parameterName: 'khgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmb-khgrid-view/par-ldndlhmb-khgrid-view.vue'),
                },
                {
                    path: 'partzggs/:partzgg?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.partzgg.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'partzggs', parameterName: 'partzgg' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-tzgg-grid-view/par-tzgg-grid-view.vue'),
                },
                {
                    path: 'parjxjgs/:parjxjg?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parjxjg.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/jixiaojieguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parjxjgs', parameterName: 'parjxjg' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-jxjg-grid-view/par-jxjg-grid-view.vue'),
                },
                {
                    path: 'parkhfas/:parkhfa?/editview/:editview?',
                    meta: {
                        caption: 'entities.parkhfa.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoheleixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parkhfas', parameterName: 'parkhfa' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-khfa-edit-view/par-khfa-edit-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/khgridview/:khgridview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.khgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'khgridview', parameterName: 'khgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-khgrid-view/par-ldndlhmbmx-khgrid-view.vue'),
                },
                {
                    path: 'parldndlhmbmxes/:parldndlhmbmx?/khgridview/:khgridview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.khgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'khgridview', parameterName: 'khgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-khgrid-view/par-ldndlhmbmx-khgrid-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parldndlhmb.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmb-grid-view/par-ldndlhmb-grid-view.vue'),
                },
                {
                    path: 'parjxjgs/:parjxjg?/editview/:editview?',
                    meta: {
                        caption: 'entities.parjxjg.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/jixiaojieguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parjxjgs', parameterName: 'parjxjg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-jxjg-edit-view/par-jxjg-edit-view.vue'),
                },
                {
                    path: 'parassesstemplates/:parassesstemplate?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.parassesstemplate.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-assess-template-grid-view/par-assess-template-grid-view.vue'),
                },
                {
                    path: 'parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-edit-view/par-ldndlhmbmx-edit-view.vue'),
                },
                {
                    path: 'parldndlhmbmxes/:parldndlhmbmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.parldndlhmbmx.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/par/par-ldndlhmbmx-edit-view/par-ldndlhmbmx-edit-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/partzggs/:partzgg?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.partzgg.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'partzggs', parameterName: 'partzgg' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-tzgg-pickup-grid-view/par-tzgg-pickup-grid-view.vue'),
    },
    {
        path: '/parintegralrules/:parintegralrule?/editview/:editview?',
        meta: {
            caption: 'entities.parintegralrule.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parintegralrules', parameterName: 'parintegralrule' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-integral-rule-edit-view/par-integral-rule-edit-view.vue'),
    },
    {
        path: '/parexamcycles/:parexamcycle?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.parexamcycle.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-cycle-pickup-view/par-exam-cycle-pickup-view.vue'),
    },
    {
        path: '/parjxjgs/:parjxjg?/editview/:editview?',
        meta: {
            caption: 'entities.parjxjg.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/jixiaojieguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'parjxjgs', parameterName: 'parjxjg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-jxjg-edit-view/par-jxjg-edit-view.vue'),
    },
    {
        path: '/parjxjgs/:parjxjg?/jxpgdjgridview/:jxpgdjgridview?',
        meta: {
            caption: 'entities.parjxjg.views.jxpgdjgridview.title',
            info:'',
            parameters: [
                { pathName: 'parjxjgs', parameterName: 'parjxjg' },
                { pathName: 'jxpgdjgridview', parameterName: 'jxpgdjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-jxjg-jxpgdjgrid-view/par-jxjg-jxpgdjgrid-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/editview/:editview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-edit-view/par-ldndlhmbmx-edit-view.vue'),
    },
    {
        path: '/parldndlhmbmxes/:parldndlhmbmx?/editview/:editview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-edit-view/par-ldndlhmbmx-edit-view.vue'),
    },
    {
        path: '/parintegralrules/:parintegralrule?/gridview/:gridview?',
        meta: {
            caption: 'entities.parintegralrule.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parintegralrules', parameterName: 'parintegralrule' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-integral-rule-grid-view/par-integral-rule-grid-view.vue'),
    },
    {
        path: '/parexamcycles/:parexamcycle?/gridview/:gridview?',
        meta: {
            caption: 'entities.parexamcycle.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-cycle-grid-view/par-exam-cycle-grid-view.vue'),
    },
    {
        path: '/parkhfas/:parkhfa?/gridview/:gridview?',
        meta: {
            caption: 'entities.parkhfa.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoheleixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'parkhfas', parameterName: 'parkhfa' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-khfa-grid-view/par-khfa-grid-view.vue'),
    },
    {
        path: '/parassesstemplates/:parassesstemplate?/editview/:editview?',
        meta: {
            caption: 'entities.parassesstemplate.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-assess-template-edit-view/par-assess-template-edit-view.vue'),
    },
    {
        path: '/parassesstemplates/:parassesstemplate?/parjxkhxhzs/:parjxkhxhz?/ygkhxgridview/:ygkhxgridview?',
        meta: {
            caption: 'entities.parjxkhxhz.views.ygkhxgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/yuangongkaohefenleiyilanbiao.png',
            iconCls: '',
            parameters: [
                { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                { pathName: 'parjxkhxhzs', parameterName: 'parjxkhxhz' },
                { pathName: 'ygkhxgridview', parameterName: 'ygkhxgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-jxkhxhz-ygkhxgrid-view/par-jxkhxhz-ygkhxgrid-view.vue'),
    },
    {
        path: '/parjxkhxhzs/:parjxkhxhz?/ygkhxgridview/:ygkhxgridview?',
        meta: {
            caption: 'entities.parjxkhxhz.views.ygkhxgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/yuangongkaohefenleiyilanbiao.png',
            iconCls: '',
            parameters: [
                { pathName: 'parjxkhxhzs', parameterName: 'parjxkhxhz' },
                { pathName: 'ygkhxgridview', parameterName: 'ygkhxgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-jxkhxhz-ygkhxgrid-view/par-jxkhxhz-ygkhxgrid-view.vue'),
    },
    {
        path: '/parkhfas/:parkhfa?/editview9/:editview9?',
        meta: {
            caption: 'entities.parkhfa.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'parkhfas', parameterName: 'parkhfa' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-khfa-edit-view9/par-khfa-edit-view9.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/kheditview/:kheditview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.kheditview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'kheditview', parameterName: 'kheditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-khedit-view/par-ldndlhmbmx-khedit-view.vue'),
    },
    {
        path: '/parldndlhmbmxes/:parldndlhmbmx?/kheditview/:kheditview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.kheditview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'kheditview', parameterName: 'kheditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-khedit-view/par-ldndlhmbmx-khedit-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/ndlhmbxzgridview/:ndlhmbxzgridview?',
        meta: {
            caption: 'entities.parldndlhmb.views.ndlhmbxzgridview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'ndlhmbxzgridview', parameterName: 'ndlhmbxzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmb-ndlhmbxzgrid-view/par-ldndlhmb-ndlhmbxzgrid-view.vue'),
    },
    {
        path: '/parexamcycles/:parexamcycle?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.parexamcycle.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-cycle-pickup-grid-view/par-exam-cycle-pickup-grid-view.vue'),
    },
    {
        path: '/partzggs/:partzgg?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.partzgg.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'partzggs', parameterName: 'partzgg' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-tzgg-mpickup-view/par-tzgg-mpickup-view.vue'),
    },
    {
        path: '/partzggs/:partzgg?/gridview/:gridview?',
        meta: {
            caption: 'entities.partzgg.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'partzggs', parameterName: 'partzgg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-tzgg-grid-view/par-tzgg-grid-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/khgridview/:khgridview?',
        meta: {
            caption: 'entities.parldndlhmb.views.khgridview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'khgridview', parameterName: 'khgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmb-khgrid-view/par-ldndlhmb-khgrid-view.vue'),
    },
    {
        path: '/parintegralrules/:parintegralrule?/editview9/:editview9?',
        meta: {
            caption: 'entities.parintegralrule.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'parintegralrules', parameterName: 'parintegralrule' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-integral-rule-edit-view9/par-integral-rule-edit-view9.vue'),
    },
    {
        path: '/parjxkhjcszs/:parjxkhjcsz?/parkhzcmxes/:parkhzcmx?/gridview/:gridview?',
        meta: {
            caption: 'entities.parkhzcmx.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parjxkhjcszs', parameterName: 'parjxkhjcsz' },
                { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-khzcmx-grid-view/par-khzcmx-grid-view.vue'),
    },
    {
        path: '/parassesstemplates/:parassesstemplate?/parkhzcmxes/:parkhzcmx?/gridview/:gridview?',
        meta: {
            caption: 'entities.parkhzcmx.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-khzcmx-grid-view/par-khzcmx-grid-view.vue'),
    },
    {
        path: '/parkhzcmxes/:parkhzcmx?/gridview/:gridview?',
        meta: {
            caption: 'entities.parkhzcmx.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-khzcmx-grid-view/par-khzcmx-grid-view.vue'),
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
        path: '/parldkhqzs/:parldkhqz?/editview/:editview?',
        meta: {
            caption: 'entities.parldkhqz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parldkhqzs', parameterName: 'parldkhqz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldkhqz-edit-view/par-ldkhqz-edit-view.vue'),
    },
    {
        path: '/parassesstemplates/:parassesstemplate?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.parassesstemplate.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-assess-template-pickup-view/par-assess-template-pickup-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/gridview/:gridview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-grid-view/par-ldndlhmbmx-grid-view.vue'),
    },
    {
        path: '/parldndlhmbmxes/:parldndlhmbmx?/gridview/:gridview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-grid-view/par-ldndlhmbmx-grid-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/khgridview/:khgridview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.khgridview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'khgridview', parameterName: 'khgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-khgrid-view/par-ldndlhmbmx-khgrid-view.vue'),
    },
    {
        path: '/parldndlhmbmxes/:parldndlhmbmx?/khgridview/:khgridview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.khgridview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'khgridview', parameterName: 'khgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-khgrid-view/par-ldndlhmbmx-khgrid-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/parldndlhmbmxes/:parldndlhmbmx?/xzgridview/:xzgridview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.xzgridview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'xzgridview', parameterName: 'xzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-xzgrid-view/par-ldndlhmbmx-xzgrid-view.vue'),
    },
    {
        path: '/parldndlhmbmxes/:parldndlhmbmx?/xzgridview/:xzgridview?',
        meta: {
            caption: 'entities.parldndlhmbmx.views.xzgridview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbmxes', parameterName: 'parldndlhmbmx' },
                { pathName: 'xzgridview', parameterName: 'xzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmbmx-xzgrid-view/par-ldndlhmbmx-xzgrid-view.vue'),
    },
    {
        path: '/parldkhqzs/:parldkhqz?/newgridview/:newgridview?',
        meta: {
            caption: 'entities.parldkhqz.views.newgridview.title',
            info:'',
            parameters: [
                { pathName: 'parldkhqzs', parameterName: 'parldkhqz' },
                { pathName: 'newgridview', parameterName: 'newgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldkhqz-new-grid-view/par-ldkhqz-new-grid-view.vue'),
    },
    {
        path: '/parexamcontents/:parexamcontent?/gridview/:gridview?',
        meta: {
            caption: 'entities.parexamcontent.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parexamcontents', parameterName: 'parexamcontent' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-content-grid-view/par-exam-content-grid-view.vue'),
    },
    {
        path: '/parexamcycles/:parexamcycle?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.parexamcycle.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-cycle-mpickup-view/par-exam-cycle-mpickup-view.vue'),
    },
    {
        path: '/parexamcycles/:parexamcycle?/editview/:editview?',
        meta: {
            caption: 'entities.parexamcycle.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-cycle-edit-view/par-exam-cycle-edit-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/gridview/:gridview?',
        meta: {
            caption: 'entities.parldndlhmb.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmb-grid-view/par-ldndlhmb-grid-view.vue'),
    },
    {
        path: '/parkhfas/:parkhfa?/editview/:editview?',
        meta: {
            caption: 'entities.parkhfa.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoheleixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'parkhfas', parameterName: 'parkhfa' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-khfa-edit-view/par-khfa-edit-view.vue'),
    },
    {
        path: '/parjxjgs/:parjxjg?/khdjeditview/:khdjeditview?',
        meta: {
            caption: 'entities.parjxjg.views.khdjeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/jixiaojieguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'parjxjgs', parameterName: 'parjxjg' },
                { pathName: 'khdjeditview', parameterName: 'khdjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-jxjg-khdjedit-view/par-jxjg-khdjedit-view.vue'),
    },
    {
        path: '/partzggs/:partzgg?/editview/:editview?',
        meta: {
            caption: 'entities.partzgg.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'partzggs', parameterName: 'partzgg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-tzgg-edit-view/par-tzgg-edit-view.vue'),
    },
    {
        path: '/parjxjgs/:parjxjg?/gridview/:gridview?',
        meta: {
            caption: 'entities.parjxjg.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/jixiaojieguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'parjxjgs', parameterName: 'parjxjg' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-jxjg-grid-view/par-jxjg-grid-view.vue'),
    },
    {
        path: '/parassesstemplates/:parassesstemplate?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.parassesstemplate.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-assess-template-pickup-grid-view/par-assess-template-pickup-grid-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/ndlhmbxzeditview/:ndlhmbxzeditview?',
        meta: {
            caption: 'entities.parldndlhmb.views.ndlhmbxzeditview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'ndlhmbxzeditview', parameterName: 'ndlhmbxzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmb-ndlhmbxzedit-view/par-ldndlhmb-ndlhmbxzedit-view.vue'),
    },
    {
        path: '/parjxkhjcszs/:parjxkhjcsz?/parkhzcmxes/:parkhzcmx?/editview/:editview?',
        meta: {
            caption: 'entities.parkhzcmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parjxkhjcszs', parameterName: 'parjxkhjcsz' },
                { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-khzcmx-edit-view/par-khzcmx-edit-view.vue'),
    },
    {
        path: '/parassesstemplates/:parassesstemplate?/parkhzcmxes/:parkhzcmx?/editview/:editview?',
        meta: {
            caption: 'entities.parkhzcmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-khzcmx-edit-view/par-khzcmx-edit-view.vue'),
    },
    {
        path: '/parkhzcmxes/:parkhzcmx?/editview/:editview?',
        meta: {
            caption: 'entities.parkhzcmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parkhzcmxes', parameterName: 'parkhzcmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-khzcmx-edit-view/par-khzcmx-edit-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/editview/:editview?',
        meta: {
            caption: 'entities.parldndlhmb.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmb-edit-view/par-ldndlhmb-edit-view.vue'),
    },
    {
        path: '/partzggs/:partzgg?/editview9/:editview9?',
        meta: {
            caption: 'entities.partzgg.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'partzggs', parameterName: 'partzgg' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-tzgg-edit-view9/par-tzgg-edit-view9.vue'),
    },
    {
        path: '/parexamcontents/:parexamcontent?/editview/:editview?',
        meta: {
            caption: 'entities.parexamcontent.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parexamcontents', parameterName: 'parexamcontent' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-content-edit-view/par-exam-content-edit-view.vue'),
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
        path: '/parassesstemplates/:parassesstemplate?/editview9/:editview9?',
        meta: {
            caption: 'entities.parassesstemplate.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-assess-template-edit-view9/par-assess-template-edit-view9.vue'),
    },
    {
        path: '/parexamcycles/:parexamcycle?/newgridview/:newgridview?',
        meta: {
            caption: 'entities.parexamcycle.views.newgridview.title',
            info:'',
            parameters: [
                { pathName: 'parexamcycles', parameterName: 'parexamcycle' },
                { pathName: 'newgridview', parameterName: 'newgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-cycle-new-grid-view/par-exam-cycle-new-grid-view.vue'),
    },
    {
        path: '/parassesstemplates/:parassesstemplate?/gridview/:gridview?',
        meta: {
            caption: 'entities.parassesstemplate.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-assess-template-grid-view/par-assess-template-grid-view.vue'),
    },
    {
        path: '/parldndlhmbs/:parldndlhmb?/kheditview/:kheditview?',
        meta: {
            caption: 'entities.parldndlhmb.views.kheditview.title',
            info:'',
            parameters: [
                { pathName: 'parldndlhmbs', parameterName: 'parldndlhmb' },
                { pathName: 'kheditview', parameterName: 'kheditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-ldndlhmb-khedit-view/par-ldndlhmb-khedit-view.vue'),
    },
    {
        path: '/parexamcontents/:parexamcontent?/editview9/:editview9?',
        meta: {
            caption: 'entities.parexamcontent.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'parexamcontents', parameterName: 'parexamcontent' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-exam-content-edit-view9/par-exam-content-edit-view9.vue'),
    },
    {
        path: '/parassesstemplates/:parassesstemplate?/parjxkhxhzs/:parjxkhxhz?/editview/:editview?',
        meta: {
            caption: 'entities.parjxkhxhz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parassesstemplates', parameterName: 'parassesstemplate' },
                { pathName: 'parjxkhxhzs', parameterName: 'parjxkhxhz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-jxkhxhz-edit-view/par-jxkhxhz-edit-view.vue'),
    },
    {
        path: '/parjxkhxhzs/:parjxkhxhz?/editview/:editview?',
        meta: {
            caption: 'entities.parjxkhxhz.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'parjxkhxhzs', parameterName: 'parjxkhxhz' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/par/par-jxkhxhz-edit-view/par-jxkhxhz-edit-view.vue'),
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
