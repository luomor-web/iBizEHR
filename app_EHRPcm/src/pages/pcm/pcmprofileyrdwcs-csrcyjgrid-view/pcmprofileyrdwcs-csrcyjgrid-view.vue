<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYRDWCS_CSRCYJGridViewBase from './pcmprofileyrdwcs-csrcyjgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/yrdwcs-csrcyj-grid/yrdwcs-csrcyj-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-csrcyj-searchform/serach-csrcyj-searchform.vue';

/**
 * 用人单位初审
 *
 * @export
 * @class PCMPROFILEYRDWCS_CSRCYJGridView
 * @extends {PCMPROFILEYRDWCS_CSRCYJGridViewBase}
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
export default class PCMPROFILEYRDWCS_CSRCYJGridView extends PCMPROFILEYRDWCS_CSRCYJGridViewBase { }
</script>