<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxPickupViewBase from './pcm-ydjzmx-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydjzmx/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动兼职明细数据选择视图
 *
 * @export
 * @class PcmYdjzmxPickupView
 * @extends {PcmYdjzmxPickupViewBase}
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
export default class PcmYdjzmxPickupView extends PcmYdjzmxPickupViewBase { }
</script>