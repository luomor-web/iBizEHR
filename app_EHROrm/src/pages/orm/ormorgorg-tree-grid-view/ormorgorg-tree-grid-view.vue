<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGOrgTreeGridViewBase from './ormorgorg-tree-grid-view-base.vue';

import view_grid from '@widgets/orm-org/org-tree-grid/org-tree-grid.vue';
import view_searchform from '@widgets/orm-org/default-searchform/default-searchform.vue';

/**
 * 组织管理
 *
 * @export
 * @class ORMORGOrgTreeGridView
 * @extends {ORMORGOrgTreeGridViewBase}
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
export default class ORMORGOrgTreeGridView extends ORMORGOrgTreeGridViewBase { }
</script>