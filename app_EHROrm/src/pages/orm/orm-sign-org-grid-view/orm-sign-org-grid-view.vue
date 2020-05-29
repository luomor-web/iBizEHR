<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmSignOrgGridViewBase from './orm-sign-org-grid-view-base.vue';

import view_grid from '@widgets/orm-sign-org/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-sign-org/default-searchform/default-searchform.vue';

/**
 * 法人主体维护
 *
 * @export
 * @class OrmSignOrgGridView
 * @extends {OrmSignOrgGridViewBase}
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
export default class OrmSignOrgGridView extends OrmSignOrgGridViewBase { }
</script>