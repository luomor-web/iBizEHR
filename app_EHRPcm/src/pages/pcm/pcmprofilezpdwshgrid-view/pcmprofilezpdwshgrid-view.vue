<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEZPDWSHGridViewBase from './pcmprofilezpdwshgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/zpdwsh-grid/zpdwsh-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-xyzp-searchform/serach-xyzp-searchform.vue';

/**
 * 用人单位初审
 *
 * @export
 * @class PCMPROFILEZPDWSHGridView
 * @extends {PCMPROFILEZPDWSHGridViewBase}
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
export default class PCMPROFILEZPDWSHGridView extends PCMPROFILEZPDWSHGridViewBase { }
</script>