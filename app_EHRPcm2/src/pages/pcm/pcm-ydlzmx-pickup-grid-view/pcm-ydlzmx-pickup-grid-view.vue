<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxPickupGridViewBase from './pcm-ydlzmx-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydlzmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydlzmx/default-searchform/default-searchform.vue';

/**
 * 异动离职明细选择表格视图
 *
 * @export
 * @class PcmYdlzmxPickupGridView
 * @extends {PcmYdlzmxPickupGridViewBase}
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
export default class PcmYdlzmxPickupGridView extends PcmYdlzmxPickupGridViewBase { }
</script>