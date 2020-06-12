<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESGridViewBase from './pimarchivesgrid-view-base.vue';

import view_grid from '@widgets/pim-archives/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-archives/default-searchform/default-searchform.vue';

/**
 * 档案信息表格视图
 *
 * @export
 * @class PIMARCHIVESGridView
 * @extends {PIMARCHIVESGridViewBase}
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
export default class PIMARCHIVESGridView extends PIMARCHIVESGridViewBase { }
</script>