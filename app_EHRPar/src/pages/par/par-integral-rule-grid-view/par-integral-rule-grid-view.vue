<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParIntegralRuleGridViewBase from './par-integral-rule-grid-view-base.vue';

import view_grid from '@widgets/par-integral-rule/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-integral-rule/default-searchform/default-searchform.vue';

/**
 * 积分规则
 *
 * @export
 * @class ParIntegralRuleGridView
 * @extends {ParIntegralRuleGridViewBase}
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
export default class ParIntegralRuleGridView extends ParIntegralRuleGridViewBase { }
</script>