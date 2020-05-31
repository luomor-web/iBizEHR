<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMAWARDSWONSHJQK_WSSWBJGridViewBase from './pcmawardswonshjqk-wsswbjgrid-view-base.vue';

import view_grid from '@widgets/pcm-awards-wons/main-grid/main-grid.vue';

/**
 * 获奖情况表格视图
 *
 * @export
 * @class PCMAWARDSWONSHJQK_WSSWBJGridView
 * @extends {PCMAWARDSWONSHJQK_WSSWBJGridViewBase}
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
export default class PCMAWARDSWONSHJQK_WSSWBJGridView extends PCMAWARDSWONSHJQK_WSSWBJGridViewBase { }
</script>