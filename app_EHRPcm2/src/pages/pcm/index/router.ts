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
            component: () => import('@pages/pcm/index/index.vue'),
            children: [
                {
                    path: 'pcmydjzmxes/:pcmydjzmx?/jsrqqreditview/:jsrqqreditview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.jsrqqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                            { pathName: 'jsrqqreditview', parameterName: 'jsrqqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjzmx-jsrqqredit-view/pcm-ydjzmx-jsrqqredit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.pickupview.caption',
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
                        caption: 'entities.ormorgsector.views.pickupview.caption',
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
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/kddpickupview/:kddpickupview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.kddpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'kddpickupview', parameterName: 'kddpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-kddpickup-view/pim-distirbution-kddpickup-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/kddpickupview/:kddpickupview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.kddpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'kddpickupview', parameterName: 'kddpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-kddpickup-view/pim-distirbution-kddpickup-view.vue'),
                },
                {
                    path: 'pcmydntmxes/:pcmydntmx?/ntglgridview/:ntglgridview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.ntglgridview.caption',
                        imgPath: '../../../img/pzgl/1/neituiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                            { pathName: 'ntglgridview', parameterName: 'ntglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydntmx-ntglgrid-view/pcm-ydntmx-ntglgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/sjyxzzpickupview/:sjyxzzpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.sjyxzzpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'sjyxzzpickupview', parameterName: 'sjyxzzpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-org-sjyxzzpickup-view/orm-org-sjyxzzpickup-view.vue'),
                },
                {
                    path: 'pcmydjzmxes/:pcmydjzmx?/lsjlgridview/:lsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.lsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jianzhijilu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                            { pathName: 'lsjlgridview', parameterName: 'lsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjzmx-lsjlgrid-view/pcm-ydjzmx-lsjlgrid-view.vue'),
                },
                {
                    path: 'pcmydlzmxes/:pcmydlzmx?/lsjlgridview/:lsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydlzmx.views.lsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/lizhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                            { pathName: 'lsjlgridview', parameterName: 'lsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydlzmx-lsjlgrid-view/pcm-ydlzmx-lsjlgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
                },
                {
                    path: 'pcmydjpmxes/:pcmydjpmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.editview9.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjpmx-edit-view9/pcm-ydjpmx-edit-view9.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/kddmpickupview/:kddmpickupview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.kddmpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'kddmpickupview', parameterName: 'kddmpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-kddmpickup-view/pim-distirbution-kddmpickup-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/kddmpickupview/:kddmpickupview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.kddmpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'kddmpickupview', parameterName: 'kddmpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-kddmpickup-view/pim-distirbution-kddmpickup-view.vue'),
                },
                {
                    path: 'pcmydbxmxes/:pcmydbxmx?/bxglgridview/:bxglgridview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.bxglgridview.caption',
                        imgPath: '../../../img/newimage/1/xiujiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                            { pathName: 'bxglgridview', parameterName: 'bxglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydbxmx-bxglgrid-view/pcm-ydbxmx-bxglgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.editview.caption',
                        imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-edit-view/pim-distirbution-edit-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.editview.caption',
                        imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-edit-view/pim-distirbution-edit-view.vue'),
                },
                {
                    path: 'pcmydjzmxes/:pcmydjzmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.editview9.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjzmx-edit-view9/pcm-ydjzmx-edit-view9.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/yxzfppickupgridview/:yxzfppickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.yxzfppickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'yxzfppickupgridview', parameterName: 'yxzfppickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-yxzfppickup-grid-view/pim-person-yxzfppickup-grid-view.vue'),
                },
                {
                    path: 'pcmydntmxes/:pcmydntmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydntmx-edit-view/pcm-ydntmx-edit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormpost.views.pickupgridview.caption',
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
                        caption: 'entities.ormpost.views.pickupgridview.caption',
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
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/ejormorgidpickupview/:ejormorgidpickupview?',
                    meta: {
                        caption: 'entities.ormpost.views.ejormorgidpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'ejormorgidpickupview', parameterName: 'ejormorgidpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-post-ejormorgidpickup-view/orm-post-ejormorgidpickup-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/ejormorgidpickupview/:ejormorgidpickupview?',
                    meta: {
                        caption: 'entities.ormpost.views.ejormorgidpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'ejormorgidpickupview', parameterName: 'ejormorgidpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-post-ejormorgidpickup-view/orm-post-ejormorgidpickup-view.vue'),
                },
                {
                    path: 'pcmydntmxes/:pcmydntmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.xzeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                            { pathName: 'xzeditview', parameterName: 'xzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydntmx-xzedit-view/pcm-ydntmx-xzedit-view.vue'),
                },
                {
                    path: 'pcmydjpmxes/:pcmydjpmx?/jpjlgridview/:jpjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.jpjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiepinguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                            { pathName: 'jpjlgridview', parameterName: 'jpjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjpmx-jpjlgrid-view/pcm-ydjpmx-jpjlgrid-view.vue'),
                },
                {
                    path: 'pcmydjpmxes/:pcmydjpmx?/glgridview/:glgridview?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.glgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiepinguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                            { pathName: 'glgridview', parameterName: 'glgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjpmx-glgrid-view/pcm-ydjpmx-glgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
                },
                {
                    path: 'pcmyddgmxes/:pcmyddgmx?/dgjlgridview/:dgjlgridview?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.dgjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/daigangguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                            { pathName: 'dgjlgridview', parameterName: 'dgjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-yddgmx-dgjlgrid-view/pcm-yddgmx-dgjlgrid-view.vue'),
                },
                {
                    path: 'pcmydjzmxes/:pcmydjzmx?/jlckeditview/:jlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.jlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                            { pathName: 'jlckeditview', parameterName: 'jlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjzmx-jlckedit-view/pcm-ydjzmx-jlckedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/yxzfppickupview/:yxzfppickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.yxzfppickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'yxzfppickupview', parameterName: 'yxzfppickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-yxzfppickup-view/pim-person-yxzfppickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/txqreditview/:txqreditview?',
                    meta: {
                        caption: 'entities.pimperson.views.txqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'txqreditview', parameterName: 'txqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-txqredit-view/pim-person-txqredit-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.ormduty.views.pickupgridview.caption',
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
                    path: 'pcmydlzmxes/:pcmydlzmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydlzmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydlzmx-edit-view/pcm-ydlzmx-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pimperson.views.editview9.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-edit-view9/pim-person-edit-view9.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/ormorgsectorpickupgridview/:ormorgsectorpickupgridview?',
                    meta: {
                        caption: 'entities.ormduty.views.ormorgsectorpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'ormorgsectorpickupgridview', parameterName: 'ormorgsectorpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-duty-orm-org-sector-pickup-grid-view/orm-duty-orm-org-sector-pickup-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormpost.views.pickupview.caption',
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
                        caption: 'entities.ormpost.views.pickupview.caption',
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
                    path: 'pcmydjpmxes/:pcmydjpmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.xzeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                            { pathName: 'xzeditview', parameterName: 'xzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjpmx-xzedit-view/pcm-ydjpmx-xzedit-view.vue'),
                },
                {
                    path: 'pcmydbxmxes/:pcmydbxmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.editview9.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydbxmx-edit-view9/pcm-ydbxmx-edit-view9.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/fpxxpickupview/:fpxxpickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.fpxxpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'fpxxpickupview', parameterName: 'fpxxpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-fpxxpickup-view/orm-orgsector-fpxxpickup-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/fpxxpickupview/:fpxxpickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.fpxxpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'fpxxpickupview', parameterName: 'fpxxpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-fpxxpickup-view/orm-orgsector-fpxxpickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/fpxxpickupgridview/:fpxxpickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.fpxxpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'fpxxpickupgridview', parameterName: 'fpxxpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-fpxxpickup-grid-view/orm-orgsector-fpxxpickup-grid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/fpxxpickupgridview/:fpxxpickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.fpxxpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'fpxxpickupgridview', parameterName: 'fpxxpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-fpxxpickup-grid-view/orm-orgsector-fpxxpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/jtlxrpickupgridview/:jtlxrpickupgridview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.jtlxrpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'jtlxrpickupgridview', parameterName: 'jtlxrpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-faminfo-jtlxrpickup-grid-view/pim-faminfo-jtlxrpickup-grid-view.vue'),
                },
                {
                    path: 'pimfaminfos/:pimfaminfo?/jtlxrpickupgridview/:jtlxrpickupgridview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.jtlxrpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'jtlxrpickupgridview', parameterName: 'jtlxrpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-faminfo-jtlxrpickup-grid-view/pim-faminfo-jtlxrpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.pickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-pickup-view/pim-person-pickup-view.vue'),
                },
                {
                    path: 'pcmydjpmxes/:pcmydjpmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.ckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                            { pathName: 'ckeditview', parameterName: 'ckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjpmx-ckedit-view/pcm-ydjpmx-ckedit-view.vue'),
                },
                {
                    path: 'pcmydlzmxes/:pcmydlzmx?/glgridview/:glgridview?',
                    meta: {
                        caption: 'entities.pcmydlzmx.views.glgridview.caption',
                        imgPath: '../../../img/pzgl/1/lizhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                            { pathName: 'glgridview', parameterName: 'glgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydlzmx-glgrid-view/pcm-ydlzmx-glgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/sjyxzzpickupgridview/:sjyxzzpickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.sjyxzzpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'sjyxzzpickupgridview', parameterName: 'sjyxzzpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-org-sjyxzzpickup-grid-view/orm-org-sjyxzzpickup-grid-view.vue'),
                },
                {
                    path: 'pcmydjzmxes/:pcmydjzmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.xzeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                            { pathName: 'xzeditview', parameterName: 'xzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjzmx-xzedit-view/pcm-ydjzmx-xzedit-view.vue'),
                },
                {
                    path: 'pcmydlzmxes/:pcmydlzmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydlzmx.views.xzeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                            { pathName: 'xzeditview', parameterName: 'xzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydlzmx-xzedit-view/pcm-ydlzmx-xzedit-view.vue'),
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
                    component: () => import('@pages/pcm/orm-org-pickup-view/orm-org-pickup-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/ormorgsectorpickupview/:ormorgsectorpickupview?',
                    meta: {
                        caption: 'entities.ormduty.views.ormorgsectorpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'ormorgsectorpickupview', parameterName: 'ormorgsectorpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-duty-orm-org-sector-pickup-view/orm-duty-orm-org-sector-pickup-view.vue'),
                },
                {
                    path: 'pcmydtxmxes/:pcmydtxmx?/jlgridview/:jlgridview?',
                    meta: {
                        caption: 'entities.pcmydtxmx.views.jlgridview.caption',
                        imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydtxmxes', parameterName: 'pcmydtxmx' },
                            { pathName: 'jlgridview', parameterName: 'jlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydtxmx-jlgrid-view/pcm-ydtxmx-jlgrid-view.vue'),
                },
                {
                    path: 'pcmyddgmxes/:pcmyddgmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.ckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                            { pathName: 'ckeditview', parameterName: 'ckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-yddgmx-ckedit-view/pcm-yddgmx-ckedit-view.vue'),
                },
                {
                    path: 'pcmydlzmxes/:pcmydlzmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmydlzmx.views.editview9.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydlzmx-edit-view9/pcm-ydlzmx-edit-view9.vue'),
                },
                {
                    path: 'pcmydbxmxes/:pcmydbxmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.ckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                            { pathName: 'ckeditview', parameterName: 'ckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydbxmx-ckedit-view/pcm-ydbxmx-ckedit-view.vue'),
                },
                {
                    path: 'pcmyddgmxes/:pcmyddgmx?/dgglgridview/:dgglgridview?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.dgglgridview.caption',
                        imgPath: '../../../img/pzgl/1/daigangguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                            { pathName: 'dgglgridview', parameterName: 'dgglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-yddgmx-dgglgrid-view/pcm-yddgmx-dgglgrid-view.vue'),
                },
                {
                    path: 'pcmydbxmxes/:pcmydbxmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydbxmx-edit-view/pcm-ydbxmx-edit-view.vue'),
                },
                {
                    path: 'pcmydbxmxes/:pcmydbxmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.xzeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                            { pathName: 'xzeditview', parameterName: 'xzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydbxmx-xzedit-view/pcm-ydbxmx-xzedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ydbmpickupview/:ydbmpickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.ydbmpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ydbmpickupview', parameterName: 'ydbmpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-ydbmpickup-view/orm-orgsector-ydbmpickup-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/ydbmpickupview/:ydbmpickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.ydbmpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ydbmpickupview', parameterName: 'ydbmpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-ydbmpickup-view/orm-orgsector-ydbmpickup-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.ormduty.views.pickupview.caption',
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
                    component: () => import('@pages/pcm/orm-org-pickup-grid-view/orm-org-pickup-grid-view.vue'),
                },
                {
                    path: 'pcmydjpmxes/:pcmydjpmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.editview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjpmx-edit-view/pcm-ydjpmx-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddckeditview/:ddckeditview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddckeditview', parameterName: 'ddckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddckedit-view/pcm-ddsqdmx-ddckedit-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddckeditview/:ddckeditview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddckeditview', parameterName: 'ddckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddckedit-view/pcm-ddsqdmx-ddckedit-view.vue'),
                },
                {
                    path: 'pcmddsqds/:pcmddsqd?/pcmddsqdmxes/:pcmddsqdmx?/ddckeditview/:ddckeditview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmddsqds', parameterName: 'pcmddsqd' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddckeditview', parameterName: 'ddckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddckedit-view/pcm-ddsqdmx-ddckedit-view.vue'),
                },
                {
                    path: 'pcmddsqdmxes/:pcmddsqdmx?/ddckeditview/:ddckeditview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddckeditview', parameterName: 'ddckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddckedit-view/pcm-ddsqdmx-ddckedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.pickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-pickup-grid-view/pim-person-pickup-grid-view.vue'),
                },
                {
                    path: 'pcmydntmxes/:pcmydntmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.ckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                            { pathName: 'ckeditview', parameterName: 'ckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydntmx-ckedit-view/pcm-ydntmx-ckedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/ddmgrgridview/:ddmgrgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.ddmgrgridview.caption',
                        imgPath: '../../../img/pzgl/1/diaodongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'ddmgrgridview', parameterName: 'ddmgrgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-ddmgr-grid-view/pim-distirbution-ddmgr-grid-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/ddmgrgridview/:ddmgrgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.ddmgrgridview.caption',
                        imgPath: '../../../img/pzgl/1/diaodongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'ddmgrgridview', parameterName: 'ddmgrgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-ddmgr-grid-view/pim-distirbution-ddmgr-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/txryeditview/:txryeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.txryeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'txryeditview', parameterName: 'txryeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-txryedit-view/pim-person-txryedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/ejormorgidpickupgridview/:ejormorgidpickupgridview?',
                    meta: {
                        caption: 'entities.ormpost.views.ejormorgidpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'ejormorgidpickupgridview', parameterName: 'ejormorgidpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-post-ejormorgidpickup-grid-view/orm-post-ejormorgidpickup-grid-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/ejormorgidpickupgridview/:ejormorgidpickupgridview?',
                    meta: {
                        caption: 'entities.ormpost.views.ejormorgidpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'ejormorgidpickupgridview', parameterName: 'ejormorgidpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-post-ejormorgidpickup-grid-view/orm-post-ejormorgidpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/txglgridview/:txglgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.txglgridview.caption',
                        imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'txglgridview', parameterName: 'txglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-txglgrid-view/pim-person-txglgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/kddfppickupgridview/:kddfppickupgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.kddfppickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'kddfppickupgridview', parameterName: 'kddfppickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-kddfppickup-grid-view/pim-distirbution-kddfppickup-grid-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/kddfppickupgridview/:kddfppickupgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.kddfppickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'kddfppickupgridview', parameterName: 'kddfppickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-distirbution-kddfppickup-grid-view/pim-distirbution-kddfppickup-grid-view.vue'),
                },
                {
                    path: 'pcmydntmxes/:pcmydntmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.editview9.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydntmx-edit-view9/pcm-ydntmx-edit-view9.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/fpxxpickupgridview/:fpxxpickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.fpxxpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'fpxxpickupgridview', parameterName: 'fpxxpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-org-fpxxpickup-grid-view/orm-org-fpxxpickup-grid-view.vue'),
                },
                {
                    path: 'pcmyddgmxes/:pcmyddgmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.xzeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                            { pathName: 'xzeditview', parameterName: 'xzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-yddgmx-xzedit-view/pcm-yddgmx-xzedit-view.vue'),
                },
                {
                    path: 'pcmydntmxes/:pcmydntmx?/ntjlgridview/:ntjlgridview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.ntjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/neituiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                            { pathName: 'ntjlgridview', parameterName: 'ntjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydntmx-ntjlgrid-view/pcm-ydntmx-ntjlgrid-view.vue'),
                },
                {
                    path: 'pcmydtxmxes/:pcmydtxmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmydtxmx.views.ckeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydtxmxes', parameterName: 'pcmydtxmx' },
                            { pathName: 'ckeditview', parameterName: 'ckeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydtxmx-ckedit-view/pcm-ydtxmx-ckedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/jtlxrpickupview/:jtlxrpickupview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.jtlxrpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'jtlxrpickupview', parameterName: 'jtlxrpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-faminfo-jtlxrpickup-view/pim-faminfo-jtlxrpickup-view.vue'),
                },
                {
                    path: 'pimfaminfos/:pimfaminfo?/jtlxrpickupview/:jtlxrpickupview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.jtlxrpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'jtlxrpickupview', parameterName: 'jtlxrpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-faminfo-jtlxrpickup-view/pim-faminfo-jtlxrpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddjlgridview/:ddjlgridview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/diaodongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddjlgridview', parameterName: 'ddjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddjlgrid-view/pcm-ddsqdmx-ddjlgrid-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddjlgridview/:ddjlgridview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/diaodongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddjlgridview', parameterName: 'ddjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddjlgrid-view/pcm-ddsqdmx-ddjlgrid-view.vue'),
                },
                {
                    path: 'pcmddsqds/:pcmddsqd?/pcmddsqdmxes/:pcmddsqdmx?/ddjlgridview/:ddjlgridview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/diaodongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmddsqds', parameterName: 'pcmddsqd' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddjlgridview', parameterName: 'ddjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddjlgrid-view/pcm-ddsqdmx-ddjlgrid-view.vue'),
                },
                {
                    path: 'pcmddsqdmxes/:pcmddsqdmx?/ddjlgridview/:ddjlgridview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/diaodongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddjlgridview', parameterName: 'ddjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddjlgrid-view/pcm-ddsqdmx-ddjlgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ydbmpickupgridview/:ydbmpickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.ydbmpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ydbmpickupgridview', parameterName: 'ydbmpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-ydbmpickup-grid-view/orm-orgsector-ydbmpickup-grid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/ydbmpickupgridview/:ydbmpickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.ydbmpickupgridview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'ydbmpickupgridview', parameterName: 'ydbmpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-orgsector-ydbmpickup-grid-view/orm-orgsector-ydbmpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
                        imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormposts', parameterName: 'ormpost' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormduties', parameterName: 'ormduty' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                            { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
                },
                {
                    path: 'pcmyddgmxes/:pcmyddgmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.editview9.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-yddgmx-edit-view9/pcm-yddgmx-edit-view9.vue'),
                },
                {
                    path: 'pcmydbxmxes/:pcmydbxmx?/jlgridview/:jlgridview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.jlgridview.caption',
                        imgPath: '../../../img/newimage/1/xiujiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                            { pathName: 'jlgridview', parameterName: 'jlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydbxmx-jlgrid-view/pcm-ydbxmx-jlgrid-view.vue'),
                },
                {
                    path: 'pcmydntmxes/:pcmydntmx?/ntjsrqqreditview/:ntjsrqqreditview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.ntjsrqqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                            { pathName: 'ntjsrqqreditview', parameterName: 'ntjsrqqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydntmx-ntjsrqqredit-view/pcm-ydntmx-ntjsrqqredit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/fpxxpickupview/:fpxxpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.fpxxpickupview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'fpxxpickupview', parameterName: 'fpxxpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/orm-org-fpxxpickup-view/orm-org-fpxxpickup-view.vue'),
                },
                {
                    path: 'pcmydbxmxes/:pcmydbxmx?/bxjsrqqreditview/:bxjsrqqreditview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.bxjsrqqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                            { pathName: 'bxjsrqqreditview', parameterName: 'bxjsrqqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydbxmx-bxjsrqqredit-view/pcm-ydbxmx-bxjsrqqredit-view.vue'),
                },
                {
                    path: 'pcmyddgmxes/:pcmyddgmx?/jsrqqreditview/:jsrqqreditview?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.jsrqqreditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                            { pathName: 'jsrqqreditview', parameterName: 'jsrqqreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-yddgmx-jsrqqredit-view/pcm-yddgmx-jsrqqredit-view.vue'),
                },
                {
                    path: 'pcmydjzmxes/:pcmydjzmx?/glgridview/:glgridview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.glgridview.caption',
                        imgPath: '../../../img/pzgl/1/jianzhijilu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                            { pathName: 'glgridview', parameterName: 'glgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ydjzmx-glgrid-view/pcm-ydjzmx-glgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddeditview/:ddeditview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddeditview', parameterName: 'ddeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddedit-view/pcm-ddsqdmx-ddedit-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddeditview/:ddeditview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddeditview', parameterName: 'ddeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddedit-view/pcm-ddsqdmx-ddedit-view.vue'),
                },
                {
                    path: 'pcmddsqds/:pcmddsqd?/pcmddsqdmxes/:pcmddsqdmx?/ddeditview/:ddeditview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmddsqds', parameterName: 'pcmddsqd' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddeditview', parameterName: 'ddeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddedit-view/pcm-ddsqdmx-ddedit-view.vue'),
                },
                {
                    path: 'pcmddsqdmxes/:pcmddsqdmx?/ddeditview/:ddeditview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddeditview.caption',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                            { pathName: 'ddeditview', parameterName: 'ddeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-ddsqdmx-ddedit-view/pcm-ddsqdmx-ddedit-view.vue'),
                },
            {
                path: 'pcmydjpmxredirectview/:pcmydjpmxredirectview?',
                meta: {
                    caption: 'entities.pcmydjpmx.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pcmydjpmxredirectview', parameterName: 'pcmydjpmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-ydjpmx-redirect-view/pcm-ydjpmx-redirect-view.vue'),
            },
            {
                path: 'pcmyddgmxredirectview/:pcmyddgmxredirectview?',
                meta: {
                    caption: 'entities.pcmyddgmx.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pcmyddgmxredirectview', parameterName: 'pcmyddgmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-yddgmx-redirect-view/pcm-yddgmx-redirect-view.vue'),
            },
            {
                path: 'pcmydlzmxredirectview/:pcmydlzmxredirectview?',
                meta: {
                    caption: 'entities.pcmydlzmx.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pcmydlzmxredirectview', parameterName: 'pcmydlzmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-ydlzmx-redirect-view/pcm-ydlzmx-redirect-view.vue'),
            },
            {
                path: 'pimdistirbutionredirectview/:pimdistirbutionredirectview?',
                meta: {
                    caption: 'entities.pimdistirbution.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pimdistirbutionredirectview', parameterName: 'pimdistirbutionredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pim-distirbution-redirect-view/pim-distirbution-redirect-view.vue'),
            },
            {
                path: 'pcmydtxmxredirectview/:pcmydtxmxredirectview?',
                meta: {
                    caption: 'entities.pcmydtxmx.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pcmydtxmxredirectview', parameterName: 'pcmydtxmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-ydtxmx-redirect-view/pcm-ydtxmx-redirect-view.vue'),
            },
            {
                path: 'pcmydbxmxredirectview/:pcmydbxmxredirectview?',
                meta: {
                    caption: 'entities.pcmydbxmx.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pcmydbxmxredirectview', parameterName: 'pcmydbxmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-ydbxmx-redirect-view/pcm-ydbxmx-redirect-view.vue'),
            },
            {
                path: 'pcmydntmxredirectview/:pcmydntmxredirectview?',
                meta: {
                    caption: 'entities.pcmydntmx.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pcmydntmxredirectview', parameterName: 'pcmydntmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-ydntmx-redirect-view/pcm-ydntmx-redirect-view.vue'),
            },
            {
                path: 'pcmydjdmxredirectview/:pcmydjdmxredirectview?',
                meta: {
                    caption: 'entities.pcmydjdmx.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pcmydjdmxredirectview', parameterName: 'pcmydjdmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-ydjdmx-redirect-view/pcm-ydjdmx-redirect-view.vue'),
            },
            {
                path: 'pcmydgzmxredirectview/:pcmydgzmxredirectview?',
                meta: {
                    caption: 'entities.pcmydgzmx.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pcmydgzmxredirectview', parameterName: 'pcmydgzmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-ydgzmx-redirect-view/pcm-ydgzmx-redirect-view.vue'),
            },
            {
                path: 'pcmydjzmxredirectview/:pcmydjzmxredirectview?',
                meta: {
                    caption: 'entities.pcmydjzmx.views.redirectview.caption',
                    parameters: [
                        { pathName: 'pcmydjzmxredirectview', parameterName: 'pcmydjzmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-ydjzmx-redirect-view/pcm-ydjzmx-redirect-view.vue'),
            },
            ...indexRoutes,
            ],
        },
    {
        path: '/ormorgs/:ormorg?/sjyxzzpickupview/:sjyxzzpickupview?',
        meta: {
            caption: 'entities.ormorg.views.sjyxzzpickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'sjyxzzpickupview', parameterName: 'sjyxzzpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-org-sjyxzzpickup-view/orm-org-sjyxzzpickup-view.vue'),
    },
    {
        path: '/pcmydjpmxes/:pcmydjpmx?/jpjlgridview/:jpjlgridview?',
        meta: {
            caption: 'entities.pcmydjpmx.views.jpjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiepinguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                { pathName: 'jpjlgridview', parameterName: 'jpjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjpmx-jpjlgrid-view/pcm-ydjpmx-jpjlgrid-view.vue'),
    },
    {
        path: '/pcmydntmxes/:pcmydntmx?/ckeditview/:ckeditview?',
        meta: {
            caption: 'entities.pcmydntmx.views.ckeditview.caption',
            parameters: [
                { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                { pathName: 'ckeditview', parameterName: 'ckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydntmx-ckedit-view/pcm-ydntmx-ckedit-view.vue'),
    },
    {
        path: '/pcmydlzmxes/:pcmydlzmx?/xzeditview/:xzeditview?',
        meta: {
            caption: 'entities.pcmydlzmx.views.xzeditview.caption',
            parameters: [
                { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                { pathName: 'xzeditview', parameterName: 'xzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydlzmx-xzedit-view/pcm-ydlzmx-xzedit-view.vue'),
    },
    {
        path: '/pcmydjzmxes/:pcmydjzmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmydjzmx.views.editview9.caption',
            parameters: [
                { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjzmx-edit-view9/pcm-ydjzmx-edit-view9.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/jtlxrpickupview/:jtlxrpickupview?',
        meta: {
            caption: 'entities.pimfaminfo.views.jtlxrpickupview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'jtlxrpickupview', parameterName: 'jtlxrpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-faminfo-jtlxrpickup-view/pim-faminfo-jtlxrpickup-view.vue'),
    },
    {
        path: '/pimfaminfos/:pimfaminfo?/jtlxrpickupview/:jtlxrpickupview?',
        meta: {
            caption: 'entities.pimfaminfo.views.jtlxrpickupview.caption',
            parameters: [
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'jtlxrpickupview', parameterName: 'jtlxrpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-faminfo-jtlxrpickup-view/pim-faminfo-jtlxrpickup-view.vue'),
    },
    {
        path: '/pcmydjpmxes/:pcmydjpmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjpmx.views.editview.caption',
            parameters: [
                { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjpmx-edit-view/pcm-ydjpmx-edit-view.vue'),
    },
    {
        path: '/pcmydlzmxes/:pcmydlzmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmydlzmx.views.editview9.caption',
            parameters: [
                { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydlzmx-edit-view9/pcm-ydlzmx-edit-view9.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormpost.views.pickupgridview.caption',
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
            caption: 'entities.ormpost.views.pickupgridview.caption',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-post-pickup-grid-view/orm-post-pickup-grid-view.vue'),
    },
    {
        path: '/pcmyddgmxes/:pcmyddgmx?/jsrqqreditview/:jsrqqreditview?',
        meta: {
            caption: 'entities.pcmyddgmx.views.jsrqqreditview.caption',
            parameters: [
                { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                { pathName: 'jsrqqreditview', parameterName: 'jsrqqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-yddgmx-jsrqqredit-view/pcm-yddgmx-jsrqqredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.caption',
            parameters: [
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjsqreditview', parameterName: 'jdjsqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjsqredit-view/pcm-ydjdmx-jdjsqredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddjlgridview/:ddjlgridview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddjlgridview.caption',
            imgPath: '../../../img/pzgl/1/diaodongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddjlgridview', parameterName: 'ddjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddjlgrid-view/pcm-ddsqdmx-ddjlgrid-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddjlgridview/:ddjlgridview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddjlgridview.caption',
            imgPath: '../../../img/pzgl/1/diaodongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddjlgridview', parameterName: 'ddjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddjlgrid-view/pcm-ddsqdmx-ddjlgrid-view.vue'),
    },
    {
        path: '/pcmddsqds/:pcmddsqd?/pcmddsqdmxes/:pcmddsqdmx?/ddjlgridview/:ddjlgridview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddjlgridview.caption',
            imgPath: '../../../img/pzgl/1/diaodongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmddsqds', parameterName: 'pcmddsqd' },
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddjlgridview', parameterName: 'ddjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddjlgrid-view/pcm-ddsqdmx-ddjlgrid-view.vue'),
    },
    {
        path: '/pcmddsqdmxes/:pcmddsqdmx?/ddjlgridview/:ddjlgridview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddjlgridview.caption',
            imgPath: '../../../img/pzgl/1/diaodongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddjlgridview', parameterName: 'ddjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddjlgrid-view/pcm-ddsqdmx-ddjlgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdlsjlgridview', parameterName: 'jdlsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdlsjlgrid-view/pcm-ydjdmx-jdlsjlgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/yxzfppickupview/:yxzfppickupview?',
        meta: {
            caption: 'entities.pimperson.views.yxzfppickupview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'yxzfppickupview', parameterName: 'yxzfppickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-yxzfppickup-view/pim-person-yxzfppickup-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/bxjsrqqreditview/:bxjsrqqreditview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.bxjsrqqreditview.caption',
            parameters: [
                { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                { pathName: 'bxjsrqqreditview', parameterName: 'bxjsrqqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydbxmx-bxjsrqqredit-view/pcm-ydbxmx-bxjsrqqredit-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/ormorgsectorpickupview/:ormorgsectorpickupview?',
        meta: {
            caption: 'entities.ormduty.views.ormorgsectorpickupview.caption',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'ormorgsectorpickupview', parameterName: 'ormorgsectorpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-duty-orm-org-sector-pickup-view/orm-duty-orm-org-sector-pickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/fpxxpickupview/:fpxxpickupview?',
        meta: {
            caption: 'entities.ormorg.views.fpxxpickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'fpxxpickupview', parameterName: 'fpxxpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-org-fpxxpickup-view/orm-org-fpxxpickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/ejormorgidpickupview/:ejormorgidpickupview?',
        meta: {
            caption: 'entities.ormpost.views.ejormorgidpickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'ejormorgidpickupview', parameterName: 'ejormorgidpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-post-ejormorgidpickup-view/orm-post-ejormorgidpickup-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/ejormorgidpickupview/:ejormorgidpickupview?',
        meta: {
            caption: 'entities.ormpost.views.ejormorgidpickupview.caption',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'ejormorgidpickupview', parameterName: 'ejormorgidpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-post-ejormorgidpickup-view/orm-post-ejormorgidpickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.pickupgridview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-pickup-grid-view/pim-person-pickup-grid-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/bxglgridview/:bxglgridview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.bxglgridview.caption',
            imgPath: '../../../img/newimage/1/xiujiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                { pathName: 'bxglgridview', parameterName: 'bxglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydbxmx-bxglgrid-view/pcm-ydbxmx-bxglgrid-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormduty.views.pickupgridview.caption',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-duty-pickup-grid-view/orm-duty-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddckeditview/:ddckeditview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddckeditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddckeditview', parameterName: 'ddckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddckedit-view/pcm-ddsqdmx-ddckedit-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddckeditview/:ddckeditview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddckeditview.caption',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddckeditview', parameterName: 'ddckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddckedit-view/pcm-ddsqdmx-ddckedit-view.vue'),
    },
    {
        path: '/pcmddsqds/:pcmddsqd?/pcmddsqdmxes/:pcmddsqdmx?/ddckeditview/:ddckeditview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddckeditview.caption',
            parameters: [
                { pathName: 'pcmddsqds', parameterName: 'pcmddsqd' },
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddckeditview', parameterName: 'ddckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddckedit-view/pcm-ddsqdmx-ddckedit-view.vue'),
    },
    {
        path: '/pcmddsqdmxes/:pcmddsqdmx?/ddckeditview/:ddckeditview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddckeditview.caption',
            parameters: [
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddckeditview', parameterName: 'ddckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddckedit-view/pcm-ddsqdmx-ddckedit-view.vue'),
    },
    {
        path: '/pcmydjzmxes/:pcmydjzmx?/jsrqqreditview/:jsrqqreditview?',
        meta: {
            caption: 'entities.pcmydjzmx.views.jsrqqreditview.caption',
            parameters: [
                { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                { pathName: 'jsrqqreditview', parameterName: 'jsrqqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjzmx-jsrqqredit-view/pcm-ydjzmx-jsrqqredit-view.vue'),
    },
    {
        path: '/pcmydjpmxes/:pcmydjpmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmydjpmx.views.editview9.caption',
            parameters: [
                { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjpmx-edit-view9/pcm-ydjpmx-edit-view9.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddeditview/:ddeditview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddeditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddeditview', parameterName: 'ddeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddedit-view/pcm-ddsqdmx-ddedit-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddeditview/:ddeditview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddeditview.caption',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddeditview', parameterName: 'ddeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddedit-view/pcm-ddsqdmx-ddedit-view.vue'),
    },
    {
        path: '/pcmddsqds/:pcmddsqd?/pcmddsqdmxes/:pcmddsqdmx?/ddeditview/:ddeditview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddeditview.caption',
            parameters: [
                { pathName: 'pcmddsqds', parameterName: 'pcmddsqd' },
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddeditview', parameterName: 'ddeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddedit-view/pcm-ddsqdmx-ddedit-view.vue'),
    },
    {
        path: '/pcmddsqdmxes/:pcmddsqdmx?/ddeditview/:ddeditview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddeditview.caption',
            parameters: [
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddeditview', parameterName: 'ddeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddedit-view/pcm-ddsqdmx-ddedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/txglgridview/:txglgridview?',
        meta: {
            caption: 'entities.pimperson.views.txglgridview.caption',
            imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'txglgridview', parameterName: 'txglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-txglgrid-view/pim-person-txglgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/ddmgrgridview/:ddmgrgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.ddmgrgridview.caption',
            imgPath: '../../../img/pzgl/1/diaodongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'ddmgrgridview', parameterName: 'ddmgrgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-ddmgr-grid-view/pim-distirbution-ddmgr-grid-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/ddmgrgridview/:ddmgrgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.ddmgrgridview.caption',
            imgPath: '../../../img/pzgl/1/diaodongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'ddmgrgridview', parameterName: 'ddmgrgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-ddmgr-grid-view/pim-distirbution-ddmgr-grid-view.vue'),
    },
    {
        path: '/pcmydjzmxes/:pcmydjzmx?/glgridview/:glgridview?',
        meta: {
            caption: 'entities.pcmydjzmx.views.glgridview.caption',
            imgPath: '../../../img/pzgl/1/jianzhijilu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                { pathName: 'glgridview', parameterName: 'glgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjzmx-glgrid-view/pcm-ydjzmx-glgrid-view.vue'),
    },
    {
        path: '/pcmydjzmxes/:pcmydjzmx?/lsjlgridview/:lsjlgridview?',
        meta: {
            caption: 'entities.pcmydjzmx.views.lsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/jianzhijilu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                { pathName: 'lsjlgridview', parameterName: 'lsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjzmx-lsjlgrid-view/pcm-ydjzmx-lsjlgrid-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.editview.caption',
            parameters: [
                { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydbxmx-edit-view/pcm-ydbxmx-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.caption',
            parameters: [
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdjlckeditview', parameterName: 'jdjlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdjlckedit-view/pcm-ydjdmx-jdjlckedit-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmydbxmx.views.editview9.caption',
            parameters: [
                { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydbxmx-edit-view9/pcm-ydbxmx-edit-view9.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/kddfppickupgridview/:kddfppickupgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.kddfppickupgridview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'kddfppickupgridview', parameterName: 'kddfppickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-kddfppickup-grid-view/pim-distirbution-kddfppickup-grid-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/kddfppickupgridview/:kddfppickupgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.kddfppickupgridview.caption',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'kddfppickupgridview', parameterName: 'kddfppickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-kddfppickup-grid-view/pim-distirbution-kddfppickup-grid-view.vue'),
    },
    {
        path: '/pcmydlzmxes/:pcmydlzmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydlzmx.views.editview.caption',
            parameters: [
                { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydlzmx-edit-view/pcm-ydlzmx-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.caption',
            imgPath: '../../../img/pzgl/1/jiediaoguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-jdglgrid-view/pcm-ydjdmx-jdglgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/jtlxrpickupgridview/:jtlxrpickupgridview?',
        meta: {
            caption: 'entities.pimfaminfo.views.jtlxrpickupgridview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'jtlxrpickupgridview', parameterName: 'jtlxrpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-faminfo-jtlxrpickup-grid-view/pim-faminfo-jtlxrpickup-grid-view.vue'),
    },
    {
        path: '/pimfaminfos/:pimfaminfo?/jtlxrpickupgridview/:jtlxrpickupgridview?',
        meta: {
            caption: 'entities.pimfaminfo.views.jtlxrpickupgridview.caption',
            parameters: [
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'jtlxrpickupgridview', parameterName: 'jtlxrpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-faminfo-jtlxrpickup-grid-view/pim-faminfo-jtlxrpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/yxzfppickupgridview/:yxzfppickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.yxzfppickupgridview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'yxzfppickupgridview', parameterName: 'yxzfppickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-yxzfppickup-grid-view/pim-person-yxzfppickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.caption',
            parameters: [
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'ydmxeditview', parameterName: 'ydmxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-ydmxedit-view/pcm-ydjdmx-ydmxedit-view.vue'),
    },
    {
        path: '/pcmydjpmxes/:pcmydjpmx?/xzeditview/:xzeditview?',
        meta: {
            caption: 'entities.pcmydjpmx.views.xzeditview.caption',
            parameters: [
                { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                { pathName: 'xzeditview', parameterName: 'xzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjpmx-xzedit-view/pcm-ydjpmx-xzedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/txryeditview/:txryeditview?',
        meta: {
            caption: 'entities.pimperson.views.txryeditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'txryeditview', parameterName: 'txryeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-txryedit-view/pim-person-txryedit-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormduty.views.pickupview.caption',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-duty-pickup-view/orm-duty-pickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/txqreditview/:txqreditview?',
        meta: {
            caption: 'entities.pimperson.views.txqreditview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'txqreditview', parameterName: 'txqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-txqredit-view/pim-person-txqredit-view.vue'),
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
        component: () => import('@pages/pcm/orm-org-pickup-view/orm-org-pickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.pickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.pickupgridview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/fpxxpickupgridview/:fpxxpickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.fpxxpickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'fpxxpickupgridview', parameterName: 'fpxxpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-fpxxpickup-grid-view/orm-orgsector-fpxxpickup-grid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/fpxxpickupgridview/:fpxxpickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.fpxxpickupgridview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'fpxxpickupgridview', parameterName: 'fpxxpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-fpxxpickup-grid-view/orm-orgsector-fpxxpickup-grid-view.vue'),
    },
    {
        path: '/pcmyddgmxes/:pcmyddgmx?/dgglgridview/:dgglgridview?',
        meta: {
            caption: 'entities.pcmyddgmx.views.dgglgridview.caption',
            imgPath: '../../../img/pzgl/1/daigangguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                { pathName: 'dgglgridview', parameterName: 'dgglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-yddgmx-dgglgrid-view/pcm-yddgmx-dgglgrid-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/jlgridview/:jlgridview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.jlgridview.caption',
            imgPath: '../../../img/newimage/1/xiujiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                { pathName: 'jlgridview', parameterName: 'jlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydbxmx-jlgrid-view/pcm-ydbxmx-jlgrid-view.vue'),
    },
    {
        path: '/pcmydntmxes/:pcmydntmx?/xzeditview/:xzeditview?',
        meta: {
            caption: 'entities.pcmydntmx.views.xzeditview.caption',
            parameters: [
                { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                { pathName: 'xzeditview', parameterName: 'xzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydntmx-xzedit-view/pcm-ydntmx-xzedit-view.vue'),
    },
    {
        path: '/pcmydjpmxes/:pcmydjpmx?/glgridview/:glgridview?',
        meta: {
            caption: 'entities.pcmydjpmx.views.glgridview.caption',
            imgPath: '../../../img/pzgl/1/jiepinguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                { pathName: 'glgridview', parameterName: 'glgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjpmx-glgrid-view/pcm-ydjpmx-glgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/editview/:editview?',
        meta: {
            caption: 'entities.pimdistirbution.views.editview.caption',
            imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-edit-view/pim-distirbution-edit-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/editview/:editview?',
        meta: {
            caption: 'entities.pimdistirbution.views.editview.caption',
            imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-edit-view/pim-distirbution-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/editview9/:editview9?',
        meta: {
            caption: 'entities.pimperson.views.editview9.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-edit-view9/pim-person-edit-view9.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/kddmpickupview/:kddmpickupview?',
        meta: {
            caption: 'entities.pimdistirbution.views.kddmpickupview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'kddmpickupview', parameterName: 'kddmpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-kddmpickup-view/pim-distirbution-kddmpickup-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/kddmpickupview/:kddmpickupview?',
        meta: {
            caption: 'entities.pimdistirbution.views.kddmpickupview.caption',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'kddmpickupview', parameterName: 'kddmpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-kddmpickup-view/pim-distirbution-kddmpickup-view.vue'),
    },
    {
        path: '/pcmydlzmxes/:pcmydlzmx?/glgridview/:glgridview?',
        meta: {
            caption: 'entities.pcmydlzmx.views.glgridview.caption',
            imgPath: '../../../img/pzgl/1/lizhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                { pathName: 'glgridview', parameterName: 'glgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydlzmx-glgrid-view/pcm-ydlzmx-glgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.caption',
            parameters: [
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/pcmydtxmxes/:pcmydtxmx?/ckeditview/:ckeditview?',
        meta: {
            caption: 'entities.pcmydtxmx.views.ckeditview.caption',
            parameters: [
                { pathName: 'pcmydtxmxes', parameterName: 'pcmydtxmx' },
                { pathName: 'ckeditview', parameterName: 'ckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydtxmx-ckedit-view/pcm-ydtxmx-ckedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.pickupview.caption',
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
            caption: 'entities.ormorgsector.views.pickupview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-orgsector-pickup-view/orm-orgsector-pickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.ormpost.views.pickupview.caption',
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
            caption: 'entities.ormpost.views.pickupview.caption',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-post-pickup-view/orm-post-pickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ydbmpickupview/:ydbmpickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.ydbmpickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ydbmpickupview', parameterName: 'ydbmpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-ydbmpickup-view/orm-orgsector-ydbmpickup-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ydbmpickupview/:ydbmpickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.ydbmpickupview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ydbmpickupview', parameterName: 'ydbmpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-ydbmpickup-view/orm-orgsector-ydbmpickup-view.vue'),
    },
    {
        path: '/pcmydjpmxes/:pcmydjpmx?/ckeditview/:ckeditview?',
        meta: {
            caption: 'entities.pcmydjpmx.views.ckeditview.caption',
            parameters: [
                { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                { pathName: 'ckeditview', parameterName: 'ckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjpmx-ckedit-view/pcm-ydjpmx-ckedit-view.vue'),
    },
    {
        path: '/pcmyddgmxes/:pcmyddgmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmyddgmx.views.editview9.caption',
            parameters: [
                { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-yddgmx-edit-view9/pcm-yddgmx-edit-view9.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormposts/:ormpost?/ejormorgidpickupgridview/:ejormorgidpickupgridview?',
        meta: {
            caption: 'entities.ormpost.views.ejormorgidpickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'ejormorgidpickupgridview', parameterName: 'ejormorgidpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-post-ejormorgidpickup-grid-view/orm-post-ejormorgidpickup-grid-view.vue'),
    },
    {
        path: '/ormposts/:ormpost?/ejormorgidpickupgridview/:ejormorgidpickupgridview?',
        meta: {
            caption: 'entities.ormpost.views.ejormorgidpickupgridview.caption',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'ejormorgidpickupgridview', parameterName: 'ejormorgidpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-post-ejormorgidpickup-grid-view/orm-post-ejormorgidpickup-grid-view.vue'),
    },
    {
        path: '/pcmydlzmxes/:pcmydlzmx?/lsjlgridview/:lsjlgridview?',
        meta: {
            caption: 'entities.pcmydlzmx.views.lsjlgridview.caption',
            imgPath: '../../../img/pzgl/1/lizhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                { pathName: 'lsjlgridview', parameterName: 'lsjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydlzmx-lsjlgrid-view/pcm-ydlzmx-lsjlgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/sjyxzzpickupgridview/:sjyxzzpickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.sjyxzzpickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'sjyxzzpickupgridview', parameterName: 'sjyxzzpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-org-sjyxzzpickup-grid-view/orm-org-sjyxzzpickup-grid-view.vue'),
    },
    {
        path: '/pcmydtxmxes/:pcmydtxmx?/jlgridview/:jlgridview?',
        meta: {
            caption: 'entities.pcmydtxmx.views.jlgridview.caption',
            imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydtxmxes', parameterName: 'pcmydtxmx' },
                { pathName: 'jlgridview', parameterName: 'jlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydtxmx-jlgrid-view/pcm-ydtxmx-jlgrid-view.vue'),
    },
    {
        path: '/pcmydntmxes/:pcmydntmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmydntmx.views.editview9.caption',
            parameters: [
                { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydntmx-edit-view9/pcm-ydntmx-edit-view9.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ydbmpickupgridview/:ydbmpickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.ydbmpickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ydbmpickupgridview', parameterName: 'ydbmpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-ydbmpickup-grid-view/orm-orgsector-ydbmpickup-grid-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/ydbmpickupgridview/:ydbmpickupgridview?',
        meta: {
            caption: 'entities.ormorgsector.views.ydbmpickupgridview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'ydbmpickupgridview', parameterName: 'ydbmpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-ydbmpickup-grid-view/orm-orgsector-ydbmpickup-grid-view.vue'),
    },
    {
        path: '/pcmyddgmxes/:pcmyddgmx?/ckeditview/:ckeditview?',
        meta: {
            caption: 'entities.pcmyddgmx.views.ckeditview.caption',
            parameters: [
                { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                { pathName: 'ckeditview', parameterName: 'ckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-yddgmx-ckedit-view/pcm-yddgmx-ckedit-view.vue'),
    },
    {
        path: '/pcmydntmxes/:pcmydntmx?/ntglgridview/:ntglgridview?',
        meta: {
            caption: 'entities.pcmydntmx.views.ntglgridview.caption',
            imgPath: '../../../img/pzgl/1/neituiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                { pathName: 'ntglgridview', parameterName: 'ntglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydntmx-ntglgrid-view/pcm-ydntmx-ntglgrid-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/xzeditview/:xzeditview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.xzeditview.caption',
            parameters: [
                { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                { pathName: 'xzeditview', parameterName: 'xzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydbxmx-xzedit-view/pcm-ydbxmx-xzedit-view.vue'),
    },
    {
        path: '/pcmydntmxes/:pcmydntmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydntmx.views.editview.caption',
            parameters: [
                { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydntmx-edit-view/pcm-ydntmx-edit-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/ckeditview/:ckeditview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.ckeditview.caption',
            parameters: [
                { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                { pathName: 'ckeditview', parameterName: 'ckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydbxmx-ckedit-view/pcm-ydbxmx-ckedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pimperson.views.pickupview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-pickup-view/pim-person-pickup-view.vue'),
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
        component: () => import('@pages/pcm/orm-org-pickup-grid-view/orm-org-pickup-grid-view.vue'),
    },
    {
        path: '/pcmydjzmxes/:pcmydjzmx?/xzeditview/:xzeditview?',
        meta: {
            caption: 'entities.pcmydjzmx.views.xzeditview.caption',
            parameters: [
                { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                { pathName: 'xzeditview', parameterName: 'xzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjzmx-xzedit-view/pcm-ydjzmx-xzedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/fpxxpickupgridview/:fpxxpickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.fpxxpickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'fpxxpickupgridview', parameterName: 'fpxxpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-org-fpxxpickup-grid-view/orm-org-fpxxpickup-grid-view.vue'),
    },
    {
        path: '/ormduties/:ormduty?/ormorgsectorpickupgridview/:ormorgsectorpickupgridview?',
        meta: {
            caption: 'entities.ormduty.views.ormorgsectorpickupgridview.caption',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'ormorgsectorpickupgridview', parameterName: 'ormorgsectorpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-duty-orm-org-sector-pickup-grid-view/orm-duty-orm-org-sector-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/kddpickupview/:kddpickupview?',
        meta: {
            caption: 'entities.pimdistirbution.views.kddpickupview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'kddpickupview', parameterName: 'kddpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-kddpickup-view/pim-distirbution-kddpickup-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/kddpickupview/:kddpickupview?',
        meta: {
            caption: 'entities.pimdistirbution.views.kddpickupview.caption',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'kddpickupview', parameterName: 'kddpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-distirbution-kddpickup-view/pim-distirbution-kddpickup-view.vue'),
    },
    {
        path: '/pcmyddgmxes/:pcmyddgmx?/dgjlgridview/:dgjlgridview?',
        meta: {
            caption: 'entities.pcmyddgmx.views.dgjlgridview.caption',
            imgPath: '../../../img/pzgl/1/daigangguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                { pathName: 'dgjlgridview', parameterName: 'dgjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-yddgmx-dgjlgrid-view/pcm-yddgmx-dgjlgrid-view.vue'),
    },
    {
        path: '/pcmydntmxes/:pcmydntmx?/ntjsrqqreditview/:ntjsrqqreditview?',
        meta: {
            caption: 'entities.pcmydntmx.views.ntjsrqqreditview.caption',
            parameters: [
                { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                { pathName: 'ntjsrqqreditview', parameterName: 'ntjsrqqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydntmx-ntjsrqqredit-view/pcm-ydntmx-ntjsrqqredit-view.vue'),
    },
    {
        path: '/pcmydntmxes/:pcmydntmx?/ntjlgridview/:ntjlgridview?',
        meta: {
            caption: 'entities.pcmydntmx.views.ntjlgridview.caption',
            imgPath: '../../../img/pzgl/1/neituiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                { pathName: 'ntjlgridview', parameterName: 'ntjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydntmx-ntjlgrid-view/pcm-ydntmx-ntjlgrid-view.vue'),
    },
    {
        path: '/pcmydjzmxes/:pcmydjzmx?/jlckeditview/:jlckeditview?',
        meta: {
            caption: 'entities.pcmydjzmx.views.jlckeditview.caption',
            parameters: [
                { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                { pathName: 'jlckeditview', parameterName: 'jlckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjzmx-jlckedit-view/pcm-ydjzmx-jlckedit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/fpxxpickupview/:fpxxpickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.fpxxpickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'fpxxpickupview', parameterName: 'fpxxpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-fpxxpickup-view/orm-orgsector-fpxxpickup-view.vue'),
    },
    {
        path: '/ormorgsectors/:ormorgsector?/fpxxpickupview/:fpxxpickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.fpxxpickupview.caption',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'fpxxpickupview', parameterName: 'fpxxpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-fpxxpickup-view/orm-orgsector-fpxxpickup-view.vue'),
    },
    {
        path: '/pcmyddgmxes/:pcmyddgmx?/xzeditview/:xzeditview?',
        meta: {
            caption: 'entities.pcmyddgmx.views.xzeditview.caption',
            parameters: [
                { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                { pathName: 'xzeditview', parameterName: 'xzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-yddgmx-xzedit-view/pcm-yddgmx-xzedit-view.vue'),
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
