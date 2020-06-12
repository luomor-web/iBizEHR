<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbmxXZGridViewBase from './par-ldndlhmbmx-xzgrid-view-base.vue';

import view_grid from '@widgets/par-ldndlhmbmx/ndlhmbxzmx-grid/ndlhmbxzmx-grid.vue';
import view_searchform from '@widgets/par-ldndlhmbmx/default-searchform/default-searchform.vue';

/**
 * 量化目标明细修正
 *
 * @export
 * @class ParLdndlhmbmxXZGridView
 * @extends {ParLdndlhmbmxXZGridViewBase}
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
export default class ParLdndlhmbmxXZGridView extends ParLdndlhmbmxXZGridViewBase { }
</script>