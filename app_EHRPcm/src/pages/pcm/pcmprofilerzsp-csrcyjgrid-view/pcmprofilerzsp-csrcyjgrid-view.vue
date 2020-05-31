<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERZSP_CSRCYJGridViewBase from './pcmprofilerzsp-csrcyjgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/rzsp-csrcyj-grid/rzsp-csrcyj-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-csrcyj-searchform/serach-csrcyj-searchform.vue';

/**
 * 局总部初审
 *
 * @export
 * @class PCMPROFILERZSP_CSRCYJGridView
 * @extends {PCMPROFILERZSP_CSRCYJGridViewBase}
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
export default class PCMPROFILERZSP_CSRCYJGridView extends PCMPROFILERZSP_CSRCYJGridViewBase { }
</script>