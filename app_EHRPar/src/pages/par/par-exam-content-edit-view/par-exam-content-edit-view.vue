<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParExamContentEditViewBase from './par-exam-content-edit-view-base.vue';

import view_form from '@widgets/par-exam-content/main-form/main-form.vue';

/**
 * 考核内容
 *
 * @export
 * @class ParExamContentEditView
 * @extends {ParExamContentEditViewBase}
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
export default class ParExamContentEditView extends ParExamContentEditViewBase { }
</script>