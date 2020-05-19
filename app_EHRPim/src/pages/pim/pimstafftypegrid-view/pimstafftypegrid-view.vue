<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMSTAFFTYPEGridViewBase from './pimstafftypegrid-view-base.vue';

import view_grid from '@widgets/pimstafftype/main-grid/main-grid.vue';
import view_searchform from '@widgets/pimstafftype/default-searchform/default-searchform.vue';

/**
 * 员工类型表格视图
 *
 * @export
 * @class PIMSTAFFTYPEGridView
 * @extends {PIMSTAFFTYPEGridViewBase}
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
export default class PIMSTAFFTYPEGridView extends PIMSTAFFTYPEGridViewBase { }
</script>