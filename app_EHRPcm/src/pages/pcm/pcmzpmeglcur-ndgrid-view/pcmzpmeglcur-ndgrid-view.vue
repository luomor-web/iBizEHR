<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMZPMEGLCurNDGridViewBase from './pcmzpmeglcur-ndgrid-view-base.vue';

import view_grid from '@widgets/pcm-zpmegl/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-zpmegl/default-searchform/default-searchform.vue';

/**
 * 招聘名额管理表格视图
 *
 * @export
 * @class PCMZPMEGLCurNDGridView
 * @extends {PCMZPMEGLCurNDGridViewBase}
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
export default class PCMZPMEGLCurNDGridView extends PCMZPMEGLCurNDGridViewBase { }
</script>