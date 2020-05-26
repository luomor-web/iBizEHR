<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMBQPickupGridViewBase from './ormxmbqpickup-grid-view-base.vue';

import view_grid from '@widgets/ormxmbq/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormxmbq/default-searchform/default-searchform.vue';

/**
 * 项目标签选择表格视图
 *
 * @export
 * @class ORMXMBQPickupGridView
 * @extends {ORMXMBQPickupGridViewBase}
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
export default class ORMXMBQPickupGridView extends ORMXMBQPickupGridViewBase { }
</script>