<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmCourseSystemPickupGridViewBase from './trm-course-system-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-course-system/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-course-system/default-searchform/default-searchform.vue';

/**
 * 课程体系选择表格视图
 *
 * @export
 * @class TrmCourseSystemPickupGridView
 * @extends {TrmCourseSystemPickupGridViewBase}
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
export default class TrmCourseSystemPickupGridView extends TrmCourseSystemPickupGridViewBase { }
</script>