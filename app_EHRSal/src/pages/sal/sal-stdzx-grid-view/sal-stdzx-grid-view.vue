<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdzxGridViewBase from './sal-stdzx-grid-view-base.vue';

import view_grid from '@widgets/sal-stdzx/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-stdzx/default-searchform/default-searchform.vue';

/**
 * 专项津贴标准表格视图
 *
 * @export
 * @class SalStdzxGridView
 * @extends {SalStdzxGridViewBase}
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
export default class SalStdzxGridView extends SalStdzxGridViewBase { }
</script>