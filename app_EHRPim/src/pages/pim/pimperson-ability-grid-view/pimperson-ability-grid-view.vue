<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPersonAbilityGridViewBase from './pimperson-ability-grid-view-base.vue';

import view_grid from '@widgets/pimperson-ability/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimperson-ability/default-searchform/default-searchform.vue';

/**
 * 员工能力表格视图
 *
 * @export
 * @class PIMPersonAbilityGridView
 * @extends {PIMPersonAbilityGridViewBase}
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
export default class PIMPersonAbilityGridView extends PIMPersonAbilityGridViewBase { }
</script>