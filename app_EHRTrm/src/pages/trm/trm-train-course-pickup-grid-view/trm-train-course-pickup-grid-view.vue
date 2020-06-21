<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainCoursePickupGridViewBase from './trm-train-course-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-train-course/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-course/default-searchform/default-searchform.vue';

/**
 * 培训课程选择表格视图
 *
 * @export
 * @class TrmTrainCoursePickupGridView
 * @extends {TrmTrainCoursePickupGridViewBase}
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
export default class TrmTrainCoursePickupGridView extends TrmTrainCoursePickupGridViewBase { }
</script>