<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSalaryBillPickupViewBase from './sal-salary-bill-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-salary-bill/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 工资单数据选择视图
 *
 * @export
 * @class SalSalaryBillPickupView
 * @extends {SalSalaryBillPickupViewBase}
 */
@Component({
    components: {
        view_pickupviewpanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class SalSalaryBillPickupView extends SalSalaryBillPickupViewBase { }
</script>