<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmCourseSystemGridViewBase from './trm-course-system-grid-view-base.vue';

import view_grid from '@widgets/trm-course-system/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-course-system/default-searchform/default-searchform.vue';

/**
 * 培训模块
 *
 * @export
 * @class TrmCourseSystemGridView
 * @extends {TrmCourseSystemGridViewBase}
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
export default class TrmCourseSystemGridView extends TrmCourseSystemGridViewBase { }
</script>