<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPAPERPAPERGridViewBase from './pimpaperpapergrid-view-base.vue';

import view_grid from '@widgets/pimpaper/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimpaper/default-searchform/default-searchform.vue';

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
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMPAPERPAPERGridView extends PIMPAPERPAPERGridViewBase { }
</script>