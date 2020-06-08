<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxGridViewBase from './pcm-ydjzmx-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydjzmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydjzmx/default-searchform/default-searchform.vue';

/**
 * 异动兼职明细表格视图
 *
 * @export
 * @class PcmYdjzmxGridView
 * @extends {PcmYdjzmxGridViewBase}
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
export default class PcmYdjzmxGridView extends PcmYdjzmxGridViewBase { }
</script>