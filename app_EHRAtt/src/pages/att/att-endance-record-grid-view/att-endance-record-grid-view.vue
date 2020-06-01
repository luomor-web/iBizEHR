<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceRecordGridViewBase from './att-endance-record-grid-view-base.vue';

import view_grid from '@widgets/att-endance-record/main-grid/main-grid.vue';
import view_searchform from '@widgets/att-endance-record/default-searchform/default-searchform.vue';

/**
 * 考勤记录表格视图
 *
 * @export
 * @class AttEndanceRecordGridView
 * @extends {AttEndanceRecordGridViewBase}
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
export default class AttEndanceRecordGridView extends AttEndanceRecordGridViewBase { }
</script>