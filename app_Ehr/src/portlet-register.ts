import OrgEduPie from '@/widgets/app/org-edu-pie-portlet/org-edu-pie-portlet.vue';
import OrgPersonAgeFunnel from '@/widgets/app/org-person-age-funnel-portlet/org-person-age-funnel-portlet.vue';
import OrgOutPutLine from '@/widgets/app/org-out-put-line-portlet/org-out-put-line-portlet.vue';
import OrgPersonOrgTypePie from '@/widgets/app/org-person-org-type-pie-portlet/org-person-org-type-pie-portlet.vue';
import OrmPNumList from '@/widgets/app/orm-pnum-list-portlet/orm-pnum-list-portlet.vue';
import OrgBar from '@/widgets/app/org-bar-portlet/org-bar-portlet.vue';
import OrgVocNumList from '@/widgets/app/org-voc-num-list-portlet/org-voc-num-list-portlet.vue';
import OrgTitleBar from '@/widgets/app/org-title-bar-portlet/org-title-bar-portlet.vue';

export const  PortletComponent = {
    install(v: any, opt: any) {
        v.component('app-org-edu-pie-portlet', OrgEduPie);
        v.component('app-org-person-age-funnel-portlet', OrgPersonAgeFunnel);
        v.component('app-org-out-put-line-portlet', OrgOutPutLine);
        v.component('app-org-person-org-type-pie-portlet', OrgPersonOrgTypePie);
        v.component('app-orm-pnum-list-portlet', OrmPNumList);
        v.component('app-org-bar-portlet', OrgBar);
        v.component('app-org-voc-num-list-portlet', OrgVocNumList);
        v.component('app-org-title-bar-portlet', OrgTitleBar);
    }
};