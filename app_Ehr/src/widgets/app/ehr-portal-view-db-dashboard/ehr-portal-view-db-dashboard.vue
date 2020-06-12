<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import EhrPortalView_dbBase from './ehr-portal-view-db-dashboard-base.vue';
import view_db_sysportlet5 from '@widgets/pim-title/org-title-bar-portlet/org-title-bar-portlet.vue';
import view_db_sysportlet4 from '@widgets/pim-person/org-person-age-funnel-portlet/org-person-age-funnel-portlet.vue';
import view_db_sysportlet3 from '@widgets/pim-education/org-edu-pie-portlet/org-edu-pie-portlet.vue';
import view_db_sysportlet2 from '@widgets/pim-output/org-out-put-line-portlet/org-out-put-line-portlet.vue';
import view_db_sysportlet1 from '@widgets/orm-org/org-bar-portlet/org-bar-portlet.vue';

 
@Component({
    components: {
        view_db_sysportlet5, 
        view_db_sysportlet4, 
        view_db_sysportlet3, 
        view_db_sysportlet2, 
        view_db_sysportlet1, 
         
    }
})
export default class EhrPortalView_db extends EhrPortalView_dbBase {

}
</script> 