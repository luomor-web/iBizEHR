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
                    path: 'ormorgs/:ormorg?/ypzxxsypickupgridview/:ypzxxsypickupgridview?',
                    meta: {
                        caption: 'entities.ormorg.views.ypzxxsypickupgridview.caption',
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
                    component: () => import('@pages/orm/ormdutyorm-org-sector-pickup-grid-view/ormdutyorm-org-sector-pickup-grid-view.vue'),
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
                    component: () => import('@pages/orm/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
                },
                {
                    path: 'pimqualmajors/:pimqualmajor?/pickupview/:pickupview?',
                    meta: {
                        caption: 'entities.pimqualmajor.views.pickupview.caption',
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
                    path: 'pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/zczsgridview/:zczsgridview?',
                    meta: {
                        caption: 'entities.pcmcertofreg.views.zczsgridview.caption',
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
                        caption: 'entities.pcmcertofreg.views.zczsgridview.caption',
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
                    path: 'pcmprofiles/:pcmprofile?/pcmawardswons/:pcmawardswons?/hjqkgridview/:hjqkgridview?',
                    meta: {
                        caption: 'entities.pcmawardswons.views.hjqkgridview.caption',
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
                        caption: 'entities.pcmawardswons.views.hjqkgridview.caption',
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
                    component: () => import('@pages/orm/ormdutyorm-org-sector-pickup-view/ormdutyorm-org-sector-pickup-view.vue'),
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
                    component: () => import('@pages/orm/ormorgsectorydbmpickup-grid-view/ormorgsectorydbmpickup-grid-view.vue'),
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
                    component: () => import('@pages/orm/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmschooloffices/:pcmschooloffice?/zxzwgridview/:zxzwgridview?',
                    meta: {
                        caption: 'entities.pcmschooloffice.views.zxzwgridview.caption',
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
                        caption: 'entities.pcmschooloffice.views.zxzwgridview.caption',
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
                        caption: 'entities.pcmprofile.views.ypzxx_lreditview.caption',
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
                    path: 'pcmprofiles/:pcmprofile?/xzwizardview/:xzwizardview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.xzwizardview.caption',
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
                    path: 'ormorgs/:ormorg?/ypzsyfpxxpickupview/:ypzsyfpxxpickupview?',
                    meta: {
                        caption: 'entities.ormorg.views.ypzsyfpxxpickupview.caption',
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
                    path: 'pimpeople/:pimperson?/txrypickupgridview/:txrypickupgridview?',
                    meta: {
                        caption: 'entities.pimperson.views.txrypickupgridview.caption',
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
                    component: () => import('@pages/orm/ormorgsectorydbmpickup-view/ormorgsectorydbmpickup-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmpracticeexperiences/:pcmpracticeexperience?/sxjygridview/:sxjygridview?',
                    meta: {
                        caption: 'entities.pcmpracticeexperience.views.sxjygridview.caption',
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
                        caption: 'entities.pcmpracticeexperience.views.sxjygridview.caption',
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
                    path: 'pcmprofiles/:pcmprofile?/testresults/:testresult?/cpjggridview/:cpjggridview?',
                    meta: {
                        caption: 'entities.testresult.views.cpjggridview.caption',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'testresults', parameterName: 'testresult' },
                            { pathName: 'cpjggridview', parameterName: 'cpjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/test-result-cpjggrid-view/test-result-cpjggrid-view.vue'),
                },
                {
                    path: 'testresults/:testresult?/cpjggridview/:cpjggridview?',
                    meta: {
                        caption: 'entities.testresult.views.cpjggridview.caption',
                        imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'testresults', parameterName: 'testresult' },
                            { pathName: 'cpjggridview', parameterName: 'cpjggridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/test-result-cpjggrid-view/test-result-cpjggrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/editview/:editview?',
                    meta: {
                        caption: 'entities.pcmcertofreg.views.editview.caption',
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
                        caption: 'entities.pcmcertofreg.views.editview.caption',
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
                    path: 'pimpeople/:pimperson?/txrypickupview/:txrypickupview?',
                    meta: {
                        caption: 'entities.pimperson.views.txrypickupview.caption',
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
                    path: 'pcmprofiles/:pcmprofile?/ypzxx_lrgridview/:ypzxx_lrgridview?',
                    meta: {
                        caption: 'entities.pcmprofile.views.ypzxx_lrgridview.caption',
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
                        caption: 'entities.pimqualmajor.views.pickupgridview.caption',
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
                    path: 'pcmprofiles/:pcmprofile?/pcmeducationexperiences/:pcmeducationexperience?/jybjgridview/:jybjgridview?',
                    meta: {
                        caption: 'entities.pcmeducationexperience.views.jybjgridview.caption',
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
                        caption: 'entities.pcmeducationexperience.views.jybjgridview.caption',
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
                    path: 'pcmprofiles/:pcmprofile?/tdzwxxes/:tdzwxx?/tdzwgridview/:tdzwgridview?',
                    meta: {
                        caption: 'entities.tdzwxx.views.tdzwgridview.caption',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                            { pathName: 'tdzwxxes', parameterName: 'tdzwxx' },
                            { pathName: 'tdzwgridview', parameterName: 'tdzwgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/tdzwxxtdzwgrid-view/tdzwxxtdzwgrid-view.vue'),
                },
                {
                    path: 'tdzwxxes/:tdzwxx?/tdzwgridview/:tdzwgridview?',
                    meta: {
                        caption: 'entities.tdzwxx.views.tdzwgridview.caption',
                        imgPath: '../../../img/zzgl/1/gangweiguanli.png',
                        iconCls: '',
                        parameters: [
                            { pathName: 'index', parameterName: 'index' },
                            { pathName: 'tdzwxxes', parameterName: 'tdzwxx' },
                            { pathName: 'tdzwgridview', parameterName: 'tdzwgridview' },
                        ],
                        requireAuth: true,
                    },
                    component: () => import('@pages/pcm/tdzwxxtdzwgrid-view/tdzwxxtdzwgrid-view.vue'),
                },
                {
                    path: 'pcmprofiles/:pcmprofile?/pcmworkresumes/:pcmworkresume?/gzllgridview/:gzllgridview?',
                    meta: {
                        caption: 'entities.pcmworkresume.views.gzllgridview.caption',
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
                        caption: 'entities.pcmworkresume.views.gzllgridview.caption',
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
            ...indexRoutes,
            ],
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
        component: () => import('@pages/orm/ormpostejormorgidpickup-view/ormpostejormorgidpickup-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmworkresumes/:pcmworkresume?/gzllgridview/:gzllgridview?',
        meta: {
            caption: 'entities.pcmworkresume.views.gzllgridview.caption',
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
            caption: 'entities.pcmworkresume.views.gzllgridview.caption',
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
            caption: 'entities.pimperson.views.txrypickupview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'txrypickupview', parameterName: 'txrypickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersontxrypickup-view/pimpersontxrypickup-view.vue'),
    },
    {
        path: '/ormorgs/:ormorg?/ypzxxsypickupgridview/:ypzxxsypickupgridview?',
        meta: {
            caption: 'entities.ormorg.views.ypzxxsypickupgridview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ypzxxsypickupgridview', parameterName: 'ypzxxsypickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgypzxxsypickup-grid-view/ormorgypzxxsypickup-grid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/testresults/:testresult?/cpjggridview/:cpjggridview?',
        meta: {
            caption: 'entities.testresult.views.cpjggridview.caption',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'testresults', parameterName: 'testresult' },
                { pathName: 'cpjggridview', parameterName: 'cpjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/test-result-cpjggrid-view/test-result-cpjggrid-view.vue'),
    },
    {
        path: '/testresults/:testresult?/cpjggridview/:cpjggridview?',
        meta: {
            caption: 'entities.testresult.views.cpjggridview.caption',
            imgPath: '../../../img/zzgl/1/zhiwuguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'testresults', parameterName: 'testresult' },
                { pathName: 'cpjggridview', parameterName: 'cpjggridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/test-result-cpjggrid-view/test-result-cpjggrid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/xzwizardview/:xzwizardview?',
        meta: {
            caption: 'entities.pcmprofile.views.xzwizardview.caption',
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
            caption: 'entities.pcmprofile.views.ypzxx_lrgridview.caption',
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
        path: '/ormposts/:ormpost?/ejormorgidpickupgridview/:ejormorgidpickupgridview?',
        meta: {
            caption: 'entities.ormpost.views.ejormorgidpickupgridview.caption',
            parameters: [
                { pathName: 'ormposts', parameterName: 'ormpost' },
                { pathName: 'ejormorgidpickupgridview', parameterName: 'ejormorgidpickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormpostejormorgidpickup-grid-view/ormpostejormorgidpickup-grid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmschooloffices/:pcmschooloffice?/zxzwgridview/:zxzwgridview?',
        meta: {
            caption: 'entities.pcmschooloffice.views.zxzwgridview.caption',
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
            caption: 'entities.pcmschooloffice.views.zxzwgridview.caption',
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
        path: '/pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/editview/:editview?',
        meta: {
            caption: 'entities.pcmcertofreg.views.editview.caption',
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
            caption: 'entities.pcmcertofreg.views.editview.caption',
            parameters: [
                { pathName: 'pcmcertofregs', parameterName: 'pcmcertofreg' },
                { pathName: 'editview', parameterName: 'editview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/pcmcertofregedit-view/pcmcertofregedit-view.vue'),
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
        component: () => import('@pages/orm/ormdutyorm-org-sector-pickup-grid-view/ormdutyorm-org-sector-pickup-grid-view.vue'),
    },
    {
        path: '/pimqualmajors/:pimqualmajor?/pickupview/:pickupview?',
        meta: {
            caption: 'entities.pimqualmajor.views.pickupview.caption',
            parameters: [
                { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                { pathName: 'pickupview', parameterName: 'pickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualmajorpickup-view/pimqualmajorpickup-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/ypzxx_lreditview/:ypzxx_lreditview?',
        meta: {
            caption: 'entities.pcmprofile.views.ypzxx_lreditview.caption',
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
        path: '/pcmprofiles/:pcmprofile?/pcmcertofregs/:pcmcertofreg?/zczsgridview/:zczsgridview?',
        meta: {
            caption: 'entities.pcmcertofreg.views.zczsgridview.caption',
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
            caption: 'entities.pcmcertofreg.views.zczsgridview.caption',
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
        path: '/ormduties/:ormduty?/ormorgsectorpickupview/:ormorgsectorpickupview?',
        meta: {
            caption: 'entities.ormduty.views.ormorgsectorpickupview.caption',
            parameters: [
                { pathName: 'ormduties', parameterName: 'ormduty' },
                { pathName: 'ormorgsectorpickupview', parameterName: 'ormorgsectorpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormdutyorm-org-sector-pickup-view/ormdutyorm-org-sector-pickup-view.vue'),
    },
    {
        path: '/pimpeople/:pimperson?/txrypickupgridview/:txrypickupgridview?',
        meta: {
            caption: 'entities.pimperson.views.txrypickupgridview.caption',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'txrypickupgridview', parameterName: 'txrypickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimpersontxrypickup-grid-view/pimpersontxrypickup-grid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/pcmawardswons/:pcmawardswons?/hjqkgridview/:hjqkgridview?',
        meta: {
            caption: 'entities.pcmawardswons.views.hjqkgridview.caption',
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
            caption: 'entities.pcmawardswons.views.hjqkgridview.caption',
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
            caption: 'entities.pcmpracticeexperience.views.sxjygridview.caption',
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
            caption: 'entities.pcmpracticeexperience.views.sxjygridview.caption',
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
        path: '/pcmprofiles/:pcmprofile?/pcmeducationexperiences/:pcmeducationexperience?/jybjgridview/:jybjgridview?',
        meta: {
            caption: 'entities.pcmeducationexperience.views.jybjgridview.caption',
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
            caption: 'entities.pcmeducationexperience.views.jybjgridview.caption',
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
        path: '/ormorgs/:ormorg?/ypzsyfpxxpickupview/:ypzsyfpxxpickupview?',
        meta: {
            caption: 'entities.ormorg.views.ypzsyfpxxpickupview.caption',
            parameters: [
                { pathName: 'ormorgs', parameterName: 'ormorg' },
                { pathName: 'ypzsyfpxxpickupview', parameterName: 'ypzsyfpxxpickupview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/orm/ormorgypzsyfpxxpickup-view/ormorgypzsyfpxxpickup-view.vue'),
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
        component: () => import('@pages/orm/ormorgsectorydbmpickup-grid-view/ormorgsectorydbmpickup-grid-view.vue'),
    },
    {
        path: '/pimqualmajors/:pimqualmajor?/pickupgridview/:pickupgridview?',
        meta: {
            caption: 'entities.pimqualmajor.views.pickupgridview.caption',
            parameters: [
                { pathName: 'pimqualmajors', parameterName: 'pimqualmajor' },
                { pathName: 'pickupgridview', parameterName: 'pickupgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pim/pimqualmajorpickup-grid-view/pimqualmajorpickup-grid-view.vue'),
    },
    {
        path: '/pcmprofiles/:pcmprofile?/tdzwxxes/:tdzwxx?/tdzwgridview/:tdzwgridview?',
        meta: {
            caption: 'entities.tdzwxx.views.tdzwgridview.caption',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'pcmprofiles', parameterName: 'pcmprofile' },
                { pathName: 'tdzwxxes', parameterName: 'tdzwxx' },
                { pathName: 'tdzwgridview', parameterName: 'tdzwgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/tdzwxxtdzwgrid-view/tdzwxxtdzwgrid-view.vue'),
    },
    {
        path: '/tdzwxxes/:tdzwxx?/tdzwgridview/:tdzwgridview?',
        meta: {
            caption: 'entities.tdzwxx.views.tdzwgridview.caption',
            imgPath: '../../../img/zzgl/1/gangweiguanli.png',
            iconCls: '',
            parameters: [
                { pathName: 'tdzwxxes', parameterName: 'tdzwxx' },
                { pathName: 'tdzwgridview', parameterName: 'tdzwgridview' },
            ],
            requireAuth: true,
        },
        component: () => import('@pages/pcm/tdzwxxtdzwgrid-view/tdzwxxtdzwgrid-view.vue'),
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
