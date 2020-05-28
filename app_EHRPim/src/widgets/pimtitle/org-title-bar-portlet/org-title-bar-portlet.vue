
<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLEOrgTitleBarBase from './org-title-bar-portlet-base.vue';
import view_db_sysportlet5_chart from '@widgets/pimtitle/org-title-bar-chart/org-title-bar-chart.vue';

 
@Component({
    components: {
        view_db_sysportlet5_chart, 
         
    }
})
export default class PIMTITLEOrgTitleBar extends PIMTITLEOrgTitleBarBase {

}
</script>