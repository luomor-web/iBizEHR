<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceSettingsFYGZZKQGridViewBase from './att-endance-settings-fygzzkqgrid-view-base.vue';

import view_grid from '@widgets/att-endance-settings/fygzzkq-grid/fygzzkq-grid.vue';
import view_searchform from '@widgets/att-endance-settings/default-searchform/default-searchform.vue';

/**
 * 非员工终止考勤
 *
 * @export
 * @class AttEndanceSettingsFYGZZKQGridView
 * @extends {AttEndanceSettingsFYGZZKQGridViewBase}
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
export default class AttEndanceSettingsFYGZZKQGridView extends AttEndanceSettingsFYGZZKQGridViewBase { }
</script>