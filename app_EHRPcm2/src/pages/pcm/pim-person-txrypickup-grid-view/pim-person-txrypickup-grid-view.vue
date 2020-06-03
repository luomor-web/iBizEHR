<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonTXRYPickupGridViewBase from './pim-person-txrypickup-grid-view-base.vue';

import view_grid from '@widgets/pim-person/txlxyg-grid/txlxyg-grid.vue';
import view_searchform from '@widgets/pim-person/txrysearch-form-searchform/txrysearch-form-searchform.vue';

/**
 * 退休人员
 *
 * @export
 * @class PimPersonTXRYPickupGridView
 * @extends {PimPersonTXRYPickupGridViewBase}
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
export default class PimPersonTXRYPickupGridView extends PimPersonTXRYPickupGridViewBase { }
</script>