<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalTypeGridViewBase from './sal-type-grid-view-base.vue';

import view_grid from '@widgets/sal-type/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-type/default-searchform/default-searchform.vue';

/**
 * 薪酬类型表格视图
 *
 * @export
 * @class SalTypeGridView
 * @extends {SalTypeGridViewBase}
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
export default class SalTypeGridView extends SalTypeGridViewBase { }
</script>