<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEBHSP_CSRCYJEditViewBase from './pcmprofilebhsp-csrcyjedit-view-base.vue';

import view_form from '@widgets/pcm-profile/bhsp-csrcyj-form/bhsp-csrcyj-form.vue';

/**
 * 编号审批
 *
 * @export
 * @class PCMPROFILEBHSP_CSRCYJEditView
 * @extends {PCMPROFILEBHSP_CSRCYJEditViewBase}
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
export default class PCMPROFILEBHSP_CSRCYJEditView extends PCMPROFILEBHSP_CSRCYJEditViewBase { }
</script>