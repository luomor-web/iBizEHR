<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONTXRYPickupViewBase from './pimpersontxrypickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/txrypickup-viewpickupviewpanel-pickupviewpanel/txrypickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 选择退休人员
 *
 * @export
 * @class PIMPERSONTXRYPickupView
 * @extends {PIMPERSONTXRYPickupViewBase}
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
export default class PIMPERSONTXRYPickupView extends PIMPERSONTXRYPickupViewBase { }
</script>