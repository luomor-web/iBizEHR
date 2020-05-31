<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMWORKRESUMEGZLL_WSSWBJGridViewBase from './pcmworkresumegzll-wsswbjgrid-view-base.vue';

import view_grid from '@widgets/pcm-work-resume/main-grid/main-grid.vue';

/**
 * 工作履历表格视图
 *
 * @export
 * @class PCMWORKRESUMEGZLL_WSSWBJGridView
 * @extends {PCMWORKRESUMEGZLL_WSSWBJGridViewBase}
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
export default class PCMWORKRESUMEGZLL_WSSWBJGridView extends PCMWORKRESUMEGZLL_WSSWBJGridViewBase { }
</script>