<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxGridViewBase from './pcm-ydjdmx-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydjdmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydjdmx/default-searchform/default-searchform.vue';

/**
 * 异动借调明细表格视图
 *
 * @export
 * @class PcmYdjdmxGridView
 * @extends {PcmYdjdmxGridViewBase}
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
export default class PcmYdjdmxGridView extends PcmYdjdmxGridViewBase { }
</script>