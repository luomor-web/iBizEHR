<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdzyzgGridViewBase from './sal-stdzyzg-grid-view-base.vue';

import view_grid from '@widgets/sal-stdzyzg/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-stdzyzg/default-searchform/default-searchform.vue';

/**
 * 执业资格津贴标准表格视图
 *
 * @export
 * @class SalStdzyzgGridView
 * @extends {SalStdzyzgGridViewBase}
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
export default class SalStdzyzgGridView extends SalStdzyzgGridViewBase { }
</script>