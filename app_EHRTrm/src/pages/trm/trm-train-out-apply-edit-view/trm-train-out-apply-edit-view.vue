<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainOutApplyEditViewBase from './trm-train-out-apply-edit-view-base.vue';

import view_form from '@widgets/trm-train-out-apply/main-form/main-form.vue';

/**
 * 外出培训申请
 *
 * @export
 * @class TrmTrainOutApplyEditView
 * @extends {TrmTrainOutApplyEditViewBase}
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
export default class TrmTrainOutApplyEditView extends TrmTrainOutApplyEditViewBase { }
</script>