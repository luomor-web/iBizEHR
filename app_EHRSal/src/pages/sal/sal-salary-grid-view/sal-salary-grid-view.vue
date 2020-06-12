<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSalaryGridViewBase from './sal-salary-grid-view-base.vue';

import view_grid from '@widgets/sal-salary/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-salary/default-searchform/default-searchform.vue';

/**
 * 员工薪酬表格视图
 *
 * @export
 * @class SalSalaryGridView
 * @extends {SalSalaryGridViewBase}
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
export default class SalSalaryGridView extends SalSalaryGridViewBase { }
</script>