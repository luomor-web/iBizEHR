<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMREWARDPUNISHMENTPimJanglGridViewBase from './pimrewardpunishmentpim-jangl-grid-view-base.vue';

import view_grid from '@widgets/pim-reward-punishment/main-grid/main-grid.vue';

/**
 * 奖励惩罚表格视图
 *
 * @export
 * @class PIMREWARDPUNISHMENTPimJanglGridView
 * @extends {PIMREWARDPUNISHMENTPimJanglGridViewBase}
 */
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMREWARDPUNISHMENTPimJanglGridView extends PIMREWARDPUNISHMENTPimJanglGridViewBase { }
</script>