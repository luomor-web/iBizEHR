<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceMreportGridViewBase from './att-endance-mreport-grid-view-base.vue';

import view_grid from '@widgets/att-endance-mreport/main-grid/main-grid.vue';
import view_searchform from '@widgets/att-endance-mreport/default-searchform/default-searchform.vue';

/**
 * 考勤月报
 *
 * @export
 * @class AttEndanceMreportGridView
 * @extends {AttEndanceMreportGridViewBase}
 */
@Component({
    components: {
        view_grid, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class AttEndanceMreportGridView extends AttEndanceMreportGridViewBase { }
</script>