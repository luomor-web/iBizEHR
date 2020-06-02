<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonTXRYPickupViewBase from './pim-person-txrypickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/txrypickup-viewpickupviewpanel-pickupviewpanel/txrypickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 选择退休人员
 *
 * @export
 * @class PimPersonTXRYPickupView
 * @extends {PimPersonTXRYPickupViewBase}
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
export default class PimPersonTXRYPickupView extends PimPersonTXRYPickupViewBase { }
</script>