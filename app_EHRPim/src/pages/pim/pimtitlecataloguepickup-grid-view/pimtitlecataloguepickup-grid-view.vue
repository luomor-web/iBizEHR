<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLECATALOGUEPickupGridViewBase from './pimtitlecataloguepickup-grid-view-base.vue';

import view_grid from '@widgets/pimtitlecatalogue/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimtitlecatalogue/default-searchform/default-searchform.vue';

/**
 * 职称目录管理选择表格视图
 *
 * @export
 * @class PIMTITLECATALOGUEPickupGridView
 * @extends {PIMTITLECATALOGUEPickupGridViewBase}
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
export default class PIMTITLECATALOGUEPickupGridView extends PIMTITLECATALOGUEPickupGridViewBase { }
</script>