<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzkhjgjlPickupGridViewBase from './pcm-xygzzkhjgjl-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-xygzzkhjgjl/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-xygzzkhjgjl/default-searchform/default-searchform.vue';

/**
 * 新员工转正考核结果记录选择表格视图
 *
 * @export
 * @class PcmXygzzkhjgjlPickupGridView
 * @extends {PcmXygzzkhjgjlPickupGridViewBase}
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
export default class PcmXygzzkhjgjlPickupGridView extends PcmXygzzkhjgjlPickupGridViewBase { }
</script>