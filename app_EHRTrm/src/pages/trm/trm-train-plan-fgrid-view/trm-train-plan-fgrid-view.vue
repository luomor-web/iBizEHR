<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlanFGridViewBase from './trm-train-plan-fgrid-view-base.vue';

import view_grid from '@widgets/trm-train-plan/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-plan/default-searchform/default-searchform.vue';

/**
 * 计划审批
 *
 * @export
 * @class TrmTrainPlanFGridView
 * @extends {TrmTrainPlanFGridViewBase}
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
export default class TrmTrainPlanFGridView extends TrmTrainPlanFGridViewBase { }
</script>