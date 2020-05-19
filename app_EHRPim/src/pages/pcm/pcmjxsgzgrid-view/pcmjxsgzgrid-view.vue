<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMJXSGZGridViewBase from './pcmjxsgzgrid-view-base.vue';

import view_grid from '@widgets/pcmjxsgz/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcmjxsgz/default-searchform/default-searchform.vue';

/**
 * 见习期表格视图
 *
 * @export
 * @class PCMJXSGZGridView
 * @extends {PCMJXSGZGridViewBase}
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
export default class PCMJXSGZGridView extends PCMJXSGZGridViewBase { }
</script>