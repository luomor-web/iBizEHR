<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMDISTIRBUTIONGRPImFenpGridViewBase from './pimdistirbutiongrpim-fenp-grid-view-base.vue';

import view_grid from '@widgets/pim-distirbution/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-distirbution/default-searchform/default-searchform.vue';

/**
 * 分配信息表格视图
 *
 * @export
 * @class PIMDISTIRBUTIONGRPImFenpGridView
 * @extends {PIMDISTIRBUTIONGRPImFenpGridViewBase}
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
export default class PIMDISTIRBUTIONGRPImFenpGridView extends PIMDISTIRBUTIONGRPImFenpGridViewBase { }
</script>