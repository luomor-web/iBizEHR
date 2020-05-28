import PIMEDUCATIONOrgEduPie from '@/widgets/pimeducation/org-edu-pie-portlet/org-edu-pie-portlet.vue';
import PIMTITLEOrgTitleBar from '@/widgets/pimtitle/org-title-bar-portlet/org-title-bar-portlet.vue';
import OrmOrgOrmPNumList from '@/widgets/orm-org/orm-pnum-list-portlet/orm-pnum-list-portlet.vue';
import OrmOrgOrgBar from '@/widgets/orm-org/org-bar-portlet/org-bar-portlet.vue';
import PIMVOCATIONALOrgVocNumList from '@/widgets/pimvocational/org-voc-num-list-portlet/org-voc-num-list-portlet.vue';
import PIMOUTPUTOrgOutPutLine from '@/widgets/pimoutput/org-out-put-line-portlet/org-out-put-line-portlet.vue';
import PIMPERSONOrgPersonAgeFunnel from '@/widgets/pimperson/org-person-age-funnel-portlet/org-person-age-funnel-portlet.vue';
import PIMPERSONOrgPersonOrgTypePie from '@/widgets/pimperson/org-person-org-type-pie-portlet/org-person-org-type-pie-portlet.vue';

export const  PortletComponent = {
    install(v: any, opt: any) {
        v.component('app-pimeducation-org-edu-pie-portlet', PIMEDUCATIONOrgEduPie);
        v.component('app-pimperson-org-person-age-funnel-portlet', PIMPERSONOrgPersonAgeFunnel);
        v.component('app-pimoutput-org-out-put-line-portlet', PIMOUTPUTOrgOutPutLine);
        v.component('app-pimperson-org-person-org-type-pie-portlet', PIMPERSONOrgPersonOrgTypePie);
        v.component('app-orm-org-orm-pnum-list-portlet', OrmOrgOrmPNumList);
        v.component('app-orm-org-org-bar-portlet', OrmOrgOrgBar);
        v.component('app-pimvocational-org-voc-num-list-portlet', PIMVOCATIONALOrgVocNumList);
        v.component('app-pimtitle-org-title-bar-portlet', PIMTITLEOrgTitleBar);
        v.component('orm-org-orm-pnum-list-portlet', OrmOrgOrmPNumList);
        v.component('orm-org-org-bar-portlet', OrmOrgOrgBar);
        v.component('pimvocational-org-voc-num-list-portlet', PIMVOCATIONALOrgVocNumList);
        v.component('pimoutput-org-out-put-line-portlet', PIMOUTPUTOrgOutPutLine);
        v.component('pimperson-org-person-age-funnel-portlet', PIMPERSONOrgPersonAgeFunnel);
        v.component('pimperson-org-person-org-type-pie-portlet', PIMPERSONOrgPersonOrgTypePie);
    }
};