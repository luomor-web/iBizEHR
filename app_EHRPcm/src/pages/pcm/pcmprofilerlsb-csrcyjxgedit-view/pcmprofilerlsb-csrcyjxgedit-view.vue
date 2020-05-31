<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERLSB_CSRCYJXGEditViewBase from './pcmprofilerlsb-csrcyjxgedit-view-base.vue';

import view_form from '@widgets/pcm-profile/ypzxx-csrcyj-form/ypzxx-csrcyj-form.vue';

/**
 * 人力上报
 *
 * @export
 * @class PCMPROFILERLSB_CSRCYJXGEditView
 * @extends {PCMPROFILERLSB_CSRCYJXGEditViewBase}
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
export default class PCMPROFILERLSB_CSRCYJXGEditView extends PCMPROFILERLSB_CSRCYJXGEditViewBase { }
</script>