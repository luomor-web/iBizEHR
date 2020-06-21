<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocRuleDetailGridViewBase from './soc-rule-detail-grid-view-base.vue';

import view_grid from '@widgets/soc-rule-detail/main-grid/main-grid.vue';

/**
 * 社保规则明细表格视图
 *
 * @export
 * @class SocRuleDetailGridView
 * @extends {SocRuleDetailGridViewBase}
 */
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class SocRuleDetailGridView extends SocRuleDetailGridViewBase { }
</script>