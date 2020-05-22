<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESGRPimDangaGridViewBase from './pimarchivesgrpim-danga-grid-view-base.vue';

import view_grid from '@widgets/pimarchives/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pimarchives/default-searchform/default-searchform.vue';

/**
 * 档案信息表格视图
 *
 * @export
 * @class PIMARCHIVESGRPimDangaGridView
 * @extends {PIMARCHIVESGRPimDangaGridViewBase}
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
export default class PIMARCHIVESGRPimDangaGridView extends PIMARCHIVESGRPimDangaGridViewBase { }
</script>