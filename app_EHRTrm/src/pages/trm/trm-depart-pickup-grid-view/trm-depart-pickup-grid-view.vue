<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmDepartPickupGridViewBase from './trm-depart-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-depart/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-depart/default-searchform/default-searchform.vue';

/**
 * 部门需求填报选择表格视图
 *
 * @export
 * @class TrmDepartPickupGridView
 * @extends {TrmDepartPickupGridViewBase}
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
export default class TrmDepartPickupGridView extends TrmDepartPickupGridViewBase { }
</script>