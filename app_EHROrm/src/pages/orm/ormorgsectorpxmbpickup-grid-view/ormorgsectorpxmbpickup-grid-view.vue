<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORPXMBPickupGridViewBase from './ormorgsectorpxmbpickup-grid-view-base.vue';

import view_grid from '@widgets/ormorgsector/xmbchoice-grid/xmbchoice-grid.vue';
import view_searchform from '@widgets/ormorgsector/default-searchform/default-searchform.vue';

/**
 * 项目部选择
 *
 * @export
 * @class ORMORGSECTORPXMBPickupGridView
 * @extends {ORMORGSECTORPXMBPickupGridViewBase}
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
export default class ORMORGSECTORPXMBPickupGridView extends ORMORGSECTORPXMBPickupGridViewBase { }
</script>