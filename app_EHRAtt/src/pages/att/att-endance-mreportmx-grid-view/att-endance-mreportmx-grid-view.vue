<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceMreportmxGridViewBase from './att-endance-mreportmx-grid-view-base.vue';

import view_grid from '@widgets/att-endance-mreportmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/att-endance-mreportmx/default-searchform/default-searchform.vue';

/**
 * 考勤月报明细
 *
 * @export
 * @class AttEndanceMreportmxGridView
 * @extends {AttEndanceMreportmxGridViewBase}
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
export default class AttEndanceMreportmxGridView extends AttEndanceMreportmxGridViewBase { }
</script>