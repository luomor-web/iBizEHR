<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMACHIEVEMENTSPimJixGridViewBase from './pimachievementspim-jix-grid-view-base.vue';

import view_grid from '@widgets/pim-achievements/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-achievements/default-searchform/default-searchform.vue';

/**
 * 绩效信息表格视图
 *
 * @export
 * @class PIMACHIEVEMENTSPimJixGridView
 * @extends {PIMACHIEVEMENTSPimJixGridViewBase}
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
export default class PIMACHIEVEMENTSPimJixGridView extends PIMACHIEVEMENTSPimJixGridViewBase { }
</script>