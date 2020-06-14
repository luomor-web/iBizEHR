<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalRuleDetailGridViewBase from './sal-rule-detail-grid-view-base.vue';

import view_grid from '@widgets/sal-rule-detail/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-rule-detail/default-searchform/default-searchform.vue';

/**
 * 薪酬规则明细表格视图
 *
 * @export
 * @class SalRuleDetailGridView
 * @extends {SalRuleDetailGridViewBase}
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
export default class SalRuleDetailGridView extends SalRuleDetailGridViewBase { }
</script>