<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEZPDWSHEditViewBase from './pcmprofilezpdwshedit-view-base.vue';

import view_form from '@widgets/pcm-profile/zpdwsh-form/zpdwsh-form.vue';

/**
 * 用人单位初审
 *
 * @export
 * @class PCMPROFILEZPDWSHEditView
 * @extends {PCMPROFILEZPDWSHEditViewBase}
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
export default class PCMPROFILEZPDWSHEditView extends PCMPROFILEZPDWSHEditViewBase { }
</script>