<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainCourseEditViewBase from './trm-train-course-edit-view-base.vue';

import view_form from '@widgets/trm-train-course/main-form/main-form.vue';

/**
 * 培训课程
 *
 * @export
 * @class TrmTrainCourseEditView
 * @extends {TrmTrainCourseEditViewBase}
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
export default class TrmTrainCourseEditView extends TrmTrainCourseEditViewBase { }
</script>