<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxJDSQWSHGridViewBase from './pcm-ddsqdmx-jdsqwshgrid-view-base.vue';

import view_grid from '@widgets/pcm-ddsqdmx/jdsqmx-grid/jdsqmx-grid.vue';
import view_searchform from '@widgets/pcm-ddsqdmx/default-searchform/default-searchform.vue';

/**
 * 借调查看
 *
 * @export
 * @class PcmDdsqdmxJDSQWSHGridView
 * @extends {PcmDdsqdmxJDSQWSHGridViewBase}
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
export default class PcmDdsqdmxJDSQWSHGridView extends PcmDdsqdmxJDSQWSHGridViewBase { }
</script>