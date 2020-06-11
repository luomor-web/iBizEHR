
<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimOutputOrgOutPutLineBase from './org-out-put-line-portlet-base.vue';
import view_db_sysportlet2_chart from '@widgets/pim-output/org-out-put-line-chart/org-out-put-line-chart.vue';

 
@Component({
    components: {
        view_db_sysportlet2_chart, 
         
    }
})
export default class PimOutputOrgOutPutLine extends PimOutputOrgOutPutLineBase {

}
</script>
