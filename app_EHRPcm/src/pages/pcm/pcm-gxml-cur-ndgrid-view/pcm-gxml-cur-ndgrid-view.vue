<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmGxmlCurNDGridViewBase from './pcm-gxml-cur-ndgrid-view-base.vue';

import view_grid from '@widgets/pcm-gxml/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-gxml/default-searchform/default-searchform.vue';

/**
 * 高校名录表格视图
 *
 * @export
 * @class PcmGxmlCurNDGridView
 * @extends {PcmGxmlCurNDGridViewBase}
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
export default class PcmGxmlCurNDGridView extends PcmGxmlCurNDGridViewBase { }
</script>