<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainCourseEditView9Base from './trm-train-course-edit-view9-base.vue';

import view_form from '@widgets/trm-train-course/main2-form/main2-form.vue';

/**
 * 培训课程
 *
 * @export
 * @class TrmTrainCourseEditView9
 * @extends {TrmTrainCourseEditView9Base}
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
export default class TrmTrainCourseEditView9 extends TrmTrainCourseEditView9Base { }
</script>