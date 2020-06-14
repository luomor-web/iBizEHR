<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParJxjgGridViewBase from './par-jxjg-grid-view-base.vue';

import view_grid from '@widgets/par-jxjg/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-jxjg/default-searchform/default-searchform.vue';

/**
 * 绩效结果表格视图
 *
 * @export
 * @class ParJxjgGridView
 * @extends {ParJxjgGridViewBase}
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
export default class ParJxjgGridView extends ParJxjgGridViewBase { }
</script>