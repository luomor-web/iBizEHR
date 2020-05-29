<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TRMLGBCOSTGridViewBase from './trmlgbcostgrid-view-base.vue';

import view_grid from '@widgets/trm-lgb-cost/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-lgb-cost/default-searchform/default-searchform.vue';

/**
 * 老干部活动管理
 *
 * @export
 * @class TRMLGBCOSTGridView
 * @extends {TRMLGBCOSTGridViewBase}
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
export default class TRMLGBCOSTGridView extends TRMLGBCOSTGridViewBase { }
</script>