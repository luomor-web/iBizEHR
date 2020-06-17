<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocRulePickupGridViewBase from './soc-rule-pickup-grid-view-base.vue';

import view_grid from '@widgets/soc-rule/main-grid/main-grid.vue';
import view_searchform from '@widgets/soc-rule/default-searchform/default-searchform.vue';

/**
 * 社保规则选择表格视图
 *
 * @export
 * @class SocRulePickupGridView
 * @extends {SocRulePickupGridViewBase}
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
export default class SocRulePickupGridView extends SocRulePickupGridViewBase { }
</script>