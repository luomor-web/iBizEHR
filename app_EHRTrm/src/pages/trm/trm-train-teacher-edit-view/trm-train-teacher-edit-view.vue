<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainTeacherEditViewBase from './trm-train-teacher-edit-view-base.vue';

import view_form from '@widgets/trm-train-teacher/main-form/main-form.vue';

/**
 * 培训教师编辑视图
 *
 * @export
 * @class TrmTrainTeacherEditView
 * @extends {TrmTrainTeacherEditViewBase}
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
export default class TrmTrainTeacherEditView extends TrmTrainTeacherEditViewBase { }
</script>