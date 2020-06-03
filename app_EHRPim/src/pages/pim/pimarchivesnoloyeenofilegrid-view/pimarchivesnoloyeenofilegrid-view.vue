<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESNOLOYEENOFILEGridViewBase from './pimarchivesnoloyeenofilegrid-view-base.vue';

import view_grid from '@widgets/pim-archives/main-fygzd-grid/main-fygzd-grid.vue';
import view_searchform from '@widgets/pim-archives/default-searchform/default-searchform.vue';

/**
 * 非员工在档提醒表格视图
 *
 * @export
 * @class PIMARCHIVESNOLOYEENOFILEGridView
 * @extends {PIMARCHIVESNOLOYEENOFILEGridViewBase}
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
export default class PIMARCHIVESNOLOYEENOFILEGridView extends PIMARCHIVESNOLOYEENOFILEGridViewBase { }
</script>