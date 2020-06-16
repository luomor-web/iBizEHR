<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPersonGridViewBase from './trm-train-person-grid-view-base.vue';

import view_grid from '@widgets/trm-train-person/main-grid/main-grid.vue';

/**
 * 培训记录表格视图
 *
 * @export
 * @class TrmTrainPersonGridView
 * @extends {TrmTrainPersonGridViewBase}
 */
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class TrmTrainPersonGridView extends TrmTrainPersonGridViewBase { }
</script>