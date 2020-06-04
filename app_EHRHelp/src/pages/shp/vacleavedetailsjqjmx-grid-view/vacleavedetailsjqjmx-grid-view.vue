<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEDETAILSJQJMX_GridViewBase from './vacleavedetailsjqjmx-grid-view-base.vue';

import view_grid from '@widgets/vac-leave-detail/main-grid/main-grid.vue';
import view_searchform from '@widgets/vac-leave-detail/default-searchform/default-searchform.vue';

/**
 * 请假明细
 *
 * @export
 * @class VACLEAVEDETAILSJQJMX_GridView
 * @extends {VACLEAVEDETAILSJQJMX_GridViewBase}
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
export default class VACLEAVEDETAILSJQJMX_GridView extends VACLEAVEDETAILSJQJMX_GridViewBase { }
</script>