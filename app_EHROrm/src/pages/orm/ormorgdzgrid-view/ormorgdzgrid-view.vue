<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGDZGridViewBase from './ormorgdzgrid-view-base.vue';

import view_grid from '@widgets/orm-orgdz/main-grid/main-grid.vue';

/**
 * 地址信息
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