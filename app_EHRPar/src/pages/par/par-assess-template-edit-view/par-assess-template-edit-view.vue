<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParAssessTemplateEditViewBase from './par-assess-template-edit-view-base.vue';

import view_form from '@widgets/par-assess-template/main-form/main-form.vue';

/**
 * 考核模板
 *
 * @export
 * @class ParAssessTemplateEditView
 * @extends {ParAssessTemplateEditViewBase}
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
export default class ParAssessTemplateEditView extends ParAssessTemplateEditViewBase { }
</script>