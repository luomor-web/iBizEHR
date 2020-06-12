<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdglGridViewBase from './sal-stdgl-grid-view-base.vue';

import view_grid from '@widgets/sal-stdgl/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-stdgl/default-searchform/default-searchform.vue';

/**
 * 工龄工资标准表格视图
 *
 * @export
 * @class SalStdglGridView
 * @extends {SalStdglGridViewBase}
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
export default class SalStdglGridView extends SalStdglGridViewBase { }
</script>