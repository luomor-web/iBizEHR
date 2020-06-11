<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSalaryBillPickupGridViewBase from './sal-salary-bill-pickup-grid-view-base.vue';

import view_grid from '@widgets/sal-salary-bill/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-salary-bill/default-searchform/default-searchform.vue';

/**
 * 工资单选择表格视图
 *
 * @export
 * @class SalSalaryBillPickupGridView
 * @extends {SalSalaryBillPickupGridViewBase}
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
export default class SalSalaryBillPickupGridView extends SalSalaryBillPickupGridViewBase { }
</script>