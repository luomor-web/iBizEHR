<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMMAJORSETYPEPickupGridViewBase from './pimmajorsetypepickup-grid-view-base.vue';

import view_grid from '@widgets/pimmajorsetype/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimmajorsetype/default-searchform/default-searchform.vue';

/**
 * 专业序列类型选择表格视图
 *
 * @export
 * @class PIMMAJORSETYPEPickupGridView
 * @extends {PIMMAJORSETYPEPickupGridViewBase}
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
export default class PIMMAJORSETYPEPickupGridView extends PIMMAJORSETYPEPickupGridViewBase { }
</script>