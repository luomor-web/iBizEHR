<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTLWGridViewBase from './pimcontractlwgrid-view-base.vue';

import view_grid from '@widgets/pim-contract/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pim-contract/default-searchform/default-searchform.vue';

/**
 * 劳务合同管理表格视图
 *
 * @export
 * @class PIMCONTRACTLWGridView
 * @extends {PIMCONTRACTLWGridViewBase}
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
export default class PIMCONTRACTLWGridView extends PIMCONTRACTLWGridViewBase { }
</script>