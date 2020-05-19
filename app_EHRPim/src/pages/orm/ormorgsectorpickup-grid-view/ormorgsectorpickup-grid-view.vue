<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORPickupGridViewBase from './ormorgsectorpickup-grid-view-base.vue';

import view_grid from '@widgets/ormorgsector/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormorgsector/default-searchform/default-searchform.vue';

/**
 * 部门管理选择表格视图
 *
 * @export
 * @class ORMORGSECTORPickupGridView
 * @extends {ORMORGSECTORPickupGridViewBase}
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
export default class ORMORGSECTORPickupGridView extends ORMORGSECTORPickupGridViewBase { }
</script>