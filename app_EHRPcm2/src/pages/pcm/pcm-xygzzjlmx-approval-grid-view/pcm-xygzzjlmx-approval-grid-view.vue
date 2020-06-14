<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzjlmxApprovalGridViewBase from './pcm-xygzzjlmx-approval-grid-view-base.vue';

import view_grid from '@widgets/pcm-xygzzjlmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-xygzzjlmx/default-searchform/default-searchform.vue';

/**
 * 试用期转正审核
 *
 * @export
 * @class PcmXygzzjlmxApprovalGridView
 * @extends {PcmXygzzjlmxApprovalGridViewBase}
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
export default class PcmXygzzjlmxApprovalGridView extends PcmXygzzjlmxApprovalGridViewBase { }
</script>