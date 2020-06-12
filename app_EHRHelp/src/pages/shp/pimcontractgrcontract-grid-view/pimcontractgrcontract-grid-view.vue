<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTGRContractGridViewBase from './pimcontractgrcontract-grid-view-base.vue';

import view_grid from '@widgets/pim-contract/main-3-grid/main-3-grid.vue';
import view_searchform from '@widgets/pim-contract/default-searchform/default-searchform.vue';

/**
 * 合同信息表格视图
 *
 * @export
 * @class PIMCONTRACTGRContractGridView
 * @extends {PIMCONTRACTGRContractGridViewBase}
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
export default class PIMCONTRACTGRContractGridView extends PIMCONTRACTGRContractGridViewBase { }
</script>