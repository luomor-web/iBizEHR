
<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimTitleOrgTitleBarBase from './org-title-bar-portlet-base.vue';
import view_db_sysportlet5_chart from '@widgets/pim-title/org-title-bar-chart/org-title-bar-chart.vue';

 
@Component({
    components: {
        view_db_sysportlet5_chart, 
         
    }
})
export default class PimTitleOrgTitleBar extends PimTitleOrgTitleBarBase {

}
</script>
