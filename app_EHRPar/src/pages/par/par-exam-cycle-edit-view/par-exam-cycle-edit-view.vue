<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParExamCycleEditViewBase from './par-exam-cycle-edit-view-base.vue';

import view_form from '@widgets/par-exam-cycle/main-form/main-form.vue';

/**
 * 考核周期
 *
 * @export
 * @class ParExamCycleEditView
 * @extends {ParExamCycleEditViewBase}
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
export default class ParExamCycleEditView extends ParExamCycleEditViewBase { }
</script>