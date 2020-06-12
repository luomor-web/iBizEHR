<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalPlanGridViewBase from './sal-plan-grid-view-base.vue';

import view_grid from '@widgets/sal-plan/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-plan/default-searchform/default-searchform.vue';

/**
 * 薪酬计算计划表格视图
 *
 * @export
 * @class SalPlanGridView
 * @extends {SalPlanGridViewBase}
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
export default class SalPlanGridView extends SalPlanGridViewBase { }
</script>