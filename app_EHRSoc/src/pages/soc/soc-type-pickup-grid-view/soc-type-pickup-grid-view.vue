<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocTypePickupGridViewBase from './soc-type-pickup-grid-view-base.vue';

import view_grid from '@widgets/soc-type/main-grid/main-grid.vue';
import view_searchform from '@widgets/soc-type/default-searchform/default-searchform.vue';

/**
 * 保险类型选择表格视图
 *
 * @export
 * @class SocTypePickupGridView
 * @extends {SocTypePickupGridViewBase}
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
export default class SocTypePickupGridView extends SocTypePickupGridViewBase { }
</script>