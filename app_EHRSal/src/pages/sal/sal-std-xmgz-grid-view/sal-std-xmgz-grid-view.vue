<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdXmgzGridViewBase from './sal-std-xmgz-grid-view-base.vue';

import view_grid from '@widgets/sal-std-xmgz/main-grid/main-grid.vue';
import view_searchform from '@widgets/sal-std-xmgz/default-searchform/default-searchform.vue';

/**
 * 项目工资标准表格视图
 *
 * @export
 * @class SalStdXmgzGridView
 * @extends {SalStdXmgzGridViewBase}
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
export default class SalStdXmgzGridView extends SalStdXmgzGridViewBase { }
</script>