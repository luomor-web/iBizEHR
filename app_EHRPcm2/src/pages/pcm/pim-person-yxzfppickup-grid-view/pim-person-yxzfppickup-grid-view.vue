<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonYXZFPPickupGridViewBase from './pim-person-yxzfppickup-grid-view-base.vue';

import view_grid from '@widgets/pim-person/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-person/ydryinfo-search-form-searchform/ydryinfo-search-form-searchform.vue';

/**
 * 有效主分配的人员
 *
 * @export
 * @class PimPersonYXZFPPickupGridView
 * @extends {PimPersonYXZFPPickupGridViewBase}
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
export default class PimPersonYXZFPPickupGridView extends PimPersonYXZFPPickupGridViewBase { }
</script>