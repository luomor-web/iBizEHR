<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmPlanFormuGridViewBase from './trm-plan-formu-grid-view-base.vue';

import view_grid from '@widgets/trm-plan-formu/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-plan-formu/default-searchform/default-searchform.vue';

/**
 * 计划制定
 *
 * @export
 * @class TrmPlanFormuGridView
 * @extends {TrmPlanFormuGridViewBase}
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
export default class TrmPlanFormuGridView extends TrmPlanFormuGridViewBase { }
</script>