<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMRCXLPickupGridViewBase from './pcmrcxlpickup-grid-view-base.vue';

import view_grid from '@widgets/pcmrcxl/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcmrcxl/default-searchform/default-searchform.vue';

/**
 * 人才序列选择表格视图
 *
 * @export
 * @class PCMRCXLPickupGridView
 * @extends {PCMRCXLPickupGridViewBase}
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
export default class PCMRCXLPickupGridView extends PCMRCXLPickupGridViewBase { }
</script>