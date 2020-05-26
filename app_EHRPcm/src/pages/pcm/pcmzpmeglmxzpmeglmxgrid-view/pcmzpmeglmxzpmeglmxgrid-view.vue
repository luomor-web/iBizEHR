<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMZPMEGLMXZPMEGLMXGridViewBase from './pcmzpmeglmxzpmeglmxgrid-view-base.vue';

import view_grid from '@widgets/pcmzpmeglmx/main-grid/main-grid.vue';

/**
 * 招聘名额管理明细表格视图
 *
 * @export
 * @class PCMZPMEGLMXZPMEGLMXGridView
 * @extends {PCMZPMEGLMXZPMEGLMXGridViewBase}
 */
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PCMZPMEGLMXZPMEGLMXGridView extends PCMZPMEGLMXZPMEGLMXGridViewBase { }
</script>