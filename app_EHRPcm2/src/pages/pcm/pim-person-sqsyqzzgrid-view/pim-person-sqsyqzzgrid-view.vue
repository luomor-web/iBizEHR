<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonSQSYQZZGridViewBase from './pim-person-sqsyqzzgrid-view-base.vue';

import view_grid from '@widgets/pim-person/sydqyg-grid/sydqyg-grid.vue';
import view_searchform from '@widgets/pim-person/syqygsearch-form-searchform/syqygsearch-form-searchform.vue';

/**
 * 试用期转正申请
 *
 * @export
 * @class PimPersonSQSYQZZGridView
 * @extends {PimPersonSQSYQZZGridViewBase}
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
export default class PimPersonSQSYQZZGridView extends PimPersonSQSYQZZGridViewBase { }
</script>