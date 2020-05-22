<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDUTYOrmOrgSectorPickupGridViewBase from './ormdutyorm-org-sector-pickup-grid-view-base.vue';

import view_grid from '@widgets/ormduty/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormduty/wcjsearch-form-searchform/wcjsearch-form-searchform.vue';

/**
 * 职务库
 *
 * @export
 * @class ORMDUTYOrmOrgSectorPickupGridView
 * @extends {ORMDUTYOrmOrgSectorPickupGridViewBase}
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
export default class ORMDUTYOrmOrgSectorPickupGridView extends ORMDUTYOrmOrgSectorPickupGridViewBase { }
</script>