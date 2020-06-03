<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxMPickupViewBase from './pcm-ydlzmx-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydlzmx/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动离职明细数据多项选择视图
 *
 * @export
 * @class PcmYdlzmxMPickupView
 * @extends {PcmYdlzmxMPickupViewBase}
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
export default class PcmYdlzmxMPickupView extends PcmYdlzmxMPickupViewBase { }
</script>