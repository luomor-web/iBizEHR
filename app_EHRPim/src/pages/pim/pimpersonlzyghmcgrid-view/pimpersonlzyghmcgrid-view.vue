<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONLZYGHMCGridViewBase from './pimpersonlzyghmcgrid-view-base.vue';

import view_grid from '@widgets/pim-person/txlxyg-2-grid/txlxyg-2-grid.vue';
import view_searchform from '@widgets/pim-person/default-searchform/default-searchform.vue';

/**
 * 离职员工
 *
 * @export
 * @class PIMPERSONLZYGHMCGridView
 * @extends {PIMPERSONLZYGHMCGridViewBase}
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
export default class PIMPERSONLZYGHMCGridView extends PIMPERSONLZYGHMCGridViewBase { }
</script>