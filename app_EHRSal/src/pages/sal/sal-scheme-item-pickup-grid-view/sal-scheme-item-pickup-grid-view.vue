<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSchemeItemPickupGridViewBase from './sal-scheme-item-pickup-grid-view-base.vue';

import view_grid from '@widgets/sal-scheme-item/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-scheme-item/default-searchform/default-searchform.vue';

/**
 * 方案要素项选择表格视图
 *
 * @export
 * @class SalSchemeItemPickupGridView
 * @extends {SalSchemeItemPickupGridViewBase}
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
export default class SalSchemeItemPickupGridView extends SalSchemeItemPickupGridViewBase { }
</script>