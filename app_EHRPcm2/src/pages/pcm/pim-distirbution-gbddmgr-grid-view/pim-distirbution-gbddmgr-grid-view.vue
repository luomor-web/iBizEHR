<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionGBDDMgrGridViewBase from './pim-distirbution-gbddmgr-grid-view-base.vue';

import view_grid from '@widgets/pim-distirbution/ddfpxx-c-grid/ddfpxx-c-grid.vue';
import view_searchform from '@widgets/pim-distirbution/ddsearch-form-searchform/ddsearch-form-searchform.vue';

/**
 * 干部调动
 *
 * @export
 * @class PimDistirbutionGBDDMgrGridView
 * @extends {PimDistirbutionGBDDMgrGridViewBase}
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
export default class PimDistirbutionGBDDMgrGridView extends PimDistirbutionGBDDMgrGridViewBase { }
</script>