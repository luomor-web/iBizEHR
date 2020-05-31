<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMREWARDPUNISHMENTHONORGridViewBase from './pimrewardpunishmenthonorgrid-view-base.vue';

import view_grid from '@widgets/pim-reward-punishment/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pim-reward-punishment/default-searchform/default-searchform.vue';

/**
 * 荣誉奖励
 *
 * @export
 * @class PIMREWARDPUNISHMENTHONORGridView
 * @extends {PIMREWARDPUNISHMENTHONORGridViewBase}
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
export default class PIMREWARDPUNISHMENTHONORGridView extends PIMREWARDPUNISHMENTHONORGridViewBase { }
</script>