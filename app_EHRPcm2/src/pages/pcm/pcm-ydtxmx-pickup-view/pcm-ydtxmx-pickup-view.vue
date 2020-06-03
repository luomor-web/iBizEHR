<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdtxmxPickupViewBase from './pcm-ydtxmx-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydtxmx/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动病休明细数据选择视图
 *
 * @export
 * @class PcmYdtxmxPickupView
 * @extends {PcmYdtxmxPickupViewBase}
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
export default class PcmYdtxmxPickupView extends PcmYdtxmxPickupViewBase { }
</script>