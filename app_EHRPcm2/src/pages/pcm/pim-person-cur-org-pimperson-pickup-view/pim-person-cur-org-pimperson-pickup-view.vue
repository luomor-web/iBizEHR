<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonCurOrgPimpersonPickupViewBase from './pim-person-cur-org-pimperson-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/cur-org-pimperson-pickup-viewpickupviewpanel-pickupviewpanel/cur-org-pimperson-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 人员信息
 *
 * @export
 * @class PimPersonCurOrgPimpersonPickupView
 * @extends {PimPersonCurOrgPimpersonPickupViewBase}
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
export default class PimPersonCurOrgPimpersonPickupView extends PimPersonCurOrgPimpersonPickupViewBase { }
</script>