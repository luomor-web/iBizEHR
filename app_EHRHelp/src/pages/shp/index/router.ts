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
            component: () => import('@pages/shp/index/index.vue'),
            children: [
                {
                    path: 'pimpeople/:pimperson?/pimarmycadres/:pimarmycadres?/grarmygridview/:grarmygridview?',
                    meta: {
                        caption: 'entities.pimarmycadres.views.grarmygridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                            { pathName: 'grarmygridview', parameterName: 'grarmygridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimarmycadresgrarmygrid-view/pimarmycadresgrarmygrid-view.vue'),
                },
                {
                    path: 'pimarmycadres/:pimarmycadres?/grarmygridview/:grarmygridview?',
                    meta: {
                        caption: 'entities.pimarmycadres.views.grarmygridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                            { pathName: 'grarmygridview', parameterName: 'grarmygridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimarmycadresgrarmygrid-view/pimarmycadresgrarmygrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/grzzeditview/:grzzeditview?',
                    meta: {
                        caption: 'entities.pimperson.views.grzzeditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'grzzeditview', parameterName: 'grzzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpersongrzzedit-view/pimpersongrzzedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarmycadres/:pimarmycadres?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimarmycadres.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimarmycadresgredit-view/pimarmycadresgredit-view.vue'),
                },
                {
                    path: 'pimarmycadres/:pimarmycadres?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimarmycadres.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimarmycadresgredit-view/pimarmycadresgredit-view.vue'),
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
                    component: () => import('@pages/shp/archivescenterpickup-view/archivescenterpickup-view.vue'),
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
                    component: () => import('@pages/shp/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
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
                    component: () => import('@pages/shp/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
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
                    component: () => import('@pages/shp/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
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
                    component: () => import('@pages/shp/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
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
                    component: () => import('@pages/shp/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
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
                    component: () => import('@pages/shp/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
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
                    component: () => import('@pages/shp/pimarchivesedit-view/pimarchivesedit-view.vue'),
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
                    component: () => import('@pages/shp/pimarchivesedit-view/pimarchivesedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/ygzzgridview/:ygzzgridview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.ygzzgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimexitandentryygzzgrid-view/pimexitandentryygzzgrid-view.vue'),
                },
                {
                    path: 'pimexitandentries/:pimexitandentry?/ygzzgridview/:ygzzgridview?',
                    meta: {
                        caption: 'entities.pimexitandentry.views.ygzzgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/chujing.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                            { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimexitandentryygzzgrid-view/pimexitandentryygzzgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/grpimjanglgridview/:grpimjanglgridview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.grpimjanglgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'grpimjanglgridview', parameterName: 'grpimjanglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimrewardpunishmentgrpim-jangl-grid-view/pimrewardpunishmentgrpim-jangl-grid-view.vue'),
                },
                {
                    path: 'pimrewardpunishments/:pimrewardpunishment?/grpimjanglgridview/:grpimjanglgridview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.grpimjanglgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'grpimjanglgridview', parameterName: 'grpimjanglgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimrewardpunishmentgrpim-jangl-grid-view/pimrewardpunishmentgrpim-jangl-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/yqxeditview/:yqxeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.yqxeditview.title',
                        info:'',
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
                    component: () => import('@pages/shp/vacleavemanageyqxedit-view/vacleavemanageyqxedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/yqxeditview/:yqxeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.yqxeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'yqxeditview', parameterName: 'yqxeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/vacleavemanageyqxedit-view/vacleavemanageyqxedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/grdividereditview/:grdividereditview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.grdividereditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'grdividereditview', parameterName: 'grdividereditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pim-distirbution-grdivider-edit-view/pim-distirbution-grdivider-edit-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/grdividereditview/:grdividereditview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.grdividereditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'grdividereditview', parameterName: 'grdividereditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pim-distirbution-grdivider-edit-view/pim-distirbution-grdivider-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimlanguageabilities/:pimlanguageability?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimlanguageability.views.greditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimlanguageabilitygredit-view/pimlanguageabilitygredit-view.vue'),
                },
                {
                    path: 'pimlanguageabilities/:pimlanguageability?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimlanguageability.views.greditview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimlanguageabilitygredit-view/pimlanguageabilitygredit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimrewardpunishmentgredit-view/pimrewardpunishmentgredit-view.vue'),
                },
                {
                    path: 'pimrewardpunishments/:pimrewardpunishment?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimrewardpunishment.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jianglichengfa.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimrewardpunishmentgredit-view/pimrewardpunishmentgredit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimtitles/:pimtitle?/grpimzhicgridview/:grpimzhicgridview?',
                    meta: {
                        caption: 'entities.pimtitle.views.grpimzhicgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'grpimzhicgridview', parameterName: 'grpimzhicgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimtitlegrpim-zhic-grid-view/pimtitlegrpim-zhic-grid-view.vue'),
                },
                {
                    path: 'pimtitles/:pimtitle?/grpimzhicgridview/:grpimzhicgridview?',
                    meta: {
                        caption: 'entities.pimtitle.views.grpimzhicgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'grpimzhicgridview', parameterName: 'grpimzhicgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimtitlegrpim-zhic-grid-view/pimtitlegrpim-zhic-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ybheditview/:ybheditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ybheditview.title',
                        info:'',
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
                    component: () => import('@pages/shp/vacleavemanageybhedit-view/vacleavemanageybhedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/ybheditview/:ybheditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ybheditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ybheditview', parameterName: 'ybheditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/vacleavemanageybhedit-view/vacleavemanageybhedit-view.vue'),
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
                    component: () => import('@pages/shp/ormorgfpxxpickup-view/ormorgfpxxpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimworkhistorygredit-view/pimworkhistorygredit-view.vue'),
                },
                {
                    path: 'pimworkhistories/:pimworkhistory?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimworkhistorygredit-view/pimworkhistorygredit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimresearchfindings/:pimresearchfindings?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimresearchfindings.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/keyanchengguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimresearchfindingsgredit-view/pimresearchfindingsgredit-view.vue'),
                },
                {
                    path: 'pimresearchfindings/:pimresearchfindings?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimresearchfindings.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/keyanchengguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimresearchfindingsgredit-view/pimresearchfindingsgredit-view.vue'),
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
                    component: () => import('@pages/shp/ormorgxmbqpickup-view/ormorgxmbqpickup-view.vue'),
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
                    component: () => import('@pages/shp/pimpersonpickup-grid-view/pimpersonpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/kqjrypickupview/:kqjrypickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.kqjrypickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'kqjrypickupview', parameterName: 'kqjrypickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpersonkqjrypickup-view/pimpersonkqjrypickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpatents/:pimpatent?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimpatent.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpatents', parameterName: 'pimpatent' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpatentgredit-view/pimpatentgredit-view.vue'),
                },
                {
                    path: 'pimpatents/:pimpatent?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimpatent.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpatents', parameterName: 'pimpatent' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpatentgredit-view/pimpatentgredit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/kqjrypickupgridview/:kqjrypickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.kqjrypickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'kqjrypickupgridview', parameterName: 'kqjrypickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpersonkqjrypickup-grid-view/pimpersonkqjrypickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpapers/:pimpaper?/grpapergridview/:grpapergridview?',
                    meta: {
                        caption: 'entities.pimpaper.views.grpapergridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpapers', parameterName: 'pimpaper' },
                            { pathName: 'grpapergridview', parameterName: 'grpapergridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpapergr-papergrid-view/pimpapergr-papergrid-view.vue'),
                },
                {
                    path: 'pimpapers/:pimpaper?/grpapergridview/:grpapergridview?',
                    meta: {
                        caption: 'entities.pimpaper.views.grpapergridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpapers', parameterName: 'pimpaper' },
                            { pathName: 'grpapergridview', parameterName: 'grpapergridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpapergr-papergrid-view/pimpapergr-papergrid-view.vue'),
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
                    component: () => import('@pages/shp/ormdutyorm-org-sector-pickup-view/ormdutyorm-org-sector-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpapers/:pimpaper?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimpaper.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpapers', parameterName: 'pimpaper' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpapergredit-view/pimpapergredit-view.vue'),
                },
                {
                    path: 'pimpapers/:pimpaper?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimpaper.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpapers', parameterName: 'pimpaper' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpapergredit-view/pimpapergredit-view.vue'),
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
                    component: () => import('@pages/shp/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
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
                    component: () => import('@pages/shp/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
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
                    component: () => import('@pages/shp/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
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
                    component: () => import('@pages/shp/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
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
                    component: () => import('@pages/shp/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
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
                    component: () => import('@pages/shp/orm-sign-org-bdwpickup-view/orm-sign-org-bdwpickup-view.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-yqx/pimexitandentryedit-view-yqx.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-yqx/pimexitandentryedit-view-yqx.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-spz/pimexitandentryedit-view-spz.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-spz/pimexitandentryedit-view-spz.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/grcontracteditview/:grcontracteditview?',
                    meta: {
                        caption: 'entities.pimcontract.views.grcontracteditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'grcontracteditview', parameterName: 'grcontracteditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimcontractgrcontract-edit-view/pimcontractgrcontract-edit-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/grcontracteditview/:grcontracteditview?',
                    meta: {
                        caption: 'entities.pimcontract.views.grcontracteditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'grcontracteditview', parameterName: 'grcontracteditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimcontractgrcontract-edit-view/pimcontractgrcontract-edit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimtitles/:pimtitle?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimtitle.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimtitlegredit-view/pimtitlegredit-view.vue'),
                },
                {
                    path: 'pimtitles/:pimtitle?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimtitle.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimtitles', parameterName: 'pimtitle' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimtitlegredit-view/pimtitlegredit-view.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-ng/pimexitandentryedit-view-ng.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-ng/pimexitandentryedit-view-ng.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-ybh/pimexitandentryedit-view-ybh.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-ybh/pimexitandentryedit-view-ybh.vue'),
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
                    component: () => import('@pages/shp/orm-org-xmbqpickup-grid-view/orm-org-xmbqpickup-grid-view.vue'),
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
                    component: () => import('@pages/shp/pimqualmajorpickup-grid-view/pimqualmajorpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimeducations/:pimeducation?/grpimedugridview/:grpimedugridview?',
                    meta: {
                        caption: 'entities.pimeducation.views.grpimedugridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'grpimedugridview', parameterName: 'grpimedugridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimeducationgrpim-edu-grid-view/pimeducationgrpim-edu-grid-view.vue'),
                },
                {
                    path: 'pimeducations/:pimeducation?/grpimedugridview/:grpimedugridview?',
                    meta: {
                        caption: 'entities.pimeducation.views.grpimedugridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'grpimedugridview', parameterName: 'grpimedugridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimeducationgrpim-edu-grid-view/pimeducationgrpim-edu-grid-view.vue'),
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
                    component: () => import('@pages/shp/ormdutyorm-org-sector-pickup-grid-view/ormdutyorm-org-sector-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimlanguageabilities/:pimlanguageability?/gryynlgridview/:gryynlgridview?',
                    meta: {
                        caption: 'entities.pimlanguageability.views.gryynlgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/yuyanshuiping.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                            { pathName: 'gryynlgridview', parameterName: 'gryynlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimlanguageabilitygryynlgrid-view/pimlanguageabilitygryynlgrid-view.vue'),
                },
                {
                    path: 'pimlanguageabilities/:pimlanguageability?/gryynlgridview/:gryynlgridview?',
                    meta: {
                        caption: 'entities.pimlanguageability.views.gryynlgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/yuyanshuiping.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                            { pathName: 'gryynlgridview', parameterName: 'gryynlgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimlanguageabilitygryynlgrid-view/pimlanguageabilitygryynlgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/xjeditview/:xjeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.xjeditview.title',
                        info:'',
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
                    component: () => import('@pages/shp/vacleavemanagexjedit-view/vacleavemanagexjedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/xjeditview/:xjeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.xjeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'xjeditview', parameterName: 'xjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/vacleavemanagexjedit-view/vacleavemanagexjedit-view.vue'),
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
                    component: () => import('@pages/shp/archivescenterpickup-grid-view/archivescenterpickup-grid-view.vue'),
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
                    component: () => import('@pages/shp/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
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
                    component: () => import('@pages/shp/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ygzzgridview/:ygzzgridview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ygzzgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/vacleavemanageygzzgrid-view/vacleavemanageygzzgrid-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/ygzzgridview/:ygzzgridview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ygzzgridview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/vacleavemanageygzzgrid-view/vacleavemanageygzzgrid-view.vue'),
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
                    component: () => import('@pages/shp/pimqualtypepickup-view/pimqualtypepickup-view.vue'),
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
                    component: () => import('@pages/shp/pimtitlecataloguenot-pickup-grid-view/pimtitlecataloguenot-pickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimeducations/:pimeducation?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimeducation.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimeducationgredit-view/pimeducationgredit-view.vue'),
                },
                {
                    path: 'pimeducations/:pimeducation?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimeducation.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimeducations', parameterName: 'pimeducation' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimeducationgredit-view/pimeducationgredit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimresearchfindings/:pimresearchfindings?/grresearchgridview/:grresearchgridview?',
                    meta: {
                        caption: 'entities.pimresearchfindings.views.grresearchgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/keyanchengguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                            { pathName: 'grresearchgridview', parameterName: 'grresearchgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimresearchfindingsgrresearchgrid-view/pimresearchfindingsgrresearchgrid-view.vue'),
                },
                {
                    path: 'pimresearchfindings/:pimresearchfindings?/grresearchgridview/:grresearchgridview?',
                    meta: {
                        caption: 'entities.pimresearchfindings.views.grresearchgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/keyanchengguo.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                            { pathName: 'grresearchgridview', parameterName: 'grresearchgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimresearchfindingsgrresearchgrid-view/pimresearchfindingsgrresearchgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimfaminfogredit-view/pimfaminfogredit-view.vue'),
                },
                {
                    path: 'pimfaminfos/:pimfaminfo?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimfaminfogredit-view/pimfaminfogredit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/grpimfenpgridview/:grpimfenpgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.grpimfenpgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'grpimfenpgridview', parameterName: 'grpimfenpgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pim-distirbution-grpim-fenp-grid-view/pim-distirbution-grpim-fenp-grid-view.vue'),
                },
                {
                    path: 'pimdistirbutions/:pimdistirbution?/grpimfenpgridview/:grpimfenpgridview?',
                    meta: {
                        caption: 'entities.pimdistirbution.views.grpimfenpgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                            { pathName: 'grpimfenpgridview', parameterName: 'grpimfenpgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pim-distirbution-grpim-fenp-grid-view/pim-distirbution-grpim-fenp-grid-view.vue'),
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
                    component: () => import('@pages/shp/orm-sign-org-bdwpickup-grid-view/orm-sign-org-bdwpickup-grid-view.vue'),
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
                    component: () => import('@pages/shp/ormorgfpxxpickup-grid-view/ormorgfpxxpickup-grid-view.vue'),
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
                    component: () => import('@pages/shp/pimtitlecataloguenot-pickup-view/pimtitlecataloguenot-pickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimcontracts/:pimcontract?/grcontractgridview/:grcontractgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.grcontractgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'grcontractgridview', parameterName: 'grcontractgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimcontractgrcontract-grid-view/pimcontractgrcontract-grid-view.vue'),
                },
                {
                    path: 'pimcontracts/:pimcontract?/grcontractgridview/:grcontractgridview?',
                    meta: {
                        caption: 'entities.pimcontract.views.grcontractgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                            { pathName: 'grcontractgridview', parameterName: 'grcontractgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimcontractgrcontract-grid-view/pimcontractgrcontract-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimpatents/:pimpatent?/grpatentgridview/:grpatentgridview?',
                    meta: {
                        caption: 'entities.pimpatent.views.grpatentgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimpatents', parameterName: 'pimpatent' },
                            { pathName: 'grpatentgridview', parameterName: 'grpatentgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpatentgrpatentgrid-view/pimpatentgrpatentgrid-view.vue'),
                },
                {
                    path: 'pimpatents/:pimpatent?/grpatentgridview/:grpatentgridview?',
                    meta: {
                        caption: 'entities.pimpatent.views.grpatentgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpatents', parameterName: 'pimpatent' },
                            { pathName: 'grpatentgridview', parameterName: 'grpatentgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimpatentgrpatentgrid-view/pimpatentgrpatentgrid-view.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-ytg/pimexitandentryedit-view-ytg.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryedit-view-ytg/pimexitandentryedit-view-ytg.vue'),
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
                    component: () => import('@pages/shp/ormorgsectorfpxxpickup-grid-view/ormorgsectorfpxxpickup-grid-view.vue'),
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
                    component: () => import('@pages/shp/ormorgsectorfpxxpickup-grid-view/ormorgsectorfpxxpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ytgeditview/:ytgeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ytgeditview.title',
                        info:'',
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
                    component: () => import('@pages/shp/vacleavemanageytgedit-view/vacleavemanageytgedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/ytgeditview/:ytgeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ytgeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ytgeditview', parameterName: 'ytgeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/vacleavemanageytgedit-view/vacleavemanageytgedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimachievements/:pimachievements?/grpimjixgridview/:grpimjixgridview?',
                    meta: {
                        caption: 'entities.pimachievements.views.grpimjixgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimachievements', parameterName: 'pimachievements' },
                            { pathName: 'grpimjixgridview', parameterName: 'grpimjixgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimachievementsgrpim-jix-grid-view/pimachievementsgrpim-jix-grid-view.vue'),
                },
                {
                    path: 'pimachievements/:pimachievements?/grpimjixgridview/:grpimjixgridview?',
                    meta: {
                        caption: 'entities.pimachievements.views.grpimjixgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimachievements', parameterName: 'pimachievements' },
                            { pathName: 'grpimjixgridview', parameterName: 'grpimjixgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimachievementsgrpim-jix-grid-view/pimachievementsgrpim-jix-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimvocationals/:pimvocational?/grpimziggridview/:grpimziggridview?',
                    meta: {
                        caption: 'entities.pimvocational.views.grpimziggridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'grpimziggridview', parameterName: 'grpimziggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimvocationalgrpim-zig-grid-view/pimvocationalgrpim-zig-grid-view.vue'),
                },
                {
                    path: 'pimvocationals/:pimvocational?/grpimziggridview/:grpimziggridview?',
                    meta: {
                        caption: 'entities.pimvocational.views.grpimziggridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'grpimziggridview', parameterName: 'grpimziggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimvocationalgrpim-zig-grid-view/pimvocationalgrpim-zig-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/grpimfimgridview/:grpimfimgridview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.grpimfimgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'grpimfimgridview', parameterName: 'grpimfimgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimfaminfogrpimfim-grid-view/pimfaminfogrpimfim-grid-view.vue'),
                },
                {
                    path: 'pimfaminfos/:pimfaminfo?/grpimfimgridview/:grpimfimgridview?',
                    meta: {
                        caption: 'entities.pimfaminfo.views.grpimfimgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                            { pathName: 'grpimfimgridview', parameterName: 'grpimfimgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimfaminfogrpimfim-grid-view/pimfaminfogrpimfim-grid-view.vue'),
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
                    component: () => import('@pages/shp/ormorghtgldwqpickup-grid-view/ormorghtgldwqpickup-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/grpimworkgridview/:grpimworkgridview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.grpimworkgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'grpimworkgridview', parameterName: 'grpimworkgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimworkhistorygrpim-work-grid-view/pimworkhistorygrpim-work-grid-view.vue'),
                },
                {
                    path: 'pimworkhistories/:pimworkhistory?/grpimworkgridview/:grpimworkgridview?',
                    meta: {
                        caption: 'entities.pimworkhistory.views.grpimworkgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                            { pathName: 'grpimworkgridview', parameterName: 'grpimworkgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimworkhistorygrpim-work-grid-view/pimworkhistorygrpim-work-grid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ngeditview/:ngeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ngeditview.title',
                        info:'',
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
                    component: () => import('@pages/shp/vac-leave-manage-ngedit-view/vac-leave-manage-ngedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/ngeditview/:ngeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.ngeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'ngeditview', parameterName: 'ngeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/vac-leave-manage-ngedit-view/vac-leave-manage-ngedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimvocationals/:pimvocational?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimvocational.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimvocationalgredit-view/pimvocationalgredit-view.vue'),
                },
                {
                    path: 'pimvocationals/:pimvocational?/greditview/:greditview?',
                    meta: {
                        caption: 'entities.pimvocational.views.greditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                            { pathName: 'greditview', parameterName: 'greditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimvocationalgredit-view/pimvocationalgredit-view.vue'),
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
                    component: () => import('@pages/shp/ormorgsectorfpxxpickup-view/ormorgsectorfpxxpickup-view.vue'),
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
                    component: () => import('@pages/shp/ormorgsectorfpxxpickup-view/ormorgsectorfpxxpickup-view.vue'),
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
                    component: () => import('@pages/shp/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
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
                    component: () => import('@pages/shp/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
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
                    component: () => import('@pages/shp/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryform-pickup-view/pimexitandentryform-pickup-view.vue'),
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
                    component: () => import('@pages/shp/pimexitandentryform-pickup-view/pimexitandentryform-pickup-view.vue'),
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
                    component: () => import('@pages/shp/ormorghtgldwpickup-view/ormorghtgldwpickup-view.vue'),
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
                    component: () => import('@pages/shp/pimpersonpickup-view/pimpersonpickup-view.vue'),
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
                    component: () => import('@pages/shp/pimachievementsedit-view/pimachievementsedit-view.vue'),
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
                    component: () => import('@pages/shp/pimachievementsedit-view/pimachievementsedit-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/pimarchives/:pimarchives?/grpimdangagridview/:grpimdangagridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.grpimdangagridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'grpimdangagridview', parameterName: 'grpimdangagridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimarchivesgrpim-danga-grid-view/pimarchivesgrpim-danga-grid-view.vue'),
                },
                {
                    path: 'pimarchives/:pimarchives?/grpimdangagridview/:grpimdangagridview?',
                    meta: {
                        caption: 'entities.pimarchives.views.grpimdangagridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimarchives', parameterName: 'pimarchives' },
                            { pathName: 'grpimdangagridview', parameterName: 'grpimdangagridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/pimarchivesgrpim-danga-grid-view/pimarchivesgrpim-danga-grid-view.vue'),
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
                    component: () => import('@pages/shp/pimqualtypepickup-grid-view/pimqualtypepickup-grid-view.vue'),
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
                    component: () => import('@pages/shp/pimqualmajorpickup-view/pimqualmajorpickup-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/spzeditview/:spzeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.spzeditview.title',
                        info:'',
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
                    component: () => import('@pages/shp/vacleavemanagespzedit-view/vacleavemanagespzedit-view.vue'),
                },
                {
                    path: 'vacleavemanages/:vacleavemanage?/spzeditview/:spzeditview?',
                    meta: {
                        caption: 'entities.vacleavemanage.views.spzeditview.title',
                        info:'',
                        imgPath: '../../../img/newimage/1/qingjiaguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                            { pathName: 'spzeditview', parameterName: 'spzeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/shp/vacleavemanagespzedit-view/vacleavemanagespzedit-view.vue'),
                },
            {
                path: 'pimgwtyperedirectview/:pimgwtyperedirectview?',
                meta: {
                    caption: 'entities.pimgwtype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimgwtyperedirectview', parameterName: 'pimgwtyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/shp/pimgwtyperedirect-view/pimgwtyperedirect-view.vue'),
            },
            ...indexRoutes,
            ],
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
        component: () => import('@pages/shp/pimqualtypepickup-view/pimqualtypepickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimeducations/:pimeducation?/grpimedugridview/:grpimedugridview?',
        meta: {
            caption: 'entities.pimeducation.views.grpimedugridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'grpimedugridview', parameterName: 'grpimedugridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimeducationgrpim-edu-grid-view/pimeducationgrpim-edu-grid-view.vue'),
    },
    {
        path: '/pimeducations/:pimeducation?/grpimedugridview/:grpimedugridview?',
        meta: {
            caption: 'entities.pimeducation.views.grpimedugridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'grpimedugridview', parameterName: 'grpimedugridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimeducationgrpim-edu-grid-view/pimeducationgrpim-edu-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/grpimjanglgridview/:grpimjanglgridview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.grpimjanglgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'grpimjanglgridview', parameterName: 'grpimjanglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimrewardpunishmentgrpim-jangl-grid-view/pimrewardpunishmentgrpim-jangl-grid-view.vue'),
    },
    {
        path: '/pimrewardpunishments/:pimrewardpunishment?/grpimjanglgridview/:grpimjanglgridview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.grpimjanglgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'grpimjanglgridview', parameterName: 'grpimjanglgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimrewardpunishmentgrpim-jangl-grid-view/pimrewardpunishmentgrpim-jangl-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ytgeditview/:ytgeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ytgeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ytgeditview', parameterName: 'ytgeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanageytgedit-view/vacleavemanageytgedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/ytgeditview/:ytgeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ytgeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ytgeditview', parameterName: 'ytgeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanageytgedit-view/vacleavemanageytgedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimachievements/:pimachievements?/grpimjixgridview/:grpimjixgridview?',
        meta: {
            caption: 'entities.pimachievements.views.grpimjixgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimachievements', parameterName: 'pimachievements' },
                { pathName: 'grpimjixgridview', parameterName: 'grpimjixgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimachievementsgrpim-jix-grid-view/pimachievementsgrpim-jix-grid-view.vue'),
    },
    {
        path: '/pimachievements/:pimachievements?/grpimjixgridview/:grpimjixgridview?',
        meta: {
            caption: 'entities.pimachievements.views.grpimjixgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jixiaoxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimachievements', parameterName: 'pimachievements' },
                { pathName: 'grpimjixgridview', parameterName: 'grpimjixgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimachievementsgrpim-jix-grid-view/pimachievementsgrpim-jix-grid-view.vue'),
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
        component: () => import('@pages/shp/pimqualtypepickup-grid-view/pimqualtypepickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimtitles/:pimtitle?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimtitle.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimtitlegredit-view/pimtitlegredit-view.vue'),
    },
    {
        path: '/pimtitles/:pimtitle?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimtitle.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimtitlegredit-view/pimtitlegredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimresearchfindings/:pimresearchfindings?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimresearchfindings.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/keyanchengguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimresearchfindingsgredit-view/pimresearchfindingsgredit-view.vue'),
    },
    {
        path: '/pimresearchfindings/:pimresearchfindings?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimresearchfindings.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/keyanchengguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimresearchfindingsgredit-view/pimresearchfindingsgredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimfaminfo.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimfaminfogredit-view/pimfaminfogredit-view.vue'),
    },
    {
        path: '/pimfaminfos/:pimfaminfo?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimfaminfo.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimfaminfogredit-view/pimfaminfogredit-view.vue'),
    },
    {
        path: '/pimquestions/:pimquestions?/yh_checkeditview/:yh_checkeditview?',
        meta: {
            caption: 'entities.pimquestions.views.yh_checkeditview.title',
            info:'',
            imgPath: '',
            iconCls: 'fa fa-question-circle',
            parameters: [
                { pathName: 'pimquestions', parameterName: 'pimquestions' },
                { pathName: 'yh_checkeditview', parameterName: 'yh_checkeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/questionsyh-check-edit-view/questionsyh-check-edit-view.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-ng/pimexitandentryedit-view-ng.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-ng/pimexitandentryedit-view-ng.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-ybh/pimexitandentryedit-view-ybh.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-ybh/pimexitandentryedit-view-ybh.vue'),
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
        component: () => import('@pages/shp/pimtitlecataloguenot-pickup-grid-view/pimtitlecataloguenot-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/xjeditview/:xjeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.xjeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'xjeditview', parameterName: 'xjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanagexjedit-view/vacleavemanagexjedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/xjeditview/:xjeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.xjeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'xjeditview', parameterName: 'xjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanagexjedit-view/vacleavemanagexjedit-view.vue'),
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
        component: () => import('@pages/shp/orm-sign-org-bdwpickup-view/orm-sign-org-bdwpickup-view.vue'),
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
        component: () => import('@pages/shp/archivescenterpickup-view/archivescenterpickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimfaminfos/:pimfaminfo?/grpimfimgridview/:grpimfimgridview?',
        meta: {
            caption: 'entities.pimfaminfo.views.grpimfimgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'grpimfimgridview', parameterName: 'grpimfimgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimfaminfogrpimfim-grid-view/pimfaminfogrpimfim-grid-view.vue'),
    },
    {
        path: '/pimfaminfos/:pimfaminfo?/grpimfimgridview/:grpimfimgridview?',
        meta: {
            caption: 'entities.pimfaminfo.views.grpimfimgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiatingqingkuang.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimfaminfos', parameterName: 'pimfaminfo' },
                { pathName: 'grpimfimgridview', parameterName: 'grpimfimgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimfaminfogrpimfim-grid-view/pimfaminfogrpimfim-grid-view.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-yqx/pimexitandentryedit-view-yqx.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-yqx/pimexitandentryedit-view-yqx.vue'),
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
        component: () => import('@pages/shp/pimqualmajorpickup-grid-view/pimqualmajorpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarmycadres/:pimarmycadres?/grarmygridview/:grarmygridview?',
        meta: {
            caption: 'entities.pimarmycadres.views.grarmygridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                { pathName: 'grarmygridview', parameterName: 'grarmygridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimarmycadresgrarmygrid-view/pimarmycadresgrarmygrid-view.vue'),
    },
    {
        path: '/pimarmycadres/:pimarmycadres?/grarmygridview/:grarmygridview?',
        meta: {
            caption: 'entities.pimarmycadres.views.grarmygridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                { pathName: 'grarmygridview', parameterName: 'grarmygridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimarmycadresgrarmygrid-view/pimarmycadresgrarmygrid-view.vue'),
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
        component: () => import('@pages/shp/pimtitlecataloguenot-pickup-view/pimtitlecataloguenot-pickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/grpimfenpgridview/:grpimfenpgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.grpimfenpgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'grpimfenpgridview', parameterName: 'grpimfenpgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pim-distirbution-grpim-fenp-grid-view/pim-distirbution-grpim-fenp-grid-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/grpimfenpgridview/:grpimfenpgridview?',
        meta: {
            caption: 'entities.pimdistirbution.views.grpimfenpgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'grpimfenpgridview', parameterName: 'grpimfenpgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pim-distirbution-grpim-fenp-grid-view/pim-distirbution-grpim-fenp-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpatents/:pimpatent?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimpatent.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpatents', parameterName: 'pimpatent' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpatentgredit-view/pimpatentgredit-view.vue'),
    },
    {
        path: '/pimpatents/:pimpatent?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimpatent.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpatents', parameterName: 'pimpatent' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpatentgredit-view/pimpatentgredit-view.vue'),
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
        component: () => import('@pages/shp/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
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
        component: () => import('@pages/shp/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
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
        component: () => import('@pages/shp/pimarchiveschangegrid-view/pimarchiveschangegrid-view.vue'),
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
        component: () => import('@pages/shp/ormorgfpxxpickup-view/ormorgfpxxpickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarmycadres/:pimarmycadres?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimarmycadres.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimarmycadresgredit-view/pimarmycadresgredit-view.vue'),
    },
    {
        path: '/pimarmycadres/:pimarmycadres?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimarmycadres.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/junzhuanganbu.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarmycadres', parameterName: 'pimarmycadres' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimarmycadresgredit-view/pimarmycadresgredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimtitles/:pimtitle?/grpimzhicgridview/:grpimzhicgridview?',
        meta: {
            caption: 'entities.pimtitle.views.grpimzhicgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'grpimzhicgridview', parameterName: 'grpimzhicgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimtitlegrpim-zhic-grid-view/pimtitlegrpim-zhic-grid-view.vue'),
    },
    {
        path: '/pimtitles/:pimtitle?/grpimzhicgridview/:grpimzhicgridview?',
        meta: {
            caption: 'entities.pimtitle.views.grpimzhicgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimtitles', parameterName: 'pimtitle' },
                { pathName: 'grpimzhicgridview', parameterName: 'grpimzhicgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimtitlegrpim-zhic-grid-view/pimtitlegrpim-zhic-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/kqjrypickupview/:kqjrypickupview?',
        meta: {
            caption: 'entities.pimperson.views.kqjrypickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'kqjrypickupview', parameterName: 'kqjrypickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpersonkqjrypickup-view/pimpersonkqjrypickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ygzzgridview/:ygzzgridview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ygzzgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanageygzzgrid-view/vacleavemanageygzzgrid-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/ygzzgridview/:ygzzgridview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ygzzgridview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanageygzzgrid-view/vacleavemanageygzzgrid-view.vue'),
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
        component: () => import('@pages/shp/pimqualmajorpickup-view/pimqualmajorpickup-view.vue'),
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
        component: () => import('@pages/shp/ormdutyorm-org-sector-pickup-view/ormdutyorm-org-sector-pickup-view.vue'),
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
        component: () => import('@pages/shp/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
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
        component: () => import('@pages/shp/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimdistirbutions/:pimdistirbution?/grdividereditview/:grdividereditview?',
        meta: {
            caption: 'entities.pimdistirbution.views.grdividereditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'grdividereditview', parameterName: 'grdividereditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pim-distirbution-grdivider-edit-view/pim-distirbution-grdivider-edit-view.vue'),
    },
    {
        path: '/pimdistirbutions/:pimdistirbution?/grdividereditview/:grdividereditview?',
        meta: {
            caption: 'entities.pimdistirbution.views.grdividereditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/fenpeixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'grdividereditview', parameterName: 'grdividereditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pim-distirbution-grdivider-edit-view/pim-distirbution-grdivider-edit-view.vue'),
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
        component: () => import('@pages/shp/pimexitandentryform-pickup-view/pimexitandentryform-pickup-view.vue'),
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
        component: () => import('@pages/shp/pimexitandentryform-pickup-view/pimexitandentryform-pickup-view.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-ytg/pimexitandentryedit-view-ytg.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-ytg/pimexitandentryedit-view-ytg.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimexitandentries/:pimexitandentry?/ygzzgridview/:ygzzgridview?',
        meta: {
            caption: 'entities.pimexitandentry.views.ygzzgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimexitandentryygzzgrid-view/pimexitandentryygzzgrid-view.vue'),
    },
    {
        path: '/pimexitandentries/:pimexitandentry?/ygzzgridview/:ygzzgridview?',
        meta: {
            caption: 'entities.pimexitandentry.views.ygzzgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/chujing.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimexitandentries', parameterName: 'pimexitandentry' },
                { pathName: 'ygzzgridview', parameterName: 'ygzzgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimexitandentryygzzgrid-view/pimexitandentryygzzgrid-view.vue'),
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
        component: () => import('@pages/shp/orm-org-xmbqpickup-grid-view/orm-org-xmbqpickup-grid-view.vue'),
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
        component: () => import('@pages/shp/ormorgxmbqpickup-view/ormorgxmbqpickup-view.vue'),
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
        component: () => import('@pages/shp/orm-sign-org-bdwpickup-grid-view/orm-sign-org-bdwpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimarchives/:pimarchives?/grpimdangagridview/:grpimdangagridview?',
        meta: {
            caption: 'entities.pimarchives.views.grpimdangagridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'grpimdangagridview', parameterName: 'grpimdangagridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimarchivesgrpim-danga-grid-view/pimarchivesgrpim-danga-grid-view.vue'),
    },
    {
        path: '/pimarchives/:pimarchives?/grpimdangagridview/:grpimdangagridview?',
        meta: {
            caption: 'entities.pimarchives.views.grpimdangagridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimarchives', parameterName: 'pimarchives' },
                { pathName: 'grpimdangagridview', parameterName: 'grpimdangagridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimarchivesgrpim-danga-grid-view/pimarchivesgrpim-danga-grid-view.vue'),
    },
    {
        path: '/pimquestions/:pimquestions?/currentquestionsgridview/:currentquestionsgridview?',
        meta: {
            caption: 'entities.pimquestions.views.currentquestionsgridview.title',
            info:'',
            imgPath: '',
            iconCls: 'fa fa-question-circle',
            parameters: [
                { pathName: 'pimquestions', parameterName: 'pimquestions' },
                { pathName: 'currentquestionsgridview', parameterName: 'currentquestionsgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/questionscurrent-questions-grid-view/questionscurrent-questions-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ngeditview/:ngeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ngeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ngeditview', parameterName: 'ngeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vac-leave-manage-ngedit-view/vac-leave-manage-ngedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/ngeditview/:ngeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ngeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ngeditview', parameterName: 'ngeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vac-leave-manage-ngedit-view/vac-leave-manage-ngedit-view.vue'),
    },
            {
                path: '/pimgwtyperedirectview/:pimgwtyperedirectview?',
                meta: {
                    caption: 'entities.pimgwtype.views.redirectview.title',
                    info:'',
                    parameters: [
                        { pathName: 'pimgwtyperedirectview', parameterName: 'pimgwtyperedirectview' },
                    ],
                    requireAuth: true,
                },
                component: () => import('@pages/shp/pimgwtyperedirect-view/pimgwtyperedirect-view.vue'),
            },
    {
        path: '/pimgwtypes/:pimgwtype?/editview/:editview?',
        meta: {
            caption: 'entities.pimgwtype.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pimgwtypes', parameterName: 'pimgwtype' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimgwtypeedit-view/pimgwtypeedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/yqxeditview/:yqxeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.yqxeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'yqxeditview', parameterName: 'yqxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanageyqxedit-view/vacleavemanageyqxedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/yqxeditview/:yqxeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.yqxeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'yqxeditview', parameterName: 'yqxeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanageyqxedit-view/vacleavemanageyqxedit-view.vue'),
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
        component: () => import('@pages/shp/pimpersonpickup-view/pimpersonpickup-view.vue'),
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
        component: () => import('@pages/shp/ormorgsectorfpxxpickup-view/ormorgsectorfpxxpickup-view.vue'),
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
        component: () => import('@pages/shp/ormorgsectorfpxxpickup-view/ormorgsectorfpxxpickup-view.vue'),
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
        component: () => import('@pages/shp/archivescenterpickup-grid-view/archivescenterpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/ybheditview/:ybheditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ybheditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ybheditview', parameterName: 'ybheditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanageybhedit-view/vacleavemanageybhedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/ybheditview/:ybheditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.ybheditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'ybheditview', parameterName: 'ybheditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanageybhedit-view/vacleavemanageybhedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimvocationals/:pimvocational?/grpimziggridview/:grpimziggridview?',
        meta: {
            caption: 'entities.pimvocational.views.grpimziggridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'grpimziggridview', parameterName: 'grpimziggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimvocationalgrpim-zig-grid-view/pimvocationalgrpim-zig-grid-view.vue'),
    },
    {
        path: '/pimvocationals/:pimvocational?/grpimziggridview/:grpimziggridview?',
        meta: {
            caption: 'entities.pimvocational.views.grpimziggridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'grpimziggridview', parameterName: 'grpimziggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimvocationalgrpim-zig-grid-view/pimvocationalgrpim-zig-grid-view.vue'),
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
        component: () => import('@pages/shp/pimachievementsedit-view/pimachievementsedit-view.vue'),
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
        component: () => import('@pages/shp/pimachievementsedit-view/pimachievementsedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpatents/:pimpatent?/grpatentgridview/:grpatentgridview?',
        meta: {
            caption: 'entities.pimpatent.views.grpatentgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpatents', parameterName: 'pimpatent' },
                { pathName: 'grpatentgridview', parameterName: 'grpatentgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpatentgrpatentgrid-view/pimpatentgrpatentgrid-view.vue'),
    },
    {
        path: '/pimpatents/:pimpatent?/grpatentgridview/:grpatentgridview?',
        meta: {
            caption: 'entities.pimpatent.views.grpatentgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhuanlixinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpatents', parameterName: 'pimpatent' },
                { pathName: 'grpatentgridview', parameterName: 'grpatentgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpatentgrpatentgrid-view/pimpatentgrpatentgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimrewardpunishments/:pimrewardpunishment?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimrewardpunishmentgredit-view/pimrewardpunishmentgredit-view.vue'),
    },
    {
        path: '/pimrewardpunishments/:pimrewardpunishment?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimrewardpunishment.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jianglichengfa.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimrewardpunishments', parameterName: 'pimrewardpunishment' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimrewardpunishmentgredit-view/pimrewardpunishmentgredit-view.vue'),
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
        component: () => import('@pages/shp/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
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
        component: () => import('@pages/shp/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/grpimworkgridview/:grpimworkgridview?',
        meta: {
            caption: 'entities.pimworkhistory.views.grpimworkgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'grpimworkgridview', parameterName: 'grpimworkgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimworkhistorygrpim-work-grid-view/pimworkhistorygrpim-work-grid-view.vue'),
    },
    {
        path: '/pimworkhistories/:pimworkhistory?/grpimworkgridview/:grpimworkgridview?',
        meta: {
            caption: 'entities.pimworkhistory.views.grpimworkgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'grpimworkgridview', parameterName: 'grpimworkgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimworkhistorygrpim-work-grid-view/pimworkhistorygrpim-work-grid-view.vue'),
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
        component: () => import('@pages/shp/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
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
        component: () => import('@pages/shp/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
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
        component: () => import('@pages/shp/pimarchivesloanandreturngrid-view/pimarchivesloanandreturngrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimeducations/:pimeducation?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimeducation.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimeducationgredit-view/pimeducationgredit-view.vue'),
    },
    {
        path: '/pimeducations/:pimeducation?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimeducation.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimeducations', parameterName: 'pimeducation' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimeducationgredit-view/pimeducationgredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/vacleavemanages/:vacleavemanage?/spzeditview/:spzeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.spzeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'spzeditview', parameterName: 'spzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanagespzedit-view/vacleavemanagespzedit-view.vue'),
    },
    {
        path: '/vacleavemanages/:vacleavemanage?/spzeditview/:spzeditview?',
        meta: {
            caption: 'entities.vacleavemanage.views.spzeditview.title',
            info:'',
            imgPath: '../../../img/newimage/1/qingjiaguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'vacleavemanages', parameterName: 'vacleavemanage' },
                { pathName: 'spzeditview', parameterName: 'spzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/vacleavemanagespzedit-view/vacleavemanagespzedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/grcontracteditview/:grcontracteditview?',
        meta: {
            caption: 'entities.pimcontract.views.grcontracteditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'grcontracteditview', parameterName: 'grcontracteditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimcontractgrcontract-edit-view/pimcontractgrcontract-edit-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/grcontracteditview/:grcontracteditview?',
        meta: {
            caption: 'entities.pimcontract.views.grcontracteditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'grcontracteditview', parameterName: 'grcontracteditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimcontractgrcontract-edit-view/pimcontractgrcontract-edit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpapers/:pimpaper?/grpapergridview/:grpapergridview?',
        meta: {
            caption: 'entities.pimpaper.views.grpapergridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpapers', parameterName: 'pimpaper' },
                { pathName: 'grpapergridview', parameterName: 'grpapergridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpapergr-papergrid-view/pimpapergr-papergrid-view.vue'),
    },
    {
        path: '/pimpapers/:pimpaper?/grpapergridview/:grpapergridview?',
        meta: {
            caption: 'entities.pimpaper.views.grpapergridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpapers', parameterName: 'pimpaper' },
                { pathName: 'grpapergridview', parameterName: 'grpapergridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpapergr-papergrid-view/pimpapergr-papergrid-view.vue'),
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
        component: () => import('@pages/shp/ormorgsectorfpxxpickup-grid-view/ormorgsectorfpxxpickup-grid-view.vue'),
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
        component: () => import('@pages/shp/ormorgsectorfpxxpickup-grid-view/ormorgsectorfpxxpickup-grid-view.vue'),
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
        component: () => import('@pages/shp/ormorgfpxxpickup-grid-view/ormorgfpxxpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimvocationals/:pimvocational?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimvocational.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimvocationalgredit-view/pimvocationalgredit-view.vue'),
    },
    {
        path: '/pimvocationals/:pimvocational?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimvocational.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimvocationals', parameterName: 'pimvocational' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimvocationalgredit-view/pimvocationalgredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimresearchfindings/:pimresearchfindings?/grresearchgridview/:grresearchgridview?',
        meta: {
            caption: 'entities.pimresearchfindings.views.grresearchgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/keyanchengguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                { pathName: 'grresearchgridview', parameterName: 'grresearchgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimresearchfindingsgrresearchgrid-view/pimresearchfindingsgrresearchgrid-view.vue'),
    },
    {
        path: '/pimresearchfindings/:pimresearchfindings?/grresearchgridview/:grresearchgridview?',
        meta: {
            caption: 'entities.pimresearchfindings.views.grresearchgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/keyanchengguo.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimresearchfindings', parameterName: 'pimresearchfindings' },
                { pathName: 'grresearchgridview', parameterName: 'grresearchgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimresearchfindingsgrresearchgrid-view/pimresearchfindingsgrresearchgrid-view.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-spz/pimexitandentryedit-view-spz.vue'),
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
        component: () => import('@pages/shp/pimexitandentryedit-view-spz/pimexitandentryedit-view-spz.vue'),
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
        component: () => import('@pages/shp/ormdutyorm-org-sector-pickup-grid-view/ormdutyorm-org-sector-pickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/kqjrypickupgridview/:kqjrypickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.kqjrypickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'kqjrypickupgridview', parameterName: 'kqjrypickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpersonkqjrypickup-grid-view/pimpersonkqjrypickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimlanguageabilities/:pimlanguageability?/gryynlgridview/:gryynlgridview?',
        meta: {
            caption: 'entities.pimlanguageability.views.gryynlgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/yuyanshuiping.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                { pathName: 'gryynlgridview', parameterName: 'gryynlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimlanguageabilitygryynlgrid-view/pimlanguageabilitygryynlgrid-view.vue'),
    },
    {
        path: '/pimlanguageabilities/:pimlanguageability?/gryynlgridview/:gryynlgridview?',
        meta: {
            caption: 'entities.pimlanguageability.views.gryynlgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/yuyanshuiping.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                { pathName: 'gryynlgridview', parameterName: 'gryynlgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimlanguageabilitygryynlgrid-view/pimlanguageabilitygryynlgrid-view.vue'),
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
        component: () => import('@pages/shp/ormorghtgldwpickup-view/ormorghtgldwpickup-view.vue'),
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
        component: () => import('@pages/shp/pimarchivesedit-view/pimarchivesedit-view.vue'),
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
        component: () => import('@pages/shp/pimarchivesedit-view/pimarchivesedit-view.vue'),
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
        component: () => import('@pages/shp/ormorghtgldwqpickup-grid-view/ormorghtgldwqpickup-grid-view.vue'),
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
        component: () => import('@pages/shp/pimpersonpickup-grid-view/pimpersonpickup-grid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimworkhistories/:pimworkhistory?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimworkhistory.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimworkhistorygredit-view/pimworkhistorygredit-view.vue'),
    },
    {
        path: '/pimworkhistories/:pimworkhistory?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimworkhistory.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimworkhistories', parameterName: 'pimworkhistory' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimworkhistorygredit-view/pimworkhistorygredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimlanguageabilities/:pimlanguageability?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimlanguageability.views.greditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimlanguageabilitygredit-view/pimlanguageabilitygredit-view.vue'),
    },
    {
        path: '/pimlanguageabilities/:pimlanguageability?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimlanguageability.views.greditview.title',
            info:'',
            parameters: [
                { pathName: 'pimlanguageabilities', parameterName: 'pimlanguageability' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimlanguageabilitygredit-view/pimlanguageabilitygredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/grzzeditview/:grzzeditview?',
        meta: {
            caption: 'entities.pimperson.views.grzzeditview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'grzzeditview', parameterName: 'grzzeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpersongrzzedit-view/pimpersongrzzedit-view.vue'),
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
        component: () => import('@pages/shp/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
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
        component: () => import('@pages/shp/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
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
        component: () => import('@pages/shp/pimarchiveschangeedit-view/pimarchiveschangeedit-view.vue'),
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
        component: () => import('@pages/shp/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
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
        component: () => import('@pages/shp/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
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
        component: () => import('@pages/shp/pimarchivesloanandreturnedit-view/pimarchivesloanandreturnedit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimpapers/:pimpaper?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimpaper.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimpapers', parameterName: 'pimpaper' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpapergredit-view/pimpapergredit-view.vue'),
    },
    {
        path: '/pimpapers/:pimpaper?/greditview/:greditview?',
        meta: {
            caption: 'entities.pimpaper.views.greditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/lunwenxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpapers', parameterName: 'pimpaper' },
                { pathName: 'greditview', parameterName: 'greditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimpapergredit-view/pimpapergredit-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/pimcontracts/:pimcontract?/grcontractgridview/:grcontractgridview?',
        meta: {
            caption: 'entities.pimcontract.views.grcontractgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'grcontractgridview', parameterName: 'grcontractgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimcontractgrcontract-grid-view/pimcontractgrcontract-grid-view.vue'),
    },
    {
        path: '/pimcontracts/:pimcontract?/grcontractgridview/:grcontractgridview?',
        meta: {
            caption: 'entities.pimcontract.views.grcontractgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pimcontracts', parameterName: 'pimcontract' },
                { pathName: 'grcontractgridview', parameterName: 'grcontractgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/shp/pimcontractgrcontract-grid-view/pimcontractgrcontract-grid-view.vue'),
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
