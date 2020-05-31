<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMGWTYPEMPickupViewBase from './pimgwtypempickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-gw-type/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 岗位类型
 *
 * @export
 * @class PIMGWTYPEMPickupView
 * @extends {PIMGWTYPEMPickupViewBase}
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
export default class PIMGWTYPEMPickupView extends PIMGWTYPEMPickupViewBase { }
</script>