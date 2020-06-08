<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEnsummaryCurZZKQHZGridViewBase from './att-ensummary-cur-zzkqhzgrid-view-base.vue';

import view_grid from '@widgets/att-ensummary/main-grid/main-grid.vue';
import view_searchform from '@widgets/att-ensummary/default-searchform/default-searchform.vue';

/**
 * 考勤汇总
 *
 * @export
 * @class AttEnsummaryCurZZKQHZGridView
 * @extends {AttEnsummaryCurZZKQHZGridViewBase}
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
export default class AttEnsummaryCurZZKQHZGridView extends AttEnsummaryCurZZKQHZGridViewBase { }
</script>