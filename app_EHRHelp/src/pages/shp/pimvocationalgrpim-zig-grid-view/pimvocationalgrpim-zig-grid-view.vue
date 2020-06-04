<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMVOCATIONALGRPimZigGridViewBase from './pimvocationalgrpim-zig-grid-view-base.vue';

import view_grid from '@widgets/pim-vocational/main-certificate-grid/main-certificate-grid.vue';
import view_searchform from '@widgets/pim-vocational/default-searchform/default-searchform.vue';

/**
 * 证书信息表格视图
 *
 * @export
 * @class PIMVOCATIONALGRPimZigGridView
 * @extends {PIMVOCATIONALGRPimZigGridViewBase}
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
export default class PIMVOCATIONALGRPimZigGridView extends PIMVOCATIONALGRPimZigGridViewBase { }
</script>