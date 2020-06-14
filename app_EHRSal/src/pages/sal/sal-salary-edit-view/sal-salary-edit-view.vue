<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSalaryEditViewBase from './sal-salary-edit-view-base.vue';

import view_form from '@widgets/sal-salary/main-form/main-form.vue';

/**
 * 员工薪酬编辑视图
 *
 * @export
 * @class SalSalaryEditView
 * @extends {SalSalaryEditViewBase}
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
export default class SalSalaryEditView extends SalSalaryEditViewBase { }
</script>