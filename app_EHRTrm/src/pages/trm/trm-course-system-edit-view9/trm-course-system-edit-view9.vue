<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmCourseSystemEditView9Base from './trm-course-system-edit-view9-base.vue';

import view_form from '@widgets/trm-course-system/main2-form/main2-form.vue';

/**
 * 培训模块
 *
 * @export
 * @class TrmCourseSystemEditView9
 * @extends {TrmCourseSystemEditView9Base}
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
export default class TrmCourseSystemEditView9 extends TrmCourseSystemEditView9Base { }
</script>