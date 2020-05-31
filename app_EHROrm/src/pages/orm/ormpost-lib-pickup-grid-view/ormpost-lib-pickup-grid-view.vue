<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPostLibPickupGridViewBase from './ormpost-lib-pickup-grid-view-base.vue';

import view_grid from '@widgets/orm-post-lib/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-post-lib/default-searchform/default-searchform.vue';

/**
 * 标准岗位
 *
 * @export
 * @class ORMPostLibPickupGridView
 * @extends {ORMPostLibPickupGridViewBase}
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
export default class ORMPostLibPickupGridView extends ORMPostLibPickupGridViewBase { }
</script>