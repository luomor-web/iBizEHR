<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDUTYGridViewBase from './ormdutygrid-view-base.vue';

import view_grid from '@widgets/orm-duty/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-duty/default-searchform/default-searchform.vue';

/**
 * 职务设置
 *
 * @export
 * @class ORMDUTYGridView
 * @extends {ORMDUTYGridViewBase}
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
export default class ORMDUTYGridView extends ORMDUTYGridViewBase { }
</script>