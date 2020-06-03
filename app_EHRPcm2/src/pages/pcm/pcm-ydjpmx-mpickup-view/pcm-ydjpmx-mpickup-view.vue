<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxMPickupViewBase from './pcm-ydjpmx-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydjpmx/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动解聘明细数据多项选择视图
 *
 * @export
 * @class PcmYdjpmxMPickupView
 * @extends {PcmYdjpmxMPickupViewBase}
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
export default class PcmYdjpmxMPickupView extends PcmYdjpmxMPickupViewBase { }
</script>