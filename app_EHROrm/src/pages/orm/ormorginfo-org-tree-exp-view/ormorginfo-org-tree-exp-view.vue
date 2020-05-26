<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGInfoOrgTreeExpViewBase from './ormorginfo-org-tree-exp-view-base.vue';

import view_treeexpbar from '@widgets/ormorginfo/org-tree-exp-viewtreeexpbar-treeexpbar/org-tree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 组织管理
 *
 * @export
 * @class ORMORGInfoOrgTreeExpView
 * @extends {ORMORGInfoOrgTreeExpViewBase}
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
export default class ORMORGInfoOrgTreeExpView extends ORMORGInfoOrgTreeExpViewBase { }
</script>