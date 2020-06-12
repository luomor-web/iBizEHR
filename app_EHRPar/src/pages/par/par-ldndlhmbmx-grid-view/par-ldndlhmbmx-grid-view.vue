<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbmxGridViewBase from './par-ldndlhmbmx-grid-view-base.vue';

import view_grid from '@widgets/par-ldndlhmbmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/par-ldndlhmbmx/default-searchform/default-searchform.vue';

/**
 * 量化目标明细（公司领导类 ）
 *
 * @export
 * @class ParLdndlhmbmxGridView
 * @extends {ParLdndlhmbmxGridViewBase}
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
export default class ParLdndlhmbmxGridView extends ParLdndlhmbmxGridViewBase { }
</script>