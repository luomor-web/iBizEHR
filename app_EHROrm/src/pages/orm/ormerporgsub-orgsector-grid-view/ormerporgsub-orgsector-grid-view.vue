<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMERPORGSubOrgsectorGridViewBase from './ormerporgsub-orgsector-grid-view-base.vue';

import view_grid from '@widgets/ormerporg/new-org-grid/new-org-grid.vue';
import view_searchform from '@widgets/ormerporg/default-searchform/default-searchform.vue';

/**
 * ERP组织库
 *
 * @export
 * @class ORMERPORGSubOrgsectorGridView
 * @extends {ORMERPORGSubOrgsectorGridViewBase}
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
export default class ORMERPORGSubOrgsectorGridView extends ORMERPORGSubOrgsectorGridViewBase { }
</script>