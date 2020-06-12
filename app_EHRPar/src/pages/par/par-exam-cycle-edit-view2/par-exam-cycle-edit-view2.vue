<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParExamCycleEditView2Base from './par-exam-cycle-edit-view2-base.vue';

import view_form from '@widgets/par-exam-cycle/main-form/main-form.vue';
import view_drbar from '@widgets/par-exam-cycle/default-drbar/default-drbar.vue';

/**
 * 考核周期编辑视图
 *
 * @export
 * @class ParExamCycleEditView2
 * @extends {ParExamCycleEditView2Base}
 */
@Component({
    components: {
        view_form, 
        view_drbar, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ParExamCycleEditView2 extends ParExamCycleEditView2Base { }
</script>