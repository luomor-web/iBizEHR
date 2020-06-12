<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMGXXKTEMPGridViewBase from './pcmgxxktempgrid-view-base.vue';

import view_grid from '@widgets/pcmgxxk-temp/main-grid/main-grid.vue';

/**
 * 高校学科
 *
 * @export
 * @class PCMGXXKTEMPGridView
 * @extends {PCMGXXKTEMPGridViewBase}
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
export default class PCMGXXKTEMPGridView extends PCMGXXKTEMPGridViewBase { }
</script>