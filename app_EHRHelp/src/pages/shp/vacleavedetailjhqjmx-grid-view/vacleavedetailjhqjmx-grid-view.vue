<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEDETAILJHQJMX_GridViewBase from './vacleavedetailjhqjmx-grid-view-base.vue';

import view_grid from '@widgets/vacleavedetail/main-grid/main-grid.vue';
import view_searchform from '@widgets/vacleavedetail/default-searchform/default-searchform.vue';

/**
 * 请假明细
 *
 * @export
 * @class VACLEAVEDETAILJHQJMX_GridView
 * @extends {VACLEAVEDETAILJHQJMX_GridViewBase}
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
export default class VACLEAVEDETAILJHQJMX_GridView extends VACLEAVEDETAILJHQJMX_GridViewBase { }
</script>