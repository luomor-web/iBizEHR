<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmSignOrgBDWPickupGridViewBase from './orm-sign-org-bdwpickup-grid-view-base.vue';

import view_grid from '@widgets/orm-sign-org/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-sign-org/default-searchform/default-searchform.vue';

/**
 * 注册单位选择
 *
 * @export
 * @class OrmSignOrgBDWPickupGridView
 * @extends {OrmSignOrgBDWPickupGridViewBase}
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
export default class OrmSignOrgBDWPickupGridView extends OrmSignOrgBDWPickupGridViewBase { }
</script>