<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLEGRPimZhicGridViewBase from './pimtitlegrpim-zhic-grid-view-base.vue';

import view_grid from '@widgets/pim-title/main-title-grid/main-title-grid.vue';
import view_searchform from '@widgets/pim-title/default-2-searchform/default-2-searchform.vue';

/**
 * 职称信息表格视图
 *
 * @export
 * @class PIMTITLEGRPimZhicGridView
 * @extends {PIMTITLEGRPimZhicGridViewBase}
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
export default class PIMTITLEGRPimZhicGridView extends PIMTITLEGRPimZhicGridViewBase { }
</script>