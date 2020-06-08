<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveDetailGridViewBase from './vac-leave-detail-grid-view-base.vue';

import view_grid from '@widgets/vac-leave-detail/main-grid/main-grid.vue';
import view_searchform from '@widgets/vac-leave-detail/default-searchform/default-searchform.vue';

/**
 * 请销假明细表格视图
 *
 * @export
 * @class VacLeaveDetailGridView
 * @extends {VacLeaveDetailGridViewBase}
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
export default class VacLeaveDetailGridView extends VacLeaveDetailGridViewBase { }
</script>