<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionKDDMPickupViewBase from './pim-distirbution-kddmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-distirbution/kddmpickup-viewpickupviewpanel-pickupviewpanel/kddmpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 可调动的分配
 *
 * @export
 * @class PimDistirbutionKDDMPickupView
 * @extends {PimDistirbutionKDDMPickupViewBase}
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
export default class PimDistirbutionKDDMPickupView extends PimDistirbutionKDDMPickupViewBase { }
</script>