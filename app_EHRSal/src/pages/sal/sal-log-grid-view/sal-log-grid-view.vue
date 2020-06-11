<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalLogGridViewBase from './sal-log-grid-view-base.vue';

import view_grid from '@widgets/sal-log/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-log/default-searchform/default-searchform.vue';

/**
 * 薪酬调整日志表格视图
 *
 * @export
 * @class SalLogGridView
 * @extends {SalLogGridViewBase}
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
export default class SalLogGridView extends SalLogGridViewBase { }
</script>