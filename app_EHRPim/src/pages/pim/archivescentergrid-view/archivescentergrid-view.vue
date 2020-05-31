<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVESCENTERGridViewBase from './archivescentergrid-view-base.vue';

import view_grid from '@widgets/pim-archives-center/main-grid/main-grid.vue';
import view_searchform from '@widgets/pim-archives-center/default-searchform/default-searchform.vue';

/**
 * 档案室管理表格视图
 *
 * @export
 * @class ARCHIVESCENTERGridView
 * @extends {ARCHIVESCENTERGridViewBase}
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
export default class ARCHIVESCENTERGridView extends ARCHIVESCENTERGridViewBase { }
</script>