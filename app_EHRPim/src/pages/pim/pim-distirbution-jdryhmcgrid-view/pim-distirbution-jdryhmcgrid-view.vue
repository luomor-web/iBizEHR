<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionJDRYHMCGridViewBase from './pim-distirbution-jdryhmcgrid-view-base.vue';

import view_grid from '@widgets/pim-distirbution/maturity-due-grid-2-grid/maturity-due-grid-2-grid.vue';
import view_searchform from '@widgets/pim-distirbution/default-searchform/default-searchform.vue';

/**
 * 借调人员花名册
 *
 * @export
 * @class PimDistirbutionJDRYHMCGridView
 * @extends {PimDistirbutionJDRYHMCGridViewBase}
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
export default class PimDistirbutionJDRYHMCGridView extends PimDistirbutionJDRYHMCGridViewBase { }
</script>