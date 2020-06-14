<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSchemeGridViewBase from './sal-scheme-grid-view-base.vue';

import view_grid from '@widgets/sal-scheme/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-scheme/default-searchform/default-searchform.vue';

/**
 * 薪酬方案表格视图
 *
 * @export
 * @class SalSchemeGridView
 * @extends {SalSchemeGridViewBase}
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
export default class SalSchemeGridView extends SalSchemeGridViewBase { }
</script>