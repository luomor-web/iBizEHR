<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAddressGridViewBase from './trm-train-address-grid-view-base.vue';

import view_grid from '@widgets/trm-train-address/main-grid/main-grid.vue';
import view_searchform from '@widgets/trm-train-address/default-searchform/default-searchform.vue';

/**
 * 培训场地表格视图
 *
 * @export
 * @class TrmTrainAddressGridView
 * @extends {TrmTrainAddressGridViewBase}
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
export default class TrmTrainAddressGridView extends TrmTrainAddressGridViewBase { }
</script>