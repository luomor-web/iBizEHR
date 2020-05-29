<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMDISTIRBUTIONYGFenPeiGridViewBase from './pimdistirbutionygfen-pei-grid-view-base.vue';

import view_grid from '@widgets/pim-distirbution/fpxx-grid/fpxx-grid.vue';
import view_searchform from '@widgets/pim-distirbution/default-searchform/default-searchform.vue';

/**
 * 分配信息表格视图
 *
 * @export
 * @class PIMDISTIRBUTIONYGFenPeiGridView
 * @extends {PIMDISTIRBUTIONYGFenPeiGridViewBase}
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
export default class PIMDISTIRBUTIONYGFenPeiGridView extends PIMDISTIRBUTIONYGFenPeiGridViewBase { }
</script>