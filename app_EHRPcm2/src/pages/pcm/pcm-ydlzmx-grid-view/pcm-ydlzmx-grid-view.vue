<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxGridViewBase from './pcm-ydlzmx-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydlzmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydlzmx/default-searchform/default-searchform.vue';

/**
 * 异动离职明细表格视图
 *
 * @export
 * @class PcmYdlzmxGridView
 * @extends {PcmYdlzmxGridViewBase}
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
export default class PcmYdlzmxGridView extends PcmYdlzmxGridViewBase { }
</script>