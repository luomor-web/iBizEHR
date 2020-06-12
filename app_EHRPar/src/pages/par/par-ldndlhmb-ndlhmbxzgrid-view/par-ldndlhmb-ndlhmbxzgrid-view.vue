<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbNDLHMBXZGridViewBase from './par-ldndlhmb-ndlhmbxzgrid-view-base.vue';

import view_grid from '@widgets/par-ldndlhmb/ndlhmbxz-grid/ndlhmbxz-grid.vue';
import view_searchform from '@widgets/par-ldndlhmb/default-searchform/default-searchform.vue';

/**
 * 量化目标修正
 *
 * @export
 * @class ParLdndlhmbNDLHMBXZGridView
 * @extends {ParLdndlhmbNDLHMBXZGridViewBase}
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
export default class ParLdndlhmbNDLHMBXZGridView extends ParLdndlhmbNDLHMBXZGridViewBase { }
</script>