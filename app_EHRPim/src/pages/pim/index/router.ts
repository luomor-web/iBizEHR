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
            component: () => import('@pages/pim/index/index.vue'),
            children: [
                {
                    path: 'pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/readeditview/:readeditview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.readeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'readeditview', parameterName: 'readeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangeread-edit-view/pimpersonchangeread-edit-view.vue'),
                },
                {
                    path: 'pimpersonchanges/:pimpersonchange?/readeditview/:readeditview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.readeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'readeditview', parameterName: 'readeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangeread-edit-view/pimpersonchangeread-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/pimdangagridview/:pimdangagridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.pimdangagridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimdangagridview', parameterName: 'pimdangagridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivespim-danga-grid-view/pimarchivespim-danga-grid-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/pimdangagridview/:pimdangagridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.pimdangagridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimdangagridview', parameterName: 'pimdangagridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivespim-danga-grid-view/pimarchivespim-danga-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimachievements/:pimachievements?/pimjixgridview/:pimjixgridview?',
                    meta: {
                        caption: 'entities.pimachievements.views.pimjixgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimachievements', parameterName: 'pimachievements' },
                            { pathName: 'pimjixgridview', parameterName: 'pimjixgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimachievementspim-jix-grid-view/pimachievementspim-jix-grid-view.vue'),
                },
                {
                    path: 'pimachievements/:pimachievements?/pimjixgridview/:pimjixgridview?',
                    meta: {
                        caption: 'entities.pimachievements.views.pimjixgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimachievements', parameterName: 'pimachievements' },
                            { pathName: 'pimjixgridview', parameterName: 'pimjixgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimachievementspim-jix-grid-view/pimachievementspim-jix-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/honorgridview/:honorgridview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.honorgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'honorgridview', parameterName: 'honorgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimrewardpunishmenthonorgrid-view/pimrewardpunishmenthonorgrid-view.vue'),
                },
                {
                    path: 'pimrewardpunishments/:pimrewardpunishment?/honorgridview/:honorgridview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.honorgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'honorgridview', parameterName: 'honorgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimrewardpunishmenthonorgrid-view/pimrewardpunishmenthonorgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/editview2/:editview2?',
                    meta: {
                        caption: 'entities.pimperson.views.editview2.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'editview2', parameterName: 'editview2' },
                        ],
                        requireAuth: false,
                    },
                    component: () => import('@pages/pim/pimpersonedit-view2/pimpersonedit-view2.vue'),
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
                    component: () => import('@pages/pim/pimpersonpickup-view/pimpersonpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimtitles/:pimtitle?/pimzhicgridview/:pimzhicgridview?',
                    meta: {
                        caption: 'entities.pimtitle.views.pimzhicgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunjihua.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'pimzhicgridview', parameterName: 'pimzhicgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlepim-zhic-grid-view/pimtitlepim-zhic-grid-view.vue'),
                },
                {
                    path: 'pimtitles/:pimtitle?/pimzhicgridview/:pimzhicgridview?',
                    meta: {
                        caption: 'entities.pimtitle.views.pimzhicgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunjihua.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'pimzhicgridview', parameterName: 'pimzhicgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlepim-zhic-grid-view/pimtitlepim-zhic-grid-view.vue'),
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
                    component: () => import('@pages/orm/ormdutyorm-org-sector-pickup-grid-view/ormdutyorm-org-sector-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/signremindgridview/:signremindgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.signremindgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'signremindgridview', parameterName: 'signremindgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractsign-remind-grid-view/pimcontractsign-remind-grid-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/signremindgridview/:signremindgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.signremindgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'signremindgridview', parameterName: 'signremindgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractsign-remind-grid-view/pimcontractsign-remind-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimtitles/:pimtitle?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimtitle.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunjihua.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlegrid-view/pimtitlegrid-view.vue'),
                },
                {
                    path: 'pimtitles/:pimtitle?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimtitle.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunjihua.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlegrid-view/pimtitlegrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.pimcontract.views.treeexpview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontracttree-exp-view/pimcontracttree-exp-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.pimcontract.views.treeexpview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontracttree-exp-view/pimcontracttree-exp-view.vue'),
                },
                {
                    path: 'pimlabourcampanies/:pimlabourcampany?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimlabourcampany.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/laowupaiqiangongsiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimlabourcampanygrid-view/pimlabourcampanygrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchivesloanandreturns/:pimarchivesloanandreturn?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarchivesloanandreturn.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/pimarchivesloanandreturns/:pimarchivesloanandreturn?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarchivesloanandreturn.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
                },
                {
                    path: 'pimarchivesloanandreturns/:pimarchivesloanandreturn?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarchivesloanandreturn.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.pimarchives.views.treeexpview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivestree-exp-view/pimarchivestree-exp-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.pimarchives.views.treeexpview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivestree-exp-view/pimarchivestree-exp-view.vue'),
                },
                {
                    path: 'pimcontracttypes/:pimcontracttype?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimcontracttype.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongleixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracttypes', parameterName: 'pimcontracttype' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontracttypeedit-view/pimcontracttypeedit-view.vue'),
                },
                {
                    path: 'pimqualmajors/:pimqualmajor?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimqualmajor.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunkecheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimqualmajoredit-view/pimqualmajoredit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/pimjanglgridview/:pimjanglgridview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.pimjanglgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'pimjanglgridview', parameterName: 'pimjanglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimrewardpunishmentpim-jangl-grid-view/pimrewardpunishmentpim-jangl-grid-view.vue'),
                },
                {
                    path: 'pimrewardpunishments/:pimrewardpunishment?/pimjanglgridview/:pimjanglgridview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.pimjanglgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'pimjanglgridview', parameterName: 'pimjanglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimrewardpunishmentpim-jangl-grid-view/pimrewardpunishmentpim-jangl-grid-view.vue'),
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
                    path: 'pimqualtypes/:pimqualtype?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pimqualtype.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimqualtypes', parameterName: 'pimqualtype' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimqualtypepickup-view/pimqualtypepickup-view.vue'),
                },
                {
                    path: 'pcmdetails/:pcmdetail?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pcmdetail.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmdetails', parameterName: 'pcmdetail' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pcmdetailgrid-view/pcmdetailgrid-view.vue'),
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
                    path: 'pimpeople/:pimperson?/quickeditview/:quickeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.quickeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'quickeditview', parameterName: 'quickeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonquick-edit-view/pimpersonquick-edit-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/htqddwwpickupview/:htqddwwpickupview?',
                    meta: {
                        caption: 'entities.ormsignorg.views.htqddwwpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'htqddwwpickupview', parameterName: 'htqddwwpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-sign-org-htqddwwpickup-view/orm-sign-org-htqddwwpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimcontract.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractedit-view/pimcontractedit-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimcontract.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractedit-view/pimcontractedit-view.vue'),
                },
                {
                    path: 'pimlabourcampanies/:pimlabourcampany?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pimlabourcampany.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimlabourcampanypickup-grid-view/pimlabourcampanypickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/reasoneditview/:reasoneditview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.reasoneditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'reasoneditview', parameterName: 'reasoneditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangereason-edit-view/pimpersonchangereason-edit-view.vue'),
                },
                {
                    path: 'pimpersonchanges/:pimpersonchange?/reasoneditview/:reasoneditview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.reasoneditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'reasoneditview', parameterName: 'reasoneditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangereason-edit-view/pimpersonchangereason-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/zddeditview/:zddeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.zddeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'zddeditview', parameterName: 'zddeditview' },
                        ],
                        requireAuth: false,
                    },
                    component: () => import('@pages/pim/pimpersonzddedit-view/pimpersonzddedit-view.vue'),
                },
                {
                    path: 'pimlabourcampanies/:pimlabourcampany?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pimlabourcampany.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimlabourcampanypickup-view/pimlabourcampanypickup-view.vue'),
                },
                {
                    path: 'pimgwtypes/:pimgwtype?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pimgwtype.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimgwtypes', parameterName: 'pimgwtype' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimgwtypepickup-grid-view/pimgwtypepickup-grid-view.vue'),
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
                    path: 'pimpeople/:pimperson?/pimpapers/:pimpaper?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimpaper.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpapers', parameterName: 'pimpaper' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpaperedit-view/pimpaperedit-view.vue'),
                },
                {
                    path: 'pimpapers/:pimpaper?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimpaper.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpapers', parameterName: 'pimpaper' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpaperedit-view/pimpaperedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/wscgridview/:wscgridview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.wscgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                            { pathName: 'wscgridview', parameterName: 'wscgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/attendancemreportmxwsc-grid-view/attendancemreportmxwsc-grid-view.vue'),
                },
                {
                    path: 'attendancemreportmxes/:attendancemreportmx?/wscgridview/:wscgridview?',
                    meta: {
                        caption: 'entities.attendancemreportmx.views.wscgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                            { pathName: 'wscgridview', parameterName: 'wscgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/att/attendancemreportmxwsc-grid-view/attendancemreportmxwsc-grid-view.vue'),
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
                    component: () => import('@pages/orm/ormorgfpxxpickup-grid-view/ormorgfpxxpickup-grid-view.vue'),
                },
                {
                    path: 'pimgwtypes/:pimgwtype?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.pimgwtype.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimgwtypes', parameterName: 'pimgwtype' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimgwtypempickup-view/pimgwtypempickup-view.vue'),
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
                    component: () => import('@pages/pim/pimpersonpickup-grid-view/pimpersonpickup-grid-view.vue'),
                },
                {
                    path: 'trmlgbcosts/:trmlgbcost?/editview/:editview?',
                    meta: {
                        caption: 'entities.trmlgbcost.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmlgbcosts', parameterName: 'trmlgbcost' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trmlgbcostedit-view/trmlgbcostedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/admineditview/:admineditview?',
                    meta: {
                        caption: 'entities.pimarchives.views.admineditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'admineditview', parameterName: 'admineditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesadmin-edit-view/pimarchivesadmin-edit-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/admineditview/:admineditview?',
                    meta: {
                        caption: 'entities.pimarchives.views.admineditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'admineditview', parameterName: 'admineditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesadmin-edit-view/pimarchivesadmin-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimtitles/:pimtitle?/wsseditview/:wsseditview?',
                    meta: {
                        caption: 'entities.pimtitle.views.wsseditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'wsseditview', parameterName: 'wsseditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlewssedit-view/pimtitlewssedit-view.vue'),
                },
                {
                    path: 'pimtitles/:pimtitle?/wsseditview/:wsseditview?',
                    meta: {
                        caption: 'entities.pimtitle.views.wsseditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'wsseditview', parameterName: 'wsseditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlewssedit-view/pimtitlewssedit-view.vue'),
                },
                {
                    path: 'pimlabourcampanies/:pimlabourcampany?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimlabourcampany.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/laowupaiqiangongsiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimlabourcampanyedit-view/pimlabourcampanyedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.editview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangeedit-view/pimpersonchangeedit-view.vue'),
                },
                {
                    path: 'pimpersonchanges/:pimpersonchange?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.editview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangeedit-view/pimpersonchangeedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimeducations/:pimeducation?/zdxlgridview/:zdxlgridview?',
                    meta: {
                        caption: 'entities.pimeducation.views.zdxlgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'zdxlgridview', parameterName: 'zdxlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimeducationzdxlgrid-view/pimeducationzdxlgrid-view.vue'),
                },
                {
                    path: 'pimeducations/:pimeducation?/zdxlgridview/:zdxlgridview?',
                    meta: {
                        caption: 'entities.pimeducation.views.zdxlgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'zdxlgridview', parameterName: 'zdxlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimeducationzdxlgrid-view/pimeducationzdxlgrid-view.vue'),
                },
                {
                    path: 'pimtypecontracts/:pimtypecontract?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimtypecontract.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtypecontracts', parameterName: 'pimtypecontract' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtypecontractgrid-view/pimtypecontractgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/xjpickupgridview/:xjpickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.xjpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'xjpickupgridview', parameterName: 'xjpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-org-xj-pickup-grid-view/orm-org-xj-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/lzyghmcgridview/:lzyghmcgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.lzyghmcgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/guazhidaoqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'lzyghmcgridview', parameterName: 'lzyghmcgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonlzyghmcgrid-view/pimpersonlzyghmcgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/formpickupview/:formpickupview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.formpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'formpickupview', parameterName: 'formpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryform-pickup-view/pimexitandentryform-pickup-view.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/formpickupview/:formpickupview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.formpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'formpickupview', parameterName: 'formpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryform-pickup-view/pimexitandentryform-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/yscgjxjeditview/:yscgjxjeditview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.yscgjxjeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'yscgjxjeditview', parameterName: 'yscgjxjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryyscgjxjedit-view/pimexitandentryyscgjxjedit-view.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/yscgjxjeditview/:yscgjxjeditview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.yscgjxjeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'yscgjxjeditview', parameterName: 'yscgjxjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryyscgjxjedit-view/pimexitandentryyscgjxjedit-view.vue'),
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
                    component: () => import('@pages/orm/ormorgfpxxpickup-view/ormorgfpxxpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimperson.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersongrid-view/pimpersongrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpatents/:pimpatent?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimpatent.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpatents', parameterName: 'pimpatent' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpatentedit-view/pimpatentedit-view.vue'),
                },
                {
                    path: 'pimpatents/:pimpatent?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimpatent.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpatents', parameterName: 'pimpatent' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpatentedit-view/pimpatentedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimeducations/:pimeducation?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimeducation.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimeducationedit-view/pimeducationedit-view.vue'),
                },
                {
                    path: 'pimeducations/:pimeducation?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimeducation.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimeducationedit-view/pimeducationedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/maturitydueeditview/:maturitydueeditview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.maturitydueeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/jiediaodaoqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'maturitydueeditview', parameterName: 'maturitydueeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimdistirbutionmaturity-due-edit-view/pimdistirbutionmaturity-due-edit-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/maturitydueeditview/:maturitydueeditview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.maturitydueeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/jiediaodaoqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'maturitydueeditview', parameterName: 'maturitydueeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimdistirbutionmaturity-due-edit-view/pimdistirbutionmaturity-due-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/jxqyggridview/:jxqyggridview?',
                    meta: {
                        caption: 'entities.pimperson.views.jxqyggridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/jianxiqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'jxqyggridview', parameterName: 'jxqyggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonjxqyggrid-view/pimpersonjxqyggrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/ygcgjxjeditview/:ygcgjxjeditview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.ygcgjxjeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'ygcgjxjeditview', parameterName: 'ygcgjxjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryygcgjxjedit-view/pimexitandentryygcgjxjedit-view.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/ygcgjxjeditview/:ygcgjxjeditview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.ygcgjxjeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'ygcgjxjeditview', parameterName: 'ygcgjxjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryygcgjxjedit-view/pimexitandentryygcgjxjedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/jdryhmcgridview/:jdryhmcgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.jdryhmcgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/jiediaodaoqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'jdryhmcgridview', parameterName: 'jdryhmcgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-distirbution-jdryhmcgrid-view/pim-distirbution-jdryhmcgrid-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/jdryhmcgridview/:jdryhmcgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.jdryhmcgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/jiediaodaoqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'jdryhmcgridview', parameterName: 'jdryhmcgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pim-distirbution-jdryhmcgrid-view/pim-distirbution-jdryhmcgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/loyeenofilegridview/:loyeenofilegridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.loyeenofilegridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'loyeenofilegridview', parameterName: 'loyeenofilegridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesloyeenofilegrid-view/pimarchivesloyeenofilegrid-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/loyeenofilegridview/:loyeenofilegridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.loyeenofilegridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'loyeenofilegridview', parameterName: 'loyeenofilegridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesloyeenofilegrid-view/pimarchivesloyeenofilegrid-view.vue'),
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
                    component: () => import('@pages/att/attendancemreportmxedit-view/attendancemreportmxedit-view.vue'),
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
                    component: () => import('@pages/att/attendancemreportmxedit-view/attendancemreportmxedit-view.vue'),
                },
                {
                    path: 'pcmdetails/:pcmdetail?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmdetail.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmdetails', parameterName: 'pcmdetail' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pcmdetailedit-view/pcmdetailedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpapers/:pimpaper?/papergridview/:papergridview?',
                    meta: {
                        caption: 'entities.pimpaper.views.papergridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpapers', parameterName: 'pimpaper' },
                            { pathName: 'papergridview', parameterName: 'papergridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpaperpapergrid-view/pimpaperpapergrid-view.vue'),
                },
                {
                    path: 'pimpapers/:pimpaper?/papergridview/:papergridview?',
                    meta: {
                        caption: 'entities.pimpaper.views.papergridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpapers', parameterName: 'pimpaper' },
                            { pathName: 'papergridview', parameterName: 'papergridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpaperpapergrid-view/pimpaperpapergrid-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/htqddwpickupgridview/:htqddwpickupgridview?',
                    meta: {
                        caption: 'entities.ormsignorg.views.htqddwpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'htqddwpickupgridview', parameterName: 'htqddwpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-sign-org-htqddwpickup-grid-view/orm-sign-org-htqddwpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/stoptimeselecteditview/:stoptimeselecteditview?',
                    meta: {
                        caption: 'entities.pimcontract.views.stoptimeselecteditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'stoptimeselecteditview', parameterName: 'stoptimeselecteditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractstop-time-select-edit-view/pimcontractstop-time-select-edit-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/stoptimeselecteditview/:stoptimeselecteditview?',
                    meta: {
                        caption: 'entities.pimcontract.views.stoptimeselecteditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'stoptimeselecteditview', parameterName: 'stoptimeselecteditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractstop-time-select-edit-view/pimcontractstop-time-select-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/gbllgridview/:gbllgridview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.gbllgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'gbllgridview', parameterName: 'gbllgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimworkhistorygbllgrid-view/pimworkhistorygbllgrid-view.vue'),
                },
                {
                    path: 'pimworkhistories/:pimworkhistory?/gbllgridview/:gbllgridview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.gbllgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'gbllgridview', parameterName: 'gbllgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimworkhistorygbllgrid-view/pimworkhistorygbllgrid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/xjpickupview/:xjpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.xjpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'xjpickupview', parameterName: 'xjpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgxj-pickup-view/ormorgxj-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimrewardpunishmentedit-view/pimrewardpunishmentedit-view.vue'),
                },
                {
                    path: 'pimrewardpunishments/:pimrewardpunishment?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimrewardpunishmentedit-view/pimrewardpunishmentedit-view.vue'),
                },
                {
                    path: 'pimtitlecatalogues/:pimtitlecatalogue?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimtitlecatalogue.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengmuluguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlecatalogueedit-view/pimtitlecatalogueedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/pimworkgridview/:pimworkgridview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.pimworkgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'pimworkgridview', parameterName: 'pimworkgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimworkhistorypim-work-grid-view/pimworkhistorypim-work-grid-view.vue'),
                },
                {
                    path: 'pimworkhistories/:pimworkhistory?/pimworkgridview/:pimworkgridview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.pimworkgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'pimworkgridview', parameterName: 'pimworkgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimworkhistorypim-work-grid-view/pimworkhistorypim-work-grid-view.vue'),
                },
                {
                    path: 'pimarchivescenters/:pimarchivescenter?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarchivescenter.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchivescenters', parameterName: 'pimarchivescenter' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/archivescenteredit-view/archivescenteredit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimresearchfindings/:pimresearchfindings?/researchgridview/:researchgridview?',
                    meta: {
                        caption: 'entities.pimresearchfindings.views.researchgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/keyanchengguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                            { pathName: 'researchgridview', parameterName: 'researchgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimresearchfindingsresearchgrid-view/pimresearchfindingsresearchgrid-view.vue'),
                },
                {
                    path: 'pimresearchfindings/:pimresearchfindings?/researchgridview/:researchgridview?',
                    meta: {
                        caption: 'entities.pimresearchfindings.views.researchgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/keyanchengguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                            { pathName: 'researchgridview', parameterName: 'researchgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimresearchfindingsresearchgrid-view/pimresearchfindingsresearchgrid-view.vue'),
                },
                {
                    path: 'pimarchivescenters/:pimarchivescenter?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pimarchivescenter.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchivescenters', parameterName: 'pimarchivescenter' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/archivescenterpickup-grid-view/archivescenterpickup-grid-view.vue'),
                },
                {
                    path: 'pimtitlecatalogues/:pimtitlecatalogue?/notpickupview/:notpickupview?',
                    meta: {
                        caption: 'entities.pimtitlecatalogue.views.notpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                            { pathName: 'notpickupview', parameterName: 'notpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlecataloguenot-pickup-view/pimtitlecataloguenot-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_ng/:editview_ng?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_ng.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_ng', parameterName: 'editview_ng' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-ng/pimexitandentryedit-view-ng.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/editview_ng/:editview_ng?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_ng.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_ng', parameterName: 'editview_ng' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-ng/pimexitandentryedit-view-ng.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/ygfenpeigridview/:ygfenpeigridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.ygfenpeigridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'ygfenpeigridview', parameterName: 'ygfenpeigridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimdistirbutionygfen-pei-grid-view/pimdistirbutionygfen-pei-grid-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/ygfenpeigridview/:ygfenpeigridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.ygfenpeigridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'ygfenpeigridview', parameterName: 'ygfenpeigridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimdistirbutionygfen-pei-grid-view/pimdistirbutionygfen-pei-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimtitles/:pimtitle?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimtitle.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunjihua.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitleedit-view/pimtitleedit-view.vue'),
                },
                {
                    path: 'pimtitles/:pimtitle?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimtitle.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunjihua.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitleedit-view/pimtitleedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/ltxyggridview/:ltxyggridview?',
                    meta: {
                        caption: 'entities.pimperson.views.ltxyggridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'ltxyggridview', parameterName: 'ltxyggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonltxyggrid-view/pimpersonltxyggrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimlanguageabilities/:pimlanguageability?/yynlgridview/:yynlgridview?',
                    meta: {
                        caption: 'entities.pimlanguageability.views.yynlgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/yuyanshuiping.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                            { pathName: 'yynlgridview', parameterName: 'yynlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimlanguageabilityyynlgrid-view/pimlanguageabilityyynlgrid-view.vue'),
                },
                {
                    path: 'pimlanguageabilities/:pimlanguageability?/yynlgridview/:yynlgridview?',
                    meta: {
                        caption: 'entities.pimlanguageability.views.yynlgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/yuyanshuiping.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                            { pathName: 'yynlgridview', parameterName: 'yynlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimlanguageabilityyynlgrid-view/pimlanguageabilityyynlgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimvocationals/:pimvocational?/pimziggridview/:pimziggridview?',
                    meta: {
                        caption: 'entities.pimvocational.views.pimziggridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'pimziggridview', parameterName: 'pimziggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimvocationalpim-zig-grid-view/pimvocationalpim-zig-grid-view.vue'),
                },
                {
                    path: 'pimvocationals/:pimvocational?/pimziggridview/:pimziggridview?',
                    meta: {
                        caption: 'entities.pimvocational.views.pimziggridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'pimziggridview', parameterName: 'pimziggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimvocationalpim-zig-grid-view/pimvocationalpim-zig-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/syqyggridview/:syqyggridview?',
                    meta: {
                        caption: 'entities.pimperson.views.syqyggridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/shiyongqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'syqyggridview', parameterName: 'syqyggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonsyqyggrid-view/pimpersonsyqyggrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/yscgjgridview/:yscgjgridview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.yscgjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'yscgjgridview', parameterName: 'yscgjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryyscgjgrid-view/pimexitandentryyscgjgrid-view.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/yscgjgridview/:yscgjgridview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.yscgjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'yscgjgridview', parameterName: 'yscgjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryyscgjgrid-view/pimexitandentryyscgjgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/xscgeditview/:xscgeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.xscgeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'xscgeditview', parameterName: 'xscgeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonxscgedit-view/pimpersonxscgedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/dadcjlgridview/:dadcjlgridview?',
                    meta: {
                        caption: 'entities.pimarchiveschange.views.dadcjlgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                            { pathName: 'dadcjlgridview', parameterName: 'dadcjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchiveschangedadcjlgrid-view/pimarchiveschangedadcjlgrid-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/dadcjlgridview/:dadcjlgridview?',
                    meta: {
                        caption: 'entities.pimarchiveschange.views.dadcjlgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                            { pathName: 'dadcjlgridview', parameterName: 'dadcjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchiveschangedadcjlgrid-view/pimarchiveschangedadcjlgrid-view.vue'),
                },
                {
                    path: 'pimarchiveschanges/:pimarchiveschange?/dadcjlgridview/:dadcjlgridview?',
                    meta: {
                        caption: 'entities.pimarchiveschange.views.dadcjlgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                            { pathName: 'dadcjlgridview', parameterName: 'dadcjlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchiveschangedadcjlgrid-view/pimarchiveschangedadcjlgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/ryinfoeditview/:ryinfoeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.ryinfoeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'ryinfoeditview', parameterName: 'ryinfoeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonryinfo-edit-view/pimpersonryinfo-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimvocationals/:pimvocational?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimvocational.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimvocationaledit-view/pimvocationaledit-view.vue'),
                },
                {
                    path: 'pimvocationals/:pimvocational?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimvocational.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimvocationaledit-view/pimvocationaledit-view.vue'),
                },
                {
                    path: 'pimtitlecatalogues/:pimtitlecatalogue?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pimtitlecatalogue.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlecataloguepickup-view/pimtitlecataloguepickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/personinfoeditview/:personinfoeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.personinfoeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'personinfoeditview', parameterName: 'personinfoeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonperson-info-edit-view/pimpersonperson-info-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesgrid-view/pimarchivesgrid-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesgrid-view/pimarchivesgrid-view.vue'),
                },
                {
                    path: 'pimqualmajors/:pimqualmajor?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimqualmajor.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/penxunkecheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimqualmajorgrid-view/pimqualmajorgrid-view.vue'),
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
                    component: () => import('@pages/orm/ormorgsectorfpxxpickup-view/ormorgsectorfpxxpickup-view.vue'),
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
                    component: () => import('@pages/orm/ormorgsectorfpxxpickup-view/ormorgsectorfpxxpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/hisrecgridview/:hisrecgridview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.hisrecgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'hisrecgridview', parameterName: 'hisrecgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangehis-rec-grid-view/pimpersonchangehis-rec-grid-view.vue'),
                },
                {
                    path: 'pimpersonchanges/:pimpersonchange?/hisrecgridview/:hisrecgridview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.hisrecgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'hisrecgridview', parameterName: 'hisrecgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangehis-rec-grid-view/pimpersonchangehis-rec-grid-view.vue'),
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
                    component: () => import('@pages/orm/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
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
                    component: () => import('@pages/orm/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarchiveschange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarchiveschange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
                },
                {
                    path: 'pimarchiveschanges/:pimarchiveschange?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarchiveschange.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/bdwpickupview/:bdwpickupview?',
                    meta: {
                        caption: 'entities.ormsignorg.views.bdwpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'bdwpickupview', parameterName: 'bdwpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-sign-org-bdwpickup-view/orm-sign-org-bdwpickup-view.vue'),
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
                    component: () => import('@pages/orm/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
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
                    component: () => import('@pages/orm/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/ygcgjgridview/:ygcgjgridview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.ygcgjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'ygcgjgridview', parameterName: 'ygcgjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryygcgjgrid-view/pimexitandentryygcgjgrid-view.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/ygcgjgridview/:ygcgjgridview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.ygcgjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'ygcgjgridview', parameterName: 'ygcgjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryygcgjgrid-view/pimexitandentryygcgjgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarmycadres/:pimarmycadres?/armygridview/:armygridview?',
                    meta: {
                        caption: 'entities.pimarmycadres.views.armygridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                            { pathName: 'armygridview', parameterName: 'armygridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarmycadresarmygrid-view/pimarmycadresarmygrid-view.vue'),
                },
                {
                    path: 'pimarmycadres/:pimarmycadres?/armygridview/:armygridview?',
                    meta: {
                        caption: 'entities.pimarmycadres.views.armygridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                            { pathName: 'armygridview', parameterName: 'armygridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarmycadresarmygrid-view/pimarmycadresarmygrid-view.vue'),
                },
                {
                    path: 'pimqualtypes/:pimqualtype?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimqualtype.views.editview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinleixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimqualtypes', parameterName: 'pimqualtype' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimqualtypeedit-view/pimqualtypeedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/zhzceditview/:zhzceditview?',
                    meta: {
                        caption: 'entities.pimperson.views.zhzceditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'zhzceditview', parameterName: 'zhzceditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonzhzcedit-view/pimpersonzhzcedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractgrid-view/pimcontractgrid-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractgrid-view/pimcontractgrid-view.vue'),
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
                    path: 'pimpeople/:pimperson?/zdeditview/:zdeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.zdeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'zdeditview', parameterName: 'zdeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonzdedit-view/pimpersonzdedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_ybh/:editview_ybh?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_ybh.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_ybh', parameterName: 'editview_ybh' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-ybh/pimexitandentryedit-view-ybh.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/editview_ybh/:editview_ybh?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_ybh.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_ybh', parameterName: 'editview_ybh' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-ybh/pimexitandentryedit-view-ybh.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimresearchfindings/:pimresearchfindings?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimresearchfindings.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/keyanchengguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimresearchfindingsedit-view/pimresearchfindingsedit-view.vue'),
                },
                {
                    path: 'pimresearchfindings/:pimresearchfindings?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimresearchfindings.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/keyanchengguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimresearchfindingsedit-view/pimresearchfindingsedit-view.vue'),
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
                    component: () => import('@pages/trm/trmtrianpersonedit-view/trmtrianpersonedit-view.vue'),
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
                    component: () => import('@pages/trm/trmtrianpersonedit-view/trmtrianpersonedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/personinfotreeexpview/:personinfotreeexpview?',
                    meta: {
                        caption: 'entities.pimperson.views.personinfotreeexpview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'personinfotreeexpview', parameterName: 'personinfotreeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonperson-info-tree-exp-view/pimpersonperson-info-tree-exp-view.vue'),
                },
                {
                    path: 'pimexpaccounts/:pimexpaccount?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimexpaccount.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/guazhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexpaccounts', parameterName: 'pimexpaccount' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexpaccountgrid-view/pimexpaccountgrid-view.vue'),
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
                    component: () => import('@pages/orm/ormdutyorm-org-sector-pickup-view/ormdutyorm-org-sector-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimvocationals/:pimvocational?/wsseditview/:wsseditview?',
                    meta: {
                        caption: 'entities.pimvocational.views.wsseditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'wsseditview', parameterName: 'wsseditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimvocationalwssedit-view/pimvocationalwssedit-view.vue'),
                },
                {
                    path: 'pimvocationals/:pimvocational?/wsseditview/:wsseditview?',
                    meta: {
                        caption: 'entities.pimvocational.views.wsseditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'wsseditview', parameterName: 'wsseditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimvocationalwssedit-view/pimvocationalwssedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/reneweditview/:reneweditview?',
                    meta: {
                        caption: 'entities.pimcontract.views.reneweditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'reneweditview', parameterName: 'reneweditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractrenew-edit-view/pimcontractrenew-edit-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/reneweditview/:reneweditview?',
                    meta: {
                        caption: 'entities.pimcontract.views.reneweditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'reneweditview', parameterName: 'reneweditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractrenew-edit-view/pimcontractrenew-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_yqx/:editview_yqx?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_yqx.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_yqx', parameterName: 'editview_yqx' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-yqx/pimexitandentryedit-view-yqx.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/editview_yqx/:editview_yqx?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_yqx.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_yqx', parameterName: 'editview_yqx' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-yqx/pimexitandentryedit-view-yqx.vue'),
                },
                {
                    path: 'pimtitlecatalogues/:pimtitlecatalogue?/notpickupgridview/:notpickupgridview?',
                    meta: {
                        caption: 'entities.pimtitlecatalogue.views.notpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                            { pathName: 'notpickupgridview', parameterName: 'notpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlecataloguenot-pickup-grid-view/pimtitlecataloguenot-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/lwgridview/:lwgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.lwgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'lwgridview', parameterName: 'lwgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractlwgrid-view/pimcontractlwgrid-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/lwgridview/:lwgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.lwgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'lwgridview', parameterName: 'lwgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractlwgrid-view/pimcontractlwgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimarchiveschange.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimarchiveschange.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
                },
                {
                    path: 'pimarchiveschanges/:pimarchiveschange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimarchiveschange.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimvocationals/:pimvocational?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimvocational.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimvocationalgrid-view/pimvocationalgrid-view.vue'),
                },
                {
                    path: 'pimvocationals/:pimvocational?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimvocational.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimvocationalgrid-view/pimvocationalgrid-view.vue'),
                },
                {
                    path: 'trmlgbcosts/:trmlgbcost?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.trmlgbcost.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'trmlgbcosts', parameterName: 'trmlgbcost' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/trm/trmlgbcostgrid-view/trmlgbcostgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangegrid-view/pimpersonchangegrid-view.vue'),
                },
                {
                    path: 'pimpersonchanges/:pimpersonchange?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimpersonchange.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonchangegrid-view/pimpersonchangegrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/lweditview/:lweditview?',
                    meta: {
                        caption: 'entities.pimcontract.views.lweditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'lweditview', parameterName: 'lweditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractlwedit-view/pimcontractlwedit-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/lweditview/:lweditview?',
                    meta: {
                        caption: 'entities.pimcontract.views.lweditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'lweditview', parameterName: 'lweditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractlwedit-view/pimcontractlwedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarmycadres/:pimarmycadres?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarmycadres.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarmycadresedit-view/pimarmycadresedit-view.vue'),
                },
                {
                    path: 'pimarmycadres/:pimarmycadres?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarmycadres.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarmycadresedit-view/pimarmycadresedit-view.vue'),
                },
                {
                    path: 'pimqualtypes/:pimqualtype?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pimqualtype.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimqualtypes', parameterName: 'pimqualtype' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimqualtypepickup-grid-view/pimqualtypepickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/noloyeenofilegridview/:noloyeenofilegridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.noloyeenofilegridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'noloyeenofilegridview', parameterName: 'noloyeenofilegridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesnoloyeenofilegrid-view/pimarchivesnoloyeenofilegrid-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/noloyeenofilegridview/:noloyeenofilegridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.noloyeenofilegridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'noloyeenofilegridview', parameterName: 'noloyeenofilegridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesnoloyeenofilegrid-view/pimarchivesnoloyeenofilegrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_ytg/:editview_ytg?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_ytg.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_ytg', parameterName: 'editview_ytg' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-ytg/pimexitandentryedit-view-ytg.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/editview_ytg/:editview_ytg?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_ytg.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_ytg', parameterName: 'editview_ytg' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-ytg/pimexitandentryedit-view-ytg.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/stopremindgridview/:stopremindgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.stopremindgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'stopremindgridview', parameterName: 'stopremindgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractstop-remind-grid-view/pimcontractstop-remind-grid-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/stopremindgridview/:stopremindgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.stopremindgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'stopremindgridview', parameterName: 'stopremindgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractstop-remind-grid-view/pimcontractstop-remind-grid-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/htgldwqpickupgridview/:htgldwqpickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.htgldwqpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'htgldwqpickupgridview', parameterName: 'htgldwqpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorghtgldwqpickup-grid-view/ormorghtgldwqpickup-grid-view.vue'),
                },
                {
                    path: 'pimarchivescenters/:pimarchivescenter?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimarchivescenter.views.gridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchivescenters', parameterName: 'pimarchivescenter' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/archivescentergrid-view/archivescentergrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimfaminfoedit-view/pimfaminfoedit-view.vue'),
                },
                {
                    path: 'pimfaminfos/:pimfaminfo?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimfaminfoedit-view/pimfaminfoedit-view.vue'),
                },
                {
                    path: 'pimtypecontracts/:pimtypecontract?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimtypecontract.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtypecontracts', parameterName: 'pimtypecontract' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtypecontractedit-view/pimtypecontractedit-view.vue'),
                },
                {
                    path: 'pimqualmajors/:pimqualmajor?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pimqualmajor.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimqualmajorpickup-view/pimqualmajorpickup-view.vue'),
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
                    component: () => import('@pages/pim/pimdistirbutionedit-view/pimdistirbutionedit-view.vue'),
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
                    component: () => import('@pages/pim/pimdistirbutionedit-view/pimdistirbutionedit-view.vue'),
                },
                {
                    path: 'pimtitlecatalogues/:pimtitlecatalogue?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimtitlecatalogue.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengmuluguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlecataloguegrid-view/pimtitlecataloguegrid-view.vue'),
                },
                {
                    path: 'pimqualmajors/:pimqualmajor?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pimqualmajor.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimqualmajorpickup-grid-view/pimqualmajorpickup-grid-view.vue'),
                },
                {
                    path: 'pimqualtypes/:pimqualtype?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimqualtype.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/kaoqinleixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimqualtypes', parameterName: 'pimqualtype' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimqualtypegrid-view/pimqualtypegrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/wssgridview/:wssgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.wssgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'wssgridview', parameterName: 'wssgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractwssgrid-view/pimcontractwssgrid-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/wssgridview/:wssgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.wssgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'wssgridview', parameterName: 'wssgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontractwssgrid-view/pimcontractwssgrid-view.vue'),
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
                    component: () => import('@pages/trm/trmtrianpersongrid-view/trmtrianpersongrid-view.vue'),
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
                    component: () => import('@pages/trm/trmtrianpersongrid-view/trmtrianpersongrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarchives.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesedit-view/pimarchivesedit-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimarchives.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesedit-view/pimarchivesedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/hmdgridview/:hmdgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.hmdgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'hmdgridview', parameterName: 'hmdgridview' },
                        ],
                        requireAuth: false,
                    },
                    component: () => import('@pages/pim/pimpersonhmdgrid-view/pimpersonhmdgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimeducations/:pimeducation?/pimedugridview/:pimedugridview?',
                    meta: {
                        caption: 'entities.pimeducation.views.pimedugridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'pimedugridview', parameterName: 'pimedugridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimeducationpim-edu-grid-view/pimeducationpim-edu-grid-view.vue'),
                },
                {
                    path: 'pimeducations/:pimeducation?/pimedugridview/:pimedugridview?',
                    meta: {
                        caption: 'entities.pimeducation.views.pimedugridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'pimedugridview', parameterName: 'pimedugridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimeducationpim-edu-grid-view/pimeducationpim-edu-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimperson.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gerenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersonedit-view/pimpersonedit-view.vue'),
                },
                {
                    path: 'pimarchivescenters/:pimarchivescenter?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pimarchivescenter.views.pickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchivescenters', parameterName: 'pimarchivescenter' },
                            { pathName: 'pickupview', parameterName: 'pickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/archivescenterpickup-view/archivescenterpickup-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/htgldwpickupview/:htgldwpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.htgldwpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'htgldwpickupview', parameterName: 'htgldwpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorghtgldwpickup-view/ormorghtgldwpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimworkhistoryedit-view/pimworkhistoryedit-view.vue'),
                },
                {
                    path: 'pimworkhistories/:pimworkhistory?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimworkhistoryedit-view/pimworkhistoryedit-view.vue'),
                },
                {
                    path: 'pimtitlecatalogues/:pimtitlecatalogue?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pimtitlecatalogue.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimtitlecataloguepickup-grid-view/pimtitlecataloguepickup-grid-view.vue'),
                },
                {
                    path: 'pimcontracttypes/:pimcontracttype?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimcontracttype.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongleixing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracttypes', parameterName: 'pimcontracttype' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimcontracttypegrid-view/pimcontracttypegrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/archivesrecordeditview/:archivesrecordeditview?',
                    meta: {
                        caption: 'entities.pimarchives.views.archivesrecordeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'archivesrecordeditview', parameterName: 'archivesrecordeditview' },
                        ],
                        requireAuth: false,
                    },
                    component: () => import('@pages/pim/pimarchivesarchives-record-edit-view/pimarchivesarchives-record-edit-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/archivesrecordeditview/:archivesrecordeditview?',
                    meta: {
                        caption: 'entities.pimarchives.views.archivesrecordeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'archivesrecordeditview', parameterName: 'archivesrecordeditview' },
                        ],
                        requireAuth: false,
                    },
                    component: () => import('@pages/pim/pimarchivesarchives-record-edit-view/pimarchivesarchives-record-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/gzryhmcgridview/:gzryhmcgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.gzryhmcgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/guazhidaoqiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'gzryhmcgridview', parameterName: 'gzryhmcgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersongzryhmcgrid-view/pimpersongzryhmcgrid-view.vue'),
                },
                {
                    path: 'ormsignorgs/:ormsignorg?/bdwpickupgridview/:bdwpickupgridview?',
                    meta: {
                        caption: 'entities.ormsignorg.views.bdwpickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                            { pathName: 'bdwpickupgridview', parameterName: 'bdwpickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/orm-sign-org-bdwpickup-grid-view/orm-sign-org-bdwpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimlanguageabilities/:pimlanguageability?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimlanguageability.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimlanguageabilityedit-view/pimlanguageabilityedit-view.vue'),
                },
                {
                    path: 'pimlanguageabilities/:pimlanguageability?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimlanguageability.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimlanguageabilityedit-view/pimlanguageabilityedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimachievements/:pimachievements?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimachievements.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimachievements', parameterName: 'pimachievements' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimachievementsedit-view/pimachievementsedit-view.vue'),
                },
                {
                    path: 'pimachievements/:pimachievements?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimachievements.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimachievements', parameterName: 'pimachievements' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimachievementsedit-view/pimachievementsedit-view.vue'),
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
                    component: () => import('@pages/orm/ormorgsectorfpxxpickup-grid-view/ormorgsectorfpxxpickup-grid-view.vue'),
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
                    component: () => import('@pages/orm/ormorgsectorfpxxpickup-grid-view/ormorgsectorfpxxpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpatents/:pimpatent?/patentgridview/:patentgridview?',
                    meta: {
                        caption: 'entities.pimpatent.views.patentgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpatents', parameterName: 'pimpatent' },
                            { pathName: 'patentgridview', parameterName: 'patentgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpatentpatentgrid-view/pimpatentpatentgrid-view.vue'),
                },
                {
                    path: 'pimpatents/:pimpatent?/patentgridview/:patentgridview?',
                    meta: {
                        caption: 'entities.pimpatent.views.patentgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpatents', parameterName: 'pimpatent' },
                            { pathName: 'patentgridview', parameterName: 'patentgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpatentpatentgrid-view/pimpatentpatentgrid-view.vue'),
                },
                {
                    path: 'pimexpaccounts/:pimexpaccount?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimexpaccount.views.editview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/guazhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexpaccounts', parameterName: 'pimexpaccount' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexpaccountedit-view/pimexpaccountedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_spz/:editview_spz?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_spz.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_spz', parameterName: 'editview_spz' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-spz/pimexitandentryedit-view-spz.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/editview_spz/:editview_spz?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview_spz.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview_spz', parameterName: 'editview_spz' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view-spz/pimexitandentryedit-view-spz.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchivesloanandreturns/:pimarchivesloanandreturn?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimarchivesloanandreturn.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/biangenghetong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/pimarchivesloanandreturns/:pimarchivesloanandreturn?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimarchivesloanandreturn.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/biangenghetong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
                },
                {
                    path: 'pimarchivesloanandreturns/:pimarchivesloanandreturn?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pimarchivesloanandreturn.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/biangenghetong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
                },
                {
                    path: 'pimportalview/:pimportalview?',
                    meta: {
                        caption: 'app.views.pimportalview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimportalview', parameterName: 'pimportalview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/portal/pim-portal-view/pim-portal-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view/pimexitandentryedit-view.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/editview/:editview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimexitandentryedit-view/pimexitandentryedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/pimfimgridview/:pimfimgridview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.pimfimgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'pimfimgridview', parameterName: 'pimfimgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimfaminfopimfim-grid-view/pimfaminfopimfim-grid-view.vue'),
                },
                {
                    path: 'pimfaminfos/:pimfaminfo?/pimfimgridview/:pimfimgridview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.pimfimgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'pimfimgridview', parameterName: 'pimfimgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimfaminfopimfim-grid-view/pimfaminfopimfim-grid-view.vue'),
                },
            {
                path: 'pimworkhistoryredirectview/:pimworkhistoryredirectview?',
                meta: {
                    caption: 'entities.pimworkhistory.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimworkhistoryredirectview', parameterName: 'pimworkhistoryredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimworkhistoryredirect-view/pimworkhistoryredirect-view.vue'),
            },
            {
                path: 'pimlanguageabilityredirectview/:pimlanguageabilityredirectview?',
                meta: {
                    caption: 'entities.pimlanguageability.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimlanguageabilityredirectview', parameterName: 'pimlanguageabilityredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimlanguageabilityredirect-view/pimlanguageabilityredirect-view.vue'),
            },
            {
                path: 'pimarchivesredirectview/:pimarchivesredirectview?',
                meta: {
                    caption: 'entities.pimarchives.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarchivesredirectview', parameterName: 'pimarchivesredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarchivesredirect-view/pimarchivesredirect-view.vue'),
            },
            {
                path: 'pimvocationalredirectview/:pimvocationalredirectview?',
                meta: {
                    caption: 'entities.pimvocational.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimvocationalredirectview', parameterName: 'pimvocationalredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimvocationalredirect-view/pimvocationalredirect-view.vue'),
            },
            {
                path: 'pimvocationalcatalogredirectview/:pimvocationalcatalogredirectview?',
                meta: {
                    caption: 'entities.pimvocationalcatalog.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimvocationalcatalogredirectview', parameterName: 'pimvocationalcatalogredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimvocationalcatalogredirect-view/pimvocationalcatalogredirect-view.vue'),
            },
            {
                path: 'pimarchivesloanandreturnredirectview/:pimarchivesloanandreturnredirectview?',
                meta: {
                    caption: 'entities.pimarchivesloanandreturn.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarchivesloanandreturnredirectview', parameterName: 'pimarchivesloanandreturnredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarchivesloanandreturnredirect-view/pimarchivesloanandreturnredirect-view.vue'),
            },
            {
                path: 'pimarchiveschangeredirectview/:pimarchiveschangeredirectview?',
                meta: {
                    caption: 'entities.pimarchiveschange.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarchiveschangeredirectview', parameterName: 'pimarchiveschangeredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarchiveschangeredirect-view/pimarchiveschangeredirect-view.vue'),
            },
            {
                path: 'pimpersonabilitydetailredirectview/:pimpersonabilitydetailredirectview?',
                meta: {
                    caption: 'entities.pimpersonabilitydetail.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpersonabilitydetailredirectview', parameterName: 'pimpersonabilitydetailredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimperson-ability-detail-redirect-view/pimperson-ability-detail-redirect-view.vue'),
            },
            {
                path: 'pimsearchmodalredirectview/:pimsearchmodalredirectview?',
                meta: {
                    caption: 'entities.pimsearchmodal.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimsearchmodalredirectview', parameterName: 'pimsearchmodalredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pim-search-modal-redirect-view/pim-search-modal-redirect-view.vue'),
            },
            {
                path: 'pimarmycadresredirectview/:pimarmycadresredirectview?',
                meta: {
                    caption: 'entities.pimarmycadres.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarmycadresredirectview', parameterName: 'pimarmycadresredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarmycadresredirect-view/pimarmycadresredirect-view.vue'),
            },
            {
                path: 'pimpersonabilityredirectview/:pimpersonabilityredirectview?',
                meta: {
                    caption: 'entities.pimpersonability.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpersonabilityredirectview', parameterName: 'pimpersonabilityredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimperson-ability-redirect-view/pimperson-ability-redirect-view.vue'),
            },
            {
                path: 'pimarchivesrecordredirectview/:pimarchivesrecordredirectview?',
                meta: {
                    caption: 'entities.pimarchivesrecord.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarchivesrecordredirectview', parameterName: 'pimarchivesrecordredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarchivesrecordredirect-view/pimarchivesrecordredirect-view.vue'),
            },
            {
                path: 'archivalcatalogueredirectview/:archivalcatalogueredirectview?',
                meta: {
                    caption: 'entities.pimarchivalcatalogue.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'archivalcatalogueredirectview', parameterName: 'archivalcatalogueredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/archivalcatalogueredirect-view/archivalcatalogueredirect-view.vue'),
            },
            {
                path: 'pimenclosureredirectview/:pimenclosureredirectview?',
                meta: {
                    caption: 'entities.pimenclosure.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimenclosureredirectview', parameterName: 'pimenclosureredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimenclosureredirect-view/pimenclosureredirect-view.vue'),
            },
            {
                path: 'pimcontractredirectview/:pimcontractredirectview?',
                meta: {
                    caption: 'entities.pimcontract.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimcontractredirectview', parameterName: 'pimcontractredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimcontractredirect-view/pimcontractredirect-view.vue'),
            },
            {
                path: 'pimtypecontractredirectview/:pimtypecontractredirectview?',
                meta: {
                    caption: 'entities.pimtypecontract.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimtypecontractredirectview', parameterName: 'pimtypecontractredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimtypecontractredirect-view/pimtypecontractredirect-view.vue'),
            },
            {
                path: 'pimlabourcampanyredirectview/:pimlabourcampanyredirectview?',
                meta: {
                    caption: 'entities.pimlabourcampany.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimlabourcampanyredirectview', parameterName: 'pimlabourcampanyredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimlabourcampanyredirect-view/pimlabourcampanyredirect-view.vue'),
            },
            {
                path: 'pimsearchfieldsetredirectview/:pimsearchfieldsetredirectview?',
                meta: {
                    caption: 'entities.pimsearchfieldset.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimsearchfieldsetredirectview', parameterName: 'pimsearchfieldsetredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pim-search-field-set-redirect-view/pim-search-field-set-redirect-view.vue'),
            },
            {
                path: 'pimtitlecatalogueredirectview/:pimtitlecatalogueredirectview?',
                meta: {
                    caption: 'entities.pimtitlecatalogue.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimtitlecatalogueredirectview', parameterName: 'pimtitlecatalogueredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimtitlecatalogueredirect-view/pimtitlecatalogueredirect-view.vue'),
            },
            {
                path: 'archivescenterredirectview/:archivescenterredirectview?',
                meta: {
                    caption: 'entities.pimarchivescenter.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'archivescenterredirectview', parameterName: 'archivescenterredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/archivescenterredirect-view/archivescenterredirect-view.vue'),
            },
            {
                path: 'pimrewardpunishmentredirectview/:pimrewardpunishmentredirectview?',
                meta: {
                    caption: 'entities.pimrewardpunishment.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimrewardpunishmentredirectview', parameterName: 'pimrewardpunishmentredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimrewardpunishmentredirect-view/pimrewardpunishmentredirect-view.vue'),
            },
            {
                path: 'pimcontracttyperedirectview/:pimcontracttyperedirectview?',
                meta: {
                    caption: 'entities.pimcontracttype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimcontracttyperedirectview', parameterName: 'pimcontracttyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimcontracttyperedirect-view/pimcontracttyperedirect-view.vue'),
            },
            {
                path: 'pimachievementsredirectview/:pimachievementsredirectview?',
                meta: {
                    caption: 'entities.pimachievements.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimachievementsredirectview', parameterName: 'pimachievementsredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimachievementsredirect-view/pimachievementsredirect-view.vue'),
            },
            {
                path: 'pimpersonchangeredirectview/:pimpersonchangeredirectview?',
                meta: {
                    caption: 'entities.pimpersonchange.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpersonchangeredirectview', parameterName: 'pimpersonchangeredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimpersonchangeredirect-view/pimpersonchangeredirect-view.vue'),
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
                component: () => import('@pages/pim/pimdistirbutionredirect-view/pimdistirbutionredirect-view.vue'),
            },
            {
                path: 'pimexpaccountredirectview/:pimexpaccountredirectview?',
                meta: {
                    caption: 'entities.pimexpaccount.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimexpaccountredirectview', parameterName: 'pimexpaccountredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimexpaccountredirect-view/pimexpaccountredirect-view.vue'),
            },
            {
                path: 'pimresearchfindingsredirectview/:pimresearchfindingsredirectview?',
                meta: {
                    caption: 'entities.pimresearchfindings.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimresearchfindingsredirectview', parameterName: 'pimresearchfindingsredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimresearchfindingsredirect-view/pimresearchfindingsredirect-view.vue'),
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
                component: () => import('@pages/pim/contract-sign-orgredirect-view/contract-sign-orgredirect-view.vue'),
            },
            {
                path: 'pimtitleredirectview/:pimtitleredirectview?',
                meta: {
                    caption: 'entities.pimtitle.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimtitleredirectview', parameterName: 'pimtitleredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimtitleredirect-view/pimtitleredirect-view.vue'),
            },
            {
                path: 'pimqualtyperedirectview/:pimqualtyperedirectview?',
                meta: {
                    caption: 'entities.pimqualtype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimqualtyperedirectview', parameterName: 'pimqualtyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimqualtyperedirect-view/pimqualtyperedirect-view.vue'),
            },
            {
                path: 'pimqualmajorredirectview/:pimqualmajorredirectview?',
                meta: {
                    caption: 'entities.pimqualmajor.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimqualmajorredirectview', parameterName: 'pimqualmajorredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimqualmajorredirect-view/pimqualmajorredirect-view.vue'),
            },
            {
                path: 'pimpatentredirectview/:pimpatentredirectview?',
                meta: {
                    caption: 'entities.pimpatent.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpatentredirectview', parameterName: 'pimpatentredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimpatentredirect-view/pimpatentredirect-view.vue'),
            },
            {
                path: 'pimpaperredirectview/:pimpaperredirectview?',
                meta: {
                    caption: 'entities.pimpaper.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpaperredirectview', parameterName: 'pimpaperredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimpaperredirect-view/pimpaperredirect-view.vue'),
            },
            {
                path: 'pimstafftyperedirectview/:pimstafftyperedirectview?',
                meta: {
                    caption: 'entities.pimstafftype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimstafftyperedirectview', parameterName: 'pimstafftyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimstafftyperedirect-view/pimstafftyperedirect-view.vue'),
            },
            {
                path: 'archivesmanageredirectview/:archivesmanageredirectview?',
                meta: {
                    caption: 'entities.pimarchivesmanage.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'archivesmanageredirectview', parameterName: 'archivesmanageredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/archivesmanageredirect-view/archivesmanageredirect-view.vue'),
            },
            {
                path: 'pimmajorsetyperedirectview/:pimmajorsetyperedirectview?',
                meta: {
                    caption: 'entities.pimmajorsetype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimmajorsetyperedirectview', parameterName: 'pimmajorsetyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimmajorsetyperedirect-view/pimmajorsetyperedirect-view.vue'),
            },
            {
                path: 'pimfaminforedirectview/:pimfaminforedirectview?',
                meta: {
                    caption: 'entities.pimfaminfo.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimfaminforedirectview', parameterName: 'pimfaminforedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimfaminforedirect-view/pimfaminforedirect-view.vue'),
            },
            {
                path: 'pcmdetailredirectview/:pcmdetailredirectview?',
                meta: {
                    caption: 'entities.pcmdetail.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pcmdetailredirectview', parameterName: 'pcmdetailredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pcmdetailredirect-view/pcmdetailredirect-view.vue'),
            },
            {
                path: 'pimeducationredirectview/:pimeducationredirectview?',
                meta: {
                    caption: 'entities.pimeducation.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimeducationredirectview', parameterName: 'pimeducationredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimeducationredirect-view/pimeducationredirect-view.vue'),
            },
            ...indexRoutes,
            ],
        },
    {
        path: '/pimstafftypes/:pimstafftype?/editview/:editview?',
        meta: {
            caption: 'entities.pimstafftype.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/peixunxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimstafftypes', parameterName: 'pimstafftype' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimstafftypeedit-view/pimstafftypeedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimperson.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersongrid-view/pimpersongrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimeducations/:pimeducation?/zdxlgridview/:zdxlgridview?',
        meta: {
            caption: 'entities.pimeducation.views.zdxlgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'zdxlgridview', parameterName: 'zdxlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimeducationzdxlgrid-view/pimeducationzdxlgrid-view.vue'),
    },
    {
        path: '/pimeducations/:pimeducation?/zdxlgridview/:zdxlgridview?',
        meta: {
            caption: 'entities.pimeducation.views.zdxlgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'zdxlgridview', parameterName: 'zdxlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimeducationzdxlgrid-view/pimeducationzdxlgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimtitles/:pimtitle?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimtitle.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunjihua.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlegrid-view/pimtitlegrid-view.vue'),
    },
    {
        path: '/pimtitles/:pimtitle?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimtitle.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunjihua.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlegrid-view/pimtitlegrid-view.vue'),
    },
    {
        path: '/pimarchivalcatalogues/:pimarchivalcatalogue?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchivalcatalogue.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivalcatalogues', parameterName: 'pimarchivalcatalogue' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/archivalcatalogueedit-view/archivalcatalogueedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/stopremindgridview/:stopremindgridview?',
        meta: {
            caption: 'entities.pimcontract.views.stopremindgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'stopremindgridview', parameterName: 'stopremindgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractstop-remind-grid-view/pimcontractstop-remind-grid-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/stopremindgridview/:stopremindgridview?',
        meta: {
            caption: 'entities.pimcontract.views.stopremindgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'stopremindgridview', parameterName: 'stopremindgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractstop-remind-grid-view/pimcontractstop-remind-grid-view.vue'),
    },
            {
                path: '/pimworkhistoryredirectview/:pimworkhistoryredirectview?',
                meta: {
                    caption: 'entities.pimworkhistory.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimworkhistoryredirectview', parameterName: 'pimworkhistoryredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimworkhistoryredirect-view/pimworkhistoryredirect-view.vue'),
            },
    {
        path: '/pimexpaccounts/:pimexpaccount?/editview/:editview?',
        meta: {
            caption: 'entities.pimexpaccount.views.editview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/guazhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexpaccounts', parameterName: 'pimexpaccount' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexpaccountedit-view/pimexpaccountedit-view.vue'),
    },
    {
        path: '/pimgwtypes/:pimgwtype?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimgwtype.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimgwtypes', parameterName: 'pimgwtype' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimgwtypepickup-grid-view/pimgwtypepickup-grid-view.vue'),
    },
    {
        path: '/pimqualtypes/:pimqualtype?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pimqualtype.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimqualtypes', parameterName: 'pimqualtype' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualtypepickup-view/pimqualtypepickup-view.vue'),
    },
    {
        path: '/pimarchivalcatalogues/:pimarchivalcatalogue?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimarchivalcatalogue.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivalcatalogues', parameterName: 'pimarchivalcatalogue' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/archivalcataloguepickup-grid-view/archivalcataloguepickup-grid-view.vue'),
    },
    {
        path: '/pimtypecontracts/:pimtypecontract?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimtypecontract.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'pimtypecontracts', parameterName: 'pimtypecontract' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtypecontractgrid-view/pimtypecontractgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimachievements/:pimachievements?/pimjixgridview/:pimjixgridview?',
        meta: {
            caption: 'entities.pimachievements.views.pimjixgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimachievements', parameterName: 'pimachievements' },
                { pathName: 'pimjixgridview', parameterName: 'pimjixgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimachievementspim-jix-grid-view/pimachievementspim-jix-grid-view.vue'),
    },
    {
        path: '/pimachievements/:pimachievements?/pimjixgridview/:pimjixgridview?',
        meta: {
            caption: 'entities.pimachievements.views.pimjixgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimachievements', parameterName: 'pimachievements' },
                { pathName: 'pimjixgridview', parameterName: 'pimjixgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimachievementspim-jix-grid-view/pimachievementspim-jix-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimtitles/:pimtitle?/wsseditview/:wsseditview?',
        meta: {
            caption: 'entities.pimtitle.views.wsseditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'wsseditview', parameterName: 'wsseditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlewssedit-view/pimtitlewssedit-view.vue'),
    },
    {
        path: '/pimtitles/:pimtitle?/wsseditview/:wsseditview?',
        meta: {
            caption: 'entities.pimtitle.views.wsseditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'wsseditview', parameterName: 'wsseditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlewssedit-view/pimtitlewssedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/personinfoeditview/:personinfoeditview?',
        meta: {
            caption: 'entities.pimperson.views.personinfoeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'personinfoeditview', parameterName: 'personinfoeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonperson-info-edit-view/pimpersonperson-info-edit-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/htgldwpickupview/:htgldwpickupview?',
        meta: {
            caption: 'entities.ormorg.views.htgldwpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'htgldwpickupview', parameterName: 'htgldwpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorghtgldwpickup-view/ormorghtgldwpickup-view.vue'),
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
        component: () => import('@pages/att/attendancemreportmxedit-view/attendancemreportmxedit-view.vue'),
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
        component: () => import('@pages/att/attendancemreportmxedit-view/attendancemreportmxedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/honorgridview/:honorgridview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.honorgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'honorgridview', parameterName: 'honorgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimrewardpunishmenthonorgrid-view/pimrewardpunishmenthonorgrid-view.vue'),
    },
    {
        path: '/pimrewardpunishments/:pimrewardpunishment?/honorgridview/:honorgridview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.honorgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'honorgridview', parameterName: 'honorgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimrewardpunishmenthonorgrid-view/pimrewardpunishmenthonorgrid-view.vue'),
    },
    {
        path: '/pimqualmajors/:pimqualmajor?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pimqualmajor.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualmajorpickup-view/pimqualmajorpickup-view.vue'),
    },
            {
                path: '/pimlanguageabilityredirectview/:pimlanguageabilityredirectview?',
                meta: {
                    caption: 'entities.pimlanguageability.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimlanguageabilityredirectview', parameterName: 'pimlanguageabilityredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimlanguageabilityredirect-view/pimlanguageabilityredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/loyeenofilegridview/:loyeenofilegridview?',
        meta: {
            caption: 'entities.pimarchives.views.loyeenofilegridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'loyeenofilegridview', parameterName: 'loyeenofilegridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesloyeenofilegrid-view/pimarchivesloyeenofilegrid-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/loyeenofilegridview/:loyeenofilegridview?',
        meta: {
            caption: 'entities.pimarchives.views.loyeenofilegridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'loyeenofilegridview', parameterName: 'loyeenofilegridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesloyeenofilegrid-view/pimarchivesloyeenofilegrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_ytg/:editview_ytg?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_ytg.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_ytg', parameterName: 'editview_ytg' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-ytg/pimexitandentryedit-view-ytg.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/editview_ytg/:editview_ytg?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_ytg.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_ytg', parameterName: 'editview_ytg' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-ytg/pimexitandentryedit-view-ytg.vue'),
    },
    {
        path: '/pimlabourcampanies/:pimlabourcampany?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pimlabourcampany.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimlabourcampanypickup-view/pimlabourcampanypickup-view.vue'),
    },
    {
        path: '/pimgwtypes/:pimgwtype?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.pimgwtype.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimgwtypes', parameterName: 'pimgwtype' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimgwtypempickup-view/pimgwtypempickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimpersonchange.views.gridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangegrid-view/pimpersonchangegrid-view.vue'),
    },
    {
        path: '/pimpersonchanges/:pimpersonchange?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimpersonchange.views.gridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangegrid-view/pimpersonchangegrid-view.vue'),
    },
            {
                path: '/pimarchivesredirectview/:pimarchivesredirectview?',
                meta: {
                    caption: 'entities.pimarchives.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarchivesredirectview', parameterName: 'pimarchivesredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarchivesredirect-view/pimarchivesredirect-view.vue'),
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
        component: () => import('@pages/orm/ormdutyorm-org-sector-pickup-view/ormdutyorm-org-sector-pickup-view.vue'),
    },
    {
        path: '/pimpersonabilitydetails/:pimpersonabilitydetail?/editview/:editview?',
        meta: {
            caption: 'entities.pimpersonabilitydetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpersonabilitydetails', parameterName: 'pimpersonabilitydetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimperson-ability-detail-edit-view/pimperson-ability-detail-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimlanguageabilities/:pimlanguageability?/yynlgridview/:yynlgridview?',
        meta: {
            caption: 'entities.pimlanguageability.views.yynlgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/yuyanshuiping.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                { pathName: 'yynlgridview', parameterName: 'yynlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimlanguageabilityyynlgrid-view/pimlanguageabilityyynlgrid-view.vue'),
    },
    {
        path: '/pimlanguageabilities/:pimlanguageability?/yynlgridview/:yynlgridview?',
        meta: {
            caption: 'entities.pimlanguageability.views.yynlgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/yuyanshuiping.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                { pathName: 'yynlgridview', parameterName: 'yynlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimlanguageabilityyynlgrid-view/pimlanguageabilityyynlgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/editview/:editview?',
        meta: {
            caption: 'entities.pimpersonchange.views.editview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangeedit-view/pimpersonchangeedit-view.vue'),
    },
    {
        path: '/pimpersonchanges/:pimpersonchange?/editview/:editview?',
        meta: {
            caption: 'entities.pimpersonchange.views.editview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangeedit-view/pimpersonchangeedit-view.vue'),
    },
    {
        path: '/pimmajorsetypes/:pimmajorsetype?/editview/:editview?',
        meta: {
            caption: 'entities.pimmajorsetype.views.editview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/rencaixulie.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimmajorsetypes', parameterName: 'pimmajorsetype' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimmajorsetypeedit-view/pimmajorsetypeedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/admineditview/:admineditview?',
        meta: {
            caption: 'entities.pimarchives.views.admineditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'admineditview', parameterName: 'admineditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesadmin-edit-view/pimarchivesadmin-edit-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/admineditview/:admineditview?',
        meta: {
            caption: 'entities.pimarchives.views.admineditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'admineditview', parameterName: 'admineditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesadmin-edit-view/pimarchivesadmin-edit-view.vue'),
    },
    {
        path: '/trmlgbcosts/:trmlgbcost?/editview/:editview?',
        meta: {
            caption: 'entities.trmlgbcost.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmlgbcosts', parameterName: 'trmlgbcost' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trmlgbcostedit-view/trmlgbcostedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/editview2/:editview2?',
        meta: {
            caption: 'entities.pimperson.views.editview2.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'editview2', parameterName: 'editview2' },
            ],
            requireAuth: false,
        },
        component: () => import('@pages/pim/pimpersonedit-view2/pimpersonedit-view2.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/archivesrecordeditview/:archivesrecordeditview?',
        meta: {
            caption: 'entities.pimarchives.views.archivesrecordeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'archivesrecordeditview', parameterName: 'archivesrecordeditview' },
            ],
            requireAuth: false,
        },
        component: () => import('@pages/pim/pimarchivesarchives-record-edit-view/pimarchivesarchives-record-edit-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/archivesrecordeditview/:archivesrecordeditview?',
        meta: {
            caption: 'entities.pimarchives.views.archivesrecordeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'archivesrecordeditview', parameterName: 'archivesrecordeditview' },
            ],
            requireAuth: false,
        },
        component: () => import('@pages/pim/pimarchivesarchives-record-edit-view/pimarchivesarchives-record-edit-view.vue'),
    },
    {
        path: '/pimqualmajors/:pimqualmajor?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimqualmajor.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualmajorpickup-grid-view/pimqualmajorpickup-grid-view.vue'),
    },
            {
                path: '/pimvocationalredirectview/:pimvocationalredirectview?',
                meta: {
                    caption: 'entities.pimvocational.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimvocationalredirectview', parameterName: 'pimvocationalredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimvocationalredirect-view/pimvocationalredirect-view.vue'),
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
        path: '/pimpeople/:pimperson?/xscgeditview/:xscgeditview?',
        meta: {
            caption: 'entities.pimperson.views.xscgeditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'xscgeditview', parameterName: 'xscgeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonxscgedit-view/pimpersonxscgedit-view.vue'),
    },
    {
        path: '/pimexpaccounts/:pimexpaccount?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimexpaccount.views.gridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/guazhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexpaccounts', parameterName: 'pimexpaccount' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexpaccountgrid-view/pimexpaccountgrid-view.vue'),
    },
    {
        path: '/pimlabourcampanies/:pimlabourcampany?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimlabourcampany.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimlabourcampanypickup-grid-view/pimlabourcampanypickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpatents/:pimpatent?/editview/:editview?',
        meta: {
            caption: 'entities.pimpatent.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpatents', parameterName: 'pimpatent' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpatentedit-view/pimpatentedit-view.vue'),
    },
    {
        path: '/pimpatents/:pimpatent?/editview/:editview?',
        meta: {
            caption: 'entities.pimpatent.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpatents', parameterName: 'pimpatent' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpatentedit-view/pimpatentedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/personinfotreeexpview/:personinfotreeexpview?',
        meta: {
            caption: 'entities.pimperson.views.personinfotreeexpview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'personinfotreeexpview', parameterName: 'personinfotreeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonperson-info-tree-exp-view/pimpersonperson-info-tree-exp-view.vue'),
    },
            {
                path: '/pimvocationalcatalogredirectview/:pimvocationalcatalogredirectview?',
                meta: {
                    caption: 'entities.pimvocationalcatalog.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimvocationalcatalogredirectview', parameterName: 'pimvocationalcatalogredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimvocationalcatalogredirect-view/pimvocationalcatalogredirect-view.vue'),
            },
    {
        path: '/pimarchivesmanages/:pimarchivesmanage?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchivesmanage.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivesmanages', parameterName: 'pimarchivesmanage' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/archivesmanageedit-view/archivesmanageedit-view.vue'),
    },
            {
                path: '/pimarchivesloanandreturnredirectview/:pimarchivesloanandreturnredirectview?',
                meta: {
                    caption: 'entities.pimarchivesloanandreturn.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarchivesloanandreturnredirectview', parameterName: 'pimarchivesloanandreturnredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarchivesloanandreturnredirect-view/pimarchivesloanandreturnredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimpersonabilities/:pimpersonability?/editview/:editview?',
        meta: {
            caption: 'entities.pimpersonability.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpersonabilities', parameterName: 'pimpersonability' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimperson-ability-edit-view/pimperson-ability-edit-view.vue'),
    },
    {
        path: '/pimpersonabilities/:pimpersonability?/editview/:editview?',
        meta: {
            caption: 'entities.pimpersonability.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpersonabilities', parameterName: 'pimpersonability' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimperson-ability-edit-view/pimperson-ability-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchivesrecords/:pimarchivesrecord?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchivesrecord.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchivesrecords', parameterName: 'pimarchivesrecord' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesrecordedit-view/pimarchivesrecordedit-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/pimarchivesrecords/:pimarchivesrecord?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchivesrecord.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchivesrecords', parameterName: 'pimarchivesrecord' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesrecordedit-view/pimarchivesrecordedit-view.vue'),
    },
    {
        path: '/pimarchivesrecords/:pimarchivesrecord?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchivesrecord.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivesrecords', parameterName: 'pimarchivesrecord' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesrecordedit-view/pimarchivesrecordedit-view.vue'),
    },
    {
        path: '/pimarchivalcatalogues/:pimarchivalcatalogue?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pimarchivalcatalogue.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivalcatalogues', parameterName: 'pimarchivalcatalogue' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/archivalcataloguepickup-view/archivalcataloguepickup-view.vue'),
    },
    {
        path: '/pimtitlecatalogues/:pimtitlecatalogue?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pimtitlecatalogue.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlecataloguepickup-view/pimtitlecataloguepickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimeducations/:pimeducation?/editview/:editview?',
        meta: {
            caption: 'entities.pimeducation.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimeducationedit-view/pimeducationedit-view.vue'),
    },
    {
        path: '/pimeducations/:pimeducation?/editview/:editview?',
        meta: {
            caption: 'entities.pimeducation.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimeducationedit-view/pimeducationedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimcontract.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractgrid-view/pimcontractgrid-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimcontract.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractgrid-view/pimcontractgrid-view.vue'),
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
        component: () => import('@pages/orm/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
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
        component: () => import('@pages/orm/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
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
        path: '/pcmdetails/:pcmdetail?/editview/:editview?',
        meta: {
            caption: 'entities.pcmdetail.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pcmdetails', parameterName: 'pcmdetail' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pcmdetailedit-view/pcmdetailedit-view.vue'),
    },
    {
        path: '/pimsearchmodals/:pimsearchmodal?/editview/:editview?',
        meta: {
            caption: 'entities.pimsearchmodal.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimsearchmodals', parameterName: 'pimsearchmodal' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-search-modal-edit-view/pim-search-modal-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimachievements/:pimachievements?/editview/:editview?',
        meta: {
            caption: 'entities.pimachievements.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimachievements', parameterName: 'pimachievements' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimachievementsedit-view/pimachievementsedit-view.vue'),
    },
    {
        path: '/pimachievements/:pimachievements?/editview/:editview?',
        meta: {
            caption: 'entities.pimachievements.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimachievements', parameterName: 'pimachievements' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimachievementsedit-view/pimachievementsedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/gzryhmcgridview/:gzryhmcgridview?',
        meta: {
            caption: 'entities.pimperson.views.gzryhmcgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/guazhidaoqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'gzryhmcgridview', parameterName: 'gzryhmcgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersongzryhmcgrid-view/pimpersongzryhmcgrid-view.vue'),
    },
    {
        path: '/pimarchivescenters/:pimarchivescenter?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pimarchivescenter.views.pickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivescenters', parameterName: 'pimarchivescenter' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/archivescenterpickup-view/archivescenterpickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/pimworkgridview/:pimworkgridview?',
        meta: {
            caption: 'entities.pimworkhistory.views.pimworkgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'pimworkgridview', parameterName: 'pimworkgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimworkhistorypim-work-grid-view/pimworkhistorypim-work-grid-view.vue'),
    },
    {
        path: '/pimworkhistories/:pimworkhistory?/pimworkgridview/:pimworkgridview?',
        meta: {
            caption: 'entities.pimworkhistory.views.pimworkgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'pimworkgridview', parameterName: 'pimworkgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimworkhistorypim-work-grid-view/pimworkhistorypim-work-grid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/xjpickupgridview/:xjpickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.xjpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'xjpickupgridview', parameterName: 'xjpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-org-xj-pickup-grid-view/orm-org-xj-pickup-grid-view.vue'),
    },
            {
                path: '/pimarchiveschangeredirectview/:pimarchiveschangeredirectview?',
                meta: {
                    caption: 'entities.pimarchiveschange.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarchiveschangeredirectview', parameterName: 'pimarchiveschangeredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarchiveschangeredirect-view/pimarchiveschangeredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/wssgridview/:wssgridview?',
        meta: {
            caption: 'entities.pimcontract.views.wssgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'wssgridview', parameterName: 'wssgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractwssgrid-view/pimcontractwssgrid-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/wssgridview/:wssgridview?',
        meta: {
            caption: 'entities.pimcontract.views.wssgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'wssgridview', parameterName: 'wssgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractwssgrid-view/pimcontractwssgrid-view.vue'),
    },
    {
        path: '/ormsignorgs/:ormsignorg?/bdwpickupgridview/:bdwpickupgridview?',
        meta: {
            caption: 'entities.ormsignorg.views.bdwpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'bdwpickupgridview', parameterName: 'bdwpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-sign-org-bdwpickup-grid-view/orm-sign-org-bdwpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/lwgridview/:lwgridview?',
        meta: {
            caption: 'entities.pimcontract.views.lwgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'lwgridview', parameterName: 'lwgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractlwgrid-view/pimcontractlwgrid-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/lwgridview/:lwgridview?',
        meta: {
            caption: 'entities.pimcontract.views.lwgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'lwgridview', parameterName: 'lwgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractlwgrid-view/pimcontractlwgrid-view.vue'),
    },
    {
        path: '/pimcontracttypes/:pimcontracttype?/editview/:editview?',
        meta: {
            caption: 'entities.pimcontracttype.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongleixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracttypes', parameterName: 'pimcontracttype' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontracttypeedit-view/pimcontracttypeedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimarchives.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesgrid-view/pimarchivesgrid-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimarchives.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesgrid-view/pimarchivesgrid-view.vue'),
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
        component: () => import('@pages/trm/trmtrianpersonedit-view/trmtrianpersonedit-view.vue'),
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
        component: () => import('@pages/trm/trmtrianpersonedit-view/trmtrianpersonedit-view.vue'),
    },
    {
        path: '/ormsignorgs/:ormsignorg?/htqddwpickupgridview/:htqddwpickupgridview?',
        meta: {
            caption: 'entities.ormsignorg.views.htqddwpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'htqddwpickupgridview', parameterName: 'htqddwpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-sign-org-htqddwpickup-grid-view/orm-sign-org-htqddwpickup-grid-view.vue'),
    },
    {
        path: '/pimqualtypes/:pimqualtype?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimqualtype.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimqualtypes', parameterName: 'pimqualtype' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualtypepickup-grid-view/pimqualtypepickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimvocationals/:pimvocational?/wsseditview/:wsseditview?',
        meta: {
            caption: 'entities.pimvocational.views.wsseditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'wsseditview', parameterName: 'wsseditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimvocationalwssedit-view/pimvocationalwssedit-view.vue'),
    },
    {
        path: '/pimvocationals/:pimvocational?/wsseditview/:wsseditview?',
        meta: {
            caption: 'entities.pimvocational.views.wsseditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'wsseditview', parameterName: 'wsseditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimvocationalwssedit-view/pimvocationalwssedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/zdeditview/:zdeditview?',
        meta: {
            caption: 'entities.pimperson.views.zdeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'zdeditview', parameterName: 'zdeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonzdedit-view/pimpersonzdedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarmycadres/:pimarmycadres?/editview/:editview?',
        meta: {
            caption: 'entities.pimarmycadres.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarmycadresedit-view/pimarmycadresedit-view.vue'),
    },
    {
        path: '/pimarmycadres/:pimarmycadres?/editview/:editview?',
        meta: {
            caption: 'entities.pimarmycadres.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarmycadresedit-view/pimarmycadresedit-view.vue'),
    },
    {
        path: '/pimarchivescenters/:pimarchivescenter?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimarchivescenter.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivescenters', parameterName: 'pimarchivescenter' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/archivescenterpickup-grid-view/archivescenterpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/signremindgridview/:signremindgridview?',
        meta: {
            caption: 'entities.pimcontract.views.signremindgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'signremindgridview', parameterName: 'signremindgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractsign-remind-grid-view/pimcontractsign-remind-grid-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/signremindgridview/:signremindgridview?',
        meta: {
            caption: 'entities.pimcontract.views.signremindgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'signremindgridview', parameterName: 'signremindgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractsign-remind-grid-view/pimcontractsign-remind-grid-view.vue'),
    },
            {
                path: '/pimpersonabilitydetailredirectview/:pimpersonabilitydetailredirectview?',
                meta: {
                    caption: 'entities.pimpersonabilitydetail.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpersonabilitydetailredirectview', parameterName: 'pimpersonabilitydetailredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimperson-ability-detail-redirect-view/pimperson-ability-detail-redirect-view.vue'),
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
        component: () => import('@pages/orm/ormorgsectorfpxxpickup-grid-view/ormorgsectorfpxxpickup-grid-view.vue'),
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
        component: () => import('@pages/orm/ormorgsectorfpxxpickup-grid-view/ormorgsectorfpxxpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/ygfenpeigridview/:ygfenpeigridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.ygfenpeigridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'ygfenpeigridview', parameterName: 'ygfenpeigridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimdistirbutionygfen-pei-grid-view/pimdistirbutionygfen-pei-grid-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/ygfenpeigridview/:ygfenpeigridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.ygfenpeigridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'ygfenpeigridview', parameterName: 'ygfenpeigridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimdistirbutionygfen-pei-grid-view/pimdistirbutionygfen-pei-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimvocationals/:pimvocational?/editview/:editview?',
        meta: {
            caption: 'entities.pimvocational.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimvocationaledit-view/pimvocationaledit-view.vue'),
    },
    {
        path: '/pimvocationals/:pimvocational?/editview/:editview?',
        meta: {
            caption: 'entities.pimvocational.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimvocationaledit-view/pimvocationaledit-view.vue'),
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
        component: () => import('@pages/orm/ormorgfpxxpickup-view/ormorgfpxxpickup-view.vue'),
    },
            {
                path: '/pimsearchmodalredirectview/:pimsearchmodalredirectview?',
                meta: {
                    caption: 'entities.pimsearchmodal.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimsearchmodalredirectview', parameterName: 'pimsearchmodalredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pim-search-modal-redirect-view/pim-search-modal-redirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/jxqyggridview/:jxqyggridview?',
        meta: {
            caption: 'entities.pimperson.views.jxqyggridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/jianxiqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'jxqyggridview', parameterName: 'jxqyggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonjxqyggrid-view/pimpersonjxqyggrid-view.vue'),
    },
            {
                path: '/pimarmycadresredirectview/:pimarmycadresredirectview?',
                meta: {
                    caption: 'entities.pimarmycadres.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarmycadresredirectview', parameterName: 'pimarmycadresredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarmycadresredirect-view/pimarmycadresredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/lweditview/:lweditview?',
        meta: {
            caption: 'entities.pimcontract.views.lweditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'lweditview', parameterName: 'lweditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractlwedit-view/pimcontractlwedit-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/lweditview/:lweditview?',
        meta: {
            caption: 'entities.pimcontract.views.lweditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'lweditview', parameterName: 'lweditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractlwedit-view/pimcontractlwedit-view.vue'),
    },
            {
                path: '/pimpersonabilityredirectview/:pimpersonabilityredirectview?',
                meta: {
                    caption: 'entities.pimpersonability.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpersonabilityredirectview', parameterName: 'pimpersonabilityredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimperson-ability-redirect-view/pimperson-ability-redirect-view.vue'),
            },
            {
                path: '/pimarchivesrecordredirectview/:pimarchivesrecordredirectview?',
                meta: {
                    caption: 'entities.pimarchivesrecord.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimarchivesrecordredirectview', parameterName: 'pimarchivesrecordredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimarchivesrecordredirect-view/pimarchivesrecordredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/zddeditview/:zddeditview?',
        meta: {
            caption: 'entities.pimperson.views.zddeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'zddeditview', parameterName: 'zddeditview' },
            ],
            requireAuth: false,
        },
        component: () => import('@pages/pim/pimpersonzddedit-view/pimpersonzddedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimarchiveschange.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimarchiveschange.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
    },
    {
        path: '/pimarchiveschanges/:pimarchiveschange?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimarchiveschange.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/pimfimgridview/:pimfimgridview?',
        meta: {
            caption: 'entities.pimfaminfo.views.pimfimgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'pimfimgridview', parameterName: 'pimfimgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimfaminfopimfim-grid-view/pimfaminfopimfim-grid-view.vue'),
    },
    {
        path: '/pimfaminfos/:pimfaminfo?/pimfimgridview/:pimfimgridview?',
        meta: {
            caption: 'entities.pimfaminfo.views.pimfimgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'pimfimgridview', parameterName: 'pimfimgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimfaminfopimfim-grid-view/pimfaminfopimfim-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchives.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesedit-view/pimarchivesedit-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchives.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesedit-view/pimarchivesedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/maturitydueeditview/:maturitydueeditview?',
        meta: {
            caption: 'entities.pimdistirbution.views.maturitydueeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/jiediaodaoqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'maturitydueeditview', parameterName: 'maturitydueeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimdistirbutionmaturity-due-edit-view/pimdistirbutionmaturity-due-edit-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/maturitydueeditview/:maturitydueeditview?',
        meta: {
            caption: 'entities.pimdistirbution.views.maturitydueeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/jiediaodaoqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'maturitydueeditview', parameterName: 'maturitydueeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimdistirbutionmaturity-due-edit-view/pimdistirbutionmaturity-due-edit-view.vue'),
    },
    {
        path: '/pimtitlecatalogues/:pimtitlecatalogue?/notpickupgridview/:notpickupgridview?',
        meta: {
            caption: 'entities.pimtitlecatalogue.views.notpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                { pathName: 'notpickupgridview', parameterName: 'notpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlecataloguenot-pickup-grid-view/pimtitlecataloguenot-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/pimjanglgridview/:pimjanglgridview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.pimjanglgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'pimjanglgridview', parameterName: 'pimjanglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimrewardpunishmentpim-jangl-grid-view/pimrewardpunishmentpim-jangl-grid-view.vue'),
    },
    {
        path: '/pimrewardpunishments/:pimrewardpunishment?/pimjanglgridview/:pimjanglgridview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.pimjanglgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'pimjanglgridview', parameterName: 'pimjanglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimrewardpunishmentpim-jangl-grid-view/pimrewardpunishmentpim-jangl-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimvocationals/:pimvocational?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimvocational.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimvocationalgrid-view/pimvocationalgrid-view.vue'),
    },
    {
        path: '/pimvocationals/:pimvocational?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimvocational.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimvocationalgrid-view/pimvocationalgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview/:editview?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view/pimexitandentryedit-view.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/editview/:editview?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view/pimexitandentryedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.pimcontract.views.treeexpview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontracttree-exp-view/pimcontracttree-exp-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.pimcontract.views.treeexpview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontracttree-exp-view/pimcontracttree-exp-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/editview/:editview?',
        meta: {
            caption: 'entities.pimfaminfo.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimfaminfoedit-view/pimfaminfoedit-view.vue'),
    },
    {
        path: '/pimfaminfos/:pimfaminfo?/editview/:editview?',
        meta: {
            caption: 'entities.pimfaminfo.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimfaminfoedit-view/pimfaminfoedit-view.vue'),
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
        component: () => import('@pages/orm/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
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
        component: () => import('@pages/orm/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/hisrecgridview/:hisrecgridview?',
        meta: {
            caption: 'entities.pimpersonchange.views.hisrecgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'hisrecgridview', parameterName: 'hisrecgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangehis-rec-grid-view/pimpersonchangehis-rec-grid-view.vue'),
    },
    {
        path: '/pimpersonchanges/:pimpersonchange?/hisrecgridview/:hisrecgridview?',
        meta: {
            caption: 'entities.pimpersonchange.views.hisrecgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'hisrecgridview', parameterName: 'hisrecgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangehis-rec-grid-view/pimpersonchangehis-rec-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/noloyeenofilegridview/:noloyeenofilegridview?',
        meta: {
            caption: 'entities.pimarchives.views.noloyeenofilegridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'noloyeenofilegridview', parameterName: 'noloyeenofilegridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesnoloyeenofilegrid-view/pimarchivesnoloyeenofilegrid-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/noloyeenofilegridview/:noloyeenofilegridview?',
        meta: {
            caption: 'entities.pimarchives.views.noloyeenofilegridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'noloyeenofilegridview', parameterName: 'noloyeenofilegridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesnoloyeenofilegrid-view/pimarchivesnoloyeenofilegrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/reneweditview/:reneweditview?',
        meta: {
            caption: 'entities.pimcontract.views.reneweditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'reneweditview', parameterName: 'reneweditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractrenew-edit-view/pimcontractrenew-edit-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/reneweditview/:reneweditview?',
        meta: {
            caption: 'entities.pimcontract.views.reneweditview.title',
            info:'',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'reneweditview', parameterName: 'reneweditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractrenew-edit-view/pimcontractrenew-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/hmdgridview/:hmdgridview?',
        meta: {
            caption: 'entities.pimperson.views.hmdgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'hmdgridview', parameterName: 'hmdgridview' },
            ],
            requireAuth: false,
        },
        component: () => import('@pages/pim/pimpersonhmdgrid-view/pimpersonhmdgrid-view.vue'),
    },
            {
                path: '/archivalcatalogueredirectview/:archivalcatalogueredirectview?',
                meta: {
                    caption: 'entities.pimarchivalcatalogue.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'archivalcatalogueredirectview', parameterName: 'archivalcatalogueredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/archivalcatalogueredirect-view/archivalcatalogueredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimvocationals/:pimvocational?/pimziggridview/:pimziggridview?',
        meta: {
            caption: 'entities.pimvocational.views.pimziggridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'pimziggridview', parameterName: 'pimziggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimvocationalpim-zig-grid-view/pimvocationalpim-zig-grid-view.vue'),
    },
    {
        path: '/pimvocationals/:pimvocational?/pimziggridview/:pimziggridview?',
        meta: {
            caption: 'entities.pimvocational.views.pimziggridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'pimziggridview', parameterName: 'pimziggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimvocationalpim-zig-grid-view/pimvocationalpim-zig-grid-view.vue'),
    },
    {
        path: '/pimtitlecatalogues/:pimtitlecatalogue?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimtitlecatalogue.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlecataloguepickup-grid-view/pimtitlecataloguepickup-grid-view.vue'),
    },
            {
                path: '/pimenclosureredirectview/:pimenclosureredirectview?',
                meta: {
                    caption: 'entities.pimenclosure.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimenclosureredirectview', parameterName: 'pimenclosureredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimenclosureredirect-view/pimenclosureredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/yscgjxjeditview/:yscgjxjeditview?',
        meta: {
            caption: 'entities.pimexitandentry.views.yscgjxjeditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'yscgjxjeditview', parameterName: 'yscgjxjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryyscgjxjedit-view/pimexitandentryyscgjxjedit-view.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/yscgjxjeditview/:yscgjxjeditview?',
        meta: {
            caption: 'entities.pimexitandentry.views.yscgjxjeditview.title',
            info:'',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'yscgjxjeditview', parameterName: 'yscgjxjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryyscgjxjedit-view/pimexitandentryyscgjxjedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimeducations/:pimeducation?/pimedugridview/:pimedugridview?',
        meta: {
            caption: 'entities.pimeducation.views.pimedugridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'pimedugridview', parameterName: 'pimedugridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimeducationpim-edu-grid-view/pimeducationpim-edu-grid-view.vue'),
    },
    {
        path: '/pimeducations/:pimeducation?/pimedugridview/:pimedugridview?',
        meta: {
            caption: 'entities.pimeducation.views.pimedugridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'pimedugridview', parameterName: 'pimedugridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimeducationpim-edu-grid-view/pimeducationpim-edu-grid-view.vue'),
    },
    {
        path: '/pimvocationalcatalogs/:pimvocationalcatalog?/editview/:editview?',
        meta: {
            caption: 'entities.pimvocationalcatalog.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezigemuluguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimvocationalcatalogs', parameterName: 'pimvocationalcatalog' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimvocationalcatalogedit-view/pimvocationalcatalogedit-view.vue'),
    },
            {
                path: '/pimcontractredirectview/:pimcontractredirectview?',
                meta: {
                    caption: 'entities.pimcontract.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimcontractredirectview', parameterName: 'pimcontractredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimcontractredirect-view/pimcontractredirect-view.vue'),
            },
    {
        path: '/pimportalview/:pimportalview?',
        meta: {
            caption: 'app.views.pimportalview.title',
            info:'',
            parameters: [
                { pathName: 'pimportalview', parameterName: 'pimportalview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/portal/pim-portal-view/pim-portal-view.vue'),
    },
    {
        path: '/pimlabourcampanies/:pimlabourcampany?/editview/:editview?',
        meta: {
            caption: 'entities.pimlabourcampany.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/laowupaiqiangongsiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimlabourcampanyedit-view/pimlabourcampanyedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/editview/:editview?',
        meta: {
            caption: 'entities.pimperson.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonedit-view/pimpersonedit-view.vue'),
    },
            {
                path: '/pimtypecontractredirectview/:pimtypecontractredirectview?',
                meta: {
                    caption: 'entities.pimtypecontract.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimtypecontractredirectview', parameterName: 'pimtypecontractredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimtypecontractredirect-view/pimtypecontractredirect-view.vue'),
            },
            {
                path: '/pimlabourcampanyredirectview/:pimlabourcampanyredirectview?',
                meta: {
                    caption: 'entities.pimlabourcampany.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimlabourcampanyredirectview', parameterName: 'pimlabourcampanyredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimlabourcampanyredirect-view/pimlabourcampanyredirect-view.vue'),
            },
    {
        path: '/pimlabourcampanies/:pimlabourcampany?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimlabourcampany.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/laowupaiqiangongsiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimlabourcampanygrid-view/pimlabourcampanygrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/reasoneditview/:reasoneditview?',
        meta: {
            caption: 'entities.pimpersonchange.views.reasoneditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'reasoneditview', parameterName: 'reasoneditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangereason-edit-view/pimpersonchangereason-edit-view.vue'),
    },
    {
        path: '/pimpersonchanges/:pimpersonchange?/reasoneditview/:reasoneditview?',
        meta: {
            caption: 'entities.pimpersonchange.views.reasoneditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'reasoneditview', parameterName: 'reasoneditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangereason-edit-view/pimpersonchangereason-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/quickeditview/:quickeditview?',
        meta: {
            caption: 'entities.pimperson.views.quickeditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'quickeditview', parameterName: 'quickeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonquick-edit-view/pimpersonquick-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_spz/:editview_spz?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_spz.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_spz', parameterName: 'editview_spz' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-spz/pimexitandentryedit-view-spz.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/editview_spz/:editview_spz?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_spz.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_spz', parameterName: 'editview_spz' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-spz/pimexitandentryedit-view-spz.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/yscgjgridview/:yscgjgridview?',
        meta: {
            caption: 'entities.pimexitandentry.views.yscgjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'yscgjgridview', parameterName: 'yscgjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryyscgjgrid-view/pimexitandentryyscgjgrid-view.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/yscgjgridview/:yscgjgridview?',
        meta: {
            caption: 'entities.pimexitandentry.views.yscgjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'yscgjgridview', parameterName: 'yscgjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryyscgjgrid-view/pimexitandentryyscgjgrid-view.vue'),
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
        path: '/ormorgs/:ormorg?/htgldwqpickupgridview/:htgldwqpickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.htgldwqpickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'htgldwqpickupgridview', parameterName: 'htgldwqpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorghtgldwqpickup-grid-view/ormorghtgldwqpickup-grid-view.vue'),
    },
            {
                path: '/pimsearchfieldsetredirectview/:pimsearchfieldsetredirectview?',
                meta: {
                    caption: 'entities.pimsearchfieldset.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimsearchfieldsetredirectview', parameterName: 'pimsearchfieldsetredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pim-search-field-set-redirect-view/pim-search-field-set-redirect-view.vue'),
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
        component: () => import('@pages/pim/pimpersonpickup-grid-view/pimpersonpickup-grid-view.vue'),
    },
    {
        path: '/pimenclosures/:pimenclosure?/editview/:editview?',
        meta: {
            caption: 'entities.pimenclosure.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/fujianxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimenclosures', parameterName: 'pimenclosure' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimenclosureedit-view/pimenclosureedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_ybh/:editview_ybh?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_ybh.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_ybh', parameterName: 'editview_ybh' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-ybh/pimexitandentryedit-view-ybh.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/editview_ybh/:editview_ybh?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_ybh.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_ybh', parameterName: 'editview_ybh' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-ybh/pimexitandentryedit-view-ybh.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/editview/:editview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimrewardpunishmentedit-view/pimrewardpunishmentedit-view.vue'),
    },
    {
        path: '/pimrewardpunishments/:pimrewardpunishment?/editview/:editview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimrewardpunishmentedit-view/pimrewardpunishmentedit-view.vue'),
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
        component: () => import('@pages/pim/pimdistirbutionedit-view/pimdistirbutionedit-view.vue'),
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
        component: () => import('@pages/pim/pimdistirbutionedit-view/pimdistirbutionedit-view.vue'),
    },
    {
        path: '/pimtitlecatalogues/:pimtitlecatalogue?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimtitlecatalogue.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengmuluguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlecataloguegrid-view/pimtitlecataloguegrid-view.vue'),
    },
    {
        path: '/pimarchivescenters/:pimarchivescenter?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchivescenter.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivescenters', parameterName: 'pimarchivescenter' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/archivescenteredit-view/archivescenteredit-view.vue'),
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
        path: '/pimpeople/:pimperson?/pimtitles/:pimtitle?/pimzhicgridview/:pimzhicgridview?',
        meta: {
            caption: 'entities.pimtitle.views.pimzhicgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunjihua.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'pimzhicgridview', parameterName: 'pimzhicgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlepim-zhic-grid-view/pimtitlepim-zhic-grid-view.vue'),
    },
    {
        path: '/pimtitles/:pimtitle?/pimzhicgridview/:pimzhicgridview?',
        meta: {
            caption: 'entities.pimtitle.views.pimzhicgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunjihua.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'pimzhicgridview', parameterName: 'pimzhicgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlepim-zhic-grid-view/pimtitlepim-zhic-grid-view.vue'),
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
        component: () => import('@pages/orm/ormorgsectorfpxxpickup-view/ormorgsectorfpxxpickup-view.vue'),
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
        component: () => import('@pages/orm/ormorgsectorfpxxpickup-view/ormorgsectorfpxxpickup-view.vue'),
    },
    {
        path: '/pimtitlecatalogues/:pimtitlecatalogue?/editview/:editview?',
        meta: {
            caption: 'entities.pimtitlecatalogue.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengmuluguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlecatalogueedit-view/pimtitlecatalogueedit-view.vue'),
    },
            {
                path: '/pimtitlecatalogueredirectview/:pimtitlecatalogueredirectview?',
                meta: {
                    caption: 'entities.pimtitlecatalogue.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimtitlecatalogueredirectview', parameterName: 'pimtitlecatalogueredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimtitlecatalogueredirect-view/pimtitlecatalogueredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/zhzceditview/:zhzceditview?',
        meta: {
            caption: 'entities.pimperson.views.zhzceditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'zhzceditview', parameterName: 'zhzceditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonzhzcedit-view/pimpersonzhzcedit-view.vue'),
    },
            {
                path: '/archivescenterredirectview/:archivescenterredirectview?',
                meta: {
                    caption: 'entities.pimarchivescenter.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'archivescenterredirectview', parameterName: 'archivescenterredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/archivescenterredirect-view/archivescenterredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/editview/:editview?',
        meta: {
            caption: 'entities.pimcontract.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractedit-view/pimcontractedit-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/editview/:editview?',
        meta: {
            caption: 'entities.pimcontract.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractedit-view/pimcontractedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/ltxyggridview/:ltxyggridview?',
        meta: {
            caption: 'entities.pimperson.views.ltxyggridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/tuixiuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'ltxyggridview', parameterName: 'ltxyggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonltxyggrid-view/pimpersonltxyggrid-view.vue'),
    },
    {
        path: '/ormsignorgs/:ormsignorg?/bdwpickupview/:bdwpickupview?',
        meta: {
            caption: 'entities.ormsignorg.views.bdwpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'bdwpickupview', parameterName: 'bdwpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-sign-org-bdwpickup-view/orm-sign-org-bdwpickup-view.vue'),
    },
            {
                path: '/pimrewardpunishmentredirectview/:pimrewardpunishmentredirectview?',
                meta: {
                    caption: 'entities.pimrewardpunishment.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimrewardpunishmentredirectview', parameterName: 'pimrewardpunishmentredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimrewardpunishmentredirect-view/pimrewardpunishmentredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/ygcgjgridview/:ygcgjgridview?',
        meta: {
            caption: 'entities.pimexitandentry.views.ygcgjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'ygcgjgridview', parameterName: 'ygcgjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryygcgjgrid-view/pimexitandentryygcgjgrid-view.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/ygcgjgridview/:ygcgjgridview?',
        meta: {
            caption: 'entities.pimexitandentry.views.ygcgjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'ygcgjgridview', parameterName: 'ygcgjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryygcgjgrid-view/pimexitandentryygcgjgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.pimarchives.views.treeexpview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivestree-exp-view/pimarchivestree-exp-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.pimarchives.views.treeexpview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivestree-exp-view/pimarchivestree-exp-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimresearchfindings/:pimresearchfindings?/editview/:editview?',
        meta: {
            caption: 'entities.pimresearchfindings.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/keyanchengguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimresearchfindingsedit-view/pimresearchfindingsedit-view.vue'),
    },
    {
        path: '/pimresearchfindings/:pimresearchfindings?/editview/:editview?',
        meta: {
            caption: 'entities.pimresearchfindings.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/keyanchengguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimresearchfindingsedit-view/pimresearchfindingsedit-view.vue'),
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
        path: '/pimpeople/:pimperson?/pimpersonchanges/:pimpersonchange?/readeditview/:readeditview?',
        meta: {
            caption: 'entities.pimpersonchange.views.readeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'readeditview', parameterName: 'readeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangeread-edit-view/pimpersonchangeread-edit-view.vue'),
    },
    {
        path: '/pimpersonchanges/:pimpersonchange?/readeditview/:readeditview?',
        meta: {
            caption: 'entities.pimpersonchange.views.readeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xinyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpersonchanges', parameterName: 'pimpersonchange' },
                { pathName: 'readeditview', parameterName: 'readeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonchangeread-edit-view/pimpersonchangeread-edit-view.vue'),
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
        path: '/pimpeople/:pimperson?/pimtitles/:pimtitle?/editview/:editview?',
        meta: {
            caption: 'entities.pimtitle.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunjihua.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitleedit-view/pimtitleedit-view.vue'),
    },
    {
        path: '/pimtitles/:pimtitle?/editview/:editview?',
        meta: {
            caption: 'entities.pimtitle.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunjihua.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitleedit-view/pimtitleedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/syqyggridview/:syqyggridview?',
        meta: {
            caption: 'entities.pimperson.views.syqyggridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/shiyongqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'syqyggridview', parameterName: 'syqyggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonsyqyggrid-view/pimpersonsyqyggrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchiveschange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchiveschange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
    },
    {
        path: '/pimarchiveschanges/:pimarchiveschange?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchiveschange.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimlanguageabilities/:pimlanguageability?/editview/:editview?',
        meta: {
            caption: 'entities.pimlanguageability.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimlanguageabilityedit-view/pimlanguageabilityedit-view.vue'),
    },
    {
        path: '/pimlanguageabilities/:pimlanguageability?/editview/:editview?',
        meta: {
            caption: 'entities.pimlanguageability.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimlanguageabilityedit-view/pimlanguageabilityedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpapers/:pimpaper?/papergridview/:papergridview?',
        meta: {
            caption: 'entities.pimpaper.views.papergridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpapers', parameterName: 'pimpaper' },
                { pathName: 'papergridview', parameterName: 'papergridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpaperpapergrid-view/pimpaperpapergrid-view.vue'),
    },
    {
        path: '/pimpapers/:pimpaper?/papergridview/:papergridview?',
        meta: {
            caption: 'entities.pimpaper.views.papergridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpapers', parameterName: 'pimpaper' },
                { pathName: 'papergridview', parameterName: 'papergridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpaperpapergrid-view/pimpaperpapergrid-view.vue'),
    },
            {
                path: '/pimcontracttyperedirectview/:pimcontracttyperedirectview?',
                meta: {
                    caption: 'entities.pimcontracttype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimcontracttyperedirectview', parameterName: 'pimcontracttyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimcontracttyperedirect-view/pimcontracttyperedirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/pimdangagridview/:pimdangagridview?',
        meta: {
            caption: 'entities.pimarchives.views.pimdangagridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimdangagridview', parameterName: 'pimdangagridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivespim-danga-grid-view/pimarchivespim-danga-grid-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/pimdangagridview/:pimdangagridview?',
        meta: {
            caption: 'entities.pimarchives.views.pimdangagridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimdangagridview', parameterName: 'pimdangagridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivespim-danga-grid-view/pimarchivespim-danga-grid-view.vue'),
    },
            {
                path: '/pimachievementsredirectview/:pimachievementsredirectview?',
                meta: {
                    caption: 'entities.pimachievements.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimachievementsredirectview', parameterName: 'pimachievementsredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimachievementsredirect-view/pimachievementsredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/ryinfoeditview/:ryinfoeditview?',
        meta: {
            caption: 'entities.pimperson.views.ryinfoeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gerenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'ryinfoeditview', parameterName: 'ryinfoeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonryinfo-edit-view/pimpersonryinfo-edit-view.vue'),
    },
            {
                path: '/pimpersonchangeredirectview/:pimpersonchangeredirectview?',
                meta: {
                    caption: 'entities.pimpersonchange.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpersonchangeredirectview', parameterName: 'pimpersonchangeredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimpersonchangeredirect-view/pimpersonchangeredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/ygcgjxjeditview/:ygcgjxjeditview?',
        meta: {
            caption: 'entities.pimexitandentry.views.ygcgjxjeditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'ygcgjxjeditview', parameterName: 'ygcgjxjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryygcgjxjedit-view/pimexitandentryygcgjxjedit-view.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/ygcgjxjeditview/:ygcgjxjeditview?',
        meta: {
            caption: 'entities.pimexitandentry.views.ygcgjxjeditview.title',
            info:'',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'ygcgjxjeditview', parameterName: 'ygcgjxjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryygcgjxjedit-view/pimexitandentryygcgjxjedit-view.vue'),
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
        component: () => import('@pages/orm/ormorgfpxxpickup-grid-view/ormorgfpxxpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarmycadres/:pimarmycadres?/armygridview/:armygridview?',
        meta: {
            caption: 'entities.pimarmycadres.views.armygridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                { pathName: 'armygridview', parameterName: 'armygridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarmycadresarmygrid-view/pimarmycadresarmygrid-view.vue'),
    },
    {
        path: '/pimarmycadres/:pimarmycadres?/armygridview/:armygridview?',
        meta: {
            caption: 'entities.pimarmycadres.views.armygridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                { pathName: 'armygridview', parameterName: 'armygridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarmycadresarmygrid-view/pimarmycadresarmygrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpatents/:pimpatent?/patentgridview/:patentgridview?',
        meta: {
            caption: 'entities.pimpatent.views.patentgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpatents', parameterName: 'pimpatent' },
                { pathName: 'patentgridview', parameterName: 'patentgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpatentpatentgrid-view/pimpatentpatentgrid-view.vue'),
    },
    {
        path: '/pimpatents/:pimpatent?/patentgridview/:patentgridview?',
        meta: {
            caption: 'entities.pimpatent.views.patentgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpatents', parameterName: 'pimpatent' },
                { pathName: 'patentgridview', parameterName: 'patentgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpatentpatentgrid-view/pimpatentpatentgrid-view.vue'),
    },
    {
        path: '/pimarchivescenters/:pimarchivescenter?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimarchivescenter.views.gridview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivescenters', parameterName: 'pimarchivescenter' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/archivescentergrid-view/archivescentergrid-view.vue'),
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
        component: () => import('@pages/pim/contract-sign-orgedit-view/contract-sign-orgedit-view.vue'),
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
        component: () => import('@pages/pim/contract-sign-orgedit-view/contract-sign-orgedit-view.vue'),
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
        component: () => import('@pages/pim/contract-sign-orgedit-view/contract-sign-orgedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpapers/:pimpaper?/editview/:editview?',
        meta: {
            caption: 'entities.pimpaper.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpapers', parameterName: 'pimpaper' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpaperedit-view/pimpaperedit-view.vue'),
    },
    {
        path: '/pimpapers/:pimpaper?/editview/:editview?',
        meta: {
            caption: 'entities.pimpaper.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpapers', parameterName: 'pimpaper' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpaperedit-view/pimpaperedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchivesloanandreturns/:pimarchivesloanandreturn?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchivesloanandreturn.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/pimarchivesloanandreturns/:pimarchivesloanandreturn?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchivesloanandreturn.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
    },
    {
        path: '/pimarchivesloanandreturns/:pimarchivesloanandreturn?/editview/:editview?',
        meta: {
            caption: 'entities.pimarchivesloanandreturn.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/formpickupview/:formpickupview?',
        meta: {
            caption: 'entities.pimexitandentry.views.formpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'formpickupview', parameterName: 'formpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryform-pickup-view/pimexitandentryform-pickup-view.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/formpickupview/:formpickupview?',
        meta: {
            caption: 'entities.pimexitandentry.views.formpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'formpickupview', parameterName: 'formpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryform-pickup-view/pimexitandentryform-pickup-view.vue'),
    },
            {
                path: '/pimdistirbutionredirectview/:pimdistirbutionredirectview?',
                meta: {
                    caption: 'entities.pimdistirbution.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimdistirbutionredirectview', parameterName: 'pimdistirbutionredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimdistirbutionredirect-view/pimdistirbutionredirect-view.vue'),
            },
    {
        path: '/pimtitlecatalogues/:pimtitlecatalogue?/notpickupview/:notpickupview?',
        meta: {
            caption: 'entities.pimtitlecatalogue.views.notpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimtitlecatalogues', parameterName: 'pimtitlecatalogue' },
                { pathName: 'notpickupview', parameterName: 'notpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtitlecataloguenot-pickup-view/pimtitlecataloguenot-pickup-view.vue'),
    },
    {
        path: '/pimqualmajors/:pimqualmajor?/editview/:editview?',
        meta: {
            caption: 'entities.pimqualmajor.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunkecheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualmajoredit-view/pimqualmajoredit-view.vue'),
    },
            {
                path: '/pimexpaccountredirectview/:pimexpaccountredirectview?',
                meta: {
                    caption: 'entities.pimexpaccount.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimexpaccountredirectview', parameterName: 'pimexpaccountredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimexpaccountredirect-view/pimexpaccountredirect-view.vue'),
            },
            {
                path: '/pimresearchfindingsredirectview/:pimresearchfindingsredirectview?',
                meta: {
                    caption: 'entities.pimresearchfindings.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimresearchfindingsredirectview', parameterName: 'pimresearchfindingsredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimresearchfindingsredirect-view/pimresearchfindingsredirect-view.vue'),
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
                component: () => import('@pages/pim/contract-sign-orgredirect-view/contract-sign-orgredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/gbllgridview/:gbllgridview?',
        meta: {
            caption: 'entities.pimworkhistory.views.gbllgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'gbllgridview', parameterName: 'gbllgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimworkhistorygbllgrid-view/pimworkhistorygbllgrid-view.vue'),
    },
    {
        path: '/pimworkhistories/:pimworkhistory?/gbllgridview/:gbllgridview?',
        meta: {
            caption: 'entities.pimworkhistory.views.gbllgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'gbllgridview', parameterName: 'gbllgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimworkhistorygbllgrid-view/pimworkhistorygbllgrid-view.vue'),
    },
            {
                path: '/pimtitleredirectview/:pimtitleredirectview?',
                meta: {
                    caption: 'entities.pimtitle.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimtitleredirectview', parameterName: 'pimtitleredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimtitleredirect-view/pimtitleredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimresearchfindings/:pimresearchfindings?/researchgridview/:researchgridview?',
        meta: {
            caption: 'entities.pimresearchfindings.views.researchgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/keyanchengguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                { pathName: 'researchgridview', parameterName: 'researchgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimresearchfindingsresearchgrid-view/pimresearchfindingsresearchgrid-view.vue'),
    },
    {
        path: '/pimresearchfindings/:pimresearchfindings?/researchgridview/:researchgridview?',
        meta: {
            caption: 'entities.pimresearchfindings.views.researchgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/keyanchengguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                { pathName: 'researchgridview', parameterName: 'researchgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimresearchfindingsresearchgrid-view/pimresearchfindingsresearchgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/stoptimeselecteditview/:stoptimeselecteditview?',
        meta: {
            caption: 'entities.pimcontract.views.stoptimeselecteditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'stoptimeselecteditview', parameterName: 'stoptimeselecteditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractstop-time-select-edit-view/pimcontractstop-time-select-edit-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/stoptimeselecteditview/:stoptimeselecteditview?',
        meta: {
            caption: 'entities.pimcontract.views.stoptimeselecteditview.title',
            info:'',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'stoptimeselecteditview', parameterName: 'stoptimeselecteditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontractstop-time-select-edit-view/pimcontractstop-time-select-edit-view.vue'),
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
        component: () => import('@pages/pim/pimpersonpickup-view/pimpersonpickup-view.vue'),
    },
            {
                path: '/pimqualtyperedirectview/:pimqualtyperedirectview?',
                meta: {
                    caption: 'entities.pimqualtype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimqualtyperedirectview', parameterName: 'pimqualtyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimqualtyperedirect-view/pimqualtyperedirect-view.vue'),
            },
    {
        path: '/trmlgbcosts/:trmlgbcost?/gridview/:gridview?',
        meta: {
            caption: 'entities.trmlgbcost.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'trmlgbcosts', parameterName: 'trmlgbcost' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/trm/trmlgbcostgrid-view/trmlgbcostgrid-view.vue'),
    },
            {
                path: '/pimqualmajorredirectview/:pimqualmajorredirectview?',
                meta: {
                    caption: 'entities.pimqualmajor.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimqualmajorredirectview', parameterName: 'pimqualmajorredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimqualmajorredirect-view/pimqualmajorredirect-view.vue'),
            },
    {
        path: '/pimqualmajors/:pimqualmajor?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimqualmajor.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/penxunkecheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualmajorgrid-view/pimqualmajorgrid-view.vue'),
    },
    {
        path: '/pimqualtypes/:pimqualtype?/editview/:editview?',
        meta: {
            caption: 'entities.pimqualtype.views.editview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinleixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimqualtypes', parameterName: 'pimqualtype' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualtypeedit-view/pimqualtypeedit-view.vue'),
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
        component: () => import('@pages/orm/ormdutyorm-org-sector-pickup-grid-view/ormdutyorm-org-sector-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchivesloanandreturns/:pimarchivesloanandreturn?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimarchivesloanandreturn.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/biangenghetong.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/pimarchivesloanandreturns/:pimarchivesloanandreturn?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimarchivesloanandreturn.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/biangenghetong.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
    },
    {
        path: '/pimarchivesloanandreturns/:pimarchivesloanandreturn?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimarchivesloanandreturn.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/biangenghetong.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchivesloanandreturns', parameterName: 'pimarchivesloanandreturn' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
    },
            {
                path: '/pimpatentredirectview/:pimpatentredirectview?',
                meta: {
                    caption: 'entities.pimpatent.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpatentredirectview', parameterName: 'pimpatentredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimpatentredirect-view/pimpatentredirect-view.vue'),
            },
    {
        path: '/pimtypecontracts/:pimtypecontract?/editview/:editview?',
        meta: {
            caption: 'entities.pimtypecontract.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimtypecontracts', parameterName: 'pimtypecontract' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimtypecontractedit-view/pimtypecontractedit-view.vue'),
    },
    {
        path: '/pimcontracttypes/:pimcontracttype?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimcontracttype.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongleixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracttypes', parameterName: 'pimcontracttype' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimcontracttypegrid-view/pimcontracttypegrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_ng/:editview_ng?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_ng.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_ng', parameterName: 'editview_ng' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-ng/pimexitandentryedit-view-ng.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/editview_ng/:editview_ng?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_ng.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_ng', parameterName: 'editview_ng' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-ng/pimexitandentryedit-view-ng.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/lzyghmcgridview/:lzyghmcgridview?',
        meta: {
            caption: 'entities.pimperson.views.lzyghmcgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/guazhidaoqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'lzyghmcgridview', parameterName: 'lzyghmcgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersonlzyghmcgrid-view/pimpersonlzyghmcgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/jdryhmcgridview/:jdryhmcgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.jdryhmcgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/jiediaodaoqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'jdryhmcgridview', parameterName: 'jdryhmcgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-distirbution-jdryhmcgrid-view/pim-distirbution-jdryhmcgrid-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/jdryhmcgridview/:jdryhmcgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.jdryhmcgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/jiediaodaoqiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'jdryhmcgridview', parameterName: 'jdryhmcgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-distirbution-jdryhmcgrid-view/pim-distirbution-jdryhmcgrid-view.vue'),
    },
            {
                path: '/pimpaperredirectview/:pimpaperredirectview?',
                meta: {
                    caption: 'entities.pimpaper.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimpaperredirectview', parameterName: 'pimpaperredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimpaperredirect-view/pimpaperredirect-view.vue'),
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
        component: () => import('@pages/trm/trmtrianpersongrid-view/trmtrianpersongrid-view.vue'),
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
        component: () => import('@pages/trm/trmtrianpersongrid-view/trmtrianpersongrid-view.vue'),
    },
            {
                path: '/pimstafftyperedirectview/:pimstafftyperedirectview?',
                meta: {
                    caption: 'entities.pimstafftype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimstafftyperedirectview', parameterName: 'pimstafftyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimstafftyperedirect-view/pimstafftyperedirect-view.vue'),
            },
            {
                path: '/archivesmanageredirectview/:archivesmanageredirectview?',
                meta: {
                    caption: 'entities.pimarchivesmanage.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'archivesmanageredirectview', parameterName: 'archivesmanageredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/archivesmanageredirect-view/archivesmanageredirect-view.vue'),
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
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/editview_yqx/:editview_yqx?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_yqx.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_yqx', parameterName: 'editview_yqx' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-yqx/pimexitandentryedit-view-yqx.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/editview_yqx/:editview_yqx?',
        meta: {
            caption: 'entities.pimexitandentry.views.editview_yqx.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'editview_yqx', parameterName: 'editview_yqx' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimexitandentryedit-view-yqx/pimexitandentryedit-view-yqx.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/xjpickupview/:xjpickupview?',
        meta: {
            caption: 'entities.ormorg.views.xjpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'xjpickupview', parameterName: 'xjpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgxj-pickup-view/ormorgxj-pickup-view.vue'),
    },
    {
        path: '/pimsearchfieldsets/:pimsearchfieldset?/editview/:editview?',
        meta: {
            caption: 'entities.pimsearchfieldset.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimsearchfieldsets', parameterName: 'pimsearchfieldset' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pim-search-field-set-edit-view/pim-search-field-set-edit-view.vue'),
    },
            {
                path: '/pimmajorsetyperedirectview/:pimmajorsetyperedirectview?',
                meta: {
                    caption: 'entities.pimmajorsetype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimmajorsetyperedirectview', parameterName: 'pimmajorsetyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimmajorsetyperedirect-view/pimmajorsetyperedirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/attendancemreportmxes/:attendancemreportmx?/wscgridview/:wscgridview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.wscgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                { pathName: 'wscgridview', parameterName: 'wscgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/attendancemreportmxwsc-grid-view/attendancemreportmxwsc-grid-view.vue'),
    },
    {
        path: '/attendancemreportmxes/:attendancemreportmx?/wscgridview/:wscgridview?',
        meta: {
            caption: 'entities.attendancemreportmx.views.wscgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinyuebao.png',
            iconCls: '',
            parameters: [
                { pathName: 'attendancemreportmxes', parameterName: 'attendancemreportmx' },
                { pathName: 'wscgridview', parameterName: 'wscgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/att/attendancemreportmxwsc-grid-view/attendancemreportmxwsc-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/editview/:editview?',
        meta: {
            caption: 'entities.pimworkhistory.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimworkhistoryedit-view/pimworkhistoryedit-view.vue'),
    },
    {
        path: '/pimworkhistories/:pimworkhistory?/editview/:editview?',
        meta: {
            caption: 'entities.pimworkhistory.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimworkhistoryedit-view/pimworkhistoryedit-view.vue'),
    },
    {
        path: '/pimqualtypes/:pimqualtype?/gridview/:gridview?',
        meta: {
            caption: 'entities.pimqualtype.views.gridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/kaoqinleixing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimqualtypes', parameterName: 'pimqualtype' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualtypegrid-view/pimqualtypegrid-view.vue'),
    },
    {
        path: '/ormsignorgs/:ormsignorg?/htqddwwpickupview/:htqddwwpickupview?',
        meta: {
            caption: 'entities.ormsignorg.views.htqddwwpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormsignorgs', parameterName: 'ormsignorg' },
                { pathName: 'htqddwwpickupview', parameterName: 'htqddwwpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/orm-sign-org-htqddwwpickup-view/orm-sign-org-htqddwwpickup-view.vue'),
    },
            {
                path: '/pimfaminforedirectview/:pimfaminforedirectview?',
                meta: {
                    caption: 'entities.pimfaminfo.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimfaminforedirectview', parameterName: 'pimfaminforedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimfaminforedirect-view/pimfaminforedirect-view.vue'),
            },
            {
                path: '/pcmdetailredirectview/:pcmdetailredirectview?',
                meta: {
                    caption: 'entities.pcmdetail.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pcmdetailredirectview', parameterName: 'pcmdetailredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pcmdetailredirect-view/pcmdetailredirect-view.vue'),
            },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/dadcjlgridview/:dadcjlgridview?',
        meta: {
            caption: 'entities.pimarchiveschange.views.dadcjlgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                { pathName: 'dadcjlgridview', parameterName: 'dadcjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchiveschangedadcjlgrid-view/pimarchiveschangedadcjlgrid-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/pimarchiveschanges/:pimarchiveschange?/dadcjlgridview/:dadcjlgridview?',
        meta: {
            caption: 'entities.pimarchiveschange.views.dadcjlgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                { pathName: 'dadcjlgridview', parameterName: 'dadcjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchiveschangedadcjlgrid-view/pimarchiveschangedadcjlgrid-view.vue'),
    },
    {
        path: '/pimarchiveschanges/:pimarchiveschange?/dadcjlgridview/:dadcjlgridview?',
        meta: {
            caption: 'entities.pimarchiveschange.views.dadcjlgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchiveschanges', parameterName: 'pimarchiveschange' },
                { pathName: 'dadcjlgridview', parameterName: 'dadcjlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimarchiveschangedadcjlgrid-view/pimarchiveschangedadcjlgrid-view.vue'),
    },
            {
                path: '/pimeducationredirectview/:pimeducationredirectview?',
                meta: {
                    caption: 'entities.pimeducation.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimeducationredirectview', parameterName: 'pimeducationredirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/pim/pimeducationredirect-view/pimeducationredirect-view.vue'),
            },
    {
        path: '/pcmdetails/:pcmdetail?/gridview/:gridview?',
        meta: {
            caption: 'entities.pcmdetail.views.gridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmdetails', parameterName: 'pcmdetail' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pcmdetailgrid-view/pcmdetailgrid-view.vue'),
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
