<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocAreaRowEditGridViewBase from './soc-area-row-edit-grid-view-base.vue';

import view_grid from '@widgets/soc-area/main-grid/main-grid.vue';
import view_searchform from '@widgets/soc-area/default-searchform/default-searchform.vue';

/**
 * 参保地表格视图
 *
 * @export
 * @class SocAreaRowEditGridView
 * @extends {SocAreaRowEditGridViewBase}
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
export default class SocAreaRowEditGridView extends SocAreaRowEditGridViewBase { }
</script>