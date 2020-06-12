<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalRulePickupGridViewBase from './sal-rule-pickup-grid-view-base.vue';

import view_grid from '@widgets/sal-rule/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-rule/default-searchform/default-searchform.vue';

/**
 * 薪酬规则选择表格视图
 *
 * @export
 * @class SalRulePickupGridView
 * @extends {SalRulePickupGridViewBase}
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
export default class SalRulePickupGridView extends SalRulePickupGridViewBase { }
</script>