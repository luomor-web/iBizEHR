<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionPickupViewBase from './pim-distirbution-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-distirbution/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 分配信息数据选择视图
 *
 * @export
 * @class PimDistirbutionPickupView
 * @extends {PimDistirbutionPickupViewBase}
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
export default class PimDistirbutionPickupView extends PimDistirbutionPickupViewBase { }
</script>