<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESLOANANDRETURNGridViewBase from './pimarchivesloanandreturngrid-view-base.vue';

import view_grid from '@widgets/pim-archive-sloanandreturn/main-grid/main-grid.vue';

/**
 * 借阅记录表格视图
 *
 * @export
 * @class PIMARCHIVESLOANANDRETURNGridView
 * @extends {PIMARCHIVESLOANANDRETURNGridViewBase}
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
export default class PIMARCHIVESLOANANDRETURNGridView extends PIMARCHIVESLOANANDRETURNGridViewBase { }
</script>