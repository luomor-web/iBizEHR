<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILESZYJTJMPickupViewBase from './pcmprofileszyjtjmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcmprofileszyjtj/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 应聘者社招引进条件选择
 *
 * @export
 * @class PCMPROFILESZYJTJMPickupView
 * @extends {PCMPROFILESZYJTJMPickupViewBase}
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
export default class PCMPROFILESZYJTJMPickupView extends PCMPROFILESZYJTJMPickupViewBase { }
</script>