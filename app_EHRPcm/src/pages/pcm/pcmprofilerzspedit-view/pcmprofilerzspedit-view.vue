<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERZSPEditViewBase from './pcmprofilerzspedit-view-base.vue';

import view_form from '@widgets/pcm-profile/rzsp-form/rzsp-form.vue';

/**
 * 局总部初审
 *
 * @export
 * @class PCMPROFILERZSPEditView
 * @extends {PCMPROFILERZSPEditViewBase}
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
export default class PCMPROFILERZSPEditView extends PCMPROFILERZSPEditViewBase { }
</script>