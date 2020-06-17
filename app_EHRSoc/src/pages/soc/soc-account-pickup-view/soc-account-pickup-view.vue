<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocAccountPickupViewBase from './soc-account-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/soc-account/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 参保账户数据选择视图
 *
 * @export
 * @class SocAccountPickupView
 * @extends {SocAccountPickupViewBase}
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
export default class SocAccountPickupView extends SocAccountPickupViewBase { }
</script>