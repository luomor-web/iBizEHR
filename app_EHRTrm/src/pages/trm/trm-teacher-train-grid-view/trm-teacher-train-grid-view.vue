<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTeacherTrainGridViewBase from './trm-teacher-train-grid-view-base.vue';

import view_grid from '@widgets/trm-teacher-train/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-teacher-train/default-searchform/default-searchform.vue';

/**
 * 讲师授课记录表格视图
 *
 * @export
 * @class TrmTeacherTrainGridView
 * @extends {TrmTeacherTrainGridViewBase}
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
export default class TrmTeacherTrainGridView extends TrmTeacherTrainGridViewBase { }
</script>