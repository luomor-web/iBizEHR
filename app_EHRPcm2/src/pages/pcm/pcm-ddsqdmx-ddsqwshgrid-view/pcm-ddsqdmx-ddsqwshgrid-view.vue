<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxDDSQWSHGridViewBase from './pcm-ddsqdmx-ddsqwshgrid-view-base.vue';

import view_grid from '@widgets/pcm-ddsqdmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ddsqdmx/default-searchform/default-searchform.vue';

/**
 * 调动查看
 *
 * @export
 * @class PcmDdsqdmxDDSQWSHGridView
 * @extends {PcmDdsqdmxDDSQWSHGridViewBase}
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
export default class PcmDdsqdmxDDSQWSHGridView extends PcmDdsqdmxDDSQWSHGridViewBase { }
</script>