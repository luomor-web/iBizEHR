<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTStopRemindGridViewBase from './pimcontractstop-remind-grid-view-base.vue';

import view_grid from '@widgets/pim-contract/stop-remind-grid-grid/stop-remind-grid-grid.vue';
import view_searchform from '@widgets/pim-contract/default-searchform/default-searchform.vue';

/**
 * 合同信息表格视图(终止提醒)
 *
 * @export
 * @class PIMCONTRACTStopRemindGridView
 * @extends {PIMCONTRACTStopRemindGridViewBase}
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
export default class PIMCONTRACTStopRemindGridView extends PIMCONTRACTStopRemindGridViewBase { }
</script>