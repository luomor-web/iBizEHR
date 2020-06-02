<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionDDRMgrGridViewBase from './pim-distirbution-ddrmgr-grid-view-base.vue';

import view_grid from '@widgets/pim-distirbution/ddfpxx-grid/ddfpxx-grid.vue';
import view_searchform from '@widgets/pim-distirbution/default-searchform/default-searchform.vue';

/**
 * 调入管理
 *
 * @export
 * @class PimDistirbutionDDRMgrGridView
 * @extends {PimDistirbutionDDRMgrGridViewBase}
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
export default class PimDistirbutionDDRMgrGridView extends PimDistirbutionDDRMgrGridViewBase { }
</script>