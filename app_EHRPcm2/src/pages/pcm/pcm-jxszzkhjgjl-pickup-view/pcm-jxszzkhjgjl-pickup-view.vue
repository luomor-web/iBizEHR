<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxszzkhjgjlPickupViewBase from './pcm-jxszzkhjgjl-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-jxszzkhjgjl/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 见习生员工转正考核结果记录数据选择视图
 *
 * @export
 * @class PcmJxszzkhjgjlPickupView
 * @extends {PcmJxszzkhjgjlPickupViewBase}
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
export default class PcmJxszzkhjgjlPickupView extends PcmJxszzkhjgjlPickupViewBase { }
</script>