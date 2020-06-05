<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzkhjgjlPickupViewBase from './pcm-xygzzkhjgjl-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-xygzzkhjgjl/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 新员工转正考核结果记录数据选择视图
 *
 * @export
 * @class PcmXygzzkhjgjlPickupView
 * @extends {PcmXygzzkhjgjlPickupViewBase}
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
export default class PcmXygzzkhjgjlPickupView extends PcmXygzzkhjgjlPickupViewBase { }
</script>