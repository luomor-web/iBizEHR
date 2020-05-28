<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGPickupGridViewBase from './ormorgpickup-grid-view-base.vue';

import view_grid from '@widgets/orm-org/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-org/default-searchform/default-searchform.vue';

/**
 * 组织管理选择表格视图
 *
 * @export
 * @class ORMORGPickupGridView
 * @extends {ORMORGPickupGridViewBase}
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
export default class ORMORGPickupGridView extends ORMORGPickupGridViewBase { }
</script>