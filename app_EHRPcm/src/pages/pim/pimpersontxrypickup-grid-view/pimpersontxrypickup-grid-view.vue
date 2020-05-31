<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONTXRYPickupGridViewBase from './pimpersontxrypickup-grid-view-base.vue';

import view_grid from '@widgets/pim-person/txlxyg-grid/txlxyg-grid.vue';
import view_searchform from '@widgets/pim-person/txrysearch-form-searchform/txrysearch-form-searchform.vue';

/**
 * 退休人员
 *
 * @export
 * @class PIMPERSONTXRYPickupGridView
 * @extends {PIMPERSONTXRYPickupGridViewBase}
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
export default class PIMPERSONTXRYPickupGridView extends PIMPERSONTXRYPickupGridViewBase { }
</script>