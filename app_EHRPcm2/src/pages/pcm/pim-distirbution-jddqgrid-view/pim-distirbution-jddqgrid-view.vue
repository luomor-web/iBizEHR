<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionJDDQGridViewBase from './pim-distirbution-jddqgrid-view-base.vue';

import view_grid from '@widgets/pim-distirbution/maturity-due-grid-grid/maturity-due-grid-grid.vue';
import view_searchform from '@widgets/pim-distirbution/default-searchform/default-searchform.vue';

/**
 * 借调人员
 *
 * @export
 * @class PimDistirbutionJDDQGridView
 * @extends {PimDistirbutionJDDQGridViewBase}
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
export default class PimDistirbutionJDDQGridView extends PimDistirbutionJDDQGridViewBase { }
</script>