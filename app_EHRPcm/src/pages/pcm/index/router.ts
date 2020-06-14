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
                    path: 'pcmxkmls/:pcmxkml?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pcmxkml.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmxkmlpickup-grid-view/pcmxkmlpickup-grid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmtestresults/:pcmtestresult?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmtestresult.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/test-result-edit-view/test-result-edit-view.vue'),
                },
                {
                    path: 'pcmtestresults/:pcmtestresult?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmtestresult.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/test-result-edit-view/test-result-edit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmawardswons/:pcmawardswons?/hjqk_wsswbjgridview/:hjqk_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmawardswons.views.hjqk_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                            { pathName: 'hjqk_wsswbjgridview', parameterName: 'hjqk_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmawardswonshjqk-wsswbjgrid-view/pcmawardswonshjqk-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmawardswons/:pcmawardswons?/hjqk_wsswbjgridview/:hjqk_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmawardswons.views.hjqk_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                            { pathName: 'hjqk_wsswbjgridview', parameterName: 'hjqk_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmawardswonshjqk-wsswbjgrid-view/pcmawardswonshjqk-wsswbjgrid-view.vue'),
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
                    path: 'pcmprofiles/:pcmprofile?/qtzpwizardview/:qtzpwizardview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.qtzpwizardview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'qtzpwizardview', parameterName: 'qtzpwizardview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileqtzpwizard-view/pcmprofileqtzpwizard-view.vue'),
                },
                {
                    path: 'pcmxkmls/:pcmxkml?/pcmgxxktemps/:pcmgxxktemp?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pcmgxxktemp.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                            { pathName: 'pcmgxxktemps', parameterName: 'pcmgxxktemp' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmgxxktempgrid-view/pcmgxxktempgrid-view.vue'),
                },
                {
                    path: 'pcmgxmls/:pcmgxml?/pcmgxxktemps/:pcmgxxktemp?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pcmgxxktemp.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                            { pathName: 'pcmgxxktemps', parameterName: 'pcmgxxktemp' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmgxxktempgrid-view/pcmgxxktempgrid-view.vue'),
                },
                {
                    path: 'pcmgxxktemps/:pcmgxxktemp?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pcmgxxktemp.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmgxxktemps', parameterName: 'pcmgxxktemp' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmgxxktempgrid-view/pcmgxxktempgrid-view.vue'),
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
                    path: 'pcmprofiles/:pcmprofile?/pcmworkresumes/:pcmworkresume?/gzll_wsswbjgridview/:gzll_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmworkresume.views.gzll_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                            { pathName: 'gzll_wsswbjgridview', parameterName: 'gzll_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmworkresumegzll-wsswbjgrid-view/pcmworkresumegzll-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmworkresumes/:pcmworkresume?/gzll_wsswbjgridview/:gzll_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmworkresume.views.gzll_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                            { pathName: 'gzll_wsswbjgridview', parameterName: 'gzll_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmworkresumegzll-wsswbjgrid-view/pcmworkresumegzll-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rlsbgridview/:rlsbgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rlsbgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rlsbgridview', parameterName: 'rlsbgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerlsbgrid-view/pcmprofilerlsbgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/zczsgridview/:zczsgridview?',
                    meta: {
                        caption: 'entities.pcmcertofreg.views.zczsgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                            { pathName: 'zczsgridview', parameterName: 'zczsgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmcertofregzczsgrid-view/pcmcertofregzczsgrid-view.vue'),
                },
                {
                    path: 'pcmcertofregs/:pcmcertofreg?/zczsgridview/:zczsgridview?',
                    meta: {
                        caption: 'entities.pcmcertofreg.views.zczsgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                            { pathName: 'zczsgridview', parameterName: 'zczsgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmcertofregzczsgrid-view/pcmcertofregzczsgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmtdzwxxes/:pcmtdzwxx?/tdzw_wsswbjgridview/:tdzw_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmtdzwxx.views.tdzw_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                            { pathName: 'tdzw_wsswbjgridview', parameterName: 'tdzw_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/tdzwxxtdzw-wsswbjgrid-view/tdzwxxtdzw-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmtdzwxxes/:pcmtdzwxx?/tdzw_wsswbjgridview/:tdzw_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmtdzwxx.views.tdzw_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                            { pathName: 'tdzw_wsswbjgridview', parameterName: 'tdzw_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/tdzwxxtdzw-wsswbjgrid-view/tdzwxxtdzw-wsswbjgrid-view.vue'),
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
                    component: () => import('@pages/orm/ormorgsectorydbmpickup-grid-view/ormorgsectorydbmpickup-grid-view.vue'),
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
                    component: () => import('@pages/orm/ormorgsectorydbmpickup-grid-view/ormorgsectorydbmpickup-grid-view.vue'),
                },
                {
                    path: 'pcmxkmls/:pcmxkml?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmxkml.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengmuluguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmxkmledit-view/pcmxkmledit-view.vue'),
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
                    path: 'pcmprofiles/:pcmprofile?/fpwizardview/:fpwizardview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.fpwizardview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'fpwizardview', parameterName: 'fpwizardview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilefpwizard-view/pcmprofilefpwizard-view.vue'),
                },
                {
                    path: 'pcmgxmls/:pcmgxml?/pickupgridview/:pickupgridview?',
                    meta: {
                        caption: 'entities.pcmgxml.views.pickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                            { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmgxmlpickup-grid-view/pcmgxmlpickup-grid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/szwizardview/:szwizardview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.szwizardview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'szwizardview', parameterName: 'szwizardview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileszwizard-view/pcmprofileszwizard-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rlsb_csrcyjxgeditview/:rlsb_csrcyjxgeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rlsb_csrcyjxgeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rlsb_csrcyjxgeditview', parameterName: 'rlsb_csrcyjxgeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerlsb-csrcyjxgedit-view/pcmprofilerlsb-csrcyjxgedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmschooloffices/:pcmschooloffice?/zxzwgridview/:zxzwgridview?',
                    meta: {
                        caption: 'entities.pcmschooloffice.views.zxzwgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                            { pathName: 'zxzwgridview', parameterName: 'zxzwgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmschoolofficezxzwgrid-view/pcmschoolofficezxzwgrid-view.vue'),
                },
                {
                    path: 'pcmschooloffices/:pcmschooloffice?/zxzwgridview/:zxzwgridview?',
                    meta: {
                        caption: 'entities.pcmschooloffice.views.zxzwgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                            { pathName: 'zxzwgridview', parameterName: 'zxzwgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmschoolofficezxzwgrid-view/pcmschoolofficezxzwgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/ypzxx_lreditview/:ypzxx_lreditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.ypzxx_lreditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'ypzxx_lreditview', parameterName: 'ypzxx_lreditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileypzxx-lredit-view/pcmprofileypzxx-lredit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/bhspgridview/:bhspgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.bhspgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'bhspgridview', parameterName: 'bhspgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilebhspgrid-view/pcmprofilebhspgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmtestresults/:pcmtestresult?/cpjg_wsswbjgridview/:cpjg_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmtestresult.views.cpjg_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                            { pathName: 'cpjg_wsswbjgridview', parameterName: 'cpjg_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/test-result-cpjg-wsswbjgrid-view/test-result-cpjg-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmtestresults/:pcmtestresult?/cpjg_wsswbjgridview/:cpjg_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmtestresult.views.cpjg_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                            { pathName: 'cpjg_wsswbjgridview', parameterName: 'cpjg_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/test-result-cpjg-wsswbjgrid-view/test-result-cpjg-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmzpmegls/:pcmzpmegl?/curndgridview/:curndgridview?',
                    meta: {
                        caption: 'entities.pcmzpmegl.views.curndgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmzpmegls', parameterName: 'pcmzpmegl' },
                            { pathName: 'curndgridview', parameterName: 'curndgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmzpmeglcur-ndgrid-view/pcmzpmeglcur-ndgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmschooloffices/:pcmschooloffice?/zxzw_wsswbjgridview/:zxzw_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmschooloffice.views.zxzw_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                            { pathName: 'zxzw_wsswbjgridview', parameterName: 'zxzw_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmschoolofficezxzw-wsswbjgrid-view/pcmschoolofficezxzw-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmschooloffices/:pcmschooloffice?/zxzw_wsswbjgridview/:zxzw_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmschooloffice.views.zxzw_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                            { pathName: 'zxzw_wsswbjgridview', parameterName: 'zxzw_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmschoolofficezxzw-wsswbjgrid-view/pcmschoolofficezxzw-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rzsp_csrcyjgridview/:rzsp_csrcyjgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rzsp_csrcyjgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rzsp_csrcyjgridview', parameterName: 'rzsp_csrcyjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerzsp-csrcyjgrid-view/pcmprofilerzsp-csrcyjgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmawardswons/:pcmawardswons?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmawardswons.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmawardswonsedit-view/pcmawardswonsedit-view.vue'),
                },
                {
                    path: 'pcmawardswons/:pcmawardswons?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmawardswons.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmawardswonsedit-view/pcmawardswonsedit-view.vue'),
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
                    component: () => import('@pages/orm/ormorgsectorydbmpickup-view/ormorgsectorydbmpickup-view.vue'),
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
                    component: () => import('@pages/orm/ormorgsectorydbmpickup-view/ormorgsectorydbmpickup-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/bhspeditview/:bhspeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.bhspeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'bhspeditview', parameterName: 'bhspeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilebhspedit-view/pcmprofilebhspedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/ypzxx_csrcyjgridview/:ypzxx_csrcyjgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.ypzxx_csrcyjgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'ypzxx_csrcyjgridview', parameterName: 'ypzxx_csrcyjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileypzxx-csrcyjgrid-view/pcmprofileypzxx-csrcyjgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmtestresults/:pcmtestresult?/cpjggridview/:cpjggridview?',
                    meta: {
                        caption: 'entities.pcmtestresult.views.cpjggridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                            { pathName: 'cpjggridview', parameterName: 'cpjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/test-result-cpjggrid-view/test-result-cpjggrid-view.vue'),
                },
                {
                    path: 'pcmtestresults/:pcmtestresult?/cpjggridview/:cpjggridview?',
                    meta: {
                        caption: 'entities.pcmtestresult.views.cpjggridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                            { pathName: 'cpjggridview', parameterName: 'cpjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/test-result-cpjggrid-view/test-result-cpjggrid-view.vue'),
                },
                {
                    path: 'pcmzpmegls/:pcmzpmegl?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmzpmegl.views.editview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmzpmegls', parameterName: 'pcmzpmegl' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmzpmegledit-view/pcmzpmegledit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/bhsp_csrcyjgridview/:bhsp_csrcyjgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.bhsp_csrcyjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'bhsp_csrcyjgridview', parameterName: 'bhsp_csrcyjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilebhsp-csrcyjgrid-view/pcmprofilebhsp-csrcyjgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/txrypickupview/:txrypickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.txrypickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'txrypickupview', parameterName: 'txrypickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersontxrypickup-view/pimpersontxrypickup-view.vue'),
                },
                {
                    path: 'pcmzpmegls/:pcmzpmegl?/treeexpview/:treeexpview?',
                    meta: {
                        caption: 'entities.pcmzpmegl.views.treeexpview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmzpmegls', parameterName: 'pcmzpmegl' },
                            { pathName: 'treeexpview', parameterName: 'treeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmzpmegltree-exp-view/pcmzpmegltree-exp-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmeducationexperiences/:pcmeducationexperience?/jybjgridview/:jybjgridview?',
                    meta: {
                        caption: 'entities.pcmeducationexperience.views.jybjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                            { pathName: 'jybjgridview', parameterName: 'jybjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmeducation-experience-jybjgrid-view/pcmeducation-experience-jybjgrid-view.vue'),
                },
                {
                    path: 'pcmeducationexperiences/:pcmeducationexperience?/jybjgridview/:jybjgridview?',
                    meta: {
                        caption: 'entities.pcmeducationexperience.views.jybjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                            { pathName: 'jybjgridview', parameterName: 'jybjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmeducation-experience-jybjgrid-view/pcmeducation-experience-jybjgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rlsb_csrcyjeditview/:rlsb_csrcyjeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rlsb_csrcyjeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rlsb_csrcyjeditview', parameterName: 'rlsb_csrcyjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerlsb-csrcyjedit-view/pcmprofilerlsb-csrcyjedit-view.vue'),
                },
                {
                    path: 'pcmxkmls/:pcmxkml?/curndgridview/:curndgridview?',
                    meta: {
                        caption: 'entities.pcmxkml.views.curndgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhichengmuluguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                            { pathName: 'curndgridview', parameterName: 'curndgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmxkmlcur-ndgrid-view/pcmxkmlcur-ndgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmpracticeexperiences/:pcmpracticeexperience?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmpracticeexperience.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmpracticeexperienceedit-view/pcmpracticeexperienceedit-view.vue'),
                },
                {
                    path: 'pcmpracticeexperiences/:pcmpracticeexperience?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmpracticeexperience.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmpracticeexperienceedit-view/pcmpracticeexperienceedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/zpdwshgridview/:zpdwshgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.zpdwshgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'zpdwshgridview', parameterName: 'zpdwshgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilezpdwshgrid-view/pcmprofilezpdwshgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmeducationexperiences/:pcmeducationexperience?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmeducationexperience.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmeducation-experience-edit-view/pcmeducation-experience-edit-view.vue'),
                },
                {
                    path: 'pcmeducationexperiences/:pcmeducationexperience?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmeducationexperience.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmeducation-experience-edit-view/pcmeducation-experience-edit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/zpdwsheditview/:zpdwsheditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.zpdwsheditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'zpdwsheditview', parameterName: 'zpdwsheditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilezpdwshedit-view/pcmprofilezpdwshedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rlsb_xgeditview/:rlsb_xgeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rlsb_xgeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rlsb_xgeditview', parameterName: 'rlsb_xgeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerlsb-xgedit-view/pcmprofilerlsb-xgedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ypzxxsypickupgridview/:ypzxxsypickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.ypzxxsypickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ypzxxsypickupgridview', parameterName: 'ypzxxsypickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgypzxxsypickup-grid-view/ormorgypzxxsypickup-grid-view.vue'),
                },
                {
                    path: 'pcmgxmls/:pcmgxml?/gxmltreeexpview/:gxmltreeexpview?',
                    meta: {
                        caption: 'entities.pcmgxml.views.gxmltreeexpview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                            { pathName: 'gxmltreeexpview', parameterName: 'gxmltreeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmgxmlgxmltree-exp-view/pcmgxmlgxmltree-exp-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmschooloffices/:pcmschooloffice?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmschooloffice.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmschoolofficeedit-view/pcmschoolofficeedit-view.vue'),
                },
                {
                    path: 'pcmschooloffices/:pcmschooloffice?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmschooloffice.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmschoolofficeedit-view/pcmschoolofficeedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/bhsp_csrcyjeditview/:bhsp_csrcyjeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.bhsp_csrcyjeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/hetongguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'bhsp_csrcyjeditview', parameterName: 'bhsp_csrcyjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilebhsp-csrcyjedit-view/pcmprofilebhsp-csrcyjedit-view.vue'),
                },
                {
                    path: 'pcmxkmls/:pcmxkml?/xkmltreeexpview/:xkmltreeexpview?',
                    meta: {
                        caption: 'entities.pcmxkml.views.xkmltreeexpview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                            { pathName: 'xkmltreeexpview', parameterName: 'xkmltreeexpview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmxkmlxkmltree-exp-view/pcmxkmlxkmltree-exp-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rzsp_csrcyjeditview/:rzsp_csrcyjeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rzsp_csrcyjeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rzsp_csrcyjeditview', parameterName: 'rzsp_csrcyjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerzsp-csrcyjedit-view/pcmprofilerzsp-csrcyjedit-view.vue'),
                },
                {
                    path: 'pcmprofilespyys/:pcmprofilespyy?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmprofilespyy.views.editview.title',
                        info:'',
                        imgPath: '../../../img/kfgl/1/peixunjiluguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofilespyys', parameterName: 'pcmprofilespyy' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilespyyedit-view/pcmprofilespyyedit-view.vue'),
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
                    component: () => import('@pages/orm/ormorgpickup-view/ormorgpickup-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmawardswons/:pcmawardswons?/hjqkgridview/:hjqkgridview?',
                    meta: {
                        caption: 'entities.pcmawardswons.views.hjqkgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                            { pathName: 'hjqkgridview', parameterName: 'hjqkgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmawardswonshjqkgrid-view/pcmawardswonshjqkgrid-view.vue'),
                },
                {
                    path: 'pcmawardswons/:pcmawardswons?/hjqkgridview/:hjqkgridview?',
                    meta: {
                        caption: 'entities.pcmawardswons.views.hjqkgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                            { pathName: 'hjqkgridview', parameterName: 'hjqkgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmawardswonshjqkgrid-view/pcmawardswonshjqkgrid-view.vue'),
                },
                {
                    path: 'pcmgxmls/:pcmgxml?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.pcmgxml.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmgxmlmpickup-view/pcmgxmlmpickup-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/ypzbdeditview/:ypzbdeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.ypzbdeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/xinqianhetong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'ypzbdeditview', parameterName: 'ypzbdeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileypzbdedit-view/pcmprofileypzbdedit-view.vue'),
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
                    path: 'pcmprofiles/:pcmprofile?/pcmpracticeexperiences/:pcmpracticeexperience?/sxjy_wsswbjgridview/:sxjy_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmpracticeexperience.views.sxjy_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                            { pathName: 'sxjy_wsswbjgridview', parameterName: 'sxjy_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmpracticeexperiencesxjy-wsswbjgrid-view/pcmpracticeexperiencesxjy-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmpracticeexperiences/:pcmpracticeexperience?/sxjy_wsswbjgridview/:sxjy_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmpracticeexperience.views.sxjy_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                            { pathName: 'sxjy_wsswbjgridview', parameterName: 'sxjy_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmpracticeexperiencesxjy-wsswbjgrid-view/pcmpracticeexperiencesxjy-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmgxmls/:pcmgxml?/curndgridview/:curndgridview?',
                    meta: {
                        caption: 'entities.pcmgxml.views.curndgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                            { pathName: 'curndgridview', parameterName: 'curndgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcm-gxml-cur-ndgrid-view/pcm-gxml-cur-ndgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rlsbeditview/:rlsbeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rlsbeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rlsbeditview', parameterName: 'rlsbeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerlsbedit-view/pcmprofilerlsbedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/yrdwcs_csrcyjeditview/:yrdwcs_csrcyjeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.yrdwcs_csrcyjeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'yrdwcs_csrcyjeditview', parameterName: 'yrdwcs_csrcyjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileyrdwcs-csrcyjedit-view/pcmprofileyrdwcs-csrcyjedit-view.vue'),
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
                    component: () => import('@pages/orm/ormorgpickup-grid-view/ormorgpickup-grid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rzspgridview/:rzspgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rzspgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rzspgridview', parameterName: 'rzspgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerzspgrid-view/pcmprofilerzspgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rzspeditview/:rzspeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rzspeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rzspeditview', parameterName: 'rzspeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerzspedit-view/pcmprofilerzspedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/xzwizardview/:xzwizardview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.xzwizardview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'xzwizardview', parameterName: 'xzwizardview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilexzwizard-view/pcmprofilexzwizard-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/ypzbd_csrcyjeditview/:ypzbd_csrcyjeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.ypzbd_csrcyjeditview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/xinqianhetong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'ypzbd_csrcyjeditview', parameterName: 'ypzbd_csrcyjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileypzbd-csrcyjedit-view/pcmprofileypzbd-csrcyjedit-view.vue'),
                },
                {
                    path: 'ormorgs/:ormorg?/ypzsyfpxxpickupview/:ypzsyfpxxpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.ypzsyfpxxpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'ormorgs', parameterName: 'ormorg' },
                            { pathName: 'ypzsyfpxxpickupview', parameterName: 'ypzsyfpxxpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/orm/ormorgypzsyfpxxpickup-view/ormorgypzsyfpxxpickup-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/zczs_wsswbjgridview/:zczs_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmcertofreg.views.zczs_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                            { pathName: 'zczs_wsswbjgridview', parameterName: 'zczs_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmcertofregzczs-wsswbjgrid-view/pcmcertofregzczs-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmcertofregs/:pcmcertofreg?/zczs_wsswbjgridview/:zczs_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmcertofreg.views.zczs_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                            { pathName: 'zczs_wsswbjgridview', parameterName: 'zczs_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmcertofregzczs-wsswbjgrid-view/pcmcertofregzczs-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/ypzbdgridview/:ypzbdgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.ypzbdgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/xinqianhetong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'ypzbdgridview', parameterName: 'ypzbdgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileypzbdgrid-view/pcmprofileypzbdgrid-view.vue'),
                },
                {
                    path: 'pcmxkmls/:pcmxkml?/mpickupview/:mpickupview?',
                    meta: {
                        caption: 'entities.pcmxkml.views.mpickupview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                            { pathName: 'mpickupview', parameterName: 'mpickupview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmxkmlmpickup-view/pcmxkmlmpickup-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/ypzxx_csrcyjeditview/:ypzxx_csrcyjeditview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.ypzxx_csrcyjeditview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'ypzxx_csrcyjeditview', parameterName: 'ypzxx_csrcyjeditview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileypzxx-csrcyjedit-view/pcmprofileypzxx-csrcyjedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmprofileapprovals/:pcmprofileapproval?/jjgridview/:jjgridview?',
                    meta: {
                        caption: 'entities.pcmprofileapproval.views.jjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmprofileapprovals', parameterName: 'pcmprofileapproval' },
                            { pathName: 'jjgridview', parameterName: 'jjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileapprovaljjgrid-view/pcmprofileapprovaljjgrid-view.vue'),
                },
                {
                    path: 'pcmprofileapprovals/:pcmprofileapproval?/jjgridview/:jjgridview?',
                    meta: {
                        caption: 'entities.pcmprofileapproval.views.jjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/zhiyezige.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofileapprovals', parameterName: 'pcmprofileapproval' },
                            { pathName: 'jjgridview', parameterName: 'jjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileapprovaljjgrid-view/pcmprofileapprovaljjgrid-view.vue'),
                },
                {
                    path: 'pimpeople/:pimperson?/txrypickupgridview/:txrypickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.txrypickupgridview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pimpeople', parameterName: 'pimperson' },
                            { pathName: 'txrypickupgridview', parameterName: 'txrypickupgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pim/pimpersontxrypickup-grid-view/pimpersontxrypickup-grid-view.vue'),
                },
                {
                    path: 'pcmgxmls/:pcmgxml?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmgxml.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/danganxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmgxmledit-view/pcmgxmledit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/rlsb_csrcyjgridview/:rlsb_csrcyjgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.rlsb_csrcyjgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'rlsb_csrcyjgridview', parameterName: 'rlsb_csrcyjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilerlsb-csrcyjgrid-view/pcmprofilerlsb-csrcyjgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmpracticeexperiences/:pcmpracticeexperience?/sxjygridview/:sxjygridview?',
                    meta: {
                        caption: 'entities.pcmpracticeexperience.views.sxjygridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                            { pathName: 'sxjygridview', parameterName: 'sxjygridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmpracticeexperiencesxjygrid-view/pcmpracticeexperiencesxjygrid-view.vue'),
                },
                {
                    path: 'pcmpracticeexperiences/:pcmpracticeexperience?/sxjygridview/:sxjygridview?',
                    meta: {
                        caption: 'entities.pcmpracticeexperience.views.sxjygridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                            { pathName: 'sxjygridview', parameterName: 'sxjygridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmpracticeexperiencesxjygrid-view/pcmpracticeexperiencesxjygrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmcertofreg.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmcertofregedit-view/pcmcertofregedit-view.vue'),
                },
                {
                    path: 'pcmcertofregs/:pcmcertofreg?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmcertofreg.views.editview.title',
                        info:'',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmcertofregedit-view/pcmcertofregedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmeducationexperiences/:pcmeducationexperience?/jybj_wsswbjgridview/:jybj_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmeducationexperience.views.jybj_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                            { pathName: 'jybj_wsswbjgridview', parameterName: 'jybj_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmeducation-experience-jybj-wsswbjgrid-view/pcmeducation-experience-jybj-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmeducationexperiences/:pcmeducationexperience?/jybj_wsswbjgridview/:jybj_wsswbjgridview?',
                    meta: {
                        caption: 'entities.pcmeducationexperience.views.jybj_wsswbjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                            { pathName: 'jybj_wsswbjgridview', parameterName: 'jybj_wsswbjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmeducation-experience-jybj-wsswbjgrid-view/pcmeducation-experience-jybj-wsswbjgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/ypzbd_csrcyjgridview/:ypzbd_csrcyjgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.ypzbd_csrcyjgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/xinqianhetong.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'ypzbd_csrcyjgridview', parameterName: 'ypzbd_csrcyjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileypzbd-csrcyjgrid-view/pcmprofileypzbd-csrcyjgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/ypzxx_lrgridview/:ypzxx_lrgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.ypzxx_lrgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'ypzxx_lrgridview', parameterName: 'ypzxx_lrgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileypzxx-lrgrid-view/pcmprofileypzxx-lrgrid-view.vue'),
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
                    path: 'pcmprofiles/:pcmprofile?/pcmtdzwxxes/:pcmtdzwxx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmtdzwxx.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/tdzwxxedit-view/tdzwxxedit-view.vue'),
                },
                {
                    path: 'pcmtdzwxxes/:pcmtdzwxx?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmtdzwxx.views.editview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/tdzwxxedit-view/tdzwxxedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmtdzwxxes/:pcmtdzwxx?/tdzwgridview/:tdzwgridview?',
                    meta: {
                        caption: 'entities.pcmtdzwxx.views.tdzwgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                            { pathName: 'tdzwgridview', parameterName: 'tdzwgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/tdzwxxtdzwgrid-view/tdzwxxtdzwgrid-view.vue'),
                },
                {
                    path: 'pcmtdzwxxes/:pcmtdzwxx?/tdzwgridview/:tdzwgridview?',
                    meta: {
                        caption: 'entities.pcmtdzwxx.views.tdzwgridview.title',
                        info:'',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                            { pathName: 'tdzwgridview', parameterName: 'tdzwgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/tdzwxxtdzwgrid-view/tdzwxxtdzwgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmworkresumes/:pcmworkresume?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmworkresume.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmworkresumeedit-view/pcmworkresumeedit-view.vue'),
                },
                {
                    path: 'pcmworkresumes/:pcmworkresume?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmworkresume.views.editview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                            { pathName: 'editview', parameterName: 'editview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmworkresumeedit-view/pcmworkresumeedit-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmworkresumes/:pcmworkresume?/gzllgridview/:gzllgridview?',
                    meta: {
                        caption: 'entities.pcmworkresume.views.gzllgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                            { pathName: 'gzllgridview', parameterName: 'gzllgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmworkresumegzllgrid-view/pcmworkresumegzllgrid-view.vue'),
                },
                {
                    path: 'pcmworkresumes/:pcmworkresume?/gzllgridview/:gzllgridview?',
                    meta: {
                        caption: 'entities.pcmworkresume.views.gzllgridview.title',
                        info:'',
                        imgPath: '../../../img/jcgl/1/gongzuolvli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                            { pathName: 'gzllgridview', parameterName: 'gzllgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmworkresumegzllgrid-view/pcmworkresumegzllgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/yrdwcs_csrcyjgridview/:yrdwcs_csrcyjgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.yrdwcs_csrcyjgridview.title',
                        info:'',
                        imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'yrdwcs_csrcyjgridview', parameterName: 'yrdwcs_csrcyjgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofileyrdwcs-csrcyjgrid-view/pcmprofileyrdwcs-csrcyjgrid-view.vue'),
                },
                {
                    path: 'pcmprofilespyys/:pcmprofilespyy?/gridview/:gridview?',
                    meta: {
                        caption: 'entities.pcmprofilespyy.views.gridview.title',
                        info:'',
                        imgPath: '../../../img/kfgl/1/peixunjiluguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofilespyys', parameterName: 'pcmprofilespyy' },
                            { pathName: 'gridview', parameterName: 'gridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/pcmprofilespyygrid-view/pcmprofilespyygrid-view.vue'),
                },
            ...indexRoutes,
            ],
        },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmworkresumes/:pcmworkresume?/gzll_wsswbjgridview/:gzll_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmworkresume.views.gzll_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                { pathName: 'gzll_wsswbjgridview', parameterName: 'gzll_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmworkresumegzll-wsswbjgrid-view/pcmworkresumegzll-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmworkresumes/:pcmworkresume?/gzll_wsswbjgridview/:gzll_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmworkresume.views.gzll_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                { pathName: 'gzll_wsswbjgridview', parameterName: 'gzll_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmworkresumegzll-wsswbjgrid-view/pcmworkresumegzll-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmprofilespyys/:pcmprofilespyy?/gridview/:gridview?',
        meta: {
            caption: 'entities.pcmprofilespyy.views.gridview.title',
            info:'',
            imgPath: '../../../img/kfgl/1/peixunjiluguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofilespyys', parameterName: 'pcmprofilespyy' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilespyygrid-view/pcmprofilespyygrid-view.vue'),
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
        path: '/pcmprofiles/:pcmprofile?/pcmworkresumes/:pcmworkresume?/gzllgridview/:gzllgridview?',
        meta: {
            caption: 'entities.pcmworkresume.views.gzllgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                { pathName: 'gzllgridview', parameterName: 'gzllgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmworkresumegzllgrid-view/pcmworkresumegzllgrid-view.vue'),
    },
    {
        path: '/pcmworkresumes/:pcmworkresume?/gzllgridview/:gzllgridview?',
        meta: {
            caption: 'entities.pcmworkresume.views.gzllgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                { pathName: 'gzllgridview', parameterName: 'gzllgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmworkresumegzllgrid-view/pcmworkresumegzllgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/txrypickupview/:txrypickupview?',
        meta: {
            caption: 'entities.pimperson.views.txrypickupview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'txrypickupview', parameterName: 'txrypickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersontxrypickup-view/pimpersontxrypickup-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmschooloffices/:pcmschooloffice?/editview/:editview?',
        meta: {
            caption: 'entities.pcmschooloffice.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmschoolofficeedit-view/pcmschoolofficeedit-view.vue'),
    },
    {
        path: '/pcmschooloffices/:pcmschooloffice?/editview/:editview?',
        meta: {
            caption: 'entities.pcmschooloffice.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmschoolofficeedit-view/pcmschoolofficeedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/ypzbd_csrcyjgridview/:ypzbd_csrcyjgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.ypzbd_csrcyjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/xinqianhetong.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'ypzbd_csrcyjgridview', parameterName: 'ypzbd_csrcyjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileypzbd-csrcyjgrid-view/pcmprofileypzbd-csrcyjgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ypzxxsypickupgridview/:ypzxxsypickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.ypzxxsypickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ypzxxsypickupgridview', parameterName: 'ypzxxsypickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgypzxxsypickup-grid-view/ormorgypzxxsypickup-grid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/rlsb_csrcyjgridview/:rlsb_csrcyjgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.rlsb_csrcyjgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rlsb_csrcyjgridview', parameterName: 'rlsb_csrcyjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerlsb-csrcyjgrid-view/pcmprofilerlsb-csrcyjgrid-view.vue'),
    },
    {
        path: '/pcmgxmls/:pcmgxml?/curndgridview/:curndgridview?',
        meta: {
            caption: 'entities.pcmgxml.views.curndgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                { pathName: 'curndgridview', parameterName: 'curndgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcm-gxml-cur-ndgrid-view/pcm-gxml-cur-ndgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/bhsp_csrcyjeditview/:bhsp_csrcyjeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.bhsp_csrcyjeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'bhsp_csrcyjeditview', parameterName: 'bhsp_csrcyjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilebhsp-csrcyjedit-view/pcmprofilebhsp-csrcyjedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmeducationexperiences/:pcmeducationexperience?/editview/:editview?',
        meta: {
            caption: 'entities.pcmeducationexperience.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmeducation-experience-edit-view/pcmeducation-experience-edit-view.vue'),
    },
    {
        path: '/pcmeducationexperiences/:pcmeducationexperience?/editview/:editview?',
        meta: {
            caption: 'entities.pcmeducationexperience.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmeducation-experience-edit-view/pcmeducation-experience-edit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmeducationexperiences/:pcmeducationexperience?/jybj_wsswbjgridview/:jybj_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmeducationexperience.views.jybj_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                { pathName: 'jybj_wsswbjgridview', parameterName: 'jybj_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmeducation-experience-jybj-wsswbjgrid-view/pcmeducation-experience-jybj-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmeducationexperiences/:pcmeducationexperience?/jybj_wsswbjgridview/:jybj_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmeducationexperience.views.jybj_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                { pathName: 'jybj_wsswbjgridview', parameterName: 'jybj_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmeducation-experience-jybj-wsswbjgrid-view/pcmeducation-experience-jybj-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmzpmegls/:pcmzpmegl?/treeexpview/:treeexpview?',
        meta: {
            caption: 'entities.pcmzpmegl.views.treeexpview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmzpmegls', parameterName: 'pcmzpmegl' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmzpmegltree-exp-view/pcmzpmegltree-exp-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/bhsp_csrcyjgridview/:bhsp_csrcyjgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.bhsp_csrcyjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'bhsp_csrcyjgridview', parameterName: 'bhsp_csrcyjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilebhsp-csrcyjgrid-view/pcmprofilebhsp-csrcyjgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmtdzwxxes/:pcmtdzwxx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmtdzwxx.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/tdzwxxedit-view/tdzwxxedit-view.vue'),
    },
    {
        path: '/pcmtdzwxxes/:pcmtdzwxx?/editview/:editview?',
        meta: {
            caption: 'entities.pcmtdzwxx.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/tdzwxxedit-view/tdzwxxedit-view.vue'),
    },
    {
        path: '/pcmxkmls/:pcmxkml?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pcmxkml.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmxkmlpickup-grid-view/pcmxkmlpickup-grid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmtestresults/:pcmtestresult?/cpjggridview/:cpjggridview?',
        meta: {
            caption: 'entities.pcmtestresult.views.cpjggridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                { pathName: 'cpjggridview', parameterName: 'cpjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/test-result-cpjggrid-view/test-result-cpjggrid-view.vue'),
    },
    {
        path: '/pcmtestresults/:pcmtestresult?/cpjggridview/:cpjggridview?',
        meta: {
            caption: 'entities.pcmtestresult.views.cpjggridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                { pathName: 'cpjggridview', parameterName: 'cpjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/test-result-cpjggrid-view/test-result-cpjggrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/rlsb_xgeditview/:rlsb_xgeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.rlsb_xgeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rlsb_xgeditview', parameterName: 'rlsb_xgeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerlsb-xgedit-view/pcmprofilerlsb-xgedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/xzwizardview/:xzwizardview?',
        meta: {
            caption: 'entities.pcmprofile.views.xzwizardview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'xzwizardview', parameterName: 'xzwizardview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilexzwizard-view/pcmprofilexzwizard-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/ypzxx_lrgridview/:ypzxx_lrgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.ypzxx_lrgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'ypzxx_lrgridview', parameterName: 'ypzxx_lrgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileypzxx-lrgrid-view/pcmprofileypzxx-lrgrid-view.vue'),
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
        path: '/pcmprofiles/:pcmprofile?/pcmpracticeexperiences/:pcmpracticeexperience?/editview/:editview?',
        meta: {
            caption: 'entities.pcmpracticeexperience.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmpracticeexperienceedit-view/pcmpracticeexperienceedit-view.vue'),
    },
    {
        path: '/pcmpracticeexperiences/:pcmpracticeexperience?/editview/:editview?',
        meta: {
            caption: 'entities.pcmpracticeexperience.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmpracticeexperienceedit-view/pcmpracticeexperienceedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/rzsp_csrcyjgridview/:rzsp_csrcyjgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.rzsp_csrcyjgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rzsp_csrcyjgridview', parameterName: 'rzsp_csrcyjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerzsp-csrcyjgrid-view/pcmprofilerzsp-csrcyjgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/rlsbgridview/:rlsbgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.rlsbgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rlsbgridview', parameterName: 'rlsbgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerlsbgrid-view/pcmprofilerlsbgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmschooloffices/:pcmschooloffice?/zxzwgridview/:zxzwgridview?',
        meta: {
            caption: 'entities.pcmschooloffice.views.zxzwgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                { pathName: 'zxzwgridview', parameterName: 'zxzwgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmschoolofficezxzwgrid-view/pcmschoolofficezxzwgrid-view.vue'),
    },
    {
        path: '/pcmschooloffices/:pcmschooloffice?/zxzwgridview/:zxzwgridview?',
        meta: {
            caption: 'entities.pcmschooloffice.views.zxzwgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                { pathName: 'zxzwgridview', parameterName: 'zxzwgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmschoolofficezxzwgrid-view/pcmschoolofficezxzwgrid-view.vue'),
    },
    {
        path: '/pcmxkmls/:pcmxkml?/xkmltreeexpview/:xkmltreeexpview?',
        meta: {
            caption: 'entities.pcmxkml.views.xkmltreeexpview.title',
            info:'',
            parameters: [
                { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                { pathName: 'xkmltreeexpview', parameterName: 'xkmltreeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmxkmlxkmltree-exp-view/pcmxkmlxkmltree-exp-view.vue'),
    },
    {
        path: '/pcmxkmls/:pcmxkml?/editview/:editview?',
        meta: {
            caption: 'entities.pcmxkml.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengmuluguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmxkmledit-view/pcmxkmledit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/editview/:editview?',
        meta: {
            caption: 'entities.pcmcertofreg.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmcertofregedit-view/pcmcertofregedit-view.vue'),
    },
    {
        path: '/pcmcertofregs/:pcmcertofreg?/editview/:editview?',
        meta: {
            caption: 'entities.pcmcertofreg.views.editview.title',
            info:'',
            parameters: [
                { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmcertofregedit-view/pcmcertofregedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmtestresults/:pcmtestresult?/editview/:editview?',
        meta: {
            caption: 'entities.pcmtestresult.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/test-result-edit-view/test-result-edit-view.vue'),
    },
    {
        path: '/pcmtestresults/:pcmtestresult?/editview/:editview?',
        meta: {
            caption: 'entities.pcmtestresult.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/test-result-edit-view/test-result-edit-view.vue'),
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
        component: () => import('@pages/orm/ormorgpickup-view/ormorgpickup-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/ypzbdeditview/:ypzbdeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.ypzbdeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/xinqianhetong.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'ypzbdeditview', parameterName: 'ypzbdeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileypzbdedit-view/pcmprofileypzbdedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/rlsb_csrcyjxgeditview/:rlsb_csrcyjxgeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.rlsb_csrcyjxgeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rlsb_csrcyjxgeditview', parameterName: 'rlsb_csrcyjxgeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerlsb-csrcyjxgedit-view/pcmprofilerlsb-csrcyjxgedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmawardswons/:pcmawardswons?/hjqk_wsswbjgridview/:hjqk_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmawardswons.views.hjqk_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                { pathName: 'hjqk_wsswbjgridview', parameterName: 'hjqk_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmawardswonshjqk-wsswbjgrid-view/pcmawardswonshjqk-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmawardswons/:pcmawardswons?/hjqk_wsswbjgridview/:hjqk_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmawardswons.views.hjqk_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                { pathName: 'hjqk_wsswbjgridview', parameterName: 'hjqk_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmawardswonshjqk-wsswbjgrid-view/pcmawardswonshjqk-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/fpwizardview/:fpwizardview?',
        meta: {
            caption: 'entities.pcmprofile.views.fpwizardview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'fpwizardview', parameterName: 'fpwizardview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilefpwizard-view/pcmprofilefpwizard-view.vue'),
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
        path: '/pcmprofiles/:pcmprofile?/pcmprofileapprovals/:pcmprofileapproval?/jjgridview/:jjgridview?',
        meta: {
            caption: 'entities.pcmprofileapproval.views.jjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmprofileapprovals', parameterName: 'pcmprofileapproval' },
                { pathName: 'jjgridview', parameterName: 'jjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileapprovaljjgrid-view/pcmprofileapprovaljjgrid-view.vue'),
    },
    {
        path: '/pcmprofileapprovals/:pcmprofileapproval?/jjgridview/:jjgridview?',
        meta: {
            caption: 'entities.pcmprofileapproval.views.jjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofileapprovals', parameterName: 'pcmprofileapproval' },
                { pathName: 'jjgridview', parameterName: 'jjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileapprovaljjgrid-view/pcmprofileapprovaljjgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/yrdwcs_csrcyjgridview/:yrdwcs_csrcyjgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.yrdwcs_csrcyjgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'yrdwcs_csrcyjgridview', parameterName: 'yrdwcs_csrcyjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileyrdwcs-csrcyjgrid-view/pcmprofileyrdwcs-csrcyjgrid-view.vue'),
    },
    {
        path: '/pcmxkmls/:pcmxkml?/pcmgxxktemps/:pcmgxxktemp?/gridview/:gridview?',
        meta: {
            caption: 'entities.pcmgxxktemp.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                { pathName: 'pcmgxxktemps', parameterName: 'pcmgxxktemp' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmgxxktempgrid-view/pcmgxxktempgrid-view.vue'),
    },
    {
        path: '/pcmgxmls/:pcmgxml?/pcmgxxktemps/:pcmgxxktemp?/gridview/:gridview?',
        meta: {
            caption: 'entities.pcmgxxktemp.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                { pathName: 'pcmgxxktemps', parameterName: 'pcmgxxktemp' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmgxxktempgrid-view/pcmgxxktempgrid-view.vue'),
    },
    {
        path: '/pcmgxxktemps/:pcmgxxktemp?/gridview/:gridview?',
        meta: {
            caption: 'entities.pcmgxxktemp.views.gridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmgxxktemps', parameterName: 'pcmgxxktemp' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmgxxktempgrid-view/pcmgxxktempgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/rzsp_csrcyjeditview/:rzsp_csrcyjeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.rzsp_csrcyjeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rzsp_csrcyjeditview', parameterName: 'rzsp_csrcyjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerzsp-csrcyjedit-view/pcmprofilerzsp-csrcyjedit-view.vue'),
    },
    {
        path: '/pcmgxmls/:pcmgxml?/gxmltreeexpview/:gxmltreeexpview?',
        meta: {
            caption: 'entities.pcmgxml.views.gxmltreeexpview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                { pathName: 'gxmltreeexpview', parameterName: 'gxmltreeexpview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmgxmlgxmltree-exp-view/pcmgxmlgxmltree-exp-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/rlsb_csrcyjeditview/:rlsb_csrcyjeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.rlsb_csrcyjeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rlsb_csrcyjeditview', parameterName: 'rlsb_csrcyjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerlsb-csrcyjedit-view/pcmprofilerlsb-csrcyjedit-view.vue'),
    },
    {
        path: '/pcmzpmegls/:pcmzpmegl?/curndgridview/:curndgridview?',
        meta: {
            caption: 'entities.pcmzpmegl.views.curndgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmzpmegls', parameterName: 'pcmzpmegl' },
                { pathName: 'curndgridview', parameterName: 'curndgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmzpmeglcur-ndgrid-view/pcmzpmeglcur-ndgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/zczs_wsswbjgridview/:zczs_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmcertofreg.views.zczs_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                { pathName: 'zczs_wsswbjgridview', parameterName: 'zczs_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmcertofregzczs-wsswbjgrid-view/pcmcertofregzczs-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmcertofregs/:pcmcertofreg?/zczs_wsswbjgridview/:zczs_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmcertofreg.views.zczs_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                { pathName: 'zczs_wsswbjgridview', parameterName: 'zczs_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmcertofregzczs-wsswbjgrid-view/pcmcertofregzczs-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/ypzxx_lreditview/:ypzxx_lreditview?',
        meta: {
            caption: 'entities.pcmprofile.views.ypzxx_lreditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'ypzxx_lreditview', parameterName: 'ypzxx_lreditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileypzxx-lredit-view/pcmprofileypzxx-lredit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/ypzxx_csrcyjeditview/:ypzxx_csrcyjeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.ypzxx_csrcyjeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'ypzxx_csrcyjeditview', parameterName: 'ypzxx_csrcyjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileypzxx-csrcyjedit-view/pcmprofileypzxx-csrcyjedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/bhspgridview/:bhspgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.bhspgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'bhspgridview', parameterName: 'bhspgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilebhspgrid-view/pcmprofilebhspgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/zczsgridview/:zczsgridview?',
        meta: {
            caption: 'entities.pcmcertofreg.views.zczsgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                { pathName: 'zczsgridview', parameterName: 'zczsgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmcertofregzczsgrid-view/pcmcertofregzczsgrid-view.vue'),
    },
    {
        path: '/pcmcertofregs/:pcmcertofreg?/zczsgridview/:zczsgridview?',
        meta: {
            caption: 'entities.pcmcertofreg.views.zczsgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhiyezige.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                { pathName: 'zczsgridview', parameterName: 'zczsgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmcertofregzczsgrid-view/pcmcertofregzczsgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/ypzbd_csrcyjeditview/:ypzbd_csrcyjeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.ypzbd_csrcyjeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/xinqianhetong.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'ypzbd_csrcyjeditview', parameterName: 'ypzbd_csrcyjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileypzbd-csrcyjedit-view/pcmprofileypzbd-csrcyjedit-view.vue'),
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
        path: '/pcmprofiles/:pcmprofile?/pcmtestresults/:pcmtestresult?/cpjg_wsswbjgridview/:cpjg_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmtestresult.views.cpjg_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                { pathName: 'cpjg_wsswbjgridview', parameterName: 'cpjg_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/test-result-cpjg-wsswbjgrid-view/test-result-cpjg-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmtestresults/:pcmtestresult?/cpjg_wsswbjgridview/:cpjg_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmtestresult.views.cpjg_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmtestresults', parameterName: 'pcmtestresult' },
                { pathName: 'cpjg_wsswbjgridview', parameterName: 'cpjg_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/test-result-cpjg-wsswbjgrid-view/test-result-cpjg-wsswbjgrid-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/txrypickupgridview/:txrypickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.txrypickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'txrypickupgridview', parameterName: 'txrypickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersontxrypickup-grid-view/pimpersontxrypickup-grid-view.vue'),
    },
    {
        path: '/pcmzpmegls/:pcmzpmegl?/editview/:editview?',
        meta: {
            caption: 'entities.pcmzpmegl.views.editview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmzpmegls', parameterName: 'pcmzpmegl' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmzpmegledit-view/pcmzpmegledit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmawardswons/:pcmawardswons?/hjqkgridview/:hjqkgridview?',
        meta: {
            caption: 'entities.pcmawardswons.views.hjqkgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                { pathName: 'hjqkgridview', parameterName: 'hjqkgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmawardswonshjqkgrid-view/pcmawardswonshjqkgrid-view.vue'),
    },
    {
        path: '/pcmawardswons/:pcmawardswons?/hjqkgridview/:hjqkgridview?',
        meta: {
            caption: 'entities.pcmawardswons.views.hjqkgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                { pathName: 'hjqkgridview', parameterName: 'hjqkgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmawardswonshjqkgrid-view/pcmawardswonshjqkgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmpracticeexperiences/:pcmpracticeexperience?/sxjygridview/:sxjygridview?',
        meta: {
            caption: 'entities.pcmpracticeexperience.views.sxjygridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                { pathName: 'sxjygridview', parameterName: 'sxjygridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmpracticeexperiencesxjygrid-view/pcmpracticeexperiencesxjygrid-view.vue'),
    },
    {
        path: '/pcmpracticeexperiences/:pcmpracticeexperience?/sxjygridview/:sxjygridview?',
        meta: {
            caption: 'entities.pcmpracticeexperience.views.sxjygridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                { pathName: 'sxjygridview', parameterName: 'sxjygridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmpracticeexperiencesxjygrid-view/pcmpracticeexperiencesxjygrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/qtzpwizardview/:qtzpwizardview?',
        meta: {
            caption: 'entities.pcmprofile.views.qtzpwizardview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'qtzpwizardview', parameterName: 'qtzpwizardview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileqtzpwizard-view/pcmprofileqtzpwizard-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/ypzbdgridview/:ypzbdgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.ypzbdgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/xinqianhetong.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'ypzbdgridview', parameterName: 'ypzbdgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileypzbdgrid-view/pcmprofileypzbdgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmeducationexperiences/:pcmeducationexperience?/jybjgridview/:jybjgridview?',
        meta: {
            caption: 'entities.pcmeducationexperience.views.jybjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                { pathName: 'jybjgridview', parameterName: 'jybjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmeducation-experience-jybjgrid-view/pcmeducation-experience-jybjgrid-view.vue'),
    },
    {
        path: '/pcmeducationexperiences/:pcmeducationexperience?/jybjgridview/:jybjgridview?',
        meta: {
            caption: 'entities.pcmeducationexperience.views.jybjgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/jiaoyuxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmeducationexperiences', parameterName: 'pcmeducationexperience' },
                { pathName: 'jybjgridview', parameterName: 'jybjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmeducation-experience-jybjgrid-view/pcmeducation-experience-jybjgrid-view.vue'),
    },
    {
        path: '/pcmgxmls/:pcmgxml?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pcmgxml.views.pickupgridview.title',
            info:'',
            parameters: [
                { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmgxmlpickup-grid-view/pcmgxmlpickup-grid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/szwizardview/:szwizardview?',
        meta: {
            caption: 'entities.pcmprofile.views.szwizardview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'szwizardview', parameterName: 'szwizardview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileszwizard-view/pcmprofileszwizard-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/bhspeditview/:bhspeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.bhspeditview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/hetongguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'bhspeditview', parameterName: 'bhspeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilebhspedit-view/pcmprofilebhspedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmpracticeexperiences/:pcmpracticeexperience?/sxjy_wsswbjgridview/:sxjy_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmpracticeexperience.views.sxjy_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                { pathName: 'sxjy_wsswbjgridview', parameterName: 'sxjy_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmpracticeexperiencesxjy-wsswbjgrid-view/pcmpracticeexperiencesxjy-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmpracticeexperiences/:pcmpracticeexperience?/sxjy_wsswbjgridview/:sxjy_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmpracticeexperience.views.sxjy_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/zuzhiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmpracticeexperiences', parameterName: 'pcmpracticeexperience' },
                { pathName: 'sxjy_wsswbjgridview', parameterName: 'sxjy_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmpracticeexperiencesxjy-wsswbjgrid-view/pcmpracticeexperiencesxjy-wsswbjgrid-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ypzsyfpxxpickupview/:ypzsyfpxxpickupview?',
        meta: {
            caption: 'entities.ormorg.views.ypzsyfpxxpickupview.title',
            info:'',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ypzsyfpxxpickupview', parameterName: 'ypzsyfpxxpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgypzsyfpxxpickup-view/ormorgypzsyfpxxpickup-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmtdzwxxes/:pcmtdzwxx?/tdzw_wsswbjgridview/:tdzw_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmtdzwxx.views.tdzw_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                { pathName: 'tdzw_wsswbjgridview', parameterName: 'tdzw_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/tdzwxxtdzw-wsswbjgrid-view/tdzwxxtdzw-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmtdzwxxes/:pcmtdzwxx?/tdzw_wsswbjgridview/:tdzw_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmtdzwxx.views.tdzw_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                { pathName: 'tdzw_wsswbjgridview', parameterName: 'tdzw_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/tdzwxxtdzw-wsswbjgrid-view/tdzwxxtdzw-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmawardswons/:pcmawardswons?/editview/:editview?',
        meta: {
            caption: 'entities.pcmawardswons.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmawardswonsedit-view/pcmawardswonsedit-view.vue'),
    },
    {
        path: '/pcmawardswons/:pcmawardswons?/editview/:editview?',
        meta: {
            caption: 'entities.pcmawardswons.views.editview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenbianzhi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmawardswons', parameterName: 'pcmawardswons' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmawardswonsedit-view/pcmawardswonsedit-view.vue'),
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
        component: () => import('@pages/orm/ormorgpickup-grid-view/ormorgpickup-grid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/yrdwcs_csrcyjeditview/:yrdwcs_csrcyjeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.yrdwcs_csrcyjeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'yrdwcs_csrcyjeditview', parameterName: 'yrdwcs_csrcyjeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileyrdwcs-csrcyjedit-view/pcmprofileyrdwcs-csrcyjedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/rlsbeditview/:rlsbeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.rlsbeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/yleiyuangongzhuanzheng.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rlsbeditview', parameterName: 'rlsbeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerlsbedit-view/pcmprofilerlsbedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/zpdwsheditview/:zpdwsheditview?',
        meta: {
            caption: 'entities.pcmprofile.views.zpdwsheditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'zpdwsheditview', parameterName: 'zpdwsheditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilezpdwshedit-view/pcmprofilezpdwshedit-view.vue'),
    },
    {
        path: '/pcmprofilespyys/:pcmprofilespyy?/editview/:editview?',
        meta: {
            caption: 'entities.pcmprofilespyy.views.editview.title',
            info:'',
            imgPath: '../../../img/kfgl/1/peixunjiluguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofilespyys', parameterName: 'pcmprofilespyy' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilespyyedit-view/pcmprofilespyyedit-view.vue'),
    },
    {
        path: '/pcmgxmls/:pcmgxml?/editview/:editview?',
        meta: {
            caption: 'entities.pcmgxml.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/danganxinxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmgxmledit-view/pcmgxmledit-view.vue'),
    },
    {
        path: '/pcmxkmls/:pcmxkml?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.pcmxkml.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmxkmlmpickup-view/pcmxkmlmpickup-view.vue'),
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
        component: () => import('@pages/orm/ormorgsectorydbmpickup-grid-view/ormorgsectorydbmpickup-grid-view.vue'),
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
        component: () => import('@pages/orm/ormorgsectorydbmpickup-grid-view/ormorgsectorydbmpickup-grid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmworkresumes/:pcmworkresume?/editview/:editview?',
        meta: {
            caption: 'entities.pcmworkresume.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmworkresumeedit-view/pcmworkresumeedit-view.vue'),
    },
    {
        path: '/pcmworkresumes/:pcmworkresume?/editview/:editview?',
        meta: {
            caption: 'entities.pcmworkresume.views.editview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/gongzuolvli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmworkresumes', parameterName: 'pcmworkresume' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmworkresumeedit-view/pcmworkresumeedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/rzspeditview/:rzspeditview?',
        meta: {
            caption: 'entities.pcmprofile.views.rzspeditview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rzspeditview', parameterName: 'rzspeditview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerzspedit-view/pcmprofilerzspedit-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/ypzxx_csrcyjgridview/:ypzxx_csrcyjgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.ypzxx_csrcyjgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/chengshurencaizhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'ypzxx_csrcyjgridview', parameterName: 'ypzxx_csrcyjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofileypzxx-csrcyjgrid-view/pcmprofileypzxx-csrcyjgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/zpdwshgridview/:zpdwshgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.zpdwshgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/xiaoyuanzhaopin.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'zpdwshgridview', parameterName: 'zpdwshgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilezpdwshgrid-view/pcmprofilezpdwshgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmschooloffices/:pcmschooloffice?/zxzw_wsswbjgridview/:zxzw_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmschooloffice.views.zxzw_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                { pathName: 'zxzw_wsswbjgridview', parameterName: 'zxzw_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmschoolofficezxzw-wsswbjgrid-view/pcmschoolofficezxzw-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmschooloffices/:pcmschooloffice?/zxzw_wsswbjgridview/:zxzw_wsswbjgridview?',
        meta: {
            caption: 'entities.pcmschooloffice.views.zxzw_wsswbjgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/bumenguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmschooloffices', parameterName: 'pcmschooloffice' },
                { pathName: 'zxzw_wsswbjgridview', parameterName: 'zxzw_wsswbjgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmschoolofficezxzw-wsswbjgrid-view/pcmschoolofficezxzw-wsswbjgrid-view.vue'),
    },
    {
        path: '/pcmxkmls/:pcmxkml?/curndgridview/:curndgridview?',
        meta: {
            caption: 'entities.pcmxkml.views.curndgridview.title',
            info:'',
            imgPath: '../../../img/jcgl/1/zhichengmuluguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmxkmls', parameterName: 'pcmxkml' },
                { pathName: 'curndgridview', parameterName: 'curndgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmxkmlcur-ndgrid-view/pcmxkmlcur-ndgrid-view.vue'),
    },
    {
        path: '/pcmgxmls/:pcmgxml?/mpickupview/:mpickupview?',
        meta: {
            caption: 'entities.pcmgxml.views.mpickupview.title',
            info:'',
            parameters: [
                { pathName: 'pcmgxmls', parameterName: 'pcmgxml' },
                { pathName: 'mpickupview', parameterName: 'mpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmgxmlmpickup-view/pcmgxmlmpickup-view.vue'),
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
        path: '/pcmprofiles/:pcmprofile?/rzspgridview/:rzspgridview?',
        meta: {
            caption: 'entities.pcmprofile.views.rzspgridview.title',
            info:'',
            imgPath: '../../../img/pzgl/1/zhijizhiwuguanxi.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'rzspgridview', parameterName: 'rzspgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmprofilerzspgrid-view/pcmprofilerzspgrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmtdzwxxes/:pcmtdzwxx?/tdzwgridview/:tdzwgridview?',
        meta: {
            caption: 'entities.pcmtdzwxx.views.tdzwgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                { pathName: 'tdzwgridview', parameterName: 'tdzwgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/tdzwxxtdzwgrid-view/tdzwxxtdzwgrid-view.vue'),
    },
    {
        path: '/pcmtdzwxxes/:pcmtdzwxx?/tdzwgridview/:tdzwgridview?',
        meta: {
            caption: 'entities.pcmtdzwxx.views.tdzwgridview.title',
            info:'',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmtdzwxxes', parameterName: 'pcmtdzwxx' },
                { pathName: 'tdzwgridview', parameterName: 'tdzwgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/tdzwxxtdzwgrid-view/tdzwxxtdzwgrid-view.vue'),
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
        component: () => import('@pages/orm/ormorgsectorydbmpickup-view/ormorgsectorydbmpickup-view.vue'),
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
        component: () => import('@pages/orm/ormorgsectorydbmpickup-view/ormorgsectorydbmpickup-view.vue'),
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
