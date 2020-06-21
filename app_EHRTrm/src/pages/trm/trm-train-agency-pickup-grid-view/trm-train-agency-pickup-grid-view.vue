<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAgencyPickupGridViewBase from './trm-train-agency-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-train-agency/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-agency/default-searchform/default-searchform.vue';

/**
 * 培训机构选择表格视图
 *
 * @export
 * @class TrmTrainAgencyPickupGridView
 * @extends {TrmTrainAgencyPickupGridViewBase}
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
export default class TrmTrainAgencyPickupGridView extends TrmTrainAgencyPickupGridViewBase { }
</script>