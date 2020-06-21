<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainActmentGridViewBase from './trm-train-actment-grid-view-base.vue';

import view_grid from '@widgets/trm-train-actment/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-actment/default-searchform/default-searchform.vue';

/**
 * 培训后评估表格视图
 *
 * @export
 * @class TrmTrainActmentGridView
 * @extends {TrmTrainActmentGridViewBase}
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
export default class TrmTrainActmentGridView extends TrmTrainActmentGridViewBase { }
</script>