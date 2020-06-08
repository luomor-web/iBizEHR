<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMWORKHISTORYGRPimWorkGridViewBase from './pimworkhistorygrpim-work-grid-view-base.vue';

import view_grid from '@widgets/pim-work-history/main-3-grid/main-3-grid.vue';
import view_searchform from '@widgets/pim-work-history/default-searchform/default-searchform.vue';

/**
 * 工作履历表格视图
 *
 * @export
 * @class PIMWORKHISTORYGRPimWorkGridView
 * @extends {PIMWORKHISTORYGRPimWorkGridViewBase}
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
export default class PIMWORKHISTORYGRPimWorkGridView extends PIMWORKHISTORYGRPimWorkGridViewBase { }
</script>