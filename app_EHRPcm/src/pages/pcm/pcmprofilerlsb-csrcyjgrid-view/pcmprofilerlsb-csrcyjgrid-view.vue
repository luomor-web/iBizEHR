<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILERLSB_CSRCYJGridViewBase from './pcmprofilerlsb-csrcyjgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/rlsb-csrcyj-grid/rlsb-csrcyj-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-rlsb-csrcyj-searchform/serach-rlsb-csrcyj-searchform.vue';

/**
 * 人力上报
 *
 * @export
 * @class PCMPROFILERLSB_CSRCYJGridView
 * @extends {PCMPROFILERLSB_CSRCYJGridViewBase}
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
export default class PCMPROFILERLSB_CSRCYJGridView extends PCMPROFILERLSB_CSRCYJGridViewBase { }
</script>