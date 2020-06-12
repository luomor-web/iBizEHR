<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmDutyOrgSectorPickupGridViewBase from './orm-duty-org-sector-pickup-grid-view-base.vue';

import view_grid from '@widgets/orm-duty/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-duty/wcjsearch-form-searchform/wcjsearch-form-searchform.vue';

/**
 * 职务库
 *
 * @export
 * @class OrmDutyOrgSectorPickupGridView
 * @extends {OrmDutyOrgSectorPickupGridViewBase}
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
export default class OrmDutyOrgSectorPickupGridView extends OrmDutyOrgSectorPickupGridViewBase { }
</script>