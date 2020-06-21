<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAddressMPickupViewBase from './trm-train-address-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-train-address/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 培训地点数据多项选择视图
 *
 * @export
 * @class TrmTrainAddressMPickupView
 * @extends {TrmTrainAddressMPickupViewBase}
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
export default class TrmTrainAddressMPickupView extends TrmTrainAddressMPickupViewBase { }
</script>