<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacSynjcxGridViewBase from './vac-synjcx-grid-view-base.vue';

import view_grid from '@widgets/vac-synjcx/main-grid/main-grid.vue';
import view_searchform from '@widgets/vac-synjcx/default-searchform/default-searchform.vue';

/**
 * 年休假查询
 *
 * @export
 * @class VacSynjcxGridView
 * @extends {VacSynjcxGridViewBase}
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
export default class VacSynjcxGridView extends VacSynjcxGridViewBase { }
</script>