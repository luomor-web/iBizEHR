import PimEducationOrgEduPie from '@/widgets/pim-education/org-edu-pie-portlet/org-edu-pie-portlet.vue';
import PIMTITLEOrgTitleBar from '@/widgets/pimtitle/org-title-bar-portlet/org-title-bar-portlet.vue';
import OrmOrgOrmPNumList from '@/widgets/orm-org/orm-pnum-list-portlet/orm-pnum-list-portlet.vue';
import OrmOrgOrgBar from '@/widgets/orm-org/org-bar-portlet/org-bar-portlet.vue';
import PIMVOCATIONALOrgVocNumList from '@/widgets/pimvocational/org-voc-num-list-portlet/org-voc-num-list-portlet.vue';
import PimOutputOrgOutPutLine from '@/widgets/pim-output/org-out-put-line-portlet/org-out-put-line-portlet.vue';
import PimPersonOrgPersonAgeFunnel from '@/widgets/pim-person/org-person-age-funnel-portlet/org-person-age-funnel-portlet.vue';
import PimPersonOrgPersonOrgTypePie from '@/widgets/pim-person/org-person-org-type-pie-portlet/org-person-org-type-pie-portlet.vue';

export const  PortletComponent = {
    install(v: any, opt: any) {
        v.component('app-pim-education-org-edu-pie-portlet', PimEducationOrgEduPie);
        v.component('app-pim-person-org-person-age-funnel-portlet', PimPersonOrgPersonAgeFunnel);
        v.component('app-pim-output-org-out-put-line-portlet', PimOutputOrgOutPutLine);
        v.component('app-pim-person-org-person-org-type-pie-portlet', PimPersonOrgPersonOrgTypePie);
        v.component('app-orm-org-orm-pnum-list-portlet', OrmOrgOrmPNumList);
        v.component('app-orm-org-org-bar-portlet', OrmOrgOrgBar);
        v.component('app-pimvocational-org-voc-num-list-portlet', PIMVOCATIONALOrgVocNumList);
        v.component('app-pimtitle-org-title-bar-portlet', PIMTITLEOrgTitleBar);
        v.component('orm-org-orm-pnum-list-portlet', OrmOrgOrmPNumList);
        v.component('orm-org-org-bar-portlet', OrmOrgOrgBar);
        v.component('pimvocational-org-voc-num-list-portlet', PIMVOCATIONALOrgVocNumList);
        v.component('pim-output-org-out-put-line-portlet', PimOutputOrgOutPutLine);
        v.component('pim-person-org-person-age-funnel-portlet', PimPersonOrgPersonAgeFunnel);
        v.component('pim-person-org-person-org-type-pie-portlet', PimPersonOrgPersonOrgTypePie);
    }
};