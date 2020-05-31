<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEBHSPGridViewBase from './pcmprofilebhspgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/bhsp-grid/bhsp-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-xyzp-searchform/serach-xyzp-searchform.vue';

/**
 * 编号审批
 *
 * @export
 * @class PCMPROFILEBHSPGridView
 * @extends {PCMPROFILEBHSPGridViewBase}
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
export default class PCMPROFILEBHSPGridView extends PCMPROFILEBHSPGridViewBase { }
</script>