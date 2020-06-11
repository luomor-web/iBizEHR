<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParKhzcmxPickupGridViewBase from './par-khzcmx-pickup-grid-view-base.vue';

import view_grid from '@widgets/par-khzcmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-khzcmx/default-searchform/default-searchform.vue';

/**
 * 考核组成明细选择表格视图
 *
 * @export
 * @class ParKhzcmxPickupGridView
 * @extends {ParKhzcmxPickupGridViewBase}
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
export default class ParKhzcmxPickupGridView extends ParKhzcmxPickupGridViewBase { }
</script>