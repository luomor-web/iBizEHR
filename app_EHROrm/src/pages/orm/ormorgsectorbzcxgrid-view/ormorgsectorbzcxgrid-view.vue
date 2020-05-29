<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORBZCXGridViewBase from './ormorgsectorbzcxgrid-view-base.vue';

import view_grid from '@widgets/orm-orgsector/bzcx-grid/bzcx-grid.vue';
import view_searchform from '@widgets/orm-orgsector/bzcx-searchform/bzcx-searchform.vue';

/**
 * 编制查询
 *
 * @export
 * @class ORMORGSECTORBZCXGridView
 * @extends {ORMORGSECTORBZCXGridViewBase}
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
export default class ORMORGSECTORBZCXGridView extends ORMORGSECTORBZCXGridViewBase { }
</script>