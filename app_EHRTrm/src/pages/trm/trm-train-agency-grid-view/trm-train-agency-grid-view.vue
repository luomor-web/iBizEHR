<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAgencyGridViewBase from './trm-train-agency-grid-view-base.vue';

import view_grid from '@widgets/trm-train-agency/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-agency/default-searchform/default-searchform.vue';

/**
 * 培训机构
 *
 * @export
 * @class TrmTrainAgencyGridView
 * @extends {TrmTrainAgencyGridViewBase}
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
export default class TrmTrainAgencyGridView extends TrmTrainAgencyGridViewBase { }
</script>