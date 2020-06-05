<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonSQJXQZZGridViewBase from './pim-person-sqjxqzzgrid-view-base.vue';

import view_grid from '@widgets/pim-person/jxdqyg-grid/jxdqyg-grid.vue';
import view_searchform from '@widgets/pim-person/jxqygsearch-form-searchform/jxqygsearch-form-searchform.vue';

/**
 * 见习期转正申请
 *
 * @export
 * @class PimPersonSQJXQZZGridView
 * @extends {PimPersonSQJXQZZGridViewBase}
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
export default class PimPersonSQJXQZZGridView extends PimPersonSQJXQZZGridViewBase { }
</script>