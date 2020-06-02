<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdtxmxPickupGridViewBase from './pcm-ydtxmx-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydtxmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydtxmx/default-searchform/default-searchform.vue';

/**
 * 异动病休明细选择表格视图
 *
 * @export
 * @class PcmYdtxmxPickupGridView
 * @extends {PcmYdtxmxPickupGridViewBase}
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
export default class PcmYdtxmxPickupGridView extends PcmYdtxmxPickupGridViewBase { }
</script>