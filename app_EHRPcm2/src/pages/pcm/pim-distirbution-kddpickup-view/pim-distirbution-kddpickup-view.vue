<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionKDDPickupViewBase from './pim-distirbution-kddpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-distirbution/kddpickup-viewpickupviewpanel-pickupviewpanel/kddpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 可调动的分配
 *
 * @export
 * @class PimDistirbutionKDDPickupView
 * @extends {PimDistirbutionKDDPickupViewBase}
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
export default class PimDistirbutionKDDPickupView extends PimDistirbutionKDDPickupViewBase { }
</script>