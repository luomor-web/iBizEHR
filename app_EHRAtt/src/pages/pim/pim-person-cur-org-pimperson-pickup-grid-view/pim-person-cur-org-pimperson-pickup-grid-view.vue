<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonCurOrgPimpersonPickupGridViewBase from './pim-person-cur-org-pimperson-pickup-grid-view-base.vue';

import view_grid from '@widgets/pim-person/ryinfo-grid-grid/ryinfo-grid-grid.vue';
import view_searchform from '@widgets/pim-person/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 人员信息
 *
 * @export
 * @class PimPersonCurOrgPimpersonPickupGridView
 * @extends {PimPersonCurOrgPimpersonPickupGridViewBase}
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
export default class PimPersonCurOrgPimpersonPickupGridView extends PimPersonCurOrgPimpersonPickupGridViewBase { }
</script>