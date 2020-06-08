<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxBXGLGridViewBase from './pcm-ydbxmx-bxglgrid-view-base.vue';

import view_grid from '@widgets/pcm-ydbxmx/glgrid-grid/glgrid-grid.vue';
import view_searchform from '@widgets/pcm-ydbxmx/default-searchform/default-searchform.vue';

/**
 * 病休管理
 *
 * @export
 * @class PcmYdbxmxBXGLGridView
 * @extends {PcmYdbxmxBXGLGridViewBase}
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
export default class PcmYdbxmxBXGLGridView extends PcmYdbxmxBXGLGridViewBase { }
</script>