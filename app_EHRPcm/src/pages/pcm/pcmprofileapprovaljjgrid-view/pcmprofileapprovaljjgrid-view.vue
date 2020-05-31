<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEAPPROVALJJGridViewBase from './pcmprofileapprovaljjgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile-approval/ck-grid/ck-grid.vue';

/**
 * 应聘者审批表
 *
 * @export
 * @class PCMPROFILEAPPROVALJJGridView
 * @extends {PCMPROFILEAPPROVALJJGridViewBase}
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
export default class PCMPROFILEAPPROVALJJGridView extends PCMPROFILEAPPROVALJJGridViewBase { }
</script>