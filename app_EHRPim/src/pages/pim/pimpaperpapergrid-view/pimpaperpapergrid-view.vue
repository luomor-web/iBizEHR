<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPAPERPAPERGridViewBase from './pimpaperpapergrid-view-base.vue';

import view_grid from '@widgets/pim-paper/main-grid/main-grid.vue';

/**
 * 论文信息表格视图
 *
 * @export
 * @class PIMPAPERPAPERGridView
 * @extends {PIMPAPERPAPERGridViewBase}
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
export default class PIMPAPERPAPERGridView extends PIMPAPERPAPERGridViewBase { }
</script>