<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMSCHOOLOFFICEZXZW_WSSWBJGridViewBase from './pcmschoolofficezxzw-wsswbjgrid-view-base.vue';

import view_grid from '@widgets/pcm-school-office/main-grid/main-grid.vue';

/**
 * 在校职务
 *
 * @export
 * @class PCMSCHOOLOFFICEZXZW_WSSWBJGridView
 * @extends {PCMSCHOOLOFFICEZXZW_WSSWBJGridViewBase}
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
export default class PCMSCHOOLOFFICEZXZW_WSSWBJGridView extends PCMSCHOOLOFFICEZXZW_WSSWBJGridViewBase { }
</script>