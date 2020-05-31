<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDUTYOrmOrgSectorPickupViewBase from './ormdutyorm-org-sector-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-duty/orm-org-sector-pickup-viewpickupviewpanel-pickupviewpanel/orm-org-sector-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 职务库
 *
 * @export
 * @class ORMDUTYOrmOrgSectorPickupView
 * @extends {ORMDUTYOrmOrgSectorPickupViewBase}
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
export default class ORMDUTYOrmOrgSectorPickupView extends ORMDUTYOrmOrgSectorPickupViewBase { }
</script>