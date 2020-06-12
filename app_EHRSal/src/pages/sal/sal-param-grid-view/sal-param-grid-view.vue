<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalParamGridViewBase from './sal-param-grid-view-base.vue';

import view_grid from '@widgets/sal-param/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-param/default-searchform/default-searchform.vue';

/**
 * 薪酬计算指标表格视图
 *
 * @export
 * @class SalParamGridView
 * @extends {SalParamGridViewBase}
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
export default class SalParamGridView extends SalParamGridViewBase { }
</script>