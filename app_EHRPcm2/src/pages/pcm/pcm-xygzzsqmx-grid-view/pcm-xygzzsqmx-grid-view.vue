<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzsqmxGridViewBase from './pcm-xygzzsqmx-grid-view-base.vue';

import view_grid from '@widgets/pcm-xygzzsqmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-xygzzsqmx/default-searchform/default-searchform.vue';

/**
 * 试用期员工转正申请明细表格视图
 *
 * @export
 * @class PcmXygzzsqmxGridView
 * @extends {PcmXygzzsqmxGridViewBase}
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
export default class PcmXygzzsqmxGridView extends PcmXygzzsqmxGridViewBase { }
</script>