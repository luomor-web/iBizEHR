<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzjlmxZZSQLSJMGridViewBase from './pcm-xygzzjlmx-zzsqlsjmgrid-view-base.vue';

import view_grid from '@widgets/pcm-xygzzjlmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-xygzzjlmx/default-searchform/default-searchform.vue';

/**
 * 试用期员工转正结果引用明细
 *
 * @export
 * @class PcmXygzzjlmxZZSQLSJMGridView
 * @extends {PcmXygzzjlmxZZSQLSJMGridViewBase}
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
export default class PcmXygzzjlmxZZSQLSJMGridView extends PcmXygzzjlmxZZSQLSJMGridViewBase { }
</script>