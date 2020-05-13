<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESLOANANDRETURNGridViewBase from './pimarchivesloanandreturngrid-view-base.vue';

import view_grid from '@widgets/pimarchivesloanandreturn/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimarchivesloanandreturn/default-searchform/default-searchform.vue';

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
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMARCHIVESLOANANDRETURNGridView extends PIMARCHIVESLOANANDRETURNGridViewBase { }
</script>