<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYPZBD_CSRCYJEditViewBase from './pcmprofileypzbd-csrcyjedit-view-base.vue';

import view_form from '@widgets/pcm-profile/rybd-csrcyj-form/rybd-csrcyj-form.vue';

/**
 * 拟录用人员
 *
 * @export
 * @class PCMPROFILEYPZBD_CSRCYJEditView
 * @extends {PCMPROFILEYPZBD_CSRCYJEditViewBase}
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
export default class PCMPROFILEYPZBD_CSRCYJEditView extends PCMPROFILEYPZBD_CSRCYJEditViewBase { }
</script>