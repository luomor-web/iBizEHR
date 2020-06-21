<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmPlanFormuEditViewBase from './trm-plan-formu-edit-view-base.vue';

import view_form from '@widgets/trm-plan-formu/main-form/main-form.vue';

/**
 * 培训计划
 *
 * @export
 * @class TrmPlanFormuEditView
 * @extends {TrmPlanFormuEditViewBase}
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
export default class TrmPlanFormuEditView extends TrmPlanFormuEditViewBase { }
</script>