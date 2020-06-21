<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlanFEditViewBase from './trm-train-plan-fedit-view-base.vue';

import view_form from '@widgets/trm-train-plan/main2-form/main2-form.vue';

/**
 * 培训计划
 *
 * @export
 * @class TrmTrainPlanFEditView
 * @extends {TrmTrainPlanFEditViewBase}
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
export default class TrmTrainPlanFEditView extends TrmTrainPlanFEditViewBase { }
</script>