<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEBHSPEditViewBase from './pcmprofilebhspedit-view-base.vue';

import view_form from '@widgets/pcm-profile/bhsp-form/bhsp-form.vue';

/**
 * 编号审批
 *
 * @export
 * @class PCMPROFILEBHSPEditView
 * @extends {PCMPROFILEBHSPEditViewBase}
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
export default class PCMPROFILEBHSPEditView extends PCMPROFILEBHSPEditViewBase { }
</script>