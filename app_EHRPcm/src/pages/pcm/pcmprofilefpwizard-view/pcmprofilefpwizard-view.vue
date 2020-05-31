<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEFPWizardViewBase from './pcmprofilefpwizard-view-base.vue';

import view_wizardpanel from '@widgets/pcm-profile/xd-fp-wizardpanel/xd-fp-wizardpanel.vue';

/**
 * 返聘应聘者信息录入向导
 *
 * @export
 * @class PCMPROFILEFPWizardView
 * @extends {PCMPROFILEFPWizardViewBase}
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
export default class PCMPROFILEFPWizardView extends PCMPROFILEFPWizardViewBase { }
</script>