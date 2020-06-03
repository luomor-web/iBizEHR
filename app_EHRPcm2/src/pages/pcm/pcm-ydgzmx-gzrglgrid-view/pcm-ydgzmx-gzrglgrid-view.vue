<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxGZRGLGridViewBase from './pcm-ydgzmx-gzrglgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydgzmx/gzrglgrid-grid/gzrglgrid-grid.vue';
import view_searchform from '@widgets/pcm-ydgzmx/gzjglsearch-form-searchform/gzjglsearch-form-searchform.vue';

/**
 * 挂职调入
 *
 * @export
 * @class PcmYdgzmxGZRGLGridView
 * @extends {PcmYdgzmxGZRGLGridViewBase}
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
export default class PcmYdgzmxGZRGLGridView extends PcmYdgzmxGZRGLGridViewBase { }
</script>