<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTWSSGridViewBase from './pimcontractwssgrid-view-base.vue';

import view_grid from '@widgets/pimcontract/main-3-grid/main-3-grid.vue';
import view_searchform from '@widgets/pimcontract/default-searchform/default-searchform.vue';

/**
 * 合同信息表格视图
 *
 * @export
 * @class PIMCONTRACTWSSGridView
 * @extends {PIMCONTRACTWSSGridViewBase}
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
export default class PIMCONTRACTWSSGridView extends PIMCONTRACTWSSGridViewBase { }
</script>