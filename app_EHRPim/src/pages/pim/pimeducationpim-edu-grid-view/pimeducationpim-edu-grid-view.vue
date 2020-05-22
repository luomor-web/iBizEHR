<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEDUCATIONPimEduGridViewBase from './pimeducationpim-edu-grid-view-base.vue';

import view_grid from '@widgets/pimeducation/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimeducation/default-searchform/default-searchform.vue';

/**
 * 教育信息表格视图
 *
 * @export
 * @class PIMEDUCATIONPimEduGridView
 * @extends {PIMEDUCATIONPimEduGridViewBase}
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
export default class PIMEDUCATIONPimEduGridView extends PIMEDUCATIONPimEduGridViewBase { }
</script>