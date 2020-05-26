<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGInfoSubSubOrgGridViewBase from './ormorginfo-sub-sub-org-grid-view-base.vue';

import view_grid from '@widgets/ormorginfo/person-grid/person-grid.vue';
import view_searchform from '@widgets/ormorginfo/search-person-searchform/search-person-searchform.vue';

/**
 * 组织管理
 *
 * @export
 * @class ORMORGInfoSubSubOrgGridView
 * @extends {ORMORGInfoSubSubOrgGridViewBase}
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
export default class ORMORGInfoSubSubOrgGridView extends ORMORGInfoSubSubOrgGridViewBase { }
</script>