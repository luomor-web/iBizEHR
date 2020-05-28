<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMERPORGLegalPickupGridViewBase from './ormerporglegal-pickup-grid-view-base.vue';

import view_grid from '@widgets/orm-erporg/mag-unit-grid-grid/mag-unit-grid-grid.vue';
import view_searchform from '@widgets/orm-erporg/default-searchform/default-searchform.vue';

/**
 * 管理单位
 *
 * @export
 * @class ORMERPORGLegalPickupGridView
 * @extends {ORMERPORGLegalPickupGridViewBase}
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
export default class ORMERPORGLegalPickupGridView extends ORMERPORGLegalPickupGridViewBase { }
</script>