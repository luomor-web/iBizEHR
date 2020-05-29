<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTWSSGridViewBase from './pimcontractwssgrid-view-base.vue';

import view_grid from '@widgets/pim-contract/main-3-grid/main-3-grid.vue';

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
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMCONTRACTWSSGridView extends PIMCONTRACTWSSGridViewBase { }
</script>