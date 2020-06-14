<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbKHGridViewBase from './par-ldndlhmb-khgrid-view-base.vue';

import view_grid from '@widgets/par-ldndlhmb/ndlhmbkh-grid/ndlhmbkh-grid.vue';
import view_searchform from '@widgets/par-ldndlhmb/default-searchform/default-searchform.vue';

/**
 * 年度量化目标考核（公司领导类）
 *
 * @export
 * @class ParLdndlhmbKHGridView
 * @extends {ParLdndlhmbKHGridViewBase}
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
export default class ParLdndlhmbKHGridView extends ParLdndlhmbKHGridViewBase { }
</script>