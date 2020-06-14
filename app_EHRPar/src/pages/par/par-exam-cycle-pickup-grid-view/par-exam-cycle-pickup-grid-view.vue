<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParExamCyclePickupGridViewBase from './par-exam-cycle-pickup-grid-view-base.vue';

import view_grid from '@widgets/par-exam-cycle/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-exam-cycle/default-searchform/default-searchform.vue';

/**
 * 考核周期选择表格视图
 *
 * @export
 * @class ParExamCyclePickupGridView
 * @extends {ParExamCyclePickupGridViewBase}
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
export default class ParExamCyclePickupGridView extends ParExamCyclePickupGridViewBase { }
</script>