<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYPZBD_CSRCYJGridViewBase from './pcmprofileypzbd-csrcyjgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/ypzbd-csrcyj-grid/ypzbd-csrcyj-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-nlyry-csrcyj-searchform/serach-nlyry-csrcyj-searchform.vue';

/**
 * 拟录用人员
 *
 * @export
 * @class PCMPROFILEYPZBD_CSRCYJGridView
 * @extends {PCMPROFILEYPZBD_CSRCYJGridViewBase}
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
export default class PCMPROFILEYPZBD_CSRCYJGridView extends PCMPROFILEYPZBD_CSRCYJGridViewBase { }
</script>