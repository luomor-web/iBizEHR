<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEYPZXX_LRGridViewBase from './pcmprofileypzxx-lrgrid-view-base.vue';

import view_grid from '@widgets/pcm-profile/ypzxx-lr-grid/ypzxx-lr-grid.vue';
import view_searchform from '@widgets/pcm-profile/serach-xyzp-searchform/serach-xyzp-searchform.vue';

/**
 * 应聘者信息
 *
 * @export
 * @class PCMPROFILEYPZXX_LRGridView
 * @extends {PCMPROFILEYPZXX_LRGridViewBase}
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
export default class PCMPROFILEYPZXX_LRGridView extends PCMPROFILEYPZXX_LRGridViewBase { }
</script>