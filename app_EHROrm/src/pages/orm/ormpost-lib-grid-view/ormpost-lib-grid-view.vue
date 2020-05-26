<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPostLibGridViewBase from './ormpost-lib-grid-view-base.vue';

import view_grid from '@widgets/ormpost-lib/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormpost-lib/default-searchform/default-searchform.vue';

/**
 * 标准岗位设置
 *
 * @export
 * @class ORMPostLibGridView
 * @extends {ORMPostLibGridViewBase}
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
export default class ORMPostLibGridView extends ORMPostLibGridViewBase { }
</script>