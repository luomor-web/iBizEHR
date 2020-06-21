<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainFaciesGridViewBase from './trm-train-facies-grid-view-base.vue';

import view_grid from '@widgets/trm-train-facies/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-facies/default-searchform/default-searchform.vue';

/**
 * 培训设施表格视图
 *
 * @export
 * @class TrmTrainFaciesGridView
 * @extends {TrmTrainFaciesGridViewBase}
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
export default class TrmTrainFaciesGridView extends TrmTrainFaciesGridViewBase { }
</script>