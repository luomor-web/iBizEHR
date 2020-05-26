<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGDZGridViewBase from './ormorgdzgrid-view-base.vue';

import view_grid from '@widgets/ormorgdz/main-grid/main-grid.vue';

/**
 * 组织地址维护表格视图
 *
 * @export
 * @class ORMORGDZGridView
 * @extends {ORMORGDZGridViewBase}
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
export default class ORMORGDZGridView extends ORMORGDZGridViewBase { }
</script>