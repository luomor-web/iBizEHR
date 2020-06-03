<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxMPickupViewBase from './pcm-ddsqdmx-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ddsqdmx/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 调动申请单明细数据多项选择视图
 *
 * @export
 * @class PcmDdsqdmxMPickupView
 * @extends {PcmDdsqdmxMPickupViewBase}
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
export default class PcmDdsqdmxMPickupView extends PcmDdsqdmxMPickupViewBase { }
</script>