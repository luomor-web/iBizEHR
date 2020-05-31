<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMFAMINFOPimfimGridViewBase from './pimfaminfopimfim-grid-view-base.vue';

import view_grid from '@widgets/pim-faminfo/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-faminfo/default-searchform/default-searchform.vue';

/**
 * 家庭情况表格视图
 *
 * @export
 * @class PIMFAMINFOPimfimGridView
 * @extends {PIMFAMINFOPimfimGridViewBase}
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
export default class PIMFAMINFOPimfimGridView extends PIMFAMINFOPimfimGridViewBase { }
</script>