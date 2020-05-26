<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMTITLEPickupGridViewBase from './ormtitlepickup-grid-view-base.vue';

import view_grid from '@widgets/ormtitle/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormtitle/default-searchform/default-searchform.vue';

/**
 * 标准头衔库
 *
 * @export
 * @class ORMTITLEPickupGridView
 * @extends {ORMTITLEPickupGridViewBase}
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
export default class ORMTITLEPickupGridView extends ORMTITLEPickupGridViewBase { }
</script>