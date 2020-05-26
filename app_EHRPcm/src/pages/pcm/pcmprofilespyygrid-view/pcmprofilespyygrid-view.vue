<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILESPYYGridViewBase from './pcmprofilespyygrid-view-base.vue';

import view_grid from '@widgets/pcmprofilespyy/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcmprofilespyy/default-searchform/default-searchform.vue';

/**
 * 应聘者审批原因表格视图
 *
 * @export
 * @class PCMPROFILESPYYGridView
 * @extends {PCMPROFILESPYYGridViewBase}
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
export default class PCMPROFILESPYYGridView extends PCMPROFILESPYYGridViewBase { }
</script>