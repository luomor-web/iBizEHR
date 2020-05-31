<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYPZBDGridViewBase from './pcmprofileypzbdgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/ypzbd-grid/ypzbd-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-nlyry-xyzp-searchform/serach-nlyry-xyzp-searchform.vue';

/**
 * 拟录用人员
 *
 * @export
 * @class PCMPROFILEYPZBDGridView
 * @extends {PCMPROFILEYPZBDGridViewBase}
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
export default class PCMPROFILEYPZBDGridView extends PCMPROFILEYPZBDGridViewBase { }
</script>