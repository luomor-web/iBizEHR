<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocAreaGridViewBase from './soc-area-grid-view-base.vue';

import view_grid from '@widgets/soc-area/main-grid/main-grid.vue';
import view_searchform from '@widgets/soc-area/default-searchform/default-searchform.vue';

/**
 * 参保地表格视图
 *
 * @export
 * @class SocAreaGridView
 * @extends {SocAreaGridViewBase}
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
export default class SocAreaGridView extends SocAreaGridViewBase { }
</script>