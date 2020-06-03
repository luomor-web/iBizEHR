<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEXZWizardViewBase from './pcmprofilexzwizard-view-base.vue';

import view_wizardpanel from '@widgets/pcm-profile/xd-xz-wizardpanel/xd-xz-wizardpanel.vue';

/**
 * 校招应聘者信息录入向导
 *
 * @export
 * @class PCMPROFILEXZWizardView
 * @extends {PCMPROFILEXZWizardViewBase}
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
export default class PCMPROFILEXZWizardView extends PCMPROFILEXZWizardViewBase { }
</script>