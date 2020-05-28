<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGAllLevelTwoOrgPickupViewBase from './ormorgall-level-two-org-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/all-level-two-org-pickup-viewpickupviewpanel-pickupviewpanel/all-level-two-org-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 管理单位
 *
 * @export
 * @class ORMORGAllLevelTwoOrgPickupView
 * @extends {ORMORGAllLevelTwoOrgPickupViewBase}
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
export default class ORMORGAllLevelTwoOrgPickupView extends ORMORGAllLevelTwoOrgPickupViewBase { }
</script>