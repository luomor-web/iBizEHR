<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAddressPickupGridViewBase from './trm-train-address-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-train-address/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-address/default-searchform/default-searchform.vue';

/**
 * 培训地点选择表格视图
 *
 * @export
 * @class TrmTrainAddressPickupGridView
 * @extends {TrmTrainAddressPickupGridViewBase}
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
export default class TrmTrainAddressPickupGridView extends TrmTrainAddressPickupGridViewBase { }
</script>