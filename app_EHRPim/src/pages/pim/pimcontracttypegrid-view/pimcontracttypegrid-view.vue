<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTTYPEGridViewBase from './pimcontracttypegrid-view-base.vue';

import view_grid from '@widgets/pimcontracttype/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimcontracttype/default-searchform/default-searchform.vue';

/**
 * 合同类别表格视图
 *
 * @export
 * @class PIMCONTRACTTYPEGridView
 * @extends {PIMCONTRACTTYPEGridViewBase}
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
export default class PIMCONTRACTTYPEGridView extends PIMCONTRACTTYPEGridViewBase { }
</script>