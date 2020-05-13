
<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGOrgBarBase from './org-bar-portlet-base.vue';
import view_db_sysportlet1_chart from '@widgets/ormorg/org-bar-chart/org-bar-chart.vue';

 
@Component({
    components: {
        view_db_sysportlet1_chart, 
         
    }
})
export default class ORMORGOrgBar extends ORMORGOrgBarBase {

}
</script>