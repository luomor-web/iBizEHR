<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONJXQYGGridViewBase from './pimpersonjxqyggrid-view-base.vue';

import view_grid from '@widgets/pim-person/jxdqyg-grid/jxdqyg-grid.vue';
import view_searchform from '@widgets/pim-person/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 见习员工
 *
 * @export
 * @class PIMPERSONJXQYGGridView
 * @extends {PIMPERSONJXQYGGridViewBase}
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
export default class PIMPERSONJXQYGGridView extends PIMPERSONJXQYGGridViewBase { }
</script>