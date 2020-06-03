<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYRDWCS_CSRCYJEditViewBase from './pcmprofileyrdwcs-csrcyjedit-view-base.vue';

import view_form from '@widgets/pcm-profile/yrdwcs-csrcyj-form/yrdwcs-csrcyj-form.vue';

/**
 * 用人单位初审
 *
 * @export
 * @class PCMPROFILEYRDWCS_CSRCYJEditView
 * @extends {PCMPROFILEYRDWCS_CSRCYJEditViewBase}
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
export default class PCMPROFILEYRDWCS_CSRCYJEditView extends PCMPROFILEYRDWCS_CSRCYJEditViewBase { }
</script>