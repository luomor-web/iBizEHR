<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxMPickupViewBase from './pcm-yddgmx-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-yddgmx/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动待岗明细数据多项选择视图
 *
 * @export
 * @class PcmYddgmxMPickupView
 * @extends {PcmYddgmxMPickupViewBase}
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
export default class PcmYddgmxMPickupView extends PcmYddgmxMPickupViewBase { }
</script>