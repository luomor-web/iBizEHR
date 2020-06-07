<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxPickupGridViewBase from './pcm-ydjdmx-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydjdmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydjdmx/default-searchform/default-searchform.vue';

/**
 * 异动借调明细选择表格视图
 *
 * @export
 * @class PcmYdjdmxPickupGridView
 * @extends {PcmYdjdmxPickupGridViewBase}
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
export default class PcmYdjdmxPickupGridView extends PcmYdjdmxPickupGridViewBase { }
</script>