<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMWORKHISTORYPimWorkGridViewBase from './pimworkhistorypim-work-grid-view-base.vue';

import view_grid from '@widgets/pim-work-history/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-work-history/default-searchform/default-searchform.vue';

/**
 * 工作履历表格视图
 *
 * @export
 * @class PIMWORKHISTORYPimWorkGridView
 * @extends {PIMWORKHISTORYPimWorkGridViewBase}
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
export default class PIMWORKHISTORYPimWorkGridView extends PIMWORKHISTORYPimWorkGridViewBase { }
</script>