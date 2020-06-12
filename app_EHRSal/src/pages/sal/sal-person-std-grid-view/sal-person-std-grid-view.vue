<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalPersonStdGridViewBase from './sal-person-std-grid-view-base.vue';

import view_grid from '@widgets/sal-person-std/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-person-std/default-searchform/default-searchform.vue';

/**
 * 员工薪酬标准表格视图
 *
 * @export
 * @class SalPersonStdGridView
 * @extends {SalPersonStdGridViewBase}
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
export default class SalPersonStdGridView extends SalPersonStdGridViewBase { }
</script>