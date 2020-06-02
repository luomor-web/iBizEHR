<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxMPickupViewBase from './pcm-ydntmx-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydntmx/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动内退明细数据多项选择视图
 *
 * @export
 * @class PcmYdntmxMPickupView
 * @extends {PcmYdntmxMPickupViewBase}
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
export default class PcmYdntmxMPickupView extends PcmYdntmxMPickupViewBase { }
</script>