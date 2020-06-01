<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacHolidayRulesGridViewBase from './vac-holiday-rules-grid-view-base.vue';

import view_grid from '@widgets/vac-holiday-rules/main-grid/main-grid.vue';
import view_searchform from '@widgets/vac-holiday-rules/default-searchform/default-searchform.vue';

/**
 * 考勤规则
 *
 * @export
 * @class VacHolidayRulesGridView
 * @extends {VacHolidayRulesGridViewBase}
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
export default class VacHolidayRulesGridView extends VacHolidayRulesGridViewBase { }
</script>