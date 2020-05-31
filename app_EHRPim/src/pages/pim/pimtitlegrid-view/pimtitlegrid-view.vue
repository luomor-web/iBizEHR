<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLEGridViewBase from './pimtitlegrid-view-base.vue';

import view_grid from '@widgets/pim-title/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pim-title/default-searchform/default-searchform.vue';

/**
 * 职称信息表格视图
 *
 * @export
 * @class PIMTITLEGridView
 * @extends {PIMTITLEGridViewBase}
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
export default class PIMTITLEGridView extends PIMTITLEGridViewBase { }
</script>