<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPATENTPATENTGridViewBase from './pimpatentpatentgrid-view-base.vue';

import view_grid from '@widgets/pim-patent/main-grid/main-grid.vue';

/**
 * 专利信息表格视图
 *
 * @export
 * @class PIMPATENTPATENTGridView
 * @extends {PIMPATENTPATENTGridViewBase}
 */
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMPATENTPATENTGridView extends PIMPATENTPATENTGridViewBase { }
</script>