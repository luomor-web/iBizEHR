<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocRuleDetailPickupGridViewBase from './soc-rule-detail-pickup-grid-view-base.vue';

import view_grid from '@widgets/soc-rule-detail/main-grid/main-grid.vue';
import view_searchform from '@widgets/soc-rule-detail/default-searchform/default-searchform.vue';

/**
 * 社保规则明细选择表格视图
 *
 * @export
 * @class SocRuleDetailPickupGridView
 * @extends {SocRuleDetailPickupGridViewBase}
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
export default class SocRuleDetailPickupGridView extends SocRuleDetailPickupGridViewBase { }
</script>