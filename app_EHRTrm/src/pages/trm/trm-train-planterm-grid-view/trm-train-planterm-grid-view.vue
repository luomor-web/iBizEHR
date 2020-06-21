<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlantermGridViewBase from './trm-train-planterm-grid-view-base.vue';

import view_grid from '@widgets/trm-train-planterm/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-planterm/default-searchform/default-searchform.vue';

/**
 * 培训立项
 *
 * @export
 * @class TrmTrainPlantermGridView
 * @extends {TrmTrainPlantermGridViewBase}
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
export default class TrmTrainPlantermGridView extends TrmTrainPlantermGridViewBase { }
</script>