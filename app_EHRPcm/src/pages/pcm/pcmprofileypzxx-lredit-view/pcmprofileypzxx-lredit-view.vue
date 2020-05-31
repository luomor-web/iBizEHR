<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYPZXX_LREditViewBase from './pcmprofileypzxx-lredit-view-base.vue';

import view_form from '@widgets/pcm-profile/ypzxx-lr-form/ypzxx-lr-form.vue';

/**
 * 应聘者信息
 *
 * @export
 * @class PCMPROFILEYPZXX_LREditView
 * @extends {PCMPROFILEYPZXX_LREditViewBase}
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
export default class PCMPROFILEYPZXX_LREditView extends PCMPROFILEYPZXX_LREditViewBase { }
</script>