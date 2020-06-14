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
            component: () => import('@pages/pcm/index/index.vue'),
            children: [
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
                    path: 'pcmydjzmxes/:pcmydjzmx?/lsjlgridview/:lsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.lsjlgridview.title',
                        info:'',
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
                    path: 'pcmjxszzkhjgjls/:pcmjxszzkhjgjl?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pcmjxszzkhjgjl.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmjxszzkhjgjls', parameterName: 'pcmjxszzkhjgjl' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxszzkhjgjl-pickup-view/pcm-jxszzkhjgjl-pickup-view.vue'),
                },
                {
                    path: 'pcmydjpmxes/:pcmydjpmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.editview9.title',
                        info:'',
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
                        caption: 'entities.pimdistirbution.views.kddmpickupview.title',
                        info:'',
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
                        caption: 'entities.pimdistirbution.views.kddmpickupview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pcmxygzzjlmxes/:pcmxygzzjlmx?/approvalgridview/:approvalgridview?',
                    meta: {
                        caption: 'entities.pcmxygzzjlmx.views.approvalgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                            { pathName: 'approvalgridview', parameterName: 'approvalgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzjlmx-approval-grid-view/pcm-xygzzjlmx-approval-grid-view.vue'),
                },
                {
                    path: 'pcmxygzzjlmxes/:pcmxygzzjlmx?/approvalgridview/:approvalgridview?',
                    meta: {
                        caption: 'entities.pcmxygzzjlmx.views.approvalgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                            { pathName: 'approvalgridview', parameterName: 'approvalgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzjlmx-approval-grid-view/pcm-xygzzjlmx-approval-grid-view.vue'),
                },
                {
                    path: 'pcmydbxmxes/:pcmydbxmx?/bxglgridview/:bxglgridview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.bxglgridview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/zzjlgridview/:zzjlgridview?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.zzjlgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/jianxiqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'zzjlgridview', parameterName: 'zzjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-zzjlgrid-view/pcm-jxsygzzjlmx-zzjlgrid-view.vue'),
                },
                {
                    path: 'pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/zzjlgridview/:zzjlgridview?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.zzjlgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/jianxiqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'zzjlgridview', parameterName: 'zzjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-zzjlgrid-view/pcm-jxsygzzjlmx-zzjlgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/yxzfppickupgridview/:yxzfppickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.yxzfppickupgridview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/yxzfppickupview/:yxzfppickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.yxzfppickupview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pimperson.views.editview9.title',
                        info:'',
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
                        caption: 'entities.ormduty.views.ormorgsectorpickupgridview.title',
                        info:'',
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
                    path: 'pcmxygzzkhjgjls/:pcmxygzzkhjgjl?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pcmxygzzkhjgjl.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxygzzkhjgjls', parameterName: 'pcmxygzzkhjgjl' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzkhjgjl-pickup-grid-view/pcm-xygzzkhjgjl-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/jtlxrpickupgridview/:jtlxrpickupgridview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.jtlxrpickupgridview.title',
                        info:'',
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
                        caption: 'entities.pimfaminfo.views.jtlxrpickupgridview.title',
                        info:'',
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
                    path: 'pcmydjpmxes/:pcmydjpmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.ckeditview.title',
                        info:'',
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
                    path: 'pcmydjzmxes/:pcmydjzmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.xzeditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/jxspickupview/:jxspickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.jxspickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'jxspickupview', parameterName: 'jxspickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-jxspickup-view/pim-person-jxspickup-view.vue'),
                },
                {
                    path: 'pcmydtxmxes/:pcmydtxmx?/jlgridview/:jlgridview?',
                    meta: {
                        caption: 'entities.pcmydtxmx.views.jlgridview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/kxzxygpickupgridview/:kxzxygpickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.kxzxygpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'kxzxygpickupgridview', parameterName: 'kxzxygpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-kxzxygpickup-grid-view/pim-person-kxzxygpickup-grid-view.vue'),
                },
                {
                    path: 'pcmyddgmxes/:pcmyddgmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.ckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydlzmx.views.editview9.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-edit-view/pcm-jxsygzzjlmx-edit-view.vue'),
                },
                {
                    path: 'pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-edit-view/pcm-jxsygzzjlmx-edit-view.vue'),
                },
                {
                    path: 'pcmydbxmxes/:pcmydbxmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.ckeditview.title',
                        info:'',
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
                    path: 'pcmydbxmxes/:pcmydbxmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.editview.title',
                        info:'',
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
                    component: () => import('@pages/pcm/orm-org-pickup-grid-view/orm-org-pickup-grid-view.vue'),
                },
                {
                    path: 'pcmydjpmxes/:pcmydjpmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.editview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddckeditview.title',
                        info:'',
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
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/ejormorgidpickupgridview/:ejormorgidpickupgridview?',
                    meta: {
                        caption: 'entities.ormpost.views.ejormorgidpickupgridview.title',
                        info:'',
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
                        caption: 'entities.ormpost.views.ejormorgidpickupgridview.title',
                        info:'',
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
                        caption: 'entities.pimperson.views.txglgridview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pcmxygzzjlmxes/:pcmxygzzjlmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmxygzzjlmx.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzjlmx-edit-view/pcm-xygzzjlmx-edit-view.vue'),
                },
                {
                    path: 'pcmxygzzjlmxes/:pcmxygzzjlmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmxygzzjlmx.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzjlmx-edit-view/pcm-xygzzjlmx-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/jtlxrpickupview/:jtlxrpickupview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.jtlxrpickupview.title',
                        info:'',
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
                        caption: 'entities.pimfaminfo.views.jtlxrpickupview.title',
                        info:'',
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
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ydbmpickupgridview/:ydbmpickupgridview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.ydbmpickupgridview.title',
                        info:'',
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
                        caption: 'entities.ormorgsector.views.ydbmpickupgridview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
                        info:'',
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
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
                        info:'',
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
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
                        info:'',
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
                    path: 'pcmydntmxes/:pcmydntmx?/ntjsrqqreditview/:ntjsrqqreditview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.ntjsrqqreditview.title',
                        info:'',
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
                        caption: 'entities.ormorg.views.fpxxpickupview.title',
                        info:'',
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
                    path: 'pcmydjzmxes/:pcmydjzmx?/glgridview/:glgridview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.glgridview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddeditview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddeditview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddeditview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddeditview.title',
                        info:'',
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
                    path: 'pcmydjzmxes/:pcmydjzmx?/jsrqqreditview/:jsrqqreditview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.jsrqqreditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/syjxeditview/:syjxeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.syjxeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'syjxeditview', parameterName: 'syjxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-person-syjxedit-view/pim-person-syjxedit-view.vue'),
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
                    component: () => import('@pages/pcm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
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
                    component: () => import('@pages/pcm/orm-orgsector-pickup-grid-view/orm-orgsector-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/kddpickupview/:kddpickupview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.kddpickupview.title',
                        info:'',
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
                        caption: 'entities.pimdistirbution.views.kddpickupview.title',
                        info:'',
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
                        caption: 'entities.pcmydntmx.views.ntglgridview.title',
                        info:'',
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
                        caption: 'entities.ormorg.views.sjyxzzpickupview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.xzeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'xzeditview', parameterName: 'xzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-xzedit-view/pcm-jxsygzzjlmx-xzedit-view.vue'),
                },
                {
                    path: 'pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.xzeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'xzeditview', parameterName: 'xzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-xzedit-view/pcm-jxsygzzjlmx-xzedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/approavlgridview/:approavlgridview?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.approavlgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'approavlgridview', parameterName: 'approavlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-approavl-grid-view/pcm-jxsygzzjlmx-approavl-grid-view.vue'),
                },
                {
                    path: 'pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/approavlgridview/:approavlgridview?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.approavlgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'approavlgridview', parameterName: 'approavlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-approavl-grid-view/pcm-jxsygzzjlmx-approavl-grid-view.vue'),
                },
                {
                    path: 'pcmydlzmxes/:pcmydlzmx?/lsjlgridview/:lsjlgridview?',
                    meta: {
                        caption: 'entities.pcmydlzmx.views.lsjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.editview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.editview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.editview.title',
                        info:'',
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
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.editview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.editview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.editview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.editview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.editview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.editview.title',
                        info:'',
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
                    path: 'pcmjxszzkhjgjls/:pcmjxszzkhjgjl?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pcmjxszzkhjgjl.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmjxszzkhjgjls', parameterName: 'pcmjxszzkhjgjl' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxszzkhjgjl-pickup-grid-view/pcm-jxszzkhjgjl-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/kxzxygpickupview/:kxzxygpickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.kxzxygpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'kxzxygpickupview', parameterName: 'kxzxygpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-kxzxygpickup-view/pim-person-kxzxygpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.editview.title',
                        info:'',
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
                        caption: 'entities.pimdistirbution.views.editview.title',
                        info:'',
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
                        caption: 'entities.pcmydjzmx.views.editview9.title',
                        info:'',
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
                    path: 'pcmydntmxes/:pcmydntmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.editview.title',
                        info:'',
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
                    path: 'pcmydntmxes/:pcmydntmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.xzeditview.title',
                        info:'',
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
                    path: 'ormorgs/:ormorg?/ormposts/:ormpost?/ejormorgidpickupview/:ejormorgidpickupview?',
                    meta: {
                        caption: 'entities.ormpost.views.ejormorgidpickupview.title',
                        info:'',
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
                        caption: 'entities.ormpost.views.ejormorgidpickupview.title',
                        info:'',
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
                    path: 'pcmydjpmxes/:pcmydjpmx?/jpjlgridview/:jpjlgridview?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.jpjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjpmx.views.glgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
                        info:'',
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
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
                        info:'',
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
                        caption: 'entities.pcmyddgmx.views.dgjlgridview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pcmxygzzjlmxes/:pcmxygzzjlmx?/syqzzjlgridview/:syqzzjlgridview?',
                    meta: {
                        caption: 'entities.pcmxygzzjlmx.views.syqzzjlgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/shiyongqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                            { pathName: 'syqzzjlgridview', parameterName: 'syqzzjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzjlmx-syqzzjlgrid-view/pcm-xygzzjlmx-syqzzjlgrid-view.vue'),
                },
                {
                    path: 'pcmxygzzjlmxes/:pcmxygzzjlmx?/syqzzjlgridview/:syqzzjlgridview?',
                    meta: {
                        caption: 'entities.pcmxygzzjlmx.views.syqzzjlgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/shiyongqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                            { pathName: 'syqzzjlgridview', parameterName: 'syqzzjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzjlmx-syqzzjlgrid-view/pcm-xygzzjlmx-syqzzjlgrid-view.vue'),
                },
                {
                    path: 'pcmydjzmxes/:pcmydjzmx?/jlckeditview/:jlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjzmx.views.jlckeditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/txqreditview/:txqreditview?',
                    meta: {
                        caption: 'entities.pimperson.views.txqreditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdglgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdglgridview.title',
                        info:'',
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
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdglgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdglgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdglgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdglgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdglgridview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdglgridview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-edit-view9/pcm-jxsygzzjlmx-edit-view9.vue'),
                },
                {
                    path: 'pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmjxsygzzjlmx.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-jxsygzzjlmx-edit-view9/pcm-jxsygzzjlmx-edit-view9.vue'),
                },
                {
                    path: 'pcmydlzmxes/:pcmydlzmx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmydlzmx.views.editview.title',
                        info:'',
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
                    path: 'pcmydjpmxes/:pcmydjpmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydjpmx.views.xzeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydbxmx.views.editview9.title',
                        info:'',
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
                        caption: 'entities.ormorgsector.views.fpxxpickupview.title',
                        info:'',
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
                        caption: 'entities.ormorgsector.views.fpxxpickupview.title',
                        info:'',
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
                        caption: 'entities.ormorgsector.views.fpxxpickupgridview.title',
                        info:'',
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
                        caption: 'entities.ormorgsector.views.fpxxpickupgridview.title',
                        info:'',
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
                    component: () => import('@pages/pcm/pim-person-pickup-view/pim-person-pickup-view.vue'),
                },
                {
                    path: 'pcmydlzmxes/:pcmydlzmx?/glgridview/:glgridview?',
                    meta: {
                        caption: 'entities.pcmydlzmx.views.glgridview.title',
                        info:'',
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
                        caption: 'entities.ormorg.views.sjyxzzpickupgridview.title',
                        info:'',
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
                    path: 'pcmydlzmxes/:pcmydlzmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydlzmx.views.xzeditview.title',
                        info:'',
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
                        caption: 'entities.ormorg.views.pickupview.title',
                        info:'',
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
                        caption: 'entities.ormduty.views.ormorgsectorpickupview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/sqjxqzzgridview/:sqjxqzzgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.sqjxqzzgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/jianxiqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'sqjxqzzgridview', parameterName: 'sqjxqzzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-sqjxqzzgrid-view/pim-person-sqjxqzzgrid-view.vue'),
                },
                {
                    path: 'pcmyddgmxes/:pcmyddgmx?/dgglgridview/:dgglgridview?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.dgglgridview.title',
                        info:'',
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
                    path: 'pcmydbxmxes/:pcmydbxmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.xzeditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/jxqpickupgridview/:jxqpickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.jxqpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'jxqpickupgridview', parameterName: 'jxqpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-jxqpickup-grid-view/pim-person-jxqpickup-grid-view.vue'),
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
                    path: 'ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ydbmpickupview/:ydbmpickupview?',
                    meta: {
                        caption: 'entities.ormorgsector.views.ydbmpickupview.title',
                        info:'',
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
                        caption: 'entities.ormorgsector.views.ydbmpickupview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/txryeditview/:txryeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.txryeditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/ddmgrgridview/:ddmgrgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.ddmgrgridview.title',
                        info:'',
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
                        caption: 'entities.pimdistirbution.views.ddmgrgridview.title',
                        info:'',
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
                    path: 'pcmydntmxes/:pcmydntmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.ckeditview.title',
                        info:'',
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
                    component: () => import('@pages/pcm/pim-person-pickup-grid-view/pim-person-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
                        info:'',
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
                    path: 'pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
                    meta: {
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
                        info:'',
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
                        caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
                        info:'',
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
                    path: 'pcmydntmxes/:pcmydntmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.editview9.title',
                        info:'',
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
                    path: 'pcmxygzzkhjgjls/:pcmxygzzkhjgjl?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pcmxygzzkhjgjl.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxygzzkhjgjls', parameterName: 'pcmxygzzkhjgjl' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzkhjgjl-pickup-view/pcm-xygzzkhjgjl-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/kddfppickupgridview/:kddfppickupgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.kddfppickupgridview.title',
                        info:'',
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
                        caption: 'entities.pimdistirbution.views.kddfppickupgridview.title',
                        info:'',
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
                    path: 'pcmydntmxes/:pcmydntmx?/ntjlgridview/:ntjlgridview?',
                    meta: {
                        caption: 'entities.pcmydntmx.views.ntjlgridview.title',
                        info:'',
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
                    path: 'pcmyddgmxes/:pcmyddgmx?/xzeditview/:xzeditview?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.xzeditview.title',
                        info:'',
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
                    path: 'ormorgs/:ormorg?/fpxxpickupgridview/:fpxxpickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.fpxxpickupgridview.title',
                        info:'',
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
                    path: 'pcmydtxmxes/:pcmydtxmx?/ckeditview/:ckeditview?',
                    meta: {
                        caption: 'entities.pcmydtxmx.views.ckeditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddjlgridview/:ddjlgridview?',
                    meta: {
                        caption: 'entities.pcmddsqdmx.views.ddjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddjlgridview.title',
                        info:'',
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
                        caption: 'entities.pcmddsqdmx.views.ddjlgridview.title',
                        info:'',
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
                    path: 'pcmyddgmxes/:pcmyddgmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.editview9.title',
                        info:'',
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
                        caption: 'entities.pcmydbxmx.views.jlgridview.title',
                        info:'',
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
                    path: 'pcmydbxmxes/:pcmydbxmx?/bxjsrqqreditview/:bxjsrqqreditview?',
                    meta: {
                        caption: 'entities.pcmydbxmx.views.bxjsrqqreditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/pcmxygzzjlmxes/:pcmxygzzjlmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmxygzzjlmx.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzjlmx-edit-view9/pcm-xygzzjlmx-edit-view9.vue'),
                },
                {
                    path: 'pcmxygzzjlmxes/:pcmxygzzjlmx?/editview9/:editview9?',
                    meta: {
                        caption: 'entities.pcmxygzzjlmx.views.editview9.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                            { pathName: 'editview9', parameterName: 'editview9' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-xygzzjlmx-edit-view9/pcm-xygzzjlmx-edit-view9.vue'),
                },
                {
                    path: 'pcmyddgmxes/:pcmyddgmx?/jsrqqreditview/:jsrqqreditview?',
                    meta: {
                        caption: 'entities.pcmyddgmx.views.jsrqqreditview.title',
                        info:'',
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
                    path: 'pimpeople/:pimperson?/sqsyqzzgridview/:sqsyqzzgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.sqsyqzzgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/shiyongqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'sqsyqzzgridview', parameterName: 'sqsyqzzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pim-person-sqsyqzzgrid-view/pim-person-sqsyqzzgrid-view.vue'),
                },
            {
                path: 'pcmydjpmxredirectview/:pcmydjpmxredirectview?',
                meta: {
                    caption: 'entities.pcmydjpmx.views.redirectview.title',
                    info:'',
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
                    caption: 'entities.pcmyddgmx.views.redirectview.title',
                    info:'',
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
                    caption: 'entities.pcmydlzmx.views.redirectview.title',
                    info:'',
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
                    caption: 'entities.pimdistirbution.views.redirectview.title',
                    info:'',
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
                    caption: 'entities.pcmydtxmx.views.redirectview.title',
                    info:'',
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
                    caption: 'entities.pcmydbxmx.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pcmydbxmxredirectview', parameterName: 'pcmydbxmxredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-ydbxmx-redirect-view/pcm-ydbxmx-redirect-view.vue'),
            },
            {
                path: 'pcmxygzzsqredirectview/:pcmxygzzsqredirectview?',
                meta: {
                    caption: 'entities.pcmxygzzsq.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pcmxygzzsqredirectview', parameterName: 'pcmxygzzsqredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pcm/pcm-xygzzsq-redirect-view/pcm-xygzzsq-redirect-view.vue'),
            },
            {
                path: 'pcmydntmxredirectview/:pcmydntmxredirectview?',
                meta: {
                    caption: 'entities.pcmydntmx.views.redirectview.title',
                    info:'',
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
                    caption: 'entities.pcmydjdmx.views.redirectview.title',
                    info:'',
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
                    caption: 'entities.pcmydgzmx.views.redirectview.title',
                    info:'',
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
                    caption: 'entities.pcmydjzmx.views.redirectview.title',
                    info:'',
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
            caption: 'entities.ormorg.views.sjyxzzpickupview.title',
            info:'',
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
            caption: 'entities.pcmydjpmx.views.jpjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydntmx.views.ckeditview.title',
            info:'',
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
            caption: 'entities.pcmydlzmx.views.xzeditview.title',
            info:'',
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
            caption: 'entities.pcmydjzmx.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjzmx-edit-view9/pcm-ydjzmx-edit-view9.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/syjxeditview/:syjxeditview?',
        meta: {
            caption: 'entities.pimperson.views.syjxeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'syjxeditview', parameterName: 'syjxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-person-syjxedit-view/pim-person-syjxedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/jtlxrpickupview/:jtlxrpickupview?',
        meta: {
            caption: 'entities.pimfaminfo.views.jtlxrpickupview.title',
            info:'',
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
            caption: 'entities.pimfaminfo.views.jtlxrpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'jtlxrpickupview', parameterName: 'jtlxrpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-faminfo-jtlxrpickup-view/pim-faminfo-jtlxrpickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmxygzzjlmxes/:pcmxygzzjlmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmxygzzjlmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzjlmx-edit-view/pcm-xygzzjlmx-edit-view.vue'),
    },
    {
        path: '/pcmxygzzjlmxes/:pcmxygzzjlmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmxygzzjlmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzjlmx-edit-view/pcm-xygzzjlmx-edit-view.vue'),
    },
    {
        path: '/pcmydjpmxes/:pcmydjpmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjpmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydlzmx.views.editview9.title',
            info:'',
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
        path: '/pcmyddgmxes/:pcmyddgmx?/jsrqqreditview/:jsrqqreditview?',
        meta: {
            caption: 'entities.pcmyddgmx.views.jsrqqreditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
            info:'',
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
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjsqreditview/:jdjsqreditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjsqreditview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddjlgridview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddjlgridview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddjlgridview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
            info:'',
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
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdlsjlgridview/:jdlsjlgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdlsjlgridview.title',
            info:'',
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
            caption: 'entities.pimperson.views.yxzfppickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'yxzfppickupview', parameterName: 'yxzfppickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-yxzfppickup-view/pim-person-yxzfppickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/xzeditview/:xzeditview?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.xzeditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'xzeditview', parameterName: 'xzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-xzedit-view/pcm-jxsygzzjlmx-xzedit-view.vue'),
    },
    {
        path: '/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/xzeditview/:xzeditview?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.xzeditview.title',
            info:'',
            parameters: [
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'xzeditview', parameterName: 'xzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-xzedit-view/pcm-jxsygzzjlmx-xzedit-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/bxjsrqqreditview/:bxjsrqqreditview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.bxjsrqqreditview.title',
            info:'',
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
            caption: 'entities.ormduty.views.ormorgsectorpickupview.title',
            info:'',
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
            caption: 'entities.ormorg.views.fpxxpickupview.title',
            info:'',
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
            caption: 'entities.ormpost.views.ejormorgidpickupview.title',
            info:'',
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
            caption: 'entities.ormpost.views.ejormorgidpickupview.title',
            info:'',
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
            caption: 'entities.pimperson.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-pickup-grid-view/pim-person-pickup-grid-view.vue'),
    },
    {
        path: '/pcmjxszzkhjgjls/:pcmjxszzkhjgjl?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pcmjxszzkhjgjl.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pcmjxszzkhjgjls', parameterName: 'pcmjxszzkhjgjl' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxszzkhjgjl-pickup-grid-view/pcm-jxszzkhjgjl-pickup-grid-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/bxglgridview/:bxglgridview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.bxglgridview.title',
            info:'',
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
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmddsqdmxes/:pcmddsqdmx?/ddckeditview/:ddckeditview?',
        meta: {
            caption: 'entities.pcmddsqdmx.views.ddckeditview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddckeditview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddckeditview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddckeditview.title',
            info:'',
            parameters: [
                { pathName: 'pcmddsqdmxes', parameterName: 'pcmddsqdmx' },
                { pathName: 'ddckeditview', parameterName: 'ddckeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ddsqdmx-ddckedit-view/pcm-ddsqdmx-ddckedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmxygzzjlmxes/:pcmxygzzjlmx?/syqzzjlgridview/:syqzzjlgridview?',
        meta: {
            caption: 'entities.pcmxygzzjlmx.views.syqzzjlgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/shiyongqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                { pathName: 'syqzzjlgridview', parameterName: 'syqzzjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzjlmx-syqzzjlgrid-view/pcm-xygzzjlmx-syqzzjlgrid-view.vue'),
    },
    {
        path: '/pcmxygzzjlmxes/:pcmxygzzjlmx?/syqzzjlgridview/:syqzzjlgridview?',
        meta: {
            caption: 'entities.pcmxygzzjlmx.views.syqzzjlgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/shiyongqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                { pathName: 'syqzzjlgridview', parameterName: 'syqzzjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzjlmx-syqzzjlgrid-view/pcm-xygzzjlmx-syqzzjlgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/kxzxygpickupview/:kxzxygpickupview?',
        meta: {
            caption: 'entities.pimperson.views.kxzxygpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'kxzxygpickupview', parameterName: 'kxzxygpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-kxzxygpickup-view/pim-person-kxzxygpickup-view.vue'),
    },
    {
        path: '/pcmydjzmxes/:pcmydjzmx?/jsrqqreditview/:jsrqqreditview?',
        meta: {
            caption: 'entities.pcmydjzmx.views.jsrqqreditview.title',
            info:'',
            parameters: [
                { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                { pathName: 'jsrqqreditview', parameterName: 'jsrqqreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjzmx-jsrqqredit-view/pcm-ydjzmx-jsrqqredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/zzjlgridview/:zzjlgridview?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.zzjlgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/jianxiqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'zzjlgridview', parameterName: 'zzjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-zzjlgrid-view/pcm-jxsygzzjlmx-zzjlgrid-view.vue'),
    },
    {
        path: '/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/zzjlgridview/:zzjlgridview?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.zzjlgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/jianxiqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'zzjlgridview', parameterName: 'zzjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-zzjlgrid-view/pcm-jxsygzzjlmx-zzjlgrid-view.vue'),
    },
    {
        path: '/pcmydjpmxes/:pcmydjpmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmydjpmx.views.editview9.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddeditview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddeditview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddeditview.title',
            info:'',
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
            caption: 'entities.pcmddsqdmx.views.ddeditview.title',
            info:'',
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
            caption: 'entities.pimperson.views.txglgridview.title',
            info:'',
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
        path: '/pcmxygzzkhjgjls/:pcmxygzzkhjgjl?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pcmxygzzkhjgjl.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pcmxygzzkhjgjls', parameterName: 'pcmxygzzkhjgjl' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzkhjgjl-pickup-view/pcm-xygzzkhjgjl-pickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/ddmgrgridview/:ddmgrgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.ddmgrgridview.title',
            info:'',
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
            caption: 'entities.pimdistirbution.views.ddmgrgridview.title',
            info:'',
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
            caption: 'entities.pcmydjzmx.views.glgridview.title',
            info:'',
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
            caption: 'entities.pcmydjzmx.views.lsjlgridview.title',
            info:'',
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
        path: '/pimpeople/:pimperson?/kxzxygpickupgridview/:kxzxygpickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.kxzxygpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'kxzxygpickupgridview', parameterName: 'kxzxygpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-kxzxygpickup-grid-view/pim-person-kxzxygpickup-grid-view.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
            info:'',
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
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdjlckeditview/:jdjlckeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdjlckeditview.title',
            info:'',
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
            caption: 'entities.pcmydbxmx.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydbxmx-edit-view9/pcm-ydbxmx-edit-view9.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmxygzzjlmxes/:pcmxygzzjlmx?/approvalgridview/:approvalgridview?',
        meta: {
            caption: 'entities.pcmxygzzjlmx.views.approvalgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                { pathName: 'approvalgridview', parameterName: 'approvalgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzjlmx-approval-grid-view/pcm-xygzzjlmx-approval-grid-view.vue'),
    },
    {
        path: '/pcmxygzzjlmxes/:pcmxygzzjlmx?/approvalgridview/:approvalgridview?',
        meta: {
            caption: 'entities.pcmxygzzjlmx.views.approvalgridview.title',
            info:'',
            parameters: [
                { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                { pathName: 'approvalgridview', parameterName: 'approvalgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzjlmx-approval-grid-view/pcm-xygzzjlmx-approval-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/kddfppickupgridview/:kddfppickupgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.kddfppickupgridview.title',
            info:'',
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
            caption: 'entities.pimdistirbution.views.kddfppickupgridview.title',
            info:'',
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
            caption: 'entities.pcmydlzmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydlzmx-edit-view/pcm-ydlzmx-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/approavlgridview/:approavlgridview?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.approavlgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'approavlgridview', parameterName: 'approavlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-approavl-grid-view/pcm-jxsygzzjlmx-approavl-grid-view.vue'),
    },
    {
        path: '/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/approavlgridview/:approavlgridview?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.approavlgridview.title',
            info:'',
            parameters: [
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'approavlgridview', parameterName: 'approavlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-approavl-grid-view/pcm-jxsygzzjlmx-approavl-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-edit-view/pcm-jxsygzzjlmx-edit-view.vue'),
    },
    {
        path: '/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-edit-view/pcm-jxsygzzjlmx-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdglgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdglgridview.title',
            info:'',
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
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.jdglgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdglgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdglgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdglgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdglgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.jdglgridview.title',
            info:'',
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
        path: '/pcmjxszzkhjgjls/:pcmjxszzkhjgjl?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pcmjxszzkhjgjl.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pcmjxszzkhjgjls', parameterName: 'pcmjxszzkhjgjl' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxszzkhjgjl-pickup-view/pcm-jxszzkhjgjl-pickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/jtlxrpickupgridview/:jtlxrpickupgridview?',
        meta: {
            caption: 'entities.pimfaminfo.views.jtlxrpickupgridview.title',
            info:'',
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
            caption: 'entities.pimfaminfo.views.jtlxrpickupgridview.title',
            info:'',
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
            caption: 'entities.pimperson.views.yxzfppickupgridview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
            info:'',
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
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/ydmxeditview/:ydmxeditview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.ydmxeditview.title',
            info:'',
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
            caption: 'entities.pcmydjpmx.views.xzeditview.title',
            info:'',
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
            caption: 'entities.pimperson.views.txryeditview.title',
            info:'',
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
        path: '/pimpeople/:pimperson?/txqreditview/:txqreditview?',
        meta: {
            caption: 'entities.pimperson.views.txqreditview.title',
            info:'',
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
            caption: 'entities.ormorg.views.pickupview.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.pickupgridview.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.pickupgridview.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.fpxxpickupgridview.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.fpxxpickupgridview.title',
            info:'',
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
            caption: 'entities.pcmyddgmx.views.dgglgridview.title',
            info:'',
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
        path: '/pimpeople/:pimperson?/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-edit-view9/pcm-jxsygzzjlmx-edit-view9.vue'),
    },
    {
        path: '/pcmjxsygzzjlmxes/:pcmjxsygzzjlmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmjxsygzzjlmx.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'pcmjxsygzzjlmxes', parameterName: 'pcmjxsygzzjlmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-jxsygzzjlmx-edit-view9/pcm-jxsygzzjlmx-edit-view9.vue'),
    },
    {
        path: '/pcmydbxmxes/:pcmydbxmx?/jlgridview/:jlgridview?',
        meta: {
            caption: 'entities.pcmydbxmx.views.jlgridview.title',
            info:'',
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
            caption: 'entities.pcmydntmx.views.xzeditview.title',
            info:'',
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
            caption: 'entities.pcmydjpmx.views.glgridview.title',
            info:'',
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
            caption: 'entities.pimdistirbution.views.editview.title',
            info:'',
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
            caption: 'entities.pimdistirbution.views.editview.title',
            info:'',
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
            caption: 'entities.pimperson.views.editview9.title',
            info:'',
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
            caption: 'entities.pimdistirbution.views.kddmpickupview.title',
            info:'',
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
            caption: 'entities.pimdistirbution.views.kddmpickupview.title',
            info:'',
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
            caption: 'entities.pcmydlzmx.views.glgridview.title',
            info:'',
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
        path: '/pimpeople/:pimperson?/pcmxygzzjlmxes/:pcmxygzzjlmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmxygzzjlmx.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzjlmx-edit-view9/pcm-xygzzjlmx-edit-view9.vue'),
    },
    {
        path: '/pcmxygzzjlmxes/:pcmxygzzjlmx?/editview9/:editview9?',
        meta: {
            caption: 'entities.pcmxygzzjlmx.views.editview9.title',
            info:'',
            parameters: [
                { pathName: 'pcmxygzzjlmxes', parameterName: 'pcmxygzzjlmx' },
                { pathName: 'editview9', parameterName: 'editview9' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzjlmx-edit-view9/pcm-xygzzjlmx-edit-view9.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.editview.title',
            info:'',
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
        path: '/pimdistirbutions/:pimdistirbution?/pcmydjdmxes/:pcmydjdmx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmydjdmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydjdmx.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-ydjdmx-edit-view/pcm-ydjdmx-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/jxqpickupgridview/:jxqpickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.jxqpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'jxqpickupgridview', parameterName: 'jxqpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-jxqpickup-grid-view/pim-person-jxqpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/jxspickupview/:jxspickupview?',
        meta: {
            caption: 'entities.pimperson.views.jxspickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'jxspickupview', parameterName: 'jxspickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-jxspickup-view/pim-person-jxspickup-view.vue'),
    },
    {
        path: '/pcmydtxmxes/:pcmydtxmx?/ckeditview/:ckeditview?',
        meta: {
            caption: 'entities.pcmydtxmx.views.ckeditview.title',
            info:'',
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
        path: '/ormorgs/:ormorg?/ormorgsectors/:ormorgsector?/ydbmpickupview/:ydbmpickupview?',
        meta: {
            caption: 'entities.ormorgsector.views.ydbmpickupview.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.ydbmpickupview.title',
            info:'',
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
            caption: 'entities.pcmydjpmx.views.ckeditview.title',
            info:'',
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
            caption: 'entities.pcmyddgmx.views.editview9.title',
            info:'',
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
            caption: 'entities.ormpost.views.ejormorgidpickupgridview.title',
            info:'',
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
            caption: 'entities.ormpost.views.ejormorgidpickupgridview.title',
            info:'',
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
            caption: 'entities.pcmydlzmx.views.lsjlgridview.title',
            info:'',
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
            caption: 'entities.ormorg.views.sjyxzzpickupgridview.title',
            info:'',
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
            caption: 'entities.pcmydtxmx.views.jlgridview.title',
            info:'',
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
            caption: 'entities.pcmydntmx.views.editview9.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.ydbmpickupgridview.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.ydbmpickupgridview.title',
            info:'',
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
            caption: 'entities.pcmyddgmx.views.ckeditview.title',
            info:'',
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
            caption: 'entities.pcmydntmx.views.ntglgridview.title',
            info:'',
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
            caption: 'entities.pcmydbxmx.views.xzeditview.title',
            info:'',
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
            caption: 'entities.pcmydntmx.views.editview.title',
            info:'',
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
            caption: 'entities.pcmydbxmx.views.ckeditview.title',
            info:'',
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
            caption: 'entities.pimperson.views.pickupview.title',
            info:'',
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
            caption: 'entities.ormorg.views.pickupgridview.title',
            info:'',
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
            caption: 'entities.pcmydjzmx.views.xzeditview.title',
            info:'',
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
            caption: 'entities.ormorg.views.fpxxpickupgridview.title',
            info:'',
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
            caption: 'entities.ormduty.views.ormorgsectorpickupgridview.title',
            info:'',
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
            caption: 'entities.pimdistirbution.views.kddpickupview.title',
            info:'',
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
            caption: 'entities.pimdistirbution.views.kddpickupview.title',
            info:'',
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
            caption: 'entities.pcmyddgmx.views.dgjlgridview.title',
            info:'',
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
            caption: 'entities.pcmydntmx.views.ntjsrqqreditview.title',
            info:'',
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
            caption: 'entities.pcmydntmx.views.ntjlgridview.title',
            info:'',
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
        path: '/pimpeople/:pimperson?/sqjxqzzgridview/:sqjxqzzgridview?',
        meta: {
            caption: 'entities.pimperson.views.sqjxqzzgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/jianxiqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'sqjxqzzgridview', parameterName: 'sqjxqzzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-sqjxqzzgrid-view/pim-person-sqjxqzzgrid-view.vue'),
    },
    {
        path: '/pcmydjzmxes/:pcmydjzmx?/jlckeditview/:jlckeditview?',
        meta: {
            caption: 'entities.pcmydjzmx.views.jlckeditview.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.fpxxpickupview.title',
            info:'',
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
            caption: 'entities.ormorgsector.views.fpxxpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
                { pathName: 'fpxxpickupview', parameterName: 'fpxxpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/orm-orgsector-fpxxpickup-view/orm-orgsector-fpxxpickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/sqsyqzzgridview/:sqsyqzzgridview?',
        meta: {
            caption: 'entities.pimperson.views.sqsyqzzgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/shiyongqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'sqsyqzzgridview', parameterName: 'sqsyqzzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pim-person-sqsyqzzgrid-view/pim-person-sqsyqzzgrid-view.vue'),
    },
    {
        path: '/pcmyddgmxes/:pcmyddgmx?/xzeditview/:xzeditview?',
        meta: {
            caption: 'entities.pcmyddgmx.views.xzeditview.title',
            info:'',
            parameters: [
                { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                { pathName: 'xzeditview', parameterName: 'xzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-yddgmx-xzedit-view/pcm-yddgmx-xzedit-view.vue'),
    },
    {
        path: '/pcmxygzzkhjgjls/:pcmxygzzkhjgjl?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pcmxygzzkhjgjl.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pcmxygzzkhjgjls', parameterName: 'pcmxygzzkhjgjl' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-xygzzkhjgjl-pickup-grid-view/pcm-xygzzkhjgjl-pickup-grid-view.vue'),
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
