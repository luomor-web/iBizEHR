<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGYPZXXSYPickupGridViewBase from './ormorgypzxxsypickup-grid-view-base.vue';

import view_grid from '@widgets/orm-org/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-org/default-searchform/default-searchform.vue';

/**
 * 组织选择表格视图
 *
 * @export
 * @class ORMORGYPZXXSYPickupGridView
 * @extends {ORMORGYPZXXSYPickupGridViewBase}
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
export default class ORMORGYPZXXSYPickupGridView extends ORMORGYPZXXSYPickupGridViewBase { }
</script>