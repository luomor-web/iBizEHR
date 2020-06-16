<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainActapplyPickupGridViewBase from './trm-train-actapply-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-train-actapply/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-actapply/default-searchform/default-searchform.vue';

/**
 * 培训活动申请选择表格视图
 *
 * @export
 * @class TrmTrainActapplyPickupGridView
 * @extends {TrmTrainActapplyPickupGridViewBase}
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
export default class TrmTrainActapplyPickupGridView extends TrmTrainActapplyPickupGridViewBase { }
</script>