<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlanPickupViewBase from './trm-train-plan-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-train-plan/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 培训计划数据选择视图
 *
 * @export
 * @class TrmTrainPlanPickupView
 * @extends {TrmTrainPlanPickupViewBase}
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
export default class TrmTrainPlanPickupView extends TrmTrainPlanPickupViewBase { }
</script>