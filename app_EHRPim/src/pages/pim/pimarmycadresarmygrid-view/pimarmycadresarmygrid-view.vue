<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARMYCADRESARMYGridViewBase from './pimarmycadresarmygrid-view-base.vue';

import view_grid from '@widgets/pim-armycadres/main-grid/main-grid.vue';

/**
 * 军转干部表格视图
 *
 * @export
 * @class PIMARMYCADRESARMYGridView
 * @extends {PIMARMYCADRESARMYGridViewBase}
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
export default class PIMARMYCADRESARMYGridView extends PIMARMYCADRESARMYGridViewBase { }
</script>