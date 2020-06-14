<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParExamContentEditView9Base from './par-exam-content-edit-view9-base.vue';

import view_form from '@widgets/par-exam-content/main2-form/main2-form.vue';

/**
 * 考核内容
 *
 * @export
 * @class ParExamContentEditView9
 * @extends {ParExamContentEditView9Base}
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
export default class ParExamContentEditView9 extends ParExamContentEditView9Base { }
</script>