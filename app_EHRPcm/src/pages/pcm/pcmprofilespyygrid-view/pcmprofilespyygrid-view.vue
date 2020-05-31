<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILESPYYGridViewBase from './pcmprofilespyygrid-view-base.vue';

import view_grid from '@widgets/pcm-profile-spyy/main-grid/main-grid.vue';

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
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PCMPROFILESPYYGridView extends PCMPROFILESPYYGridViewBase { }
</script>