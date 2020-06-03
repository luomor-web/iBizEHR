<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimFaminfoJTLXRPickupGridViewBase from './pim-faminfo-jtlxrpickup-grid-view-base.vue';

import view_grid from '@widgets/pim-faminfo/lxrgrid-grid/lxrgrid-grid.vue';
import view_searchform from '@widgets/pim-faminfo/default-searchform/default-searchform.vue';

/**
 * 家庭联系人
 *
 * @export
 * @class PimFaminfoJTLXRPickupGridView
 * @extends {PimFaminfoJTLXRPickupGridViewBase}
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
export default class PimFaminfoJTLXRPickupGridView extends PimFaminfoJTLXRPickupGridViewBase { }
</script>