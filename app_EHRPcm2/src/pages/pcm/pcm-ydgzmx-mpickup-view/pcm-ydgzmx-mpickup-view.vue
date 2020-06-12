<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxMPickupViewBase from './pcm-ydgzmx-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydgzmx/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动挂职明细数据多项选择视图
 *
 * @export
 * @class PcmYdgzmxMPickupView
 * @extends {PcmYdgzmxMPickupViewBase}
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
export default class PcmYdgzmxMPickupView extends PcmYdgzmxMPickupViewBase { }
</script>