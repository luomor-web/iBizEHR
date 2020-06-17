<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainCourseGridViewBase from './trm-train-course-grid-view-base.vue';

import view_grid from '@widgets/trm-train-course/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-course/default-searchform/default-searchform.vue';

/**
 * 培训课程
 *
 * @export
 * @class TrmTrainCourseGridView
 * @extends {TrmTrainCourseGridViewBase}
 */
@Component({
    components: {
        view_grid, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class TrmTrainCourseGridView extends TrmTrainCourseGridViewBase { }
</script>