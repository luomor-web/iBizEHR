<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMRESEARCHFINDINGSRESEARCHGridViewBase from './pimresearchfindingsresearchgrid-view-base.vue';

import view_grid from '@widgets/pim-research-findings/main-grid/main-grid.vue';

/**
 * 科研成果表格视图
 *
 * @export
 * @class PIMRESEARCHFINDINGSRESEARCHGridView
 * @extends {PIMRESEARCHFINDINGSRESEARCHGridViewBase}
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
export default class PIMRESEARCHFINDINGSRESEARCHGridView extends PIMRESEARCHFINDINGSRESEARCHGridViewBase { }
</script>