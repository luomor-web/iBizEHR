<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxDDSQGridViewBase from './pcm-ddsqdmx-ddsqgrid-view-base.vue';

import view_grid from '@widgets/pcm-ddsqdmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ddsqdmx/default-searchform/default-searchform.vue';

/**
 * 调动申请
 *
 * @export
 * @class PcmDdsqdmxDDSQGridView
 * @extends {PcmDdsqdmxDDSQGridViewBase}
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
export default class PcmDdsqdmxDDSQGridView extends PcmDdsqdmxDDSQGridViewBase { }
</script>