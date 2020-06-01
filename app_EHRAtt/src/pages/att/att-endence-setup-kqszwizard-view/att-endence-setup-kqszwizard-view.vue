<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceSetupKQSZWizardViewBase from './att-endence-setup-kqszwizard-view-base.vue';

import view_wizardpanel from '@widgets/att-endence-setup/kqszxd-wizardpanel/kqszxd-wizardpanel.vue';

/**
 * 考勤设置向导视图
 *
 * @export
 * @class AttEndenceSetupKQSZWizardView
 * @extends {AttEndenceSetupKQSZWizardViewBase}
 */
@Component({
    components: {
        view_wizardpanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class AttEndenceSetupKQSZWizardView extends AttEndenceSetupKQSZWizardViewBase { }
</script>