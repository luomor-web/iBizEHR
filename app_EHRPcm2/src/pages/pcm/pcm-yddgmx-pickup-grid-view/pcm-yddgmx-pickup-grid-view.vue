<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxPickupGridViewBase from './pcm-yddgmx-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-yddgmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-yddgmx/default-searchform/default-searchform.vue';

/**
 * 异动待岗明细选择表格视图
 *
 * @export
 * @class PcmYddgmxPickupGridView
 * @extends {PcmYddgmxPickupGridViewBase}
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
export default class PcmYddgmxPickupGridView extends PcmYddgmxPickupGridViewBase { }
</script>