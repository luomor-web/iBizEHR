<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORPXMBPickupViewBase from './ormorgsectorpxmbpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormorgsector/pxmbpickup-viewpickupviewpanel-pickupviewpanel/pxmbpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 项目部选择
 *
 * @export
 * @class ORMORGSECTORPXMBPickupView
 * @extends {ORMORGSECTORPXMBPickupViewBase}
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
export default class ORMORGSECTORPXMBPickupView extends ORMORGSECTORPXMBPickupViewBase { }
</script>