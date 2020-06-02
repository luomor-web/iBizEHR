<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmSignOrgPickupGridViewBase from './orm-sign-org-pickup-grid-view-base.vue';

import view_grid from '@widgets/orm-sign-org/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-sign-org/default-searchform/default-searchform.vue';

/**
 * 法人主体选择表格视图
 *
 * @export
 * @class OrmSignOrgPickupGridView
 * @extends {OrmSignOrgPickupGridViewBase}
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
export default class OrmSignOrgPickupGridView extends OrmSignOrgPickupGridViewBase { }
</script>