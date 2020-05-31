<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYYGCGJGridViewBase from './pimexitandentryygcgjgrid-view-base.vue';

import view_grid from '@widgets/pim-exitandentry/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-exitandentry/default-searchform/default-searchform.vue';

/**
 * 出入境管理实体表格视图（因公出国境）
 *
 * @export
 * @class PIMEXITANDENTRYYGCGJGridView
 * @extends {PIMEXITANDENTRYYGCGJGridViewBase}
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
export default class PIMEXITANDENTRYYGCGJGridView extends PIMEXITANDENTRYYGCGJGridViewBase { }
</script>