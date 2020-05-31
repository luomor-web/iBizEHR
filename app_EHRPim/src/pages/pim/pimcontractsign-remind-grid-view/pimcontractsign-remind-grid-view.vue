<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTSignRemindGridViewBase from './pimcontractsign-remind-grid-view-base.vue';

import view_grid from '@widgets/pim-contract/sign-rmind-grid-grid/sign-rmind-grid-grid.vue';
import view_searchform from '@widgets/pim-contract/default-searchform/default-searchform.vue';

/**
 * 合同信息表格视图（初签/续签提醒）
 *
 * @export
 * @class PIMCONTRACTSignRemindGridView
 * @extends {PIMCONTRACTSignRemindGridViewBase}
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
export default class PIMCONTRACTSignRemindGridView extends PIMCONTRACTSignRemindGridViewBase { }
</script>