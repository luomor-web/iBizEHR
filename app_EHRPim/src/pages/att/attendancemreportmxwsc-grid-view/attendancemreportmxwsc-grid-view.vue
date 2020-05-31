<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ATTENDANCEMREPORTMXWscGridViewBase from './attendancemreportmxwsc-grid-view-base.vue';

import view_grid from '@widgets/att-endance-mreportmx/wsc-grid-grid/wsc-grid-grid.vue';
import view_searchform from '@widgets/att-endance-mreportmx/default-searchform/default-searchform.vue';

/**
 * 考勤信息
 *
 * @export
 * @class ATTENDANCEMREPORTMXWscGridView
 * @extends {ATTENDANCEMREPORTMXWscGridViewBase}
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
export default class ATTENDANCEMREPORTMXWscGridView extends ATTENDANCEMREPORTMXWscGridViewBase { }
</script>