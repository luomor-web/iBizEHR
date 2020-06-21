<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainTeacherGridViewBase from './trm-train-teacher-grid-view-base.vue';

import view_grid from '@widgets/trm-train-teacher/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-teacher/default-searchform/default-searchform.vue';

/**
 * 培训教师表格视图
 *
 * @export
 * @class TrmTrainTeacherGridView
 * @extends {TrmTrainTeacherGridViewBase}
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
export default class TrmTrainTeacherGridView extends TrmTrainTeacherGridViewBase { }
</script>