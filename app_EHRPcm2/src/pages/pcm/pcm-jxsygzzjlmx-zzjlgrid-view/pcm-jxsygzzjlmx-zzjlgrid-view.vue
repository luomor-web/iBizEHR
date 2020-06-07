<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmJxsygzzjlmxZZJLGridViewBase from './pcm-jxsygzzjlmx-zzjlgrid-view-base.vue';

import view_grid from '@widgets/pcm-jxsygzzjlmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-jxsygzzjlmx/default-searchform/default-searchform.vue';

/**
 * 见习期转正记录
 *
 * @export
 * @class PcmJxsygzzjlmxZZJLGridView
 * @extends {PcmJxsygzzjlmxZZJLGridViewBase}
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
export default class PcmJxsygzzjlmxZZJLGridView extends PcmJxsygzzjlmxZZJLGridViewBase { }
</script>