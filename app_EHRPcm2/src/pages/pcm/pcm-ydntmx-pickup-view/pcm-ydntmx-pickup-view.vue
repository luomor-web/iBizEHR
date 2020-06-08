<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxPickupViewBase from './pcm-ydntmx-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydntmx/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动内退明细数据选择视图
 *
 * @export
 * @class PcmYdntmxPickupView
 * @extends {PcmYdntmxPickupViewBase}
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
export default class PcmYdntmxPickupView extends PcmYdntmxPickupViewBase { }
</script>