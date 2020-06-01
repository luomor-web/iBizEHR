<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaceTypeGridViewBase from './vac-leace-type-grid-view-base.vue';

import view_grid from '@widgets/vac-leace-type/main-grid/main-grid.vue';
import view_searchform from '@widgets/vac-leace-type/default-searchform/default-searchform.vue';

/**
 * 休假类型管理表格视图
 *
 * @export
 * @class VacLeaceTypeGridView
 * @extends {VacLeaceTypeGridViewBase}
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
export default class VacLeaceTypeGridView extends VacLeaceTypeGridViewBase { }
</script>