<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainTeacherWBEditViewBase from './trm-train-teacher-wbedit-view-base.vue';

import view_form from '@widgets/trm-train-teacher/main-2-form/main-2-form.vue';

/**
 * 培训教师编辑视图
 *
 * @export
 * @class TrmTrainTeacherWBEditView
 * @extends {TrmTrainTeacherWBEditViewBase}
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
export default class TrmTrainTeacherWBEditView extends TrmTrainTeacherWBEditViewBase { }
</script>