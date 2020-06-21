<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainOutApplyGridViewBase from './trm-train-out-apply-grid-view-base.vue';

import view_grid from '@widgets/trm-train-out-apply/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-out-apply/default-searchform/default-searchform.vue';

/**
 * 外出培训申请
 *
 * @export
 * @class TrmTrainOutApplyGridView
 * @extends {TrmTrainOutApplyGridViewBase}
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
export default class TrmTrainOutApplyGridView extends TrmTrainOutApplyGridViewBase { }
</script>