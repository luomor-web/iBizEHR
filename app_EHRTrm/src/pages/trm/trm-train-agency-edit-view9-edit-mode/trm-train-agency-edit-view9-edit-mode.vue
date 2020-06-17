<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAgencyEditView9_EditModeBase from './trm-train-agency-edit-view9-edit-mode-base.vue';

import view_form from '@widgets/trm-train-agency/main-form/main-form.vue';

/**
 * 培训机构
 *
 * @export
 * @class TrmTrainAgencyEditView9_EditMode
 * @extends {TrmTrainAgencyEditView9_EditModeBase}
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
export default class TrmTrainAgencyEditView9_EditMode extends TrmTrainAgencyEditView9_EditModeBase { }
</script>