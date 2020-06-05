<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxsygzzjlmxSQTEMPLGridViewBase from './pcm-jxsygzzjlmx-sqtemplgrid-view-base.vue';

import view_grid from '@widgets/pcm-jxsygzzjlmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-jxsygzzjlmx/default-searchform/default-searchform.vue';

/**
 * 见习生员工转正记录引用明细表
 *
 * @export
 * @class PcmJxsygzzjlmxSQTEMPLGridView
 * @extends {PcmJxsygzzjlmxSQTEMPLGridViewBase}
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
export default class PcmJxsygzzjlmxSQTEMPLGridView extends PcmJxsygzzjlmxSQTEMPLGridViewBase { }
</script>