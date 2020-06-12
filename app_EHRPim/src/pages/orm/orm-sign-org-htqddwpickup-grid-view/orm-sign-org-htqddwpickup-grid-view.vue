<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmSignOrgHTQDDWPickupGridViewBase from './orm-sign-org-htqddwpickup-grid-view-base.vue';

import view_grid from '@widgets/orm-sign-org/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-sign-org/default-searchform/default-searchform.vue';

/**
 * 合同签订单位选择
 *
 * @export
 * @class OrmSignOrgHTQDDWPickupGridView
 * @extends {OrmSignOrgHTQDDWPickupGridViewBase}
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
export default class OrmSignOrgHTQDDWPickupGridView extends OrmSignOrgHTQDDWPickupGridViewBase { }
</script>