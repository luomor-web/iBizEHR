<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDUTYEstManPickupGridViewBase from './ormdutyest-man-pickup-grid-view-base.vue';

import view_grid from '@widgets/ormduty/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormduty/default-searchform/default-searchform.vue';

/**
 * 职务库
 *
 * @export
 * @class ORMDUTYEstManPickupGridView
 * @extends {ORMDUTYEstManPickupGridViewBase}
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
export default class ORMDUTYEstManPickupGridView extends ORMDUTYEstManPickupGridViewBase { }
</script>