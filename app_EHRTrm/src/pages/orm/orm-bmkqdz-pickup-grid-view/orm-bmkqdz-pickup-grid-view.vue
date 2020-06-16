<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmBmkqdzPickupGridViewBase from './orm-bmkqdz-pickup-grid-view-base.vue';

import view_grid from '@widgets/orm-bmkqdz/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-bmkqdz/default-searchform/default-searchform.vue';

/**
 * 部门地址维护选择表格视图
 *
 * @export
 * @class OrmBmkqdzPickupGridView
 * @extends {OrmBmkqdzPickupGridViewBase}
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
export default class OrmBmkqdzPickupGridView extends OrmBmkqdzPickupGridViewBase { }
</script>