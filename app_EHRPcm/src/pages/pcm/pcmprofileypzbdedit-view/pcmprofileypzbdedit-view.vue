<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYPZBDEditViewBase from './pcmprofileypzbdedit-view-base.vue';

import view_form from '@widgets/pcm-profile/rybd-form/rybd-form.vue';

/**
 * 拟录用人员
 *
 * @export
 * @class PCMPROFILEYPZBDEditView
 * @extends {PCMPROFILEYPZBDEditViewBase}
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
export default class PCMPROFILEYPZBDEditView extends PCMPROFILEYPZBDEditViewBase { }
</script>