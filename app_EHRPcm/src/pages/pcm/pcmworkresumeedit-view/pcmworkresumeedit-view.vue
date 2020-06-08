<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMWORKRESUMEEditViewBase from './pcmworkresumeedit-view-base.vue';

import view_form from '@widgets/pcm-work-resume/main-form/main-form.vue';

/**
 * 工作履历
 *
 * @export
 * @class PCMWORKRESUMEEditView
 * @extends {PCMWORKRESUMEEditViewBase}
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
export default class PCMWORKRESUMEEditView extends PCMWORKRESUMEEditViewBase { }
</script>