<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPAPERGrPAPERGridViewBase from './pimpapergr-papergrid-view-base.vue';

import view_grid from '@widgets/pim-paper/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pim-paper/default-searchform/default-searchform.vue';

/**
 * 论文信息表格视图
 *
 * @export
 * @class PIMPAPERGrPAPERGridView
 * @extends {PIMPAPERGrPAPERGridViewBase}
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
export default class PIMPAPERGrPAPERGridView extends PIMPAPERGrPAPERGridViewBase { }
</script>