<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMQUALTYPEGridViewBase from './pimqualtypegrid-view-base.vue';

import view_grid from '@widgets/pim-qual-type/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-qual-type/default-searchform/default-searchform.vue';

/**
 * 岗位（技能）证书别表格视图
 *
 * @export
 * @class PIMQUALTYPEGridView
 * @extends {PIMQUALTYPEGridViewBase}
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
export default class PIMQUALTYPEGridView extends PIMQUALTYPEGridViewBase { }
</script>