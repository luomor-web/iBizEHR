<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonBYLYGPickupGridViewBase from './pim-person-bylygpickup-grid-view-base.vue';

import view_grid from '@widgets/pim-person/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-person/ydryinfo-search-form-searchform/ydryinfo-search-form-searchform.vue';

/**
 * B/Y类员工
 *
 * @export
 * @class PimPersonBYLYGPickupGridView
 * @extends {PimPersonBYLYGPickupGridViewBase}
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
export default class PimPersonBYLYGPickupGridView extends PimPersonBYLYGPickupGridViewBase { }
</script>