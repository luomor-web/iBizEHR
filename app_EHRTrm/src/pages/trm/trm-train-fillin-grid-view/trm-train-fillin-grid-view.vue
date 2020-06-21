<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainFillinGridViewBase from './trm-train-fillin-grid-view-base.vue';

import view_grid from '@widgets/trm-train-fillin/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-fillin/default-searchform/default-searchform.vue';

/**
 * 培训需求填报
 *
 * @export
 * @class TrmTrainFillinGridView
 * @extends {TrmTrainFillinGridViewBase}
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
export default class TrmTrainFillinGridView extends TrmTrainFillinGridViewBase { }
</script>