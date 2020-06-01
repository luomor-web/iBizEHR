<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceSettingsYGSZKQGridViewBase from './att-endance-settings-ygszkqgrid-view-base.vue';

import view_grid from '@widgets/att-endance-settings/ygszkq-grid/ygszkq-grid.vue';
import view_searchform from '@widgets/att-endance-settings/default-searchform/default-searchform.vue';

/**
 * 员工设置考勤
 *
 * @export
 * @class AttEndanceSettingsYGSZKQGridView
 * @extends {AttEndanceSettingsYGSZKQGridViewBase}
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
export default class AttEndanceSettingsYGSZKQGridView extends AttEndanceSettingsYGSZKQGridViewBase { }
</script>