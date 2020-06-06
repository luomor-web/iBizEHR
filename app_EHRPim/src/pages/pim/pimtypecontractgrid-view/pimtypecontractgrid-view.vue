<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTYPECONTRACTGridViewBase from './pimtypecontractgrid-view-base.vue';

import view_grid from '@widgets/pim-type-contract/main-grid/main-grid.vue';

/**
 * 合同类型表格视图
 *
 * @export
 * @class PIMTYPECONTRACTGridView
 * @extends {PIMTYPECONTRACTGridViewBase}
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
export default class PIMTYPECONTRACTGridView extends PIMTYPECONTRACTGridViewBase { }
</script>