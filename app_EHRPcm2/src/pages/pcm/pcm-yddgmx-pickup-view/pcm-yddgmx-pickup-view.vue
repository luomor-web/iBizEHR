<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxPickupViewBase from './pcm-yddgmx-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-yddgmx/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动待岗明细数据选择视图
 *
 * @export
 * @class PcmYddgmxPickupView
 * @extends {PcmYddgmxPickupViewBase}
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
export default class PcmYddgmxPickupView extends PcmYddgmxPickupViewBase { }
</script>