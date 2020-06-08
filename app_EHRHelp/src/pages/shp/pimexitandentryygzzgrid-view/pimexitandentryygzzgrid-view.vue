<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYYGZZGridViewBase from './pimexitandentryygzzgrid-view-base.vue';

import view_grid from '@widgets/pim-exitandentry/ygzz-grid/ygzz-grid.vue';
import view_searchform from '@widgets/pim-exitandentry/default-searchform/default-searchform.vue';

/**
 * 出入境管理实体表格视图（员工自助）
 *
 * @export
 * @class PIMEXITANDENTRYYGZZGridView
 * @extends {PIMEXITANDENTRYYGZZGridViewBase}
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
export default class PIMEXITANDENTRYYGZZGridView extends PIMEXITANDENTRYYGZZGridViewBase { }
</script>