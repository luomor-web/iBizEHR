<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMTITLEMPickupViewBase from './ormtitlempickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormtitle/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 标准头衔库
 *
 * @export
 * @class ORMTITLEMPickupView
 * @extends {ORMTITLEMPickupViewBase}
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
export default class ORMTITLEMPickupView extends ORMTITLEMPickupViewBase { }
</script>