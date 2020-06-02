<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxDGGLGridViewBase from './pcm-yddgmx-dgglgrid-view-base.vue';

import view_grid from '@widgets/pcm-yddgmx/dgglgrid-grid/dgglgrid-grid.vue';
import view_searchform from '@widgets/pcm-yddgmx/default-searchform/default-searchform.vue';

/**
 * 待岗管理
 *
 * @export
 * @class PcmYddgmxDGGLGridView
 * @extends {PcmYddgmxDGGLGridViewBase}
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
export default class PcmYddgmxDGGLGridView extends PcmYddgmxDGGLGridViewBase { }
</script>