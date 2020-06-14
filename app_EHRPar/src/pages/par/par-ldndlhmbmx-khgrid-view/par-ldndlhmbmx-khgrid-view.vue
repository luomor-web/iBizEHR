<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbmxKHGridViewBase from './par-ldndlhmbmx-khgrid-view-base.vue';

import view_grid from '@widgets/par-ldndlhmbmx/ndlhmbkhmx-jzszps-grid/ndlhmbkhmx-jzszps-grid.vue';
import view_searchform from '@widgets/par-ldndlhmbmx/default-searchform/default-searchform.vue';

/**
 * 量化目标明细考核
 *
 * @export
 * @class ParLdndlhmbmxKHGridView
 * @extends {ParLdndlhmbmxKHGridViewBase}
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
export default class ParLdndlhmbmxKHGridView extends ParLdndlhmbmxKHGridViewBase { }
</script>