<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxDGJLGridViewBase from './pcm-yddgmx-dgjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-yddgmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-yddgmx/default-searchform/default-searchform.vue';

/**
 * 待岗记录
 *
 * @export
 * @class PcmYddgmxDGJLGridView
 * @extends {PcmYddgmxDGJLGridViewBase}
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
export default class PcmYddgmxDGJLGridView extends PcmYddgmxDGJLGridViewBase { }
</script>