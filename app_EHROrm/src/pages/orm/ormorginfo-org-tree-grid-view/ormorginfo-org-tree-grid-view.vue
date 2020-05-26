<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGInfoOrgTreeGridViewBase from './ormorginfo-org-tree-grid-view-base.vue';

import view_grid from '@widgets/ormorginfo/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormorginfo/default-searchform/default-searchform.vue';

/**
 * 组织管理
 *
 * @export
 * @class ORMORGInfoOrgTreeGridView
 * @extends {ORMORGInfoOrgTreeGridViewBase}
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
export default class ORMORGInfoOrgTreeGridView extends ORMORGInfoOrgTreeGridViewBase { }
</script>