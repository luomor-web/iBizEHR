<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONSYQYGGridViewBase from './pimpersonsyqyggrid-view-base.vue';

import view_grid from '@widgets/pim-person/sydqyg-grid/sydqyg-grid.vue';
import view_searchform from '@widgets/pim-person/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 试用员工
 *
 * @export
 * @class PIMPERSONSYQYGGridView
 * @extends {PIMPERSONSYQYGGridViewBase}
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
export default class PIMPERSONSYQYGGridView extends PIMPERSONSYQYGGridViewBase { }
</script>