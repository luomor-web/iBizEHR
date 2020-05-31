<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARMYCADRESGRARMYGridViewBase from './pimarmycadresgrarmygrid-view-base.vue';

import view_grid from '@widgets/pim-armycadres/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pim-armycadres/default-searchform/default-searchform.vue';

/**
 * 军转干部表格视图
 *
 * @export
 * @class PIMARMYCADRESGRARMYGridView
 * @extends {PIMARMYCADRESGRARMYGridViewBase}
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
export default class PIMARMYCADRESGRARMYGridView extends PIMARMYCADRESGRARMYGridViewBase { }
</script>