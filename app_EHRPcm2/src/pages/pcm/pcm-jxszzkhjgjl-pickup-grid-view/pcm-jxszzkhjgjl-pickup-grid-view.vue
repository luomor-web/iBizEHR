<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxszzkhjgjlPickupGridViewBase from './pcm-jxszzkhjgjl-pickup-grid-view-base.vue';

import view_grid from '@widgets/pcm-jxszzkhjgjl/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-jxszzkhjgjl/default-searchform/default-searchform.vue';

/**
 * 见习生员工转正考核结果记录选择表格视图
 *
 * @export
 * @class PcmJxszzkhjgjlPickupGridView
 * @extends {PcmJxszzkhjgjlPickupGridViewBase}
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
export default class PcmJxszzkhjgjlPickupGridView extends PcmJxszzkhjgjlPickupGridViewBase { }
</script>