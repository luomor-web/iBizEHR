<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmDemdeftionPickupGridViewBase from './trm-demdeftion-pickup-grid-view-base.vue';

import view_grid from '@widgets/trm-demdeftion/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-demdeftion/default-searchform/default-searchform.vue';

/**
 * 培训需求
 *
 * @export
 * @class TrmDemdeftionPickupGridView
 * @extends {TrmDemdeftionPickupGridViewBase}
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
export default class TrmDemdeftionPickupGridView extends TrmDemdeftionPickupGridViewBase { }
</script>