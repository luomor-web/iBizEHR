<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdtxmxJLGridViewBase from './pcm-ydtxmx-jlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydtxmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydtxmx/default-searchform/default-searchform.vue';

/**
 * 退休记录
 *
 * @export
 * @class PcmYdtxmxJLGridView
 * @extends {PcmYdtxmxJLGridViewBase}
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
export default class PcmYdtxmxJLGridView extends PcmYdtxmxJLGridViewBase { }
</script>