<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocTypeGridViewBase from './soc-type-grid-view-base.vue';

import view_grid from '@widgets/soc-type/main-grid/main-grid.vue';

/**
 * 保险类型表格视图
 *
 * @export
 * @class SocTypeGridView
 * @extends {SocTypeGridViewBase}
 */
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class SocTypeGridView extends SocTypeGridViewBase { }
</script>