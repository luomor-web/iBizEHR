<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMGWTYPEPickupGridViewBase from './pimgwtypepickup-grid-view-base.vue';

import view_grid from '@widgets/pim-gw-type/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-gw-type/default-searchform/default-searchform.vue';

/**
 * 岗位类型
 *
 * @export
 * @class PIMGWTYPEPickupGridView
 * @extends {PIMGWTYPEPickupGridViewBase}
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
export default class PIMGWTYPEPickupGridView extends PIMGWTYPEPickupGridViewBase { }
</script>