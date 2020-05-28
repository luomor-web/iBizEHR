<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMLABOURCAMPANYPickupGridViewBase from './pimlabourcampanypickup-grid-view-base.vue';

import view_grid from '@widgets/pimlabourcampany/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimlabourcampany/default-searchform/default-searchform.vue';

/**
 * 劳务派遣公司管理选择表格视图
 *
 * @export
 * @class PIMLABOURCAMPANYPickupGridView
 * @extends {PIMLABOURCAMPANYPickupGridViewBase}
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
export default class PIMLABOURCAMPANYPickupGridView extends PIMLABOURCAMPANYPickupGridViewBase { }
</script>