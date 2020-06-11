<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdzcGridViewBase from './sal-stdzc-grid-view-base.vue';

import view_grid from '@widgets/sal-stdzc/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-stdzc/default-searchform/default-searchform.vue';

/**
 * 职称类别标准表格视图
 *
 * @export
 * @class SalStdzcGridView
 * @extends {SalStdzcGridViewBase}
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
export default class SalStdzcGridView extends SalStdzcGridViewBase { }
</script>