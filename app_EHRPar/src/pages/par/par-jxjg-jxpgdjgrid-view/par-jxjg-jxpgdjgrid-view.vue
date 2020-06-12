<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParJxjgJXPGDJGridViewBase from './par-jxjg-jxpgdjgrid-view-base.vue';

import view_grid from '@widgets/par-jxjg/khpgdj-grid/khpgdj-grid.vue';
import view_searchform from '@widgets/par-jxjg/default-searchform/default-searchform.vue';

/**
 * 绩效评估定级
 *
 * @export
 * @class ParJxjgJXPGDJGridView
 * @extends {ParJxjgJXPGDJGridViewBase}
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
export default class ParJxjgJXPGDJGridView extends ParJxjgJXPGDJGridViewBase { }
</script>