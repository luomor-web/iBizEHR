<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceSettingsGridViewBase from './att-endance-settings-grid-view-base.vue';

import view_grid from '@widgets/att-endance-settings/main-grid/main-grid.vue';
import view_searchform from '@widgets/att-endance-settings/default-searchform/default-searchform.vue';

/**
 * 考勤人员
 *
 * @export
 * @class AttEndanceSettingsGridView
 * @extends {AttEndanceSettingsGridViewBase}
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
export default class AttEndanceSettingsGridView extends AttEndanceSettingsGridViewBase { }
</script>