<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYPZXX_CSRCYJGridViewBase from './pcmprofileypzxx-csrcyjgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/ypzxx-csrcyj-grid/ypzxx-csrcyj-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-csrcyj-searchform/serach-csrcyj-searchform.vue';

/**
 * 应聘者信息
 *
 * @export
 * @class PCMPROFILEYPZXX_CSRCYJGridView
 * @extends {PCMPROFILEYPZXX_CSRCYJGridViewBase}
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
export default class PCMPROFILEYPZXX_CSRCYJGridView extends PCMPROFILEYPZXX_CSRCYJGridViewBase { }
</script>