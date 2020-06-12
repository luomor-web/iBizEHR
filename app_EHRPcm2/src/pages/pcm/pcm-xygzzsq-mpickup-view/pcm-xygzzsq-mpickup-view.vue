<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzsqMPickupViewBase from './pcm-xygzzsq-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-xygzzsq/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 试用期员工转正申请数据多项选择视图
 *
 * @export
 * @class PcmXygzzsqMPickupView
 * @extends {PcmXygzzsqMPickupViewBase}
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
export default class PcmXygzzsqMPickupView extends PcmXygzzsqMPickupViewBase { }
</script>