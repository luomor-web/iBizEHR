<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlanJHFBGridViewBase from './trm-train-plan-jhfbgrid-view-base.vue';

import view_grid from '@widgets/trm-train-plan/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-plan/default-searchform/default-searchform.vue';

/**
 * 计划发布
 *
 * @export
 * @class TrmTrainPlanJHFBGridView
 * @extends {TrmTrainPlanJHFBGridViewBase}
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
export default class TrmTrainPlanJHFBGridView extends TrmTrainPlanJHFBGridViewBase { }
</script>