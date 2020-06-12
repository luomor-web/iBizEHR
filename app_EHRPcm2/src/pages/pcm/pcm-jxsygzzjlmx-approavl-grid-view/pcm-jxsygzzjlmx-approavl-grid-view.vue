<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxsygzzjlmxApproavlGridViewBase from './pcm-jxsygzzjlmx-approavl-grid-view-base.vue';

import view_grid from '@widgets/pcm-jxsygzzjlmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-jxsygzzjlmx/default-searchform/default-searchform.vue';

/**
 * 见习期转正审核
 *
 * @export
 * @class PcmJxsygzzjlmxApproavlGridView
 * @extends {PcmJxsygzzjlmxApproavlGridViewBase}
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
export default class PcmJxsygzzjlmxApproavlGridView extends PcmJxsygzzjlmxApproavlGridViewBase { }
</script>