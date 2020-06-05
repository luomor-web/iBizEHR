<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxLSJLGridViewBase from './pcm-ydlzmx-lsjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydlzmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydlzmx/default-searchform/default-searchform.vue';

/**
 * 离职记录
 *
 * @export
 * @class PcmYdlzmxLSJLGridView
 * @extends {PcmYdlzmxLSJLGridViewBase}
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
export default class PcmYdlzmxLSJLGridView extends PcmYdlzmxLSJLGridViewBase { }
</script>