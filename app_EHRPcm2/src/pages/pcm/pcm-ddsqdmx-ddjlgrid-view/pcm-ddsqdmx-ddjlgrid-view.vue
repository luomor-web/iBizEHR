<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxDDJLGridViewBase from './pcm-ddsqdmx-ddjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ddsqdmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ddsqdmx/default-searchform/default-searchform.vue';

/**
 * 调动记录
 *
 * @export
 * @class PcmDdsqdmxDDJLGridView
 * @extends {PcmDdsqdmxDDJLGridViewBase}
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
export default class PcmDdsqdmxDDJLGridView extends PcmDdsqdmxDDJLGridViewBase { }
</script>