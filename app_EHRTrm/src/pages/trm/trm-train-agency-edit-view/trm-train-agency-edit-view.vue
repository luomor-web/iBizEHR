<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAgencyEditViewBase from './trm-train-agency-edit-view-base.vue';

import view_form from '@widgets/trm-train-agency/main-form/main-form.vue';

/**
 * 培训机构
 *
 * @export
 * @class TrmTrainAgencyEditView
 * @extends {TrmTrainAgencyEditViewBase}
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
export default class TrmTrainAgencyEditView extends TrmTrainAgencyEditViewBase { }
</script>