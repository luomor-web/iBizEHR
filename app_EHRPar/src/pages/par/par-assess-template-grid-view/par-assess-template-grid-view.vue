<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParAssessTemplateGridViewBase from './par-assess-template-grid-view-base.vue';

import view_grid from '@widgets/par-assess-template/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-assess-template/default-searchform/default-searchform.vue';

/**
 * 考核模板表格视图
 *
 * @export
 * @class ParAssessTemplateGridView
 * @extends {ParAssessTemplateGridViewBase}
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
export default class ParAssessTemplateGridView extends ParAssessTemplateGridViewBase { }
</script>