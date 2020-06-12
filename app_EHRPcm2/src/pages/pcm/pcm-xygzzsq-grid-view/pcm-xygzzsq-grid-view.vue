<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzsqGridViewBase from './pcm-xygzzsq-grid-view-base.vue';

import view_grid from '@widgets/pcm-xygzzsq/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-xygzzsq/default-searchform/default-searchform.vue';

/**
 * 试用期员工转正申请表格视图
 *
 * @export
 * @class PcmXygzzsqGridView
 * @extends {PcmXygzzsqGridViewBase}
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
export default class PcmXygzzsqGridView extends PcmXygzzsqGridViewBase { }
</script>