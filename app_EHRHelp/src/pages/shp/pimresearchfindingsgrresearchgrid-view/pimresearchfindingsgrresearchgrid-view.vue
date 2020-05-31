<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMRESEARCHFINDINGSGRRESEARCHGridViewBase from './pimresearchfindingsgrresearchgrid-view-base.vue';

import view_grid from '@widgets/pim-research-findings/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pim-research-findings/default-searchform/default-searchform.vue';

/**
 * 科研成果表格视图
 *
 * @export
 * @class PIMRESEARCHFINDINGSGRRESEARCHGridView
 * @extends {PIMRESEARCHFINDINGSGRRESEARCHGridViewBase}
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
export default class PIMRESEARCHFINDINGSGRRESEARCHGridView extends PIMRESEARCHFINDINGSGRRESEARCHGridViewBase { }
</script>