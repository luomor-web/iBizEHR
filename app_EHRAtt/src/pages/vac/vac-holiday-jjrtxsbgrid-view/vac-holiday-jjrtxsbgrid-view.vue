<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacHolidayJJRTXSBGridViewBase from './vac-holiday-jjrtxsbgrid-view-base.vue';

import view_grid from '@widgets/vac-holiday/main-grid/main-grid.vue';

/**
 * 节假日/调休上班
 *
 * @export
 * @class VacHolidayJJRTXSBGridView
 * @extends {VacHolidayJJRTXSBGridViewBase}
 */
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class VacHolidayJJRTXSBGridView extends VacHolidayJJRTXSBGridViewBase { }
</script>