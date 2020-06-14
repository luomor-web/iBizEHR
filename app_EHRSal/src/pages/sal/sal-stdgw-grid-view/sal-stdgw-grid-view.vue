<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdgwGridViewBase from './sal-stdgw-grid-view-base.vue';

import view_grid from '@widgets/sal-stdgw/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-stdgw/default-searchform/default-searchform.vue';

/**
 * 高温津贴标准表格视图
 *
 * @export
 * @class SalStdgwGridView
 * @extends {SalStdgwGridViewBase}
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
export default class SalStdgwGridView extends SalStdgwGridViewBase { }
</script>