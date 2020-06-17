<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrafficGridViewBase from './trm-traffic-grid-view-base.vue';

import view_grid from '@widgets/trm-traffic/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-traffic/default-searchform/default-searchform.vue';

/**
 * 交通信息
 *
 * @export
 * @class TrmTrafficGridView
 * @extends {TrmTrafficGridViewBase}
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
export default class TrmTrafficGridView extends TrmTrafficGridViewBase { }
</script>