<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxJZSQGRGridViewBase from './pcm-ddsqdmx-jzsqgrgrid-view-base.vue';

import view_grid from '@widgets/pcm-ddsqdmx/jzsqmxgr-grid/jzsqmxgr-grid.vue';
import view_searchform from '@widgets/pcm-ddsqdmx/default-searchform/default-searchform.vue';

/**
 * 兼职申请
 *
 * @export
 * @class PcmDdsqdmxJZSQGRGridView
 * @extends {PcmDdsqdmxJZSQGRGridViewBase}
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
export default class PcmDdsqdmxJZSQGRGridView extends PcmDdsqdmxJZSQGRGridViewBase { }
</script>