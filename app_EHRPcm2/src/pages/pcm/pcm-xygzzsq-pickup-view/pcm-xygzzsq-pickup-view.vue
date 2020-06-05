<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzsqPickupViewBase from './pcm-xygzzsq-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-xygzzsq/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 试用期员工转正申请数据选择视图
 *
 * @export
 * @class PcmXygzzsqPickupView
 * @extends {PcmXygzzsqPickupViewBase}
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
export default class PcmXygzzsqPickupView extends PcmXygzzsqPickupViewBase { }
</script>