<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxPDDGridViewBase from './pcm-ddsqdmx-pddgrid-view-base.vue';

import view_grid from '@widgets/pcm-ddsqdmx/ddedit-form-grid/ddedit-form-grid.vue';
import view_searchform from '@widgets/pcm-ddsqdmx/default-searchform/default-searchform.vue';

/**
 * 调动明细
 *
 * @export
 * @class PcmDdsqdmxPDDGridView
 * @extends {PcmDdsqdmxPDDGridViewBase}
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
export default class PcmDdsqdmxPDDGridView extends PcmDdsqdmxPDDGridViewBase { }
</script>