<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgsectorFPXXPickupGridViewBase from './orm-orgsector-fpxxpickup-grid-view-base.vue';

import view_grid from '@widgets/orm-orgsector/bmxmjc-grid/bmxmjc-grid.vue';
import view_searchform from '@widgets/orm-orgsector/default-searchform/default-searchform.vue';

/**
 * 部门选择
 *
 * @export
 * @class OrmOrgsectorFPXXPickupGridView
 * @extends {OrmOrgsectorFPXXPickupGridViewBase}
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
export default class OrmOrgsectorFPXXPickupGridView extends OrmOrgsectorFPXXPickupGridViewBase { }
</script>