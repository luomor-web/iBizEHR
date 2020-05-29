<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONCurLeaderPickupGridViewBase from './pimpersoncur-leader-pickup-grid-view-base.vue';

import view_grid from '@widgets/pimperson/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimperson/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 部门负责人选择
 *
 * @export
 * @class PIMPERSONCurLeaderPickupGridView
 * @extends {PIMPERSONCurLeaderPickupGridViewBase}
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
export default class PIMPERSONCurLeaderPickupGridView extends PIMPERSONCurLeaderPickupGridViewBase { }
</script>