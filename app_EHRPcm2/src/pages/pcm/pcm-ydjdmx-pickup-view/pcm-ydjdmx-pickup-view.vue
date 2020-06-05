<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxPickupViewBase from './pcm-ydjdmx-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydjdmx/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动借调明细数据选择视图
 *
 * @export
 * @class PcmYdjdmxPickupView
 * @extends {PcmYdjdmxPickupViewBase}
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
export default class PcmYdjdmxPickupView extends PcmYdjdmxPickupViewBase { }
</script>