<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgsectorPickupGridViewBase from './orm-orgsector-pickup-grid-view-base.vue';

import view_grid from '@widgets/orm-orgsector/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-orgsector/default-searchform/default-searchform.vue';

/**
 * 部门管理选择表格视图
 *
 * @export
 * @class OrmOrgsectorPickupGridView
 * @extends {OrmOrgsectorPickupGridViewBase}
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
export default class OrmOrgsectorPickupGridView extends OrmOrgsectorPickupGridViewBase { }
</script>