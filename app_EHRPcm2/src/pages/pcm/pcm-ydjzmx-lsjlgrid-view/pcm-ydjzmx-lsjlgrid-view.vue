<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxLSJLGridViewBase from './pcm-ydjzmx-lsjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydjzmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydjzmx/default-searchform/default-searchform.vue';

/**
 * 兼职记录
 *
 * @export
 * @class PcmYdjzmxLSJLGridView
 * @extends {PcmYdjzmxLSJLGridViewBase}
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
export default class PcmYdjzmxLSJLGridView extends PcmYdjzmxLSJLGridViewBase { }
</script>