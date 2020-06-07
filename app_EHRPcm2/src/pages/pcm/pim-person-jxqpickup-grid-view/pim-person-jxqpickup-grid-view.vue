<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonJXQPickupGridViewBase from './pim-person-jxqpickup-grid-view-base.vue';

import view_grid from '@widgets/pim-person/jxdqyg-grid/jxdqyg-grid.vue';
import view_searchform from '@widgets/pim-person/jxqygsearch-form-searchform/jxqygsearch-form-searchform.vue';

/**
 * 见习期员工
 *
 * @export
 * @class PimPersonJXQPickupGridView
 * @extends {PimPersonJXQPickupGridViewBase}
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
export default class PimPersonJXQPickupGridView extends PimPersonJXQPickupGridViewBase { }
</script>