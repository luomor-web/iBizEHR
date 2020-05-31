<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPATENTGRPATENTGridViewBase from './pimpatentgrpatentgrid-view-base.vue';

import view_grid from '@widgets/pim-patent/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pim-patent/default-searchform/default-searchform.vue';

/**
 * 专利信息表格视图
 *
 * @export
 * @class PIMPATENTGRPATENTGridView
 * @extends {PIMPATENTGRPATENTGridViewBase}
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
export default class PIMPATENTGRPATENTGridView extends PIMPATENTGRPATENTGridViewBase { }
</script>