<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxMPickupViewBase from './pcm-ydjdmx-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydjdmx/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动借调明细数据多项选择视图
 *
 * @export
 * @class PcmYdjdmxMPickupView
 * @extends {PcmYdjdmxMPickupViewBase}
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
export default class PcmYdjdmxMPickupView extends PcmYdjdmxMPickupViewBase { }
</script>