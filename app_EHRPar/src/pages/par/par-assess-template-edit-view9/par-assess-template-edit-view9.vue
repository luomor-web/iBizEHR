<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParAssessTemplateEditView9Base from './par-assess-template-edit-view9-base.vue';

import view_form from '@widgets/par-assess-template/main2-form/main2-form.vue';

/**
 * 考核模板
 *
 * @export
 * @class ParAssessTemplateEditView9
 * @extends {ParAssessTemplateEditView9Base}
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
export default class ParAssessTemplateEditView9 extends ParAssessTemplateEditView9Base { }
</script>