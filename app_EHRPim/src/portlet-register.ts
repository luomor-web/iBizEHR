import PIMEDUCATIONOrgEduPie from '@/widgets/pimeducation/org-edu-pie-portlet/org-edu-pie-portlet.vue';
import PIMTITLEOrgTitleBar from '@/widgets/pimtitle/org-title-bar-portlet/org-title-bar-portlet.vue';
import ORMORGOrmPNumList from '@/widgets/ormorg/orm-pnum-list-portlet/orm-pnum-list-portlet.vue';
import ORMORGOrgBar from '@/widgets/ormorg/org-bar-portlet/org-bar-portlet.vue';
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
        v.component('app-ormorg-orm-pnum-list-portlet', ORMORGOrmPNumList);
        v.component('app-ormorg-org-bar-portlet', ORMORGOrgBar);
        v.component('app-pimvocational-org-voc-num-list-portlet', PIMVOCATIONALOrgVocNumList);
        v.component('app-pimtitle-org-title-bar-portlet', PIMTITLEOrgTitleBar);
        v.component('ormorg-orm-pnum-list-portlet', ORMORGOrmPNumList);
        v.component('ormorg-org-bar-portlet', ORMORGOrgBar);
        v.component('pimvocational-org-voc-num-list-portlet', PIMVOCATIONALOrgVocNumList);
        v.component('pimoutput-org-out-put-line-portlet', PIMOUTPUTOrgOutPutLine);
        v.component('pimperson-org-person-age-funnel-portlet', PIMPERSONOrgPersonAgeFunnel);
        v.component('pimperson-org-person-org-type-pie-portlet', PIMPERSONOrgPersonOrgTypePie);
    }
};