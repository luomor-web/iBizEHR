<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONCHANGEHisRecGridViewBase from './pimpersonchangehis-rec-grid-view-base.vue';

import view_grid from '@widgets/pimpersonchange/his-rec-grid/his-rec-grid.vue';
import view_searchform from '@widgets/pimpersonchange/default-searchform/default-searchform.vue';

/**
 * 历史审核记录
 *
 * @export
 * @class PIMPERSONCHANGEHisRecGridView
 * @extends {PIMPERSONCHANGEHisRecGridViewBase}
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
export default class PIMPERSONCHANGEHisRecGridView extends PIMPERSONCHANGEHisRecGridViewBase { }
</script>