<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmDutyOrgSectorPickupViewBase from './orm-duty-org-sector-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-duty/org-sector-pickup-viewpickupviewpanel-pickupviewpanel/org-sector-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 职务库
 *
 * @export
 * @class OrmDutyOrgSectorPickupView
 * @extends {OrmDutyOrgSectorPickupViewBase}
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
export default class OrmDutyOrgSectorPickupView extends OrmDutyOrgSectorPickupViewBase { }
</script>