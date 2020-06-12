<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMEducationExperienceEditViewBase from './pcmeducation-experience-edit-view-base.vue';

import view_form from '@widgets/pcm-education-experience/main-form/main-form.vue';

/**
 * 教育背景
 *
 * @export
 * @class PCMEducationExperienceEditView
 * @extends {PCMEducationExperienceEditViewBase}
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
export default class PCMEducationExperienceEditView extends PCMEducationExperienceEditViewBase { }
</script>