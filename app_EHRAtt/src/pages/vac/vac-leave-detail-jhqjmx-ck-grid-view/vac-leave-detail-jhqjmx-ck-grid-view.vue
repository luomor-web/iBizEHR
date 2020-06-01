<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveDetailJHQJMX_CK_GridViewBase from './vac-leave-detail-jhqjmx-ck-grid-view-base.vue';

import view_grid from '@widgets/vac-leave-detail/ck-grid/ck-grid.vue';
import view_searchform from '@widgets/vac-leave-detail/default-searchform/default-searchform.vue';

/**
 * 请假明细
 *
 * @export
 * @class VacLeaveDetailJHQJMX_CK_GridView
 * @extends {VacLeaveDetailJHQJMX_CK_GridViewBase}
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
export default class VacLeaveDetailJHQJMX_CK_GridView extends VacLeaveDetailJHQJMX_CK_GridViewBase { }
</script>