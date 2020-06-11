<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalPlanEditViewBase from './sal-plan-edit-view-base.vue';

import view_form from '@widgets/sal-plan/main-form/main-form.vue';

/**
 * 薪酬计算计划编辑视图
 *
 * @export
 * @class SalPlanEditView
 * @extends {SalPlanEditViewBase}
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
export default class SalPlanEditView extends SalPlanEditViewBase { }
</script>