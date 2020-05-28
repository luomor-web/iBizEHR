
<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMOUTPUTOrgOutPutLineBase from './org-out-put-line-portlet-base.vue';
import view_db_sysportlet2_chart from '@widgets/pimoutput/org-out-put-line-chart/org-out-put-line-chart.vue';

 
@Component({
    components: {
        view_db_sysportlet2_chart, 
         
    }
})
export default class PIMOUTPUTOrgOutPutLine extends PIMOUTPUTOrgOutPutLineBase {

}
</script>