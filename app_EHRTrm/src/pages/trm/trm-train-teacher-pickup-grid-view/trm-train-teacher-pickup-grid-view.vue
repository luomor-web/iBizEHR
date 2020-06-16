<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainTeacherPickupGridViewBase from './trm-train-teacher-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-train-teacher/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-teacher/default-searchform/default-searchform.vue';

/**
 * 培训教师选择表格视图
 *
 * @export
 * @class TrmTrainTeacherPickupGridView
 * @extends {TrmTrainTeacherPickupGridViewBase}
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
export default class TrmTrainTeacherPickupGridView extends TrmTrainTeacherPickupGridViewBase { }
</script>