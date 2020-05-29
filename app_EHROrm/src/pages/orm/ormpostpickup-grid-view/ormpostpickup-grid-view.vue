<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPOSTPickupGridViewBase from './ormpostpickup-grid-view-base.vue';

import view_grid from '@widgets/orm-post/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-post/default-searchform/default-searchform.vue';

/**
 * 岗位管理选择表格视图
 *
 * @export
 * @class ORMPOSTPickupGridView
 * @extends {ORMPOSTPickupGridViewBase}
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
export default class ORMPOSTPickupGridView extends ORMPOSTPickupGridViewBase { }
</script>