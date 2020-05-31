<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERLSB_CSRCYJEditViewBase from './pcmprofilerlsb-csrcyjedit-view-base.vue';

import view_form from '@widgets/pcm-profile/rlsb-csrcyj-form/rlsb-csrcyj-form.vue';

/**
 * 人力上报
 *
 * @export
 * @class PCMPROFILERLSB_CSRCYJEditView
 * @extends {PCMPROFILERLSB_CSRCYJEditViewBase}
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
export default class PCMPROFILERLSB_CSRCYJEditView extends PCMPROFILERLSB_CSRCYJEditViewBase { }
</script>