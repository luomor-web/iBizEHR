<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONLTXYGGridViewBase from './pimpersonltxyggrid-view-base.vue';

import view_grid from '@widgets/pim-person/txlxyg-grid/txlxyg-grid.vue';
import view_searchform from '@widgets/pim-person/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 离（退）休人员
 *
 * @export
 * @class PIMPERSONLTXYGGridView
 * @extends {PIMPERSONLTXYGGridViewBase}
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
export default class PIMPERSONLTXYGGridView extends PIMPERSONLTXYGGridViewBase { }
</script>