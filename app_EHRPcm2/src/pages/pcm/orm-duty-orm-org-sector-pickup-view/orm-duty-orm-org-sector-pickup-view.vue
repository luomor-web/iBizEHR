<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmDutyOrmOrgSectorPickupViewBase from './orm-duty-orm-org-sector-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-duty/orm-org-sector-pickup-viewpickupviewpanel-pickupviewpanel/orm-org-sector-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 职务库
 *
 * @export
 * @class OrmDutyOrmOrgSectorPickupView
 * @extends {OrmDutyOrmOrgSectorPickupViewBase}
 */
@Component({
    components: {
        view_pickupviewpanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class OrmDutyOrmOrgSectorPickupView extends OrmDutyOrmOrgSectorPickupViewBase { }
</script>