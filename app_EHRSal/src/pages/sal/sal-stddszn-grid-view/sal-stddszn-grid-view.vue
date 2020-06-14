<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStddsznGridViewBase from './sal-stddszn-grid-view-base.vue';

import view_grid from '@widgets/sal-stddszn/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-stddszn/default-searchform/default-searchform.vue';

/**
 * 独生子女标准表格视图
 *
 * @export
 * @class SalStddsznGridView
 * @extends {SalStddsznGridViewBase}
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
export default class SalStddsznGridView extends SalStddsznGridViewBase { }
</script>