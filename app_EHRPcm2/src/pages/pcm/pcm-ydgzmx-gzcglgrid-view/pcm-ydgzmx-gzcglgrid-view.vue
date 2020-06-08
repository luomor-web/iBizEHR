<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxGZCGLGridViewBase from './pcm-ydgzmx-gzcglgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydgzmx/gzcgl-grid/gzcgl-grid.vue';
import view_searchform from '@widgets/pcm-ydgzmx/gzcglsearch-form-searchform/gzcglsearch-form-searchform.vue';

/**
 * 挂职调出
 *
 * @export
 * @class PcmYdgzmxGZCGLGridView
 * @extends {PcmYdgzmxGZCGLGridViewBase}
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
export default class PcmYdgzmxGZCGLGridView extends PcmYdgzmxGZCGLGridViewBase { }
</script>