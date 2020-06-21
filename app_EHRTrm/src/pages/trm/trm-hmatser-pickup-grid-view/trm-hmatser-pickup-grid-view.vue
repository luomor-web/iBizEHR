<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmHmatserPickupGridViewBase from './trm-hmatser-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-hmatser/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-hmatser/default-searchform/default-searchform.vue';

/**
 * 班主任选择表格视图
 *
 * @export
 * @class TrmHmatserPickupGridView
 * @extends {TrmHmatserPickupGridViewBase}
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
export default class TrmHmatserPickupGridView extends TrmHmatserPickupGridViewBase { }
</script>