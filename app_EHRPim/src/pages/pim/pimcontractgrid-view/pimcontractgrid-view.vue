<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTGridViewBase from './pimcontractgrid-view-base.vue';

import view_grid from '@widgets/pim-contract/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-contract/default-searchform/default-searchform.vue';

/**
 * 合同信息表格视图
 *
 * @export
 * @class PIMCONTRACTGridView
 * @extends {PIMCONTRACTGridViewBase}
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
export default class PIMCONTRACTGridView extends PIMCONTRACTGridViewBase { }
</script>