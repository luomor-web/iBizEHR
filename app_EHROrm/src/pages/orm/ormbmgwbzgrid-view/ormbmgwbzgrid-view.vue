<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMBMGWBZGridViewBase from './ormbmgwbzgrid-view-base.vue';

import view_grid from '@widgets/ormbmgwbz/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormbmgwbz/default-searchform/default-searchform.vue';

/**
 * 岗位编制明细
 *
 * @export
 * @class ORMBMGWBZGridView
 * @extends {ORMBMGWBZGridViewBase}
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
export default class ORMBMGWBZGridView extends ORMBMGWBZGridViewBase { }
</script>