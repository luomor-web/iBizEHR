<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDepEstManZWGridViewBase from './ormdep-est-man-zwgrid-view-base.vue';

import view_grid from '@widgets/ormdep-est-man/zwbzmx-grid/zwbzmx-grid.vue';
import view_searchform from '@widgets/ormdep-est-man/default-searchform/default-searchform.vue';

/**
 * 职务编制明细
 *
 * @export
 * @class ORMDepEstManZWGridView
 * @extends {ORMDepEstManZWGridViewBase}
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
export default class ORMDepEstManZWGridView extends ORMDepEstManZWGridViewBase { }
</script>