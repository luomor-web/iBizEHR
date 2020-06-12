<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSubjectPickupGridViewBase from './sal-subject-pickup-grid-view-base.vue';

import view_grid from '@widgets/sal-subject/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-subject/default-searchform/default-searchform.vue';

/**
 * 财务科目选择表格视图
 *
 * @export
 * @class SalSubjectPickupGridView
 * @extends {SalSubjectPickupGridViewBase}
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
export default class SalSubjectPickupGridView extends SalSubjectPickupGridViewBase { }
</script>