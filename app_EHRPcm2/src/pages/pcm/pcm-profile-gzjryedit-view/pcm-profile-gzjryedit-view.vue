<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmProfileGZJRYEditViewBase from './pcm-profile-gzjryedit-view-base.vue';

import view_form from '@widgets/pcm-profile/csrc-gzj-form/csrc-gzj-form.vue';

/**
 * 挂职进人员信息
 *
 * @export
 * @class PcmProfileGZJRYEditView
 * @extends {PcmProfileGZJRYEditViewBase}
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
export default class PcmProfileGZJRYEditView extends PcmProfileGZJRYEditViewBase { }
</script>