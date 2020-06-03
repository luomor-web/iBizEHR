<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxPickupViewBase from './pcm-ydjpmx-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydjpmx/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动解聘明细数据选择视图
 *
 * @export
 * @class PcmYdjpmxPickupView
 * @extends {PcmYdjpmxPickupViewBase}
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
export default class PcmYdjpmxPickupView extends PcmYdjpmxPickupViewBase { }
</script>