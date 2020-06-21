<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlanEditViewBase from './trm-train-plan-edit-view-base.vue';

import view_form from '@widgets/trm-train-plan/main-form/main-form.vue';

/**
 * 培训计划详情
 *
 * @export
 * @class TrmTrainPlanEditView
 * @extends {TrmTrainPlanEditViewBase}
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
export default class TrmTrainPlanEditView extends TrmTrainPlanEditViewBase { }
</script>