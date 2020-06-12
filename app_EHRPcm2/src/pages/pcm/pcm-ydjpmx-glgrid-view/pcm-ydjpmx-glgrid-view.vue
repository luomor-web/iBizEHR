<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxGLGridViewBase from './pcm-ydjpmx-glgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydjpmx/jpgl-grid/jpgl-grid.vue';
import view_searchform from '@widgets/pcm-ydjpmx/default-searchform/default-searchform.vue';

/**
 * 解聘管理
 *
 * @export
 * @class PcmYdjpmxGLGridView
 * @extends {PcmYdjpmxGLGridViewBase}
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
export default class PcmYdjpmxGLGridView extends PcmYdjpmxGLGridViewBase { }
</script>