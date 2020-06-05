<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxGZCLSJLGridViewBase from './pcm-ydgzmx-gzclsjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydgzmx/gzcjlgrid-grid/gzcjlgrid-grid.vue';
import view_searchform from '@widgets/pcm-ydgzmx/gzcjlsearch-form-searchform/gzcjlsearch-form-searchform.vue';

/**
 * 挂职出记录
 *
 * @export
 * @class PcmYdgzmxGZCLSJLGridView
 * @extends {PcmYdgzmxGZCLSJLGridViewBase}
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
export default class PcmYdgzmxGZCLSJLGridView extends PcmYdgzmxGZCLSJLGridViewBase { }
</script>