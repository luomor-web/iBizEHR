<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILESZWizardViewBase from './pcmprofileszwizard-view-base.vue';

import view_wizardpanel from '@widgets/pcm-profile/xd-sz-wizardpanel/xd-sz-wizardpanel.vue';

/**
 * 社招应聘者信息录入向导
 *
 * @export
 * @class PCMPROFILESZWizardView
 * @extends {PCMPROFILESZWizardViewBase}
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
export default class PCMPROFILESZWizardView extends PCMPROFILESZWizardViewBase { }
</script>