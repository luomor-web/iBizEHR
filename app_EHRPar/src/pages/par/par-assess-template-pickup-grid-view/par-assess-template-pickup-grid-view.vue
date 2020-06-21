<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParAssessTemplatePickupGridViewBase from './par-assess-template-pickup-grid-view-base.vue';

import view_grid from '@widgets/par-assess-template/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-assess-template/default-searchform/default-searchform.vue';

/**
 * 考核模板选择表格视图
 *
 * @export
 * @class ParAssessTemplatePickupGridView
 * @extends {ParAssessTemplatePickupGridViewBase}
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
export default class ParAssessTemplatePickupGridView extends ParAssessTemplatePickupGridViewBase { }
</script>