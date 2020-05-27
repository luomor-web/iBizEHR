<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSubOrgGridViewBase from './ormorgsub-org-grid-view-base.vue';

import view_grid from '@widgets/ormorg/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormorg/default-searchform/default-searchform.vue';

/**
 * 组织管理
 *
 * @export
 * @class ORMORGSubOrgGridView
 * @extends {ORMORGSubOrgGridViewBase}
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
export default class ORMORGSubOrgGridView extends ORMORGSubOrgGridViewBase { }
</script>