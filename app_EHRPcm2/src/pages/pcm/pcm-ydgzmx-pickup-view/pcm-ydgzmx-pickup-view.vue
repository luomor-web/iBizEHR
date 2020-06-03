<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxPickupViewBase from './pcm-ydgzmx-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydgzmx/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动挂职明细数据选择视图
 *
 * @export
 * @class PcmYdgzmxPickupView
 * @extends {PcmYdgzmxPickupViewBase}
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
export default class PcmYdgzmxPickupView extends PcmYdgzmxPickupViewBase { }
</script>