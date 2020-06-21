<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmStayGridViewBase from './trm-stay-grid-view-base.vue';

import view_grid from '@widgets/trm-stay/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-stay/default-searchform/default-searchform.vue';

/**
 * 培训住宿
 *
 * @export
 * @class TrmStayGridView
 * @extends {TrmStayGridViewBase}
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
export default class TrmStayGridView extends TrmStayGridViewBase { }
</script>