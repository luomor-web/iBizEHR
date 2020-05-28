<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMWORKHISTORYGBLLGridViewBase from './pimworkhistorygbllgrid-view-base.vue';

import view_grid from '@widgets/pimworkhistory/gbll-grid/gbll-grid.vue';
import view_searchform from '@widgets/pimworkhistory/default-searchform/default-searchform.vue';

/**
 * 工作履历
 *
 * @export
 * @class PIMWORKHISTORYGBLLGridView
 * @extends {PIMWORKHISTORYGBLLGridViewBase}
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
export default class PIMWORKHISTORYGBLLGridView extends PIMWORKHISTORYGBLLGridViewBase { }
</script>