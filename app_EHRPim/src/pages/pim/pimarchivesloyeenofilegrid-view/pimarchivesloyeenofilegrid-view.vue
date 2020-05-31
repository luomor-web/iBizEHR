<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESLOYEENOFILEGridViewBase from './pimarchivesloyeenofilegrid-view-base.vue';

import view_grid from '@widgets/pim-archives/main-ygbzd-grid/main-ygbzd-grid.vue';
import view_searchform from '@widgets/pim-archives/default-searchform/default-searchform.vue';

/**
 * 员工不在档提醒表格视图
 *
 * @export
 * @class PIMARCHIVESLOYEENOFILEGridView
 * @extends {PIMARCHIVESLOYEENOFILEGridViewBase}
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
export default class PIMARCHIVESLOYEENOFILEGridView extends PIMARCHIVESLOYEENOFILEGridViewBase { }
</script>