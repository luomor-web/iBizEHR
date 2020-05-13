<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGXMBQPickupGridViewBase from './ormorgxmbqpickup-grid-view-base.vue';

import view_grid from '@widgets/ormorg/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormorg/default-searchform/default-searchform.vue';

/**
 * 组织选择表格视图
 *
 * @export
 * @class ORMORGXMBQPickupGridView
 * @extends {ORMORGXMBQPickupGridViewBase}
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
export default class ORMORGXMBQPickupGridView extends ORMORGXMBQPickupGridViewBase { }
</script>