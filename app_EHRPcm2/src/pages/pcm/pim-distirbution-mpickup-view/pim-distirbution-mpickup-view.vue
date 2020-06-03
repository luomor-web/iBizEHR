<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionMPickupViewBase from './pim-distirbution-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-distirbution/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 分配信息数据多项选择视图
 *
 * @export
 * @class PimDistirbutionMPickupView
 * @extends {PimDistirbutionMPickupViewBase}
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
export default class PimDistirbutionMPickupView extends PimDistirbutionMPickupViewBase { }
</script>