<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmPostEJORMORGIDPickupGridViewBase from './orm-post-ejormorgidpickup-grid-view-base.vue';

import view_grid from '@widgets/orm-post/gwchoice-grid/gwchoice-grid.vue';
import view_searchform from '@widgets/orm-post/default-searchform/default-searchform.vue';

/**
 * 岗位选择
 *
 * @export
 * @class OrmPostEJORMORGIDPickupGridView
 * @extends {OrmPostEJORMORGIDPickupGridViewBase}
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
export default class OrmPostEJORMORGIDPickupGridView extends OrmPostEJORMORGIDPickupGridViewBase { }
</script>