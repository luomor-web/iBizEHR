<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEQTZPWizardViewBase from './pcmprofileqtzpwizard-view-base.vue';

import view_wizardpanel from '@widgets/pcm-profile/xd-qtzp-wizardpanel/xd-qtzp-wizardpanel.vue';

/**
 * 其他招聘应聘者信息录入向导
 *
 * @export
 * @class PCMPROFILEQTZPWizardView
 * @extends {PCMPROFILEQTZPWizardViewBase}
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
export default class PCMPROFILEQTZPWizardView extends PCMPROFILEQTZPWizardViewBase { }
</script>