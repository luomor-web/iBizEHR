<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAgencyEditView9Base from './trm-train-agency-edit-view9-base.vue';

import view_form from '@widgets/trm-train-agency/main2-form/main2-form.vue';

/**
 * 培训机构编辑视图
 *
 * @export
 * @class TrmTrainAgencyEditView9
 * @extends {TrmTrainAgencyEditView9Base}
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
export default class TrmTrainAgencyEditView9 extends TrmTrainAgencyEditView9Base { }
</script>