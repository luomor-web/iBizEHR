<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxPickupViewBase from './pcm-ydbxmx-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-ydbxmx/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 异动病休明细数据选择视图
 *
 * @export
 * @class PcmYdbxmxPickupView
 * @extends {PcmYdbxmxPickupViewBase}
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
export default class PcmYdbxmxPickupView extends PcmYdbxmxPickupViewBase { }
</script>