<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMVOCATIONALGridViewBase from './pimvocationalgrid-view-base.vue';

import view_grid from '@widgets/pim-vocational/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/pim-vocational/default-searchform/default-searchform.vue';

/**
 * 证书信息表格视图
 *
 * @export
 * @class PIMVOCATIONALGridView
 * @extends {PIMVOCATIONALGridViewBase}
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
export default class PIMVOCATIONALGridView extends PIMVOCATIONALGridViewBase { }
</script>