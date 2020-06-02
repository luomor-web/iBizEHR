<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxNTGLGridViewBase from './pcm-ydntmx-ntglgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydntmx/glgrid-grid/glgrid-grid.vue';
import view_searchform from '@widgets/pcm-ydntmx/default-searchform/default-searchform.vue';

/**
 * 内退管理
 *
 * @export
 * @class PcmYdntmxNTGLGridView
 * @extends {PcmYdntmxNTGLGridViewBase}
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
export default class PcmYdntmxNTGLGridView extends PcmYdntmxNTGLGridViewBase { }
</script>