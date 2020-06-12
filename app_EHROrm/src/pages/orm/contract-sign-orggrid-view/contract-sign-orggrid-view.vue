<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ContractSignORGGridViewBase from './contract-sign-orggrid-view-base.vue';

import view_grid from '@widgets/pim-contract-sign-org/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-contract-sign-org/default-searchform/default-searchform.vue';

/**
 * 法人主体设置
 *
 * @export
 * @class ContractSignORGGridView
 * @extends {ContractSignORGGridViewBase}
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
export default class ContractSignORGGridView extends ContractSignORGGridViewBase { }
</script>