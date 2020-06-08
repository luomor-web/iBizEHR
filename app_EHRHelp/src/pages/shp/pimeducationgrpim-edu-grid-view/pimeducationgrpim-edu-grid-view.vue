<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEDUCATIONGRPimEduGridViewBase from './pimeducationgrpim-edu-grid-view-base.vue';

import view_grid from '@widgets/pim-education/main-self-help-grid/main-self-help-grid.vue';
import view_searchform from '@widgets/pim-education/default-searchform/default-searchform.vue';

/**
 * 教育信息表格视图
 *
 * @export
 * @class PIMEDUCATIONGRPimEduGridView
 * @extends {PIMEDUCATIONGRPimEduGridViewBase}
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
export default class PIMEDUCATIONGRPimEduGridView extends PIMEDUCATIONGRPimEduGridViewBase { }
</script>