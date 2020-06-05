<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxPickupGridViewBase from './pcm-ydjpmx-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydjpmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydjpmx/default-searchform/default-searchform.vue';

/**
 * 异动解聘明细选择表格视图
 *
 * @export
 * @class PcmYdjpmxPickupGridView
 * @extends {PcmYdjpmxPickupGridViewBase}
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
export default class PcmYdjpmxPickupGridView extends PcmYdjpmxPickupGridViewBase { }
</script>