<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainBuapplyGridViewBase from './trm-train-buapply-grid-view-base.vue';

import view_grid from '@widgets/trm-train-buapply/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-buapply/default-searchform/default-searchform.vue';

/**
 * 培训费用登记
 *
 * @export
 * @class TrmTrainBuapplyGridView
 * @extends {TrmTrainBuapplyGridViewBase}
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
export default class TrmTrainBuapplyGridView extends TrmTrainBuapplyGridViewBase { }
</script>