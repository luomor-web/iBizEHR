<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxPickupGridViewBase from './pcm-ydgzmx-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydgzmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydgzmx/default-searchform/default-searchform.vue';

/**
 * 异动挂职明细选择表格视图
 *
 * @export
 * @class PcmYdgzmxPickupGridView
 * @extends {PcmYdgzmxPickupGridViewBase}
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
export default class PcmYdgzmxPickupGridView extends PcmYdgzmxPickupGridViewBase { }
</script>