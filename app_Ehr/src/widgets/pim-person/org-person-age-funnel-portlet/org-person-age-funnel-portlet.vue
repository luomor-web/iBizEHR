
<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonOrgPersonAgeFunnelBase from './org-person-age-funnel-portlet-base.vue';
import view_db_sysportlet4_chart from '@widgets/pim-person/org-person-age-chart/org-person-age-chart.vue';

 
@Component({
    components: {
        view_db_sysportlet4_chart, 
         
    }
})
export default class PimPersonOrgPersonAgeFunnel extends PimPersonOrgPersonAgeFunnelBase {

}
</script>
