<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLECATALOGUENotPickupGridViewBase from './pimtitlecataloguenot-pickup-grid-view-base.vue';

import view_grid from '@widgets/pim-title-catalogue/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-title-catalogue/default-searchform/default-searchform.vue';

/**
 * 职称目录管理选择表格视图
 *
 * @export
 * @class PIMTITLECATALOGUENotPickupGridView
 * @extends {PIMTITLECATALOGUENotPickupGridViewBase}
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
export default class PIMTITLECATALOGUENotPickupGridView extends PIMTITLECATALOGUENotPickupGridViewBase { }
</script>