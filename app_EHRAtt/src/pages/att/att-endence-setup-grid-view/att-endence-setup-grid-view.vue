<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceSetupGridViewBase from './att-endence-setup-grid-view-base.vue';

import view_grid from '@widgets/att-endence-setup/main-grid/main-grid.vue';
import view_searchform from '@widgets/att-endence-setup/default-searchform/default-searchform.vue';

/**
 * 考勤设置表格视图
 *
 * @export
 * @class AttEndenceSetupGridView
 * @extends {AttEndenceSetupGridViewBase}
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
export default class AttEndenceSetupGridView extends AttEndenceSetupGridViewBase { }
</script>