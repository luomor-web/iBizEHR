<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlanGridViewBase from './trm-train-plan-grid-view-base.vue';

import view_grid from '@widgets/trm-train-plan/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-plan/default-searchform/default-searchform.vue';

/**
 * 培训计划详情
 *
 * @export
 * @class TrmTrainPlanGridView
 * @extends {TrmTrainPlanGridViewBase}
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
export default class TrmTrainPlanGridView extends TrmTrainPlanGridViewBase { }
</script>