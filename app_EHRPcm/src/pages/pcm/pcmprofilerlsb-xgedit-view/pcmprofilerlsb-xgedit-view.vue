<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERLSB_XGEditViewBase from './pcmprofilerlsb-xgedit-view-base.vue';

import view_form from '@widgets/pcm-profile/ypzxx-lr-form/ypzxx-lr-form.vue';

/**
 * 人力上报
 *
 * @export
 * @class PCMPROFILERLSB_XGEditView
 * @extends {PCMPROFILERLSB_XGEditViewBase}
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
export default class PCMPROFILERLSB_XGEditView extends PCMPROFILERLSB_XGEditViewBase { }
</script>