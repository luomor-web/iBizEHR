<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimFaminfoJTLXRPickupViewBase from './pim-faminfo-jtlxrpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-faminfo/jtlxrpickup-viewpickupviewpanel-pickupviewpanel/jtlxrpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 家庭联系人
 *
 * @export
 * @class PimFaminfoJTLXRPickupView
 * @extends {PimFaminfoJTLXRPickupViewBase}
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
export default class PimFaminfoJTLXRPickupView extends PimFaminfoJTLXRPickupViewBase { }
</script>