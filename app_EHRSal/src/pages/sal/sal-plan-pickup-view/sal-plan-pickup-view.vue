<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalPlanPickupViewBase from './sal-plan-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-plan/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 薪酬计算计划数据选择视图
 *
 * @export
 * @class SalPlanPickupView
 * @extends {SalPlanPickupViewBase}
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
export default class SalPlanPickupView extends SalPlanPickupViewBase { }
</script>