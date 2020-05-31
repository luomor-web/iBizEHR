<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase from './pcmpracticeexperiencesxjy-wsswbjgrid-view-base.vue';

import view_grid from '@widgets/pcm-practice-experience/main-grid/main-grid.vue';

/**
 * 实习信息
 *
 * @export
 * @class PCMPRACTICEEXPERIENCESXJY_WSSWBJGridView
 * @extends {PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase}
 */
@Component({
    components: {
        view_grid, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PCMPRACTICEEXPERIENCESXJY_WSSWBJGridView extends PCMPRACTICEEXPERIENCESXJY_WSSWBJGridViewBase { }
</script>