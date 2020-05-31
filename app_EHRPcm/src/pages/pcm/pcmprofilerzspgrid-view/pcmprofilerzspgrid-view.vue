<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERZSPGridViewBase from './pcmprofilerzspgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/rzsp-grid/rzsp-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-xyzp-searchform/serach-xyzp-searchform.vue';

/**
 * 局总部初审
 *
 * @export
 * @class PCMPROFILERZSPGridView
 * @extends {PCMPROFILERZSPGridViewBase}
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
export default class PCMPROFILERZSPGridView extends PCMPROFILERZSPGridViewBase { }
</script>