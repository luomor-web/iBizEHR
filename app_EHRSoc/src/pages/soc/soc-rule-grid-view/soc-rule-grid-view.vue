<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocRuleGridViewBase from './soc-rule-grid-view-base.vue';

import view_grid from '@widgets/soc-rule/main-grid/main-grid.vue';
import view_searchform from '@widgets/soc-rule/default-searchform/default-searchform.vue';

/**
 * 社保规则表格视图
 *
 * @export
 * @class SocRuleGridView
 * @extends {SocRuleGridViewBase}
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
export default class SocRuleGridView extends SocRuleGridViewBase { }
</script>