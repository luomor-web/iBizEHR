<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMLABOURCAMPANYGridViewBase from './pimlabourcampanygrid-view-base.vue';

import view_grid from '@widgets/pim-labourcampany/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-labourcampany/default-searchform/default-searchform.vue';

/**
 * 劳务派遣公司表格视图
 *
 * @export
 * @class PIMLABOURCAMPANYGridView
 * @extends {PIMLABOURCAMPANYGridViewBase}
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
export default class PIMLABOURCAMPANYGridView extends PIMLABOURCAMPANYGridViewBase { }
</script>