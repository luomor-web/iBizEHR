<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONCHANGEGridViewBase from './pimpersonchangegrid-view-base.vue';

import view_grid from '@widgets/pim-person-change/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-person-change/default-searchform/default-searchform.vue';

/**
 * 员工信息审核表格视图
 *
 * @export
 * @class PIMPERSONCHANGEGridView
 * @extends {PIMPERSONCHANGEGridViewBase}
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
export default class PIMPERSONCHANGEGridView extends PIMPERSONCHANGEGridViewBase { }
</script>