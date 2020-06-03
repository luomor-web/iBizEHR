<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonKXZXYGPickupGridViewBase from './pim-person-kxzxygpickup-grid-view-base.vue';

import view_grid from '@widgets/pim-person/sydqyg-grid/sydqyg-grid.vue';
import view_searchform from '@widgets/pim-person/default-searchform/default-searchform.vue';

/**
 * 人员信息选择表格视图
 *
 * @export
 * @class PimPersonKXZXYGPickupGridView
 * @extends {PimPersonKXZXYGPickupGridViewBase}
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
export default class PimPersonKXZXYGPickupGridView extends PimPersonKXZXYGPickupGridViewBase { }
</script>