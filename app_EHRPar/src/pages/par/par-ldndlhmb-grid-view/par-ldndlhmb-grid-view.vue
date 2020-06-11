<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbGridViewBase from './par-ldndlhmb-grid-view-base.vue';

import view_grid from '@widgets/par-ldndlhmb/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-ldndlhmb/default-searchform/default-searchform.vue';

/**
 * 年度量化目标（助理总经理级领导 ）表格视图
 *
 * @export
 * @class ParLdndlhmbGridView
 * @extends {ParLdndlhmbGridViewBase}
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
export default class ParLdndlhmbGridView extends ParLdndlhmbGridViewBase { }
</script>