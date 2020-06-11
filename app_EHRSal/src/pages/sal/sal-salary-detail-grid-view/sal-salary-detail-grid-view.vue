<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSalaryDetailGridViewBase from './sal-salary-detail-grid-view-base.vue';

import view_grid from '@widgets/sal-salary-detail/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-salary-detail/default-searchform/default-searchform.vue';

/**
 * 员工薪酬明细表格视图
 *
 * @export
 * @class SalSalaryDetailGridView
 * @extends {SalSalaryDetailGridViewBase}
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
export default class SalSalaryDetailGridView extends SalSalaryDetailGridViewBase { }
</script>