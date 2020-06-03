<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORGridViewBase from './ormorgsectorgrid-view-base.vue';

import view_grid from '@widgets/orm-orgsector/main-grid/main-grid.vue';
import view_searchform from '@widgets/orm-orgsector/default-searchform/default-searchform.vue';

/**
 * 部门/项目部管理
 *
 * @export
 * @class ORMORGSECTORGridView
 * @extends {ORMORGSECTORGridViewBase}
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
export default class ORMORGSECTORGridView extends ORMORGSECTORGridViewBase { }
</script>