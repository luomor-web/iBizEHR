<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGOrgTreeExpViewBase from './ormorgorg-tree-exp-view-base.vue';

import view_treeexpbar from '@widgets/orm-org/org-tree-exp-viewtreeexpbar-treeexpbar/org-tree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 组织管理
 *
 * @export
 * @class ORMORGOrgTreeExpView
 * @extends {ORMORGOrgTreeExpViewBase}
 */
@Component({
    components: {
        view_treeexpbar, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ORMORGOrgTreeExpView extends ORMORGOrgTreeExpViewBase { }
</script>