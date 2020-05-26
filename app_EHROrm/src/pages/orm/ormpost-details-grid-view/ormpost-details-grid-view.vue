<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPostDetailsGridViewBase from './ormpost-details-grid-view-base.vue';

import view_grid from '@widgets/ormpost-details/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormpost-details/default-searchform/default-searchform.vue';

/**
 * 岗位明细
 *
 * @export
 * @class ORMPostDetailsGridView
 * @extends {ORMPostDetailsGridViewBase}
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
export default class ORMPostDetailsGridView extends ORMPostDetailsGridViewBase { }
</script>