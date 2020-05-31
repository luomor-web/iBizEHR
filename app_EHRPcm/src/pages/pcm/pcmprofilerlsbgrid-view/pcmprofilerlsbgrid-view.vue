<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERLSBGridViewBase from './pcmprofilerlsbgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/rlsb-grid/rlsb-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-rlsb-xyzp-searchform/serach-rlsb-xyzp-searchform.vue';

/**
 * 人力上报
 *
 * @export
 * @class PCMPROFILERLSBGridView
 * @extends {PCMPROFILERLSBGridViewBase}
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
export default class PCMPROFILERLSBGridView extends PCMPROFILERLSBGridViewBase { }
</script>