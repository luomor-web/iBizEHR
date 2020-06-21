<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainTeacherWBGridViewBase from './trm-train-teacher-wbgrid-view-base.vue';

import view_grid from '@widgets/trm-train-teacher/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/trm-train-teacher/default-searchform/default-searchform.vue';

/**
 * 培训教师表格视图
 *
 * @export
 * @class TrmTrainTeacherWBGridView
 * @extends {TrmTrainTeacherWBGridViewBase}
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
export default class TrmTrainTeacherWBGridView extends TrmTrainTeacherWBGridViewBase { }
</script>