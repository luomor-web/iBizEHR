<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonSetAttRulesGridViewBase from './pim-person-set-att-rules-grid-view-base.vue';

import view_grid from '@widgets/pim-person/ryinfo-grid-grid/ryinfo-grid-grid.vue';
import view_searchform from '@widgets/pim-person/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 员工考勤设置
 *
 * @export
 * @class PimPersonSetAttRulesGridView
 * @extends {PimPersonSetAttRulesGridViewBase}
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
export default class PimPersonSetAttRulesGridView extends PimPersonSetAttRulesGridViewBase { }
</script>