<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMBQGridViewBase from './ormxmbqgrid-view-base.vue';

import view_grid from '@widgets/orm-xmbq/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-xmbq/default-searchform/default-searchform.vue';

/**
 * 项目标签
 *
 * @export
 * @class ORMXMBQGridView
 * @extends {ORMXMBQGridViewBase}
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
export default class ORMXMBQGridView extends ORMXMBQGridViewBase { }
</script>