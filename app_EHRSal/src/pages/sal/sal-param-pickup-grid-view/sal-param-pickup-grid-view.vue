<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalParamPickupGridViewBase from './sal-param-pickup-grid-view-base.vue';

import view_grid from '@widgets/sal-param/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-param/default-searchform/default-searchform.vue';

/**
 * 薪酬计算指标选择表格视图
 *
 * @export
 * @class SalParamPickupGridView
 * @extends {SalParamPickupGridViewBase}
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
export default class SalParamPickupGridView extends SalParamPickupGridViewBase { }
</script>