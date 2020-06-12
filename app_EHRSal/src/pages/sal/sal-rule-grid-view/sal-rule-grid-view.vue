<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalRuleGridViewBase from './sal-rule-grid-view-base.vue';

import view_grid from '@widgets/sal-rule/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-rule/default-searchform/default-searchform.vue';

/**
 * 薪酬规则表格视图
 *
 * @export
 * @class SalRuleGridView
 * @extends {SalRuleGridViewBase}
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
export default class SalRuleGridView extends SalRuleGridViewBase { }
</script>