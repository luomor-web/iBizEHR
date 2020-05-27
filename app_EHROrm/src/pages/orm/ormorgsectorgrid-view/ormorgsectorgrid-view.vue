<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORGridViewBase from './ormorgsectorgrid-view-base.vue';

import view_grid from '@widgets/ormorgsector/main-grid/main-grid.vue';
import view_searchform from '@widgets/ormorgsector/default-searchform/default-searchform.vue';

/**
 * 部门/项目部信息
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