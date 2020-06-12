<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdgwgzGridViewBase from './sal-stdgwgz-grid-view-base.vue';

import view_grid from '@widgets/sal-stdgwgz/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-stdgwgz/default-searchform/default-searchform.vue';

/**
 * 岗位工资标准表格视图
 *
 * @export
 * @class SalStdgwgzGridView
 * @extends {SalStdgwgzGridViewBase}
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
export default class SalStdgwgzGridView extends SalStdgwgzGridViewBase { }
</script>