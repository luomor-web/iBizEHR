<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlanPickupGridViewBase from './trm-train-plan-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-train-plan/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-plan/default-searchform/default-searchform.vue';

/**
 * 培训计划选择表格视图
 *
 * @export
 * @class TrmTrainPlanPickupGridView
 * @extends {TrmTrainPlanPickupGridViewBase}
 */
@Component({
    components: {
        view_grid, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class TrmTrainPlanPickupGridView extends TrmTrainPlanPickupGridViewBase { }
</script>