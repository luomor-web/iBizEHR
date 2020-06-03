<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxMPickupViewBase from './pcm-ydbxmx-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydbxmx/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动病休明细数据多项选择视图
 *
 * @export
 * @class PcmYdbxmxMPickupView
 * @extends {PcmYdbxmxMPickupViewBase}
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
export default class PcmYdbxmxMPickupView extends PcmYdbxmxMPickupViewBase { }
</script>