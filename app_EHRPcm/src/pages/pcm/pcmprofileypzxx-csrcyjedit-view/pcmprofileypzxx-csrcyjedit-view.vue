<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYPZXX_CSRCYJEditViewBase from './pcmprofileypzxx-csrcyjedit-view-base.vue';

import view_form from '@widgets/pcm-profile/ypzxx-csrcyj-form/ypzxx-csrcyj-form.vue';

/**
 * 应聘者信息
 *
 * @export
 * @class PCMPROFILEYPZXX_CSRCYJEditView
 * @extends {PCMPROFILEYPZXX_CSRCYJEditViewBase}
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
export default class PCMPROFILEYPZXX_CSRCYJEditView extends PCMPROFILEYPZXX_CSRCYJEditViewBase { }
</script>