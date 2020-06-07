<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxGridViewBase from './pcm-ydntmx-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydntmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydntmx/default-searchform/default-searchform.vue';

/**
 * 异动内退明细表
 *
 * @export
 * @class PcmYdntmxGridView
 * @extends {PcmYdntmxGridViewBase}
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
export default class PcmYdntmxGridView extends PcmYdntmxGridViewBase { }
</script>