<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARMYCADRESARMYGridViewBase from './pimarmycadresarmygrid-view-base.vue';

import view_grid from '@widgets/pimarmycadres/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimarmycadres/default-searchform/default-searchform.vue';

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
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMARMYCADRESARMYGridView extends PIMARMYCADRESARMYGridViewBase { }
</script>