<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxGridViewBase from './pcm-ydbxmx-grid-view-base.vue';

import view_grid from '@widgets/pcm-ydbxmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydbxmx/default-searchform/default-searchform.vue';

/**
 * 异动病休明细表格视图
 *
 * @export
 * @class PcmYdbxmxGridView
 * @extends {PcmYdbxmxGridViewBase}
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
export default class PcmYdbxmxGridView extends PcmYdbxmxGridViewBase { }
</script>