<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxLGSQMXGridViewBase from './pcm-ddsqdmx-lgsqmxgrid-view-base.vue';

import view_grid from '@widgets/pcm-ddsqdmx/lgsqmx-grid/lgsqmx-grid.vue';
import view_searchform from '@widgets/pcm-ddsqdmx/default-searchform/default-searchform.vue';

/**
 * 轮岗申请明细
 *
 * @export
 * @class PcmDdsqdmxLGSQMXGridView
 * @extends {PcmDdsqdmxLGSQMXGridViewBase}
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
export default class PcmDdsqdmxLGSQMXGridView extends PcmDdsqdmxLGSQMXGridViewBase { }
</script>