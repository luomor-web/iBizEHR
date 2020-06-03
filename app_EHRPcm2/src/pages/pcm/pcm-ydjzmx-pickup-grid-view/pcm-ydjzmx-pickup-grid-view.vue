<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxPickupGridViewBase from './pcm-ydjzmx-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydjzmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydjzmx/default-searchform/default-searchform.vue';

/**
 * 异动兼职明细选择表格视图
 *
 * @export
 * @class PcmYdjzmxPickupGridView
 * @extends {PcmYdjzmxPickupGridViewBase}
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
export default class PcmYdjzmxPickupGridView extends PcmYdjzmxPickupGridViewBase { }
</script>