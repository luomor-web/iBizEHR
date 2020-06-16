<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmHmatserGridViewBase from './trm-hmatser-grid-view-base.vue';

import view_grid from '@widgets/trm-hmatser/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-hmatser/default-searchform/default-searchform.vue';

/**
 * 班主任表格视图
 *
 * @export
 * @class TrmHmatserGridView
 * @extends {TrmHmatserGridViewBase}
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
export default class TrmHmatserGridView extends TrmHmatserGridViewBase { }
</script>