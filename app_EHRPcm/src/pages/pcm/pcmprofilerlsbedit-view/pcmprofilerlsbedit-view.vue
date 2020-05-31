<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERLSBEditViewBase from './pcmprofilerlsbedit-view-base.vue';

import view_form from '@widgets/pcm-profile/rlsb-form/rlsb-form.vue';

/**
 * 人力上报
 *
 * @export
 * @class PCMPROFILERLSBEditView
 * @extends {PCMPROFILERLSBEditViewBase}
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
export default class PCMPROFILERLSBEditView extends PCMPROFILERLSBEditViewBase { }
</script>