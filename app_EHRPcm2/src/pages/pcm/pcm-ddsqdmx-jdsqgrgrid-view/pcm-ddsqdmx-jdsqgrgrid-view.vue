<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxJDSQGRGridViewBase from './pcm-ddsqdmx-jdsqgrgrid-view-base.vue';

import view_grid from '@widgets/pcm-ddsqdmx/jdsqmxgr-grid/jdsqmxgr-grid.vue';
import view_searchform from '@widgets/pcm-ddsqdmx/default-searchform/default-searchform.vue';

/**
 * 借调申请
 *
 * @export
 * @class PcmDdsqdmxJDSQGRGridView
 * @extends {PcmDdsqdmxJDSQGRGridViewBase}
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
export default class PcmDdsqdmxJDSQGRGridView extends PcmDdsqdmxJDSQGRGridViewBase { }
</script>