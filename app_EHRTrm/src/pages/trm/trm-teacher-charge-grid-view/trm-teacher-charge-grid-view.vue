<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTeacherChargeGridViewBase from './trm-teacher-charge-grid-view-base.vue';

import view_grid from '@widgets/trm-teacher-charge/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-teacher-charge/default-searchform/default-searchform.vue';

/**
 * 讲师费用台账
 *
 * @export
 * @class TrmTeacherChargeGridView
 * @extends {TrmTeacherChargeGridViewBase}
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
export default class TrmTeacherChargeGridView extends TrmTeacherChargeGridViewBase { }
</script>