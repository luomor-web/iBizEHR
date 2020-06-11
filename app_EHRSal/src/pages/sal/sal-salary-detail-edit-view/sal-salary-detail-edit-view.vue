<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSalaryDetailEditViewBase from './sal-salary-detail-edit-view-base.vue';

import view_form from '@widgets/sal-salary-detail/main-form/main-form.vue';

/**
 * 员工薪酬明细编辑视图
 *
 * @export
 * @class SalSalaryDetailEditView
 * @extends {SalSalaryDetailEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class SalSalaryDetailEditView extends SalSalaryDetailEditViewBase { }
</script>