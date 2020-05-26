<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILESZYJTJPickupGridViewBase from './pcmprofileszyjtjpickup-grid-view-base.vue';

import view_grid from '@widgets/pcmprofileszyjtj/ypzsy-grid/ypzsy-grid.vue';
import view_searchform from '@widgets/pcmprofileszyjtj/default-searchform/default-searchform.vue';

/**
 * 应聘者社招引进条件选择表格视图
 *
 * @export
 * @class PCMPROFILESZYJTJPickupGridView
 * @extends {PCMPROFILESZYJTJPickupGridViewBase}
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
export default class PCMPROFILESZYJTJPickupGridView extends PCMPROFILESZYJTJPickupGridViewBase { }
</script>