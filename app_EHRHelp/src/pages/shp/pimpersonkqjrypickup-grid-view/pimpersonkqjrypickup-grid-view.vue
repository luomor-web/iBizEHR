<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONKQJRYPickupGridViewBase from './pimpersonkqjrypickup-grid-view-base.vue';

import view_grid from '@widgets/pimperson/ryinfo-grid-grid/ryinfo-grid-grid.vue';
import view_searchform from '@widgets/pimperson/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 请假人员
 *
 * @export
 * @class PIMPERSONKQJRYPickupGridView
 * @extends {PIMPERSONKQJRYPickupGridViewBase}
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
export default class PIMPERSONKQJRYPickupGridView extends PIMPERSONKQJRYPickupGridViewBase { }
</script>