<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMQUALMAJORPickupGridViewBase from './pimqualmajorpickup-grid-view-base.vue';

import view_grid from '@widgets/pimqualmajor/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimqualmajor/default-searchform/default-searchform.vue';

/**
 * 执业资格专业选择表格视图
 *
 * @export
 * @class PIMQUALMAJORPickupGridView
 * @extends {PIMQUALMAJORPickupGridViewBase}
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
export default class PIMQUALMAJORPickupGridView extends PIMQUALMAJORPickupGridViewBase { }
</script>