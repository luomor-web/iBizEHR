<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceSetupCurOrgKQSZGridViewBase from './att-endence-setup-cur-org-kqszgrid-view-base.vue';

import view_grid from '@widgets/att-endence-setup/main-grid/main-grid.vue';
import view_searchform from '@widgets/att-endence-setup/default-searchform/default-searchform.vue';

/**
 * 考勤设置表格视图
 *
 * @export
 * @class AttEndenceSetupCurOrgKQSZGridView
 * @extends {AttEndenceSetupCurOrgKQSZGridViewBase}
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
export default class AttEndenceSetupCurOrgKQSZGridView extends AttEndenceSetupCurOrgKQSZGridViewBase { }
</script>