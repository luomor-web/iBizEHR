<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxJLGridViewBase from './pcm-ydbxmx-jlgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydbxmx/main-grid/main-grid.vue';
import view_searchform from '@widgets/pcm-ydbxmx/default-searchform/default-searchform.vue';

/**
 * 病休记录
 *
 * @export
 * @class PcmYdbxmxJLGridView
 * @extends {PcmYdbxmxJLGridViewBase}
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
export default class PcmYdbxmxJLGridView extends PcmYdbxmxJLGridViewBase { }
</script>