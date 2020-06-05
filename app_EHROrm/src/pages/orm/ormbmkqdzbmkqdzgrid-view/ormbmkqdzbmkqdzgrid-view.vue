<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMBMKQDZBMKQDZGridViewBase from './ormbmkqdzbmkqdzgrid-view-base.vue';

import view_grid from '@widgets/orm-bmkqdz/main-2-grid/main-2-grid.vue';
import view_searchform from '@widgets/orm-bmkqdz/default-searchform/default-searchform.vue';

/**
 * 考勤地址信息
 *
 * @export
 * @class ORMBMKQDZBMKQDZGridView
 * @extends {ORMBMKQDZBMKQDZGridViewBase}
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
export default class ORMBMKQDZBMKQDZGridView extends ORMBMKQDZBMKQDZGridViewBase { }
</script>