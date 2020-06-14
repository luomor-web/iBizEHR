<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalItemPickupGridViewBase from './sal-item-pickup-grid-view-base.vue';

import view_grid from '@widgets/sal-item/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-item/default-searchform/default-searchform.vue';

/**
 * 薪酬要素项选择表格视图
 *
 * @export
 * @class SalItemPickupGridView
 * @extends {SalItemPickupGridViewBase}
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
export default class SalItemPickupGridView extends SalItemPickupGridViewBase { }
</script>