<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SALPERSONSTDDETAILGridViewBase from './salpersonstddetailgrid-view-base.vue';

import view_grid from '@widgets/salpersonstddetail/main-grid/main-grid.vue';
import view_searchform from '@widgets/salpersonstddetail/default-searchform/default-searchform.vue';

/**
 * 员工薪酬标准明细表格视图
 *
 * @export
 * @class SALPERSONSTDDETAILGridView
 * @extends {SALPERSONSTDDETAILGridViewBase}
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
export default class SALPERSONSTDDETAILGridView extends SALPERSONSTDDETAILGridViewBase { }
</script>