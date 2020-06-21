<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAddressPickupViewBase from './trm-train-address-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-train-address/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 培训地点数据选择视图
 *
 * @export
 * @class TrmTrainAddressPickupView
 * @extends {TrmTrainAddressPickupViewBase}
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
export default class TrmTrainAddressPickupView extends TrmTrainAddressPickupViewBase { }
</script>