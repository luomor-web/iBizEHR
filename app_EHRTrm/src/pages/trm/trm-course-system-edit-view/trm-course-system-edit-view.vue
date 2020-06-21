<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmCourseSystemEditViewBase from './trm-course-system-edit-view-base.vue';

import view_form from '@widgets/trm-course-system/main-form/main-form.vue';

/**
 * 培训模块
 *
 * @export
 * @class TrmCourseSystemEditView
 * @extends {TrmCourseSystemEditViewBase}
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
export default class TrmCourseSystemEditView extends TrmCourseSystemEditViewBase { }
</script>