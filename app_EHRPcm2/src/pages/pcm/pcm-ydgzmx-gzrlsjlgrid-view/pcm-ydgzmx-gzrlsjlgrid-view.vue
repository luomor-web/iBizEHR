<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxGZRLSJLGridViewBase from './pcm-ydgzmx-gzrlsjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydgzmx/gzrgrid-grid/gzrgrid-grid.vue';
import view_searchform from '@widgets/pcm-ydgzmx/gzjjlsearch-form-searchform/gzjjlsearch-form-searchform.vue';

/**
 * 挂职进记录
 *
 * @export
 * @class PcmYdgzmxGZRLSJLGridView
 * @extends {PcmYdgzmxGZRLSJLGridViewBase}
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
export default class PcmYdgzmxGZRLSJLGridView extends PcmYdgzmxGZRLSJLGridViewBase { }
</script>