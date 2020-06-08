<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERZSP_CSRCYJEditViewBase from './pcmprofilerzsp-csrcyjedit-view-base.vue';

import view_form from '@widgets/pcm-profile/rzsp-csrcyj-form/rzsp-csrcyj-form.vue';

/**
 * 局总部初审
 *
 * @export
 * @class PCMPROFILERZSP_CSRCYJEditView
 * @extends {PCMPROFILERZSP_CSRCYJEditViewBase}
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
export default class PCMPROFILERZSP_CSRCYJEditView extends PCMPROFILERZSP_CSRCYJEditViewBase { }
</script>