<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEBHSP_CSRCYJGridViewBase from './pcmprofilebhsp-csrcyjgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/bhsp-csrcyj-grid/bhsp-csrcyj-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-csrcyj-searchform/serach-csrcyj-searchform.vue';

/**
 * 编号审批
 *
 * @export
 * @class PCMPROFILEBHSP_CSRCYJGridView
 * @extends {PCMPROFILEBHSP_CSRCYJGridViewBase}
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
export default class PCMPROFILEBHSP_CSRCYJGridView extends PCMPROFILEBHSP_CSRCYJGridViewBase { }
</script>