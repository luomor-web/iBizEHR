<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxGBDDJLGridViewBase from './pcm-ddsqdmx-gbddjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ddsqdmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ddsqdmx/default-searchform/default-searchform.vue';

/**
 * 干部调动记录
 *
 * @export
 * @class PcmDdsqdmxGBDDJLGridView
 * @extends {PcmDdsqdmxGBDDJLGridViewBase}
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
export default class PcmDdsqdmxGBDDJLGridView extends PcmDdsqdmxGBDDJLGridViewBase { }
</script>