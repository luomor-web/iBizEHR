<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVALCATALOGUEPickupGridViewBase from './archivalcataloguepickup-grid-view-base.vue';

import view_grid from '@widgets/pim-archival-catalogue/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-archival-catalogue/default-searchform/default-searchform.vue';

/**
 * 档案目录选择表格视图
 *
 * @export
 * @class ARCHIVALCATALOGUEPickupGridView
 * @extends {ARCHIVALCATALOGUEPickupGridViewBase}
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
export default class ARCHIVALCATALOGUEPickupGridView extends ARCHIVALCATALOGUEPickupGridViewBase { }
</script>