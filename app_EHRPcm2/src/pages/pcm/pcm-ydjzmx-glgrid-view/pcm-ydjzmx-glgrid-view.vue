<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxGLGridViewBase from './pcm-ydjzmx-glgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydjzmx/glgrid-grid/glgrid-grid.vue';
import view_searchform from '@widgets/pcm-ydjzmx/default-searchform/default-searchform.vue';

/**
 * 兼职管理
 *
 * @export
 * @class PcmYdjzmxGLGridView
 * @extends {PcmYdjzmxGLGridViewBase}
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
export default class PcmYdjzmxGLGridView extends PcmYdjzmxGLGridViewBase { }
</script>