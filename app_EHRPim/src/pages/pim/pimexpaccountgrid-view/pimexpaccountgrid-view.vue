<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXPACCOUNTGridViewBase from './pimexpaccountgrid-view-base.vue';

import view_grid from '@widgets/pim-expaccount/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-expaccount/default-searchform/default-searchform.vue';

/**
 * 费用台账表格视图
 *
 * @export
 * @class PIMEXPACCOUNTGridView
 * @extends {PIMEXPACCOUNTGridViewBase}
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
export default class PIMEXPACCOUNTGridView extends PIMEXPACCOUNTGridViewBase { }
</script>