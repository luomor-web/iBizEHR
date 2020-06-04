<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMREWARDPUNISHMENTGRPimJanglGridViewBase from './pimrewardpunishmentgrpim-jangl-grid-view-base.vue';

import view_grid from '@widgets/pim-reward-punishment/main-bonus-penalty-grid/main-bonus-penalty-grid.vue';
import view_searchform from '@widgets/pim-reward-punishment/default-searchform/default-searchform.vue';

/**
 * 奖励惩罚表格视图
 *
 * @export
 * @class PIMREWARDPUNISHMENTGRPimJanglGridView
 * @extends {PIMREWARDPUNISHMENTGRPimJanglGridViewBase}
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
export default class PIMREWARDPUNISHMENTGRPimJanglGridView extends PIMREWARDPUNISHMENTGRPimJanglGridViewBase { }
</script>