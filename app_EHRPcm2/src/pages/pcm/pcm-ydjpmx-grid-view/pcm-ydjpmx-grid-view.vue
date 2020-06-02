<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxGridViewBase from './pcm-ydjpmx-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydjpmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydjpmx/default-searchform/default-searchform.vue';

/**
 * 异动解聘明细表
 *
 * @export
 * @class PcmYdjpmxGridView
 * @extends {PcmYdjpmxGridViewBase}
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
export default class PcmYdjpmxGridView extends PcmYdjpmxGridViewBase { }
</script>