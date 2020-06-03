<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionKDDFPPickupGridViewBase from './pim-distirbution-kddfppickup-grid-view-base.vue';

import view_grid from '@widgets/pim-distirbution/ddfpxx-grid/ddfpxx-grid.vue';
import view_searchform from '@widgets/pim-distirbution/default-searchform/default-searchform.vue';

/**
 * 可调动的分配
 *
 * @export
 * @class PimDistirbutionKDDFPPickupGridView
 * @extends {PimDistirbutionKDDFPPickupGridViewBase}
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
export default class PimDistirbutionKDDFPPickupGridView extends PimDistirbutionKDDFPPickupGridViewBase { }
</script>