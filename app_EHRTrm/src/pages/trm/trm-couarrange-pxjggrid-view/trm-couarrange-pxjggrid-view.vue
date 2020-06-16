<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmCouarrangePXJGGridViewBase from './trm-couarrange-pxjggrid-view-base.vue';

import view_grid from '@widgets/trm-couarrange/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/trm-couarrange/default-searchform/default-searchform.vue';

/**
 * 课程安排表格视图
 *
 * @export
 * @class TrmCouarrangePXJGGridView
 * @extends {TrmCouarrangePXJGGridViewBase}
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
export default class TrmCouarrangePXJGGridView extends TrmCouarrangePXJGGridViewBase { }
</script>