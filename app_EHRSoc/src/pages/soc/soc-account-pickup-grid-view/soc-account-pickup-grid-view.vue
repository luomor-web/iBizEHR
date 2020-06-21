<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocAccountPickupGridViewBase from './soc-account-pickup-grid-view-base.vue';

import view_grid from '@widgets/soc-account/main-grid/main-grid.vue';
import view_searchform from '@widgets/soc-account/default-searchform/default-searchform.vue';

/**
 * 参保账户选择表格视图
 *
 * @export
 * @class SocAccountPickupGridView
 * @extends {SocAccountPickupGridViewBase}
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
export default class SocAccountPickupGridView extends SocAccountPickupGridViewBase { }
</script>