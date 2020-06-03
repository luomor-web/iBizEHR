<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveTipsQJTSGridViewBase from './vac-leave-tips-qjtsgrid-view-base.vue';

import view_grid from '@widgets/vac-leave-tips/main-grid/main-grid.vue';

/**
 * 温馨提示
 *
 * @export
 * @class VacLeaveTipsQJTSGridView
 * @extends {VacLeaveTipsQJTSGridViewBase}
 */
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class VacLeaveTipsQJTSGridView extends VacLeaveTipsQJTSGridViewBase { }
</script>