<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSourceGridViewBase from './sal-source-grid-view-base.vue';

import view_grid from '@widgets/sal-source/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-source/default-searchform/default-searchform.vue';

/**
 * 薪酬计算源表格视图
 *
 * @export
 * @class SalSourceGridView
 * @extends {SalSourceGridViewBase}
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
export default class SalSourceGridView extends SalSourceGridViewBase { }
</script>