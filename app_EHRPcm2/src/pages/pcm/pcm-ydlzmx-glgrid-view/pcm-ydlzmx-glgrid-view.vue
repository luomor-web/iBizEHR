<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxGLGridViewBase from './pcm-ydlzmx-glgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydlzmx/glgrid-grid/glgrid-grid.vue';
import view_searchform from '@widgets/pcm-ydlzmx/glsearch-form-searchform/glsearch-form-searchform.vue';

/**
 * 离职管理
 *
 * @export
 * @class PcmYdlzmxGLGridView
 * @extends {PcmYdlzmxGLGridViewBase}
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
export default class PcmYdlzmxGLGridView extends PcmYdlzmxGLGridViewBase { }
</script>