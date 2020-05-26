<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMBMXGridViewBase from './ormxmbmxgrid-view-base.vue';

import view_grid from '@widgets/ormxmbmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormxmbmx/default-searchform/default-searchform.vue';

/**
 * 项目部人员明细
 *
 * @export
 * @class ORMXMBMXGridView
 * @extends {ORMXMBMXGridViewBase}
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
export default class ORMXMBMXGridView extends ORMXMBMXGridViewBase { }
</script>