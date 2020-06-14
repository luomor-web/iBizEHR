<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSourcePickupGridViewBase from './sal-source-pickup-grid-view-base.vue';

import view_grid from '@widgets/sal-source/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-source/default-searchform/default-searchform.vue';

/**
 * 薪酬计算源选择表格视图
 *
 * @export
 * @class SalSourcePickupGridView
 * @extends {SalSourcePickupGridViewBase}
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
export default class SalSourcePickupGridView extends SalSourcePickupGridViewBase { }
</script>